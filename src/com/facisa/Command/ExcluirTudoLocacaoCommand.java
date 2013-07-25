package com.facisa.Command;

import com.facisa.fachada.Fachada;

public class ExcluirTudoLocacaoCommand implements Command {
	private Fachada fachada;
	
    public ExcluirTudoLocacaoCommand(Fachada fachada){
        this.fachada = fachada;
    }	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try {
			fachada.ExcluirTodaLocacao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
