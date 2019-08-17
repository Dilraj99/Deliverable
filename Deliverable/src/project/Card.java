package project;

public class Card {

	//Declare an integer instance variable that represents the Card's value
	private int value;
	
	//Create constructor and initialize instance variable, value
	public Card(int value){
		
		this.value = value;
		
	}//end of Card constructor 
	
	//Accessor for the instance variable, value
	public int getValue(){
		
		return value;
		
	}//end of method getValue
	
	//Mutator for the instance variable, value
	public void setValue(int value){
		
		this.value = value;
		
	}//end of method setValue
		
	
	@Override //Override default toString method
	
	//Return a string of the Card's value
	public String toString(){
		
		return getValue() + "";
			
	}//end of method toString
	
}//end of class Card