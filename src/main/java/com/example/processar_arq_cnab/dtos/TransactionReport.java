package com.example.processar_arq_cnab.dtos;

import java.math.BigDecimal;
import java.util.List;

public record TransactionReport(
        String nomeLoja,
        BigDecimal total,
        List<Transaction> transactions) {

    public TransactionReport addTotal(BigDecimal valor) {
        return new TransactionReport(nomeLoja, total.add(valor), transactions);
    }

    public TransactionReport addTransaction(Transaction transaction){
        transactions.add(transaction);
        return new TransactionReport(nomeLoja, total, transactions);
    }
}
