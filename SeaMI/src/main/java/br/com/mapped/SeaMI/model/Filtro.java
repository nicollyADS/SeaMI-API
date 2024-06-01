package br.com.mapped.SeaMI.model;

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

}
