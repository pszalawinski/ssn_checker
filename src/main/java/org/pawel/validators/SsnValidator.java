package org.pawel.validators;

import java.util.regex.Pattern;

public class SsnValidator implements BaseValidator {

	LuhnChecksumCalculator luhnChecksumCalculator;

	public SsnValidator(LuhnChecksumCalculator luhnChecksumCalculator) {
		this.luhnChecksumCalculator = luhnChecksumCalculator;
	}

	@Override
	public boolean isOlder() {
		return true;
	}

	@Override
	public boolean isNumber(String preparedSsn) {
		return !Pattern.matches("[a-zA-Z]+", preparedSsn);
	}

	@Override
	public boolean isProperPattern() {
		return true;
	}

	@Override
	public boolean isLengthCorrect(String preparedSsn) {
		return preparedSsn.length() == 10 || preparedSsn.length() == 12;
	}

	@Override
	public boolean isChecksumCorrect(String ssn) {
		System.out.println("Checksum -" + luhnChecksumCalculator.calculateChecksum(ssn));
		return luhnChecksumCalculator.calculateChecksum(ssn);
	}
}