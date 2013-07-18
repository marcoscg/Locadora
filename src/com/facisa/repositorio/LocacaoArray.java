package com.facisa.repositorio;

import java.util.ArrayList;

import org.hamcrest.core.IsNull;

import com.facisa.entidade.Locacao;

public class LocacaoArray {
	
	private static LocacaoArray instance;
	
	private ArrayList<Locacao> locacaoList;	
	
	private LocacaoArray() {
		this.locacaoList = new ArrayList<Locacao>();
	}
	
	public static LocacaoArray getInstance() {
		
		if (instance == null) {
			instance = new LocacaoArray();
		}
		
		return instance;
	}

	public void Novo(Locacao locacao) throws Exception {
		
		if (locacao.getCliente() == null) {
			throw new Exception("Cliente n�o encontrado!");	
		}
		
		if (locacao.getFilmes() == null) {
			throw new Exception("Filmes n�o encontrado!");	
		}
		
		if (locacao.getDtLocacao() == null) {
			throw new Exception("Data de loca��o n�o informada!");
		}		
		
		if (locacao.getValor() == null || locacao.getValor() == 0) {
			throw new Exception("Valor n�o informado!");
		}		
		
		locacaoList.add(locacao);
		
	}
	
	public void Excluir(Locacao locacao) throws Exception {
		
		int index = locacaoList.indexOf(locacao);
		
		if (index == -1) {
			throw new Exception("Cliente n�o encontrado!");
		}		
		
		locacaoList.remove(index);		
	}
	
	public void ExcluirTudo() {
		
		locacaoList.removeAll(locacaoList);
		
	}	
	
	public ArrayList<Locacao> Listar() {
		
		return locacaoList;
		
	}		

}
