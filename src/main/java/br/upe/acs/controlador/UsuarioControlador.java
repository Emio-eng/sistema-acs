package br.upe.acs.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.upe.acs.controlador.respostas.UsuarioResposta;
import br.upe.acs.servico.UsuarioServico;
import br.upe.acs.utils.AcsExcecao;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
@CrossOrigin
public class UsuarioControlador {

    private final UsuarioServico servico;

    @Operation(summary = "Buscar usuário por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable("id") Long id) {
        ResponseEntity<?> resposta;
        try {
			UsuarioResposta usuarioResposta = new UsuarioResposta(servico.buscarUsuarioPorId(id).orElseThrow());
			resposta = ResponseEntity.ok(usuarioResposta);
		} catch (AcsExcecao e) {
			resposta = ResponseEntity.badRequest().body(e.getMessage());
		}

        return resposta;
    }

    @Operation(summary = "Verificar usuário")
    @PostMapping("/verificacao")
    public ResponseEntity<?> verificarUsuario(@RequestParam(value = "usuarioId") Long usuarioId,
                                              @RequestParam(value = "codigoVerificacao") String codigo) {
        ResponseEntity<?> resposta;
        try {
            resposta = ResponseEntity.ok(servico.verificarUsuario(usuarioId, codigo));
        } catch (AcsExcecao e) {
            resposta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return resposta;
    }
}
