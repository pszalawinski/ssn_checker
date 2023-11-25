package org.pawel.validators;


public class LuhnChecksumCalculator implements BaseChecksumCalculator {

	@Override
	public boolean calculateChecksum(String ssn) {
		return isValidLuhn(ssn);
	}

	public static boolean isValidLuhn(String number) {
		int checksum = Character.getNumericValue(number.charAt(number.length() - 1));
		int total = 0;

		for (int i = number.length() - 2; i >= 0; i--) {
			int sum = 0;
			int digit = Character.getNumericValue(number.charAt(i));
			if (i % 2 == 0) {
				digit *= 2;
			}

			sum = digit / 10 + digit % 10;
			total += sum;
		}
		return 10 - total % 10 == checksum;
	}
}
