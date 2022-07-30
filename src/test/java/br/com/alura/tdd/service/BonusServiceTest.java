package br.com.alura.tdd.service;

import br.com.alura.tdd.exception.EstudoTddAluraExpcetion;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static br.com.alura.tdd.modelo.Constantes.MAX_BONUS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    private BonusService service;
    private Funcionario funcionario;

    @BeforeEach
    void start() {
        this.service = new BonusService();
        this.funcionario = new Funcionario("Edilson", LocalDate.now(), new BigDecimal("10000"));
    }

    @Test
    void DEVE_Lancar_Exception_Quando_Valor_Bonus_Acima_Do_Limite_Maximo () {
        //given
        funcionario.setSalario(new BigDecimal("25000"));
        var expected = "Valor do bonus acima do limite maximo de " + MAX_BONUS;

        //when
        var excepetion = assertThrows(EstudoTddAluraExpcetion.class, ()-> service.calcularBonus(funcionario));
        var actual = excepetion.getMessage();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void DEVE_Retornar_Dez_Por_Cento_do_Salario_Abaixo_Do_Limite_Maximo () {
        //given
        funcionario.setSalario(new BigDecimal("2500"));
        var expected = new BigDecimal("250.00");

        //when
        var actual = service.calcularBonus(funcionario);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void DEVE_Retornar_Dez_Por_Cento_do_Salario_No_Limite_Maximo () {
        //given
        var expected = new BigDecimal("1000.00");

        //when
        var actual = service.calcularBonus(funcionario);

        //then
        assertEquals(expected, actual);
    }
}