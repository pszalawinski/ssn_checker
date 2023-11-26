package org.pawel;

import java.io.IOException;
import org.pawel.adapter.CheckerController;
import org.pawel.service.NameCheckerService;
import org.pawel.service.SsnCheckerService;
import org.pawel.validators.LuhnChecksumCalculator;
import org.pawel.validators.SsnValidator;

public class Main {

	public static void main(String[] args) throws IOException {
		CheckerController checkerController = new CheckerController(
				new SsnCheckerService(
						new SsnValidator(
								new LuhnChecksumCalculator())), new NameCheckerService());
		checkerController.chooseChecker();
	}
}