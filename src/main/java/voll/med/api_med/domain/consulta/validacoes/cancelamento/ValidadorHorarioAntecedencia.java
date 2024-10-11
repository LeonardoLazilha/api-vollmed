package voll.med.api_med.domain.consulta.validacoes.cancelamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import voll.med.api_med.domain.ValidacaoException;
import voll.med.api_med.domain.consulta.ConsultaRepository;
import voll.med.api_med.domain.consulta.dto.CancelamentoConsultaDTO;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamento")
public class ValidadorHorarioAntecedencia implements ValidadorCancelamentoDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;


    @Override
    public void validar(CancelamentoConsultaDTO dados) {
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaHoras = Duration.between(agora, consulta.getData()).toHours();

        if (diferencaHoras < 24){
            throw new ValidacaoException("Consulta somente pode ser cancelada com antecedência mínima de 24h!");
        }
    }
}
