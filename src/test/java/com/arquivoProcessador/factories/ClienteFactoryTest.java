package com.arquivoProcessador.factories;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.arquivoProcessador.entity.Cliente;

/**
 *
 * @author bscherer
 */
public class ClienteFactoryTest {

	public ClienteFactoryTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testCreateClientByString() {
		Cliente expectedClient = new Cliente("2345675434544345", "Jose da Silva", "Rural");
		String expectedClientRegister = String.format("002ç%sç%sç%s", expectedClient.getCnpj(),
				expectedClient.getnome(), expectedClient.getAreaNegocio());

		EntityFactory factory = new ClienteFactory();
		Cliente client = (Cliente) factory.create(expectedClientRegister);
		assertEquals(client.getCnpj(), expectedClient.getCnpj());
		assertEquals(client.getnome(), expectedClient.getnome());
		assertEquals(client.getAreaNegocio(), expectedClient.getAreaNegocio());
	}
}
