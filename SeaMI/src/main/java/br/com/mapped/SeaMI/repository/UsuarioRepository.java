package br.com.mapped.SeaMI.repository;

import br.com.mapped.SeaMI.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
