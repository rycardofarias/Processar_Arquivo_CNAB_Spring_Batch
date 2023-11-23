package com.example.processar_arq_cnab.services;

import com.example.processar_arq_cnab.dtos.Transaction;
import com.example.processar_arq_cnab.dtos.TransactionReport;
import com.example.processar_arq_cnab.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionReport> listTotalTransactionsByStoreName() {
        var transactions = transactionRepository.findAllByOrderByNomeLojaAscIdDesc();

        var reportMap =  new LinkedHashMap<String, TransactionReport>();

        transactions.forEach(transaction -> {
            String storeName = transaction.nomeLoja();
            BigDecimal valor = transaction.valor();

            reportMap.compute(storeName, (key, existingReport) ->{
                var report = (existingReport != null) ? existingReport
                        : new TransactionReport(key, BigDecimal.ZERO, new ArrayList<>());
                return report.addTotal(valor).addTransacao(transaction);
            });
        });
        return new ArrayList<>(reportMap.values());
    }
}
