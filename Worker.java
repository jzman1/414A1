import java.util.Iterator;
import java.util.Set;

public class Worker {
	protected String Name;
	protected Set<Qualification> workerQualifications;
	protected double workerSalary = 0.0;
	protected Set<Project> workerProjects; //MAYBE?!?!

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
		workerProjects.add(p);
	}
	//********HELPER FOR PROJECTS
	
	public String toString(){ //Projects = MAYBE?!?!
		return getName() + ":" + workerProjects.size() + ":" + getQualifications().size() + ":" + getSalary();
	}

	public boolean willOverload(Project proj) {
		boolean ret = false;
		Iterator<Project> it = this.workerProjects.iterator();
		int loadlvl = 0;
		while(it.hasNext()){
			Object comparee = it.next();
			if(comparee instanceof Project){
				if(((Project) comparee).getStatus() == ProjectStatus.ACTIVE){
					if(((Project) comparee).getSize() == ProjectSize.BIG){
						loadlvl += 3;
					}else if(((Project) comparee).getSize() == ProjectSize.MEDIUM){
						loadlvl += 2;
					}else if(((Project) comparee).getSize() == ProjectSize.SMALL){
						loadlvl += 1;
					}else{
						loadlvl += 0;
					}
				}
			}
		}
		if(loadlvl > 12){
			ret = true;
		}
		return ret;
	}
}
