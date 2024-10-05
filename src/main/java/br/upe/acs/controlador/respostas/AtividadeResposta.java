package br.upe.acs.controlador.respostas;

import java.util.List;
import java.util.stream.Collectors;

import br.upe.acs.dominio.Atividade;
import br.upe.acs.dominio.Certificado;
import br.upe.acs.dominio.enums.EixoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class AtividadeResposta {

    private final Long id;

    @Enumerated(EnumType.STRING)
    private final EixoEnum eixo;

    private final String descricao;

    private final int chMaxima;

    private final List<CertificadoResposta> certificados;

    public AtividadeResposta(Atividade atividade) {
        super();
        this.id = atividade.getId();
        this.eixo = atividade.getEixo();
        this.descricao = atividade.getDescricao();
        this.chMaxima = atividade.getChMaxima();
        this.certificados = converterCertificados(atividade.getCertificados());
    }

    private List<CertificadoResposta> converterCertificados(List<Certificado> certificados) {
        return certificados.stream()
				.map(CertificadoResposta::new).collect(Collectors.toList());
    }
}
