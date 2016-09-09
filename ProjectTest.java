/*
 * Joshua Zarin
 * 9/8/16
 * CS414 A1
 * Project.java
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class ProjectTest {
	@Test
	public void testCreation(){
		System.out.println('\n' + "-----Testing Project creation method-----");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		System.out.println('\n' + "Test constructor with p0 (checking if not null)");
		assertNotNull(p0);
		System.out.println('\n' + "-----End test creation-----");
		System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testGetName(){
		System.out.println('\n' + "-----Testing Project getName method-----");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		System.out.println('\n' + "Test getName with p0 (name = Test Project 0): " + p0.getName());
		assertTrue(p0.getName() == "Test Project 0");
		System.out.println('\n' + "-----End test getName-----");
		System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testGetSize(){
		System.out.println('\n' + "-----Testing Project getSize method-----");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		System.out.println('\n' + "Test getSize with p0 (size = MEDIUM): " + p0.getSize());
		assertEquals(p0.getSize(), ProjectSize.MEDIUM);
		assertFalse(p0.getSize() != ProjectSize.MEDIUM);
		System.out.println('\n' + "-----End test getSize-----");
		System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testGetStatus(){
		System.out.println('\n' + "-----Testing Project getStatus method-----");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		System.out.println('\n' + "Test getStatus with p0 (status = ACTIVE): " + p0.getStatus());
		assertTrue(p0.getStatus() == ProjectStatus.ACTIVE);
		assertTrue(p0.getStatus() != ProjectStatus.PLANNED);
		System.out.println('\n' + "-----End test getStatus-----");
		System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testGetProjectWorkers(){
		System.out.println('\n' + "-----Testing Project getProjectWorkers method-----");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Worker test1 = new Worker("Bob",Quals);
		Worker test2 = new Worker("Loe",Quals);
		Worker test3 = new Worker("EE",Quals);
		Worker test4 = new Worker("EEt",Quals);
		Set<Worker> workerss = new HashSet<Worker>();
		workerss.add(test1);
		workerss.add(test2);
		workerss.add(test3);
		p0.addWorker(test1);
		p0.addWorker(test2);
		p0.addWorker(test3);
		System.out.println('\n' + "Test getProjectWorkers (Test Project 0, 3 workers): " + p0.getProjectWorkers());
		assertEquals(p0.getProjectWorkers(),workerss);
		p0.removeWorker(test1);
		workerss.remove(test1);
		assertEquals(p0.getProjectWorkers(),workerss);
		p0.addWorker(test4);
		workerss.add(test4);
		assertEquals(p0.getProjectWorkers(),workerss);
		System.out.println('\n' + "-----End test getProjectWorkers-----");
		System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testSetStatus(){
		System.out.println('\n' + "-----Testing Project setStatus method-----");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		System.out.println('\n' + "Test setStatus with p0 (status = ACTIVE): " + p0.getStatus());
		assertTrue(p0.getStatus() == ProjectStatus.ACTIVE);
		assertTrue(p0.getStatus() != ProjectStatus.PLANNED);
		p0.setStatus(ProjectStatus.PLANNED);
		System.out.println('\n' + "Test setStatus with p0 (status = PLANNED): " + p0.getStatus());
		assertFalse(p0.getStatus() == ProjectStatus.ACTIVE);
		assertTrue(p0.getStatus() == ProjectStatus.PLANNED);
		System.out.println('\n' + "-----End test setStatus-----");
		System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testEquals(){
		System.out.println('\n' + "-----Testing Project testEquals method-----");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		Project p1 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		Project p2 = new Project("Test Project 1", ProjectSize.BIG,ProjectStatus.PLANNED);
		Project p3 = new Project("Test Project 1", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		System.out.println('\n' + "Test equals with p0 and p1 (equal): " + p0.equals(p1));
		assertTrue(p0.equals(p1));
		assertEquals(p0, p1);
		System.out.println('\n' + "Test equals with p0 and p2 and p3 (non equal): " + p0.equals(p2));
		assertFalse(p0.equals(p2));
		assertFalse(p0.equals(p3));
		System.out.println('\n' + "-----End test testEquals-----");
		System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testToString(){
		System.out.println('\n' + "-----Testing Project toString method-----");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Worker test1 = new Worker("Bob",Quals);
		Worker test2 = new Worker("Loe",Quals);
		Worker test3 = new Worker("EE",Quals);
		p0.addWorker(test1);
		p0.addWorker(test2);
		p0.addWorker(test3);
		System.out.println('\n' + "Test toString (Test Project 0, 3 workers, ACTIVE status): " + p0.toString());
		assertEquals(p0.toString(), "Test Project 0:3:ACTIVE");
		assertFalse(p0.toString() == "NULL");
		System.out.println('\n' + "-----End test toString-----");
		System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testMissingQualifications(){
		System.out.println('\n' + "-----Testing Project missingQualifications method-----");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Qualification q3 = new Qualification("Completion accuracy");
		Qualification q4 = new Qualification("Completion cost");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Worker test1 = new Worker("Bob",new HashSet<Qualification>(Quals));
		Quals.add(q3);
		Worker test2 = new Worker("Loe",new HashSet<Qualification>(Quals));
		Quals.add(q4);
		p0.missingQualifications = new HashSet<Qualification>(Quals);
		p0.addWorker(test1);
		p0.addWorker(test2);
		System.out.println('\n' + "Test missingQualifications (missing Completion cost)");
		Quals.remove(q1);
		Quals.remove(q2);
		Quals.remove(q3);
		assertEquals(p0.missingQualifications(),Quals);
		assertTrue(p0.missingQualifications().size() == Quals.size());
		System.out.println('\n' + "-----End test missingQualificatiosn-----");
		System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testAddWorker(){
		System.out.println('\n' + "-----Testing Project addWorker method-----");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Worker test1 = new Worker("Bob",Quals);
		Worker test2 = new Worker("Loe",Quals);
		Worker test3 = new Worker("EE",Quals);
		Worker test4 = new Worker("EEt",Quals);
		p0.addWorker(test1);
		p0.addWorker(test2);
		p0.addWorker(test3);
		System.out.println('\n' + "Test addWorker (Test Project 0, 3 workers): " + p0.getProjectWorkers().size());
		assertEquals(p0.getProjectWorkers().size(),3);
		p0.addWorker(test4);
		assertTrue(p0.getProjectWorkers().size() > 3);
		System.out.println('\n' + "-----End test addWorker-----");
		System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testRemoveWorker(){
		System.out.println('\n' + "-----Testing Project removeWorker method-----");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Worker test1 = new Worker("Bob",Quals);
		Worker test2 = new Worker("Loe",Quals);
		Worker test3 = new Worker("EE",Quals);
		p0.addWorker(test1);
		p0.addWorker(test2);
		p0.addWorker(test3);
		System.out.println('\n' + "Test removeWorker (Test Project 0, 3 workers): " + p0.getProjectWorkers().size());
		assertEquals(p0.getProjectWorkers().size(),3);
		p0.removeWorker(test1);
		assertTrue(p0.getProjectWorkers().size() < 3);
		System.out.println('\n' + "-----End test removeWorker-----");
		System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testIsHelpful(){
		System.out.println('\n' + "-----Testing Project isHelpful method-----");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Qualification q3 = new Qualification("Completion accuracy");
		Qualification q4 = new Qualification("Completion cost");
		Qualification q5 = new Qualification("HR training");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Worker test1 = new Worker("Bob",new HashSet<Qualification>(Quals));
		Quals.add(q3);
		Worker test2 = new Worker("Loe",new HashSet<Qualification>(Quals));
		Quals.add(q4);
		p0.missingQualifications = new HashSet<Qualification>(Quals);
		p0.addWorker(test1);
		p0.addWorker(test2);
		System.out.println('\n' + "Test missingQualifications (missing Completion cost)");
		Quals.remove(q1);
		Quals.remove(q2);
		Quals.remove(q3);
		Worker test3 = new Worker("Carl",new HashSet<Qualification>(Quals));
		assertTrue(p0.isHelpful(test3));
		Quals.add(q5);
		Quals.remove(q4);
		Worker test4 = new Worker("Carlos",new HashSet<Qualification>(Quals));
		assertFalse(p0.isHelpful(test4));
		System.out.println('\n' + "-----End test isHelpful-----");
		System.out.println("------------------------------------------------------------");
	}
}