package br.com.mapped.SeaMI.model;

import br.com.mapped.SeaMI.dto.AmostraAgua.AtualizacaoAmostraAguaDto;
import br.com.mapped.SeaMI.dto.AmostraAgua.CadastroAmostraAguaDto;
import br.com.mapped.SeaMI.dto.Relatorio.AtualizacaoRelatorioDto;
import br.com.mapped.SeaMI.dto.Relatorio.CadastroRelatorioDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="TB_GS_RELATORIO")
@EntityListeners(AuditingEntityListener.class)
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relatorio")
    @SequenceGenerator(name = "relatorio", sequenceName = "seq_gs_relatorio", allocationSize = 1)
    @Column(name="cdRelatorio", length = 10)
    private Long id;

    @Column(name="nmRelatorio", length = 100, nullable = false)
    private String nome;

    @Column(name="dsRelatorio", length = 200, nullable = false)
    private String descricao;

    @CreatedDate
    @Column(name="dtCriacao", nullable = false)
    private LocalDateTime dataCriacao;

    //relacionamentos
    // relatorio relatorioAmostra - um pra muitos
    @OneToMany(mappedBy = "relatorio")
    private List<RelatorioAmostra> relatorioAmostras;

    //relatorio usuario - muitos pra um
    @ManyToOne
    @JoinColumn(name="cdUsuario", nullable = false)
    private Usuario usuario;

    public Relatorio(CadastroRelatorioDto relatorioDto, Usuario usuario) {
        nome = relatorioDto.nome();
        descricao = relatorioDto.descricao();

        //usuario
        this.usuario = usuario;
    }

    public void atualizarInformacoesRelatorio(AtualizacaoRelatorioDto dto) {
        if (dto.nome() != null)
            nome = dto.nome();
        if (dto.descricao() != null)
            descricao = dto.descricao();
    }

}
