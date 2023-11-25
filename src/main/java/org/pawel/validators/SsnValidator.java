package org.pawel.validators;

import static org.pawel.utils.SsnUtils.pattern10;
import static org.pawel.utils.SsnUtils.pattern12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.regex.Pattern;
import org.pawel.utils.SsnUtils;

public class SsnValidator implements BaseValidator {


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

		if (!SsnUtils.isValidDate(date, formatter)) {
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
		return preparedSsn.length() == 10 || preparedSsn.length() == 12;
	}

	@Override
	public boolean isChecksumCorrect(String ssn) {
		return luhnChecksumCalculator.calculateChecksum(ssn);
	}
}