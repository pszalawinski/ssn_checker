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
		String ssnNumber = scanner.next();
		checkerService.isValidSsnNumber(ssnNumber);
	}

	public void checkName() {

		System.out.println("nemen");
	}
}
