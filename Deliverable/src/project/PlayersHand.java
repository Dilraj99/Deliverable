package project;

import java.util.ArrayList;



//start of parent class
public class PlayersHand {
	
	//Declare instance variable that represents any arbitrary player's hand of cards 
	private ArrayList < Card > hand;
	
	
	//Constructor
	public PlayersHand(){
		
		//Initialize the player's hand of cards to an empty ArrayList
		hand = new ArrayList< Card >();
		
	}//end Player constructor
	
	
	//Mutator for instance variable, hand
	public void setHand( ArrayList< Card > hand){
		
		this.hand = hand;
	}//end method setHand
	
	
	//Accessor for instance variable, hand
	public ArrayList< Card > getHand(){
		return hand;
	}//end method getHand
	
	//Add method to add cards to the players hand
	public void addCard(Card card){
		
		hand.add(card);	
	}//end method addCard
	
	
	
	
	//Access method that returns the total number of cards in the player's hand
	public int getNumOfCards(){
		
		//Initialize the total number of cards in hand to 0
		int totalCards = 0;
		
		//For each card in player's hand
		for (Card eachCard: hand){
			
			//Increment the total number of cards by 1
			totalCards = totalCards + 1;
				
		}//end of for each loop
		
		return totalCards;
		
	}//end method getNumOfCards
	

	
	
	@Override //Override the default toString method
	
	//Return a string representation of the player's hand
	public String toString(){
		
		return getHand() + "";
		
	}//end method toString
	
	
	

}//end of class PlayersHand