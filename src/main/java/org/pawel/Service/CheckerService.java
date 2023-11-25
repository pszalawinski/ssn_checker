package org.pawel.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

		if (SsnUtils.isPlusOnTheEnd(preparedSsn)
				&& ssnValidator.isNumber(preparedSsn.replace("+", ""))) {
			return ssnValidator.isOlder(preparedSsn);
		}

		if (!ssnValidator.isLengthCorrect(preparedSsn) && ssnValidator.isNumber(preparedSsn)) {
			System.out.println("Length of SSN is incorrect");
			return false;
		}

		if (preparedSsn.length() == 12) {
			preparedSsn = SsnUtils.removeCentury(preparedSsn);
		}

		boolean checksum = ssnValidator.isChecksumCorrect(preparedSsn);
		return checksum;

	}

}
