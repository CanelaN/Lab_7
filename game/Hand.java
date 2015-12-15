package game;
/*A package was given to these classes in order to hold the related classes together. Packages
 * are structuring mechanisms. */

import java.util.ArrayList;
import java.util.Scanner;

public class Hand extends Deck {
	/*instance variables are declared with access modifier private so that they may only be accessed 
	 by the methods of this class */

	private int sum; 
	private int product;
	Deck gameDeck = new Deck();
	ArrayList<String> hand = new ArrayList<String>(5);

	/* Methods were all made public so that they could be invoked from within same class or from any other class
	 * This was important because this game required other classes to take methods from each other in order
	 * to function correctly. Protected access would have allowed access to the fields or methods within 
	 * the classes themselves and subclasses. */
	public Hand(Deck deck){
		gameDeck = deck;
		this.hand = new ArrayList<String>(5);
	}
	
	public int size(){

		return hand.size();
	}
	
	public void displayHand(){
		if (isEmpty() == true) {
			System.out.println();
			System.out.println("You have an empty hand");
		} else {
			System.out.println();
			System.out.print("Your hand: ");
			for (int i = 0; i < hand.size(); i++){

				if (i < hand.size()-1) {
					System.out.print(hand.get(i) + ","); 
				} else {
					System.out.print(hand.get(i)); 
				}

			} 
			
		}
		//display player's hand
		//if hand is empty, display a message indicating so
		//otherwise display hand as { , , ,}
	}

	public boolean isEmpty(){
		//returns true if hand is empty
		//otherwise false
		if (hand.size() == 0){

			return true; 
		} else
			return false; 	
	}

	public boolean isFull(){

		if (hand.size() == 5){
			return true;

		}else
			//returns true if hand is full (5 cards)
			//otherwise false
			return false; 	
	}

	public void addCard(String card){
		hand.add(card); 
		//insert card into array of cards

	}

	public void dropCard(int i){
		gameDeck.insertCard(hand.get(i));
		int change = hand.size()-1;
		swap(hand, i, change);

		hand.remove(hand.size()-1);
		
		//drop card at position i
		//swap last card in array with this position
	}



	private static void swap(ArrayList<String> hand, int i, int change) {
		String helper = hand.get(i);
		hand.set(i, hand.get(change));
		hand.set(change, helper);

	}

	public void sumAndProduct(){
		int value = 0; 
		this.sum = 0;
		this.product = 1; 
		for (int i = 0; i < hand.size(); i++){
			if (hand.get(i).equals("Ace")){
				value = aceValue();				
			} else if (hand.get(i).equals("King") || hand.get(i).equals("Queen") || hand.get(i).equals("Jack") ){
				value = 10; 

			}else if (hand.get(i).equals("2")){
				value = 2;

			}else if (hand.get(i).equals("3")){
				value = 3;

			}else if (hand.get(i).equals("4")){
				value = 4;

			}else if (hand.get(i).equals("5")){
				value = 5;

			}else if (hand.get(i).equals("6")){
				value = 6;

			}else if (hand.get(i).equals("7")){
				value = 7;

			}else if (hand.get(i).equals("8")){
				value = 8;

			}else if (hand.get(i).equals("9")){
				value = 9;

			}else if (hand.get(i).equals("10")){
				value = 10;				
			}

			sum += value;	
			product *= value; 
		}
		if (sum > 0 && product > 1){
			System.out.println();
			System.out.println("Sum: " + sum + "| Product: " + product); 
		
		}
		//2 parameters
		//use parameters to calculate the sum and product of the hand
		//if user hold ace, use aceValue to determine what they would like it to be represented by

	}

	public int getSum() {
		return sum;
	}

	public int getProduct() {
		return product;
	}

	public int containsCard(String card){

		//returns index of array if card is in the hand
		//otherwise return -1
		return 0;
	}

	public int aceValue(){
		System.out.println();
		System.out.println("Would you like your Ace to be worth 1 or 11?");
		Scanner scan = new Scanner(System.in);
		int value = scan.nextInt();

		while (value != 1 && value != 11){
			System.out.println();
			System.out.println("That is not a valid response. Please choose 1 or 11.");
			value = scan.nextInt();			
		}
		return value;
	}

	public void drawACard() {
		String drawnCard = gameDeck.drawCard();
		hand.add(drawnCard); 	
		System.out.println();
		System.out.println ("The card you drew was:");
		System.out.println(drawnCard); 
		
	}
	
	
}
