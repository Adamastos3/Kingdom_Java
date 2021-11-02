package Game.Items;

public class Weapon extends Item {
	private final int defaultAttacValue = 10;
	private final int defaultDefenceValue = 10;
	private final int defaultEnduranceConsumption = 1;
	private int attacValue = defaultAttacValue;
	private int defenceValue = defaultDefenceValue;
	private int enduranceConsumption = defaultEnduranceConsumption;

	public Weapon(int id, String name, int price, int attacValue, int defenceValue, int enduranceConsumption) {
		super(id, name, price);
		setAttacValue(attacValue);
		setDefenceValue(defenceValue);
		setEnduranceConsumption(enduranceConsumption);
	}

	public int getAttacValue() {
		return attacValue;
	}

	public void setAttacValue(int attacValue) {
		if (attacValue > 0) {
			this.attacValue = attacValue;
		}
	}

	public int getDefenceValue() {
		return defenceValue;
	}

	public void setDefenceValue(int defenceValue) {
		if (defenceValue > 0)
			this.defenceValue = defenceValue;
	}

	public int getEnduranceConsumption() {
		return enduranceConsumption;
	}

	public void setEnduranceConsumption(int enduranceConsumption) {
		if (enduranceConsumption > 0)
			this.enduranceConsumption = enduranceConsumption;
	}

}
