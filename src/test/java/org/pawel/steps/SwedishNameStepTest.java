package org.pawel.steps;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.pawel.steps.NameSteps.SwedishNameStep;
import org.pawel.validators.NameValidator;

class SwedishNameStepTest {

	NameValidator nameValidator;
	SwedishNameStep swedishNameStep;

	@BeforeEach
	void before() {
		this.nameValidator = new NameValidator();
		this.swedishNameStep = new SwedishNameStep(nameValidator);

	}

	@ParameterizedTest
	@ValueSource(strings = {"Märit", "Löwe", "Kåre", "Kåre Olsson"})
	void shouldReturnInformationThatNameHasSwedishChar(String name) {
		//given
		//when
		swedishNameStep.isNameValid(name);
		//then
		assertTrue(swedishNameStep.isSwedishChar);
	}

	@ParameterizedTest
	@ValueSource(strings = {"Marit", "Lowe", "Kare"})
	void shouldReturnInformationThatNameHasNotSwedishChar(String name) {
		//given
		//when
		swedishNameStep.isNameValid(name);
		//then
		assertFalse(swedishNameStep.isSwedishChar);
	}
}