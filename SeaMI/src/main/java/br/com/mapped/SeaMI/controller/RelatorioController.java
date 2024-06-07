package br.com.mapped.SeaMI.controller;

import br.com.mapped.SeaMI.dto.AmostraAgua.DetalhesAmostraAguaDto;
import br.com.mapped.SeaMI.dto.Relatorio.AtualizacaoRelatorioDto;
import br.com.mapped.SeaMI.dto.Relatorio.DetalhesRelatorioDto;
import br.com.mapped.SeaMI.repository.RelatorioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioRepository relatorioRepository;

    //GET
    @GetMapping
    public ResponseEntity<List<DetalhesRelatorioDto>> get(Pageable pageable){
        var relatorio = relatorioRepository.findAll(pageable)
                .stream().map(DetalhesRelatorioDto::new).toList();
        return ResponseEntity.ok(relatorio);
    }

    //GET BY ID
    @GetMapping("{id}")
    public ResponseEntity<DetalhesRelatorioDto> get(@PathVariable("id")Long id){
        var relatorio = relatorioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesRelatorioDto(relatorio));
    }


    //DELETE
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        relatorioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //PUT
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesRelatorioDto> put(@PathVariable("id")Long id,
                                                      @RequestBody @Valid AtualizacaoRelatorioDto dto){
        var relatorio = relatorioRepository.getReferenceById(id);
        relatorio.atualizarInformacoesRelatorio(dto);
        return ResponseEntity.ok(new DetalhesRelatorioDto(relatorio));
    }

    //PESQUISAS
    //pesquisar relatorio por data da criacao
    @GetMapping("por-data-relatorio")
    public ResponseEntity<Page<DetalhesRelatorioDto>> getData(@RequestParam("data") LocalDateTime dataCriacao,
                                                                Pageable pageable){
        var lista = relatorioRepository.findByDataCriacao(dataCriacao,pageable).map(DetalhesRelatorioDto::new);
        return ResponseEntity.ok(lista);
    }

    //pesquisar relatorio por data da criacao entre duas datas
    @GetMapping("por-data")
    public ResponseEntity<Page<DetalhesRelatorioDto>> getBetween(@RequestParam("data-inicio") LocalDateTime dataInicio,
                                                                   @RequestParam("data-fim") LocalDateTime dataFim,
                                                                   Pageable pageable){
        var lista = relatorioRepository.findByDataCriacaoBetween(dataInicio, dataFim, pageable).map(DetalhesRelatorioDto::new);
        return ResponseEntity.ok(lista);
    }

    //pesquisar relatorio por data da criacao após uma data especifica
    @GetMapping("por-data-seguinte")
    public ResponseEntity<Page<DetalhesRelatorioDto>> getAfter(@RequestParam("data-seguinte") LocalDateTime dataCriacao,
                                                                 Pageable pageable){
        var lista = relatorioRepository.findByDataCriacaoAfter(dataCriacao,pageable).map(DetalhesRelatorioDto::new);
        return ResponseEntity.ok(lista);
    }



}
