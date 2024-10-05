package br.upe.acs.controlador.respostas;

import java.util.Date;

import br.upe.acs.dominio.Certificado;
import lombok.Getter;

@Getter
public class CertificadoResposta {
	
	private final Long id;
	
	private final String titulo;
	
	private final String descricao;
	
	private final Date data;
	
	private final int horas;
	
	private final int chMaxima;
	
	private final int chTotal;
	
	private final byte[] certificadoArquivo;

	public CertificadoResposta(Certificado certificado) {
		super();
		this.id = certificado.getId();
		this.titulo = certificado.getTitulo();
		this.descricao = certificado.getDescricao();
		this.data = certificado.getData();
		this.horas = certificado.getHoras();
		this.chMaxima = certificado.getChMaxima();
		this.chTotal = certificado.getChTotal();
		this.certificadoArquivo = certificado.getCertificado();
	}
}
