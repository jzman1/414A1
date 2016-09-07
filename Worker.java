import java.util.Set;

public class Worker {
	protected String workerName;
	protected Set<Qualification> workerQualifications;
	protected double workerSalary = 0.0;
	protected Set<Project> workerProjects; //MAYBE?!?!

	public Worker(String nName, Set<Qualification> qualifications){
		this.workerName=nName;
		this.workerQualifications=qualifications;
	}
	
	public String getName(){
		return workerName;
	}
	
	public double getSalary(){
		return workerSalary;
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
	
	public String toString(){ //Projects = MAYBE?!?!
		return getName() + ":" + workerProjects.size() + ":" + getQualifications().size() + ":" + getSalary();
	}
}

