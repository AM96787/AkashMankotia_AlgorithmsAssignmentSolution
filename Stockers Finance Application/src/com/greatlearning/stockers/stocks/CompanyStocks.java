package com.greatlearning.stockers.stocks;

import java.util.HashMap;
import java.util.Scanner;
import com.greatlearning.stockers.sort.*;
import com.greatlearning.stockers.search.*;

public class CompanyStocks {
	public int noOfCompanies, incShareCount, decShareCount;
	double sharePrice, price;
	String shareStatus, status;
	Scanner sc = new Scanner(System.in);
	public double arr[];

	// This function is to get the user input
	// for stock price and companies stock price status
	public void getInputs() {
		HashMap<Integer, Double> pricemap = new HashMap<>();
		HashMap<Integer, String> statusmap = new HashMap<>();
		System.out.print("Enter the number of companies: ");
		noOfCompanies = sc.nextInt();
		System.out.print("\n");
		for (int i = 1; i <= noOfCompanies; i++) {
			System.out.print("Enter the stock price for companies " + i + ": ");
			sharePrice = sc.nextDouble();
			System.out.print("\n");
			System.out.print("Whether company's stock price rose today compare to yesterday?: ");
			shareStatus = sc.next();
			System.out.print("\n");
			pricemap.put(i, sharePrice);
			statusmap.put(i, shareStatus);
		}
		incShareCount = 0;
		decShareCount = 0;
		arr = new double[noOfCompanies];

		for (int i = 1; i <= noOfCompanies; i++) {
			price = pricemap.get(i);
			status = statusmap.get(i);
			int j = i - 1;
			arr[j] = price;
			if (status.toUpperCase().equals("TRUE")) {
				incShareCount = incShareCount + 1;
			} else {
				decShareCount = decShareCount + 1;
			}
		}
	}

	// This function is to display the user input menu
	// and take input choice from users
	public int displayMenuToGetChoice() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("1. Display the companies stock prices in ascending order");
		System.out.println("2. Display the companies stock prices in descending order");
		System.out.println("3. Display the total no of companies for which stock prices rose today");
		System.out.println("4. Display the total no of companies for which stock prices declined today");
		System.out.println("5. Search a specific stock price");
		System.out.println("6. Press 0 to Exit");
		System.out.println("---------------------------------------------------------------------------");
		System.out.print("\n");
		System.out.print("Enter your Choice: ");
		int c = sc.nextInt();
		return c;
	}

	public static void main(String[] args) {
		CompanyStocks cs = new CompanyStocks();
		AscendingSort as = new AscendingSort();
		cs.getInputs();
		int choice;
		do {
			choice = cs.displayMenuToGetChoice();
			System.out.print("\n");
			switch (choice) {
			case 0:
				System.out.println("Exited Successfully");
				break;
			case 1:
				System.out.println("****Stock Prices In Ascending Order****\n");
				as.mergeSort(cs.arr, 0, (cs.arr.length - 1));
				for (int i = 0; i < cs.noOfCompanies; i++) {
					System.out.print(cs.arr[i] + " ");
				}
				System.out.println("\n");
				break;
			case 2:
				DescendingSort ds = new DescendingSort();
				System.out.println("****Stock Prices In Descending Order****\n");
				ds.mergeSort(cs.arr, 0, (cs.arr.length - 1));
				for (int i = 0; i < cs.noOfCompanies; i++) {
					System.out.print(cs.arr[i] + " ");
				}
				System.out.println("\n");
				break;
			case 3:
				System.out.println("Total no of companies for which stock prices rose today: " + cs.incShareCount);
				System.out.println("\n");
				break;
			case 4:
				System.out.println("Total no of companies for which stock prices declined today: " + cs.decShareCount);
				System.out.println("\n");
				break;
			case 5:
				StockSearch bs = new StockSearch();
				as.mergeSort(cs.arr, 0, (cs.arr.length - 1));
				System.out.print("Enter the Stock Price for searching: ");
				double sp = cs.sc.nextDouble();
				System.out.print("\n");
				int s = bs.searchFunction(cs.arr, 0, (cs.arr.length - 1), sp);
				if (s == -1)
					System.out.println("Stock of value " + sp + " is not available\n");
				else
					System.out.println("Stock of value " + sp + " is available\n");
				break;
			default:
				System.out.println("Press 0 to Exit");
				break;
			}
		} while (choice != 0);
	}
}
