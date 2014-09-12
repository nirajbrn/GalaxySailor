package com.test.merchant.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.merchant.guide.logic.ConvertorLogic;

public class ConvertorLogicTest {

	protected Character[] characterArray;
	protected Character character;

	@Before
	public void setUp() throws Exception {
		character = 'P';
		characterArray = new Character[]{'I','X','V','L'};

	}

	@Test
	public void testOutputFormatter(){
		boolean result = ConvertorLogic.checkIfLiteralPresent(characterArray, character);
		Assert.assertEquals(false, result);
	}

	@Test

	/**
	 * Test whether the subtraction logic is handled correctly.
	 */
	public void testSubtractionLogic(){
		float result = ConvertorLogic.subtractionLogic(52f, 10f, 50f);
		Assert.assertEquals(42f, result, 00.00);
	}
}
