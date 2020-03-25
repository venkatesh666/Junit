package io.junit5;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

	MathUtils mathUtils;
	
	@BeforeAll
	void beforeAll() {
		System.out.println("Excecuting Before All.....");
	}
	@BeforeEach
	void init()
	{
	 mathUtils = new MathUtils();
	}
	
	@AfterEach
	void cleanup(){
		System.out.println("cleaning up..........");
	}
	
	
	@Test
	@DisplayName("Testing add method")
	void test() {
      int expected = 3;
     int actual=  mathUtils.add(1, 2);
      assertEquals(expected, actual,"add method");
	}
    
	@Test
	@DisplayName("multiply method")
	void testMultiply() {
	assertAll(
	() -> assertEquals(4,mathUtils.multiply(2, 2)),
	 () -> assertEquals(6,mathUtils.multiply(2, 3)),
	  () ->assertEquals(8,mathUtils.multiply(4, 2)),
	  () -> assertEquals(-4,mathUtils.multiply(2, -2))
		);	
	}
	
	
	@Test
	//@EnabledOnOs(OS.LINUX)
	void testDivide() {
		boolean isServerup=false;
    assumeTrue(isServerup);
		assertThrows(ArithmeticException.class,() -> mathUtils.divide(1,0),"Divide by zero");
	}
	
	@Test
	void testComputeCircleRadius()
	{
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),"should return right answers");
	}
	
	@Test
	@DisplayName("Testing displayname")
	@Disabled
	void testDisabled() {
		fail("This test should be failed");
	}
}
