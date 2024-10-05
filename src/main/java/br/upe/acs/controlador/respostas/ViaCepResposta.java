package br.upe.acs.controlador.respostas;

import br.upe.acs.dominio.dto.ViaCepDTO;
import lombok.Getter;

@Getter
public class ViaCepResposta {
    private String cep;

    private String rua;

    private String bairro;

    private String cidade;

    private String UF;

    public ViaCepResposta(ViaCepDTO viaCepDTO) {
        super();
        this.cep = viaCepDTO.getCep();
        this.rua = viaCepDTO.getLogradouro();
        this.bairro = viaCepDTO.getBairro();
        this.cidade = viaCepDTO.getLocalidade();
        UF = viaCepDTO.getUf();
    }
}
