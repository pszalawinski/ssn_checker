package org.pawel.steps.SsnSteps;

import static org.pawel.utils.Constants.WRONG;

import java.util.Arrays;
import org.pawel.validators.SsnValidator;

public class NumberValidatorStep extends SsnBaseStep {

	SsnValidator ssnValidator;

	public NumberValidatorStep(SsnValidator ssnValidator) {
		super("NumberValidatorStep");
		this.ssnValidator = ssnValidator;
	}

	@Override
	public void setNext(SsnBaseStep nextProcessor) {
		this.nextProcessor = nextProcessor;
	}

	@Override
	public boolean isSsnValid(String ssn) {
		if (!ssnValidator.isNumber(ssn) && nextProcessor != null) {
			return nextProcessor.isSsnValid(ssn);
		}
		System.out.println("Given SSN is not a correct numeric value".concat(
				Arrays.toString(WRONG)));
		return false;
	}
}
