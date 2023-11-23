package com.example.processar_arq_cnab.enuns;

import java.math.BigDecimal;

public enum TypeTransaction {
    DEBITO(1), BOLETO(2), FINANCIAMENTO(3),
    CREDITO(4), RECEBIMENTO_EMPRESTIMO(5), VENDAS(6),
    RECEBIMENTO_TED(7), RECEBIMENTO_DOC(8), ALUGUEL(9);

    private int type;

    private TypeTransaction(int type) {
        this.type = type;
    }

    // Similar to Strategy Pattern
    public BigDecimal getSinal() {
        return switch (type) {
            case 1, 4, 5, 6, 7, 8 -> new BigDecimal(1);
            case 2, 3, 9 -> new BigDecimal(-1);
            default -> new BigDecimal(0);
        };
    }

    public static TypeTransaction findByType(int type) {
        for (TypeTransaction typeTransaction: values()) {
            if (typeTransaction.type == type) {
                return typeTransaction;
            }
        }
        throw new IllegalArgumentException("Invalid type: " + type);
    }
}