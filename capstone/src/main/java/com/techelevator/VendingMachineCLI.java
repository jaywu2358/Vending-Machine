package com.techelevator;

import com.techelevator.view.Log;
import com.techelevator.view.Menu;

import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };



	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		System.out.println("Welcome to the Vendo-Matic 800!");
		System.out.println("");
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		System.out.println("(3) Exit");
		System.out.println("");
		System.out.println("Please make a selection: ");
		String userSelection = userInput.nextLine();

		if (userSelection.equals("1")) {
			System.out.println("Here are our options: ");
			//will use VendingMachine display method
		} if (userSelection.equals("2")) {
			System.out.println("Here are our options: ");
				//will use VendingMachine display method
			//System.out.println("Current money provided: " + money provided method);
				//double placeholderName

			System.out.println("");
			System.out.println("(1) Feed Money");
				//take whole dollar 1, 5, 10, 20
			System.out.println("(2) Select Product");
			System.out.println("(3) Finish Transaction");
			System.out.println("");
			System.out.println("Please make a selection: ");
			userSelection = userInput.nextLine();

			if(userSelection.equals("1")) {
				System.out.println("Please only input $1, $5, $10, or $20 bills");

			} if(userSelection.equals("2")) {

			} if(userSelection.equals("3")) {
			//	System.out.println("Thank you for your purchase. Here is your change: " + method change);
				//return change - using nickels, dimes, and quarters
				//return to main menu, instead of System.exit
				//log.txt
			}

			//will use VendingMachine purchase method
		} if (userSelection.equals("3")) {
			System.out.println("Have a good day!");
			System.exit(1);
		}

	}
}
