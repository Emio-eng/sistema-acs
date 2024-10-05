package br.upe.acs.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.dominio.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByEmail(String email);
	
	Optional<Usuario> findByCpf(String cpf);
}
