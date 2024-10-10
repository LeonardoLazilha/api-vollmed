package voll.med.api_med.domain.consulta.validacoes;

import voll.med.api_med.domain.ValidacaoException;
import voll.med.api_med.domain.consulta.dto.AgendamentoConsultaDTO;
import voll.med.api_med.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {

    private PacienteRepository pacienteRepository;

    public void validar(AgendamentoConsultaDTO dados){
        var pacienteAtivo = pacienteRepository.findAtivoById(dados.idPaciente());
        if (!pacienteAtivo || pacienteAtivo == null){
            throw  new ValidacaoException("Consulta não pode ser agendada com paciente desativado!");
        }
    }
}
