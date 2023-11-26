package org.pawel.processors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.pawel.validators.NameValidator;


class SwedishNameProcessorTest {
	NameValidator nameValidator;
	SwedishNameProcessor swedishNameProcessor;

	@BeforeEach
	void before(){
		this.nameValidator = new NameValidator();
		this.swedishNameProcessor = new SwedishNameProcessor(nameValidator);

	}

	@ParameterizedTest
	@ValueSource(strings = {"Märit", "Löwe", "Kåre", "Kåre Olsson"})
	void shouldReturnInformationThatNameHasSwedishChar(String name){
		//given
		//when
		swedishNameProcessor.isNameValid(name);
		//then
		assertTrue(swedishNameProcessor.isSwedishChar);
	}

	@ParameterizedTest
	@ValueSource(strings = {"Marit", "Lowe", "Kare"})
	void shouldReturnInformationThatNameHasNotSwedishChar(String name){
		//given
		//when
		swedishNameProcessor.isNameValid(name);
		//then
		assertFalse(swedishNameProcessor.isSwedishChar);
	}

	@ParameterizedTest
	@ValueSource(strings = {"Mar2it", "Lowe1", "123","o"})
	void shouldReturnFalseIfNameHasNumbersOrTooShort(String name){
		//given
		//when
		//then
		assertFalse(swedishNameProcessor.isNameValid(name));
	}

}