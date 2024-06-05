package br.com.mapped.SeaMI.repository;

import br.com.mapped.SeaMI.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //buscar usuario por nome
    Page<Usuario> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    //buscar usuario por cpf
    Page<Usuario> findByCpfEquals(String cpf, Pageable pageable);
}
