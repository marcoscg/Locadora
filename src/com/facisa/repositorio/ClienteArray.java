package com.facisa.repositorio;

import java.util.ArrayList;

import com.facisa.entidade.Cliente;

public class ClienteArray {
	
	private ArrayList<Cliente> clienteList;		
	
	public ClienteArray() {
		this.clienteList = new ArrayList<Cliente>();
	}

	public void Novo(Cliente cliente) {	
		
		clienteList.add(cliente);	
		
	}
	
	public int Tamanho() {
		
		return clienteList.size();
		
	}
	
	public ArrayList<Cliente> Listar() {
		
		return clienteList;
		
	}
	

}
