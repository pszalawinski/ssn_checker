package org.pawel;

import org.pawel.adapter.CheckerController;
import org.pawel.service.NameCheckerService;
import org.pawel.service.SsnCheckerService;

public class Main {

	public static void main(String[] args) {
		CheckerController checkerController = new CheckerController(
				new SsnCheckerService(),
				new NameCheckerService());

		checkerController.chooseChecker();
	}
}