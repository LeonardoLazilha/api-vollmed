package voll.med.api_med.domain.consulta.validacoes;

import org.springframework.stereotype.Component;
import voll.med.api_med.domain.ValidacaoException;
import voll.med.api_med.domain.consulta.ConsultaRepository;
import voll.med.api_med.domain.consulta.dto.AgendamentoConsultaDTO;

@Component
public class ValidadorMedicoPossuiConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

    private ConsultaRepository consultaRepository;

    public void validar(AgendamentoConsultaDTO dados){
        var medicoPossuiOutraConsultaNoMesmoHorario = consultaRepository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("O médico escolhido já possui consulta neste mesmo horário.");
        }
    }

}
