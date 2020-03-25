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
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("From MathUtils Class")
class MathUtilsTest {

	TestInfo testInfo;
	TestReporter testReporter;
	MathUtils mathUtils;
	
	@BeforeAll
	void beforeAll() {
		System.out.println("Excecuting Before All.....");
	}
	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter)
	{
		this.testInfo = testInfo;
		this.testReporter = testReporter;
	 mathUtils = new MathUtils();
	 testReporter.publishEntry("Runnig "+ testInfo.getDisplayName()+"with Tags "+testInfo.getTags());
	}
	
	@AfterEach
	void cleanup(){
		System.out.println("cleaning up..........");
	}
	
	@Nested
	@DisplayName("From addTest class")
	@Tag("Math")
	class addTest{
	
	@Test
	void test() {
    assertEquals(4,mathUtils.add(2, 2),"Adding two positive numbers");
	}
    
	
	@Test
	@DisplayName("Testing add method")
	void testadd() {
		int expected= -4;
		int actual = mathUtils.add(-2, -2);
     assertEquals(expected, actual, () -> "Adding two negative numbers" + expected + " result is" +actual);
	}
	
	}
	
	@Test
	@Tag("Math")
	@DisplayName("multiply method")
	void testMultiply() {
	testReporter.publishEntry("Runnig "+ testInfo.getDisplayName()+"with Tags "+testInfo.getTags());
		assertAll(
	() -> assertEquals(4,mathUtils.multiply(2, 2)),
	 () -> assertEquals(6,mathUtils.multiply(2, 3)),
	  () ->assertEquals(8,mathUtils.multiply(4, 2)),
	  () -> assertEquals(-4,mathUtils.multiply(2, -2))
		);	
	}
	
	
	@Test
	//@EnabledOnOs(OS.LINUX)
	@Tag("Math")
	void testDivide() {
		boolean isServerup=false;
    assumeTrue(isServerup);
		assertThrows(ArithmeticException.class,()-> mathUtils.divide(1,0),"Divide by zero");
	}
	
	@Test
	@RepeatedTest(3)
	@Tag("ComputeCricle")
	//void testComputeCircleRadius(RepetitionInfo repetitioninfo)
	void testComputeCircleRadius()
	{
		//repetitioninfo.getCurrentRepetition();
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),"should return right answers");
	}
	
	@Test
	@DisplayName("Testing displayname")
	@Disabled
	void testDisabled() {
		fail("This test should be failed");
	}
}
