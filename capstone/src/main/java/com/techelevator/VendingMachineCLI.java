package com.techelevator;

import com.techelevator.Inventory.Products;

import com.techelevator.view.Customer;
import com.techelevator.view.Log;
import com.techelevator.view.VendingMachine;


import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.techelevator.view.Log.log;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "(1) Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "(2) Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "(3) Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	public static void main(String[] args) throws FileNotFoundException {

		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.getProductInfo();
		Customer customer = new Customer();

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
				System.out.println("\n");
				System.out.println("*********** Vending Machine Items ***********");
				System.out.println("\n");
				vendingMachine.printInventory();

			} else if (userSelection.equals("2")) {

				System.out.println("\n");
				System.out.println("Current money provided: $" + customer.getRemainingBalance());

				System.out.println("\n");
				System.out.println("(1) Feed Money");
				System.out.println("(2) Select Product");
				System.out.println("(3) Finish Transaction");
				System.out.println("\n");
				System.out.println("Please make a selection: ");
				userSelection = userInput.nextLine();

				if (userSelection.equals("1")) {
					System.out.println("Please only insert $1, $5, $10, or $20 bills");
					userSelection = userInput.nextLine();
					customer.feedMoney(new BigDecimal(userSelection));

				}
				if (userSelection.equals("2")) {
					System.out.println("\n");
					System.out.println("*********** Vending Machine Items ***********");
					System.out.println("\n");
					vendingMachine.printInventory();
					userSelection = userInput.nextLine().toUpperCase();
					vendingMachine.dispenseItem(customer, userSelection);

				}
				if (userSelection.equals("3")) {
					customer.returnChange(vendingMachine.getRemainingBalance());
				}

			} else if (userSelection.equals("3")) {
				;
				customer.returnChange(vendingMachine.getRemainingBalance());
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

