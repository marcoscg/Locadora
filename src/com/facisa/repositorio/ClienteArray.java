package com.facisa.repositorio;

import java.util.ArrayList;

import com.facisa.entidade.Cliente;

public class ClienteArray {
	
	private ArrayList<Cliente> clienteList;		
	
	public ClienteArray() {
		this.clienteList = new ArrayList<Cliente>();
	}

	public void Novo(Cliente cliente) throws Exception {
		
		if (cliente.getNome().length() <= 3) {		
			throw new Exception("Tem que ter mais do que 3 caracteres...");
		}		
		
		clienteList.add(cliente);	
		
	}
	
	public int Tamanho() {
		
		return clienteList.size();
		
	}
	
	public ArrayList<Cliente> Listar() {
		
		return clienteList;
		
	}
	

}
