package org.pawel.service;

import static org.pawel.utils.SsnUtils.*;

import org.pawel.processors.SsnSteps.AgeValidatorStep;
import org.pawel.processors.SsnSteps.ChecksumValidatorStep;
import org.pawel.processors.SsnSteps.DateValidatorStep;
import org.pawel.processors.SsnSteps.LengthValidatorStep;
import org.pawel.processors.SsnSteps.NumberValidatorStep;
import org.pawel.processors.SsnSteps.SsnBaseStep;
import org.pawel.validators.LuhnChecksumCalculator;
import org.pawel.validators.SsnValidator;

public class SsnCheckerService {

	public SsnCheckerService() {

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
