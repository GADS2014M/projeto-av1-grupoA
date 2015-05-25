package br.aplicacao;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ModelScanner {
    private final Scanner scanner;
    private final PrintStream out;
    
    //construtor 
    public ModelScanner(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }
    // askInt
    public int askInt() {
        return scanner.nextInt();
    }
    
    //askLine
    
    public String askLine(){
    	return scanner.nextLine();
    }
   
    
}