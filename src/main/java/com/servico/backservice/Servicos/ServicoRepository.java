package com.servico.backservice.Servicos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long> {


    @Query("select s from Servico s where s.status = 'PENDENTE'")
    List<Servico>  buscarServicosPagamentoPendente();


    @Query("select s from Servico s where s.status = 'CANCELADO'")
    List<Servico>  buscarServicosCancelados();



}
