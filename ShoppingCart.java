import java.util.ArrayList;
import java.io.*;

public class ShoppingCart extends User {
 
	private ArrayList<Item> content = new ArrayList<Item>();
	File f;
	
	public ShoppingCart(String userName){
		
		setUsername(userName);
		f = new File("Cart_" + userName + ".txt");
		
		if(!f.exists()){
			try{
				f.createNewFile();
			} catch (IOException e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void DeleteFile(){
		
		f.delete();
		
	}
	
	public String getContent(){
		
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
			String[] strList = item.getInfo().split("///");
			
			String toAdd = "";
			for (String str : strList) {
				toAdd += str + ", ";
			}
			toAdd = toAdd.substring(0, toAdd.length() - 2);
			
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
