package com.techelevator;

import com.techelevator.Inventory.Products;

import com.techelevator.view.VendingMachine;


import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "(1) Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "(2) Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "(3) Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };



	public static void main(String[] args) {

		//UserBalance newUserBalance = new UserBalance(0);
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.getProductInfo();

		Scanner userInput = new Scanner(System.in);
		String userSelection;

		System.out.println("Welcome to the Vendo-Matic 800!");
		System.out.println("\n");
		System.out.println("***********Main Menu***********");
		System.out.println("\n");

		do {
			//System.out.println("(1) Display Vending Machine Items");
			System.out.println(MAIN_MENU_OPTIONS[0]);
			//System.out.println("(2) Purchase");
			System.out.println(MAIN_MENU_OPTIONS[1]);
			//System.out.println("(3) Exit");
			System.out.println(MAIN_MENU_OPTIONS[2]);
			System.out.println("\n");
			System.out.println("Please make a selection: ");
			userSelection = userInput.nextLine();


			if (userSelection.equals("1234")) {
				//Generate sales report
			} else if (userSelection.equals("1")) {
				//Set<String> setOfNames = productInfoMap.keySet();
				System.out.println("Here are the options: ");
				System.out.println("\n");
				vendingMachine.printInventory();
				//will use VendingMachine display method
			} else if (userSelection.equals("2")) {
				System.out.println("Here are our options: ");
				//will use VendingMachine display method
				//System.out.println("Current money provided: " + money provided method);
				//double placeholderName
				System.out.println("Current Money Provided: ");
				System.out.println("\n");
				System.out.println("(1) Feed Money");
				System.out.println("take whole dollar 1, 5, 10, 20");


				System.out.println("(2) Select Product");
				System.out.println("(3) Finish Transaction");
				System.out.println("\n");
				System.out.println("Please make a selection: ");
				userSelection = userInput.nextLine();

				if (userSelection.equals("1")) {
					System.out.println("Please only input $1, $5, $10 bills");

				}
				if (userSelection.equals("2")) {

				}
				if (userSelection.equals("3")) {
					//	System.out.println("Thank you for your purchase. Here is your change: " + method change);
					//return change - using nickels, dimes, and quarters
					//return to main menu, instead of System.exit
					//log.txt
				}

				//will use VendingMachine purchase method
			} else if (userSelection.equals("3")) {
				System.out.println("Have a good day!");
				System.exit(1);
			} else {
				System.out.println("Not a valid selection! Returning to main menu....");
				System.out.println();

			}
			System.out.println("\n");
			System.out.println("***********Returning To Main Menu***********");
			System.out.println("\n");

		} while (!userInput.equals("1") || !userInput.equals("2") || !userInput.equals("3") || !userInput.equals("1234"));



	}
}

