package br.com.mapped.SeaMI.repository;

import br.com.mapped.SeaMI.model.LocalizacaoFiltro;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoFiltroRepository extends JpaRepository<LocalizacaoFiltro, Long > {

    //pesquisar localizacao por latitude e longitude
    Page<LocalizacaoFiltro> findByLatitudeAndLongitude(String latitude, String longitude, Pageable pageable);
}
