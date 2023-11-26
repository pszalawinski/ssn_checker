package org.pawel.processors;

import org.pawel.validators.NameValidator;

public class NumericNameProcessor extends WordProcessor {

	NameValidator nameValidator;

	public NumericNameProcessor(NameValidator nameValidator) {
		super("NumericNameProcessor");
		this.nameValidator = nameValidator;
	}

	@Override
	public void setNext(WordProcessor nextProcessor) {
		this.nextProcessor = nextProcessor;

	}

	@Override
	public boolean isNameValid(String name) {

		if (!nameValidator.isNotNumeric(name)) {
			System.out.println("Name has numbers. It is considered as wrong name.");
			return false;
		} else {
			return nextProcessor.isNameValid(name);
		}

	}
}
