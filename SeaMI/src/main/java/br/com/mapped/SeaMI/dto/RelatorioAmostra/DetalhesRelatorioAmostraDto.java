package br.com.mapped.SeaMI.dto.RelatorioAmostra;
import br.com.mapped.SeaMI.model.RelatorioAmostra;

public record DetalhesRelatorioAmostraDto(Long id, String descricaoAmostra, Long idAmostra, Long idRelatorio) {

        DetalhesRelatorioAmostraDto(RelatorioAmostra relatorioAmostra) {
                this(relatorioAmostra.getId(), relatorioAmostra.getDescricaoAmostra(),relatorioAmostra.getAmostraAgua().getId(),relatorioAmostra.getRelatorio().getId()

                );

        }
}
