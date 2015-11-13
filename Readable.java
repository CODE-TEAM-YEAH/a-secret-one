public class Readable extends Item{
	
	protected String authorName;

	public String getInfo() {
		
		String info = "";
		info += sNo + "///";
		info += name + "///";
		info += authorName + "///";
		info += price + "///";
		info += quantity + "///";
		info += type;
		return info;
	}
	@Override
	public int getPrice(){
		return 0;
	}
	
}