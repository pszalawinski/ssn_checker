package org.pawel.service;

import org.pawel.processors.BlankNameProcessor;
import org.pawel.processors.NumericNameProcessor;
import org.pawel.processors.SwedishNameProcessor;
import org.pawel.processors.WordProcessor;
import org.pawel.validators.NameValidator;

public class NameCheckerService {
	public NameCheckerService() {
	}

	public boolean isValidName(String name){
		NameValidator nameValidator = new NameValidator();

		WordProcessor nameBlankProcessor = new BlankNameProcessor(nameValidator);
		WordProcessor numericWordProcessor = new NumericNameProcessor(nameValidator);
		WordProcessor swedishNameProcessor = new SwedishNameProcessor(nameValidator);
		nameBlankProcessor.setNext(numericWordProcessor);
		numericWordProcessor.setNext(swedishNameProcessor);

		return nameBlankProcessor.isNameValid(name.trim());
	}

}
