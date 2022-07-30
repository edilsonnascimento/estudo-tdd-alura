package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {
    public void calcular(Funcionario funcionario, Desempenho desempenho) {
        desempenho.calcularDesempenho(funcionario);
    }
}
