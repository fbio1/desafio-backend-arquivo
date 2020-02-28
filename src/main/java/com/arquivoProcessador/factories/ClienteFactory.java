package com.arquivoProcessador.factories;

import com.arquivoProcessador.entity.Cliente;
import com.arquivoProcessador.entity.Entity;

public class ClienteFactory implements EntityFactory {

	@Override
	public Entity create(String register) {
		String[] splitedRegistries = register.split("ç");
		return new Cliente(splitedRegistries[1], splitedRegistries[2], splitedRegistries[3]);
	}

}
