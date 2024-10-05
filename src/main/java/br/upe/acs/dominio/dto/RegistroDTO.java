package br.upe.acs.dominio.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroDTO {
	
	private String nomeCompleto;

	@CPF(message = "CPF inválido!")
	private String cpf;
	
	private int periodo;
	
	private String telefone;

	@Email(message = "Email inválido!")
	private String email;
	
	private String senha;
	
	private String cep;
	
	private String rua;
	
	private String bairro;
	
	private String cidade;
	
	private String UF;
	
	private int numero;
	
	private Long cursoId;
}
