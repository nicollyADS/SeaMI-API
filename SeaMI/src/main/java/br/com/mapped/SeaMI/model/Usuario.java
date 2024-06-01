package br.com.mapped.SeaMI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="TB_GS_USUARIO")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    @SequenceGenerator(name = "usuario", sequenceName = "seq_gs_usuario", allocationSize = 1)
    @Column(name="cdUsuario", length = 10)
    private Long id;

    @Column(name="nmUsuario", length = 100, nullable = false)
    private String nome;

    @Column(name="nrRG", length = 15, nullable = false)
    private String rg;

    @Column(name="nrCpf", length = 15, nullable = false)
    private String cpf;

    @Column(name="dsNacionalidade", length = 50, nullable = false)
    private String nacionalidade;

    @Column(name="nrTelefone", length = 15, nullable = false)
    private String telefone;

    @Column(name="dtNascimento", nullable = false)
    private LocalDate dataNascimento;

    @CreatedDate
    @Column(name="dtCadastro", nullable = false)
    private LocalDateTime dataCadastro;

}
