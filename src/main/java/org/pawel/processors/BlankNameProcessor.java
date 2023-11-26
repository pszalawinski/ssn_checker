package org.pawel.processors;

import java.util.Arrays;
import org.pawel.validators.NameValidator;

public class BlankNameProcessor extends WordProcessor {

	NameValidator nameValidator;
	public BlankNameProcessor(NameValidator nameValidator) {
		super("BlankNameProcessor");
		this.nameValidator = nameValidator;
	}
	@Override
	public void setNext(WordProcessor nextProcessor){
		this.nextProcessor=nextProcessor;
	}

	@Override
	public boolean isNameValid(String name) {
		if (nameValidator.isNotBlank(name) && nextProcessor != null) {
			return nextProcessor.isNameValid(name);
		}
		System.out.println("Name is empty".concat(
				Arrays.toString(Character.toChars(0x274C))));
		return false;
	}

}
