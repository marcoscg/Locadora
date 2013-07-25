package com.facisa.Command;

import com.facisa.entidade.Filme;
import com.facisa.fachada.Fachada;

public class NovoFilmeCommand implements Command {
	private Fachada fachada;
	private Filme filme;
	
    public NovoFilmeCommand(Fachada fachada, Filme filme){
        this.fachada = fachada;
        this.filme = filme;
    }	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try {
			fachada.NovoFilme(filme);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
