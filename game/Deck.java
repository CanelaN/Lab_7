package game;
/*A package was given to these classes in order to hold the related classes together. Packages
 * are structuring mechanisms */

import java.util.ArrayList;
import java.util.Random;


public class Deck {
	/*instance variables are declared with access modifier private so that they may only be accessed 
	 by the methods of this class */
	private ArrayList<String> deck = new ArrayList<String>(52);
	private ArrayList<String> scrapDeck = new ArrayList<String>();

	/* Methods were all made public so that they could be invoked from within same class or from any other class
	 * This was important because this game required other classes to take methods from each other in order
	 * to function correctly. Protected access would have allowed access to the fields or methods within 
	 * the classes themselves and subclasses. */
	public Deck(){

		/**
		 * initializes deck to full deck of 52 cards, scrap deck empty
		 * shuffles deck
		 */
		for (int i = 0; i < 4; i++){
			deck.add("King");
			deck.add("Queen");
			deck.add("Jack");
			deck.add("Ace");
			deck.add("2");
			deck.add("3");
			deck.add("4");
			deck.add("5");
			deck.add("6");
			deck.add("7");
			deck.add("8");
			deck.add("9");
			deck.add("10");
		}

		shuffle();
		
		this.scrapDeck = new ArrayList<String>();
	}


	/**
	 * insert a discarded card into the scrap deck
	 */
	public void insertCard(String card){
		scrapDeck.add(card);

	}

	/**
	 * return the first card on the deck
	 * If deck is empty, swap the deck with the scrap deck before returning the card
	 */
	public String drawCard(){
		if (isEmpty() == true){
			swapDecks();
		} 

		String drawnCard = deck.get(0);
		
		deck.remove(0);

		return drawnCard;
	}

	/**
	 * @return true if the deck to draw from is empty, false otherwise
	 */
	public boolean isEmpty(){
		if (deck.size() == 0) {
			return true;
		} else

			return false;
	}

	/**
	 * switch the deck and scrap deck
	 * Shuffle the deck
	 */
	public void swapDecks(){
		deck = scrapDeck;
		scrapDeck.clear();

		shuffle();

	}

	/**
	 * using random, loop through the cards in the deck, swapping positions
	 * perform loop 3 times
	 */
	public void shuffle(){
		// Random number generator			

		int n = deck.size();
		Random random = new Random();
		random.nextInt();
		for (int j = 0; j <= 3; j++){

			for (int i = 0; i < n; i++) {
				int change = i + random.nextInt(n - i);
				swap(deck, i, change);
			}

		}
	}

	/**
	 * method created to swap positions  
	 */
	private void swap(ArrayList<String> deck, int i, int change) {
		String helper = deck.get(i);
		deck.set(i, deck.get(change));
		deck.set(change, helper);
	}
	
	/**
	 * method created to keep track of the size of the deck/scrap deck
	 */
	public void displayDecks(){
		System.out.println();
		System.out.println("Deck size: " + deck.size()+ "| Scrap deck size: " + scrapDeck.size());
		
		
		
	}
}

