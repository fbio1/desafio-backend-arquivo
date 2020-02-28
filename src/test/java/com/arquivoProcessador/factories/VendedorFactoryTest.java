package com.arquivoProcessador.factories;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.arquivoProcessador.entity.Vendedor;

import static org.junit.Assert.*;

/**
 *
 * @author bscherer
 */
public class VendedorFactoryTest {
    
    public VendedorFactoryTest() {
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
    public void testCreateSalesmanByString(){
        //001ç1234567891234çPedroç50000
        Vendedor expectedSalesman = new Vendedor("1234567891234", "Pedro",new BigDecimal(5000));
        String expectedSalesmanRegister = String.format("001ç%sç%sç%s",
                expectedSalesman.getCpf(),
                expectedSalesman.getName(),
                expectedSalesman.getSalary());
        
        EntityFactory factory = new VendedorFactory();
        Vendedor salesman = (Vendedor) factory.create(expectedSalesmanRegister);
        assertEquals(salesman.getCpf(), expectedSalesman.getCpf());
        assertEquals(salesman.getName(), expectedSalesman.getName());
        assertEquals(salesman.getSalary(), expectedSalesman.getSalary());
        
    }
}
