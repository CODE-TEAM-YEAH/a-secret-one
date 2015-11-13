
public class CD extends Audio {

	@Override
	public int getPrice() {
		return 0; //////////////EDIT LATER
	}
	
	public CD(String[] info){
	
		sNo = Integer.parseInt(info[0]);
		name = info[1];
		artistName = info[2];
		price = Integer.parseInt(info[3]);
		quantity = Integer.parseInt(info[4]);
		type = "CD";
	}
}
