package br.com.mapped.SeaMI.dto.Usuario;

import br.com.mapped.SeaMI.model.Status;
import br.com.mapped.SeaMI.model.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DetalhesUsuarioDto(Long id, String nome, String rg, String cpf, String nacionalidade, String telefone, LocalDate dataNascimento, LocalDateTime dataCadastro, Status status,
                                 String email, String senha) {

    public DetalhesUsuarioDto(Usuario usuario){
        this(
                //Usuario
                usuario.getId(), usuario.getNome(), usuario.getRg(), usuario.getCpf(), usuario.getNacionalidade(), usuario.getTelefone(), usuario.getDataNascimento(), usuario.getDataCadastro(), usuario.getStatus(),

                //Login
                usuario.getLogin().getEmail(), usuario.getLogin().getSenha()
        );

    }

}
