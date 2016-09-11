/*
 * Joshua Zarin
 * 9/8/16
 * CS414 A1
 * Project.java
 */
import java.util.*;
package cs414.a1.jzman1;
public class Project {
	protected String projectName;
	protected ProjectSize projectSize;
	protected ProjectStatus projectStatus;
	protected Set<Worker> projectWorkers = new HashSet<Worker>();//MAYBE?!?!
	protected Set<Qualification> missingQualifications = new HashSet<Qualification>();

	public Project(String name, ProjectSize size, ProjectStatus status){
		this.projectName = name;
		this.projectSize = size;
		this.projectStatus = status;
	}
	
	public String getName(){
		return projectName;
	}
	
	public ProjectSize getSize(){
		return projectSize;
	}
	
	public ProjectStatus getStatus(){
		return projectStatus;
	}

	//***** needed for company
	public Set<Worker> getProjectWorkers(){
		return projectWorkers;
	}
	//***** needed for company
	
	public void setStatus(ProjectStatus status){
		this.projectStatus = status;
	}
	
	@Override
	public boolean equals(Object comparee){
		boolean ret = false;
		if(comparee instanceof Project){
			if (((Project)comparee).getName() == this.getName()){
				ret = true;
			}
		}
		return ret;
	}
	
	public String toString(){
		return getName() + ":" + projectWorkers.size() + ":" + getStatus();//.getName().toUpperCase();
	}
	
	public Set<Qualification> missingQualifications(){ 
		Iterator<Worker> it1 = projectWorkers.iterator();
		while(it1.hasNext()){
			Object comparee1 = it1.next();
			if(comparee1 instanceof Worker){
				Iterator<Qualification> it2 = ((Worker) comparee1).getQualifications().iterator();
				while(it2.hasNext()){
					Object comparee2 = it2.next();
					if(comparee2 instanceof Qualification){
						if(missingQualifications.contains(comparee2)){
							missingQualifications.remove((Qualification)comparee2);
						}
					}
				}
			}
		}
		return missingQualifications;
	}
	
	
	//********for company
	public void addWorker(Worker employee){
		projectWorkers.add(employee);
	}
	public void removeWorker(Worker employee){
		projectWorkers.remove((Worker)employee);
	}
	//********for company
	
	public boolean isHelpful(Worker w){
		boolean ret = false;
		//if new added worker satisfies missing qualification(s), then true, else false
		Iterator<Qualification> it = w.getQualifications().iterator();
		while(it.hasNext()){
			Object comparee = it.next();
			if(comparee instanceof Qualification){
				if(this.missingQualifications().contains((Qualification)comparee) == true){
					ret = true;
				}
			}
		}
		return ret;
	}
}

