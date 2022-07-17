package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

    // Essa foi a minha resolução
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {

        BigDecimal reajuste = BigDecimal.ZERO;

        switch (desempenho) {
            case A_DESEJAR:
                reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
            break;
            case BOM:
                reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
            break;
            case OTIMO:
                reajuste = funcionario.getSalario().multiply(new BigDecimal("0.2"));
            break;        
            default:
                // Chamar uma execeção quando não tiver o parametro de desempenho
            break;
        }

        funcionario.reajustarSalario(reajuste);
    }

    //Essa foi resolução do curso
    public void concederReajusteAlura(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal reajuste = funcionario.getSalario().multiply(desempenho.percentual());
        funcionario.reajustarSalario(reajuste);
    }

}
