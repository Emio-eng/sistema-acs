package br.upe.acs.controlador.respostas;

import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.dominio.Endereco;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.enums.PerfilEnum;
import lombok.Getter;

@Getter
public class UsuarioResposta {

	private final Long id;

	private final String nomeCompleto;

	private final String cpf;

	private final int periodo;

	private final String telefone;

	private final String email;

	private final String senha;

	private final String codigoVerificacao;

	private final boolean verificado;

	private final PerfilEnum perfil;

	private final Endereco endereco;

	private final CursoResposta curso;

	private final List<RequisicaoResposta> requisicoes;

	public UsuarioResposta(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nomeCompleto = usuario.getNomeCompleto();
		this.cpf = usuario.getCpf();
		this.periodo = usuario.getPeriodo();
		this.telefone = usuario.getTelefone();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.codigoVerificacao = usuario.getCodigoVerificacao();
		this.verificado = usuario.isVerificado();
		this.perfil = usuario.getPerfil();
		this.endereco = null; // TODO
		this.curso = new CursoResposta(usuario.getCurso());
		this.requisicoes = converterRequisicoes(usuario.getRequisicoes());
	}

	private List<RequisicaoResposta> converterRequisicoes(List<Requisicao> requisicoes) {
		return requisicoes.stream().map(RequisicaoResposta::new)
				.collect(Collectors.toList());
	}
}
