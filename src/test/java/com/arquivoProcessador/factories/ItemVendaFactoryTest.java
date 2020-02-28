package com.arquivoProcessador.factories;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.arquivoProcessador.entity.ItemVenda;

import static org.junit.Assert.*;

public class ItemVendaFactoryTest {
    
    public ItemVendaFactoryTest() {
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
    public void testCreateSaleItemByString(){
    //[Item ID-Item Quantity-Item Price]
    //[1-10-100,2-30-2.50,3-40-3.10]
        ItemVenda expectedSaleItem = new ItemVenda(1L,10L,new BigDecimal(100));
        String expectedSaleItemRegister = String.format("%s-%s-%s",
                expectedSaleItem.getId().toString(),
                expectedSaleItem.getQuantity().toString(),
                expectedSaleItem.getUnitPrice().toString());
        EntityFactory factory = new ItemVendaFactory();
        ItemVenda saleItem = (ItemVenda)factory.create(expectedSaleItemRegister);
        assertEquals(saleItem.getId(), expectedSaleItem.getId());
        assertEquals(saleItem.getQuantity(), expectedSaleItem.getQuantity());
        assertEquals(saleItem.getUnitPrice(), expectedSaleItem.getUnitPrice());
        
    }
}
