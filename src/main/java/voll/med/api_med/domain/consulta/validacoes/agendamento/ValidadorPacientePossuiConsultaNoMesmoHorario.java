package voll.med.api_med.domain.consulta.validacoes.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import voll.med.api_med.domain.ValidacaoException;
import voll.med.api_med.domain.consulta.ConsultaRepository;
import voll.med.api_med.domain.consulta.dto.AgendamentoConsultaDTO;


@Component
public class ValidadorPacientePossuiConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(AgendamentoConsultaDTO dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = consultaRepository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if (pacientePossuiOutraConsultaNoDia){
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia.");
        }
    }
}
