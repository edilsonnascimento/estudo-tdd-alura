package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static br.com.alura.tdd.modelo.Desempenho.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    void start() {
        service = new ReajusteService();
        funcionario = new Funcionario("Edilson", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    void DEVE_Reajustar_Salrio_Para_Tres_Por_Cento_QUANDO_Desempenho_For_a_Desejar() {
        //given
        var expetectd = new BigDecimal("1030.00");

        //when
        service.calcular(funcionario, A_DESEJAR);
        var actual = funcionario.getSalario();

        //then
        assertEquals(expetectd, actual);
    }

    @Test
    void DEVE_Reajustar_Salrio_Para_Quinze_Por_Cento_QUANDO_Desempenho_For_Bom() {
        //given
        var expetectd = new BigDecimal("1150.00");

        //when
        service.calcular(funcionario, BOM);
        var actual = funcionario.getSalario();

        //then
        assertEquals(expetectd, actual);
    }

    @Test
    void DEVE_Reajustar_Salrio_Para_Vinte_Por_Cento_QUANDO_Desempenho_For_Otimo() {
        //given
        var expetectd = new BigDecimal("1200.00");

        //when
        service.calcular(funcionario, OTIMO);
        var actual = funcionario.getSalario();

        //then
        assertEquals(expetectd, actual);
    }
}