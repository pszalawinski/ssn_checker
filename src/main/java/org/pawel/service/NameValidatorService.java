package org.pawel.service;

import org.pawel.steps.NameSteps.BlankNameStep;
import org.pawel.steps.NameSteps.NumericNameStep;
import org.pawel.steps.NameSteps.SwedishNameStep;
import org.pawel.steps.NameSteps.WordStep;
import org.pawel.validators.NameValidator;

public class NameValidatorService {
	public NameValidatorService() {
	}

	public boolean isValidName(String name){
		NameValidator nameValidator = new NameValidator();

		WordStep nameBlankStep = new BlankNameStep(nameValidator);
		WordStep numericWordStep = new NumericNameStep(nameValidator);
		WordStep swedishNameStep = new SwedishNameStep(nameValidator);
		nameBlankStep.setNext(numericWordStep);
		numericWordStep.setNext(swedishNameStep);

		return nameBlankStep.isNameValid(name.trim());
	}

}
