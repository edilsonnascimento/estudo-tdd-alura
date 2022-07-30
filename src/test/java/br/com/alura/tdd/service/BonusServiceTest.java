package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {

    private BonusService service;

    @BeforeEach
    void start() {
        service = new BonusService();
    }

    @Test
    void DEVE_Zerar_Bonus_Quando_Valor_Atingir_Maximo () {
        //given
        var funcionario = new Funcionario("Edilson", LocalDate.now(), new BigDecimal("25000"));
        var expected = new BigDecimal("0.00");

        //when
        var actual = service.calcularBonus(funcionario);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void DEVE_Retornar_Dez_Por_Cento_do_Salario_Acima_Do_Limite_Maximo () {
        //given
        var funcionario = new Funcionario("Edilson", LocalDate.now(), new BigDecimal("2500"));
        var expected = new BigDecimal("250.00");

        //when
        var actual = service.calcularBonus(funcionario);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void DEVE_Retornar_Dez_Por_Cento_do_Salario_No_Limite_Maximo () {
        //given
        var funcionario = new Funcionario("Edilson", LocalDate.now(), new BigDecimal("10000"));
        var expected = new BigDecimal("1000.00");

        //when
        var actual = service.calcularBonus(funcionario);

        //then
        assertEquals(expected, actual);
    }
}