package org.pawel.processors;

import org.pawel.validators.NameValidator;

public class SwedishNameProcessor extends WordProcessor {

	Boolean isSwedishChar = false;
	NameValidator nameValidator;

	public SwedishNameProcessor(NameValidator nameValidator) {
		super("SwedishNameProcessor");
		this.nameValidator = nameValidator;
	}

	@Override
	public void setNext(WordProcessor nextProcessor) {
		this.nextProcessor = nextProcessor;
	}

	@Override
	public boolean isNameValid(String name) {

		isSwedishChar = nameValidator.hasSwedishLetter(name);

		if (nameValidator.isLengthValid(name)) {
			nameValidator.isFullNameGiven(name);
			return true;
		} else {
			return false;
		}

	}
}
