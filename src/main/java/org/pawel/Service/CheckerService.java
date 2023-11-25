package org.pawel.Service;

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
			preparedSsn = SsnUtils.removeCentury(preparedSsn);
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
