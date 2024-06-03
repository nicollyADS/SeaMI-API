package br.com.mapped.SeaMI.dto.Filtro;

import br.com.mapped.SeaMI.model.Filtro;
import br.com.mapped.SeaMI.model.Status;

import java.time.LocalDateTime;

public record DetalhesFiltroDto (Long id, String tipo, String descricao, LocalDateTime dataInstalacao, Status status, LocalDateTime dataManutencao,
                                 Long idLocalizacaoFiltro, String nomeRio, String latitude, String longitude, String profundidade) {

    public DetalhesFiltroDto(Filtro filtro) {

        this(
                //Filtro
                filtro.getId(), filtro.getTipo(), filtro.getDescricao(), filtro.getDataInstalacao(), filtro.getStatus(), filtro.getDataManutencao(),

                //LocalizacaoFiltro
                filtro.getLocalizacaoFiltro().getId(), filtro.getLocalizacaoFiltro().getNomeRio(), filtro.getLocalizacaoFiltro().getLatitude(),
                filtro.getLocalizacaoFiltro().getLongitude(), filtro.getLocalizacaoFiltro().getProfundidade()

        );
    }
}
