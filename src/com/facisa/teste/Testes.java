package com.facisa.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.facisa.Command.Command;
import com.facisa.Command.ExcluirClienteCommand;
import com.facisa.Command.ExcluirFilmeCommand;
import com.facisa.Command.ExcluirLocacaoCommand;
import com.facisa.Command.ExcluirTudoClienteCommand;
import com.facisa.Command.ExcluirTudoFilmeCommand;
import com.facisa.Command.ExcluirTudoLocacaoCommand;
import com.facisa.Command.NovaLocacaoCommand;
import com.facisa.Command.NovoClienteCommand;
import com.facisa.Command.NovoFilmeCommand;
import com.facisa.Controle.Controle;
import com.facisa.entidade.Cliente;
import com.facisa.entidade.Endereco;
import com.facisa.entidade.Filme;
import com.facisa.entidade.Locacao;
import com.facisa.fachada.Fachada;
import com.facisa.util.TipoEnum;
import com.facisa.util.ValidaCPF;

public class Testes {

	private Fachada fachada;
	private Controle controle;
	
	@Before
	public void setUp() throws Exception {
		this.fachada = new Fachada();	
		this.controle = new Controle();
		
		Command cmdexclirtudocliente = new ExcluirTudoClienteCommand(fachada);
		Command cmdexclirtudoFilme = new ExcluirTudoFilmeCommand(fachada);
		Command cmdexclirtudoLocacao = new ExcluirTudoLocacaoCommand(fachada);
		
		controle.execute(cmdexclirtudocliente);
		controle.execute(cmdexclirtudoFilme);
		controle.execute(cmdexclirtudoLocacao);
	}
	
	@Test
	public void testCPFValido() {		
		ValidaCPF cpf = new ValidaCPF();
		
		assertTrue(cpf.isCPF("51434829502"));
		assertTrue(cpf.isCPF("87431154380"));
		assertTrue(cpf.isCPF("63356030124"));		
	}
	
	@Test
	public void testCPFInvalido() {		
		ValidaCPF cpf = new ValidaCPF();		
		
		assertFalse(cpf.isCPF("51434829501"));	
		assertFalse(cpf.isCPF("87431154381"));
		assertFalse(cpf.isCPF("63356030121"));
		assertFalse(cpf.isCPF(""));
	}	
	
	@Test
	public void testCriarFachada() {		
		assertNotNull(fachada);
	}

	@Test
	public void testUmNovoCliente() throws Exception {		
		Cliente cliente = new Cliente();
		cliente.setCpf("51434829502");
		cliente.setNome("Marcos Guimaraes");
		cliente.setEndereco(enderecoPadrao());
		
		Command cmdnovocliente = new NovoClienteCommand(fachada, cliente);
		controle.execute(cmdnovocliente);
		
		ArrayList<Cliente> clientes = fachada.ListaCliente();
		
		assertEquals(1, clientes.size());
		assertEquals(cliente, clientes.get(0));		
	}
	
	@Test
	public void testDoisNovosClientes() throws Exception {		
		Cliente cliente = new Cliente();
		cliente.setCpf("51434829502");
		cliente.setNome("Telma Moreira");	
		cliente.setEndereco(enderecoPadrao());
		
		Cliente cliente1 = new Cliente();
		cliente1.setCpf("87431154380");
		cliente1.setNome("Daniel Pereira");	
		cliente1.setEndereco(enderecoPadrao());
		
		Command cmdnovocliente = new NovoClienteCommand(fachada, cliente);
		Command cmdnovocliente1 = new NovoClienteCommand(fachada, cliente1);
		
		controle.execute(cmdnovocliente);	
		controle.execute(cmdnovocliente1);
		
		ArrayList<Cliente> clientes = fachada.ListaCliente();
		
		assertEquals(2, clientes.size());
		assertEquals(cliente, clientes.get(0));
		assertEquals(cliente1, clientes.get(1));			
	}	
	
	@Test
	public void testExcluirCliente() throws Exception {	
		
		Cliente cliente = new Cliente();
		cliente.setCpf("51434829502");
		cliente.setNome("Marcos Guimaraes");
		cliente.setEndereco(enderecoPadrao());
		
		Cliente cliente1 = new Cliente();
		cliente1.setCpf("87431154380");
		cliente1.setNome("Adriana Pereira");
		cliente1.setEndereco(enderecoPadrao());
		
		Cliente cliente2 = new Cliente();
		cliente2.setCpf("63356030124");
		cliente2.setNome("Roberto Silva");
		cliente2.setEndereco(enderecoPadrao());
		
		Command cmdnovocliente = new NovoClienteCommand(fachada, cliente);
		Command cmdnovocliente1 = new NovoClienteCommand(fachada, cliente1);
		Command cmdnovocliente2 = new NovoClienteCommand(fachada, cliente2);
		
		controle.execute(cmdnovocliente);	
		controle.execute(cmdnovocliente1);
		controle.execute(cmdnovocliente2);
		
		ArrayList<Cliente> clientes = fachada.ListaCliente();
		
		assertEquals(3, clientes.size());
		assertEquals(cliente, clientes.get(0));
		assertEquals(cliente1, clientes.get(1));
		assertEquals(cliente2, clientes.get(2));
		
		Command cmdexclircliente = new ExcluirClienteCommand(fachada, cliente);
		Command cmdexclircliente2 = new ExcluirClienteCommand(fachada, cliente2);
		
		controle.execute(cmdexclircliente);	
		controle.execute(cmdexclircliente2);
		
		clientes = fachada.ListaCliente();
		
		assertEquals(1, clientes.size());		
		assertEquals(cliente1, clientes.get(0));	
	}	
	
	@Test
	public void testExcluirTodoCliente() throws Exception {	
		
		Cliente cliente = new Cliente();
		cliente.setCpf("51434829502");
		cliente.setNome("Marcos Guimaraes");
		cliente.setEndereco(enderecoPadrao());
		
		Cliente cliente1 = new Cliente();
		cliente1.setCpf("87431154380");
		cliente1.setNome("Adriana Pereira");
		cliente1.setEndereco(enderecoPadrao());
		
		Cliente cliente2 = new Cliente();
		cliente2.setCpf("63356030124");
		cliente2.setNome("Roberto Silva");
		cliente2.setEndereco(enderecoPadrao());		
		
		Command cmdnovocliente = new NovoClienteCommand(fachada, cliente);
		Command cmdnovocliente1 = new NovoClienteCommand(fachada, cliente1);
		Command cmdnovocliente2 = new NovoClienteCommand(fachada, cliente2);
		
		controle.execute(cmdnovocliente);	
		controle.execute(cmdnovocliente1);
		controle.execute(cmdnovocliente2);
		
		ArrayList<Cliente> clientes = fachada.ListaCliente();
		
		assertEquals(3, clientes.size());
		assertEquals(cliente, clientes.get(0));
		assertEquals(cliente1, clientes.get(1));
		assertEquals(cliente2, clientes.get(2));
		
		Command cmdexclirtudocliente = new ExcluirTudoClienteCommand(fachada);
		
		controle.execute(cmdexclirtudocliente);
		
		clientes = fachada.ListaCliente();
		
		assertEquals(0, clientes.size());		
	}
	
	@Test(expected=Exception.class)
	public void testCPFVazio() throws Exception {
		
		Cliente cliente = new Cliente();
		cliente.setCpf("");
		cliente.setNome("Marcos");
		
		fachada.NovoCliente(cliente);		
	}	
	
	@Test(expected=Exception.class)
	public void testNomeVazio() throws Exception {
		
		Cliente cliente = new Cliente();
		cliente.setCpf("63356030124");
		cliente.setNome("");
		
		fachada.NovoCliente(cliente);		
	}	
	
	@Test(expected=Exception.class)
	public void testClienteNaoExiste() throws Exception {
		
		Cliente cliente = new Cliente();
		cliente.setCpf("63356030124");
		cliente.setNome("Marcos Guimaraes");
		
		Cliente cliente1 = new Cliente();
		cliente1.setCpf("87431154380");
		cliente1.setNome("Juliana");		
		
		fachada.NovoCliente(cliente);
		
		fachada.ExcluirCliente(cliente1);
		
	}
	
	@Test
	public void testUmNovoFilme() throws Exception {		
		
		Filme filme = filmeDVDPadrao();	
		
		Command cmdnovofilme = new NovoFilmeCommand(fachada, filme);
		
		controle.execute(cmdnovofilme);
		
		ArrayList<Filme> filmes = fachada.ListaFilme();
		
		assertEquals(1, filmes.size());
		assertEquals(filme, filmes.get(0));		
	}
	
	@Test
	public void testExcluirFilme() throws Exception {		
		
		Filme filme = filmeDVDPadrao();		

		Command cmdnovofilme = new NovoFilmeCommand(fachada, filme);
		
		controle.execute(cmdnovofilme);
		
		ArrayList<Filme> filmes = fachada.ListaFilme();
		
		assertEquals(1, filmes.size());
		assertEquals(filme, filmes.get(0));
		
		Command cmdexcluirfilme = new ExcluirFilmeCommand(fachada, filme);
		
		controle.execute(cmdexcluirfilme);
		
		filmes = fachada.ListaFilme();
		
		assertEquals(0, filmes.size());
		
	}
	
	@Test(expected=Exception.class)
	public void testSemCodigoFilme() throws Exception {
		
		Filme filme = new Filme();
		filme.setTitulo("Filme 1");
		filme.setGenero("Ação");
		filme.setAno(2013);
		filme.setTipo(TipoEnum.DVD);
		
		fachada.NovoFilme(filme);		
	}	
	
	@Test(expected=Exception.class)
	public void testFilmeNaoExiste() throws Exception {
		
		Filme filme = filmeDVDPadrao();
		
		Filme filme1 = filmeBLURAYPadrao();

		fachada.NovoFilme(filme);
		
		fachada.ExcluirFilme(filme1);
		
	}	
	
	@Test
	public void testUmaNovaLocacao() throws Exception {		
		
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		filmes.add(filmeDVDPadrao());
		filmes.add(filmeBLURAYPadrao());		
		
		Locacao locacao = new Locacao();
		locacao.setCodigo(1);
		locacao.setCliente(clientePadrao());	
		locacao.setFilmes(filmes);
		locacao.setDtLocacao(Calendar.getInstance().getTime());
		locacao.setValor(10.00);
		
		Command cmdnovalocacao = new NovaLocacaoCommand(fachada, locacao);
		
		controle.execute(cmdnovalocacao);
		
		ArrayList<Locacao> locacoes = fachada.ListaLocacao();
		
		assertEquals(1, locacoes.size());
		assertEquals(locacao, locacoes.get(0));		
	}
	
	@Test
	public void testExcluirLocacao() throws Exception {		
		
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		filmes.add(filmeDVDPadrao());
		filmes.add(filmeBLURAYPadrao());		
		
		Locacao locacao = new Locacao();
		locacao.setCodigo(1);
		locacao.setCliente(clientePadrao());	
		locacao.setFilmes(filmes);
		locacao.setDtLocacao(Calendar.getInstance().getTime());
		locacao.setValor(10.00);

		Command cmdnovalocacao = new NovaLocacaoCommand(fachada, locacao);
		
		controle.execute(cmdnovalocacao);
		
		ArrayList<Locacao> locacoes = fachada.ListaLocacao();
		
		assertEquals(1, locacoes.size());
		assertEquals(locacao, locacoes.get(0));	
		
		Command cmdexcluirlocacao = new ExcluirLocacaoCommand(fachada, locacao);
		
		controle.execute(cmdexcluirlocacao);
		
		locacoes = fachada.ListaLocacao();
		
		assertEquals(0, locacoes.size());		
	}
	
	@Test(expected=Exception.class)
	public void testLocacaoSemCliente() throws Exception {
		
		Locacao locacao = new Locacao();
		locacao.setCodigo(1);
		
		this.fachada.NovaLocacao(locacao);
		
	}
	
	@Test(expected=Exception.class)
	public void testLocacaoSemFilme() throws Exception {
		
		Locacao locacao = new Locacao();
		locacao.setCodigo(1);
		locacao.setCliente(clientePadrao());		
		
		this.fachada.NovaLocacao(locacao);		
	}
	
	@Test(expected=Exception.class)
	public void testLocacaoSemData() throws Exception {
		
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		filmes.add(filmeDVDPadrao());
		filmes.add(filmeBLURAYPadrao());		
		
		Locacao locacao = new Locacao();
		locacao.setCodigo(1);
		locacao.setCliente(clientePadrao());
		locacao.setFilmes(filmes);		
		
		this.fachada.NovaLocacao(locacao);		
	}	
	
	@Test(expected=Exception.class)
	public void testLocacaoSemValor() throws Exception {
		
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		filmes.add(filmeDVDPadrao());
		filmes.add(filmeBLURAYPadrao());		
		
		Locacao locacao = new Locacao();
		locacao.setCodigo(1);
		locacao.setCliente(clientePadrao());
		locacao.setFilmes(filmes);
		locacao.setDtLocacao(Calendar.getInstance().getTime());
		
		this.fachada.NovaLocacao(locacao);		
	}	
	
	public Endereco enderecoPadrao() {		
		Endereco endereco = new Endereco();
		
		endereco.setLogradouro("Rua Chile");
		endereco.setNumero(123);
		endereco.setBairro("Catole");
		endereco.setComplemento("1 andar");
		endereco.setCep("12345678");
		endereco.setMunicipio("Campina Grande");
		endereco.setEstado("PB");		
		
		return endereco;		
	}
	
	public Cliente clientePadrao() {
		
		Cliente cliente = new Cliente();
		cliente.setCpf("63356030124");
		cliente.setNome("Marcos Guimaraes");
		cliente.setEndereco(enderecoPadrao());
		
		return cliente;
	}
	
	public Filme filmeDVDPadrao() {
		
		Filme filme = new Filme();
		filme.setCodigo(1);
		filme.setTitulo("Filme 1");
		filme.setGenero("Ação");
		filme.setAno(2013);
		filme.setTipo(TipoEnum.DVD);
		
		return filme;		
		
	}
	
	public Filme filmeBLURAYPadrao() {
		
		Filme filme = new Filme();
		filme.setCodigo(2);
		filme.setTitulo("Filme 2");
		filme.setGenero("Comedia");
		filme.setAno(2011);
		filme.setTipo(TipoEnum.BLU_RAY);
		
		return filme;		
		
	}	

}
