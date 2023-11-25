package org.pawel.validators;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LuhnChecksumCalculatorTest {

	LuhnChecksumCalculator luhnChecksumCalculator = new LuhnChecksumCalculator();

	@ParameterizedTest
	@ValueSource(strings = {"6202013899", "9308310128", "7106237113"})
	void shouldReturnTrueForCorrectChecksum(String ssn) {
		//given
		//when
		boolean result = luhnChecksumCalculator.calculateChecksum(ssn);
		//then
		assertTrue(result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"6202013892", "9308310121", "7106237114"})
	void shouldReturnFalseForIncorrectChecksum(String ssn) {
		//given
		//when
		boolean result = luhnChecksumCalculator.calculateChecksum(ssn);
		//then
		assertFalse(result);
	}
}