package br.com.mapped.SeaMI.model;

import br.com.mapped.SeaMI.dto.Usuario.AtualizacaoUsuarioDto;
import br.com.mapped.SeaMI.dto.Usuario.CadastroUsuarioDto;
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

    @Column(name="stUsuario", length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    //relacionamentos
    // usuario login - UM pra um
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Login login;

    //usuario amostraAgua - um pra muitos
    @OneToMany(mappedBy = "usuario")
    private List<AmostraAgua> amostraAguas;

    //usuario relatorio - um pra muitos
    @OneToMany(mappedBy = "usuario")
    private List<Relatorio> relatorios;

    public Usuario(CadastroUsuarioDto usuarioDto) {
        //usuario
        nome = usuarioDto.nome();
        rg = usuarioDto.rg();
        cpf = usuarioDto.cpf();
        nacionalidade = usuarioDto.nacionalidade();
        telefone = usuarioDto.telefone();
        dataNascimento = usuarioDto.dataNascimento();
        status = usuarioDto.status();

        //login
        login = new Login(usuarioDto);
        login.setUsuario(this);
    }

    public void atualizarInformacoesUsuario(AtualizacaoUsuarioDto dto) {
        //usuario
        if (dto.nome() != null)
            nome = dto.nome();
        if (dto.rg() != null)
            rg = dto.rg();
        if (dto.cpf() != null)
            cpf = dto.cpf();
        if (dto.nacionalidade() != null)
            nacionalidade = dto.nacionalidade();
        if (dto.telefone() != null)
            telefone = dto.telefone();
        if (dto.dataNascimento() != null)
            dataNascimento = dto.dataNascimento();
        if (dto.status() != null)
            status = dto.status();

        //login
        if (dto.email() != null)
            this.login.setEmail(dto.email());
        if (dto.senha() != null)
            this.login.setSenha(dto.senha());

    }

}
