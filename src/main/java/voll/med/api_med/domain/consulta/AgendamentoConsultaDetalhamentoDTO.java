package voll.med.api_med.domain.consulta;

import java.time.LocalDateTime;

public record AgendamentoConsultaDetalhamentoDTO(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}
