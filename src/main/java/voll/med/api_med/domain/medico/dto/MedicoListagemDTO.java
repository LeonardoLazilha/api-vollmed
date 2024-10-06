package voll.med.api_med.domain.medico.dto;

import voll.med.api_med.domain.medico.Especialidade;
import voll.med.api_med.domain.medico.Medico;

public record MedicoListagemDTO(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public MedicoListagemDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
