package Game.Creature;

public class Level {

	private final int defaultLevel=1;
	
	private int level;
	
	
	public Level(int level) {
		setLevel(level);
	}
	
	

	public int getLevel() {
		return level;
	}

	private void setLevel(int level) {
		if(level >0) {
			this.level = level;
		}else{
			this.level=defaultLevel;
		}
	}

	
	public int getLevelMultiplier() {
		return (int) ((int) level*0.5);
	}	
}
