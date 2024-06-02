package br.com.mapped.SeaMI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="TB_GS_AMOSTRA_AGUA")
@EntityListeners(AuditingEntityListener.class)
public class AmostraAgua {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amostraAgua")
    @SequenceGenerator(name = "amostraAgua", sequenceName = "seq_gs_amostra_agua", allocationSize = 1)
    @Column(name="cdAmostra", length = 10)
    private Long id;

    @Column(name="dtColeta", nullable = false)
    private LocalDateTime dataColeta;

    @Column(name="dsPH", length = 15, nullable = false)
    private String ph;

    @Column(name="dsPoluentesQuimicos", length = 15, nullable = false)
    private String poluentesQuimicos;

    @Column(name="dsNutrientes", length = 15, nullable = false)
    private String nutrientes;

    @Column(name="dsConcentracaoPlastico", length = 15, nullable = false)
    private String plastico;

    @Column(name="dsOxigenioDissolvido", length = 15, nullable = false)
    private String oxigenioDissolvido;

    @Column(name="dsTemperatura", length = 15, nullable = false)
    private String temperatura;

    @Column(name="dsTurbidez", length = 15, nullable = false)
    private String turbidez;


    //relacionamentos
    //amostraAgua usuario - muitos pra um
    @ManyToOne
    @JoinColumn(name="cdUsuario", nullable = false)
    private Usuario usuario;

    //amostraAgua filtro - um pra muitos
    @OneToMany(mappedBy = "amostraAgua")
    private List<Filtro> filtros;

    //amostraAgua relatorioAmostra - um pra muitos
    @OneToMany(mappedBy = "amostraAgua")
    private List<RelatorioAmostra> relatorioAmostras;

}
