package voll.med.api_med.domain.consulta;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import voll.med.api_med.domain.ValidacaoException;
import voll.med.api_med.domain.consulta.dto.CancelamentoConsultaDTO;
import voll.med.api_med.domain.consulta.dto.CancelamentoConsultaDetalhamentoDTO;
import voll.med.api_med.domain.consulta.validacoes.cancelamento.ValidadorCancelamentoDeConsulta;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CancelamentoDeConsultaService {

    private final ConsultaRepository consultaRepository;
    private final List<ValidadorCancelamentoDeConsulta> validadoresCancelamento;

    public CancelamentoConsultaDetalhamentoDTO cancelar(CancelamentoConsultaDTO dados) {
        if (!consultaRepository.existsById(dados.idConsulta())) {
            throw new ValidacaoException("Id da consulta informado não existe!");
        }

        validadoresCancelamento.forEach(v -> v.validar(dados));

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivoCancelamento());

        consultaRepository.save(consulta);

        return new CancelamentoConsultaDetalhamentoDTO(consulta.getId(), consulta.getMotivoCancelamento());
    }
}