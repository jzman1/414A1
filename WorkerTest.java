/*
 * Joshua Zarin
 * 9/8/16
 * CS414 A1
 * WorkerTest.java
 */
package cs414.a1.jzman1;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class WorkerTest {
	@Test
	public void testCreation(){
		//System.out.println('\n' + "-----Testing Worker creation method-----");
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Qualification q3 = new Qualification("Experience");
		Qualification q4 = new Qualification("CDL");
		Qualification q5 = new Qualification("Safety Certification");
		Qualification q6 = new Qualification("Machine operating certificate");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Quals.add(q3);
		Quals.add(q4);
		Quals.add(q5);
		Quals.add(q6);
		Worker test1 = new Worker("Bob",Quals);
		assertNotNull(test1);
		//System.out.println('\n' + "-----End test creation-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testGetName(){
		//System.out.println('\n' + "-----Testing Worker getName method-----");
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Worker test1 = new Worker("Bob",Quals);
		assertEquals(test1.getName(),"Bob");
		//System.out.println('\n' + "Worker name: " + test1.getName());
		Worker test2 = new Worker("",Quals);
		assertEquals(test2.getName(), "");
		assertNotNull(test2);
		//System.out.println('\n' + "-----End test getName-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testGetSalary(){
		//System.out.println('\n' + "-----Testing Worker getSalary method-----");
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Worker test1 = new Worker("Bob",Quals);
		assertTrue(test1.getSalary() == 0.0);
		assertFalse(test1.getSalary() != ((double)0.0));
		//System.out.println('\n' + "-----End test getSalary-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testSetSalary(){
		//System.out.println('\n' + "-----Testing Worker setSalary method-----");
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Worker test1 = new Worker("Bob",Quals);
		assertTrue(test1.getSalary() == 0.0);
		assertFalse(test1.getSalary() != ((double)0.0));
		//System.out.println('\n' + "Test result (default 0.0 value): " + test1.getSalary());
		test1.setSalary(14000.15);
		assertTrue(test1.getSalary() > 0);
		assertTrue(test1.getSalary() == 14000.15);
		//System.out.println('\n' + "Test result (set @ 14000.15): " + test1.getSalary());
		test1.setSalary(-14000.15);
		assertTrue(test1.getSalary() > 0);
		assertTrue(test1.getSalary() == 14000.15);
		//System.out.println('\n' + "Test result (set @ -14000.15, should become positive): " + test1.getSalary());
		//System.out.println('\n' + "-----End test setSalary-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testGetQualifications(){
		//System.out.println('\n' + "-----Testing Worker getQualifications method-----");
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Qualification q3 = new Qualification("Experience");
		Qualification q4 = new Qualification("CDL");
		Qualification q5 = new Qualification("Safety Certification");
		Qualification q6 = new Qualification("Machine operating certificate");
		Set<Qualification> Quals1 = new HashSet<Qualification>();
		Set<Qualification> Quals2 = new HashSet<Qualification>();
		Quals1.add(q1);
		Quals1.add(q2);
		Quals1.add(q3);
		Quals1.add(q4);
		Quals1.add(q5);
		Quals1.add(q6);
		Quals2.add(q1);
		Quals2.add(q2);
		Worker test1 = new Worker("Bob",Quals1);
		assertNotNull(test1);
		//System.out.println('\n' + "Test equality (compare getQualifications and non equal set): " + test1.getQualifications().equals(Quals2));
		assertFalse(test1.getQualifications().equals(Quals2));
		Quals2.add(q3);
		Quals2.add(q4);
		Quals2.add(q5);
		Quals2.add(q6);
		//System.out.println('\n' + "Test equality (compare getQualifications and equal set): " + test1.getQualifications().equals(Quals2));
		assertTrue(test1.getQualifications().equals(Quals2));
		//System.out.println('\n' + "-----End test getQualifications-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testAddQualification(){
		//System.out.println('\n' + "-----Testing Worker addQualification method-----");
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Qualification q3 = new Qualification("Experience");
		Set<Qualification> Quals1 = new HashSet<Qualification>();
		Set<Qualification> Quals2 = new HashSet<Qualification>();
		Quals1.add(q1);
		Quals2.add(q1);
		Quals2.add(q2);
		Quals2.add(q3);
		Worker test1 = new Worker("Bob",Quals1);
		assertNotNull(test1);
		//System.out.println('\n' + "Test equality (compare getQualifications and non equal set): " + test1.getQualifications().equals(Quals2));
		assertFalse(test1.getQualifications().equals(Quals2));
		test1.addQualifications(q2);
		test1.addQualifications(q3);
		//System.out.println('\n' + "Test equality (compare getQualifications after adding Qualificatiosn and equal set): " + test1.getQualifications().equals(Quals2));
		assertTrue(test1.getQualifications().equals(Quals2));
		//System.out.println('\n' + "-----End test addQualification-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testEquals(){
		//System.out.println('\n' + "-----Testing Worker equals method-----");
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Qualification q3 = new Qualification("Experience");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Worker test1 = new Worker("Bob",Quals);
		Worker test2 = new Worker("Bob",Quals);
		//System.out.println('\n' + "Test equality (compare workers with equal names and equal qualifications): " + test1.equals(test2));
		assertTrue(test1.equals(test2));
		Quals.add(q3);
		Worker test3 = new Worker("Bob",Quals);
		//System.out.println('\n' + "Test equality (compare workers with equal names and non equal qualifications): " + test1.equals(test3));
		assertTrue(test1.equals(test3));
		Worker test4 = new Worker("John",Quals);
		//System.out.println('\n' + "Test equality (compare workers with non equal names and non equal qualifications): " + test1.equals(test4));
		assertFalse(test1.equals(test4));
		Quals.remove(q3);
		Worker test5 = new Worker("James",Quals);
		//System.out.println('\n' + "Test equality (compare workers with non equal names and equal qualifications): " + test1.equals(test5));
		assertFalse(test1.equals(test5));
		//System.out.println('\n' + "-----End test equals-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testToString(){
		//System.out.println('\n' + "-----Testing Worker toString method-----");
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Qualification q3 = new Qualification("Experience");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Worker test1 = new Worker("Bob",Quals);
		test1.setSalary(14000.15);
		//System.out.println('\n' + "Test toString (Bob, 0 projects, 2 qualifications, $14000.15 salary): " + test1.toString());
		assertEquals(test1.toString(), "Bob:0:2:14000.15");
		test1.addProject(new Project("Test Project 1", ProjectSize.MEDIUM,ProjectStatus.PLANNED));
		test1.addProject(new Project("Test Project 2", ProjectSize.SMALL,ProjectStatus.SUSPENDED));
		test1.setSalary(25000.09);
		test1.addQualifications(q3);
		//System.out.println('\n' + "Test toString (Bob, 2 projects, 3 qualifications, $25000.09 salary): " + test1.toString());
		assertEquals(test1.toString(), "Bob:2:3:25000.09");
		//System.out.println('\n' + "-----End test toString-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testWillOverload(){
		//System.out.println('\n' + "-----Testing Worker willOverload method-----");
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Qualification q3 = new Qualification("Experience");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Quals.add(q3);
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);	//2
		Project p1 = new Project("Test Project 1", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);	//4
		Project p2 = new Project("Test Project 2", ProjectSize.SMALL,ProjectStatus.ACTIVE);		//5
		Project p3 = new Project("Test Project 3", ProjectSize.BIG,ProjectStatus.ACTIVE);		//8
		Project p4 = new Project("Test Project 4", ProjectSize.BIG,ProjectStatus.ACTIVE);		//11
		Project p6 = new Project("Test Project 6", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);	//15
		Project p7 = new Project("Test Project 7", ProjectSize.BIG,ProjectStatus.ACTIVE);		//15
		Worker test1 = new Worker("Bob",Quals);
		
		
		
		//System.out.println('\n' + "Test willOverload with 0 projects (false)" + test1.willOverload(p0));
		assertFalse(test1.willOverload(p0));
		test1.addProject(p0);
		//System.out.println('\n' + "Test willOverload with load 2 (false)" + test1.willOverload(p1));
		assertFalse(test1.willOverload(p1));
		test1.addProject(p1);
		test1.addProject(p3);
		test1.addProject(p4);
		test1.addProject(p6);
		//System.out.println('\n' + "Test willOverload with load 12 (true)" + test1.willOverload(p2));
		assertTrue(test1.willOverload(p2));
		test1.removeProject(p0);
		//System.out.println('\n' + "Test willOverload with load 10 (false)" + test1.willOverload(p2));
		assertFalse(test1.willOverload(p2));
		//System.out.println('\n' + "Test willOverload with load 10 (true)" + test1.willOverload(p7));
		assertTrue(test1.willOverload(p7));
		//System.out.println('\n' + "-----End test willOverload-----");
		//System.out.println("------------------------------------------------------------");
	}
}
