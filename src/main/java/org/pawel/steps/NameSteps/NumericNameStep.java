package org.pawel.steps.NameSteps;

import static org.pawel.utils.Constants.WRONG;

import java.util.Arrays;
import org.pawel.validators.NameValidator;

public class NumericNameStep extends WordStep {

	NameValidator nameValidator;

	public NumericNameStep(NameValidator nameValidator) {
		super("NumericNameStep");
		this.nameValidator = nameValidator;
	}

	@Override
	public void setNext(WordStep nextProcessor) {
		this.nextProcessor = nextProcessor;

	}

	@Override
	public boolean isNameValid(String name) {

		if (!nameValidator.isNotNumeric(name)) {
			System.out.println("Name has numbers. It is considered as wrong name.".concat(
					Arrays.toString(WRONG)));
			return false;
		} else {
			return nextProcessor.isNameValid(name);
		}

	}
}
