public class eBook extends Readable {

	@Override
	public int getPrice(){
	
		return 0;
	}

public eBook(String[] info){
		
		sNo = Integer.parseInt(info[0]);
		name = info[1];
		authorName = info[2];
		price = Integer.parseInt(info[3]);
		quantity = Integer.parseInt(info[4]);
		type = "CD";
	}
}
