package br.com.mapped.SeaMI.dto.Usuario;

import br.com.mapped.SeaMI.model.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CadastroUsuarioDto(
        @NotBlank(message = "O Nome do usuário não pode estar em branco")
        @Size(max = 100, message = "O Nome do usuário deve ter no máximo 100 caracteres")
        String nome,

        @NotBlank(message = "O RG não pode estar em branco")
        @Size(max = 15, message = "O RG deve ter no máximo 15 caracteres")
        String rg,

        @NotBlank(message = "O CPF não pode estar em branco")
        @Size(max = 15, message = "O CPF deve ter no máximo 15 caracteres")
        String cpf,

        @NotBlank(message = "A Nacionalidade não pode estar em branco")
        @Size(max = 50, message = "A Nacionalidade deve ter no máximo 50 caracteres")
        String nacionalidade,

        @NotBlank(message = "O Telefone não pode estar em branco")
        @Size(max = 15, message = "O Telefone deve ter no máximo 15 caracteres")
        String telefone,

        @NotNull(message = "A Data de nascimento não pode ser nula")
        LocalDate dataNascimento,


        @NotNull(message = "O Status não pode ser nulo")
        Status status,

        //Login
        @NotBlank(message = "O Email não pode estar em branco")
        @Size(max = 100, message = "O Email deve ter no máximo 100 caracteres")
        @Email(message = "O Email deve ser válido")
        String email,

        @NotBlank(message = "A Senha não pode estar em branco")
        @Size(max = 15, message = "A Senha deve ter no máximo 15 caracteres")
        String senha

) {
}
