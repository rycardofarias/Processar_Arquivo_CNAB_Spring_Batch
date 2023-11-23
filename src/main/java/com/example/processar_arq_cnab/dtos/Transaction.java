package com.example.processar_arq_cnab.dtos;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public record Transaction(

      @Id Long id,
      Integer tipo,
      Date data,
      BigDecimal valor,
      Long cpf,
      String cartao,
      Time hora,
      @Column ("DONO_LOJA") String donoLoja,
      @Column ("NOME_LOJA") String nomeLoja){

    public Transaction withValue(BigDecimal valor) {
        return new Transaction(
                id, tipo, data,
                valor,
                cpf, cartao, hora,
                donoLoja, nomeLoja);
    }

    public Transaction withDate(String date) throws ParseException{
        var dtFormat = new SimpleDateFormat("yyyyMMdd");
        var dt = dtFormat.parse(date);

        return new Transaction(
                id, tipo, new Date(dt.getTime()),
                valor, cpf,
                cartao, hora,
                donoLoja, nomeLoja);
    }

    public Transaction withTime(String time) throws ParseException{
        var dtFormat = new SimpleDateFormat("HHmmss");
        var dt = dtFormat.parse(time);

        return new Transaction(
                id, tipo, data,
                valor, cpf,
                cartao, new Time(data.getTime()),
                donoLoja, nomeLoja);
    }
}
