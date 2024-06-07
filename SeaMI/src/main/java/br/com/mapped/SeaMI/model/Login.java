package br.com.mapped.SeaMI.model;

import br.com.mapped.SeaMI.dto.Usuario.CadastroUsuarioDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="TB_GS_LOGIN")
@EntityListeners(AuditingEntityListener.class)
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login")
    @SequenceGenerator(name = "login", sequenceName = "seq_gs_login", allocationSize = 1)
    @Column(name="cdLogin", length = 10)
    private Long id;

    @Column(name="dsEmail", length = 100, nullable = false)
    private String email;

    @Column(name="dsSenha", length = 15, nullable = false)
    private String senha;

    //relacionamentos
    //login usuario - um pra UM
    @OneToOne
    @JoinColumn(name = "cdUsuario", nullable = false)
    private Usuario usuario;

    public Login(CadastroUsuarioDto loginDto) {
        email = loginDto.email();
        senha = loginDto.senha();
    }
}
