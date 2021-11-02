package Game.Creature;

import Game.Items.Armor;
import Game.Items.Inventory;
import Game.Items.Weapon;

public class User extends Human {

	 public User(String name, int hp, int stamina, int level, int vitality,int strength, int persistance, int martialArts, int defence, Inventory inventory, int weaponId, int armorId) {
		super(name, hp, stamina,new LevelPlayer(level,vitality, strength,persistance,martialArts, defence) , inventory, weaponId, armorId);
		setMaxHp(hp);
		setMaxStamina(stamina);
	}
	
	@Override
	public LevelPlayer getLevel() {
		return (LevelPlayer) super.getLevel();
	}
	
	
	@Override
	public void setHp(int hp) {
		LevelPlayer tmp = getLevel();
		int result = hp;
		for(int i=0; i< tmp.getVitality(); i++) {
			result+= result*0.25;
		}
		super.setHp((int)result);
	}
	
	@Override
	public void setMaxHp() {
		LevelPlayer tmp = getLevel();
		int result = this.getHp();
		for(int i=0; i< tmp.getVitality(); i++) {
			result+= result*0.25;
		}
		super.setMaxHp();
	}
	
	
	@Override
	public void setMaxStamina( ) {
		LevelPlayer tmp = getLevel();
		int result= getStamina();
		for(int i=0; i< tmp.getPersistance(); i++) {
			result+= result*0.25;
		}
		super.setStamina((int) result);
	}
	

	@Override
	public int getDamage() {
		LevelPlayer level= (LevelPlayer) this.getLevel();
		Weapon weapon= this.getWeapon();
		int multiplier = (int) (level.getStrength()*0.5+level.getMartialArts()*0.5);
		int damage= weapon.getAttacValue()*multiplier;
		if(this.noStamina()) {
			return damage/2;
		}else {
			this.makeAction(weapon.getEnduranceConsumption());
			return damage;
		}
		
		
	}
	
	@Override
	public int getDefence() {
		LevelPlayer level= (LevelPlayer) this.getLevel();
		Armor armor= this.getArmor();
		int multiplier = (int) (level.getStrength()*0.5+level.getDefence()*0.5);
		return armor.getDefenceValue()*multiplier;
	}
	
}
