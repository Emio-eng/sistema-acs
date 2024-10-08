package br.upe.acs.controlador;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.upe.acs.dominio.dto.RequisicaoRascunhoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.upe.acs.controlador.respostas.RequisicaoResposta;
import br.upe.acs.dominio.dto.RequisicaoDTO;
import br.upe.acs.servico.RequisicaoCertificadoServico;
import br.upe.acs.servico.RequisicaoServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/requisicao")
@RequiredArgsConstructor
@CrossOrigin
public class RequisicaoControlador {

    private final RequisicaoServico servico;

    private final RequisicaoCertificadoServico requisicaoCertificadoServico;

    @Operation(summary = "Listar todas as requisições")
    @GetMapping
    public ResponseEntity<List<RequisicaoResposta>> listarRequisicoes() {
        return ResponseEntity.ok(servico.listarRequisicoes().stream()
                .map(RequisicaoResposta::new).collect(Collectors.toList()));
    }

    @Operation(summary = "Listar as requisições com paginação")
    @GetMapping("/paginacao")
    public ResponseEntity<Map<String, Object>> listarRequisicoesPaginas(@RequestParam(defaultValue = "0") int pagina,
                                                                        @RequestParam(defaultValue = "10") int quantidade) {
        return ResponseEntity.ok(servico.listarRequisicoesPaginadas(pagina, quantidade));
    }

    @Operation(summary = "Listar as requisições de um usuário específico")
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<RequisicaoResposta>> listarRequisicoesPorUsuario(@PathVariable("id") Long usuarioId)
            throws AcsExcecao {
        return ResponseEntity.ok(servico.listarRequisicoesPorUsuario(usuarioId).stream()
                .map(RequisicaoResposta::new).collect(Collectors.toList()));
    }

    @Operation(summary = "Buscar requisição por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarRequisicaoPorId(@PathVariable("id") Long id) {
        try {
            RequisicaoResposta requisicaoResposta = new RequisicaoResposta(servico.buscarRequisicaoPorId(id).orElseThrow());
            return ResponseEntity.ok(requisicaoResposta);
        } catch (AcsExcecao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Adicionar requisição com certificados")
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> adicionarRequisicao(@RequestParam(value = "usuarioId") Long usuarioId,
                                                 @RequestParam(value = "cursoId") Long cursoId,
                                                 @RequestParam(value = "semestre") int semestre,
                                                 @RequestParam(value = "qtdCertificados") int qtdCertificados,
                                                 @RequestPart(value = "certificados") MultipartFile[] certificados,
                                                 @RequestPart(value = "certificadosMetadados") MultipartFile certificadosMetadados) {
        RequisicaoDTO requisicaoDTO = new RequisicaoDTO();
        requisicaoDTO.setCursoId(cursoId);
        requisicaoDTO.setUsuarioId(usuarioId);
        requisicaoDTO.setSemestre(semestre);
        requisicaoDTO.setQtdCertificados(qtdCertificados);
        requisicaoDTO.setCertificados(certificados);
        requisicaoDTO.setCertificadosMetadados(certificadosMetadados);

        ResponseEntity<?> resposta;
        try {
            resposta = ResponseEntity.ok(requisicaoCertificadoServico.adicionarRequisicao(requisicaoDTO));
        } catch (Exception e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }

    @PostMapping(path = "/rascunho", consumes = {"multipart/form-data"})
    public ResponseEntity<?> adicionarRequisicaoRascunho(@RequestParam(value = "usuarioId") Long usuarioId,
                                                         @RequestParam(value = "cursoId") Long cursoId,
                                                         @RequestParam(value = "semestre") int semestre,
                                                         @RequestParam(value = "qtdCertificados") int qtdCertificados,
                                                         @RequestPart(value = "certificados", required = false) MultipartFile[] certificados,
                                                         @RequestPart(value = "certificadosMetadados") MultipartFile certificadosMetadados) {
        RequisicaoRascunhoDTO requisicaoRascunhoDTO = new RequisicaoRascunhoDTO();
        requisicaoRascunhoDTO.setSemestre(semestre);
        requisicaoRascunhoDTO.setQtdCertificados(qtdCertificados);
        requisicaoRascunhoDTO.setUsuarioId(usuarioId);
        requisicaoRascunhoDTO.setCursoId(cursoId);
        requisicaoRascunhoDTO.setCertificadoArquivos(certificados);
        requisicaoRascunhoDTO.setCertificadosMetadados(certificadosMetadados);

        ResponseEntity<?> resposta;
        try {
            requisicaoCertificadoServico.salvarRascunho(requisicaoRascunhoDTO);
            resposta = ResponseEntity.ok().build();
        } catch (Exception e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }
}
