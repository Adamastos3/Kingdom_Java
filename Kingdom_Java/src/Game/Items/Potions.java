package Game.Items;

import Datenbank.Models.PotionsCategory;

public class Potions extends Item{
	private final int defaultEffectiveness=10;
	private int effectiveness = defaultEffectiveness;
	private PotionsCategory category;
	
	public Potions(int id, String name, int price, int effectiveness, PotionsCategory category) {
		super(id, name, price);
		setEffectiveness(effectiveness);
		setCategory(category);
	}

	public int getEffectiveness() {
		return effectiveness;
	}

	private void setEffectiveness(int effectiveness) {
		if(effectiveness >0)
		this.effectiveness = effectiveness;
	}

	public PotionsCategory getCategory() {
		return category;
	}

	private void setCategory(PotionsCategory category) {
		this.category = category;
	}
	
	

}
