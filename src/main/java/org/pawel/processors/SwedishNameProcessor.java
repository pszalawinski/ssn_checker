package org.pawel.processors;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.pawel.validators.NameValidator;

public class SwedishNameProcessor extends WordProcessor {

	Pattern pattern = Pattern.compile("[äåöÄÅÖ]");
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
		Matcher matcher = pattern.matcher(name);
		if (matcher.find()) {
			isSwedishChar = true;
			System.out.println("Provided name with Swedish character.".concat(
					Arrays.toString(Character.toChars(0x270C))));
		}

		if (nameValidator.isLengthValid(name) && nameValidator.isNotNumeric(name)) {
			nameValidator.isFullNameGiven(name);
			return true;
		} else {
			return false;
		}

	}
}
