package org.pawel.utils;

import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class SsnUtils {
	public static final String pattern10 = "yyMMdd";
	public static final String pattern12 = "yyyyMMdd";

	static Pattern special = Pattern.compile ("[+]");
	public static String removeCentury(String ssn) {
		return ssn.substring(2);

	}

	public static String prepareSsn(String rawSsn) {
		return removeDashes(rawSsn.replaceAll(" ", ""));
	}

	public static boolean isOnePlusOnTheEnd(String preparedSsn) {
		return countSpecialCharacters(preparedSsn) <= 1 && String.valueOf(
				preparedSsn.charAt(preparedSsn.length() - 1)).equals("+");
	}
	public static String removeDashes(String number) {
		return number.replace("-", "");
	}

	public static boolean isValidDate(String dateStr, DateTimeFormatter formatter) {
		try {
			LocalDate.parse(dateStr, formatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	private static int countSpecialCharacters(String str) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!Character.isLetterOrDigit(ch)) {
				count++;
			}
		}

		return count;
	}
}
