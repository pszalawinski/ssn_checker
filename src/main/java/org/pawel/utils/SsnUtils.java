package org.pawel.utils;

import java.util.regex.Pattern;

public class SsnUtils {

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
		String removedDashes = number.replace("-", "");
		System.out.println("Trimmed ssn: " + number.replace("-", ""));
		return removedDashes;
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
