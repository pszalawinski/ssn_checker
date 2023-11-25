package org.pawel.validators;

public interface BaseValidator {

	boolean isOlder();
	boolean isNumber();
	boolean isProperPattern();
	boolean isLengthCorrect(String number);
	boolean isChecksumCorrect(String number);
}
