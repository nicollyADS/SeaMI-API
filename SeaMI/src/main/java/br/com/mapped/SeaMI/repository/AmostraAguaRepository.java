package br.com.mapped.SeaMI.repository;

import br.com.mapped.SeaMI.model.AmostraAgua;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface AmostraAguaRepository extends JpaRepository<AmostraAgua, Long > {

    //buscar amostra por data da coleta
    Page<AmostraAgua> findByDataColeta(LocalDateTime dataColeta, Pageable pageable);

    //buscar amostra por data da coleta entre duas datas
    Page<AmostraAgua> findByDataColetaBetween(LocalDateTime dataInicio, LocalDateTime dataFim, Pageable pageable);

    //buscar amostra por data da coleta depois de uma data
    Page<AmostraAgua> findByDataColetaAfter(LocalDateTime dataColeta, Pageable pageable);


}
