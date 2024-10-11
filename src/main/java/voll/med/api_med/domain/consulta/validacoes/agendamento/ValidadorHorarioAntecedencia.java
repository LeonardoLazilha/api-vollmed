package voll.med.api_med.domain.consulta.validacoes.agendamento;

import org.springframework.stereotype.Component;
import voll.med.api_med.domain.ValidacaoException;
import voll.med.api_med.domain.consulta.dto.AgendamentoConsultaDTO;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(AgendamentoConsultaDTO dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }

    }
}