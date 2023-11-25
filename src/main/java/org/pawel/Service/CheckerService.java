package org.pawel.Service;

import static org.pawel.utils.SsnUtils.pattern10;
import static org.pawel.utils.SsnUtils.pattern12;

import java.time.format.DateTimeFormatter;
import org.pawel.utils.SsnUtils;
import org.pawel.validators.SsnValidator;

public class CheckerService {


	SsnValidator ssnValidator;

	public CheckerService(SsnValidator ssnValidator) {
		this.ssnValidator = ssnValidator;

	}

	public boolean isValidSsnNumber(String ssn) {
		String preparedSsn = SsnUtils.prepareSsn(ssn);

		if (!ssnValidator.isLengthCorrect(preparedSsn)) {
			System.out.println("Length of SSN is incorrect");
			return false;
		}

		if (SsnUtils.isOnePlusOnTheEnd(preparedSsn)
				&&
				!ssnValidator.isNumber(preparedSsn.replace("+", "")))
		{
			return ssnValidator.isOlder(preparedSsn);

		}

		if (ssnValidator.isNumber(preparedSsn)) {
			System.out.println("Given SSN is not a correct numeric value");
			return false;
		}

		if (preparedSsn.length() == 12) {
			if (!SsnUtils.isValidDate(preparedSsn.substring(0,8), DateTimeFormatter.ofPattern(pattern12))) {
				System.out.println("Date of birth in given SSN is not correct.");
				return false;
			}
			preparedSsn = SsnUtils.removeCentury(preparedSsn);
		}
		if (!SsnUtils.isValidDate(preparedSsn.substring(0,6), DateTimeFormatter.ofPattern(pattern10))) {
			System.out.println("Date of birth in given SSN is not correct.");
			return false;
		}

		boolean checksum = ssnValidator.isChecksumCorrect(preparedSsn);

		if(!checksum){
			System.out.println("Given SSN is invalid");
			return checksum;}
		else {
		return checksum;
		}

	}

}
