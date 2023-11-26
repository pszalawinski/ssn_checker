package org.pawel.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SsnCheckerServiceTest {

	SsnCheckerService checkerService = new SsnCheckerService();

	@ParameterizedTest
	@ValueSource(strings = {
			"19620201-3899",
			"196202013899", "1962 0201 38 99", "620201-3899",
			"710 6237 113", "930831 0128",
			"19000201-389+",
			"000201-389+"}
	)
	void ssnIsProperlyPrepared(String rawSsn) {
		//given
		//when
		boolean result = checkerService.isValidSsnNumber(rawSsn);
		//then
		assertTrue(result);
	}

	@ParameterizedTest
	@ValueSource(strings = {
			"A9620201-389", "A19620201-389", "19620201-389", "19620201389",
			"1962 0201 38 9", "620201-389", "710 6237 11", "9308", "930831 012123",
			"19900201-389+", "900201-389+", "550201-389+", "19929898123+"})
	void ssnIsInProperlyGiven(String rawSsn) {
		//given
		//when
		boolean result = checkerService.isValidSsnNumber(rawSsn);
		//then
		assertFalse(result);
	}
}