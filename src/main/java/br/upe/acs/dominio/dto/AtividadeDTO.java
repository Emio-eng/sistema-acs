package br.upe.acs.dominio.dto;

import br.upe.acs.dominio.enums.EixoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtividadeDTO {
	
	@Enumerated(EnumType.STRING)
	private EixoEnum eixo;
	
	private String descricao;
}
