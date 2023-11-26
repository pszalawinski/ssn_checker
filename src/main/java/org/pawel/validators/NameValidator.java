package org.pawel.validators;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements BaseWordValidator {

	Pattern numericPattern = Pattern.compile("[1-9].*+");
	Pattern swedishLetters = Pattern.compile("[äåöÄÅÖ]");

	@Override
	public boolean isLengthValid(String word) {
		if (word.length() >= 2) {
			return true;
		} else {
			System.out.println("Name is too short.");
			return false;
		}
	}

	@Override
	public boolean isNotBlank(String word) {
		return word != null && !word.isBlank() && !word.isEmpty();
	}

	public void isFullNameGiven(String name) {
		if (name.trim().contains(" ")) {
			System.out.println("Probably full name given.");
		} else {
			System.out.println("Given only name.");
		}
	}

	public boolean isNotNumeric(String name) {
		Matcher matcher = numericPattern.matcher(name);
		return !matcher.find();
	}

	public boolean hasSwedishLetter(String name) {
		Matcher matcher = swedishLetters.matcher(name);
		if (matcher.find()) {
			System.out.println("Provided name with Swedish character.".concat(
					Arrays.toString(Character.toChars(0x270C))));
			return true;
		}
		return false;
	}
}
