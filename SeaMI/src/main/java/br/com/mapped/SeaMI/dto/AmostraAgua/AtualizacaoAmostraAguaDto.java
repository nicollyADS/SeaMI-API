package br.com.mapped.SeaMI.dto.AmostraAgua;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AtualizacaoAmostraAguaDto (
        @NotNull(message = "A Data da coleta não pode ser nula")
        @PastOrPresent(message = "A Data da coleta deve ser no passado ou presente")
        LocalDateTime dataColeta,

        @NotBlank(message = "O PH não pode estar em branco")
        @Size(max = 15, message = "O PH deve ter no máximo 15 caracteres")
        String ph,

        @NotBlank(message = "Os Poluentes Químicos não podem estar em branco")
        @Size(max = 15, message = "Os Poluentes Químicos devem ter no máximo 15 caracteres")
        String poluentesQuimicos,

        @NotBlank(message = "Os Nutrientes não podem estar em branco")
        @Size(max = 15, message = "Os Nutrientes devem ter no máximo 15 caracteres")
        String nutrientes,

        @NotBlank(message = "A Concentração de Plástico não pode estar em branco")
        @Size(max = 15, message = "A Concentração de Plástico deve ter no máximo 15 caracteres")
        String plastico,

        @NotBlank(message = "O Oxigênio Dissolvido não pode estar em branco")
        @Size(max = 15, message = "O Oxigênio Dissolvido deve ter no máximo 15 caracteres")
        String oxigenioDissolvido,

        @NotBlank(message = "A Temperatura não pode estar em branco")
        @Size(max = 15, message = "A Temperatura deve ter no máximo 15 caracteres")
        String temperatura,

        @NotBlank(message = "A Turbidez não pode estar em branco")
        @Size(max = 15, message = "A Turbidez deve ter no máximo 15 caracteres")
        String turbidez
) {}
