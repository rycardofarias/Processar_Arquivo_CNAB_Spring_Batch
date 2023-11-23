package com.example.processar_arq_cnab.controllers;

import com.example.processar_arq_cnab.dtos.Transaction;
import com.example.processar_arq_cnab.dtos.TransactionReport;
import com.example.processar_arq_cnab.services.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transacoes")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    List<TransactionReport> listAll() {
        return transactionService.listTotalTransactionsByStoreName();
    }
}
