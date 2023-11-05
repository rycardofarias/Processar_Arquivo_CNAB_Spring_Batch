package com.example.processar_arq_cnab.dtos;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Date;

public record Transaction(Integer type,
                          Date date,
                          BigDecimal value,
                          Long cpf,
                          String card,
                          Time time,
                          String storeOwner,
                          String storeName){
}
