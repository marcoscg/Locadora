package com.facisa.Command;

import com.facisa.entidade.Locacao;
import com.facisa.fachada.Fachada;

public class NovaLocacaoCommand implements Command {
	private Fachada fachada;
	private Locacao locacao;
	
    public NovaLocacaoCommand(Fachada fachada, Locacao locacao){
        this.fachada = fachada;
        this.locacao = locacao;
    }	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try {
			fachada.NovaLocacao(locacao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
