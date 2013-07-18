package com.facisa.entidade;

import java.util.ArrayList;
import java.util.Date;

public class Locacao {
	
	private int codigo;
	private Cliente cliente;
	private ArrayList<Filme> filmes;
	private Date dtLocacao;
	private Date dtDevolucao;
	private Double valor;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ArrayList<Filme> getFilmes() {
		return filmes;
	}
	
	public void setFilmes(ArrayList<Filme> filmes) {
		this.filmes = filmes;
	}
	
	public Date getDtLocacao() {
		return dtLocacao;
	}
	
	public void setDtLocacao(Date dtLocacao) {
		this.dtLocacao = dtLocacao;
	}
	
	public Date getDtDevolucao() {
		return dtDevolucao;
	}
	
	public void setDtDevolucao(Date dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + codigo;
		result = prime * result
				+ ((dtDevolucao == null) ? 0 : dtDevolucao.hashCode());
		result = prime * result
				+ ((dtLocacao == null) ? 0 : dtLocacao.hashCode());
		result = prime * result + ((filmes == null) ? 0 : filmes.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Locacao other = (Locacao) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (codigo != other.codigo)
			return false;
		if (dtDevolucao == null) {
			if (other.dtDevolucao != null)
				return false;
		} else if (!dtDevolucao.equals(other.dtDevolucao))
			return false;
		if (dtLocacao == null) {
			if (other.dtLocacao != null)
				return false;
		} else if (!dtLocacao.equals(other.dtLocacao))
			return false;
		if (filmes == null) {
			if (other.filmes != null)
				return false;
		} else if (!filmes.equals(other.filmes))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	
}
