package com.capraro;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SpecificationTest {

	private Specification<String> startsWithA;
	private Specification<String> shortString;

	@Before
	public void setSpecifications() {
		shortString = s -> s.length() < 3;
		startsWithA = s -> s.length() > 0 && s.charAt(0) == 'a';		
	}
	
	@Test
	public void shouldCheckStringsNot() {
		assertThat(shortString.not().isSatisfiedBy("bcdefg"), is(true));
	}

	@Test
	public void shouldCheckStringsAnd() {
		assertThat(shortString.and(startsWithA).isSatisfiedBy("bc"), is(false));
	}
	
	@Test
	public void shouldCheckStringsOr() {
		assertThat(shortString.or(startsWithA).isSatisfiedBy("bc"), is(true));
	}
	
	@Test
	public void shouldCheckStringsAndOr() {
		assertThat(shortString.or(startsWithA).isSatisfiedBy("bc"), is(true));
	}
}

