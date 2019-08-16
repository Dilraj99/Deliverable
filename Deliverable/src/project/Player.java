package project;

import project.PlayersHand;
import java.util.Scanner;

//start of class 
//use extend keyword, for Player to be a child of parent class, PlayersHand
public class Player extends PlayersHand {
	
	//Declare string instance variable that represents the dealer's name
	private String playerName;
	
	//Create initializing, parameterless constructor
	public Player(){
		
		//Explicitly call the parent class', PlayersHand, constructor
		super();
		
		//Initialize Scanner object, called playerInput 
		Scanner playerInput = new Scanner(System.in);
		
		//Prompt the player to enter their name and assign value to instance variable, playerName
		System.out.print("Enter your name: ");
		playerName = playerInput.next();
	
	}//end constructor Player
	
	
	//Accessor for instance variable, playerName
	public String getName(){
		
		return playerName;
	}//end method getName
	
	
	//Mutator for instance variable, playerName
	public void setName(String playerName){
		
		this.playerName = playerName;
	}//end method setName
	
	
	@Override //Override the parent class', PlayersHand, toString method
	
	//Method toString: Returns a string representation of the player's hand
	public String toString(){
		
		return getName() + "'s card hand is: " + super.toString();
		
	}//end method toString

}//end of class Player