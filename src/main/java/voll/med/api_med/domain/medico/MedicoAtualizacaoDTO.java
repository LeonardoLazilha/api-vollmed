package voll.med.api_med.domain.medico;

import jakarta.validation.constraints.NotNull;
import voll.med.api_med.domain.endereco.EnderecoDTO;

public record MedicoAtualizacaoDTO(@NotNull Long id, String nome, String telefone, EnderecoDTO endereco) {
}
