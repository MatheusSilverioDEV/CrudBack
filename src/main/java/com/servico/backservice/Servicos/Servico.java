package com.servico.backservice.Servicos;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "servico")
@Data
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCliente;

    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio = new Date();

    @Column(name = "data_termino")
    @Temporal(TemporalType.DATE)
    private Date dataTermino;

    @Column(name = "descricao_servico")
    private String descricaoServico;

    @Column(name = "valor_servico")
    private Double valorServico;

    @Column(name = "valor_pago")
    private Double valorPago;

    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

    @Enumerated(EnumType.STRING)
    private Status status;







}