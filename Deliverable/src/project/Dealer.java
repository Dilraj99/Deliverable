package project;


import project.PlayersHand;

public class Dealer extends PlayersHand{
	
	//Declare string instance variable that represents the dealer's name
	private String dealerName;
	
	//Create initializing, parameterless constructor
	public Dealer(){
		
		//Explicitly call the parent class', PlayersHand, constructor
		super();
		
		//Initialize the dealer's name 
		dealerName = "Dealer";
					
	}//end of Dealer constructor
		
	
	//Accessor for instance variable, dealerName	
	public String getName(){
		
		return dealerName;
		
	}//end method getName
	
	
	//Mutator for instance variable, dealerName
	public void setName(String dealerName){
		
		this.dealerName = dealerName;
	}//end method setName
		
	/*
	 * Method dealerTurn: Determines whether the dealer should take or end their turn, by taking into
	 * account the dealer and the player's score (accepted as parameters). Returns true if dealer 
	 * should take their turn and keep drawing, false otherwise.	
	 */
	public boolean dealerTurn(int dealerScore, int playerScore){
		
		//If the dealer's score is less than the player's, return true
		if(dealerScore < playerScore){
			
			return true;
			
		}//end if
		
		//Else, the dealer's score is greater than or equal to player's, so return false
		else{
			return false;
			
			}//end else
		
	}//end method dealerTurn
		
	
	/*
	 * Method dealerAI: A simple Artificial Intelligence that determines whether the dealer should
	 * take their turn and keep drawing, or end their turn. Takes as parameters the player and dealer's
	 * current score, and the choice of whether the player decided to 'Stay'. Based on the parameters,
	 * return true if the dealer should continue their turn and draw again, false otherwise. 
	 */
	public boolean dealerAI(int dealerScore, int playerScore, String playerStays){
		
		//If the dealer's score is exactly 21, return false.
		if (dealerScore == 21){
			
			return false;
		}//end if
		
		//Else, if the player's score is greater than 21 (busted), return false
		else if (playerScore > 21){
			
			return false;
		}//end of else if
		
		//Else, if the player's score is less than the dealer's...
		else if(playerScore < dealerScore){
				
			//If the dealer's score is greater than or equal to 17, return false
			if (dealerScore >= 17){
				
				return false;
			}//end nested if
				
		}//end else if
		
		//Else, if the player chose to 'Stay'...
		else if (playerStays.equals("stay")){
			
			//If the dealer's score is greater than the player's score, return false
			if(dealerScore > playerScore){
				
				return false;
			}//end if 
		}//end of else if
		
		//If none of the above are true, it's in the dealer's advantage to keep drawing, so return true
		return true;
				
	}//end method dealerAI
		
	
	
	//Method toString: return a string representation of the Dealer's hand
	public String toString(){
			
		return getName() + "'s card hand is: " + super.toString();
	}//end method toString
		
		

}//end of class Dealer