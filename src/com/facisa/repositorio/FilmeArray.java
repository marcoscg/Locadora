package com.facisa.repositorio;

import java.util.ArrayList;

import com.facisa.entidade.Filme;

public class FilmeArray {
	
	private static FilmeArray instance;
	
	private ArrayList<Filme> filmeList;	
	
	private FilmeArray() {
		this.filmeList = new ArrayList<Filme>();
	}
	
	public static FilmeArray getInstance() {
		
		if (instance == null) {
			instance = new FilmeArray();
		}
		
		return instance;
	}

	public void Novo(Filme filme) throws Exception {
		
		if (filme.getCodigo() == 0) {		
			throw new Exception("Filme sem código!");
		}		
		
		filmeList.add(filme);
		
	}
	
	public void Excluir(Filme filme) throws Exception {
		
		int index = filmeList.indexOf(filme);
		
		if (index == -1) {
			throw new Exception("Cliente não encontrado!");
		}		
		
		filmeList.remove(index);		
	}
	
	public void ExcluirTudo() {
		
		filmeList.removeAll(filmeList);
		
	}	
	
	public ArrayList<Filme> Listar() {
		
		return filmeList;
		
	}	

}
