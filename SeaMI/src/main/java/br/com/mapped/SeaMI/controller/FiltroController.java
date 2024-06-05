package br.com.mapped.SeaMI.controller;

import br.com.mapped.SeaMI.dto.AmostraAgua.DetalhesAmostraAguaDto;
import br.com.mapped.SeaMI.dto.Filtro.AtualizacaoFiltroDto;
import br.com.mapped.SeaMI.dto.Filtro.CadastroFiltroDto;
import br.com.mapped.SeaMI.dto.Filtro.DetalhesFiltroDto;
import br.com.mapped.SeaMI.dto.Filtro.DetalhesLocalizacaoFiltro;
import br.com.mapped.SeaMI.dto.Usuario.DetalhesUsuarioDto;
import br.com.mapped.SeaMI.model.Filtro;
import br.com.mapped.SeaMI.model.Status;
import br.com.mapped.SeaMI.repository.AmostraAguaRepository;
import br.com.mapped.SeaMI.repository.FiltroRepository;
import br.com.mapped.SeaMI.repository.LocalizacaoFiltroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("filtros")
public class FiltroController {

    @Autowired
    private FiltroRepository filtroRepository;

    @Autowired
    private AmostraAguaRepository amostraAguaRepository;

    @Autowired
    private LocalizacaoFiltroRepository localizacaoFiltroRepository;

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
    public ResponseEntity<DetalhesFiltroDto> post(@RequestBody @Valid CadastroFiltroDto dto, UriComponentsBuilder builder) {
        var filtro = new Filtro(dto);
        var amostraAgua = amostraAguaRepository.getReferenceById(dto.idAmostra());

        filtro.setAmostraAgua(amostraAgua);

        filtro = filtroRepository.save(filtro);
        var uri = builder.path("filtros/{id}").buildAndExpand(filtro.getId()).toUri();
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

    //PESQUISAS

    //pesquisar filtro por tipo
    @GetMapping("por-tipo")
    public ResponseEntity<Page<DetalhesFiltroDto>> getTipo(@RequestParam("tipo") String tipo,
                                                                Pageable pageable){
        var lista = filtroRepository.findByTipoIgnoreCase(tipo,pageable).map(DetalhesFiltroDto::new);
        return ResponseEntity.ok(lista);
    }

    //pesquisar filtro por status
    @GetMapping("por-status")
    public ResponseEntity<Page<DetalhesFiltroDto>> getStatus(@RequestParam("tipo") String status,
                                                           Pageable pageable){
        var lista = filtroRepository.findByStatusIgnoreCase(status,pageable).map(DetalhesFiltroDto::new);
        return ResponseEntity.ok(lista);
    }

    //pesquisar localizacao por latitude e longitude
    @GetMapping("por-localizacao")
    public ResponseEntity<Page<DetalhesLocalizacaoFiltro>> getLocalizacao(@RequestParam("latitude") String latitude,
                                                                          @RequestParam("longitude") String longitude,
                                                                          Pageable pageable){
        var lista = localizacaoFiltroRepository.findByLatitudeAndLongitude(latitude, longitude, pageable).map(DetalhesLocalizacaoFiltro::new);
        return ResponseEntity.ok(lista);
    }
}
