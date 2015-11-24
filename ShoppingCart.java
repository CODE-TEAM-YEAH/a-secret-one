/*
* Name: Damian Angelone, Liam Duncan, Gagandeep Singh 
* MacID:​ angelodp, duncanla, singhg25
* Student 1408211, 1427659, 1306242
* Description:​ Creates Shopping Cart objects for our Online Shopping OOP assignment. 
*/


//Imports for the class.
import java.util.ArrayList;
import java.io.*;

public class ShoppingCart extends User { //Class sued for the shopping cart, which extends User.
 
	private ArrayList<Item> content = new ArrayList<Item>(); //Creates an array list used to store the content of the cart.
	File f; //File used for writing and reading.
	
	public ShoppingCart(String userName){ //Creates the shopping cart file.
		
		setUsername(userName); //Gets the username for the file name.
		f = new File("Cart_" + userName + ".txt"); //Creates the file name.
		
		if(!f.exists()){ //If the file doesn't exist.
			try{ //Crates the file.
			} catch (Exception e){ //Checks for errors.
				e.printStackTrace(); //Returns errors to the user.
			}
			
		}
		
	}
	
	public void DeleteFile(){ //Used to delete the shopping cart data.
		
		f.delete(); //Deletes content.
		
	}
	
	public String getContent(){ //Used to get the content in the cart.
		
		String c = "", line;			// Create empty string and a string to hold the file's contents 
		try {
			FileReader reader = new FileReader("Cart_" + getUsername() + ".txt");	// Create a filereader from the cart_username.txt
			BufferedReader buffer = new BufferedReader(reader);			// Create a bufferedreader for the filereader
			while ((line = buffer.readLine()) != null) {			// While the lines in the file isn't null
				c += line + "\n";			// Add the file's line and a new line to the string
			}
			buffer.close();				// Close the bufferedreader
		} catch (Exception e) {			// Catch any exceptions
			e.printStackTrace();		// Print the exception message
		}
		return c;
	}
	public ArrayList<Item> getCart() {		// Function to get thte cart's info
		return content;					// Return the list of contents
	}
	
	public void addItem(Item item){
		content.add(item);				// Add the item to the field content
		try {
			FileWriter writer = new FileWriter("Cart_" + getUsername() + ".txt", true);	// Create a filereader from the cart_username.txt
			BufferedWriter buffer = new BufferedWriter(writer);		// Create a bufferedreader for the filereader
			String[] strList = item.getInfo().split("///"); //Splits at '///' characters.
			
			String toAdd = ""; //Used to store what item is to be added to the cart.
			for (String str : strList) { //Will loop for as many strings there are in strList.
				toAdd += str + ", "; //Adds ', ' between content of the item.
			}
			toAdd = toAdd.substring(0, toAdd.length() - 2); //Removes the final ', ' from the string.
			
			buffer.write(toAdd + "\n");		// Write a new line and the info
			buffer.close();				// Close the bufferedReader
		} catch (Exception e) {		// Catch any exception
			e.printStackTrace();		// Print it's message
		}
	}
	public void addToPurchased(double total, String ID) {		// Function to add a purchase to the file of items bought
		File g = new File("ItemsBought_" + getUsername() + ".txt");		// Create a file in memory
		if (!g.exists()) {						// If that file exists in the disk
			try {
				g.createNewFile();			// Create the file in the disk
				FileWriter writer = new FileWriter("ItemsBought_" + getUsername() + ".txt", true); // Create a filewriter for the ItemsBought file
				BufferedWriter buffer = new BufferedWriter(writer);					// Create a buffer for the writer
				for (Item i : content) {				// For each item in the content
					buffer.write(ID + " \t" + i.name + "\t" + total + "\n");		// Write a new line, the code, the item's name and the total
				}
				buffer.close();							// Close the buffer
			} catch (Exception e) {				// Catch any exception
				e.printStackTrace();		// Print the exception's message
			}
		} else {
			try {
				FileWriter writer = new FileWriter("ItemsBought_" + getUsername() + ".txt", true); // Create a filewriter for the ItemsBought file
				BufferedWriter buffer = new BufferedWriter(writer);					// Create a buffer for the writer
				for (Item i : content) {				// For each item in the content
					buffer.write(ID + "\t" + i.name + "\t" + total + "\n");		// Write a new line, the code, the item's name and the total
				}
				buffer.close();							// Close the buffer
			} catch (Exception e) {				// Catch any exception
				e.printStackTrace();		// Print the exception's message
			}
		}
	}
	public void clean() {		// Function to delete the file
		f.delete();			// delete the file from the disk.
	}
}
