package com.arquivoProcessador.factories;

import java.math.BigDecimal;

import com.arquivoProcessador.entity.Entity;
import com.arquivoProcessador.entity.Vendedor;

public class VendedorFactory implements EntityFactory {

	@Override
	public Entity create(String register) {
		String[] splitedRegister = register.split("ç");
		return new Vendedor(splitedRegister[1], splitedRegister[2], new BigDecimal(splitedRegister[3]));
	}

}
