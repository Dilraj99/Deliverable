package project;

import java.util.ArrayList;
import java.util.Scanner;
import project.Card;

//start of class
public class Hand {
	
	//Declare string instance variables that will represent the names of the player and dealer
	private String playerName;
	private String dealerName;
	
	//Create initializing constructor, with string parameters for playerName and dealerName
	public Hand(String playerName, String dealerName){
		
		//Initialize the player and dealer's names
		
		this.playerName = playerName;
		this.dealerName = dealerName;
		
	}//end constructor Hand
	
	
	//Accessor method for instance variable, playerName
	public String getPlayerName(){
		
		return playerName;
	}//end method getPlayerName
	
	//Mutator method for instance variable, playerName
	public void setPlayerName(String playerName){
		
		this.playerName = playerName;
	}//end method setPlayerName
	
	//Accessor method for instance variable, dealerName
	public String getDealerName(){
		
		return dealerName;
	}//end method getDealerName
	
	//Mutator method for instance variable, dealerName
	public void setDealerName(String dealerName){
		
		this.dealerName = dealerName;
	}//end method setDealerName
	
	
	/*
	 * Method hitOrStay: Gives the human player the option of whether to 'Hit' or 'Stay'. 
	 * Returns string 'hit' if the player chooses 'Hit', string 'stay' if the player chooses 'Stay', 
	 * or null otherwise. 
	 */
	public String hitOrStay(){
		
		//Initialize Scanner object input
		Scanner input = new Scanner(System.in);
		
		//Declare string variable to store the player's answer
		String answer;
		
		//Prompt the player to type in 'Hit' or 'Stay' as their choice, and store value in answer
		System.out.print(playerName + ", please choose to \''Hit\'' or \''Stay\'': ");
		answer = input.next();
		
		//If the player's answer begins with an 'h' (regardless of case), return string 'hit'
		if ( answer.startsWith("H") || answer.startsWith("h") ){
			
			return "hit";
		}//end if
		
		//Else, if the player's answer begins with an 's' (regardless of case), return string 'stay'
		else if (answer.startsWith("S") || answer.startsWith("s")){
			
			return "stay";
		}//end else if
		
		//Else, return null
		else {
			return "null";
		}//end else
	
	}//end method hitOrStay
	

	/*
	 * Method totalScore: totals the value of the cards in a player's hand. Checks to see if the 
	 * player's hand contains an Ace. If an Ace is present, and the player will bust, change the 
	 * Ace value from 11 to 1. Return the totaled value of the cards in hand. 
	 */
	public int totalScore(ArrayList< Card > hand){
		
		//Declare Card object that represents the current card in player's hand 
		Card currentCard;
		
		//Initialize the card's value to 0
		int currentCardValue = 0;
		
		//Initialize the total values of cards in hand to 0
		int total = 0;
	
		
		//For each card in the player's hand
		for (Card eachCard: hand){
			
			//Access the card's value and assign it to the variable, cardValue
			int cardValue = eachCard.getValue();
			
			//Check for an Ace
			
			//If the card's value is 1...
			if(cardValue == 1){
				
				//Increment the total by 11
				total = total + 11;
			}//end if
			
			//Else, if the card is not an Ace
			else{
				
				//Add the cardValue to the total normally
				total = total + cardValue;
			}//end else
			
		}//end for each loop
		
		//If the player's total is greater than 21 (which means they will bust), Check for an Ace
		if(total > 21){
			
			//Look at each card element in the entire hand 
			for (int i = 0; i < hand.size(); i++){
				
				//Access the element of the current card at index i, assign element to currentCard
				currentCard = hand.get(i);
				
				//Assign the value of the current card to variable, currentCardValue
				currentCardValue = currentCard.getValue();
				
				//If the current card's value is '1', that means the card is an Ace
				if(currentCardValue == 1){
					
					//Change the Ace's value in the total from 11 to 1, by subtracting the total by 10
					total = total - 10;
					
					//return the new total
					return total;
					
				}//end if
			}//end for loop
		}//end if
		
		return total;
		
	}//end method totalScore

	/*
	 * Method gameStatus: Determines whether a player's total status is a 'Bust', 'Win', 'Charlie' 
	 * (if it's the human player), or 'Continue'(which means the status is none of the above and 
	 * the game continues). Returns the string indicating the player's status. 
	 */
	public String gameStatus(int score, int totalCards, String name){
		
		//Loop until counter i is less than or equal to 5 (allows players to draw no more than 5 cards)
		for (int i = 1; i <= 5; i++){
			
			//Implement the rules of the BlackJack game to determine status
					
			//If the player's score is greater than or equal 21...
			if (score >= 21){
				
				//If the player's score is greater than 21, return string 'Bust'
				if(score > 21){
					
					return "Bust";
				}//end if
						
						
				//Else, the score is exactly 21, return string 'Win'
				else{
					
					return "Win";
				}//end of else
						
			}//end of nested-if
					
			//If the player's name is not dealer, then it's the human player
			if (!(name.equals("Dealer"))){
				
				//If the human player's total amount of cards is equal to 5, return 'Charlie'
				//This means the human player has also NOT 'Busted'
				
				if (totalCards == 5){
					return "Charlie";
				}//end if
			}//end of if
						
		}//end of for loop
		
		//If none of the status' above, return string 'Continue'
		return "Continue";
		
	}//end of method gameStatus
		
	
	/*
	 * Method isWin: Determines whether the dealer or player wins the game, depending on their 
	 * status and total scores (accepted as parameters). Returns a string indicating which player
	 * has won, or whether it was a draw. 
	 */
	public String isWin(String playerStatus, String dealerStatus, int dealerScore, int playerScore){
		
		//If neither the player or dealer have busted...
		if(!(playerStatus.equals("Bust")) && !(dealerStatus.equals("Bust"))){
			
			//If the player's score is greater than dealer's, return string informing player of win
			if(playerScore > dealerScore){
				
				return "The winner is " + getPlayerName();
			}//end nested if
			
			//Else, if player's score is less than dealer's, return string informing player of loss
			else if (playerScore < dealerScore){
				
				return "The winner is " + getDealerName();
			}//end nested else if
			
			//Else, the player's score is equal to the dealer's, return string informing player of draw
			else{
				
				return "It's a draw!";
			}//end nested else
			
		}//end if
		
		//Else, if player has busted, return string informing player of loss
		else if(playerStatus.equals("Bust")){
			return getPlayerName() + " Busts! " + getDealerName() + " won!";
		}//end else if
		
		//Else, if dealer has busted, return string informing player of win
		else{
			return getDealerName() + " Busts! " + getPlayerName() + " won!";
		}//end else	
					
	}//end method isWin
	
	
}//end of class Hand