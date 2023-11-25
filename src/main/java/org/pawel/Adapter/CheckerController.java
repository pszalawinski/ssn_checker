package org.pawel.Adapter;

import java.util.Scanner;
import org.pawel.Service.CheckerService;

public class CheckerController {

	CheckerService checkerService;

	public CheckerController(CheckerService checkerService) {
		this.checkerService = checkerService;
	}

	public void checkSsnNumber() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Provide SSN or type exit");
		String input = scanner.next();

		while (!input.equals("exit")) {
			if (
					checkerService.isValidSsnNumber(input)) {
				System.out.println("Given SSN is valid");
			}
			input = scanner.next();
		}
	}

	public void checkName() {

		System.out.println("nemen");
	}
}
