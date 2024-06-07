package br.com.mapped.SeaMI.dto.Filtro;

import br.com.mapped.SeaMI.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AtualizacaoFiltroDto (
        @NotBlank(message = "O Tipo de filtro não pode estar em branco")
        @Size(max = 50, message = "O Tipo de filtro deve ter no máximo 50 caracteres")
        String tipo,

        @NotBlank(message = "A Descrição do filtro não pode estar em branco")
        @Size(max = 200, message = "A Descrição do filtro deve ter no máximo 200 caracteres")
        String descricao,

        @NotNull(message = "A Data de instalação não pode ser nula")
        LocalDateTime dataInstalacao,

        @NotNull(message = "O Status não pode ser nulo e deve conter ATIVO ou INATIVO")
        Status status,

        LocalDateTime dataManutencao,

        @NotNull(message = "O id da Amostra não pode ser nulo")
        Long idAmostra,

        //LocalizacaoFiltro
        @NotBlank(message = "O Nome do rio não pode estar em branco")
        @Size(max = 100, message = "O Nome do rio deve ter no máximo 100 caracteres")
        String nomeRio,

        @NotBlank(message = "A Latitude não pode estar em branco")
        @Size(max = 20, message = "A Latitude deve ter no máximo 20 caracteres")
        String latitude,

        @NotBlank(message = "A Longitude não pode estar em branco")
        @Size(max = 20, message = "A Longitude deve ter no máximo 20 caracteres")
        String longitude,

        @NotBlank(message = "A Profundidade não pode estar em branco")
        @Size(max = 20, message = "A Profundidade deve ter no máximo 20 caracteres")
        String profundidade
) {
}
