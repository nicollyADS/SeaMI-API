package br.com.mapped.SeaMI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="TB_GS_RELATORIO_AMOSTRA")
@EntityListeners(AuditingEntityListener.class)
public class RelatorioAmostra {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relatorioAmostra")
    @SequenceGenerator(name = "relatorioAmostra", sequenceName = "seq_gs_relatorio_amostra", allocationSize = 1)
    @Column(name="cdRelatorioAmostra", length = 10)
    private Long id;

    @Column(name="dsRelatorioAmostra", length = 200, nullable = false)
    private String descricao;

}


