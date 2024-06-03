package br.com.mapped.SeaMI.controller;

import br.com.mapped.SeaMI.dto.Usuario.DetalhesUsuarioDto;
import br.com.mapped.SeaMI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;



}
