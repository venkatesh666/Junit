package io.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void test() {
      MathUtils mathUtils = new  MathUtils();
      int expected = 3;
     int actual=  mathUtils.add(1, 2);
      assertEquals(expected, actual,"add method");
	}
    
	
	@Test
	void testComputeCircleRadius()
	{
		MathUtils mathUtils = new MathUtils();
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),"should return right answers");
	}
}
