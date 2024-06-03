package br.com.mapped.SeaMI.controller;

import br.com.mapped.SeaMI.dto.AmostraAgua.CadastroAmostraAguaDto;
import br.com.mapped.SeaMI.dto.AmostraAgua.DetalhesAmostraAguaDto;
import br.com.mapped.SeaMI.dto.Relatorio.CadastroRelatorioDto;
import br.com.mapped.SeaMI.dto.Relatorio.DetalhesRelatorioDto;
import br.com.mapped.SeaMI.dto.Usuario.AtualizacaoUsuarioDto;
import br.com.mapped.SeaMI.dto.Usuario.CadastroUsuarioDto;
import br.com.mapped.SeaMI.dto.Usuario.DetalhesUsuarioDto;
import br.com.mapped.SeaMI.model.AmostraAgua;
import br.com.mapped.SeaMI.model.Relatorio;
import br.com.mapped.SeaMI.model.Usuario;
import br.com.mapped.SeaMI.repository.AmostraAguaRepository;
import br.com.mapped.SeaMI.repository.RelatorioRepository;
import br.com.mapped.SeaMI.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AmostraAguaRepository amostraAguaRepository;

    @Autowired
    private RelatorioRepository relatorioRepository;


    //GET
    @GetMapping
    public ResponseEntity<List<DetalhesUsuarioDto>> get(Pageable pageable){
        var usuario = usuarioRepository.findAll(pageable)
                .stream().map(DetalhesUsuarioDto::new).toList();
        return ResponseEntity.ok(usuario);
    }

    //GET BY ID
    @GetMapping("{id}")
    public ResponseEntity<DetalhesUsuarioDto> get(@PathVariable("id")Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesUsuarioDto(usuario));
    }

    //POST
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesUsuarioDto> post(@RequestBody @Valid CadastroUsuarioDto usuarioDto,
                                                  UriComponentsBuilder uriBuilder){
        var usuario = new Usuario(usuarioDto);
        usuarioRepository.save(usuario);
        var uri = uriBuilder.path("usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesUsuarioDto(usuario));
    }

    //DELETE
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //PUT
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesUsuarioDto> put(@PathVariable("id")Long id,
                                                  @RequestBody @Valid AtualizacaoUsuarioDto dto){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.atualizarInformacoesUsuario(dto);
        return ResponseEntity.ok(new DetalhesUsuarioDto(usuario));
    }

    //relacionamentos

    //POST AMOSTRA AGUA
    @PostMapping("{id}/amostras-agua")
    @Transactional
    public ResponseEntity<DetalhesAmostraAguaDto> post(@PathVariable("id") Long id,
                                                       @RequestBody @Valid CadastroAmostraAguaDto dto,
                                                       UriComponentsBuilder uriBuilder){
        var usuario = usuarioRepository.getReferenceById(id);
        var amostra = new AmostraAgua(dto, usuario);
        amostraAguaRepository.save(amostra);
        var uri = uriBuilder.path("amostras-agua/{id}").buildAndExpand(amostra.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesAmostraAguaDto(amostra));
    }

    //POST RELATORIO
    @PostMapping("{id}/relatorios")
    @Transactional
    public ResponseEntity<DetalhesRelatorioDto> post(@PathVariable("id") Long id,
                                                     @RequestBody @Valid CadastroRelatorioDto dto,
                                                     UriComponentsBuilder uriBuilder){
        var usuario = usuarioRepository.getReferenceById(id);
        var relatorio = new Relatorio(dto, usuario);
        relatorioRepository.save(relatorio);
        var uri = uriBuilder.path("relatorios/{id}").buildAndExpand(relatorio.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesRelatorioDto(relatorio));
    }








}
