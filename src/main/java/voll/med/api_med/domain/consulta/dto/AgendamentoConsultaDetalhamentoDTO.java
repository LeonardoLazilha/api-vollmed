package voll.med.api_med.domain.consulta.dto;

import voll.med.api_med.domain.consulta.Consulta;

import java.time.LocalDateTime;

public record AgendamentoConsultaDetalhamentoDTO(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {

    public AgendamentoConsultaDetalhamentoDTO(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}
