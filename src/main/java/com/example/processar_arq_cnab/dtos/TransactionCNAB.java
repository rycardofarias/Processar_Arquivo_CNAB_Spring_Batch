package com.example.processar_arq_cnab.dtos;

import java.math.BigDecimal;

public record TransactionCNAB(
    Integer tipo,
    String data,
    BigDecimal valor,
    Long cpf,
    String cartao,
    String hora,
    String donoLoja,
    String nomeLoja){

}
