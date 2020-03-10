package com.openclassrooms.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	private int nombre1;
	private int nombre2;
	Calculator calculatrice = new Calculator();

	@Test
	void shouldAddTwoNumber() {
		nombre1 = 2;
		nombre2 = 3;
		assertEquals(5, calculatrice.add(nombre1, nombre2));
	}

	@Test
	void substract() {
		nombre1 = 10;
		nombre2 = 5;
		assertEquals(5, calculatrice.substract(nombre1, nombre2));
	}

	@Test
	void multiply() {
		nombre1 = 3;
		nombre2 = 3;
		assertEquals(9, calculatrice.multiply(nombre1, nombre2));
	}
}
