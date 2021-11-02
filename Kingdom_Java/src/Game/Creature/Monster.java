package Game.Creature;

import Game.Items.Inventory;

public class Monster extends Creature{

	private final int defaultAttacValue=1;
	private final int defaultDefenceValue=1;
	private int attacValue=defaultAttacValue;
	private int defenceValue= defaultDefenceValue;
	public Monster(String name, int hp, int stamina, int level, Inventory inventory, int attacValue, int defenceValue) {
		super(name, hp, stamina, new Level(level), inventory);
		setAttacValue(attacValue);
		setDefenceValue(defenceValue);
	}
	private void setAttacValue(int attacValue) {
		this.attacValue = attacValue;
	}

	private void setDefenceValue(int defenceValue) {
		this.defenceValue = defenceValue;
	}
	public int getDamage() {
		return attacValue*this.getLevel().getLevelMultiplier();
	}
	
	public int getDefence() {
		return defenceValue * this.getLevel().getLevelMultiplier();
	}
}
