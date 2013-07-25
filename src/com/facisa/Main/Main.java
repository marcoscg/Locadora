package com.facisa.Main;

import java.util.ArrayList;
import java.util.Calendar;

import com.facisa.Command.Command;
import com.facisa.Command.ExcluirClienteCommand;
import com.facisa.Command.ExcluirFilmeCommand;
import com.facisa.Command.ExcluirLocacaoCommand;
import com.facisa.Command.ExcluirTudoClienteCommand;
import com.facisa.Command.NovaLocacaoCommand;
import com.facisa.Command.NovoClienteCommand;
import com.facisa.Command.NovoFilmeCommand;
import com.facisa.Controle.Controle;
import com.facisa.entidade.Cliente;
import com.facisa.entidade.Filme;
import com.facisa.entidade.Locacao;
import com.facisa.fachada.Fachada;
import com.facisa.util.TipoEnum;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fachada fachada = new Fachada();
		
		Cliente cliente = new Cliente();
		cliente.setCpf("51434829502");
		cliente.setNome("Marcos Guimaraes");
		
		Filme filme = new Filme();
		filme.setCodigo(1);
		filme.setTitulo("Filme 1");
		filme.setGenero("Ação");
		filme.setAno(2013);
		filme.setTipo(TipoEnum.DVD);		
		
		Command cmdnovocliente = new NovoClienteCommand(fachada, cliente);
		Command cmdexclircliente = new ExcluirClienteCommand(fachada, cliente);
		Command cmdexclirtudocliente = new ExcluirTudoClienteCommand(fachada);
		
		Controle controle = new Controle();
		
		controle.execute(cmdnovocliente);
		controle.execute(cmdexclircliente);
		//controle.execute(cmdexclirtudocliente);
		
		ArrayList<Cliente> clientes = fachada.ListaCliente();
		
		for (Cliente c : clientes) {  
		    System.out.println(c.getCpf() + " " + c.getNome());   
		} 	
		
		//Filme
		Command cmdnovofilme = new NovoFilmeCommand(fachada, filme);
		Command cmdexcluirfilme = new ExcluirFilmeCommand(fachada, filme);
		
		controle.execute(cmdnovofilme);
		controle.execute(cmdexcluirfilme);
		
		ArrayList<Filme> filmes = fachada.ListaFilme();
		
		for (Filme f : filmes) {  
		    System.out.println(f.getCodigo() + " " + f.getTitulo());   
		}
		
		//Locacao
		filmes = new ArrayList<Filme>();
		filmes.add(filme);	
		
		Locacao locacao = new Locacao();
		locacao.setCodigo(1);
		locacao.setCliente(cliente);	
		locacao.setFilmes(filmes);
		locacao.setDtLocacao(Calendar.getInstance().getTime());
		locacao.setValor(10.00);	
		
		Command cmdnovalocacao = new NovaLocacaoCommand(fachada, locacao);
		Command cmdexcluirlocacao = new ExcluirLocacaoCommand(fachada, locacao);
		
		controle.execute(cmdnovalocacao);
		controle.execute(cmdexcluirlocacao);
		
		ArrayList<Locacao> locacoes = fachada.ListaLocacao();
		
		for (Locacao l : locacoes) {  
		    System.out.println(l.getCodigo() + " " + l.getCliente().toString());   
		}		
		

	}

}
