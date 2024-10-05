package br.upe.acs.controlador.respostas;

import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.dominio.Endereco;
import br.upe.acs.dominio.Usuario;
import lombok.Getter;

@Getter
public class EnderecoResposta {

	private final Long id;
	
	private final String cep;
	
	private final String rua;
	
	private final String bairro;
	
	private final String cidade;
	
	private final String UF;
	
	private final int numero;
	
	private final List<UsuarioResposta> usuarios;

	public EnderecoResposta(Endereco endereco) {
		super();
		this.id = endereco.getId();
		this.cep = endereco.getCep();
		this.rua = endereco.getRua();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		UF = endereco.getUF();
		this.numero = endereco.getNumero();
		this.usuarios = converterUsuario(endereco.getUsuarios());
	}
	
	private List<UsuarioResposta> converterUsuario(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioResposta::new)
				.collect(Collectors.toList());
	}
	
}
