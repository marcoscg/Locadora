package com.facisa.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.facisa.entidade.Cliente;
import com.facisa.entidade.Endereco;
import com.facisa.entidade.Filme;
import com.facisa.entidade.Locacao;
import com.facisa.fachada.Fachada;
import com.facisa.util.TipoEnum;
import com.facisa.util.ValidaCPF;

public class Testes {

	private Fachada fachada;
	
	@Before
	public void setUp() throws Exception {
		this.fachada = new Fachada();		
		
		fachada.ExcluirTodoCliente();
		fachada.ExcluirTodoFilme();
		fachada.ExcluirTodaLocacao();
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
		
		this.fachada.NovoCliente(cliente);
		
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
		
		fachada.NovoCliente(cliente);	
		fachada.NovoCliente(cliente1);
		
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
		
		fachada.NovoCliente(cliente);
		fachada.NovoCliente(cliente1);
		fachada.NovoCliente(cliente2);
		
		ArrayList<Cliente> clientes = fachada.ListaCliente();
		
		assertEquals(3, clientes.size());
		assertEquals(cliente, clientes.get(0));
		assertEquals(cliente1, clientes.get(1));
		assertEquals(cliente2, clientes.get(2));		
		
		fachada.ExcluirCliente(cliente);
		fachada.ExcluirCliente(cliente2);
		
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
		
		fachada.NovoCliente(cliente);
		fachada.NovoCliente(cliente1);
		fachada.NovoCliente(cliente2);
		
		ArrayList<Cliente> clientes = fachada.ListaCliente();
		
		assertEquals(3, clientes.size());
		assertEquals(cliente, clientes.get(0));
		assertEquals(cliente1, clientes.get(1));
		assertEquals(cliente2, clientes.get(2));		
		
		fachada.ExcluirTodoCliente();
		
		clientes = fachada.ListaCliente();
		
		assertEquals(0, clientes.size());		
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
		
		Filme filme = new Filme();
		filme.setCodigo(1);
		filme.setTitulo("Filme 1");
		filme.setGenero("Ação");
		filme.setAno(2013);
		filme.setTipo(TipoEnum.DVD);		

		this.fachada.NovoFilme(filme);
		
		ArrayList<Filme> filmes = fachada.ListaFilme();
		
		assertEquals(1, filmes.size());
		assertEquals(filme, filmes.get(0));		
	}
	
	@Test
	public void testExcluirFilme() throws Exception {		
		
		Filme filme = new Filme();
		filme.setCodigo(1);
		filme.setTitulo("Filme 1");
		filme.setGenero("Ação");
		filme.setAno(2013);
		filme.setTipo(TipoEnum.DVD);		

		this.fachada.NovoFilme(filme);
		
		ArrayList<Filme> filmes = fachada.ListaFilme();
		
		assertEquals(1, filmes.size());
		assertEquals(filme, filmes.get(0));
		
		this.fachada.ExcluirFilme(filme);
		
		filmes = fachada.ListaFilme();
		
		assertEquals(0, filmes.size());
		
	}
	
	@Test(expected=Exception.class)
	public void testFilmeNaoExiste() throws Exception {
		
		Filme filme = new Filme();
		filme.setCodigo(1);
		filme.setTitulo("Filme 1");
		filme.setGenero("Ação");
		filme.setAno(2013);
		filme.setTipo(TipoEnum.DVD);
		
		Filme filme1 = new Filme();
		filme1.setCodigo(1);
		filme1.setTitulo("Filme 2");
		filme1.setGenero("Comedia");
		filme1.setAno(2013);
		filme1.setTipo(TipoEnum.BLU_RAY);		

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

		this.fachada.NovaLocacao(locacao);
		
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

		this.fachada.NovaLocacao(locacao);
		
		ArrayList<Locacao> locacoes = fachada.ListaLocacao();
		
		assertEquals(1, locacoes.size());
		assertEquals(locacao, locacoes.get(0));	
		
		this.fachada.ExcluirLocacao(locacao);
		
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
