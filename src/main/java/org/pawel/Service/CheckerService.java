package org.pawel.Service;

import org.pawel.utils.SsnUtils;
import org.pawel.validators.SsnValidator;

public class CheckerService {

	SsnValidator ssnValidator;
	SsnUtils ssnUtils;

	public CheckerService(SsnValidator ssnValidator, SsnUtils ssnUtils) {
		this.ssnValidator = ssnValidator;
		this.ssnUtils = ssnUtils;
	}

	public boolean isValidSsnNumber(String ssn) {
		String preparedSsn = ssnUtils.prepareSsn(ssn);

		if (!ssnValidator.isLengthCorrect(preparedSsn) && ssnValidator.isNumber(preparedSsn)) {
			System.out.println("Length of SSN is incorrect");
			return false;
		}

		if (preparedSsn.length() == 12) {
			preparedSsn = ssnUtils.removeCentury(preparedSsn);
		}

		boolean checksum = ssnValidator.isChecksumCorrect(preparedSsn);
		return checksum;

	}
}
