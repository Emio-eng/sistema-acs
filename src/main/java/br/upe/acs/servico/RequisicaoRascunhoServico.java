package br.upe.acs.servico;

import br.upe.acs.dominio.RequisicaoRascunho;
import br.upe.acs.repositorio.RequisicaoRascunhoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequisicaoRascunhoServico {
    private final RequisicaoRascunhoRepositorio repositorio;

    public Optional<RequisicaoRascunho> buscarRequisicaoRascunhoPorId(Long id) throws AcsExcecao {
        if (repositorio.findById(id).isEmpty()) {
            throw new AcsExcecao("Não existe uma requisição associada a este id!");
        }

        return repositorio.findById(id);
    }
}
