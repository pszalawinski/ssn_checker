package org.pawel.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements BaseWordValidator {

	Pattern pattern = Pattern.compile("[a-zA-ZäåöÄÅÖ ]+");
	@Override
	public boolean isLengthValid(String word) {
		if (word.length() >= 2) {
			return true;
		} else {
			System.out.println("Name to short.");
			return false;
		}
	}

	@Override
	public boolean isNotBlank(String word) {
		if (word == null && word.trim().isEmpty()) {
			System.out.println("Provided empty name.");
			return false;
		}
		return true;
	}

	public void isFullNameGiven(String name) {
		if(name.trim().contains(" ")){
			System.out.println("Probably full name given.");
		} else {System.out.println("Given only name.");}
	}

	public boolean isNotNumeric(String name){
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}
}
