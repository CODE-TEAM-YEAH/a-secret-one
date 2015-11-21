public class Audio extends Item {

	protected String artistName;
	public String getInfo(){
		
		String info = "";
		info += sNo + "///";
		info += name + "///";
		info += artistName + "///";
		info += price + "///";
		info += quantity + "///";
		info += type;
		return info;
	}
	
	@Override
	public int getPrice(){
	
		return price;
		
	}
	
	
}
