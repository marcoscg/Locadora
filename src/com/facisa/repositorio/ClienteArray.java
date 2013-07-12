package com.facisa.repositorio;

import java.util.ArrayList;

import com.facisa.entidade.Cliente;
import com.facisa.util.ValidaCPF;

public class ClienteArray {
	
	private ArrayList<Cliente> clienteList;		
	
	public ClienteArray() {
		this.clienteList = new ArrayList<Cliente>();
	}

	public void Novo(Cliente cliente) throws Exception {
		
		ValidaCPF cpf = new ValidaCPF();
		
		if (!cpf.isCPF(cliente.getCpf())) {
			throw new Exception("CPF inválido!");	
		}
		
		if (cliente.getNome().equals("")) {		
			throw new Exception("Nome não pode ser vazio!");
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
