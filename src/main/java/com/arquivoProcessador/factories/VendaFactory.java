package com.arquivoProcessador.factories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.arquivoProcessador.entity.Entity;
import com.arquivoProcessador.entity.ItemVenda;
import com.arquivoProcessador.entity.Venda;

public class VendaFactory implements EntityFactory {

	@Override
	public Entity create(String register) {
		String[] splitedRegistries = register.split("ç");
		Venda sale = new Venda(new Long(splitedRegistries[1]), createSaleItems(splitedRegistries[2]),
				splitedRegistries[3]);
		return sale;
	}

	private List<ItemVenda> createSaleItems(String itemsRegister) {
		List<ItemVenda> saleItems = new ArrayList<ItemVenda>();
		List<String> items = Arrays.asList(itemsRegister.replace("[", "").replace("]", "").split(","));
		EntityFactory saleItemsFactory = new ItemVendaFactory();
		for (String item : items) {
			saleItems.add((ItemVenda) saleItemsFactory.create(item));
		}
		return saleItems;
	}

}
