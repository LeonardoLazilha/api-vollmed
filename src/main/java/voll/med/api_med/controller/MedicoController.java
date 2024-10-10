package voll.med.api_med.controller;

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
import voll.med.api_med.domain.medico.Medico;
import voll.med.api_med.domain.medico.dto.MedicoAtualizacaoDTO;
import voll.med.api_med.domain.medico.dto.MedicoDTO;
import voll.med.api_med.domain.medico.dto.MedicoDetalhamentoDTO;
import voll.med.api_med.domain.medico.dto.MedicoListagemDTO;
import voll.med.api_med.domain.medico.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar (@RequestBody @Valid MedicoDTO dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);
        medicoRepository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new MedicoDetalhamentoDTO(medico));
    }

    @GetMapping
    public ResponseEntity<Page<MedicoListagemDTO>> listar(@PageableDefault(size = 20, page = 0, sort = {"nome"}) Pageable paginacao){
        var page = medicoRepository.findAllByAtivoTrue(paginacao).map(MedicoListagemDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid MedicoAtualizacaoDTO dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        if (medico.getAtivo()){
            medico.atualizarInformacoes(dados);
            return ResponseEntity.ok(new MedicoDetalhamentoDTO(medico));
        }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Médico inativo. Não pode ser atualizado.");
        }
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.inativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        if (medico.getAtivo()) {
            return ResponseEntity.ok(new MedicoDetalhamentoDTO(medico));
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Médico inativo. Não pode ser exibido.");
        }
    }



}
