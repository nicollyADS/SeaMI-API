package br.com.mapped.SeaMI.repository;

import br.com.mapped.SeaMI.model.AmostraAgua;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AmostraAguaRepository extends JpaRepository<AmostraAgua, Long > {

    //buscar amostra por data da coleta
    Page<AmostraAgua> findByDataColeta(LocalDate dataColeta, Pageable pageable);

    //buscar amostra por data da coleta entre duas datas
    Page<AmostraAgua> findByDataColetaBetween(LocalDate dataInicio, LocalDate dataFim, Pageable pageable);

    //buscar amostra por data da coleta depois de uma data
    Page<AmostraAgua> findByDataColetaAfter(LocalDate dataColeta, Pageable pageable);


}
