package br.com.mapped.SeaMI.repository;

import br.com.mapped.SeaMI.model.AmostraAgua;
import br.com.mapped.SeaMI.model.Relatorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface RelatorioRepository extends JpaRepository<Relatorio, Long > {

    //pesquisar relatorio por data da criacao
    Page<Relatorio> findByDataCriacao(LocalDateTime dataCriacao, Pageable pageable);

    //buscar relatorio por data de criacao entre duas datas
    Page<Relatorio> findByDataCriacaoBetween(LocalDateTime dataInicio, LocalDateTime dataFim, Pageable pageable);

    //buscar relatorio por data da coleta após uma data
    Page<Relatorio> findByDataCriacaoAfter(LocalDateTime dataColeta, Pageable pageable);

}
