package br.upe.acs.dominio.vo;

import br.upe.acs.dominio.dto.CertificadoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RascunhoVO {
    private MultipartFile[] certificadoArquivos;

    private List<CertificadoDTO> certificados;

    private int qtdCertificados;

    private Long idRequisicao;
}
