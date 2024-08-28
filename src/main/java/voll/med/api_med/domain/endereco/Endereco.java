package voll.med.api_med.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(EnderecoDTO dados) {
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.logradouro = dados.logradouro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.complemento = dados.complemento();
        this.numero = dados.numero();
    }

    public void atualizarInformacoes(EnderecoDTO dados) {
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.uf() != null) {
            this.uf = dados.uf();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
    }
    }
