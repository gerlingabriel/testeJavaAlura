package br.com.alura.tdd.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Funcionario {

	private String nome;
	private LocalDate dataAdmissao;
	private BigDecimal salario;

	public Funcionario(String nome, LocalDate dataAdmissao, BigDecimal salario) {
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

    public void reajustarSalario(BigDecimal valorAdiconar) {
		this.salario = this.salario.add(valorAdiconar);
		arredendamento();
    }

	// Métodos privados não deve ser testado, o que é testado é método public
	// Dentro so public está será validados esses métodod privados
	private void arredendamento() {
		this.salario = this.salario.setScale(2, RoundingMode.HALF_UP);
	}

}
