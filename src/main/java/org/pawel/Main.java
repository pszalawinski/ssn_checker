package org.pawel;

import org.pawel.adapter.ValidatorController;
import org.pawel.service.NameValidatorService;
import org.pawel.service.SsnValidatorService;

public class Main {

	public static void main(String[] args) {
		ValidatorController validatorController = new ValidatorController(
				new SsnValidatorService(),
				new NameValidatorService());

		validatorController.chooseChecker();
	}
}