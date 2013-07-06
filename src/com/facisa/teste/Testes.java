package com.facisa.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.facisa.entidade.Cliente;
import com.facisa.fachada.Fachada;

public class Testes {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws Exception {
		
		
		Cliente cliente = new Cliente();		
		cliente.setNome("Marcos Guimaraes");
		
		Fachada fachada = new Fachada();
		fachada.NovoCliente(cliente);
		
		ArrayList<Cliente> clientes = fachada.ListaCliente();
		
		assertEquals(1, clientes.size());
		assertEquals(cliente, clientes.get(0));		
		
	}
	
	@Test(expected=Exception.class)
	public void test1() throws Exception {
		
		Cliente cliente = new Cliente();		
		cliente.setNome("Ma");	
		
		Fachada fachada = new Fachada();
		fachada.NovoCliente(cliente);
		
	}

}
