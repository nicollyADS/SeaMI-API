package br.com.mapped.SeaMI.controller;

import br.com.mapped.SeaMI.dto.AmostraAgua.AtualizacaoAmostraAguaDto;
import br.com.mapped.SeaMI.dto.AmostraAgua.DetalhesAmostraAguaDto;
import br.com.mapped.SeaMI.repository.AmostraAguaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("amostras-agua")
public class AmostraAguaController {

    @Autowired
    private AmostraAguaRepository amostraAguaRepository;

    //GET
    @GetMapping
    public ResponseEntity<List<DetalhesAmostraAguaDto>> get(Pageable pageable){
        var amostra = amostraAguaRepository.findAll(pageable)
                .stream().map(DetalhesAmostraAguaDto::new).toList();
        return ResponseEntity.ok(amostra);
    }

    //GET BY ID
    @GetMapping("{id}")
    public ResponseEntity<DetalhesAmostraAguaDto> get(@PathVariable("id")Long id){
        var amostra = amostraAguaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesAmostraAguaDto(amostra));
    }


    //DELETE
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        amostraAguaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //PUT
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesAmostraAguaDto> put(@PathVariable("id")Long id,
                                                 @RequestBody @Valid AtualizacaoAmostraAguaDto dto){
        var amostra = amostraAguaRepository.getReferenceById(id);
        amostra.atualizarInformacoesAmostraAgua(dto);
        return ResponseEntity.ok(new DetalhesAmostraAguaDto(amostra));
    }


}
