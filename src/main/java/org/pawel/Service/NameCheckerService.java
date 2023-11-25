package org.pawel.Service;

import org.pawel.Processors.NameBlankProcessor;
import org.pawel.Processors.SwedishNameProcessor;
import org.pawel.Processors.WordProcessor;
import org.pawel.validators.NameValidator;

public class NameCheckerService {
	public NameCheckerService() {
	}

	public boolean isValidName(String name){
		NameValidator nameValidator = new NameValidator();

		WordProcessor nameBlankProcessor = new NameBlankProcessor(nameValidator);
		WordProcessor swedishNameProcessor = new SwedishNameProcessor(nameValidator);
		nameBlankProcessor.setNext(swedishNameProcessor);

		return nameBlankProcessor.isNameValid(name.trim());
	}

}
