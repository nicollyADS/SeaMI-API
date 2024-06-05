package br.com.mapped.SeaMI.repository;

import br.com.mapped.SeaMI.model.Filtro;
import br.com.mapped.SeaMI.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiltroRepository extends JpaRepository<Filtro, Long > {
    //buscar filtro por tipo
    Page<Filtro> findByTipoIgnoreCase(String tipo, Pageable pageable);

    //buscar filtro por status
    Page<Filtro> findByStatusIgnoreCase(String status, Pageable pageable);

}
