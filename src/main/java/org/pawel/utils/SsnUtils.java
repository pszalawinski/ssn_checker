package org.pawel.utils;

public class SsnUtils {


	public static String removeCentury(String ssn) {
		return ssn.substring(2);
	}

	public static String prepareSsn(String rawSsn) {
		return removeDashes(rawSsn.replaceAll(" ", ""));
	}

	public static boolean isPlusOnTheEnd(String preparedSsn) {
		return String.valueOf(preparedSsn.charAt(preparedSsn.length() - 1)).equals("+");
	}
	public static String removeDashes(String number) {
		String removedDashes = number.replace("-", "");
		System.out.println("Trimmed ssn: " + number.replace("-", ""));
		return removedDashes;
	}


}
