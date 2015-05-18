package br.aplicacao.util;

import java.io.PrintStream;

public class OutputClass {
	private String message;
	private PrintStream mode;

	/**
	 * configura uma messagem normal por padrão
	 * 
	 * @param message
	 */
	public OutputClass() {
		this.mode = System.out;
	}

	public OutputClass(String message) {
		this();
		this.message = message;
	}

	public void mostra() {
		mode.println(this.message);
	}

	public OutputClass mostraTexto(String message) {
		this.message = message;
		this.mostra();
		return this;
	}
	
	public OutputClass next(String message) {
		this.message = message;
		this.mostra();
		return this;
	}

	public void erroMode(Boolean status) {
		if (status)
			this.mode = System.err;
		else
			this.mode = System.out;
	}

	public void mostraErro() {
		erroMode(true);
		mode.println(this.message);
		erroMode(false);
	}

}
