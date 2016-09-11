/*
 * Joshua Zarin
 * 9/8/16
 * CS414 A1
 * testAll.java
 */
package cs414.a1.jzman1;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
@RunWith(Suite.class)
@SuiteClasses({ QualificationTest.class, WorkerTest.class, ProjectTest.class, CompanyTest.class})
public class TestAll {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
	    Result qualTestResult = JUnitCore.runClasses(QualificationTest.class);
	    Result workTestResult = JUnitCore.runClasses(WorkerTest.class);
	    Result projTestResult = JUnitCore.runClasses(ProjectTest.class);
	    Result compTestResult = JUnitCore.runClasses(CompanyTest.class);
	}
}