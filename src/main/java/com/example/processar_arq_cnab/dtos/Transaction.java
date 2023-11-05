package com.example.processar_arq_cnab.dtos;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public record Transaction(
      Long id,
      Integer type,
      Date date,
      BigDecimal value,
      Long cpf,
      String card,
      Time time,
      String storeOwner,
      String storeName){

    public Transaction withValue(BigDecimal value) {
        return new Transaction(
                this.id(), this.type(), this.date(),
                value,
                this.cpf(), this.card(), this.time(),
                this.storeOwner(), this.storeName());
    }

    public Transaction withDate(String date) throws ParseException{
        var dtFormat = new SimpleDateFormat("yyyyMMdd");
        var dt = dtFormat.parse(date);

        return new Transaction(
                this.id(), this.type(), new Date(dt.getTime()),
                this.value, this.cpf(),
                this.card(), this.time(),
                this.storeOwner(), this.storeName());
    }

    public Transaction withTime(String time) throws ParseException{
        var dtFormat = new SimpleDateFormat("HHmmss");
        var dt = dtFormat.parse(time);

        return new Transaction(
                this.id(), this.type(), this.date(),
                this.value, this.cpf(),
                this.card(), new Time(date.getTime()),
                this.storeOwner(), this.storeName());
    }
}
