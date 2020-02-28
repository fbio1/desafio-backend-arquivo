package com.arquivoProcessador.factories;

import com.arquivoProcessador.entity.Entity;

public interface EntityFactory {

	/**
	 *
	 * @param register
	 * @return
	 */
	abstract Entity create(String register);

}
