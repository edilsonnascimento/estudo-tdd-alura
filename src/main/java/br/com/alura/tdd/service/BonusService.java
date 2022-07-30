package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.exception.EstudoTddAluraExpcetion;
import br.com.alura.tdd.modelo.Constantes;
import br.com.alura.tdd.modelo.Funcionario;

import static br.com.alura.tdd.modelo.Constantes.MAX_BONUS;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) throws EstudoTddAluraExpcetion {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new EstudoTddAluraExpcetion("Valor do bonus acima do limite maximo de " + MAX_BONUS);
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}
}
