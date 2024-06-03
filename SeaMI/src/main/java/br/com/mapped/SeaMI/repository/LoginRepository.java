package br.com.mapped.SeaMI.repository;

import br.com.mapped.SeaMI.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long > {
}
