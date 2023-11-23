package com.example.processar_arq_cnab.services;

import com.example.processar_arq_cnab.dtos.Transaction;
import com.example.processar_arq_cnab.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> listTotalTransactionsByStoreName() {
        var transaction = transactionRepository.findAllByOrderByNomeLojaAscIdDesc();
        return transaction;
    }
}
