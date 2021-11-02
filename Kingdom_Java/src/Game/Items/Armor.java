package Game.Items;

public class Armor extends Item{

	private final int defaultDefenceValue=10;
	private int defenceValue= defaultDefenceValue;
	
	public Armor(int id, String name, int price, int defenceValue) {
		super(id, name,price);
		
		setDefenceValue(defenceValue);
	}

	public int getDefenceValue() {
		return defenceValue;
	}

	public void setDefenceValue(int defenceValue) {
		if(defenceValue > 0)
		this.defenceValue = defenceValue;
	}
}
