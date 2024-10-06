package voll.med.api_med.domain.medico.dto;

import voll.med.api_med.domain.endereco.Endereco;
import voll.med.api_med.domain.medico.Especialidade;
import voll.med.api_med.domain.medico.Medico;

public record MedicoDetalhamentoDTO(
        Long id, String nome, String crm, String email, String telefone, Especialidade especialidade, Endereco endereco
) {
    public MedicoDetalhamentoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
