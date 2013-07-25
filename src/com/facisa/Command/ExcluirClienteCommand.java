package com.facisa.Command;

import com.facisa.entidade.Cliente;
import com.facisa.fachada.Fachada;

public class ExcluirClienteCommand implements Command {

	private Fachada fachada;
	private Cliente cliente;
	
    public ExcluirClienteCommand(Fachada fachada, Cliente cliente){
        this.fachada = fachada;
        this.cliente = cliente;
    }	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try {
			fachada.ExcluirCliente(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
