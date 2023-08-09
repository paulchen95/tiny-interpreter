package com.chen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.chen.node.LetNode;

import junit.framework.TestCase;

public class ASTTest extends TestCase {

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
	public void testSimpleLet() {
		// Setup a list of Tokens
		ArrayList<Token> list = new ArrayList<Token>();
		list.add(new Token(TokenEnum.LetKeyword));
		list.add(new Token(TokenEnum.Variable, "xyz"));
		list.add(new Token(TokenEnum.Assignment));
		list.add(new Token(TokenEnum.Number, "2"));
		list.add(new Token(TokenEnum.Semicolon));
		
		// Test making a LetNode
		Tuple result = new LetNode().makeNode(list, 0);
		
		assertEquals("result.getNext() must return 5", 5, result.getNext());
		
	}
	
	private List<Token> getExpectedForShow() {
		ArrayList<Token> expected = new ArrayList<Token>();
		expected.add(new Token(TokenEnum.ShowKeyword));
		expected.add(new Token(TokenEnum.Variable, "xyz"));
		expected.add(new Token(TokenEnum.Semicolon));
		return expected;
	}
	
	private void assertEquals(String methodName, String input, List<Token> expected) {
		Parser p = new Parser();
		List<Token> actual = p.parse(input);
		System.out.println("-----------------------------------------");
		System.out.println("Test Method: " + methodName);
		System.out.println("Expected: " + Arrays.toString(expected.toArray()));
		System.out.println("Actually: " + Arrays.toString(actual.toArray()));
		
		assertEquals(expected, actual);
	}
	
	private void assertEquals(List<Token> expected, List<Token> actual) {
		Assert.assertNotNull("expected Array<Token> must not be null", expected);
		Assert.assertNotNull("actual Array<Token> must not be null", actual);
		Assert.assertEquals("# of elements must match: expected.size() = " + expected.size() + ", actual.size() = " + actual.size(), 
			expected.size(), actual.size());
		for (int x = 0; x < expected.size(); x++) {
			Assert.assertEquals("Token mismatch at index " + x + ", expected: \"" + expected.get(x) + "\" but got actual: \"" + actual.get(x) + "\"",
				expected.get(x), actual.get(x));
		}
	}
	
	private String getMethodName() {
	    StackWalker walker = StackWalker.getInstance();
	    Optional<String> methodName = walker.walk(frames -> frames
	      .skip(1)
	      .findFirst()
	      .map(StackWalker.StackFrame::getMethodName));
	    return methodName.isPresent() ? methodName.get() : "unknown";
	}
 }
