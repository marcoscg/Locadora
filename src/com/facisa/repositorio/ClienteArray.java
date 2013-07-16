package com.facisa.repositorio;

import java.util.ArrayList;

import com.facisa.entidade.Cliente;
import com.facisa.util.ValidaCPF;

public class ClienteArray {
	
	private static ClienteArray instance;
	
	private ArrayList<Cliente> clienteList;	
	
	private ClienteArray() {
		this.clienteList = new ArrayList<Cliente>();
	}
	
	public static ClienteArray getInstance() {
		
		if (instance == null) {
			instance = new ClienteArray();
		}
		
		return instance;
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
	
	public void Excluir(Cliente cliente) throws Exception {
		
		int index = clienteList.indexOf(cliente);
		
		if (index == -1) {
			throw new Exception("Cliente não encontrado!");
		}		
		
		clienteList.remove(index);		
	}
	
	public void ExcluirTudo() {
		
		clienteList.removeAll(clienteList);
		
	}	
	
	public ArrayList<Cliente> Listar() {
		
		return clienteList;
		
	}
	

}
