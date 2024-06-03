package br.com.mapped.SeaMI.model;

import br.com.mapped.SeaMI.dto.Filtro.AtualizacaoFiltroDto;
import br.com.mapped.SeaMI.dto.Filtro.CadastroFiltroDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="TB_GS_FILTRO")
@EntityListeners(AuditingEntityListener.class)
public class Filtro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filtro")
    @SequenceGenerator(name = "filtro", sequenceName = "seq_gs_filtro", allocationSize = 1)
    @Column(name="cdFiltro", length = 10)
    private Long id;

    @Column(name="tpFiltro", length = 50, nullable = false)
    private String tipo;

    @Column(name="dsFiltro", length = 200, nullable = false)
    private String descricao;

    @Column(name="dtInstalacao", nullable = false)
    private LocalDateTime dataInstalacao;

    @Column(name="stFiltro", length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="dtManutencao")
    private LocalDateTime dataManutencao;


    //relacionamentos
    //filtro amostraAgua - muitos pra um
    @ManyToOne
    @JoinColumn(name="cdAmostra", nullable = false)
    private AmostraAgua amostraAgua;

    //filtro localizacaoFiltro - UM pra um
    @OneToOne(mappedBy = "filtro", cascade = CascadeType.ALL)
    private LocalizacaoFiltro localizacaoFiltro;

    public Filtro(CadastroFiltroDto filtroDto) {
        tipo = filtroDto.tipo();
        descricao = filtroDto.descricao();
        dataInstalacao = filtroDto.dataInstalacao();
        status = filtroDto.status();
        dataManutencao= filtroDto.dataManutencao();

        //localizacao filtro
        localizacaoFiltro = new LocalizacaoFiltro(filtroDto);
        localizacaoFiltro.setFiltro(this);
    }

    public void atualizarInformacoesFiltro(AtualizacaoFiltroDto dto) {
        if (dto.tipo() != null)
            tipo = dto.tipo();
        if (dto.descricao() != null)
            descricao = dto.descricao();
        if (dto.dataInstalacao() != null)
            dataInstalacao = dto.dataInstalacao();
        if (dto.status() != null)
            status = dto.status();
        if (dto.dataManutencao() != null)
            dataManutencao = dto.dataManutencao();

        //carteirinha
        if (dto.nomeRio() != null)
            this.localizacaoFiltro.setNomeRio(dto.nomeRio());
        if (dto.latitude() != null)
            this.localizacaoFiltro.setLatitude(dto.latitude());
        if (dto.longitude() != null)
            this.localizacaoFiltro.setLongitude(dto.longitude());
        if (dto.profundidade() != null)
            this.localizacaoFiltro.setProfundidade(dto.profundidade());

    }

}
