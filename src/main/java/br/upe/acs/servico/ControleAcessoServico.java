package br.upe.acs.servico;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.upe.acs.config.JwtService;
import br.upe.acs.controlador.respostas.AutenticacaoResposta;
import br.upe.acs.dominio.Curso;
import br.upe.acs.dominio.Endereco;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.dto.EmailDTO;
import br.upe.acs.dominio.dto.EnderecoDTO;
import br.upe.acs.dominio.dto.LoginDTO;
import br.upe.acs.dominio.dto.RegistroDTO;
import br.upe.acs.dominio.enums.PerfilEnum;
import br.upe.acs.repositorio.UsuarioRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ControleAcessoServico {

    private final UsuarioRepositorio repositorio;
    private final JwtService jwtService;
    private final EnderecoServico enderecoServico;
    private final CursoServico cursoServico;
    private final EmailServico emailServico;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AutenticacaoResposta cadastrarUsuario(RegistroDTO registro) throws AcsExcecao {
        verificarDadosUnicos(registro.getEmail(), registro.getCpf());
		validarSenha(registro.getSenha());
		validarEmailInstitucional(registro.getEmail());

		Usuario usuarioSalvar = new Usuario();
		Endereco enderecoSalvo = adicionarEnderecoUsuario(registro);
		String codigoVerificacao = gerarCodigoVerificacao();
		Curso cursoSalvar = cursoServico.buscarCursoPorId(registro.getCursoId()).orElseThrow();

		usuarioSalvar.setNomeCompleto(registro.getNomeCompleto());
		usuarioSalvar.setCpf(registro.getCpf());
		usuarioSalvar.setPeriodo(registro.getPeriodo());
		usuarioSalvar.setTelefone(registro.getTelefone());
		usuarioSalvar.setEmail(registro.getEmail());
		usuarioSalvar.setSenha(passwordEncoder.encode(registro.getSenha()));
		usuarioSalvar.setPerfil(PerfilEnum.USUARIO);
		usuarioSalvar.setCodigoVerificacao(codigoVerificacao);
		usuarioSalvar.setVerificado(false);
		usuarioSalvar.setEndereco(enderecoSalvo);
        usuarioSalvar.setCurso(cursoSalvar);

        repositorio.save(usuarioSalvar);

        CompletableFuture.runAsync(() -> enviarEmail(registro, codigoVerificacao));

        return gerarAutenticacaoResposta(usuarioSalvar);
    }

    public AutenticacaoResposta loginUsuario(LoginDTO login) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getSenha()));
        Usuario usuario = repositorio.findByEmail(login.getEmail()).orElseThrow();

        return gerarAutenticacaoResposta(usuario);
    }

	private void verificarDadosUnicos(String email, String cpf) throws AcsExcecao {
		String mensagem = "";

		if (repositorio.findByCpf(cpf).isPresent()) {
			mensagem += "cpf";
		}

		if (repositorio.findByEmail(email).isPresent()) {
			mensagem += "/email";
		}

		if (!mensagem.isBlank()) {
			throw new AcsExcecao("Os dados a seguir " + mensagem + " já estão cadastrados!");
		}
	}

	private void validarSenha(String senha) throws AcsExcecao {
		boolean comMaiuscula = false, comMinuscula = false, comNumerico = false, comEspecial = false;

		if (senha.length() < 8) {
			throw new AcsExcecao("A senha informada deve ter 8 ou mais caracteres!");
		}

		for (char caracteres : senha.toCharArray()) {
			if (Character.isDigit(caracteres)) {
				comNumerico = true;
			} else if (Character.isUpperCase(caracteres)) {
				comMaiuscula = true;
			} else if (Character.isLowerCase(caracteres)) {
				comMinuscula = true;
			} else {
				comEspecial = true;
			}
		}

		if (!(comMaiuscula && comMinuscula && comNumerico && comEspecial)) {
			StringBuilder error = new StringBuilder("Senha inválida: A senha necessita de caracteres");

			if (!comMaiuscula) {
				error.append(" maiúsculos;");
			}
			if (!comMinuscula) {
				error.append(" minúsculos;");
			}
			if (!comNumerico) {
				error.append(" numéricos;");
			}
			if (!comEspecial) {
				error.append(" especiais;");
			}

			throw new AcsExcecao(error.toString());
		}
	}

	private void validarEmailInstitucional(String email) throws AcsExcecao {
		if (!email.split("@")[1].equals("upe.br")) {
			throw new AcsExcecao("Email inválido! Por favor insira o email institucional.");
		}
	}

	private Endereco adicionarEnderecoUsuario(RegistroDTO registro) {
		EnderecoDTO enderecoSalvar = new EnderecoDTO();
		enderecoSalvar.setCep(registro.getCep());
		enderecoSalvar.setCidade(registro.getCidade());
		enderecoSalvar.setBairro(registro.getBairro());
		enderecoSalvar.setRua(registro.getRua());
		enderecoSalvar.setNumero(registro.getNumero());
		enderecoSalvar.setUF(registro.getUF());

		return enderecoServico.adicionarEndereco(enderecoSalvar);
	}

	private static String gerarCodigoVerificacao() {
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder codigo = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			int indice = random.nextInt(caracteres.length());
			char caractere = caracteres.charAt(indice);
			codigo.append(caractere);
		}

		return codigo.toString();
	}

	private void enviarEmail(RegistroDTO registro, String codigoVerificacao) {
        EmailDTO email = new EmailDTO();

        email.setAssunto("Código de verificação - Sistema ACs UPE");
        email.setDestinatario(registro.getEmail());
        email.setMensagem(
                "Confirme seu email, envie esse código na página de verificação do sistema: " + codigoVerificacao);
        emailServico.enviarEmail(email);
    }

	private AutenticacaoResposta gerarAutenticacaoResposta(Usuario usuario) {
		String jwtToken = jwtService.generateToken(usuario);
		AutenticacaoResposta autenticacaoResposta = new AutenticacaoResposta();
		autenticacaoResposta.setToken(jwtToken);

		return autenticacaoResposta;
	}
}
