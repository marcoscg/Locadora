package com.facisa.fachada;

import java.util.ArrayList;

import com.facisa.entidade.Cliente;
import com.facisa.entidade.Filme;
import com.facisa.repositorio.ClienteArray;
import com.facisa.repositorio.FilmeArray;

public class Fachada {
	
	public void NovoCliente(Cliente cliente) throws Exception {		
		ClienteArray.getInstance().Novo(cliente);		
	}
	
	public ArrayList<Cliente> ListaCliente() {		
		return ClienteArray.getInstance().Listar();		
	}

	public void ExcluirCliente(Cliente cliente) throws Exception {
		ClienteArray.getInstance().Excluir(cliente);
		
	}
	
	public void ExcluirTodoCliente() {
		ClienteArray.getInstance().ExcluirTudo();
		
	}
	
	public void NovoFilme(Filme filme) throws Exception {		
		FilmeArray.getInstance().Novo(filme);		
	}
	
	public ArrayList<Filme> ListaFilme() {		
		return FilmeArray.getInstance().Listar();		
	}

	public void ExcluirFilme(Filme filme) throws Exception {
		FilmeArray.getInstance().Excluir(filme);
		
	}
	
	public void ExcluirTodoFilme() {
		FilmeArray.getInstance().ExcluirTudo();
		
	}	
	
	

}
