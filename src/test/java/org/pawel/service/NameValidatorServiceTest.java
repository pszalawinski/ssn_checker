package org.pawel.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class NameValidatorServiceTest {

	NameValidatorService nameValidatorService = new NameValidatorService();

	@Test
	public void shouldReturnTrueWhenNameIsCorrect() {
		//given
		String name = "Löwe";
		//when
		boolean result = nameValidatorService.isValidName(name);
		//then
		assertTrue(result);
	}

	@Test
	public void shouldReturnFalseWhenNameIsEmpty() {
		//given
		String name = "";
		//when
		boolean result = nameValidatorService.isValidName(name);
		//then
		assertFalse(result);
	}

	@Test
	public void shouldReturnFalseWhenNameIsNumeric() {
		//given
		String name = "Löwe1";
		//when
		boolean result = nameValidatorService.isValidName(name);
		//then
		assertFalse(result);
	}
}