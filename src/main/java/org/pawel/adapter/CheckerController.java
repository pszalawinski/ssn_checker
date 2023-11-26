package org.pawel.adapter;

import static org.pawel.utils.Constants.*;

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
		System.out.println(MAIN_MESSAGE);
		String input = scanner.nextLine();
		while (!input.equals(EXIT)) {
			switch (input) {
				case "1" -> checkSsnNumber();
				case "2" -> checkName();
			}
			System.out.println(MAIN_MESSAGE);
			input = scanner.nextLine();
		}

	}

	public void checkSsnNumber() {
		System.out.println(SSN_OR_EXIT);
		String input = scanner.nextLine();

		while (!input.equals(EXIT)) {
			if (
					checkerService.isValidSsnNumber(input)) {
				System.out.println("Given SSN is valid ".concat(
						Arrays.toString(CORRECT)));
			}
			System.out.println(SSN_OR_EXIT);
			input = scanner.nextLine();
		}
	}

	public void checkName() {
		System.out.println(NAME_OR_EXIT);
		String input = scanner.nextLine();

		while (!input.equals(EXIT)) {
			if (nameCheckerService.isValidName(input)) {
				System.out.println("Given Name is valid ".concat(
						Arrays.toString(CORRECT)));
			}
			System.out.println(NAME_OR_EXIT);
			input = scanner.nextLine();
		}
	}
}
