//hello
import java.util.*;

public class Company {
	protected String Name = "";
	protected Set<Worker> assignedWorkerPool;
	protected Set<Worker> availableWorkerPool;//employed workers
	protected Set<Project> projects;
	
	
	public Company(String name){
		this.Name=name;
	}
	
	public String getName(){
		return Name;
	}
	
	//get available workers: set(Worker)
	public Set<Worker> getAvailableWorkers(){
		return availableWorkerPool;
	}
	
	//get assigned workers: set(Worker)
	public Set<Worker> getAssignedWorkers(){
		return assignedWorkerPool;
	}
	
	
	//get unassigned workers: set(Worker)
	public Set<Worker> getUnassignedWorkers(){
		Set<Worker> rets = new HashSet<Worker>();
		Iterator<Worker> it = availableWorkerPool.iterator();
		while(it.hasNext()){
			Object comparee = it.next();
			if(comparee instanceof Worker){
				if(assignedWorkerPool.contains((Worker)comparee) == false){
					rets.add((Worker)comparee);
				}
			}
		}
		return rets;	
	}
	
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
	public void addToAvailableWorkerPool(Worker employee){
		availableWorkerPool.add(employee);	//set will not add duplicate if employee is already in pool
	}
	
	//assign (worker(available worker pool, not 
		//assigned to this project already), project(not
		//active or finished state))
	public void assign(Worker employee, Project proj){
		Set<Worker> ProjWorkers = proj.getProjectWorkers();
		if(availableWorkerPool.contains(employee) && (ProjWorkers.contains(employee)==false) && proj.getStatus()!= ProjectStatus.ACTIVE && proj.getStatus() != ProjectStatus.FINISHED && proj.isHelpful(employee) && (employee.willOverload(proj) == false)){
			assignedWorkerPool.add(employee);
			proj.addWorker(employee);		
			employee.addProject(proj);
		}
	}
	
	//unassign (worker, project)
	
	//unassign all (worker)-remove worker from all his projects
	
	//start(project): planned/suspended project become active 
		//if qualification requirements are met, else stay planned/suspended
	
	//finish(project): mark active project as finished. all workers only on this
		//project are removed from assigned workers, suspended or planned projects
		//stay that way and can't be finished unless active
	
	//createProject
}

