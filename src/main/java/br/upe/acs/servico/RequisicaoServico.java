package br.upe.acs.servico;

import br.upe.acs.controlador.respostas.RequisicaoResposta;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.repositorio.RequisicaoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequisicaoServico {

	private final RequisicaoRepositorio repositorio;
	private final UsuarioServico usuarioServico;
	
	public List<Requisicao> listarRequisicoes() {
		return repositorio.findAll();
	}

	public Map<String, Object> listarRequisicoesPaginadas(int pagina, int quantidade) {
		Pageable paginaFormato = PageRequest.of(pagina, quantidade);

		Page<Requisicao> requisicoesPagina = repositorio.findAll(paginaFormato);

		return gerarPaginacao(requisicoesPagina);
	}

	public List<Requisicao> listarRequisicoesPorUsuario(Long usuarioId) throws AcsExcecao {
		Usuario usuario = usuarioServico.buscarUsuarioPorId(usuarioId).orElseThrow();

		return repositorio.findByUsuario(usuario);
	}

	public Optional<Requisicao> buscarRequisicaoPorId(Long id) throws AcsExcecao {
		if (repositorio.findById(id).isEmpty()) {
			throw new AcsExcecao("Não existe uma requisição associada a este id!");
		}

		return repositorio.findById(id);
	}

	private Map<String, Object> gerarPaginacao (Page<Requisicao> pagina) {
		List<RequisicaoResposta> requisicoesConteudo = pagina.getContent().stream()
				.map(RequisicaoResposta::new).toList();

		Map<String, Object> resposta = new HashMap<>();
		resposta.put("requisicoes", requisicoesConteudo);
		resposta.put("paginaAtual", pagina.getNumber());
		resposta.put("totalItens", pagina.getTotalElements());
		resposta.put("totalPaginas", pagina.getTotalPages());

		return resposta;
	}

}
