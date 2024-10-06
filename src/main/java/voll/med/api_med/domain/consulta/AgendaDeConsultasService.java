package voll.med.api_med.domain.consulta;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import voll.med.api_med.domain.consulta.dto.AgendamentoConsultaDTO;
import voll.med.api_med.domain.medico.MedicoRepository;
import voll.med.api_med.domain.paciente.PacienteRepository;

@Service
@RequiredArgsConstructor
public class AgendaDeConsultasService {

    private ConsultaRepository consultaRepository;
    private MedicoRepository medicoRepository;
    private PacienteRepository pacienteRepository;


    public void agendar(AgendamentoConsultaDTO dados){

        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = medicoRepository.findById(dados.idMedico()).get();
        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);
    }
}
