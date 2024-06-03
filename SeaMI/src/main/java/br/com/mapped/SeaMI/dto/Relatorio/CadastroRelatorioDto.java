package br.com.mapped.SeaMI.dto.Relatorio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroRelatorioDto(
        @NotBlank(message = "O Nome do relatório não pode estar em branco")
        @Size(max = 100, message = "O Nome do relatório deve ter no máximo 100 caracteres")
        String nome,

        @NotBlank(message = "A Descrição do relatório não pode estar em branco")
        @Size(max = 200, message = "A Descrição do relatório deve ter no máximo 200 caracteres")
        String descricao
) {
}
