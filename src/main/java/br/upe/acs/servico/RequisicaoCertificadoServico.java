package br.upe.acs.servico;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.upe.acs.dominio.RequisicaoRascunho;
import br.upe.acs.dominio.dto.RequisicaoRascunhoDTO;
import br.upe.acs.dominio.vo.RascunhoVO;
import br.upe.acs.repositorio.RequisicaoRascunhoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.upe.acs.dominio.Curso;
import br.upe.acs.dominio.Requisicao;
import br.upe.acs.dominio.Usuario;
import br.upe.acs.dominio.dto.CertificadoDTO;
import br.upe.acs.dominio.dto.CertificadosMetadadosDTO;
import br.upe.acs.dominio.dto.RequisicaoDTO;
import br.upe.acs.dominio.enums.RequisicaoStatusEnum;
import br.upe.acs.repositorio.RequisicaoRepositorio;
import br.upe.acs.utils.AcsExcecao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequisicaoCertificadoServico {

    private final UsuarioServico usuarioServico;
    private final CursoServico cursoServico;
    private final CertificadoServico certificadoServico;
    private final CertificadoRascunhoServico certificadoRascunhoServico;
    private final AtividadeServico atividadeServico;
    private final RequisicaoRepositorio repositorio;
    private final RequisicaoRascunhoRepositorio rascunhoRepositorio;

    public void salvarRascunho(RequisicaoRascunhoDTO requisicaoRascunho) throws AcsExcecao, IOException, ParseException {
        CertificadosMetadadosDTO certificadosMetadados = converterCertificadosMetadados(requisicaoRascunho.getCertificadosMetadados());

        RequisicaoRascunho rascunhoSalvar = new RequisicaoRascunho();
        rascunhoSalvar.setSemestre(requisicaoRascunho.getSemestre());
        rascunhoSalvar.setQtdCertificados(requisicaoRascunho.getQtdCertificados());
        rascunhoSalvar.setUsuarioId(requisicaoRascunho.getUsuarioId());
        rascunhoSalvar.setCursoId(requisicaoRascunho.getCursoId());
        rascunhoSalvar.setDataExpiracao(null);

        RequisicaoRascunho rascunhoSalvo = rascunhoRepositorio.save(rascunhoSalvar);

        MultipartFile[] certificadoArquivosRascunho = requisicaoRascunho.getCertificadoArquivos();
        List<CertificadoDTO> certificadosRascunho = certificadosMetadados.getCertificados();

        RascunhoVO rascunhoVO = new RascunhoVO();
        rascunhoVO.setCertificadoArquivos(certificadoArquivosRascunho);
        rascunhoVO.setCertificados(certificadosRascunho);
        rascunhoVO.setQtdCertificados(requisicaoRascunho.getQtdCertificados());
        rascunhoVO.setIdRequisicao(rascunhoSalvo.getId());

       adicionarCertificadosRascunho(rascunhoVO);
    }

    public String adicionarRequisicao(RequisicaoDTO requisicao) throws Exception {
        Curso cursoSalvar = cursoServico.buscarCursoPorId(requisicao.getCursoId()).orElseThrow();
        Usuario usuarioSalvar = usuarioServico.buscarUsuarioPorId(requisicao.getUsuarioId()).orElseThrow();
        CertificadosMetadadosDTO certificadosMetadados = converterCertificadosMetadados(requisicao.getCertificadosMetadados());

        validarRequisicao(requisicao, certificadosMetadados.getCertificados());
        Requisicao requisicaoSalvar = new Requisicao();
        requisicaoSalvar.setData(obterDataAtual());
        requisicaoSalvar.setSemestre(requisicao.getSemestre());
        requisicaoSalvar.setQtdCertificados(requisicao.getQtdCertificados());
        requisicaoSalvar.setStatusRequisicao(RequisicaoStatusEnum.ENCAMINHADO_COORDENACAO);
        requisicaoSalvar.setCurso(cursoSalvar);
        requisicaoSalvar.setUsuario(usuarioSalvar);

        Requisicao requisicaoSalva = repositorio.save(requisicaoSalvar);

        MultipartFile[] certificadoArquivos = requisicao.getCertificados();
        List<CertificadoDTO> certificados = certificadosMetadados.getCertificados();
        adicionarCertificados(certificadoArquivos, certificados, requisicaoSalva.getId());

        String token = gerarTokenRequisicao();
        requisicaoSalva.setToken(token);
        repositorio.save(requisicaoSalva);

        return token;
    }

    private void validarRequisicao(RequisicaoDTO requisicao, List<CertificadoDTO> certificados) throws AcsExcecao {
        boolean isValid = true;
        String mensagem = "";

        if (requisicao.getSemestre() <= 0 || requisicao.getSemestre() > 2) {
            isValid = false;
            mensagem += "O semestre informado não é válido/";
        }
        if (requisicao.getQtdCertificados() <= 0 || requisicao.getQtdCertificados() > 20) {
            isValid = false;
            mensagem += "A quantidade de certificados informada não é válida/";
        }
        if (certificados.size() != requisicao.getQtdCertificados()) {
            isValid = false;
            mensagem += "A quantidade de certificados informadas não é igual a quantidade de certificados cadastrados/";
        }

        if (!isValid) {
            throw new AcsExcecao(mensagem);
        }
    }

    private static Date obterDataAtual() throws ParseException {
        SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date data = new Date();
        final String dataString = dataFormato.format(data);

        return dataFormato.parse(dataString);
    }

    private CertificadosMetadadosDTO converterCertificadosMetadados(MultipartFile certificadosMetadadosArquivo) throws AcsExcecao {
        CertificadosMetadadosDTO certificadosMetadados;
        try {
            byte[] certificadoMetadadosBytes = certificadosMetadadosArquivo.getBytes();
            certificadosMetadados = converter(certificadoMetadadosBytes);
        } catch (IOException e) {
            throw new AcsExcecao("Falha na conversão dos metadados relacionados aos certificados!");
        }

        return certificadosMetadados;
    }

    private CertificadosMetadadosDTO converter(byte[] certificadosMetadadosJson)
            throws IOException {
        String jsonString = new String(certificadosMetadadosJson);

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonString,
                CertificadosMetadadosDTO.class);
    }

    private void adicionarCertificados(MultipartFile[] certificadoArquivos, List<CertificadoDTO> certificados,
                                       Long idRequisicao) throws IOException, ParseException, AcsExcecao {

        validarCertificados(certificados);

        for (int i = 0; i < certificadoArquivos.length; i++) {

            MultipartFile certificadoArquivoSalvar = certificadoArquivos[i];
            CertificadoDTO certificadoSalvar = certificados.get(i);
            certificadoSalvar.setRequisicaoId(idRequisicao);

            certificadoServico.adicionarCertificado(certificadoSalvar, certificadoArquivoSalvar);
        }
    }

    private void adicionarCertificadosRascunho(RascunhoVO rascunho) throws AcsExcecao, IOException, ParseException {

        for (int i = 0; i < rascunho.getQtdCertificados(); i++) {

            MultipartFile certificadoArquivoSalvar = null;
            if(rascunho.getCertificadoArquivos().length >= i + 1) {
                certificadoArquivoSalvar = rascunho.getCertificadoArquivos()[i];
            }

            CertificadoDTO certificadoSalvar = new CertificadoDTO();
            if (rascunho.getCertificados().size() >= i + 1) {
                certificadoSalvar = rascunho.getCertificados().get(i);
                certificadoSalvar.setRequisicaoId(rascunho.getIdRequisicao());
            }

            certificadoRascunhoServico.adicionarCertificadoRascunho(certificadoSalvar, certificadoArquivoSalvar);
        }
    }

    private void validarCertificados(List<CertificadoDTO> certificados) throws AcsExcecao {
        boolean isValid = true;

        for (CertificadoDTO certificado : certificados) {

            if (certificado.getDescricao().isBlank()) {
                isValid = false;
            } else if (!verificarData(certificado.getData())) {
                isValid = false;
            } else if (certificado.getHoras() <= 1) {
                isValid = false;
            } else if (!verificarAtividade(certificado.getAtividadeId())) {
                isValid = false;
            }

            if (!isValid) {
                throw new AcsExcecao("Os metadados dos certificados enviados não são válidos!");
            }
        }
    }

    private static boolean verificarData(String dataString) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        formato.setLenient(false);

        try {
            formato.parse(dataString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean verificarAtividade(Long atividadeId) {
        try {
            atividadeServico.buscarAtividadePorId(atividadeId);
            return true;
        } catch (AcsExcecao e) {
            return false;
        }
    }

    private String gerarTokenRequisicao() {
        String caracteres = "0123456789!@#$%.*";
        Random random = new Random();
        StringBuilder tokenParcial = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(caracteres.length());
            tokenParcial.append(caracteres.charAt(index));
        }

        Instant timeStamp = Instant.now();
        long epocaSegundos = timeStamp.getEpochSecond();

        return tokenParcial + Long.toString(epocaSegundos);
    }
}
