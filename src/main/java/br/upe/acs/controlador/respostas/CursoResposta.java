package br.upe.acs.controlador.respostas;

import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.dominio.Curso;
import br.upe.acs.dominio.Requisicao;
import lombok.Getter;

@Getter
public class CursoResposta {

	private final Long id;

	private final String nome;

	private final List<RequisicaoResposta> requisicoes;

	public CursoResposta(Curso curso) {
		super();
		this.id = curso.getId();
		this.nome = curso.getNome();
		this.requisicoes = converterRequisicoes(curso.getRequisicoes());
	}

	private List<RequisicaoResposta> converterRequisicoes(List<Requisicao> requisicoes) {
		return requisicoes.stream().map(RequisicaoResposta::new)
				.collect(Collectors.toList());
	}
}
