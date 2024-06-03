package br.com.mapped.SeaMI.controller;

import br.com.mapped.SeaMI.model.RelatorioAmostra;
import br.com.mapped.SeaMI.repository.RelatorioAmostraRepository;
import br.com.mapped.SeaMI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("relatorios-amostra")
public class RelatorioAmostraController {

    @Autowired
    private RelatorioAmostraRepository relatorioAmostraRepository;
}
