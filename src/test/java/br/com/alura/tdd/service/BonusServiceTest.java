package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusServiceTest {

    @Test
    public void deveLancarExcecaoQuandoSalarioMaiorMil(){

        BonusService service = new BonusService();

        assertThrows(IllegalAccessException.class, 
            () -> service.calcularBonus(
            new Funcionario("Rodrigo", LocalDate.of(2022, 02, 01), new BigDecimal(10001))) );

        // Outra abordagem para pegar erro e as vezes comparar a mensagem
        // try {
        //     service.calcularBonus(new Funcionario("Rodrigo", LocalDate.of(2022, 02, 01), new BigDecimal(10001)) );
        //     fail("Exceção não chamada!")
        // } catch (Exception e) {
        //     assertEquals("Funcionário não pode receber bonus!", e.getMessage());
        // }
    }

    @Test
    public void deveTerBonus() throws IllegalAccessException{

        BonusService service = new BonusService();

        BigDecimal bonus = service.calcularBonus(
            new Funcionario("Rodrigo", LocalDate.of(2022, 02, 01), new BigDecimal(2500)));

        assertEquals(new BigDecimal(250).setScale(2), bonus);
    }

    @Test
    public void deveDarBonusQuandoForIgualARegra() throws IllegalAccessException{

        BonusService service = new BonusService();

        BigDecimal bonus = service.calcularBonus(
            new Funcionario("Rodrigo", LocalDate.of(2022, 02, 01), new BigDecimal(10000)));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
    
}
