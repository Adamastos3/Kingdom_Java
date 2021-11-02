package Game.Items;

public abstract class Item {
	private final int defaultPrice =1;
	private final String defaultName="Item";
	private int id;
	private String name = defaultName;
	private int price = defaultPrice;
	
	public Item(int id, String name, int price) {
		setId(id);
		setPrice(price);
		setName(name);
	}
	
	public int getId() {
		return id;
	}
	
	private void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name != null) {
			this.name=name;
		}
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		if(price >0) {
			this.price=price;
		}
	}
}
