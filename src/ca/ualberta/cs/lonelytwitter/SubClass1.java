package ca.ualberta.cs.lonelytwitter;

public abstract class SubClass1 extends NewAbstract{
	private String s = "We are in SubClass1";
	
	public String setText(){
		s = "Set in 1";
		return s;
	}
	
	public String emptyText(){
		s = "Emptied in 1";
		return s;
	}
	
	public String getText(){
		return s + " returned in 1";
	}

}
