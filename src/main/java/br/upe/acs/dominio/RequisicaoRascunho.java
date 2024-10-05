package br.upe.acs.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RequisicaoRascunho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int semestre;

    private int qtdCertificados;

    private Long usuarioId;

    private Long cursoId;

    @Temporal(TemporalType.DATE)
    private Date dataExpiracao;

    @OneToMany(mappedBy = "requisicaoRascunho")
    private List<CertificadoRascunho> certificadosRascunho;

    public Long getId() {
        return id;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getQtdCertificados() {
        return qtdCertificados;
    }

    public void setQtdCertificados(int qtdCertificados) {
        this.qtdCertificados = qtdCertificados;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public List<CertificadoRascunho> getCertificados() {
        return certificadosRascunho;
    }

    public void setCertificados(List<CertificadoRascunho> certificados) {
        this.certificadosRascunho = certificados;
    }
}
