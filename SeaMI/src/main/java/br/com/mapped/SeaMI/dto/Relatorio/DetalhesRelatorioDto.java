package br.com.mapped.SeaMI.dto.Relatorio;

import br.com.mapped.SeaMI.model.Relatorio;

import java.time.LocalDateTime;

public record DetalhesRelatorioDto(Long id, String nome, String descricao, LocalDateTime dataCriacao) {

    public DetalhesRelatorioDto(Relatorio relatorio) {
        this(relatorio.getId(), relatorio.getNome(), relatorio.getDescricao(), relatorio.getDataCriacao() );
    }

}
