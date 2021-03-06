package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class CalculatorTest {

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testUnknownNumbers(){
    	assertEquals(10, Calculator.add("1,2,3,4"));
    }

    @Test
    public void testHandlesNewLines(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumber() throws Exception{
    	Calculator.add("-1,2,-5");
    }

    @Test
    public void testBiggerThan1000(){
    	assertEquals(2, Calculator.add("1001,2"));
    }

    @Test
    public void testHandleDelimeters(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }
}