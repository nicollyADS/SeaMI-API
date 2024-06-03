package br.com.mapped.SeaMI.controller;

import br.com.mapped.SeaMI.dto.Filtro.AtualizacaoFiltroDto;
import br.com.mapped.SeaMI.dto.Filtro.CadastroFiltroDto;
import br.com.mapped.SeaMI.dto.Filtro.DetalhesFiltroDto;
import br.com.mapped.SeaMI.model.Filtro;
import br.com.mapped.SeaMI.repository.FiltroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("filtros")
public class FiltroController {

    @Autowired
    private FiltroRepository filtroRepository;

    //GET
    @GetMapping
    public ResponseEntity<List<DetalhesFiltroDto>> get(Pageable pageable){
        var filtro = filtroRepository.findAll(pageable)
                .stream().map(DetalhesFiltroDto::new).toList();
        return ResponseEntity.ok(filtro);
    }

    //GET BY ID
    @GetMapping("{id}")
    public ResponseEntity<DetalhesFiltroDto> get(@PathVariable("id")Long id){
        var filtro = filtroRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesFiltroDto(filtro));
    }

    //POST
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesFiltroDto> post(@RequestBody @Valid CadastroFiltroDto filtroDto,
                                                  UriComponentsBuilder uriBuilder){
        var filtro = new Filtro(filtroDto);
        filtroRepository.save(filtro);
        var uri = uriBuilder.path("filtros/{id}").buildAndExpand(filtro.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesFiltroDto(filtro));
    }

    //DELETE
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        filtroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //PUT
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesFiltroDto> put(@PathVariable("id")Long id,
                                                 @RequestBody @Valid AtualizacaoFiltroDto dto){
        var filtro = filtroRepository.getReferenceById(id);
        filtro.atualizarInformacoesFiltro(dto);
        return ResponseEntity.ok(new DetalhesFiltroDto(filtro));
    }

}
