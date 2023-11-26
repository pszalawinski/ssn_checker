package org.pawel.processors.SsnSteps;

import static org.pawel.utils.SsnUtils.isOnePlusOnTheEnd;

import org.pawel.validators.SsnValidator;

public class AgeValidatorStep extends SsnBaseStep {

	SsnValidator ssnValidator;

	public AgeValidatorStep(SsnValidator ssnValidator) {
		super("AgeValidatorStep");
		this.ssnValidator = ssnValidator;
	}

	@Override
	public void setNext(SsnBaseStep nextProcessor) {
		this.nextProcessor = nextProcessor;
	}

	@Override
	public boolean isSsnValid(String ssn) {
		if (isOnePlusOnTheEnd(ssn)
				&&
				!ssnValidator.isNumber(ssn.replace("+", ""))) {
			return ssnValidator.isOlder(ssn);
		}
		if(nextProcessor != null){
			return nextProcessor.isSsnValid(ssn);
		}
		return false;


	}
}
