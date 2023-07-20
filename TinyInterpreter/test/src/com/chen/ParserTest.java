package com.chen;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class ParserTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }
	
	@Test
	public void testAlwaysPassForSure() {
		Assert.assertTrue(true);
	}

	@Test
	public void testSimpleAssignment() {
		String input = "Let xyz=123;";
		ArrayList<Token> expected = new ArrayList<Token>();
		expected.add(new Token(TokenEnum.LetKeyword, null));
		expected.add(new Token(TokenEnum.Variable, "xyz"));
		expected.add(new Token(TokenEnum.Assignment, null));
		expected.add(new Token(TokenEnum.Number, "123"));
		expected.add(new Token(TokenEnum.Semicolon, null));
		assertEquals(input, expected);
	}
	
	private void assertEquals(String input, List<Token> expected) {
		Parser p = new Parser();
		List<Token> actual = p.parse(input);
		assertEquals(expected, actual);
	}
	
	private void assertEquals(List<Token> expected, List<Token> actual) {
		Assert.assertNotNull("expected Array<Token> must not be null", expected);
		Assert.assertNotNull("actual Array<Token> must not be null", actual);
		Assert.assertEquals("# of elements must match: expected.size() = " + expected.size() + ", actual.size() = " + actual.size(), 
			expected.size(), actual.size());
		for (int x = 0; x < expected.size(); x++) {
			Assert.assertEquals("Token mismatch at index " + x + ", expected: " + expected.get(x) + " but got actual: " + actual.get(x), 
				expected.get(x), actual.get(x));
		}
	}
}
