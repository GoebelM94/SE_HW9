package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.Calendar;

class TestCalendar {

	@ParameterizedTest
	@ValueSource(ints = {1960, 1984, 2000, 2004, 2024})
	public void Should_return_true(int year) {
		assertTrue(new Calendar(year).isLeapYear());
	}

	@ParameterizedTest
	@ValueSource(ints = {1900, 1999, 2003, 2011, 2014})
	public void Should_return_false(int year) {
		assertFalse(new Calendar(year).isLeapYear());
	}

	@ParameterizedTest
	@ValueSource(ints = {2000})
	public void Should_return_if_year_is_leap(int year) {
		GregorianCalendar gc = new GregorianCalendar(year, 1, 1, 1, 1, 1);
		assertTrue(gc.isLeapYear(year));
	}

	@Test
	public void Boundary_test() {
		Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Calendar(0).isLeapYear());
		assertEquals("Year has to be a positive integer value", exception.getMessage());
	}
	
}
