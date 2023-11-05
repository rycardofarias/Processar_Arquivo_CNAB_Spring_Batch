package com.example.processar_arq_cnab.dtos;

import java.math.BigDecimal;

public record TransactionCNAB(
    Integer type,
    String date,
    BigDecimal value,
    Long cpf,
    String card,
    String time,
    String storeOwner,
    String storeName){

}
