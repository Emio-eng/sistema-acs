package br.upe.acs.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.dominio.Atividade;

public interface AtividadeRepositorio extends JpaRepository<Atividade, Long> {

}
