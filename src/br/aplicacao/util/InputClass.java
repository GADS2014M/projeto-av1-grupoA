package br.aplicacao.util;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputClass {
	private Scanner sc;

	public InputClass() {
		this.sc = new Scanner(System.in);
	}

	public String nextString() {
		return sc.nextLine();
	}

	public int nextInt() {
		return sc.nextInt();
	}

	public Double nextDouble() {
		return sc.nextDouble();
	}

	public BigDecimal nextBigDecimal() {
		return sc.nextBigDecimal();
	}

}
