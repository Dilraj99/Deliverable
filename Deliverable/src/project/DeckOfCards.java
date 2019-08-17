package project;

import java.util.Random;
import java.util.ArrayList;

//start of class
public class DeckOfCards{

	//Declare an ArrayList of Cards instance variable to represent the deck of cards
	private ArrayList< Card > DeckOfCards;
	
	//Create initializing, parameterless constructor
	public DeckOfCards(){
		
		//Use a list and loop to fill the deck with the 52 cards (4 of each card value)
		
		//Initialize an integer array of all the possible card values in the deck 
		int[] CardValuesList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
		
		//Initialize instance variable DeckOfCards to an empty ArrayList of Cards
		DeckOfCards = new ArrayList < Card > ();
		
			//For each integer element in the CardValuesList
			for(int cardNumber: CardValuesList){
				
				//Create a new Card object with the CardValuesList element's value
				Card currentCard = new Card(cardNumber);
				
				//Use a for loop to fill the deck with 4 cards of each value (total of 52 cards)
				for (int j = 1; j <= 4; j++){
					
					//Add the current Card object to the DeckOfCards
					DeckOfCards.add(currentCard);
					
				}//end nested for loop	
				
			}//end for each loop
			
	}//end Deck constructor
	
	
	//Method random: returns a Random object to be used to generate random numbers for deck
	public Random random(){
		
		//Initialize a Random object, called random and return it
		Random random = new Random();
		return random;
	}//end method random
	
	//Access method that returns the size of the DeckOfCards
	public int getDeckSize(){
		
		return DeckOfCards.size();
	}//end method getDeckSize
	
	
	//Method getRandomCard: returns a random Card object in the DeckOfCards
	public Card getRandomCard(){
	
		//Initialize an integer variable called index, that is assigned a random index in the DeckOfCards
		int index = random().nextInt(getDeckSize());
		
		//Then access the Card by using the index to create a random Card object
		Card randomCard = DeckOfCards.get(index);
		
		return randomCard;
	}//end method getRandomCard
	
	
	//Method shuffleDeck: uses the random method to randomly shuffle the Cards in the DeckOfCards 
	public void shuffleDeck(){
		
		//For each index of each element in the DeckOfCards...
		for(int i = 0; i < getDeckSize(); i++){
			
			//Assign a random Card from the deck to the Card object, randomCard	
			Card randomCard = getRandomCard();
			
			//Assign that random card's index to the variable, randomCardIndex
			int randomCardIndex = DeckOfCards.indexOf(randomCard);
			
			//Remove the random Card from the DeckOfCards
			DeckOfCards.remove(randomCardIndex);
			
			//Append that random Card to the end of the DeckOfCards ArrayList
			DeckOfCards.add(randomCard);
			
		}//end of for loop		
		
	}//end method shuffleDeck
	
	
	/*
	 * Method dealCard: deals random Cards from the DeckOfCards, by first, drawing a random card,
	 * removing it, and then returning the card.
	 */
	public Card dealCard(){
		
		//Remove a card from the deck of cards array list
		//get the index of card
		//return the random card
		
		//Assign a random Card from the deck to the Card object, randomCard	
		Card randomCard = getRandomCard();
		
		//Assign that random card's index to the variable, randomCardIndex
		int randomCardIndex = DeckOfCards.indexOf(randomCard);
		
		//Remove the random Card from the DeckOfCards
		DeckOfCards.remove(randomCardIndex);
			
		return randomCard;
	}//end method dealCard
	
	//Accessor method for the instance variable, DeckOfCards
	public ArrayList< Card > getDeck(){
		
		return DeckOfCards;
	}//end method getDeck
	
	//Mutator method for the instance variable, DeckOfCards
	public void setDeck(ArrayList< Card > DeckOfCards){
		
		this.DeckOfCards = DeckOfCards;
	}//end method setDeck
	
	//Method initialDraw: Prints out the initial draw of a player
	public void initialDraw(String name, Card card){
		
		System.out.println(name + " draws " + card + ".");
	}//end method initialiDraw
	
	
	@Override //Overrides the default toString method
	
	//Method toString, returns a string representation of the deck of cards
	public String toString(){
		
		return "Current deck of cards: " + "\n" + getDeck();
	}//end method toString
	
}//end of class DeckOfCards