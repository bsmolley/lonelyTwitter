package ca.ualberta.cs.lonelytwitter;

public abstract class SubClass2 extends NewAbstract{
	private String s = "We are in SubClass2";
	
	public String setText(){
		s = "Set in 2";
		return s;
	}
	
	public String emptyText(){
		s = "Emptied in 2";
		return s;
	}
	
	public String getText(){
		return s + " returned in 2";
	}

}
