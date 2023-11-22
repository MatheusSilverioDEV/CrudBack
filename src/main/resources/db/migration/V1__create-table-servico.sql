CREATE TABLE servico (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome_cliente VARCHAR(255) NOT NULL,
    data_inicio DATE NULL,
    data_termino DATE NULL,
    descricao_servico VARCHAR(255) NOT NULL,
    valor_servico DOUBLE NOT NULL,
    valor_pago DOUBLE NULL,
    data_pagamento DATE NULL,
    status ENUM('PENDENTE', 'REALIZADO', 'CANCELADO') NOT NULL,
    PRIMARY KEY (id)
);