package Game.Allgemein;

import java.util.ArrayList;

public class Sprachenmanager {

	private final String defaultLanguageFile="";
	private ArrayList<String> languages;
	
	public Sprachenmanager(String filename) {
		initManager(filename);
	}
	
	public Sprachenmanager() {
		initManager(defaultLanguageFile);
	}

	private void initManager(String filename) {
		Reader reader= new Reader();
		languages= reader.readLanguages(defaultLanguageFile);
	}
	
	public ArrayList<String> getLanguages() {
		return languages;
	}

	public void setLanguages(ArrayList<String> languages) {
		this.languages = languages;
	}
	
	
}
