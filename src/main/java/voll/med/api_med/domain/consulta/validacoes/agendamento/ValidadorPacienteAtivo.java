package voll.med.api_med.domain.consulta.validacoes.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import voll.med.api_med.domain.ValidacaoException;
import voll.med.api_med.domain.consulta.dto.AgendamentoConsultaDTO;
import voll.med.api_med.domain.paciente.PacienteRepository;


@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(AgendamentoConsultaDTO dados){
        var pacienteAtivo = pacienteRepository.findAtivoById(dados.idPaciente());
        if (!pacienteAtivo || pacienteAtivo == null){
            throw  new ValidacaoException("Consulta não pode ser agendada com paciente desativado!");
        }
    }
}
