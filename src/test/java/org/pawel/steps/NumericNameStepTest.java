package org.pawel.steps;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.pawel.steps.NameSteps.NumericNameStep;
import org.pawel.validators.NameValidator;

public class NumericNameStepTest {

	NameValidator nameValidator;
	NumericNameStep numericNameStep;

	@BeforeEach
	void before(){
		this.nameValidator = new NameValidator();
		this.numericNameStep = new NumericNameStep(nameValidator);

	}

	@ParameterizedTest
	@ValueSource(strings = {"Mar2it", "Lowe1", "123"})
	void shouldReturnFalseIfNameHasNumbersOrTooShort(String name){
		//given
		//when
		//then
		assertFalse(numericNameStep.isNameValid(name));
	}

}