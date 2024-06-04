package br.com.mapped.SeaMI.model;

import br.com.mapped.SeaMI.dto.Relatorio.AtualizacaoRelatorioDto;
import br.com.mapped.SeaMI.dto.Relatorio.CadastroRelatorioDto;
import br.com.mapped.SeaMI.dto.RelatorioAmostra.AtualizacaoRelatorioAmostraDto;
import br.com.mapped.SeaMI.dto.RelatorioAmostra.CadastroRelatorioAmostraDto;
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
    private String descricaoAmostra;

    //relacionamentos
    //relatorioAmostra amostraAgua - muitos pra um
    @ManyToOne
    @JoinColumn(name="cdAmostra", nullable = false)
    private AmostraAgua amostraAgua;

    //relatorioAmostra relatorio - muitos pra um
    @ManyToOne
    @JoinColumn(name="cdRelatorio", nullable = false)
    private Relatorio relatorio;

    public RelatorioAmostra(CadastroRelatorioAmostraDto relatorioAmostraDto) {
        descricaoAmostra = relatorioAmostraDto.descricaoAmostra();
    }

    public void atualizarInformacoesRelatorioAmostra(AtualizacaoRelatorioAmostraDto dto) {
        if (dto.descricaoAmostra() != null)
            descricaoAmostra = dto.descricaoAmostra();
    }

}


