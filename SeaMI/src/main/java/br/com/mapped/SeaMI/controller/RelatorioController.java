package br.com.mapped.SeaMI.controller;

import br.com.mapped.SeaMI.model.Relatorio;
import br.com.mapped.SeaMI.repository.RelatorioRepository;
import br.com.mapped.SeaMI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioRepository relatorioRepository;
}
