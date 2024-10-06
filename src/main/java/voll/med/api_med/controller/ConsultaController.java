package voll.med.api_med.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import voll.med.api_med.domain.consulta.AgendaDeConsultasService;
import voll.med.api_med.domain.consulta.dto.AgendamentoConsultaDTO;
import voll.med.api_med.domain.consulta.dto.AgendamentoConsultaDetalhamentoDTO;

@RestController
@RequestMapping("/consulta")
@RequiredArgsConstructor
public class ConsultaController {

    private AgendaDeConsultasService agendaDeConsultasService;

    @PostMapping
    @Transactional
    public ResponseEntity agendar (@RequestBody @Valid AgendamentoConsultaDTO dados){
        agendaDeConsultasService.agendar(dados);
        return ResponseEntity.ok(new AgendamentoConsultaDetalhamentoDTO(null, null, null, null));
    }
}
