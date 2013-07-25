package com.facisa.Command;

import com.facisa.entidade.Filme;
import com.facisa.fachada.Fachada;

public class ExcluirFilmeCommand implements Command {
	private Fachada fachada;
	private Filme filme;
	
    public ExcluirFilmeCommand(Fachada fachada, Filme filme){
        this.fachada = fachada;
        this.filme = filme;
    }	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try {
			fachada.ExcluirFilme(filme);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
