package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.Calculator;


class TestCalculator {

	Calculator calculator = new Calculator();

	@Test
	public void Should_add_two_numbers_and_return_result() {
		assertEquals(2, calculator.add(1, 1));
	}

	@ParameterizedTest
	@CsvSource({"0, 0", "0, 1", "1, 0", "1, 1"})
	public void Should_add_two_numbers_and_return_result_parameterized(int valueOne, int valueTwo) {
		assertEquals(valueOne+valueTwo, calculator.add(valueOne, valueTwo));
	}
	
	@Test
	public void Should_substract_two_numbers_and_return_result() {
		assertEquals(1, calculator.sub(1, 0));
	}
	
	@Test
	public void Should_multiply_two_numbers_and_return_result() {
		assertEquals(0, calculator.multiply(1, 0));
	}
	
	@Test
	public void Should_divide_two_numbers_and_return_result() {
		assertEquals(1, calculator.divide(1, 1));
	}
	
	@Test
	public void Should_throw_an_arithmetic_exception_if_denominator_is_zero() {
		Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
		assertEquals("ZeroDivisionError", exception.getMessage());
	}
}
