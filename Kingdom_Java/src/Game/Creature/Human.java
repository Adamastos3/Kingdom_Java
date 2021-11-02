package Game.Creature;

import Game.Items.Armor;
import Game.Items.Inventory;
import Game.Items.Weapon;

public class Human extends Creature {
	
	private Weapon weapon;
	private Armor armor;
	
	public Human(String name, int hp, int stamina, int level, Inventory inventory, int weaponId, int armorId) {
		this(name, hp, stamina, new Level(level), inventory, weaponId, armorId);
		
	}
	public Human(String name, int hp, int stamina, Level level, Inventory inventory, int weaponId, int armorId) {
		super(name, hp, stamina, level, inventory);
		setWeapon(weaponId);
		setArmor(armorId);
		
	}

	public Weapon getWeapon() {
		return weapon;
	}


	public void setWeapon(int weaponId) {
		if(this.getInventory().checkId(weaponId)) {
			Weapon w =null;
			try {
				w = (Weapon) this.getInventory().getElementById(weaponId);
			}catch(Exception e) {
				e.printStackTrace();
				w = null;
			}
			if(w != null) {
				weapon= w;
			}
		}
	}


	public Armor getArmor() {
		return armor;
	}


	public void setArmor(int armorId) {
		if(this.getInventory().checkId(armorId)) {
			Armor a =null;
			try {
				a = (Armor) this.getInventory().getElementById(armorId);
			}catch(Exception e) {
				e.printStackTrace();
				a = null;
			}
			if(a != null) {
				armor= a;
			}
		}
	}
	
	public int getDamage() {
		return weapon.getAttacValue()*this.getLevel().getLevelMultiplier();
	}
	
	public int getDefence() {
		return armor.getDefenceValue() * this.getLevel().getLevelMultiplier();
	}

}
