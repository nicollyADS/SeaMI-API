package br.com.mapped.SeaMI.dto.Filtro;

import br.com.mapped.SeaMI.model.LocalizacaoFiltro;

public record DetalhesLocalizacaoFiltro(Long idLocalizacaoFiltro, String nomeRio, String latitude, String longitude, String profundidade) {

    public DetalhesLocalizacaoFiltro(LocalizacaoFiltro localizacao) {
        this(
                localizacao.getId(), localizacao.getNomeRio(), localizacao.getLatitude(), localizacao.getLongitude(), localizacao.getProfundidade()
        );

    }

}
