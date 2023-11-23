package com.example.processar_arq_cnab.repositories;

import com.example.processar_arq_cnab.dtos.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    //select * from transaction order by nome_loja asc, id desc
    List<Transaction> findAllByOrderByNomeLojaAscIdDesc();

}
