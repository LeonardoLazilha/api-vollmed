package voll.med.api_med.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import voll.med.api_med.domain.consulta.AgendaDeConsultasService;
import voll.med.api_med.domain.consulta.CancelamentoDeConsultaService;
import voll.med.api_med.domain.consulta.dto.AgendamentoConsultaDTO;
import voll.med.api_med.domain.consulta.dto.CancelamentoConsultaDTO;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultasService agendaDeConsultasService;

    @Autowired
    private CancelamentoDeConsultaService cancelamentoDeConsultaService;

    @PostMapping
    @Transactional
    public ResponseEntity agendar (@RequestBody @Valid AgendamentoConsultaDTO dados){
        var dto = agendaDeConsultasService.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/cancelar")
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid CancelamentoConsultaDTO dados) {
        var dto = cancelamentoDeConsultaService.cancelar(dados);
        return ResponseEntity.ok(dto);
    }
}
