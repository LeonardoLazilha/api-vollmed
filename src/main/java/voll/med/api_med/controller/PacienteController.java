package voll.med.api_med.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import voll.med.api_med.domain.paciente.Paciente;
import voll.med.api_med.domain.paciente.dto.PacienteAtualizacaoDTO;
import voll.med.api_med.domain.paciente.dto.PacienteDTO;
import voll.med.api_med.domain.paciente.dto.PacienteDetalhamentoDTO;
import voll.med.api_med.domain.paciente.dto.PacienteListagemDTO;
import voll.med.api_med.domain.paciente.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar (@RequestBody @Valid PacienteDTO dados, UriComponentsBuilder uriBuilder){
        var paciente = new Paciente(dados);
        repository.save(paciente);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new PacienteDetalhamentoDTO(paciente));
    }


    @GetMapping
    public ResponseEntity <Page<PacienteListagemDTO>> listar(@PageableDefault (size = 20, page = 0, sort = {"id"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(PacienteListagemDTO::new);
        return ResponseEntity.ok(page);
   }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar (@RequestBody @Valid PacienteAtualizacaoDTO dados){
        var paciente = repository.getReferenceById(dados.id());
        if (paciente.getAtivo()){
            paciente.atualizarInformacoes(dados);
            return ResponseEntity.ok(new PacienteDetalhamentoDTO(paciente));
        }else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Paciente inativo. Não pode ser atualizado.");
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir (@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.inativar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        if (paciente.getAtivo()){
            return ResponseEntity.ok(new PacienteDetalhamentoDTO(paciente));
        }else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Paciente inativo. Não pode ser exibido.");
        }
    }


}
