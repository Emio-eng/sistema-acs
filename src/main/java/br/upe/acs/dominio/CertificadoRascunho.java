package br.upe.acs.dominio;

import br.upe.acs.dominio.enums.EixoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CertificadoRascunho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    private String descricao;

    @Temporal(TemporalType.DATE)
    private Date data;

    private int horas;

    private int chMaxima;

    private byte[] certificadoArquivo;

    @Enumerated(EnumType.STRING)
    private EixoEnum eixoAtividade;

    private String descricaoAtividade;

    @ManyToOne
    private RequisicaoRascunho requisicaoRascunho;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getChMaxima() {
        return chMaxima;
    }

    public void setChMaxima(int chMaxima) {
        this.chMaxima = chMaxima;
    }

    public byte[] getCertificadoArquivo() {
        return certificadoArquivo;
    }

    public void setCertificadoArquivo(byte[] certificadoArquivo) {
        this.certificadoArquivo = certificadoArquivo;
    }

    public EixoEnum getEixoAtividade() {
        return eixoAtividade;
    }

    public void setEixoAtividade(EixoEnum eixoAtividade) {
        this.eixoAtividade = eixoAtividade;
    }

    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }

    public RequisicaoRascunho getRequisicaoRascunho() {
        return requisicaoRascunho;
    }

    public void setRequisicaoRascunho(RequisicaoRascunho requisicaoRascunho) {
        this.requisicaoRascunho = requisicaoRascunho;
    }
}
