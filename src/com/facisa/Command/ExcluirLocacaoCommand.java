package com.facisa.Command;

import com.facisa.entidade.Locacao;
import com.facisa.fachada.Fachada;

public class ExcluirLocacaoCommand implements Command {
	private Fachada fachada;
	private Locacao locacao;
	
    public ExcluirLocacaoCommand(Fachada fachada, Locacao locacao){
        this.fachada = fachada;
        this.locacao = locacao;
    }	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try {
			fachada.ExcluirLocacao(locacao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
