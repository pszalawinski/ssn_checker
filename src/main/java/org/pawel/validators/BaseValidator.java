package org.pawel.validators;

public interface BaseValidator {

	boolean isOlder(String number);

	boolean isNumber(String number);

	boolean isProperPattern();

	boolean isLengthCorrect(String number);

	boolean isChecksumCorrect(String number);
}
