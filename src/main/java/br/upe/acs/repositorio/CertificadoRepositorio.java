package br.upe.acs.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.acs.dominio.Certificado;

public interface CertificadoRepositorio extends JpaRepository<Certificado, Long> {

}
