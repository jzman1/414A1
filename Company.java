/*
 * Joshua Zarin
 * 9/8/16
 * CS414 A1
 * Company.java
 */
package cs414.a1.jzman1;
import java.util.*;

public class Company {
	protected String Name = "";
	protected Set<Worker> assignedWorkerPool = new HashSet<Worker>();
	protected Set<Worker> availableWorkerPool = new HashSet<Worker>();//employed workers
	protected Set<Project> projects = new HashSet<Project>();
	
	
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
	public void unassign(Worker employee, Project proj){
		if(proj.getProjectWorkers().contains(employee)){
			proj.removeWorker(employee);
			if(proj.missingQualifications().size() > 0 && proj.getStatus() == ProjectStatus.ACTIVE){
				proj.setStatus(ProjectStatus.SUSPENDED);
			}
			employee.removeProject(proj);
			if(employee.workerProjects.size() == 0){
				assignedWorkerPool.remove((Worker)employee);
			}
		}
	}
	
	//unassign all (worker)-remove worker from all his projects
	public void unassignAll(Worker employee){
		Iterator<Project> it = employee.workerProjects.iterator();
		while(it.hasNext()){
			Object comparee = it.next();
			if(comparee instanceof Project){
				//employee.removeProject((Project)comparee);
				((Project)comparee).removeWorker(employee);
				if(((Project) comparee).missingQualifications().size() > 0 && ((Project)comparee).getStatus() == ProjectStatus.ACTIVE){
					((Project)comparee).setStatus(ProjectStatus.SUSPENDED);
				}
				it.remove();
			}
		}
		assignedWorkerPool.remove((Worker)employee);
	}
	
	//start(project): planned/suspended project become active 
		//if qualification requirements are met, else stay planned/suspended
	public void start(Project proj){
		if(proj.getStatus() == ProjectStatus.PLANNED || proj.getStatus() == ProjectStatus.SUSPENDED){
			if(proj.missingQualifications().size() == 0){
				proj.setStatus(ProjectStatus.ACTIVE);
			}
		}
	}
	
	//finish(project): mark active project as finished. all workers only on this
		//project are removed from assigned workers, suspended or planned projects
		//stay that way and can't be finished unless active
	public void finish(Project proj){
		if(proj.getStatus() == ProjectStatus.ACTIVE){
			Iterator<Worker> it = proj.projectWorkers.iterator();
			while(it.hasNext()){
				Object comparee = it.next();
				if(comparee instanceof Worker){
					//proj.removeWorker((Worker)comparee);
					((Worker) comparee).removeProject(proj);
					if(((Worker)comparee).workerProjects.size() == 0){
						assignedWorkerPool.remove((Worker)comparee);
					}
					it.remove();
				}
			}
			proj.setStatus(ProjectStatus.FINISHED);
		}
	}
	
	//createProject
	public Project createProject(String n, Set<Qualification> qs, ProjectSize size, ProjectStatus status){
		Project p = new Project(n, size, status);
		this.projects.add(p);
		p.missingQualifications = qs;
		return p;
	}
}

