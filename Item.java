public abstract class Item { //Class used for items.
	public abstract String getInfo(); //gets info about the item.

	public abstract int getPrice(); //Gets the price of the item.

	protected int price; //Universal variable for price.
	protected int sNo; //Universal variable for serial number.
	protected String name; //Universal variable for name.
	protected int quantity; //Universal variable for quantity.
	protected String type; //Universal variable for type.
	protected int quantityInCart; //Universal variable for quantity in user's cart.
	
}