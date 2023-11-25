package org.pawel.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import org.pawel.utils.SsnUtils;

public class SsnValidator implements BaseValidator {

	private static final String pattern10 = "yyMMdd";
	private static final String pattern12 = "yyyyMMdd";
	LuhnChecksumCalculator luhnChecksumCalculator;

	public SsnValidator(LuhnChecksumCalculator luhnChecksumCalculator) {
		this.luhnChecksumCalculator = luhnChecksumCalculator;
	}

	@Override
	public boolean isOlder(String preparedSsn) {
		DateTimeFormatter formatter;
		String date;
		switch (preparedSsn.length()) {
			case 12 -> {
				date = preparedSsn.substring(0, 8);
				formatter = DateTimeFormatter.ofPattern(pattern12);
				System.out.println(date);
			}
			default -> {
				String shortDate = preparedSsn.substring(0, 6);
				DateTimeFormatter initialFormatter = DateTimeFormatter.ofPattern(pattern10);

				//adjust date
				LocalDate parsedDate = LocalDate.parse(shortDate, initialFormatter);
				LocalDate adjustedDate =
						parsedDate.getYear() <= LocalDate.now().getYear() ? parsedDate.minusYears(100) : parsedDate;

				date = SsnUtils.removeDashes(adjustedDate.toString().replace("-",""));
				formatter = DateTimeFormatter.ofPattern(pattern12);

				System.out.println(date);
			}


		}
		return LocalDate.now().minusYears(100)
				.isAfter(LocalDate.parse(date, formatter));
	}

	@Override
	public boolean isNumber(String preparedSsn) {
		return !Pattern.matches("[a-zA-Z]", preparedSsn);
	}

	@Override
	public boolean isLengthCorrect(String preparedSsn) {
		System.out.println("LENGTH of ".concat(preparedSsn).concat("is ").concat(
				String.valueOf(preparedSsn.length())));
		return preparedSsn.length() == 10 || preparedSsn.length() == 12;
	}

	@Override
	public boolean isChecksumCorrect(String ssn) {
		System.out.println("Checksum -" + luhnChecksumCalculator.calculateChecksum(ssn));
		return luhnChecksumCalculator.calculateChecksum(ssn);
	}
}