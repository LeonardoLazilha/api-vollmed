package voll.med.api_med.domain.paciente;

import voll.med.api_med.domain.endereco.Endereco;

public record PacienteDetalhamentoDTO(
        Long id, String email, String nome, String telefone,
        String cpf, Endereco endereco) {
    public PacienteDetalhamentoDTO (Paciente paciente){
        this(paciente.getId(), paciente.getEmail(), paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
