package voll.med.api_med.domain.consulta.dto;

import jakarta.validation.constraints.NotNull;
import voll.med.api_med.domain.consulta.validacoes.cancelamento.MotivoCancelamento;

public record CancelamentoConsultaDTO(

        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivoCancelamento
) {
}
