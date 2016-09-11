/*
 * Joshua Zarin
 * 9/8/16
 * CS414 A1
 * WorkerTest.java
 */

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
public class CompanyTest {

	@Test
	public void testCreate(){
		//System.out.println('\n' + "-----Testing Project constructor-----");
		Company test1 = new Company("test company 1");
		assertNotNull(test1);
		//System.out.println('\n' + "-----End test constructor-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	public void testGetName(){
		//System.out.println('\n' + "-----Testing Project getName method-----");
		Company test1 = new Company("test company 1");
		assertFalse(test1.getName() != "test company 1");
		assertEquals(test1.getName(),"test company 1");
		//System.out.println('\n' + "-----End test getName-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testGetAvailableWorkers(){
		//System.out.println('\n' + "-----Testing Company getAvailableWorkers method-----");
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Set<Worker> Workers = new HashSet<Worker>();
		Worker test1 = new Worker("Bob",Quals);
		Worker test2 = new Worker("Loe",Quals);
		Workers.add(test1);
		Workers.add(test2);
		Company testc = new Company("test company 1");
		testc.addToAvailableWorkerPool(test1);
		testc.addToAvailableWorkerPool(test2);
		assertEquals(testc.getAvailableWorkers(),Workers);
		//System.out.println('\n' + "-----End test getAvailableWorkers-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testGetAssignedWorkers(){
		//System.out.println('\n' + "-----Testing Company getAssignedWorkers method-----");
		//System.out.println('\n' + "-----End test getAssignedWorkers-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testEquals(){
		//System.out.println('\n' + "-----Testing Company equals method-----");
		Company test1 = new Company("test1");
		Company test2 = new Company("test2");
		Company test3 = new Company("test1");
		assertEquals(test1,test3);
		assertTrue(test1.equals(test3));
		assertFalse(test1.equals(test2));
		//System.out.println('\n' + "-----End test equals-----");
		//System.out.println("------------------------------------------------------------");
	}

	@Test
	public void testToString(){
		//System.out.println('\n' + "-----Testing Company toString method-----");
		Company test = new Company("test");
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Worker test1 = new Worker("Bob",Quals);
		Worker test2 = new Worker("Loe",Quals);
		test.createProject("p", Quals, ProjectSize.MEDIUM, ProjectStatus.ACTIVE);
		test.addToAvailableWorkerPool(test1);
		test.addToAvailableWorkerPool(test2);
		assertEquals(test.toString(), "test:2:1");
		//System.out.println('\n' + "-----End test toString-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testAddToAvailableWorkerPool(){
		//System.out.println('\n' + "-----Testing Company addToAvailableWorkerPool method-----");
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		Worker test1 = new Worker("Bob",Quals);
		Worker test2 = new Worker("Loe",Quals);
		Company testc = new Company("test company 1");
		testc.addToAvailableWorkerPool(test1);
		testc.addToAvailableWorkerPool(test2);
		assertEquals(testc.availableWorkerPool.size(),2);
		//System.out.println('\n' + "-----End test addToAvailableWorkerPool-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testAssign(){
		//System.out.println('\n' + "-----Testing Company assign method-----");
		Company test = new Company("test");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.PLANNED);
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
		assertEquals(test.getAssignedWorkers().size(),0);
		test.addToAvailableWorkerPool(test1);
		test.addToAvailableWorkerPool(test2);
		test.assign(test1, p0);
		test.assign(test2, p0);
		assertEquals(test.getAssignedWorkers().size(),2);
		Project p1 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		Worker test3 = new Worker("l",new HashSet<Qualification>(Quals));
		test.assign(test3, p1);
		assertEquals(test.getAssignedWorkers().size(),2);
		//System.out.println('\n' + "-----End test assign-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testUnassign(){
		//System.out.println('\n' + "-----Testing Company unassign method-----");
		Company test = new Company("test");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.PLANNED);
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
		assertEquals(test.getAssignedWorkers().size(),0);
		test.addToAvailableWorkerPool(test1);
		test.addToAvailableWorkerPool(test2);
		test.assign(test1, p0);
		test.assign(test2, p0);
		assertEquals(test.getAssignedWorkers().size(),2);
		test.unassign(test1, p0);
		assertEquals(test.getAssignedWorkers().size(),1);
		test.unassign(test2, p0);
		assertEquals(test.getAssignedWorkers().size(),0);
		//System.out.println('\n' + "-----End test unassign-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testUnassignAll(){
		//System.out.println('\n' + "-----Testing Company unassignAll method-----");
		Company test = new Company("test");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.PLANNED);
		Project p1 = new Project("Test Project 1", ProjectSize.MEDIUM,ProjectStatus.PLANNED);
		Project p2 = new Project("Test Project 2", ProjectSize.BIG,ProjectStatus.PLANNED);
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
		p1.missingQualifications = new HashSet<Qualification>(Quals);
		assertEquals(test.getAssignedWorkers().size(),0);
		test.addToAvailableWorkerPool(test1);
		test.addToAvailableWorkerPool(test2);
		test.assign(test1, p0);
		test.assign(test2, p0);
		assertEquals(test.getAssignedWorkers().size(),2);
		test.assign(test1, p1);
		assertTrue(test1.workerProjects.size() == 2);
		test.assign(test1, p2);
		test.unassignAll(test1);
		assertEquals(test.getAssignedWorkers().size(),1);
		//System.out.println('\n' + "-----End test unassignAll-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testStart(){
		//System.out.println('\n' + "-----Testing Company start method-----");
		Company test = new Company("test");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.PLANNED);
		Project p1 = new Project("Test Project 1", ProjectSize.MEDIUM,ProjectStatus.PLANNED);
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Strength");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Worker test1 = new Worker("Bob",new HashSet<Qualification>(Quals));
		p0.missingQualifications = new HashSet<Qualification>(Quals);
		Quals.add(q2);
		p1.missingQualifications = new HashSet<Qualification>(Quals);
		test.addToAvailableWorkerPool(test1);
		test.assign(test1, p0);
		assertEquals(test.getAssignedWorkers().size(),1);
		assertEquals(p0.getStatus(),ProjectStatus.PLANNED);
		test.start(p0);
		assertEquals(p0.getStatus(),ProjectStatus.ACTIVE);
		
		assertEquals(p1.getStatus(),ProjectStatus.PLANNED);
		test.start(p1);
		assertEquals(p1.getStatus(),ProjectStatus.PLANNED);
		test.assign(test1, p1);
		test.start(p1);
		assertEquals(p1.getStatus(),ProjectStatus.PLANNED);
		//System.out.println('\n' + "-----End test start-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testFinish(){
		//System.out.println('\n' + "-----Testing Company finish method-----");
		Company test = new Company("test");
		Project p0 = new Project("Test Project 0", ProjectSize.MEDIUM,ProjectStatus.PLANNED);
		Project p1 = new Project("Test Project 1", ProjectSize.MEDIUM,ProjectStatus.ACTIVE);
		Qualification q1 = new Qualification("Education");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Worker test1 = new Worker("Bob",new HashSet<Qualification>(Quals));
		p0.missingQualifications = new HashSet<Qualification>(Quals);
		p1.missingQualifications = new HashSet<Qualification>(Quals);
		test.addToAvailableWorkerPool(test1);
		test.assign(test1, p0);
		test.assign(test1, p1);
		assertTrue(test.getAssignedWorkers().size() == 1);
		assertTrue(test1.workerProjects.size() == 1);
		test.finish(p0);
		test.unassign(test1, p0);
		assertEquals(p0.projectStatus,ProjectStatus.PLANNED);
		assertEquals(p1.projectStatus,ProjectStatus.ACTIVE);
		test.finish(p1);
		assertEquals(p1.projectStatus,ProjectStatus.FINISHED);
		assertEquals(test1.workerProjects.size(),0);
		assertEquals(test.getAssignedWorkers().size(),0);
		//System.out.println('\n' + "-----End test finish-----");
		//System.out.println("------------------------------------------------------------");
	}
	
	@Test
	public void testCreateProject(){
		//System.out.println('\n' + "-----Testing Company createProject method-----");
		Company test = new Company("test");
		Qualification q1 = new Qualification("Education");
		Qualification q2 = new Qualification("Completion Speed");
		Set<Qualification> Quals = new HashSet<Qualification>();
		Quals.add(q1);
		Quals.add(q2);
		test.createProject("p", Quals, ProjectSize.MEDIUM, ProjectStatus.ACTIVE);
		assertEquals(test.projects.size(),1);
		test.createProject("p2", Quals, ProjectSize.BIG, ProjectStatus.PLANNED);
		assertEquals(test.projects.size(),2);
		//System.out.println('\n' + "-----End test createProject-----");
		//System.out.println("------------------------------------------------------------");
	}
}
