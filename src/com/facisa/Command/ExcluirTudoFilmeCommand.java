package com.facisa.Command;

import com.facisa.fachada.Fachada;

public class ExcluirTudoFilmeCommand implements Command {
	private Fachada fachada;
	
    public ExcluirTudoFilmeCommand(Fachada fachada){
        this.fachada = fachada;
    }	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try {
			fachada.ExcluirTodoFilme();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
