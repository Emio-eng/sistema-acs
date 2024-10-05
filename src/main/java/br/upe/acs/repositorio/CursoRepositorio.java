package br.upe.acs.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.dominio.Curso;

public interface CursoRepositorio extends JpaRepository<Curso, Long>{

}
