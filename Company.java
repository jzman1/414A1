//hello
import java.util.*;

public class Company {
	protected String CompanyName = "";
	protected ArrayList<Worker> assignedWorkerPool;
	protected ArrayList<Worker> availableWorkerPool;//employed workers
	protected ArrayList<Worker> projects;
	
	
	public Company(String name){
		this.CompanyName=name;
	}
	
	public String getName(){
		return CompanyName;
	}
	
	//get available workers: set(Worker)
	public ArrayList<Worker> getAvailableWorkers(){
		return availableWorkerPool;
	}
	
	//get assigned workers: set(Worker)
	public ArrayList<Worker> getAssignedWorkers(){
		return assignedWorkerPool;
	}
	
	
	//get unassigned workers: set(Worker)
	//***********************************
	
	//equals (company names)
	@Override
	public boolean equals(Object comparee){
		boolean ret = false;
		if(comparee instanceof Company){
			if (((Company)comparee).getName() == this.getName()){
				ret = true;
			}
		}
		return ret;
	}
	
	//to string: company name, colon, 
		//number of available workers, colon, 
		//and number of projects carried out
	public String toString(){
		return getName() + ":" + getAvailableWorkers().size() + ":" + this.projects.size();
	}
	
	//add to available worker pool: worker not 
		//in available workers now in available workers
	
	//assign (worker(available worker pool, not 
		//assigned to this project already), project(not
		//active or finished state))
	
	//unassign (worker, project)
	
	//unassign all (worker)-remove worker from all his projects
	
	//start(project): planned/suspended project become active 
		//if qualification requirements are met, else stay planned/suspended
	
	//finish(project): mark active project as finished. all workers only on this
		//project are removed from assigned workers, suspended or planned projects
		//stay that way and can't be finished unless active
	
	//createProject
}

