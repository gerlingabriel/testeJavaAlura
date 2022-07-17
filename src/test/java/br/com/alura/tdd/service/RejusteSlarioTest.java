package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class RejusteSlarioTest {

    private Funcionario funcionario;
    private Funcionario funcionario2;
    private ReajusteService reajusteService;

    @BeforeEach
    public void init(){
        this.funcionario = new Funcionario("Rodrigo", LocalDate.of(2022, 02, 01), new BigDecimal(1000));
        this.funcionario2 = new Funcionario("Rodrigo", LocalDate.of(2022, 02, 01), new BigDecimal(1000));
        this.reajusteService = new ReajusteService();
    }

    @Test
    public void deveReajustarSalarioComPerfomaceADesejar() {

        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        reajusteService.concederReajusteAlura(funcionario2, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
        assertEquals(new BigDecimal("1030.00"), funcionario2.getSalario());
    }

    @Test
    public void deveReajustarSalarioComPerfomaceBom() {

        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        reajusteService.concederReajusteAlura(funcionario2, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
        assertEquals(new BigDecimal("1150.00"), funcionario2.getSalario());
    }

    @Test
    public void deveReajustarSalarioComPerfomaceOtimo() {

        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        reajusteService.concederReajusteAlura(funcionario2, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
        assertEquals(new BigDecimal("1200.00"), funcionario2.getSalario());
    }
    
}
