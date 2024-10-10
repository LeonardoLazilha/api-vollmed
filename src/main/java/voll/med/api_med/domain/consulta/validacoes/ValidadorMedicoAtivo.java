package voll.med.api_med.domain.consulta.validacoes;

import voll.med.api_med.domain.ValidacaoException;
import voll.med.api_med.domain.consulta.dto.AgendamentoConsultaDTO;
import voll.med.api_med.domain.medico.MedicoRepository;

public class ValidadorMedicoAtivo {

    private MedicoRepository medicoRepository;

    public void validar(AgendamentoConsultaDTO dados) {
        //escolha do medico opcional
        if (dados.idMedico() == null) {
            return;
        }

        var medicoAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if (!medicoAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada! Médico desativado.");
        }
    }

}
