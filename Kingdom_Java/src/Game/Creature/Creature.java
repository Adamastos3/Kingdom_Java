package Game.Creature;

import Game.Items.Inventory;

public abstract class Creature {

	private final int defaultHp = 100;
	private final int defaultStamina=100;
	private final double regenarationRate= 0.1;

	private Level level;
	private int hp = defaultHp;
	private int maxHp;
	private int maxStamina;
	private int stamina= defaultStamina;
	private String name;
	private Inventory inventory;

	public Creature(String name, int hp, int stamina, Level level, Inventory inventory) {
		setLevel(level);
		setHp(hp);
		setStamina(stamina);
		setName(name);
		setInventory(inventory);
		setMaxHp();
		setMaxStamina();
	}

	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name!= null) {
			this.name=name;
		}
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	private void setInventory(Inventory inventory) {
		this.inventory=inventory;
	}
	
	public Level getLevel() {
		return level;
	}

	private void setLevel(Level level) {
		this.level=level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		if (hp > 0) {
			this.hp = hp;
		}
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		if (stamina > 0) {
			this.stamina = stamina;
		}
	}

	public int getMaxHp() {
		return maxHp;
	}


	public void setMaxHp() {
		this.maxHp = hp;
	}
	
	public void setMaxHp(int value) {
		this.maxHp = value;
	}


	public int getMaxStamina() {
		return maxStamina;
	}


	public void setMaxStamina() {
		this.maxStamina = hp;
	}
	public void setMaxStamina(int value) {
		this.maxStamina = value;
	}
	
	public void addDamage(int damage) {
		if (damage >0) {
			this.hp=this.hp - damage;	
		}
	}
	
	public void makeAction(int stamina) {
		if(stamina >0) {
			this.stamina = this.stamina -stamina;
		}
		
		if(this.stamina < 0) {
			this.stamina=0;
		}
	}
	
	public void regenerateHp() {
		if(hp != maxHp) {
			hp+= hp*regenarationRate;
		}
	}
	
	public void regenerateStamina() {
		if(stamina != maxStamina) {
			stamina+= stamina*regenarationRate;
		}
	}
	
	public boolean isDead() {
		if(hp <=0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean noStamina() {
		if(stamina <=0) {
			return true;
		}else {
			return false;
		}
	}
	

}
