package br.com.mapped.SeaMI.dto.RelatorioAmostra;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AtualizacaoRelatorioAmostraDto(
        @NotBlank(message = "A Descrição do relatório não pode estar em branco")
        @Size(max = 200, message = "A Descrição do relatório deve ter no máximo 200 caracteres")
        String descricaoAmostra,

        @NotNull(message = "O id da Amostra não pode ser nulo")
        Long idAmostra,

        @NotNull(message = "O id do Relatório não pode ser nulo")
        Long idRelatorio
){
}
