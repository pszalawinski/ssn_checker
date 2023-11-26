package org.pawel.steps.NameSteps;

import static org.pawel.utils.Constants.WRONG;

import java.util.Arrays;
import org.pawel.validators.NameValidator;

public class BlankNameStep extends WordStep {

	NameValidator nameValidator;
	public BlankNameStep(NameValidator nameValidator) {
		super("BlankNameStep");
		this.nameValidator = nameValidator;
	}
	@Override
	public void setNext(WordStep nextProcessor){
		this.nextProcessor=nextProcessor;
	}

	@Override
	public boolean isNameValid(String name) {
		if (nameValidator.isNotBlank(name) && nextProcessor != null) {
			return nextProcessor.isNameValid(name);
		}
		System.out.println("Name is empty".concat(
				Arrays.toString(WRONG)));
		return false;
	}

}
