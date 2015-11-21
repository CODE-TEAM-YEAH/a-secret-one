//Class that creates CDs(extends Audio -> Item).
public class CD extends Audio {

	@Override
	public int getPrice() {
		return (int)( price * 1.02);
	}
	
	public CD(String[] info){ //Creates CD objects.
	
		sNo = Integer.parseInt(info[0]); //Reads in first value for serial number.
		name = info[1]; //Reads in second value for the MP3 name.
		artistName = info[2]; //Reads in third value for the artist name.
		price = Integer.parseInt(info[3]); //Reads in fourth value for the price.
		quantity = Integer.parseInt(info[4]); //Reads in fifth value for the quantity.
		type = info[5]; //Reads in sixth value for the type.
	}
}
