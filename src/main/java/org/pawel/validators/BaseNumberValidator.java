package org.pawel.validators;

public interface BaseNumberValidator {

	boolean isOlder(String number);

	boolean isNumber(String number);

	boolean isLengthCorrect(String number);

	boolean isChecksumCorrect(String number);
}
