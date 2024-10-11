package voll.med.api_med.domain.consulta.validacoes.cancelamento;

import voll.med.api_med.domain.consulta.dto.CancelamentoConsultaDTO;

public interface ValidadorCancelamentoDeConsulta {

    void validar(CancelamentoConsultaDTO dados);
}
