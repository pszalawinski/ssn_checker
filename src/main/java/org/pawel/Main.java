package org.pawel;

import org.pawel.Adapter.CheckerController;
import org.pawel.Service.CheckerService;
import org.pawel.utils.SsnUtils;
import org.pawel.validators.LuhnChecksumCalculator;
import org.pawel.validators.SsnValidator;

public class Main {

	public static void main(String[] args) {
		CheckerController checkerController = new CheckerController(
				new CheckerService(
						new SsnValidator(
								new LuhnChecksumCalculator())));
		checkerController.checkSsnNumber();
		checkerController.checkName();
	}
}