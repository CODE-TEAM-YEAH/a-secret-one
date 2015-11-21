
//Imports used for program.
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//Class for the user interface.
public class UserInterface {
	private ArrayList<Readable> readables = new ArrayList<Readable>(); // Array
																		// list
																		// for
																		// readables.
	private ArrayList<Audio> audioProducts = new ArrayList<Audio>(); // Array
																		// list
																		// for
																		// audio
																		// products.
	private int currentPage; // Variable that stores the current page.
	String userName = ""; // Variable that stores the username.
	private Scanner in = new Scanner(System.in); // Scanner used to read in
													// inputs from user.
	private ShoppingCart cart; // Creates an instance/object of the shopping
								// cart class.

	public int changeCurrentPage(int page) { // Method that changes the current
												// page.

		currentPage = page; // Sets the local variable equal to the universal
							// variable.
		return getCurrentPage(page); // Calls the function that will call the
										// chosen page.
	}

	public int getCurrentPage(int page) { // Method that will switch to the
											// chosen page.

		if (page == 1) { // If page 1 is chosen.

			Page1(); // Calls function that displays page 1.

		}

		else if (page == 2) { // If page 2 is chosen.

			System.out.println("Username Successfully added"); // Prints to
																// screen.
			Page1(); // Calls function that displays page 1.
		}

		else if (page == 3) { // If page 3 is chosen.

			System.out.println("Hello, Mr. " + userName + "!\n"); // Prints to
																	// screen.
			Page5(); // Calls function that displays page 5.
		}

		else if (page == 4) { // If page 4 is chosen.

			System.out.println("No Access"); // Prints to screen.
			Page1(); // Calls function that displays page 1.

		}

		else if (page == 5) { // If page 5 is chosen.

			Page5(); // Calls function that displays page 5.
		}

		else if (page == 6) { // If page 6 is chosen.

			Page6(); // Calls function that displays page 6.
		}

		else if (page == 7) { // If page 7 is chosen.

			Page7(); // Calls function that displays page 7.

		}

		else if (page == 8) { // If page 8 is chosen.

			Page8(); // Calls function that displays page 8.

		} else if (page == 9) { // If page 9 is chosen.

			Page9(); // Calls function that displays page 9.

		} else if (page == 10) { // If page 10 is chosen.

			Page10();// Calls function that displays page 10.
		}

		return page; // Returns page number.
	}

	private void Page1() { // Function for page 1.

		readables.clear(); // Clears the readables arraylist (avoid duplicate
							// items, in-case user signs out).
		audioProducts.clear(); // Clears the audio products arraylist (avoid
								// duplicate items, in-case user signs out).
		getReadables(); // Fills the array list with available readables.
		getAudioProducts(); // Fills the array list with available audio
							// products.

		System.out.println("Choose your option:	{1} Sign in\n                    	{2} Sign up"); // Prints
																									// to
																									// screen.
		int choice = in.nextInt(); // Reads in the user's option for page
									// choices.

		if (choice == 1) { // If the chose to sign in.

			System.out.println("\nEnter your username: "); // Prints to screen.
			userName = in.next(); // Reads in the user's username.
			boolean available = false; // Boolean used to check username
										// availability.

			String fileName = "Users.txt"; // Chooses this file to read in.
			String line = null; // Chooses a default line to search through.

			try {
				FileReader fileReader = new FileReader(fileName); // Creates a
																	// file
																	// reader to
																	// read the
																	// text
																	// file.
				BufferedReader bufferedReader = new BufferedReader(fileReader); // Creates
																				// a
																				// buffer
																				// reader
																				// for
																				// the
																				// file
																				// reader.

				while ((line = bufferedReader.readLine()) != null) { // Will
																		// read
																		// through
																		// every
																		// line
																		// until
																		// the
																		// end
																		// of
																		// the
																		// file.
					if (userName.equals(line)) { // If the username is equal to
													// a name on the list.

						available = true; // Sets the availabilty variable to
											// true,
					}

				}
				bufferedReader.close(); // Closes the buffer reader.
			} catch (FileNotFoundException ex) { // Checks for file error.
				System.out.println("Unable to open file '" + fileName + "'"); // Prints
																				// error
																				// to
																				// screen.
			} catch (IOException ex) { // Checks for file error.
				System.out.println("Error reading file '" + fileName + "'"); // Prints
																				// error
																				// to
																				// screen.
			}
			/////////////////////////////////////////////

			if (available) { // Occurs if the username appears in file.
				changeCurrentPage(3); // Change the page to 3.
			}

			else if (!available) { // Occurs if the username doesn't appear in
									// file.

				changeCurrentPage(4); // Change the page to 4.
			}

		}

		else if (choice == 2) { // Occurs if they chose to sign in.

			System.out.println("\nChoose your username: "); // Prints to screen.
			userName = in.next(); // Reads in the user's username.

			String fileName = "Users.txt"; // Program will check this text file.

			try {
				FileWriter fileWriter = new FileWriter(fileName, true); // Creates
																		// a
																		// file
																		// writer
																		// to
																		// write
																		// the
																		// text
																		// file.
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // Creates
																				// a
																				// buffer
																				// writer
																				// for
																				// the
																				// file
																				// writer.
				bufferedWriter.write("\n" + userName); // Adds the user's name
														// to the text file.
				bufferedWriter.close(); // Closes the buffer writer.

			} catch (FileNotFoundException ex) { // Checks for file error.
				System.out.println("Unable to open file '" + fileName + "'"); // Prints
																				// error
																				// to
																				// screen.
			} catch (IOException ex) { // Checks for file error.
				System.out.println("Error reading file '" + fileName + "'"); // Prints
																				// error
																				// to
																				// screen.
			}

			changeCurrentPage(2); // Change the page to 2.
		}
	}

	private void Page5() { // Function for page 5.
		cart = new ShoppingCart(userName);
		System.out.println("\n{1} View Items by Category\n{2} View Shopping Cart\n{3} Sign Out\nChoose your option:"); // Prints
																														// to
																														// screen.
		int choice2 = in.nextInt(); // Reads in the user's next choice.

		if (choice2 == 1) { // If they chose to view items by category.

			changeCurrentPage(6); // Change the page to 6.
		}

		else if (choice2 == 2) { // If they chose to view their shopping cart.

			changeCurrentPage(7); // Change the page to 7.
		}

		else if (choice2 == 3) { // If they choose to sign out.

			changeCurrentPage(1); // Change the page to 1.
		}
	}

	private void Page6() { // Function for page 6.

		System.out
				.println("\n{1} Readables\n{2} Audio\nChoose your option:\n(Press -1 to go back to the previous menu)"); // Prints
																															// to
																															// screen.
		int choice3 = in.nextInt(); // Reads in the user's next option.

		if (choice3 == 1) { // If they chose to view readables.

			changeCurrentPage(8); // Change the page to 1.
		}

		else if (choice3 == 2) { // If they chose to view audio products.

			changeCurrentPage(9); // Change the page to 9.
		}

		else if (choice3 == -1) { // Returns to previous page.

			changeCurrentPage(5); // Change the page to 9.
		}

	}

	private void Page7() { // Function for page 7.

		System.out.println("\nShopping Cart:");
		String line;
		///
		try {
			FileReader fileReader = new FileReader("Cart_" + userName + ".txt"); // Creates
																					// a
																					// file
																					// reader
																					// to
																					// read
																					// the
																					// text
																					// file.
			BufferedReader bufferedReader = new BufferedReader(fileReader); // Creates
																			// a
																			// buffer
																			// reader
																			// for
																			// the
																			// file
																			// reader.

			while ((line = bufferedReader.readLine()) != null) { // Will read
																	// through
																	// every
																	// line
																	// until the
																	// end of
																	// the file.

				System.out.println(line);

			}
			bufferedReader.close(); // Closes the buffer reader.
		} catch (FileNotFoundException ex) { // Checks for file error.
			System.out.println("Unable to open file '" + "Cart_" + userName + ".txt" + "'"); // Prints
																								// error
																								// to
																								// screen.
		} catch (IOException ex) { // Checks for file error.
			System.out.println("Error reading file '" + "Cart_" + userName + ".txt" + "'"); // Prints
																							// error
																							// to
																							// screen.
		}
		///
		System.out.println("\nPress -1 to return to previous page:");
		int choice3 = in.nextInt();
		if (choice3 == -1) {
			changeCurrentPage(5);
		}
	}

	private void Page8() { // Function for page 8.

		System.out.println("Readables:\nS.No" + "   " + "Name of the Book" + "   " + "Author" + "   " + "Price($)"
				+ "   " + "Quantity in Store" + "   " + "Type"); // Prints to
																	// screen.
		showReadables(); // Shows the items in the readables array list.
		System.out.println("\nChoose your Option: \nOr Press -1 to return to previous menu."); // Prints
																								// to
																								// screen.
		int choice2 = in.nextInt(); // Reads in the user's next option.
		int optionOnScreen = 0; // Variable used for choosing item.

		for (Readable r : readables) { // Loop will iterate for every item in
										// the readables array list.
			if (r.sNo == choice2) { // Occurs iff the serial number is equal to
									// the user's input.
				break; // Ends for each loop.
			} else { // If the current item's serial number doesn't match the
						// user's input, check next item.
				optionOnScreen += 1; // Moves to next item.

			}
		}
		if (choice2 == -1) { // If user chooses to go to previous page.
			changeCurrentPage(6); // Change the page to 6.
		}

		else { // If user chooses an item.
			System.out.println("\nEnter quantity: "); // Prints to screen.
			int quantity = in.nextInt(); // Reads in user's desire quantity.
			readables.get(optionOnScreen).quantityInCart = quantity; // Accesses
																		// the
																		// chosen
																		// item
																		// of
																		// the
																		// desired
																		// quantity
																		// to
																		// the
																		// user's
																		// cart.
			cart.addItem(readables.get(optionOnScreen)); // Adds item(s) to
															// cart.
			System.out.println("\n" + quantity + " " + readables.get(optionOnScreen).name + " "
					+ "(s) succesfully added to your cart."); // Prints to
																// screen.
			System.out.println("Press -2 to Continue Shopping or Press 0 to checkout: "); // Prints
																							// to
																							// screen.
			int continuing = in.nextInt(); // Reads in the user's next option.
			if (continuing == -2) { // If user chooses to return to previous
									// page.
				changeCurrentPage(6); // Change the page to 6.
			} else if (continuing == 0) { // If user chooses to checkout.
				changeCurrentPage(10); // Change the page to 10.
			}

		}
	}

	private void Page9() { // Function for page 9.

		System.out.println("Audio:\nS.No" + "   " + "Name of Product" + "   " + "Artist" + "   " + "Price($)" + "   "
				+ "Quantity in Store" + "   " + "Type"); // Prints to screen.
		showAudioProducts(); // Shows the items in the readables array list.
		System.out.println("\nChoose your Option: \nOr Press -1 to return to previous menu."); // Prints
																								// to
																								// screen.
		int choice = in.nextInt(); // Reads in user's desire quantity.
		int optionOnScreen = 0; // Variable used for choosing item.

		for (Audio r : audioProducts) { // Loop will iterate for every item in
										// the audio products array list.
			if (r.sNo == choice) { // Occurs iff the serial number is equal to
									// the user's input.
				break; // Ends for each loop.
			} else { // If the current item's serial number doesn't match the
						// user's input, check next item.
				optionOnScreen += 1; // Moves to next item.

			}
		}

		if (choice == -1) { // If user chooses to go to previous page.

			changeCurrentPage(6); // Change the page to 6.
		}

		else { // If user chooses an item.
			System.out.println("\nEnter quantity: "); // Prints to screen.
			int quantity2 = in.nextInt(); // Reads in user's desire quantity.
			audioProducts.get(optionOnScreen).quantityInCart = quantity2; // Accesses
																			// the
																			// chosen
																			// item
																			// of
																			// the
																			// desired
																			// quanitity
																			// to
																			// the
																			// user's
																			// cart.
			cart.addItem(audioProducts.get(optionOnScreen)); // Adds item(s) to
																// cart.
			System.out.println("\n" + quantity2 + " " + audioProducts.get(optionOnScreen).name + " "
					+ "(s) succesfully added to your cart."); // Prints to
																// screen.
			System.out.println("Press -2 to Continue Shopping or Press 0 to checkout: "); // Prints
																							// to
																							// screen.
			int continuing = in.nextInt(); // Reads in the user's next option.
			if (continuing == -2) { // If user chooses to return to previous
									// page.
				changeCurrentPage(6); // Change the page to 6.
			} else if (continuing == 0) { // If user chooses to checkout.
				changeCurrentPage(10); // Change the page to 10.
			}

		}
	}

	private void Page10() {

		int i = 0;
		double envTax, HST, Shipping, total = 0, finalTotal = 0;
		System.out.println("\nBilling Information: ");
		System.out.println("  Name                              Quantity          Price");

		for (Item item : cart.getCart()) {
			System.out.println("\n  " + fmtProd(32, item.name) + "  " + fmtProd(18, Integer.toString(item.quantityInCart))
							+ "  " + fmtProd(7, Integer.toString(item.price)));
			if (item.type.equals("CD") || item.type.equals("Book")) {
				envTax = item.price * item.quantityInCart * 0.02;
				System.out.println(fmtProd(28, "  Enviornment Tax" + " #" + (i+1) + ": ") + fmtProd(28, "2%") + fmtProd(7, Double.toString(envTax)));
			}

			total += item.getPrice() * item.quantityInCart;
			finalTotal += item.price * item.quantityInCart;
			i++;
		}

		HST = finalTotal * 0.13;
		Shipping = finalTotal * 0.1;
		total += HST + Shipping;
		System.out.println(fmtProd(27, "\n  HST") + "  " + fmtProd(28, "13%") + fmtProd(15, Double.toString(HST)));
		System.out.println(fmtProd(28, "  Shipping") + fmtProd(28, "10%") + fmtProd(15,  Double.toString(Shipping)));
		System.out.println(fmtProd(55, " ") + "________");
		System.out.println(fmtProd(55, "  Total") + "$" + fmtProd(15, Double.toString(total)));
		System.out.println("Are you sure you want to pay? yes or no. yes");

		// cart.DeleteFile();
	}

	public void getReadables() { // Function that gets the readables.

		String fileName = "Books.txt"; // Will read from the following text
										// file.
		String line; // Creates variable to represent liens of the text file.

		try {
			FileReader fileReader2 = new FileReader(fileName); // Creates a file
																// reader to
																// read the text
																// file.
			BufferedReader bufferedReader = new BufferedReader(fileReader2); // Creates
																				// a
																				// buffer
																				// reader
																				// for
																				// the
																				// file
																				// reader.

			while ((line = bufferedReader.readLine()) != null) { // Creates a
																	// file
																	// reader to
																	// read the
																	// text
																	// file.

				String info[] = line.split(", "); // Reads in every line,
													// splitting at every ', ' .
				readables.add(new Book(info)); // Adds the item to the array
												// list.
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) { // Checks for file error.
			System.out.println("Unable to open file '" + fileName + "'"); // Prints
																			// error
																			// to
																			// screen.
		} catch (IOException ex) { // Checks for file error.
			System.out.println("Error reading file '" + fileName + "'"); // Prints
																			// error
																			// to
																			// screen.
		}
		String fileName2 = "Ebooks.txt"; // Will read from the following text
											// file.
		String line2; // Creates variable to represent liens of the text file.

		try {
			FileReader fileReader3 = new FileReader(fileName2); // Creates a
																// file reader
																// to read the
																// text file.
			BufferedReader bufferedReader2 = new BufferedReader(fileReader3); // Creates
																				// a
																				// buffer
																				// reader
																				// for
																				// the
																				// file
																				// reader.

			while ((line2 = bufferedReader2.readLine()) != null) { // Creates a
																	// file
																	// reader to
																	// read the
																	// text
																	// file.

				String info2[] = line2.split(", "); // Reads in every line,
													// splitting at every ', ' .
				readables.add(new eBook(info2)); // Adds the item to the array
													// list.
			}
			bufferedReader2.close(); // Closes the buffered reader.
		} catch (FileNotFoundException ex) { // Checks for file error.
			System.out.println("Unable to open file '" + fileName2 + "'"); // Prints
																			// error
																			// to
																			// screen.
		} catch (IOException ex) { // Checks for file error.
			System.out.println("Error reading file '" + fileName2 + "'"); // Prints
																			// error
																			// to
																			// screen.
		}

	}

	public void getAudioProducts() { // Function that gets the audio products.

		String fileName = "CDs.txt"; // Will read from the following text file.
		String line; // Creates variable to represent liens of the text file.

		try {
			FileReader fileReader2 = new FileReader(fileName); // Creates a file
																// reader to
																// read the text
																// file.
			BufferedReader bufferedReader = new BufferedReader(fileReader2); // Creates
																				// a
																				// buffer
																				// reader
																				// for
																				// the
																				// file
																				// reader.

			while ((line = bufferedReader.readLine()) != null) { // Creates a
																	// file
																	// reader to
																	// read the
																	// text
																	// file.
				//System.out.println((line));
				String info[] = line.split(", "); // Reads in every line,
													// splitting at every ', ' .
				audioProducts.add(new CD(info)); // Adds the item to the array
													// list.
			}
			bufferedReader.close(); // Closes the buffered reader.
		} catch (FileNotFoundException ex) { // Checks for file error.
			System.out.println("Unable to open file '" + fileName + "'"); // Prints
																			// error
																			// to
																			// screen.
		} catch (IOException ex) { // Checks for file error.
			System.out.println("Error reading file '" + fileName + "'"); // Prints
																			// error
																			// to
																			// screen.
		}

		String fileName2 = "MP3.txt"; // Will read from the following text file.
		String line2; // Creates variable to represent liens of the text file.

		try {
			FileReader fileReader3 = new FileReader(fileName2); // Creates a
																// file reader
																// to read the
																// text file.
			BufferedReader bufferedReader2 = new BufferedReader(fileReader3); // Creates
																				// a
																				// buffer
																				// reader
																				// for
																				// the
																				// file
																				// reader.

			while ((line2 = bufferedReader2.readLine()) != null) { // Creates a
																	// file
																	// reader to
																	// read the
																	// text
																	// file.

				String info2[] = line2.split(", "); // Reads in every line,
													// splitting at every ', ' .
				audioProducts.add(new MP3(info2)); // Adds the item to the array
													// list.
			}
			bufferedReader2.close(); // Closes the buffered reader.
		} catch (FileNotFoundException ex) { // Checks for file error.
			System.out.println("Unable to open file '" + fileName2 + "'"); // Prints
																			// error
																			// to
																			// screen.
		} catch (IOException ex) { // Checks for file error.
			System.out.println("Error reading file '" + fileName2 + "'"); // Prints
																			// error
																			// to
																			// screen.
		}
	}

	public String fmtProd(int space, String data) { // Function that formats
														// the items.
		int l = data.length(); // Checks length of data.
		String k; // Amount of blank spaces.
		if (l > space) { // If the string is too long for the format.
			k = data.substring(0, space - 3) + "..."; // Shortens the string
														// that's too long.
		} else { // If the string fits in the format.
			String m = ""; // Sets initial length of format to zero.
			for (int j = 0; j < (space - l); j++) { // Checks all lengths.
				m += " "; // Edit format
			}
			k = data + m; // Add format with words.
		}
		return k; // Returns the formated text.
	}

	public void showReadables() { // Function that shows the readable items.
		String[] read; // Creates an array that stores the items to display.
		for (Readable i : readables) { // Iterates for all elements of the array
										// list.
			read = i.getInfo().split("///"); // Splits each variable by '///'.

			System.out.println(" " + fmtProd(5, read[0]) + "  " + fmtProd(17, read[1]) + "  "
					+ fmtProd(7, read[2]) + "  " + fmtProd(9, read[3]) + "  " + fmtProd(18, read[4]) + "  "
					+ fmtProd(5, read[5])); // Prints out the formatted items.
		}
	}

	public void showAudioProducts() { // Function that shows the audio items.

		String[] read; // Creates an array that stores the items to display.
		for (Audio i : audioProducts) { // Iterates for all elements of the
										// array list.

			read = i.getInfo().split("///"); // Splits each variable by '///'.
			System.out.println(" " + fmtProd(5, read[0]) + "  " + fmtProd(17, read[1]) + "  "
					+ fmtProd(7, read[2]) + "  " + fmtProd(9, read[3]) + "  " + fmtProd(18, read[4]) + "  "
					+ fmtProd(5, read[5])); // Prints out the formatted
												// items.
		}

	}

}