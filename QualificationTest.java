/*
 * Joshua Zarin
 * 9/8/16
 * CS414 A1
 * QualificationTest.java
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class QualificationTest {
	@Test
	public void testObjects(){
		System.out.println("Testing qualification creation");
		Qualification test1 = new Qualification("This is a test");
		assertNotNull("test 1 doesn't exist!",test1);
		Qualification test2 = new Qualification("This is a test");
		assertEquals("Objects 1 and 2 are not equal",test1, test2);
		Qualification test3 = test1;
		assertSame("Objects 3 and 1 aren't the same", test3, test1);
		System.out.println("-----End test creation-----");
	}
	
	@Test
	public void testToString(){
		System.out.println("Testing qualification toString method");
		Qualification test1 = new Qualification("This is a test");
		String tester = "This is a test";
		String ftester = "This is not a test";
		assertTrue("Object 1 doesn't equal correct string",test1.toString() == tester);
		System.out.println(test1.toString());
		assertFalse("object 1 equals incorrect string",test1.toString() == ftester);
		System.out.println("-----End test toString-----");
	}
	
	@Test
	public void testEquals(){
		System.out.println("Testing qualification equals method");
		Qualification test1 = new Qualification("This is a test");
		assertNotNull("test 1 doesn't exist!",test1);
		Qualification test2 = new Qualification("This is a test");
		assertTrue("Objects 1 and 2 are not equal according to their override equals", test1.equals(test2));
		Qualification test3 = new Qualification("This is not a test");
		assertFalse("Objects 3 and 1 are equal", test3.equals(test1));
		System.out.println(test1.equals(test2));
		System.out.println(test1.equals(test3));
		System.out.println("-----End test equals-----");
	}
}
