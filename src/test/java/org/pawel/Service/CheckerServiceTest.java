package org.pawel.Service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.pawel.utils.SsnUtils;
import org.pawel.validators.LuhnChecksumCalculator;
import org.pawel.validators.SsnValidator;

class CheckerServiceTest {

	LuhnChecksumCalculator luhnChecksumCalculator = new LuhnChecksumCalculator();
	SsnValidator ssnValidator = new SsnValidator(luhnChecksumCalculator);
	SsnUtils ssnUtils = new SsnUtils();
	CheckerService checkerService = new CheckerService(ssnValidator, ssnUtils);

	@ParameterizedTest
	@ValueSource(strings = {"19620201-3899", "196202013899","1962 0201 38 99", "620201-3899", "710 6237 113", "930831 0128"})
	void ssnIsProperlyPrepared(String rawSsn){
		//given
		//when
		boolean result = checkerService.isValidSsnNumber(rawSsn);
		//then
		assertTrue(result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"19620201-389", "19620201389","1962 0201 38 9", "620201-389", "710 6237 11", "9308", "930831 012123"})
	void ssnIsInProperlyGiven(String rawSsn){
		//given
		//when
		boolean result = checkerService.isValidSsnNumber(rawSsn);
		//then
		assertFalse(result);
	}
  
}