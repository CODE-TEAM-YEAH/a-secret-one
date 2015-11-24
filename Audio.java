/*
* Name: Damian Angelone, Liam Duncan, Gagandeep Singh 
* MacID: ​angelodp, duncanla, singhg25
* Student 1408211, 1427659, 1306242
* Description:​ Creates Audio objects and all of its parameters for our Online Shopping OOP assignment. 
*/

public class Audio extends Item { //This class creates audio objects, extending Item.

	protected String artistName; //variable for the artist name.
	public String getInfo(){ //Method used to return the info of the item.
		
		String info = ""; //Stores the Audio's info.
		info += sNo + "///"; //Concantenate the information. 
		info += name + "///"; //Concantenate the information. 
		info += artistName + "///"; //Concantenate the information. 
		info += price + "///"; //Concantenate the information. 
		info += quantity + "///"; //Concantenate the information. 
		info += type; //Concantenate the information. 
		return info; //Return the info to the suer.
	}
	
	@Override //Override the price.
	public int getPrice(){ //Method that gets the price of the Audio item.
	
		return price; //Return the price to the user.
		
	}
	
	
}
