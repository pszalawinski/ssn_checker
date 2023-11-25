package org.pawel.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
						parsedDate.getYear() <= LocalDate.now().getYear() ? parsedDate.minusYears(
								100) : parsedDate;

				date = SsnUtils.removeDashes(adjustedDate.toString().replace("-", ""));
				formatter = DateTimeFormatter.ofPattern(pattern12);

				System.out.println(date);
			}


		}

		if (!isValidDate(date, formatter)) {
			System.out.println("Date of birth in given SSN is not correct.");
			return false;
		}

		boolean check = LocalDate.now().minusYears(100)
				.isAfter(LocalDate.parse(date, formatter));
		if (check) {
			return true;
		} else {
			System.out.println(
					"Given SSN is incorrect. Person with this SSN should be older than 100 years, but it is not.");
			return false;
		}
	}

	@Override
	public boolean isNumber(String preparedSsn) {
		return Pattern.matches("[a-zA-Z]", preparedSsn);
	}

	@Override
	public boolean isLengthCorrect(String preparedSsn) {
		System.out.println("LENGTH of ".concat(preparedSsn).concat("is ").concat(
				String.valueOf(preparedSsn.length())));
		return preparedSsn.length() == 10 || preparedSsn.length() == 12;
	}

	@Override
	public boolean isChecksumCorrect(String ssn) {
		System.out.println("Checksum: " + luhnChecksumCalculator.calculateChecksum(ssn));
		return luhnChecksumCalculator.calculateChecksum(ssn);
	}

	private boolean isValidDate(String dateStr, DateTimeFormatter formatter) {
		try {
			LocalDate.parse(dateStr, formatter);
			return true; // If parsing succeeds, the date is valid
		} catch (DateTimeParseException e) {
			return false; // Parsing failed, indicating an invalid date
		}
	}
}