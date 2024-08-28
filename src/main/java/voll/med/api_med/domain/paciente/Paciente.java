package voll.med.api_med.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import voll.med.api_med.domain.endereco.Endereco;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    Endereco endereco;

    private Boolean ativo;


    public Paciente(PacienteDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public Long getId() {return id;}

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void atualizarInformacoes(PacienteAtualizacaoDTO dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }

        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }

        if (dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}
