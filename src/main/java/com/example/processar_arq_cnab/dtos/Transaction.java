package com.example.processar_arq_cnab.dtos;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public record Transaction(
      Long id,
      Integer tipo,
      Date data,
      BigDecimal valor,
      Long cpf,
      String cartao,
      Time hora,
      String donoLoja,
      String nomeLoja){

    public Transaction withValue(BigDecimal valor) {
        return new Transaction(
                this.id(), this.tipo(), this.data(),
                valor,
                this.cpf(), this.cartao(), this.hora(),
                this.donoLoja(), this.nomeLoja());
    }

    public Transaction withDate(String date) throws ParseException{
        var dtFormat = new SimpleDateFormat("yyyyMMdd");
        var dt = dtFormat.parse(date);

        return new Transaction(
                this.id(), this.tipo(), new Date(dt.getTime()),
                this.valor, this.cpf(),
                this.cartao(), this.hora(),
                this.donoLoja(), this.nomeLoja());
    }

    public Transaction withTime(String time) throws ParseException{
        var dtFormat = new SimpleDateFormat("HHmmss");
        var dt = dtFormat.parse(time);

        return new Transaction(
                this.id(), this.tipo(), this.data(),
                this.valor, this.cpf(),
                this.cartao(), new Time(data.getTime()),
                this.donoLoja(), this.nomeLoja());
    }
}
