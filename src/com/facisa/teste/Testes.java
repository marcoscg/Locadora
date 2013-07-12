package com.facisa.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.facisa.entidade.Cliente;
import com.facisa.fachada.Fachada;
import com.facisa.util.ValidaCPF;

public class Testes {

	private Fachada fachada;
	
	@Before
	public void setUp() throws Exception {
		fachada = new Fachada();
	}
	
	@Test
	public void testCPFValido() {		
		ValidaCPF cpf = new ValidaCPF();		
		assertTrue(cpf.isCPF("02172051942"));		
	}
	
	@Test
	public void testCPFInvalido() {		
		ValidaCPF cpf = new ValidaCPF();		
		assertFalse(cpf.isCPF("02172051941"));		
	}	

	@Test
	public void testNovoCliente() throws Exception {		
		Cliente cliente = new Cliente();
		cliente.setCpf("02172051942");
		cliente.setNome("Marcos Guimaraes");		
		
		fachada.NovoCliente(cliente);
		
		ArrayList<Cliente> clientes = fachada.ListaCliente();
		
		assertEquals(1, clientes.size());
		assertEquals(cliente, clientes.get(0));		
	}	
	
	@Test(expected=Exception.class)
	public void testNomeVazio() throws Exception {
		
		Cliente cliente = new Cliente();
		cliente.setCpf("02172051942");
		cliente.setNome("");	
		
		fachada.NovoCliente(cliente);
		
	}

}
