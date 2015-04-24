package cliente;

import loja.Loja;
import loja.menu.MenuTerminal;

public class Ford {
	private Loja loja = new Loja();

	
	public static void main(String[] args) {
		
		Ford rioDeJaneiro = new Ford();
		
		new MenuTerminal(rioDeJaneiro.getLoja());
		
	}
	
	
	
	// get e set
	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	
	

}
