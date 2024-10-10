package voll.med.api_med.domain.consulta.validacoes;

import voll.med.api_med.domain.consulta.dto.AgendamentoConsultaDTO;

public interface ValidadorAgendamentoDeConsulta {

    void validar(AgendamentoConsultaDTO dados);
}
