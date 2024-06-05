package br.com.mapped.SeaMI.repository;

import br.com.mapped.SeaMI.model.Filtro;
import br.com.mapped.SeaMI.model.Status;
import br.com.mapped.SeaMI.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiltroRepository extends JpaRepository<Filtro, Long > {
    //buscar filtro por tipo
    Page<Filtro> findByTipoContainingIgnoreCase(String tipo, Pageable pageable);

}
