package voll.med.api_med.domain.paciente.dto;

import jakarta.validation.constraints.NotNull;
import voll.med.api_med.domain.endereco.EnderecoDTO;

public record PacienteAtualizacaoDTO(@NotNull Long id, String nome, String telefone, EnderecoDTO endereco) {
}
