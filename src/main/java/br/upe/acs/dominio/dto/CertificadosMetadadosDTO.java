package br.upe.acs.dominio.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CertificadosMetadadosDTO {

	private List<CertificadoDTO> certificados;
}