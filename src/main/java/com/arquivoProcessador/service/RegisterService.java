package com.arquivoProcessador.service;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.arquivoProcessador.entity.Cliente;
import com.arquivoProcessador.entity.Entity;
import com.arquivoProcessador.entity.ItemVenda;
import com.arquivoProcessador.entity.Venda;
import com.arquivoProcessador.entity.Vendedor;
import com.arquivoProcessador.factories.ClienteFactory;
import com.arquivoProcessador.factories.EntityFactory;
import com.arquivoProcessador.factories.VendaFactory;
import com.arquivoProcessador.factories.VendedorFactory;

public class RegisterService {

	private List<Entity> registers;

	public RegisterService() {
		registers = new ArrayList<Entity>();
	}

	public void registerAll(List<String> lines) {
		lines.stream().forEach(line -> register(line));
	}

	public void register(String line) {
		EntityFactory factory = getCorrespondentFactory(line);
		registers.add(factory.create(line));
	}

	public void clear() {
		registers.clear();
	}

	public List<Cliente> getClients() {
		return registers.stream().filter(reg -> reg instanceof Cliente).map(reg -> (Cliente) reg)
				.collect(Collectors.toList());
	}

	public List<Vendedor> getSalesmen() {
		return registers.stream().filter(reg -> reg instanceof Vendedor).map(reg -> (Vendedor) reg)
				.collect(Collectors.toList());
	}

	public List<Venda> getSales() {
		return registers.stream().filter(reg -> reg instanceof Venda).map(reg -> (Venda) reg)
				.collect(Collectors.toList());
	}

	public Long getMostExpensiveSaleId() {
		BigDecimal mostExpensivePrice = BigDecimal.ZERO;
		Long mostExpensiveSaleId = 0L;
		List<Venda> sales = getSales();
		for (Venda sale : sales) {
			BigDecimal purchaseTotal = purchaseTotal(sale);
			if (mostExpensivePrice.compareTo(purchaseTotal) <= 0) {
				mostExpensiveSaleId = sale.getId();
				mostExpensivePrice = purchaseTotal;
			}
		}
		return mostExpensiveSaleId;
	}

	public String getWorstSalesman() {
		List<Venda> sales = getSales();
		BigDecimal worstSalePrice = purchaseTotal(sales.get(0));
		Venda worstSale = sales.get(0);
		for (Venda sale : sales) {
			if (worstSalePrice.compareTo(purchaseTotal(sale)) < 0) {
			} else {
				worstSalePrice = purchaseTotal(sale);
				worstSale = sale;
			}
		}

		return worstSale.getNomeVendedor();
	}

	public String getReportResult() {
		return String.format("%dç%dç%02dç%s", getClients().size(), getSalesmen().size(), getMostExpensiveSaleId(),
				getWorstSalesman());
	}

	private EntityFactory getCorrespondentFactory(String line) {
		String type = line.substring(0, 3);
		EntityFactory factory;

		switch (type) {
		case "001":
			factory = new VendedorFactory();
			break;
		case "002":
			factory = new ClienteFactory();
			break;
		case "003":
			factory = new VendaFactory();
			break;
		default:
			throw new InvalidParameterException("Registro inválido");
		}
		return factory;
	}

	private BigDecimal purchaseTotal(Venda sale) {
		BigDecimal purchaseTotal = BigDecimal.ZERO;
		for (ItemVenda item : sale.getItems()) {
			purchaseTotal = purchaseTotal.add(item.getPrice());
		}
		return purchaseTotal;
	}
}
