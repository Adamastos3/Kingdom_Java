package Game.Creature;

import java.util.HashMap;

public class LevelPlayer extends Level {
	private final static int defaultVitality = 0;
	private final static int defaultStrength = 0;
	private final static int defaultPersistance = 0;
	private final static int defaultMartialArts = 0;
	private final static int defaultdefence = 0;

	private HashMap<String, Integer> attributes;

	public LevelPlayer(int level, int vitality, int strength, int persistance, int martialArts, int defence) {
		super(level);
		setAttributes(vitality, strength, persistance, martialArts, defence);
	}

	public HashMap<String, Integer> getAttributes() {
		return attributes;
	}

	private void setAttributes(int vitality, int strength, int persistance, int martialArts, int defence) {
		if (vitality >= 0) {
			attributes.put("vitality", vitality);
		} else {
			attributes.put("vitalityh", defaultVitality);
		}
		if (strength >= 0) {
			attributes.put("strength", strength);
		} else {
			attributes.put("strength", defaultStrength);
		}
		if (persistance >= 0) {
			attributes.put("persistance", persistance);
		} else {
			attributes.put("persistance", defaultPersistance);
		}
		if (martialArts >= 0) {
			attributes.put("martial arts", martialArts);
		} else {
			attributes.put("martial arts", defaultMartialArts);
		}
		if (defence >= 0) {
			attributes.put("defence", defence);
		} else {
			attributes.put("defence", defaultdefence);
		}

	}

	public int getVitality() {
		return attributes.get("vitality");
	}

	public int getStrength() {
		return attributes.get("strength");
	}

	public int getPersistance() {
		return attributes.get("persistance");
	}

	public int getMartialArts() {
		return attributes.get("martial arts");
	}

	public int getDefence() {
		return attributes.get("defence");
	}

	public void setVitality(int value) {
		if (value > attributes.get("vitality")) {
			attributes.replace("vitality", value);
		}
	}

	public void setStrenght(int value) {
		if (value > attributes.get("strength")) {
			attributes.replace("strength", value);
		}
	}

	public void setPersistance(int value) {
		if (value > attributes.get("persistance")) {
			attributes.replace("persistance", value);
		}
	}

	public void setMartialArts(int value) {
		if (value > attributes.get("martial arts")) {
			attributes.replace("martial arts", value);
		}
	}

	public void setDefence(int value) {
		if (value > attributes.get("defence")) {
			attributes.replace("defence", value);
		}
	}
}
