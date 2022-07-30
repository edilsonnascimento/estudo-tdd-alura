package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Constantes {
    MAX_BONUS(new BigDecimal("1000"));

    public BigDecimal bonus;

    Constantes(BigDecimal bonus) {
        this.bonus = bonus;
    }
}
