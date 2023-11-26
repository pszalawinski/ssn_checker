package org.pawel.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mockito;
import org.pawel.processors.NumericNameProcessor;
import org.pawel.processors.SwedishNameProcessor;

public class NameCheckerServiceTest {

	NameCheckerService nameCheckerService = new NameCheckerService();

	SwedishNameProcessor swedishNameProcessor = mock(SwedishNameProcessor.class);
	NumericNameProcessor numericWordProcessor = mock(NumericNameProcessor.class);

	@Test
	public void shouldReturnTrueWhenNameIsCorrect() {
		//given
		String name = "Löwe";
		//when
		boolean result = nameCheckerService.isValidName(name);
		//then
		assertTrue(result);
	}

	@Test
	public void shouldReturnFalseWhenNameIsEmpty() {
		//given
		String name = "";
		//when
		boolean result = nameCheckerService.isValidName(name);
		//then
		Mockito.verifyNoInteractions(numericWordProcessor);
		Mockito.verifyNoInteractions(swedishNameProcessor);
		assertFalse(result);
	}

	@Test
	public void shouldReturnFalseWhenNameIsNumeric() {
		//given
		String name = "Löwe1";
		//when
		boolean result = nameCheckerService.isValidName(name);
		//then
		Mockito.verifyNoInteractions(swedishNameProcessor);
		assertFalse(result);
	}
}