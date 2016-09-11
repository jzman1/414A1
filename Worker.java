/*
 * Joshua Zarin
 * 9/8/16
 * CS414 A1
 * Worker.java
 */
import java.util.*;

public class Worker {
	protected String Name;
	protected Set<Qualification> workerQualifications;
	protected double workerSalary = 0.0;
	protected int workLoad = 0;
	protected Set<Project> workerProjects = new HashSet<Project>();

	public Worker(String nName, Set<Qualification> qualifications){
		this.Name=nName;
		this.workerQualifications=qualifications;
	}

	public String getName(){
		return Name;
	}

	public double getSalary(){
		return workerSalary;
	}

	public void setSalary(double salary){
		if(salary < 0) salary *= -1;
		workerSalary = salary;
	}

	public Set<Qualification> getQualifications(){
		return workerQualifications;
	}

	public void addQualifications(Qualification q){
		workerQualifications.add(q);
	}

	@Override
	public boolean equals(Object comparee){
		boolean ret = false;
		if(comparee instanceof Worker){
			if (((Worker)comparee).getName() == this.getName()){
				ret = true;
			}
		}
		return ret;
	}

	//********HELPER FOR PROJECTS
	public void addProject(Project p){
		if(p.getStatus() == ProjectStatus.ACTIVE){
			if(p.getSize() == ProjectSize.BIG){
				workLoad += 3;
			}else if(p.getSize() == ProjectSize.MEDIUM){
				workLoad += 2;
			}else if(p.getSize() == ProjectSize.SMALL){
				workLoad += 1;
			}else{
				workLoad += 0;
			}
		}
		workerProjects.add(p);
	}
	public void removeProject(Project p){
		if(p.getStatus() == ProjectStatus.ACTIVE){
			if(p.getSize() == ProjectSize.BIG){
				workLoad -= 3;
			}else if(p.getSize() == ProjectSize.MEDIUM){
				workLoad -= 2;
			}else if(p.getSize() == ProjectSize.SMALL){
				workLoad -= 1;
			}else{
				workLoad += 0;
			}
		}
		workerProjects.remove((Project)p);
	}
	//********HELPER FOR PROJECTS

	public String toString(){ //Projects = MAYBE?!?!
		return getName() + ":" + workerProjects.size() + ":" + getQualifications().size() + ":" + getSalary();
	}

	public boolean willOverload(Project proj) {
		int tempp = 0;
		boolean ret = false;
		if(proj.getStatus() == ProjectStatus.ACTIVE){
			if(proj.getSize() == ProjectSize.BIG){
				tempp = 3;
			}else if(proj.getSize() == ProjectSize.MEDIUM){
				tempp = 2;
			}else if(proj.getSize() == ProjectSize.SMALL){
				tempp = 1;
			}else{
				tempp = 0;
			}
		}
		if((workLoad + tempp) > 12){
			ret = true;
		}
		return ret;
	}
}
