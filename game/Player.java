package game;
/*A package was given to these classes in order to hold the related classes together. Packages
 * are structuring mechanisms. */

import java.util.Scanner;

public class Player extends Hand  {
	/*instance variables are declared with access modifier private so that they may only be accessed 
	 by the methods of this class */
	private Scanner scan = new Scanner(System.in); 
	private String name; 
	private int target;
	private static Deck deck = new Deck();

	Hand playerHand = new Hand(deck); 

	/* Methods were all made public so that they could be invoked from within same class or from any other class
	 * This was important because this game required other classes to take methods from each other in order
	 * to function correctly. Protected access would have allowed access to the fields or methods within 
	 * the classes themselves and subclasses. */
	
	/** 
	 * empty hand
	 * no name	
	 */
	public Player(){
		super(deck);
		this.playerHand  = new Hand(deck);
	}


	/**
	 * creates Player object with an empty hand and name 
	 * @param name
	 */
	public Player(int target, String name, Deck gameDeck){
		super(deck);
		deck = gameDeck;
		this.playerHand  = new Hand(deck); 
		this.target = target; 
		this.name = name; 
	}


	/**
	 * displays player's hand - displayHand()
	 * if player's hand is empty, they must draw a card
	 * if player's hand is full, they must drop a card
	 * returns boolean indicating whether or not the player's hand meets the target
	 */
	public boolean takeTurn (){
		System.out.println(">>>><<<<>>>><<<<>>>><<<<>>>><<<<<>>>><<<<>>>><<<<>>>><<<<>>>><<<<>>>><<<<");
		System.out.println();
		System.out.println (getName() + "'s Turn"); 
		System.out.println();
		System.out.println("Target:" + target);
		displayPlayerHand(); 
		System.out.println();
		pickUpOrDrop();

		displayPlayerHand();
		System.out.println();
		playerHand.sumAndProduct();
		deck.displayDecks();

		if (completeTurn() == true){

			return true;		

		} else

			return false;
	}


	/**
	 * displays player's hand 
	 */
	public void displayPlayerHand(){

		playerHand.displayHand();			
	}
	
	/**
	 * returns the player's name
	 */
	public String getName (){
		
		return name; 
	}

	/**
     * determine whether or not user would like to pick up or drop a card
	 * check that selection is valid
	 */
	public void pickUpOrDrop(){
		if(playerHand.isEmpty() == true){
			System.out.println("You must pick a card");
			pickUp();
		} else if (playerHand.isFull() == true){
			System.out.println();
			System.out.println("Your hand is full. You must drop a card");
			drop();
		} else {
			System.out.println();
			System.out.println("Would you like to pick up a card or drop a card? ");
			System.out.println("Enter 'pick' to pick up"
					+ " or 'drop' to drop.");

			String response = scan.next();

			while (!response.equals("pick") && !response.equals("drop")){

				System.out.println("That is not a valid response.");
				System.out.println("Enter 'pick' to pick up"
						+ " or 'drop' to drop.");
				response = scan.next();
			}

			if (response.equals("pick")){
				pickUp();
			}else if (response.equals("drop")){
				drop();			
			}
		}		
	}

	/**
     * displays drawn card to player
	 * adds card to player's hand
	 */
	public void pickUp(){
		playerHand.drawACard();
	}
	
	/**
     * allows user to select which card to drop
     * ensures user selects card that they are holding
	 */
	public void drop (){
		System.out.println();
		System.out.println("Which card would you like to drop?");
		System.out.println(" Enter 0 for the first card,"
				+ "1 for the second, 3 for the fourth, or 4 for the fifth.");
		displayPlayerHand();

		int index = scan.nextInt(); 

		while (index >= playerHand.size() || index < 0){
			System.out.println("That is not a valid response. ");
			System.out.println("Enter 0 for the first card,"
					+ "1 for the second, 3 for the fourth, or 4 for the fifth.");
			index = scan.nextInt();
		}

		playerHand.dropCard(index);
	}

	public boolean completeTurn(){

		if (playerHand.getSum() == target || playerHand.getProduct() == target){

			return true;
		} else

			return false;
	}


}

