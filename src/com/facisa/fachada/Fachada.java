package com.facisa.fachada;

import java.util.ArrayList;

import com.facisa.entidade.Cliente;
import com.facisa.entidade.Filme;
import com.facisa.entidade.Locacao;
import com.facisa.repositorio.ClienteArray;
import com.facisa.repositorio.FilmeArray;
import com.facisa.repositorio.LocacaoArray;

public class Fachada {
	
	//Cliente
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
	
	//Filme
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
	
	//Locacao
	public void NovaLocacao(Locacao locacao) throws Exception {		
		LocacaoArray.getInstance().Novo(locacao);		
	}
	
	public ArrayList<Locacao> ListaLocacao() {		
		return LocacaoArray.getInstance().Listar();		
	}

	public void ExcluirLocacao(Locacao locacao) throws Exception {
		LocacaoArray.getInstance().Excluir(locacao);
		
	}
	
	public void ExcluirTodaLocacao() {
		LocacaoArray.getInstance().ExcluirTudo();
		
	}	
	

}
