package org.pawel.processors.SsnSteps;

import static org.pawel.utils.Constants.WRONG;
import static org.pawel.utils.SsnUtils.isValidDate;
import static org.pawel.utils.SsnUtils.pattern10;
import static org.pawel.utils.SsnUtils.pattern12;
import static org.pawel.utils.SsnUtils.removeCentury;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import org.pawel.validators.SsnValidator;

public class DateValidatorStep extends SsnBaseStep {

	SsnValidator ssnValidator;

	public DateValidatorStep(SsnValidator ssnValidator) {
		super("DateValidatorStep");
		this.ssnValidator = ssnValidator;
	}

	@Override
	public void setNext(SsnBaseStep nextProcessor) {
		this.nextProcessor = nextProcessor;
	}

	@Override
	public boolean isSsnValid(String ssn) {
		String preparedSsn;
		if (ssn.length() == 12 && nextProcessor != null) {
			if (!isValidDate(ssn.substring(0, 8), DateTimeFormatter.ofPattern(pattern12))) {
				System.out.println("Date of birth in given SSN is not correct.".concat(
						Arrays.toString(WRONG)));
				return false;
			}
			preparedSsn = removeCentury(ssn);
			return nextProcessor.isSsnValid(preparedSsn);
		}
		if (isValidDate(ssn.substring(0, 6), DateTimeFormatter.ofPattern(pattern10))
				&& nextProcessor != null) {
			return nextProcessor.isSsnValid(ssn);
		}
		System.out.println("Date of birth in given SSN is not correct.".concat(
				Arrays.toString(WRONG)));
		return false;

	}
}
