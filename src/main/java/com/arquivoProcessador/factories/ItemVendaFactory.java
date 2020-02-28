package com.arquivoProcessador.factories;

import java.math.BigDecimal;

import com.arquivoProcessador.entity.Entity;
import com.arquivoProcessador.entity.ItemVenda;

public class ItemVendaFactory implements EntityFactory {

	public ItemVendaFactory() {
	}

	@Override
	public Entity create(String register) {
		String[] splitedRegistries = register.split("-");
		return new ItemVenda(new Long(splitedRegistries[0]), new Long(splitedRegistries[1]),
				new BigDecimal(splitedRegistries[2]));

	}

}
