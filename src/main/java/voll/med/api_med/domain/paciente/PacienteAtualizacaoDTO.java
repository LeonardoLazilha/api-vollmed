package voll.med.api_med.domain.paciente;

import jakarta.validation.constraints.NotNull;
import voll.med.api_med.domain.endereco.EnderecoDTO;

public record PacienteAtualizacaoDTO(@NotNull Long id, String nome, String telefone, EnderecoDTO endereco) {
}
