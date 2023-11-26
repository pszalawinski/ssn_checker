package org.pawel.steps.SsnSteps;

import static org.pawel.utils.Constants.WRONG;

import java.util.Arrays;
import org.pawel.validators.SsnValidator;

public class ChecksumValidatorStep extends SsnBaseStep {

	SsnValidator ssnValidator;

	public ChecksumValidatorStep(SsnValidator ssnValidator) {
		super("ChecksumValidatorStep");
		this.ssnValidator = ssnValidator;
	}

	@Override
	public void setNext(SsnBaseStep nextProcessor) {
		this.nextProcessor = nextProcessor;
	}

	@Override
	public boolean isSsnValid(String ssn) {

		boolean checksum = ssnValidator.isChecksumCorrect(ssn);

		if (checksum) {
			return true;
		} else {
			System.out.println("Given SSN is invalid, checksum is not correct".concat(
					Arrays.toString(WRONG)));
			return false;
		}


	}
}
