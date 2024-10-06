package voll.med.api_med.domain.paciente.dto;

import voll.med.api_med.domain.paciente.Paciente;

public record PacienteListagemDTO(Long id, String nome, String email, String cpf, Boolean ativo) {

    public PacienteListagemDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getAtivo());
    }
}
