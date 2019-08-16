package project;

import java.util.ArrayList;
import java.util.Scanner;

//start of class
public class Blackjack {

	//main method begins execution of Java application
	public static void main(String[] args) {
		
		//Play a full game at least once, and continue while the player chooses to play again
		do{
			
			//Initialize objects and variables for the game of BlackJack
			
			
			//Initialize Player object that represents the player
			//NOTE: Initializing a Player object will prompt the user to enter their name for the game
			Player player = new Player();
			
			//Initialize an ArrayList of Cards that will represent the player's hand
			ArrayList< Card > playerHand = player.getHand();
			
			//Initialize player's score and total cards in hand to 0
			int playerScore = 0;
			
			int playerTotalCards = 0;
			
			//Initialize string variable, representing the player's status
			String playerStatus = "";
			
			
			//Initialize Dealer object that will represent the dealer
			Dealer dealer = new Dealer();
			
			//Initialize an ArrayList of Cards that will represent the dealer's hand
			ArrayList< Card > dealerHand = dealer.getHand();
			
			//Initialize dealer's score and total cards in hand to 0
			int dealerScore = 0;
			
			int dealerTotalCards = 0;
			
			//Initialize string variable, representing the dealer's status
			String dealerStatus = "";
			
			
			//Initialize Hand object that will keep tabs on the score and status of the players
			Hand Hand = new Hand(player.getName(), dealer.getName());
			
			//Initialize a string variable that represents the winner of the game
			String winnerOfGame = "";
			
			//Initialize a DeckOfCards object that will represent a full deck of cards
			DeckOfCards DeckOfCards = new DeckOfCards();
			
			
			//the game of BlackJack
			
			
			//Shuffle Begin the deck of cards
			DeckOfCards.shuffleDeck();
			
			
			//Before the first turn, one card will be randomly drawn for the player and dealer
			
			
			//Draw a random card from the deck for the player
			Card playerCard = DeckOfCards.dealCard();
			
			//Add the card to the player's hand
			player.addCard(playerCard);
			
			//Draw a random card from the deck for the dealer
			Card dealerCard = DeckOfCards.dealCard();
			
			//Add the card to the dealer's hand
			dealer.addCard(dealerCard);
			
			//For the initial draw, display the cards drawn by the dealer and player
			DeckOfCards.initialDraw(player.getName(), playerCard);
			DeckOfCards.initialDraw(dealer.getName(), dealerCard);
			
			
			//The player is now given the option to either 'Hit' or 'Stay'
			
			//Declare a string variable that will represent the player's choice
			String playerChoice;
			
			//Prompt the player to enter 'hit' or 'stay'
			playerChoice = Hand.hitOrStay();
			

			//Loop while player's choice is 'hit'
			while(playerChoice.equals("hit")){
				
				//Player can draw a random card from the deck
				player.addCard(DeckOfCards.dealCard());
				
				//Calculate player's current score
				playerScore = Hand.totalScore(playerHand);
				
				//Total the number of cards in player's hand
				playerTotalCards = player.getNumOfCards();
				
				//Determine player's current status in game
				playerStatus = Hand.gameStatus(playerScore, playerTotalCards, player.getName());
				
				//Display the player's current hand, score, and status
				System.out.println(player);
				System.out.println(player.getName() + "'s score is: " + playerScore);
				System.out.println(player.getName() + "'s status is: " + playerStatus + "\n");
				
				//If player's status is Continue, then player can choose whether to hit or stay
				if(playerStatus.equals("Continue")){
					
					//Prompt player again to choose whether to 'Hit' or 'Stay'
					playerChoice = Hand.hitOrStay();
				}//end of if
				
				//Else, inform the player that they can no longer draw due to their game status
				else{
					
					System.out.println(player.getName() + ", cannot draw anymore because your " +
							"status is: " + playerStatus + "\n");
					break;//ends the player's turn by breaking out of while loop
					
				}//end else
			}//end while loop
			
			//If player's status is 'Charlie', then the player automatically wins
			if(playerStatus.equals("Charlie")){
				
				//Display winning message to player
				System.out.println("Charlie! Congrats, " + player.getName() + "! You won!");
				
				
			}//end if
			
			//The player's status is not 'Charlie', so the dealer can take their turn
			else{
				
				//Calculate the dealer's total score
				dealerScore = Hand.totalScore(dealerHand);
				
				//Loop while it's the dealer's turn (meaning, dealer's score is less than player's)
				while(dealer.dealerTurn(dealerScore, playerScore)){
					
					//If the dealer has a better chance of winning by drawing, continue to draw cards
					if(dealer.dealerAI(dealerScore, playerScore, playerChoice)){
						
						//Calculate the dealer's current total score in the game
						dealerScore = Hand.totalScore(dealerHand);
						
						//Calculate the current number of cards in dealer's hand
						dealerTotalCards = dealer.getNumOfCards();
						
						//Check the dealer's status in the game
						dealerStatus = Hand.gameStatus(dealerScore, dealerTotalCards, dealer.getName());
						
						//If the dealer status is 'Continue', then the dealer can draw cards
						if(dealerStatus.equals("Continue")){
							
							//Add a random card to the dealer's hand
							dealer.addCard(DeckOfCards.dealCard());
						}//end nested-if
						
						//Else, the dealer cannot draw anymore due to their status
						else{
							
							break;//ends the dealer's turn by breaking out of the while loop
						}//end nested-else
						
					}//end if
					
					//Else, the dealer's chances of winning are better without drawing, so stop drawing
					else{
						break;//ends the dealer's turn by breaking out of the while loop
					}//end else
				}//end while loop
				
				//Inform the player that the dealer's turn is over
				System.out.println(dealer.getName() + "'s turn is now over." + "\n");
				
				//Determine the winner of the game
				winnerOfGame = Hand.isWin(playerStatus, dealerStatus, dealerScore, playerScore);
				
				//Display the scores of both players
				System.out.println(player.getName() + "'s final score is: " + playerScore);
				System.out.println(player + "\n");
				
				System.out.println(dealer.getName() + "'s final score is: " + dealerScore);
				System.out.println(dealer);
				
				//Display message that prints the winner of the game
				System.out.println("\n" + winnerOfGame + "\n");
				
			}//end else
			
			
		}while(playAgain());//If the player chooses to play again, continue to play game
			

	}//end main method
	
	//Method playAgain: Returns true if the player wants to play again, false otherwise
	public static boolean playAgain(){
		
		//Initialize Scanner object, called playAgainInput
		Scanner playAgainInput = new Scanner(System.in);
		
		//Declare string variable to store the player's answer
		String answer;
		
		//Prompt the player to type 'yes' to play again
		System.out.print("Enter the word 'yes' to play again, or anything else to end the game: ");
		answer = playAgainInput.next();
		
		//If the player chooses to play again, return true
		if (answer.equalsIgnoreCase("yes")){
			return true;
		}//end if
		
		//Else, the player did not choose to play again, so return false
		else{
			return false;
		}//end else
		
	}//end method playAgain

}//end of class BlackJack