package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR{
        @Override
        public void calcularDesempenho(Funcionario funcionario) {
            ajustarSalarioPara(funcionario, new BigDecimal("0.03"));
        }
    },
    BOM{
        @Override
        public void calcularDesempenho(Funcionario funcionario) {
            ajustarSalarioPara(funcionario, new BigDecimal("0.15"));
        }
    },
    OTIMO{
        @Override
        public void calcularDesempenho(Funcionario funcionario) {
            ajustarSalarioPara(funcionario, new BigDecimal("0.2"));
        }
    };

    public abstract void calcularDesempenho(Funcionario funcionario);

    private static void ajustarSalarioPara(Funcionario funcionario, BigDecimal percentual) {
        var reajuste = funcionario.getSalario().multiply(percentual);
        funcionario.reajustarSalario(reajuste);
    }
}