package voll.med.api_med.domain.consulta;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import voll.med.api_med.domain.ValidacaoException;
import voll.med.api_med.domain.consulta.dto.AgendamentoConsultaDTO;
import voll.med.api_med.domain.medico.MedicoRepository;
import voll.med.api_med.domain.paciente.PacienteRepository;

@Service
@RequiredArgsConstructor
public class AgendaDeConsultasService {

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;


    public void agendar(AgendamentoConsultaDTO dados)  {
        if (!pacienteRepository.existsById(dados.idPaciente())){
        throw new ValidacaoException("Id do paciente não localizado.");
        }

        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
        throw new ValidacaoException("Id do médico não localizado.");
        }

        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = medicoRepository.findById(dados.idMedico()).get();
        var consulta = new Consulta(null, medico, paciente, dados.data());

        consultaRepository.save(consulta);
    }
}
