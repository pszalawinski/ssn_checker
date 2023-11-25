package org.pawel.validators;

public interface BaseWordValidator {

	boolean isLengthValid(String word);
	boolean isNotBlank(String word);

}
