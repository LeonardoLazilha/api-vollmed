package voll.med.api_med.domain.consulta.dto;

import voll.med.api_med.domain.consulta.validacoes.cancelamento.MotivoCancelamento;

public record CancelamentoConsultaDetalhamentoDTO(Long idConsulta, MotivoCancelamento motivoCancelamento) {
}
