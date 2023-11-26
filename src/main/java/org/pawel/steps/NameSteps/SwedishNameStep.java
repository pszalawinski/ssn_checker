package org.pawel.steps.NameSteps;

import org.pawel.validators.NameValidator;

public class SwedishNameStep extends WordStep {

	public Boolean isSwedishChar = false;
	NameValidator nameValidator;

	public SwedishNameStep(NameValidator nameValidator) {
		super("SwedishNameStep");
		this.nameValidator = nameValidator;
	}

	@Override
	public void setNext(WordStep nextProcessor) {
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
