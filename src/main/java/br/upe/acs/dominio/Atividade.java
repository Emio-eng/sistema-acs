package br.upe.acs.dominio;

import java.util.List;

import br.upe.acs.dominio.enums.EixoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Atividade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private EixoEnum eixo;
	
	private String descricao;
	
	private int chMaxima;
	
	@OneToMany(mappedBy = "atividade")
	private List<Certificado> certificados;

	public Long getId() {
		return id;
	}

	public EixoEnum getEixo() {
		return eixo;
	}

	public void setEixo(EixoEnum eixo) {
		this.eixo = eixo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getChMaxima() {
		return chMaxima;
	}

	public void setChMaxima(int chMaxima) {
		this.chMaxima = chMaxima;
	}
	
	public List<Certificado> getCertificados() {
		return certificados;
	}

	public void setCertificados(List<Certificado> certificados) {
		this.certificados = certificados;
	}
}
