package com.servico.backservice.Servicos;


import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    private Status status;


    public List<Servico> buscarTodos(){
        return repository.findAll();
    }

    public List<Servico> buscarServicosPagamentoPendente(){
        return repository.buscarServicosPagamentoPendente();
    }

    public List<Servico> buscarServicoServicosCancelados(){
        return repository.buscarServicosCancelados();
    }

    public Servico inserir(Servico servico){
        if (servico.getValorPago() == null || servico.getValorPago() == 0 || servico.getDataPagamento() == null){
            servico.setStatus(status.PENDENTE);
        }else{
            servico.setStatus(status.REALIZADO);
        }
        return repository.saveAndFlush(servico);
    }

    public Servico alterar(Servico servico){
        if (servico.getValorPago() != null && servico.getValorPago() > 0 && servico.getDataPagamento() != null){
            servico.setStatus(status.REALIZADO);
        }
            return repository.saveAndFlush(servico);
    }

    public void cancelarServico(Long id){
        Servico servico = repository.findById(id).get();
        servico.setStatus(Status.CANCELADO);
        repository.save(servico);
    }

    public void excluir(Long id){
        Servico servico = repository.findById(id).get();
        repository.delete(servico);
        servico.setStatus(status.CANCELADO);
    }


}
