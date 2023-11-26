package org.pawel.processors;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.pawel.validators.NameValidator;

public class SwedishNameProcessor extends WordProcessor {

	Boolean isSwedishChar = false;
	NameValidator nameValidator;

	public SwedishNameProcessor(NameValidator nameValidator) {
		super("SwedishNameProcessor");
		this.nameValidator = nameValidator;
	}

	@Override
	public void setNext(WordProcessor nextProcessor) {
		this.nextProcessor = nextProcessor;
	}

	@Override
	public boolean isNameValid(String name) {

		isSwedishChar = nameValidator.hasSwedishLetter(name);

		if (nameValidator.isLengthValid(name)) {
			nameValidator.isFullNameGiven(name);
			return true;
		} else {
			return false;
		}

	}
}
