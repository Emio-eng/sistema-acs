package br.upe.acs.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.dominio.Endereco;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {

}
