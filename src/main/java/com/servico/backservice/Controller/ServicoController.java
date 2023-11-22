package com.servico.backservice.Controller;

import com.servico.backservice.Servicos.Servico;
import com.servico.backservice.Servicos.ServicoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired  
    private ServicoService service;


    @GetMapping("/listar")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Servico> buscarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/pendente")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Servico> buscarServicosPagamentosPendente(){
        return service.buscarServicosPagamentoPendente();
    }

    @GetMapping("/cancelados")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Servico> buscarServicosCancelados(){
        return service.buscarServicoServicosCancelados();
    }

    @PostMapping("/cadastrar")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Servico inserir(@RequestBody Servico servico){
        return service.inserir(servico);
    }

    @PostMapping("/cancelar/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Void> cancelar(@PathVariable("id") Long id){
        service.cancelarServico(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/alterar")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Servico alterar(@RequestBody Servico servico){
        return service.alterar(servico);
    }



    @DeleteMapping("/deletar/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Void> remover(@PathVariable("id") Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }


}
