package br.com.mapped.SeaMI.controller;

import br.com.mapped.SeaMI.dto.RelatorioAmostra.AtualizacaoRelatorioAmostraDto;
import br.com.mapped.SeaMI.dto.RelatorioAmostra.CadastroRelatorioAmostraDto;
import br.com.mapped.SeaMI.dto.RelatorioAmostra.DetalhesRelatorioAmostraDto;
import br.com.mapped.SeaMI.model.RelatorioAmostra;
import br.com.mapped.SeaMI.repository.AmostraAguaRepository;
import br.com.mapped.SeaMI.repository.RelatorioAmostraRepository;
import br.com.mapped.SeaMI.repository.RelatorioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("relatorios-amostra")
public class RelatorioAmostraController {

    @Autowired
    private RelatorioAmostraRepository relatorioAmostraRepository;

    @Autowired
    private AmostraAguaRepository amostraAguaRepository;

    @Autowired
    private RelatorioRepository relatorioRepository;

    //GET
    @GetMapping
    public ResponseEntity<List<DetalhesRelatorioAmostraDto>> get(Pageable pageable){
        var relatorio = relatorioAmostraRepository.findAll(pageable)
                .stream().map(DetalhesRelatorioAmostraDto::new).toList();
        return ResponseEntity.ok(relatorio);
    }

    //GET BY ID
    @GetMapping("{id}")
    public ResponseEntity<DetalhesRelatorioAmostraDto> get(@PathVariable("id")Long id){
        var relatorio = relatorioAmostraRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesRelatorioAmostraDto(relatorio));
    }


    //DELETE
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        relatorioAmostraRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //POST
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesRelatorioAmostraDto> post(@RequestBody @Valid CadastroRelatorioAmostraDto dto, UriComponentsBuilder builder) {
        var relatorioAmostra = new RelatorioAmostra(dto);
        var amostra = amostraAguaRepository.getReferenceById(dto.idAmostra());
        var relatorio = relatorioRepository.getReferenceById(dto.idRelatorio());

        relatorioAmostra.setAmostraAgua(amostra);
        relatorioAmostra.setRelatorio(relatorio);


        relatorioAmostra = relatorioAmostraRepository.save(relatorioAmostra);
        var uri = builder.path("relatorios-amostra/{id}").buildAndExpand(relatorioAmostra.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesRelatorioAmostraDto(relatorioAmostra));
    }

    //PUT
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesRelatorioAmostraDto> put(@PathVariable("id")Long id,
                                                      @RequestBody @Valid AtualizacaoRelatorioAmostraDto dto){
        var relatorio = relatorioAmostraRepository.getReferenceById(id);
        relatorio.atualizarInformacoesRelatorioAmostra(dto);
        return ResponseEntity.ok(new DetalhesRelatorioAmostraDto(relatorio));
    }
}
