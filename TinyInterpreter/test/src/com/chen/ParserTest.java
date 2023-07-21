package com.chen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
		assertEquals(getMethodName(), input, getExpectedForSimpleAssignment());
	}

	@Test
	public void testSimpleAssignmentSomeSpace() {
		String input = " Let xyz = 123 ; ";
		assertEquals(getMethodName(), input, getExpectedForSimpleAssignment());		
	}

	@Test
	public void testSimpleAssignmentLotsOfSpace() {
		String input = "Let     xyz   \n  =      123    ;   ";
		assertEquals(getMethodName(), input, getExpectedForSimpleAssignment());		
	}

	private List<Token> getExpectedForSimpleAssignment() {
		ArrayList<Token> expected = new ArrayList<Token>();
		expected.add(new Token(TokenEnum.LetKeyword));
		expected.add(new Token(TokenEnum.Variable, "xyz"));
		expected.add(new Token(TokenEnum.Assignment));
		expected.add(new Token(TokenEnum.Number, "123"));
		expected.add(new Token(TokenEnum.Semicolon));
		return expected;
	}
	
	@Test
	public void testLetVarPlusNum() {
		String input = "Let  xyz   \n  =    xyz  +  2    ;   ";
		ArrayList<Token> expected = new ArrayList<Token>();
		expected.add(new Token(TokenEnum.LetKeyword));
		expected.add(new Token(TokenEnum.Variable, "xyz"));
		expected.add(new Token(TokenEnum.Assignment));
		expected.add(new Token(TokenEnum.Variable, "xyz"));
		expected.add(new Token(TokenEnum.PlusOp));
		expected.add(new Token(TokenEnum.Number, "2"));
		expected.add(new Token(TokenEnum.Semicolon));
		assertEquals(getMethodName(), input, expected);		
	}

	@Test
	public void testLetVarPlusVar() {
		String input = "Let  xyz   \n  =    abc  +  def    ;   ";
		ArrayList<Token> expected = new ArrayList<Token>();
		expected.add(new Token(TokenEnum.LetKeyword));
		expected.add(new Token(TokenEnum.Variable, "xyz"));
		expected.add(new Token(TokenEnum.Assignment));
		expected.add(new Token(TokenEnum.Variable, "abc"));
		expected.add(new Token(TokenEnum.PlusOp));
		expected.add(new Token(TokenEnum.Variable, "def"));
		expected.add(new Token(TokenEnum.Semicolon));
		assertEquals(getMethodName(), input, expected);		
	}
	
	@Test
	public void testLetNumPlusVar() {
		String input = "Let  xyz   \n  =    2  +  def    ;   ";
		ArrayList<Token> expected = new ArrayList<Token>();
		expected.add(new Token(TokenEnum.LetKeyword));
		expected.add(new Token(TokenEnum.Variable, "xyz"));
		expected.add(new Token(TokenEnum.Assignment));
		expected.add(new Token(TokenEnum.Number, "2"));
		expected.add(new Token(TokenEnum.PlusOp));
		expected.add(new Token(TokenEnum.Variable, "def"));
		expected.add(new Token(TokenEnum.Semicolon));
		assertEquals(getMethodName(), input, expected);		
	}

	@Test
	public void testLetNumPlusNum() {
		String input = "Let  xyz   \n  =    2  +  3    ;   ";
		ArrayList<Token> expected = new ArrayList<Token>();
		expected.add(new Token(TokenEnum.LetKeyword));
		expected.add(new Token(TokenEnum.Variable, "xyz"));
		expected.add(new Token(TokenEnum.Assignment));
		expected.add(new Token(TokenEnum.Number, "2"));
		expected.add(new Token(TokenEnum.PlusOp));
		expected.add(new Token(TokenEnum.Number, "3"));
		expected.add(new Token(TokenEnum.Semicolon));
		assertEquals(getMethodName(), input, expected);		
	}

	@Test
	public void testLetWithParan() {
		String input = "Let  xyz   \n  =   ( 2  +  3  )   ;   ";
		ArrayList<Token> expected = new ArrayList<Token>();
		expected.add(new Token(TokenEnum.LetKeyword));
		expected.add(new Token(TokenEnum.Variable, "xyz"));
		expected.add(new Token(TokenEnum.Assignment));
		expected.add(new Token(TokenEnum.LeftParan));
		expected.add(new Token(TokenEnum.Number, "2"));
		expected.add(new Token(TokenEnum.PlusOp));
		expected.add(new Token(TokenEnum.Number, "3"));
		expected.add(new Token(TokenEnum.RightParan));
		expected.add(new Token(TokenEnum.Semicolon));
		assertEquals(getMethodName(), input, expected);		
	}

	@Test
	public void testLetComplex() {
		String input = "Let  a  =  a * ( 2  + ( b * c ))   ;   ";
		ArrayList<Token> expected = new ArrayList<Token>();
		expected.add(new Token(TokenEnum.LetKeyword));
		expected.add(new Token(TokenEnum.Variable, "a"));
		expected.add(new Token(TokenEnum.Assignment));
		expected.add(new Token(TokenEnum.Variable, "a"));
		expected.add(new Token(TokenEnum.StarOp));
		expected.add(new Token(TokenEnum.LeftParan));
		expected.add(new Token(TokenEnum.Number, "2"));
		expected.add(new Token(TokenEnum.PlusOp));
		expected.add(new Token(TokenEnum.LeftParan));
		expected.add(new Token(TokenEnum.Variable, "b"));
		expected.add(new Token(TokenEnum.StarOp));
		expected.add(new Token(TokenEnum.Variable, "c"));
		expected.add(new Token(TokenEnum.RightParan));
		expected.add(new Token(TokenEnum.RightParan));
		expected.add(new Token(TokenEnum.Semicolon));
		assertEquals(getMethodName(), input, expected);		
	}
	
	@Test
	public void testSimpleShow() {
	    String input = "Show xyz;";
		assertEquals(getMethodName(), input, getExpectedForShow());
	}

	@Test
	public void testSimpleShowSomeSpace() {
		String input = "   Show   xyz  ; ";
		assertEquals(getMethodName(), input, getExpectedForShow());		
	}

	@Test
	public void testSimpleShowLotsOfSpace() {
		String input = "      \t    Show  \t   xyz   \n     ;         ";
		assertEquals(getMethodName(), input, getExpectedForShow());		
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
