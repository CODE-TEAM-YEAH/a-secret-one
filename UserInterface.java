/*
* Name: Damian Angelone, Liam Duncan, Gagandeep Singh 
* MacID: ​angelodp, duncanla, singhg25
* Student 1408211, 1427659, 1306242
* Description:​ Acts as the user interface for our Online Shopping OOP assignment. 
*/

//Imports used for program.
import java.io.*;
import java.util.*;
import javax.sound.sampled.Line;
import java.lang.Math;


//Class for the user interface.
public class UserInterface {
	private ArrayList<Readable> readables = new ArrayList<Readable>(); // Arraylist for readables.
	private ArrayList<Audio> audioProducts = new ArrayList<Audio>(); // Array list for audio products.
	private int currentPage; // Variable that stores the current page.
	String userName = ""; // Variable that stores the username.
	private Scanner in = new Scanner(System.in); // Scanner used to read in inputs from user.
	private ShoppingCart cart; // Creates an instance/object of the shopping cart class.
	String OGpassword = "ADMIN";
	
	public int changeCurrentPage(int page) { // Method that changes the current page.

		currentPage = page; // Sets the local variable equal to the universal variable.
		return getCurrentPage(page); // Calls the function that will call the chosen page.
	}

	public int getCurrentPage(int page) { // Method that will switch to the chosen page.

		if (page == 1) { // If page 1 is chosen.

			Page1(); // Calls function that displays page 1.

		}

		else if (page == 2) { // If page 2 is chosen.

			System.out.println("Username Successfully added"); // Prints to screen.
			Page1(); // Calls function that displays page 1.
		}

		else if (page == 3) { // If page 3 is chosen.

			System.out.println("Hello, Mr. " + userName + "!\n"); // Prints to screen.
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
		
		else if (page == 11) { // If page 10 is chosen.

			Page11();// Calls function that displays page 10.
		}

		return page; // Returns page number.
	}

	private void Page1() { // Function for page 1.

		readables.clear(); // Clears the readables arraylist (avoid duplicate items, in-case user signs out).
		audioProducts.clear(); // Clears the audio products arraylist (avoid duplicate items, in-case user signs out).
		getReadables(); // Fills the array list with available readables.
		getAudioProducts(); // Fills the array list with available audio products.

		System.out.println("\nChoose your option:	{1} Sign in\n                    	{2} Sign up"); // Prints to screen.
		String choice = in.next(); // Reads in the user's option for page choices.

		if (choice.equals("1")) { // If the chose to sign in.

			System.out.println("\nEnter your username: "); // Prints to screen.
			userName = in.next(); // Reads in the user's username.
			boolean available = false; // Boolean used to check username availability.
			
			//////
			String password; //String that stores the admin' password.
			if(userName.equals("ADMIN")){ //If the user's enters 'ADMIN' as their username.
				System.out.println("\nPlease enter the password: "); // Prints to screen.
				password = in.next(); //Reads in password.
				if(password.equals(OGpassword)){ //
					changeCurrentPage(11); // Change the page to 11.
				}
				else{
					System.out.println("Invalid password.\nReturning to previous menu . . ."); // Prints to screen.
					changeCurrentPage(1); // Change the page to 1.
				}
			}
			//////
			String fileName = "Users.txt"; // Chooses this file to read in.
			String line = null; // Chooses a default line to search through.

			try {
				FileReader fileReader = new FileReader(fileName); // Creates a file reader to read the text file.
				BufferedReader bufferedReader = new BufferedReader(fileReader); // Creates a buffer reader for the file reader.

				while ((line = bufferedReader.readLine()) != null) { // Will read through every line until the end of the file.
					if (userName.equals(line)) { // If the username is equal to a name on the list.

						available = true; // Sets the availabilty variable to true,
					}

				}
				bufferedReader.close(); // Closes the buffer reader.
			} catch (FileNotFoundException ex) { // Checks for file error.
				System.out.println("Unable to open file '" + fileName + "'"); // Prints error to screen.
			} catch (IOException ex) { // Checks for file error.
				System.out.println("Error reading file '" + fileName + "'"); // Prints error to screen.
			}
			/////////////////////////////////////////////

			if (available) { // Occurs if the username appears in file.
				changeCurrentPage(3); // Change the page to 3.
			}

			else if (!available) { // Occurs if the username doesn't appear in file.

				changeCurrentPage(4); // Change the page to 4.
			}

		}

		else if (choice.equals("2")) { // Occurs if they chose to sign in.

			System.out.println("\nChoose your username: "); // Prints to screen.
			userName = in.next(); // Reads in the user's username.
			
			/////
			if(userName.equals("ADMIN".toLowerCase())){
				System.out.println("Invalid username (already exists)."); // Prints to screen.
				changeCurrentPage(1); // Change the page to 1.
			}
			/////
			String fileName = "Users.txt"; // Program will check this text file.

			try {
				FileWriter fileWriter = new FileWriter(fileName, true); // Creates a file writer to write the text file.
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // Creates a buffer  writer for the file writer.
				bufferedWriter.write("\n" + userName); // Adds the user's name to the text file.
				bufferedWriter.close(); // Closes the buffer writer.

			} catch (FileNotFoundException ex) { // Checks for file error.
				System.out.println("Unable to open file '" + fileName + "'"); // Prints error to screen.
			} catch (IOException ex) { // Checks for file error.
				System.out.println("Error reading file '" + fileName + "'"); // Prints error to screen.
			}

			changeCurrentPage(2); // Change the page to 2.
		}
		
		else{
			System.out.println("Incorrect input -- returning to menu."); // Prints to screen.
			changeCurrentPage(1); // Change the page to 1.
		}
	}

	private void Page5() { // Function for page 5.
		cart = new ShoppingCart(userName);
		System.out.println("{1} View Items by Category\n{2} View Shopping Cart\n{3} Sign Out\n{4} View Previous Orders\nChoose your option:"); // Prints to screen.
		String choice2 = in.next(); // Reads in the user's next choice.

		if (choice2.equals("1")) { // If they chose to view items by category.

			changeCurrentPage(6); // Change the page to 6.
		}

		else if (choice2.equals("2")) { // If they chose to view their shopping cart.

			changeCurrentPage(7); // Change the page to 7.
		}

		else if (choice2.equals("3")) { // If they choose to sign out.

			changeCurrentPage(1); // Change the page to 1.
		}
		
		else if (choice2.equals("4")) { 
			
			File g = new File("ItemsBought_" + cart.getUsername() + ".txt"); //Creates a new file extension for the items_bought cart.
			if (!g.exists()) { //If the file doesnt' exist.					
				System.out.println("\nNo items purchased."); // Prints to screen.
				changeCurrentPage(5); // Change the page to 5.
			}
			
			else { //If the file exists.
				System.out.format("%10s%30s%10s\n", "Confirmation Id", "Product Name", "Total"); // Prints to screen.
				String Line = null; //Line used to read file.
				try {
					FileReader reader1 = new FileReader("ItemsBought_" + cart.getUsername() + ".txt");		// Create a file reader of the filename
					BufferedReader ItemsBought = new BufferedReader(reader1);		// Create a buffered reader of the file reader
		
					while ((Line = ItemsBought.readLine()) != null) {	// Loop through every line in the file until null
						String info[] = Line.split("\t"); //Splits the text by tab character.
						System.out.format("%15s%30s%10s\n", info[0], info[1], info[2]); //Prints to screen.
					}
					ItemsBought.close();	// Close the reader
				} catch (IOException e) {	// Catch any exception
					e.printStackTrace(); // Print the exception's message
				}
				
				System.out.println("\nPress -1 to return to previous menu: ");	// Print
				if(in.nextInt() == -1){ //Retruns to previous page.
					changeCurrentPage(5); // Change the page to 5.
				}
			}
		}
		else{
			System.out.println("Incorrect input -- returning to menu."); // Prints to screen.
			changeCurrentPage(5); // Change the page to 5.
		}
	}

	private void Page6() { // Function for page 6.

		System.out.println("\n{1} Readables\n{2} Audio\nChoose your option:\n(Press -1 to go back to the previous menu)"); // Prints to screen.
		String choice3 = in.next(); // Reads in the user's next option.

		if (choice3.equals("1")) { // If they chose to view readables.

			changeCurrentPage(8); // Change the page to 1.
		}

		else if (choice3.equals("2")) { // If they chose to view audio products.

			changeCurrentPage(9); // Change the page to 9.
		}

		else if (choice3.equals("-1")) { // Returns to previous page.

			changeCurrentPage(5); // Change the page to 9.
		}
		else{ //Sanity Check.
			System.out.println("Incorrect input -- returning to menu."); // Prints to screen.
			changeCurrentPage(6); // Change the page to 6.
		}

	}

	private void Page7() { // Function for page 7.

		System.out.println("\nShopping Cart:"); //Prints to screen.
		String line; //Line used for reading file.
		///
		try {
			FileReader fileReader = new FileReader("Cart_" + userName + ".txt"); // Creates a file reader to read the text file.
			BufferedReader bufferedReader = new BufferedReader(fileReader); // Creates a  buffer reader for the file reader.

			while ((line = bufferedReader.readLine()) != null) { // Will read through every line until the end of the file.

				System.out.println(line); //Prints text line to screen.

			}
			bufferedReader.close(); // Closes the buffer reader.
		} catch (FileNotFoundException ex) { // Checks for file error.
			System.out.println("Unable to open file '" + "Cart_" + userName + ".txt" + "'"); // Prints error to screen.
		} catch (IOException ex) { // Checks for file error.
			System.out.println("Error reading file '" + "Cart_" + userName + ".txt" + "'"); // Prints error to screen.
		}
		///
		System.out.println("\nPress -1 to return to previous page:"); // Prints to screen.
		String choice3 = in.next(); //User's input about leaving page.
		if (choice3.equals("-1")) { //Returns to previous menu.
			changeCurrentPage(5); //Changes current page to 5.
		}
		else{ //Sanity check.
			System.out.println("Incorrect input -- returning to menu."); // Prints to screen.
			changeCurrentPage(5); //Changes page to 5.
		}
	}

	private void Page8() { // Function for page 8.

		System.out.println("Readables:\nS.No" + "   " + "Name of the Book" + "   " + "Author" + "   " + "Price($)"
				+ "   " + "Quantity in Store" + "   " + "Type"); // Prints to screen.
		showReadables(); // Shows the items in the readables array list.
		System.out.println("\nChoose your Option: \nOr Press -1 to return to previous menu."); // Prints to screen.
		int choice2 = in.nextInt(); // Reads in the user's next option.
		int optionOnScreen = 0; // Variable used for choosing item.
		boolean continueProg = false; //Used to check for valid input.
		
		for (Readable r : readables) { // Loop will iterate for every item in the readables array list.
			if (r.sNo == choice2) { // Occurs iff the serial number is equal to the user's input.
				continueProg = true; //True if input is valid.
				break; // Ends for each loop.
			} else { // If the current item's serial number doesn't match the user's input, check next item.
				optionOnScreen += 1; // Moves to next item.

			}
		}
		if (choice2 == -1) { // If user chooses to go to previous page.
			changeCurrentPage(6); // Change the page to 6.
		}

		else if(continueProg == true) { // If user chooses an item.
			System.out.println("\nEnter quantity: "); // Prints to screen.
			int quantity = in.nextInt(); // Reads in user's desire quantity.
			readables.get(optionOnScreen).quantityInCart = quantity; // Accesses the chosen item of the desired quantity to the user's cart.
			cart.addItem(readables.get(optionOnScreen)); // Adds item(s) to
															// cart.
			System.out.println("\n" + quantity + " " + readables.get(optionOnScreen).name + " "
					+ "(s) succesfully added to your cart."); // Prints to screen.
			System.out.println("Press -2 to Continue Shopping or Press 0 to checkout: "); // Prints to screen.
			int continuing = in.nextInt(); // Reads in the user's next option.
			if (continuing == -2) { // If user chooses to return to previous page.
				changeCurrentPage(6); // Change the page to 6.
			} else if (continuing == 0) { // If user chooses to checkout.
				changeCurrentPage(10); // Change the page to 10.
			}

		}
		else{ //Sanity check.
			System.out.println("\nInvlid entry.\nReturning to menu . . . \n"); // Prints to screen.
			changeCurrentPage(9); //Changes current page to 9.
		}
	}

	private void Page9() { // Function for page 9.

		System.out.println("Audio:\nS.No" + "   " + "Name of Product" + "   " + "Artist" + "   " + "Price($)" + "   "
				+ "Quantity in Store" + "   " + "Type"); // Prints to screen.
		showAudioProducts(); // Shows the items in the readables array list.
		System.out.println("\nChoose your Option: \nOr Press -1 to return to previous menu."); // Prints to screen.
		int choice = in.nextInt(); // Reads in user's desire quantity.
		int optionOnScreen = 0; // Variable used for choosing item.
		boolean continueProg = false; //Used to check for valid input.
		
		for (Audio r : audioProducts) { // Loop will iterate for every item in the audio products array list.
			if (r.sNo == choice) { // Occurs iff the serial number is equal to the user's input.
				continueProg = true; //True if input is valid.
				break; // Ends for each loop.
			} else { // If the current item's serial number doesn't match the user's input, check next item.
				optionOnScreen += 1; // Moves to next item.

			}
		}

		if (choice == -1) { // If user chooses to go to previous page.

			changeCurrentPage(6); // Change the page to 6.
		}
		
		else if (continueProg == true) { // If user chooses an item.
			System.out.println("\nEnter quantity: "); // Prints to screen.
			int quantity2 = in.nextInt(); // Reads in user's desire quantity.
			audioProducts.get(optionOnScreen).quantityInCart = quantity2; // Accesses the chosen item of the desired quantity to the user's cart.
			cart.addItem(audioProducts.get(optionOnScreen)); // Adds item(s) to cart.
			System.out.println("\n" + quantity2 + " " + audioProducts.get(optionOnScreen).name + " "
					+ "(s) succesfully added to your cart."); // Prints to screen.
			System.out.println("Press -2 to Continue Shopping or Press 0 to checkout: "); // Prints to screen.
			int continuing = in.nextInt(); // Reads in the user's next option.
			if (continuing == -2) { // If user chooses to return to previous
									// page.
				changeCurrentPage(6); // Change the page to 6.
			} else if (continuing == 0) { // If user chooses to checkout.
				changeCurrentPage(10); // Change the page to 10.
			}
		}
		
		else{ //Sanity check.
			System.out.println("\nInvlid entry.\nReturning to menu . . . \n"); // Prints to screen.
			changeCurrentPage(9); //Changes current page to 9.
		}
	}

	private void Page10() { // Function for page 10.

		int i = 0; //Used to print items later in code.
		double envTax, HST, Shipping, total = 0, finalTotal = 0; //Sets variables.
		System.out.println("\nBilling Information: "); // Prints to screen.
		System.out.println("  Name                              Quantity          Price"); //Prints to screen.

		for (Item item : cart.getCart()) { //Will run for every item that exists in the cart.
			System.out.println("\n  " + fmtProd(32, item.name) + "  " + fmtProd(18, Integer.toString(item.quantityInCart))
							+ "  " + fmtProd(7, Integer.toString(item.price))); //Print to screen.
			if (item.type.equals("CD") || item.type.equals("Book")) { //If the user chooses a readable.
				envTax = item.price * item.quantityInCart * 0.02; //Calculates enviornmental tax.
				System.out.println(fmtProd(28, "  Enviornment Tax" + " #" + (i+1) + ": ") + fmtProd(28, "2%") + fmtProd(7, Double.toString(envTax))); //Prints to screen.
			}

			total += item.getPrice() * item.quantityInCart; //Finds total cost of combined items.
			finalTotal += item.price * item.quantityInCart; //Adds all costs togetehr to find the final.
			i++; //Cycle to the next item.
		}

		HST = finalTotal * 0.13; //Calculates HST.
		Shipping = finalTotal * 0.1; //Calculates shipping fee.
		total += HST + Shipping; //Adds togetehr to find the total.
		System.out.println(fmtProd(27, "\n  HST") + "  " + fmtProd(28, "13%") + fmtProd(15, Double.toString(HST))); // Prints to screen.
		System.out.println(fmtProd(28, "  Shipping") + fmtProd(28, "10%") + fmtProd(15,  Double.toString(Shipping))); // Prints to screen.
		System.out.println(fmtProd(55, " ") + "________"); // Prints to screen.
		System.out.println(fmtProd(55, "  Total") + "$" + fmtProd(15, Double.toString(total))); // Prints to screen.
		System.out.println("Are you sure you want to pay? (Yes or No)"); // Prints to screen.
		String ShopChoice = in.next(); //Takes in the suer's response.
		
		double randNumber = Math.random(); //Calculates random number for the ID.
		double d = randNumber * 100; //Makes it 1 - 3 digit.
		int randomInt = (int)d; //Removes decimals.
		String ID = "UD1" + randomInt; //Creates the check-out ID.
		
		if (ShopChoice.toLowerCase().equals("yes")){ //If the user types in any variation of 'yes'.
			System.out.println("\nConfirmation ID: " + ID); // Prints to screen.
			System.out.println("Items shipped to Mr." + userName + ".\nReturning to menu . . .\n"); // Prints to screen.
			cart.addToPurchased(total, ID); //Calls the function that wil ladd items to the 'putchased' text file.
			cart.clean(); //Deletes contents of the cart.
			changeCurrentPage(5); //Changes current page to 5.
		}
		
		else if(ShopChoice.toLowerCase().equals("no")){ //If the user types in any variation of 'no'.
			System.out.println("Payment cancelled.\nDeleting cart . . ."); // Prints to screen.
			changeCurrentPage(6); //Changes current page to 6.
			cart.clean(); //Deletes contents of the cart.
		}
		else{ //Sanity Check
			System.out.println("\nInvalid type -- Please try again."); // Prints to screen.
			changeCurrentPage(10); //Changes current page to 10.
		}

	}
	
	private void Page11(){ // Function for page 11.
		
		System.out.println("\nAdmin Options: \n{1} Sort items by Name \n{2} Sort Items by Price (Minimum to Maximum) \n{3} Change Password \n{4} Add New Item \n{5} Sign Out \n{6} Remove Duplicate Names"); // Prints to screen.
		String adminChoice = in.next(); //takes in the user's response.
		
		if(adminChoice.equals("1")){ //If they chose to sort by name.
			
			System.out.println("Which category would you like to sort?\n{1} CDs \n{2} MP3 \n{3} Books \n{4} eBooks"); // Prints to screen.
			String category = in.next(); //Takes in user's response.
			String file = ""; //Variable to store the file name for read/write.
			
			if(category.equals("1")){ //Is user chooses CDs.
				file = "CDs.txt"; //Choose appropriate file name.
			}
			else if(category.equals("2")){ //Is user chooses MP3.
				file = "MP3.txt"; //Choose appropriate file name.
			}
			else if(category.equals("3")){ //Is user chooses Books.
				file = "Books.txt"; //Choose appropriate file name.
			}
			else if(category.equals("4")){ //Is user chooses eBooks.
				file = "Ebooks.txt"; //Choose appropriate file name.
			}
			else{ //Sanity check.
				System.out.println("Invlid entry.\nReturning to menu . . . "); // Prints to screen.
				changeCurrentPage(11); //Changes current page to 11.
			}
			
			sortByName(file); //Calls function that sorts the items by name.
			System.out.println("File successfully sorted from Minumum to Maximum.\nReturning to menu . . . "); // Prints to screen.
			changeCurrentPage(11); //Changes current page to 11.
			
		}
		else if(adminChoice.equals("2")){ //If they chose to sort by price.
			
			System.out.println("Which category would you like to sort?\n{1} CDs \n{2} MP3 \n{3} Books \n{4} eBooks"); // Prints to screen.
			String category = in.next(); //Takes in user's response.
			String file = ""; //Variable to store the file name for read/write.
			
			if(category.equals("1")){ //Is user chooses CDs.
				file = "CDs.txt"; //Choose appropriate file name.
			}
			else if(category.equals("2")){ //Is user chooses MP3.
				file = "MP3.txt";  //Choose appropriate file name.
			}
			else if(category.equals("3")){ //Is user chooses Books.
				file = "Books.txt"; //Choose appropriate file name.
			}
			else if(category.equals("4")){ //Is user chooses eBooks.
				file = "Ebooks.txt"; //Choose appropriate file name.
			}
			else{ //Sanity check.
				System.out.println("Invlid entry.\nReturning to menu . . . \n"); // Prints to screen.
				changeCurrentPage(11); //Changes current page to 11.
			}
			
			sortByPrice(file); //Calls function that sorts the items by price.
			System.out.println("File successfully sorted from Minumum to Maximum.\nReturning to menu . . . "); // Prints to screen.
			changeCurrentPage(11); //Changes current page to 11.
			
		}
		else if(adminChoice.equals("4")){ //If they chose to change password.
			String newItem = ""; //Used to store new Item.
			System.out.println("\nPlease enter the Serial Number:"); // Prints to screen.
			String SnO = in.next(); //Takes in user's response for serial number.
			newItem += SnO + ", "; //Concatenates the new item.
			System.out.println("\nPlease enter the name of the product:"); // Prints to screen.
			String prodName = in.next(); //Takes in user's response for product name.
			newItem += prodName + ", "; //Concatenates the new item.
			System.out.println("\nPlease enter the Author/Artist:"); // Prints to screen.
			String artistAuthor = in.next(); //Takes in user's response for author/artist.
			newItem += artistAuthor + ", "; //Concatenates the new item.
			System.out.println("\nPlease enter the Price:"); // Prints to screen.
			String newPrice = in.next(); //Takes in user's response for new price.
			newItem += newPrice + ", "; //Concatenates the new item.
			System.out.println("\nPlease enter the Quantity in Store:"); // Prints to screen.
			String newQuantity = in.next(); //Takes in user's response for new quantity..
			newItem += newQuantity + ", "; //Concatenates the new item.
			System.out.println("\nPlease enter the Type of the Product: (CD/MP3/Book/eBook)"); // Prints to screen.
			String newType = (in.next()).toLowerCase(); //Takes in user's response for type (lower-case).
			newItem += newType; //Concatenates the new item.
			
			if(newType.equals("cd")){ //If the chosen type is CDs.
				
				String fileName = "CDs.txt"; // Program will check this text file.

				try {
					FileWriter fileWriter = new FileWriter(fileName, true); // Creates a file writer to write the text file.
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // Creates a buffer  writer for the file writer.
					bufferedWriter.write("\n" + newItem); // Adds the user's name to the text file.
					bufferedWriter.close(); // Closes the buffer writer.

				} catch (FileNotFoundException ex) { // Checks for file error.
					System.out.println("Unable to open file '" + fileName + "'"); // Prints error to screen.
				} catch (IOException ex) { // Checks for file error.
					System.out.println("Error reading file '" + fileName + "'"); // Prints error to screen.
				}
			}
			
			else if(newType.equals("mp3")){ //If the chosen type is MP3.
				
				String fileName = "MP3.txt"; // Program will check this text file.

				try {
					FileWriter fileWriter = new FileWriter(fileName, true); // Creates a file writer to write the text file.
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // Creates a buffer  writer for the file writer.
					bufferedWriter.write("\n" + newItem); // Adds the user's name to the text file.
					bufferedWriter.close(); // Closes the buffer writer.

				} catch (FileNotFoundException ex) { // Checks for file error.
					System.out.println("Unable to open file '" + fileName + "'"); // Prints error to screen.
				} catch (IOException ex) { // Checks for file error.
					System.out.println("Error reading file '" + fileName + "'"); // Prints error to screen.
				}
			}
			
			else if(newType.equals("book")){ //If the chosen type is Book.
				
				String fileName = "Books.txt"; // Program will check this text file.

				try {
					FileWriter fileWriter = new FileWriter(fileName, true); // Creates a file writer to write the text file.
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // Creates a buffer  writer for the file writer.
					bufferedWriter.write("\n" + newItem); // Adds the user's name to the text file.
					bufferedWriter.close(); // Closes the buffer writer.

				} catch (FileNotFoundException ex) { // Checks for file error.
					System.out.println("Unable to open file '" + fileName + "'"); // Prints error to screen.
				} catch (IOException ex) { // Checks for file error.
					System.out.println("Error reading file '" + fileName + "'"); // Prints error to screen.
				}
			}
			
			else if(newType.equals("ebook")){ //If the chosen type is eBook.
				
				String fileName = "Ebooks.txt"; // Program will check this text file.

				try {
					FileWriter fileWriter = new FileWriter(fileName, true); // Creates a file writer to write the text file.
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // Creates a buffer  writer for the file writer.
					bufferedWriter.write("\n" + newItem); // Adds the user's name to the text file.
					bufferedWriter.close(); // Closes the buffer writer.

				} catch (FileNotFoundException ex) { // Checks for file error.
					System.out.println("Unable to open file '" + fileName + "'"); // Prints error to screen.
				} catch (IOException ex) { // Checks for file error.
					System.out.println("Error reading file '" + fileName + "'"); // Prints error to screen.
				}
			}
			
			else{ //Sanity check.
				System.out.println("\nInvalid type -- Returning menu."); // Prints to screen.
				changeCurrentPage(11); //Changes current page to 11.
			}
			
			System.out.println("\nItem added successfully.\nRedirecting to menu . . ."); // Prints to screen.
			changeCurrentPage(11); //Changes current page to 11.
			
			
		}
		else if(adminChoice.equals("3")){ //If they chose to change password.
			System.out.println("\nPlease enter your new password:"); // Prints to screen.
			OGpassword = in.next(); //Takes in user's response.
			System.out.println("\nPassword succesfully changed to " + OGpassword + "."); // Prints to screen.
			changeCurrentPage(11); //Change current page to 11.
		}
		else if(adminChoice.equals("5")){ //If they chose to sign out.
			changeCurrentPage(1); //Change current page to 1.
		}
		
		else if(adminChoice.equals("6")){ //If they chose to remove duplicate names.
			try{
			BufferedReader reader = new BufferedReader(new FileReader("Users.txt")); //Creates new Buffered Reader for the Users text file.
		    Set<String> lines = new HashSet<String>(10000); //Stores each name.
		    String line; //Used to read each line.
		    while ((line = reader.readLine()) != null) { //While line isn't blank (runs through the whole file).
		        lines.add(line.toLowerCase()); //Reads in each lien to the set as a lowercase, so it can compare the mall.
		    }
		    reader.close(); //Closes the reader.
		    BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt")); //Creates new Buffered writer for the Users text file.
		    for (String unique : lines) { //Will loop for as many lines in the user's text file.
		        writer.write(unique); //Writes the only user to the file.
		        writer.newLine(); //Writes a new line.
		    }
		    writer.close(); //Closes the writer.
			
			}
			catch(Exception e){ //Catches errors.
				System.out.println(e); //Outputs errors.
				}
			
			System.out.println("\nDuplicate Usernames Deleted.\nReturning to menu . . . "); //Prints to screen.
			changeCurrentPage(11); //Changes current page to 11.
			
		}
		
		else{ //Sanity check.
			System.out.println("\nInvalid input -- Returning menu."); // Prints to screen.
			changeCurrentPage(11); //Change current page to 11.
		}
	}

	public void getReadables() { // Function that gets the readables.

		String fileName = "Books.txt"; // Will read from the following text file.
		String line; // Creates variable to represent liens of the text file.

		try {
			FileReader fileReader2 = new FileReader(fileName); // Creates a file reader to read the text file.
			BufferedReader bufferedReader = new BufferedReader(fileReader2); // Creates a buffer reader for the file reader.

			while ((line = bufferedReader.readLine()) != null) { // Creates a file reader to read the text file.

				String info[] = line.split(", "); // Reads in every line, splitting at every ', ' .
				readables.add(new Book(info)); // Adds the item to the array list.
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) { // Checks for file error.
			System.out.println("Unable to open file '" + fileName + "'"); // Prints error to screen.
		} catch (IOException ex) { // Checks for file error.
			System.out.println("Error reading file '" + fileName + "'"); // Prints error to screen.
		}
		String fileName2 = "Ebooks.txt"; // Will read from the following text file.
		String line2; // Creates variable to represent liens of the text file.

		try {
			FileReader fileReader3 = new FileReader(fileName2); // Creates a file reader to read the text file.
			BufferedReader bufferedReader2 = new BufferedReader(fileReader3); // Creates a buffer reader for the file reader.

			while ((line2 = bufferedReader2.readLine()) != null) { // Creates a file reader to read the text file.

				String info2[] = line2.split(", "); // Reads in every line, splitting at every ', ' .
				readables.add(new eBook(info2)); // Adds the item to the array list.
			}
			bufferedReader2.close(); // Closes the buffered reader.
		} catch (FileNotFoundException ex) { // Checks for file error.
			System.out.println("Unable to open file '" + fileName2 + "'"); // Prints error to screen.
		} catch (IOException ex) { // Checks for file error.
			System.out.println("Error reading file '" + fileName2 + "'"); // Prints error to screen.
		}

	}

	public void getAudioProducts() { // Function that gets the audio products.

		String fileName = "CDs.txt"; // Will read from the following text file.
		String line; // Creates variable to represent liens of the text file.

		try {
			FileReader fileReader2 = new FileReader(fileName); // Creates a file reader to read the text file.
			BufferedReader bufferedReader = new BufferedReader(fileReader2); // Creates a buffer reader for the file reader.

			while ((line = bufferedReader.readLine()) != null) { // Creates a file reader to read the text file.
				//System.out.println((line));
				String info[] = line.split(", "); // Reads in every line, splitting at every ', ' .
				audioProducts.add(new CD(info)); // Adds the item to the array list.
			}
			bufferedReader.close(); // Closes the buffered reader.
		} catch (FileNotFoundException ex) { // Checks for file error.
			System.out.println("Unable to open file '" + fileName + "'"); // Prints error to screen.
		} catch (IOException ex) { // Checks for file error.
			System.out.println("Error reading file '" + fileName + "'"); // Prints error to screen.
		}

		String fileName2 = "MP3.txt"; // Will read from the following text file.
		String line2; // Creates variable to represent liens of the text file.

		try {
			FileReader fileReader3 = new FileReader(fileName2); // Creates a file reader to read the text file.
			BufferedReader bufferedReader2 = new BufferedReader(fileReader3); // Creates a buffer reader for the file reader.

			while ((line2 = bufferedReader2.readLine()) != null) { // Creates a file reader to read the text file.

				String info2[] = line2.split(", "); // Reads in every line, splitting at every ', ' .
				audioProducts.add(new MP3(info2)); // Adds the item to the array list.
			}
			bufferedReader2.close(); // Closes the buffered reader.
		} catch (FileNotFoundException ex) { // Checks for file error.
			System.out.println("Unable to open file '" + fileName2 + "'"); // Prints error to screen.
		} catch (IOException ex) { // Checks for file error.
			System.out.println("Error reading file '" + fileName2 + "'"); // Prints error to screen.
		}
	}

	public String fmtProd(int space, String data) { // Function that formats the items.
		int l = data.length(); // Checks length of data.
		String k; // Amount of blank spaces.
		if (l > space) { // If the string is too long for the format.
			k = data.substring(0, space - 3) + "..."; // Shortens the string that's too long.
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
		for (Readable i : readables) { // Iterates for all elements of the array list.
			read = i.getInfo().split("///"); // Splits each variable by '///'.

			System.out.println(" " + fmtProd(5, read[0]) + "  " + fmtProd(17, read[1]) + "  "
					+ fmtProd(7, read[2]) + "  " + fmtProd(9, read[3]) + "  " + fmtProd(18, read[4]) + "  "
					+ fmtProd(5, read[5])); // Prints out the formatted items.
		}
	}

	public void showAudioProducts() { // Function that shows the audio items.

		String[] read; // Creates an array that stores the items to display.
		for (Audio i : audioProducts) { // Iterates for all elements of the array list.

			read = i.getInfo().split("///"); // Splits each variable by '///'.
			System.out.println(" " + fmtProd(5, read[0]) + "  " + fmtProd(17, read[1]) + "  "
					+ fmtProd(7, read[2]) + "  " + fmtProd(9, read[3]) + "  " + fmtProd(18, read[4]) + "  "
					+ fmtProd(5, read[5])); // Prints out the formatted items.
		}

	}
	
	public void sortByPrice(String FileName){ //Function used to sort by price (min to max) -- similar to bubble sort.
		
		try{
			FileReader fileReader = new FileReader(FileName); // Creates a file reader to read the text file.
			BufferedReader Item = new BufferedReader(fileReader); // Creates a buffer reader for the file reader.
			ArrayList<String[]> Lines = new ArrayList<>(); //Used to store temporary sorted items.
			String line; //used to read through the lines.
			while ((line = Item.readLine()) != null){ // Creates a file reader to read the text file.
				String[] Content = line.split(", "); //Splits the string by ', ' .
				Lines.add(Content); //Adds each split string to the array.
				}
			int count = 1; //Used for iteration.
			for(int i = 0; i < Lines.size(); i++){ //Will run for as many times as the size of the array.
				for(int j = i; j < Lines.size(); j++){ //Will run for as many times as the size of the array (same as above).
					int a = Integer.parseInt(Lines.get(i)[3]); //Checks the price of item A.
					int b = Integer.parseInt(Lines.get(j)[3]); //Checks the price of item B.
					if(a > b){ //If Item A is more expensive than Item B.
						String[] Temp = Lines.get(i); //Takes the first object into the array.
						Lines.set(i, Lines.get(j)); //Swaps the two items.
						Lines.set(j, Temp); //Store item from the temp array in the position of the other item.
						i = 0; //Resets process.	
					}
				}
			}
			FileWriter fileWriter = new FileWriter(FileName, false); // Creates a file writer to write the text file (overwrite).
			BufferedWriter Write = new BufferedWriter(fileWriter); // Creates a buffer  writer for the file writer.
			Write.write(""); //Clears the text file.
			Write.close(); //Closes the writer.
			FileWriter fileWriter2 = new FileWriter(FileName, true); // Creates a file writer to write the text file.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter2); // Creates a buffer  writer for the file writer.
			int a =0; //Used for iteration.
			for (String[] i : Lines){ //Will loop for as many times as there are items in Lines.
				String str = ""; //Used to store the new Item.
				for(String s : i){ //Will loop for as many times as the length of string s.
					str += s + ", "; //Concatenates the item together.
				}
				str = str.substring(0, str.length() - 2); //removes the last ', ' from the item.
				if (a < Lines.size()) { //If the length of the array of items is greater than our value (beginning of loop).
					str += "\n"; //Skip a line.
				}
				a++; //Increase our iteration value.
				bufferedWriter.write(str); // Adds the user's name to the text file.
			}	
			bufferedWriter.close(); // Closes the buffer writer.
		}
		catch(Exception e) //Checks for errors.
		{
			System.out.println(e); //Prints errors to user.
		}
	}
	
	public void sortByName(String FileName) { //Function used to sort the items alphabetically.
		
		try{
			FileReader fileReader = new FileReader(FileName); // Creates a file reader to read the text file.
			BufferedReader Item = new BufferedReader(fileReader); // Creates a buffer reader for the file reader.
			ArrayList<String[]> Lines = new ArrayList<>(); //Used to store temporary sorted items.
			String line; //used to read through the lines.
			while ((line = Item.readLine()) != null){ // Creates a file reader to read the text file.
				String[] Content = line.split(", "); //Splits the string by ', ' .
				Lines.add(Content); //Adds each split string to the array.
				}
			int count = 1; //Used for iteration.
			for(int i = 0; i < Lines.size(); i++){ //Will run for as many times as the size of the array.
				for(int j = i; j < Lines.size(); j++){ //Will run for as many times as the size of the array (same as above).
					
					String a = Lines.get(i)[1]; //Checks the name of item A.
					String b = Lines.get(j)[1]; //Checks the name of item B.
					
					int compare = a.compareTo(b); //Compares the first character of each string.
					
					if (compare > 0)  //Above statement returns a positive number if A is greater than B in the alphabet.
					{  
						String[] Temp = Lines.get(i); //Stores item A in a temp array.
						Lines.set(i, Lines.get(j)); //Swaps the position of A and B.
						Lines.set(j, Temp); //Stores A where B used to be (bubble sort).
						i = 0;
					} 
						
				}
				
		}
			FileWriter fileWriter = new FileWriter(FileName, false); // Creates a file writer to write the text file (overwrite).
			BufferedWriter Write = new BufferedWriter(fileWriter); // Creates a buffer  writer for the file writer.
			Write.write(""); //Clears the text file.
			Write.close(); //Closes the writer.
			FileWriter fileWriter2 = new FileWriter(FileName, true); // Creates a file writer to write the text file.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter2); // Creates a buffer  writer for the file writer.
			int a =0; //Used for iteration.
			for (String[] i : Lines){ //Will loop for as many times as there are items in Lines.
				String str = ""; //Used to store the new Item.
				for(String s : i){ //Will loop for as many times as the length of string s.
					str += s + ", "; //Concatenates the item together.
				}
				str = str.substring(0, str.length() - 2); //removes the last ', ' from the item.
				if (a < Lines.size()) { //If the length of the array of items is greater than our value (beginning of loop).
					str += "\n"; //Skip a line.
				}
				a++; //Increase our iteration value.
				bufferedWriter.write(str); // Adds the user's name to the text file.
			}	
			bufferedWriter.close(); // Closes the buffer writer.
		}
		catch(Exception e) //Checks for errors.
		{
			System.out.println(e); //Prints errors to user.
		}
	}
}