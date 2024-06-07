package br.com.mapped.SeaMI.model;

import br.com.mapped.SeaMI.dto.Filtro.CadastroFiltroDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="TB_GS_LOCALIZACAO_FILTRO")
@EntityListeners(AuditingEntityListener.class)
public class LocalizacaoFiltro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "localizacaoFiltro")
    @SequenceGenerator(name = "localizacaoFiltro", sequenceName = "seq_gs_localizacao_filtro", allocationSize = 1)
    @Column(name="cdLocalizacao", length = 10)
    private Long id;

    @Column(name="nmRio", length = 100, nullable = false)
    private String nomeRio;

    @Column(name="dsLatitude", length = 20, nullable = false)
    private String latitude;

    @Column(name="dsLongitude", length = 20, nullable = false)
    private String longitude;

    @Column(name="dsProfundidade", length = 20, nullable = false)
    private String profundidade;

    //relacionamentos
    //localizacaoFiltro filtro - um pra UM
    @OneToOne
    @JoinColumn(name = "cdFiltro", nullable = false)
    private Filtro filtro;

    public LocalizacaoFiltro(CadastroFiltroDto localizacaoDto) {
        nomeRio = localizacaoDto.nomeRio();
        latitude = localizacaoDto.latitude();
        longitude = localizacaoDto.longitude();
        profundidade = localizacaoDto.profundidade();
    }

}
