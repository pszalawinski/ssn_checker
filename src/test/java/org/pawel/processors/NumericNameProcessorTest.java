package org.pawel.processors;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.pawel.validators.NameValidator;

public class NumericNameProcessorTest {

	NameValidator nameValidator;
	NumericNameProcessor numericNameProcessor;

	@BeforeEach
	void before(){
		this.nameValidator = new NameValidator();
		this.numericNameProcessor = new NumericNameProcessor(nameValidator);

	}

	@ParameterizedTest
	@ValueSource(strings = {"Mar2it", "Lowe1", "123"})
	void shouldReturnFalseIfNameHasNumbersOrTooShort(String name){
		//given
		//when
		//then
		assertFalse(numericNameProcessor.isNameValid(name));
	}

}