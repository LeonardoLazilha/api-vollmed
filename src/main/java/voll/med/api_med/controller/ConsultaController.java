package voll.med.api_med.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import voll.med.api_med.domain.consulta.AgendamentoConsultaDTO;
import voll.med.api_med.domain.consulta.AgendamentoConsultaDetalhamentoDTO;

@RestController
@RequestMapping
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar (@RequestBody @Valid AgendamentoConsultaDTO dados){
        System.out.println(dados);
        return ResponseEntity.ok(new AgendamentoConsultaDetalhamentoDTO(null, null, null, null));
    }
}
