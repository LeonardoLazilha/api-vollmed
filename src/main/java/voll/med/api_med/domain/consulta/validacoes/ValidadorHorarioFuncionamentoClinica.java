package voll.med.api_med.domain.consulta.validacoes;

import org.springframework.stereotype.Component;
import voll.med.api_med.domain.ValidacaoException;
import voll.med.api_med.domain.consulta.dto.AgendamentoConsultaDTO;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

    public void validar(AgendamentoConsultaDTO dados){
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dataConsulta.getHour() < 7;
        var depoisDoEncerramento = dataConsulta.getHour() < 18;

        if (domingo || antesDaAbertura || depoisDoEncerramento){
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }

    }
}
