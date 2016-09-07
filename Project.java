import java.util.*;

public class Project {
	protected String projectName;
	protected ProjectSize projectSize;
	protected ProjectStatus projectStatus;
	protected Set<Worker> projectWorkers;//MAYBE?!?!

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
	
	public String toString(){	//project workers MAYBE?!?!
		return getName() + ":" + projectWorkers.size() + ":" + getStatus();//.getName().toUpperCase();
	}
	
	public Set<Qualification> missingQualifications(){ 
		//Set<Qualification> missingQ;
		
		Iterator<Worker> it = projectWorkers.iterator();
		while(it.hasNext()){
			Object comparee = it.next();
			if(comparee instanceof Worker){
				
			}
		}
		//return missing worker qualifications
		//or empty, not null, set if none are
		//missing
		return null;
	}
	
	public boolean isHelpful(Worker w){
		//if new added worker satisfies missing qualification(s), then true, else false
		return false;
		
	}
}

