/*
* Name: Damian Angelone, Liam Duncan, Gagandeep Singh 
* MacID: ​angelodp, duncanla, singhg25
* Student 1408211, 1427659, 1306242
* Description:​ Creates Readable objects and all its parameters for our Online Shopping OOP assignment. 
*/

public class Readable extends Item{ //Class used for readables (extends items).
	
	protected String authorName; //Stores author's name.

	public String getInfo() { //gets the info of the item.
		
		String info = ""; //Stores the info.
		info += sNo + "///"; //Concatenates information.
		info += name + "///"; //Concatenates information.
		info += authorName + "///"; //Concatenates information.
		info += price + "///"; //Concatenates information.
		info += quantity + "///"; //Concatenates information.
		info += type; //Concatenates information.
		return info; //Returns the info.
	}
	@Override //Overrides the price.
	public int getPrice(){ //Gets the price.
		return price; //Returns price.
	}
	
}