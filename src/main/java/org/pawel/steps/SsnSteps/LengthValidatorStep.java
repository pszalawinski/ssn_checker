package org.pawel.steps.SsnSteps;

import static org.pawel.utils.Constants.WRONG;

import java.util.Arrays;
import org.pawel.validators.SsnValidator;

public class LengthValidatorStep extends SsnBaseStep {

	SsnValidator ssnValidator;
	public LengthValidatorStep(SsnValidator ssnValidator) {
		super("LengthValidatorStep");
		this.ssnValidator = ssnValidator;
	}

	@Override
	public void setNext(SsnBaseStep nextProcessor) {
		this.nextProcessor=nextProcessor;
	}

	@Override
	public boolean isSsnValid(String ssn){
		if (ssnValidator.isLengthCorrect(ssn) && nextProcessor != null) {
			return nextProcessor.isSsnValid(ssn);
		}
		System.out.println("Length of SSN is incorrect".concat(
				Arrays.toString(WRONG)));
		return false;
	}
}
