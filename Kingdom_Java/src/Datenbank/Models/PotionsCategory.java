package Datenbank.Models;

public class PotionsCategory {

	private String description;
	private int id;
	public PotionsCategory(int id,String description) {
		this.description = description;
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
