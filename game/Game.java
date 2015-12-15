package game;
/*A package was given to these classes in order to hold the related classes together. Packages
 * are structuring mechanisms. */

import java.util.Scanner;

public class Game {
	/*instance variables are declared with access modifier private so that they may only be accessed 
	 by the methods of this class */
	private static int target;
	private static Scanner scan = new Scanner(System.in);
	static Deck deck = new Deck();
	
	
	/* Methods were all made public so that they could be invoked from within same class or from any other class
	 * This was important because this game required other classes to take methods from each other in order
	 * to function correctly. Protected access would have allowed access to the fields or methods within 
	 * the classes themselves and subclasses. */
	
	public static void main(String[] args) {
		target = 10 + (int) (Math.random() * (( 50 - 10 ) + 1));

		System.out.println("Player One enter your name: ");
		String player1Name = scan.next();
		System.out.println("Player Two enter your name: ");
		String player2Name = scan.next();

		Player one = new Player (target, player1Name, deck);
		Player two = new Player (target, player2Name, deck);

		System.out.println("The target is: " + target); 


		do {
			one.takeTurn();

			if (one.completeTurn() == true) {
				two.takeTurn();
				if (two.completeTurn() == false){
					System.out.println();
					System.out.println(one.getName() + " IS THE WINNER!!!");
					System.out.println(one.getName() + " IS THE WINNER!!!");
					System.out.println(one.getName() + " IS THE WINNER!!!");
					break;
				} else if (two.completeTurn() == true) {
					System.out.println();
					System.out.println("IT'S A TIE!!!");
					System.out.println("IT'S A TIE!!!");
					System.out.println("IT'S A TIE!!!");
					break;
				}
			}

			two.takeTurn();

			if (two.completeTurn()== true) {
				one.takeTurn();
				if (one.completeTurn() == false){
					System.out.println();
					System.out.println(two.getName() + " IS THE WINNER!!!");
					System.out.println(two.getName() + " IS THE WINNER!!!");
					System.out.println(two.getName() + " IS THE WINNER!!!");
					break;
				} else if (one.completeTurn() == true) {
					System.out.println();
					System.out.println("IT'S A TIE!!!");
					System.out.println("IT'S A TIE!!!");
					System.out.println("IT'S A TIE!!!");
					break;
				}
			}

		} while (one.completeTurn() == false && two.completeTurn() == false);

	}

}
			