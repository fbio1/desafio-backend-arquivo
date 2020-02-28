package com.arquivoProcessador.factories;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.arquivoProcessador.entity.ItemVenda;
import com.arquivoProcessador.entity.Venda;

import static org.junit.Assert.*;

public class VendaFactoryTest {

    public VendaFactoryTest() {
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
    public void testCreateSaleByRegister() {
        //003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name
        //003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro

        Venda expectedSale = new Venda(10L, new ArrayList(), "Pedro");
        expectedSale.addItens(new ItemVenda(1L, 10L, new BigDecimal(100)));
        expectedSale.addItens(new ItemVenda(2L, 30L, new BigDecimal(2.50)));
        expectedSale.addItens(new ItemVenda(3L, 40L, new BigDecimal(3.10)));
        String expectedSaleRegister = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        EntityFactory factory = new VendaFactory();
        Venda sale = (Venda) factory.create(expectedSaleRegister);
        assertEquals(sale.getId(), expectedSale.getId());
        assertEquals(sale.getNomeVendedor(), expectedSale.getNomeVendedor());

    }
}
