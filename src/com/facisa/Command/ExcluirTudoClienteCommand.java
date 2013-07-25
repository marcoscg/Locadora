package com.facisa.Command;

import com.facisa.fachada.Fachada;

public class ExcluirTudoClienteCommand implements Command {

	private Fachada fachada;
	
    public ExcluirTudoClienteCommand(Fachada fachada){
        this.fachada = fachada;
    }	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try {
			fachada.ExcluirTodoCliente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
}
