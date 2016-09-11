/*
 * Joshua Zarin
 * 9/8/16
 * CS414 A1
 * Qualification.java
 */
package cs414.a1.jzman1;
public class Qualification {
	protected String qualificationDescription;
	
	public Qualification(String description){
		this.qualificationDescription = description;
	}
	
	public String toString(){
		return qualificationDescription;
	}
	
	@Override
	public boolean equals(Object comparee){
		boolean ret = false;
		if(comparee instanceof Qualification){
			if (((Qualification)comparee).toString() == this.toString()){
				ret = true;
			}
		}
		return ret;
	}
}