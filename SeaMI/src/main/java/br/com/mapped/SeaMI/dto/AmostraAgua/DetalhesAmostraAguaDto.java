package br.com.mapped.SeaMI.dto.AmostraAgua;

import br.com.mapped.SeaMI.model.AmostraAgua;

import java.time.LocalDateTime;

public record DetalhesAmostraAguaDto (Long id, LocalDateTime dataColeta, String ph, String poluentesQuimicos, String nutrientes, String plastico, String oxigenioDissolvido, String temperatura, String turbidez) {

    public DetalhesAmostraAguaDto(AmostraAgua amostraAgua) {
        this(
                amostraAgua.getId(), amostraAgua.getDataColeta(), amostraAgua.getPh(), amostraAgua.getPoluentesQuimicos(), amostraAgua.getNutrientes(), amostraAgua.getPlastico(), amostraAgua.getOxigenioDissolvido(),
                amostraAgua.getTemperatura(), amostraAgua.getTurbidez()
        );
    }
}
