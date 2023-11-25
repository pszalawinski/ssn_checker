package org.pawel;

import java.io.IOException;
import org.pawel.Adapter.CheckerController;
import org.pawel.Service.SsnCheckerService;
import org.pawel.validators.LuhnChecksumCalculator;
import org.pawel.validators.SsnValidator;

public class Main {

	public static void main(String[] args) throws IOException {
		CheckerController checkerController = new CheckerController(
				new SsnCheckerService(
						new SsnValidator(
								new LuhnChecksumCalculator())));
		checkerController.chooseChecker();
	}
}