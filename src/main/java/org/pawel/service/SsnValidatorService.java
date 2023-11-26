package org.pawel.service;

import static org.pawel.utils.SsnUtils.*;

import org.pawel.steps.SsnSteps.AgeValidatorStep;
import org.pawel.steps.SsnSteps.ChecksumValidatorStep;
import org.pawel.steps.SsnSteps.DateValidatorStep;
import org.pawel.steps.SsnSteps.LengthValidatorStep;
import org.pawel.steps.SsnSteps.NumberValidatorStep;
import org.pawel.steps.SsnSteps.SsnBaseStep;
import org.pawel.validators.LuhnChecksumCalculator;
import org.pawel.validators.SsnValidator;

public class SsnValidatorService {

	public SsnValidatorService() {

	}

	public boolean isValidSsnNumber(String ssn) {

		//register all steps
		LuhnChecksumCalculator luhnChecksumCalculator = new LuhnChecksumCalculator();
		SsnValidator ssnValidator = new SsnValidator(luhnChecksumCalculator);

		SsnBaseStep lengthValidatorStep = new LengthValidatorStep(ssnValidator);
		SsnBaseStep ageValidatorStep = new AgeValidatorStep(ssnValidator);
		SsnBaseStep numberValidatorStep = new NumberValidatorStep(ssnValidator);
		SsnBaseStep dateValidatorStep = new DateValidatorStep(ssnValidator);
		SsnBaseStep checksumValidatorStep = new ChecksumValidatorStep(ssnValidator);

		lengthValidatorStep.setNext(ageValidatorStep);
		ageValidatorStep.setNext(numberValidatorStep);
		numberValidatorStep.setNext(dateValidatorStep);
		dateValidatorStep.setNext(checksumValidatorStep);

		return lengthValidatorStep.isSsnValid(prepareSsn(ssn));
	}
}
