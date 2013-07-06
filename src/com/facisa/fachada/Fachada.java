package com.facisa.fachada;

import java.util.ArrayList;

import com.facisa.entidade.Cliente;
import com.facisa.repositorio.ClienteArray;

public class Fachada {
	
	private ClienteArray clienteArray;
	
	public Fachada() {
		
		this.clienteArray = new ClienteArray();
		
	}

	public void NovoCliente(Cliente cliente) {		
		
		clienteArray.Novo(cliente);		
	}
	
	public int TamanhoCliente() {
		
		return clienteArray.Tamanho();
		
	}
	
	public ArrayList<Cliente> ListaCliente() {
		
		return clienteArray.Listar();
		
	}
	
	

}
