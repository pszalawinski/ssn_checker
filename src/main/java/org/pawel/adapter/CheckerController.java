package org.pawel.adapter;

import java.util.Arrays;
import java.util.Scanner;
import org.pawel.service.NameCheckerService;
import org.pawel.service.SsnCheckerService;

public class CheckerController {

	SsnCheckerService checkerService;
	NameCheckerService nameCheckerService;
	Scanner scanner = new Scanner(System.in);

	public CheckerController(SsnCheckerService checkerService,
			NameCheckerService nameCheckerService) {
		this.checkerService = checkerService;
		this.nameCheckerService = nameCheckerService;
	}

	public void chooseChecker() {
		System.out.println("Do you want to check SSN [1] or name [2]? For exit, type exit.");
		String input = scanner.nextLine();
		while (!input.equals("exit")) {
			switch (input) {
				case "1" -> checkSsnNumber();
				case "2" -> checkName();
			}
			System.out.println("Do you want to check SSN [1] or name [2]? For exit, type exit.");
			input = scanner.nextLine();
		}

	}

	public void checkSsnNumber() {
		System.out.println("Provide SSN or type exit");
		String input = scanner.nextLine();

		while (!input.equals("exit")) {
			if (
					checkerService.isValidSsnNumber(input)) {
				System.out.println("Given SSN is valid ".concat(
						Arrays.toString(Character.toChars(0x2705))));
			}
			System.out.println("Provide SSN or type exit");
			input = scanner.nextLine();
		}
	}

	public void checkName() {
		System.out.println("Provide name or type exit");
		String input = scanner.nextLine();

		while (!input.equals("exit")) {
			if (nameCheckerService.isValidName(input)) {
				System.out.println("Given Name is valid ".concat(
						Arrays.toString(Character.toChars(0x2705))));
			}
			System.out.println("Provide name or type exit");
			input = scanner.nextLine();
		}
	}
}
