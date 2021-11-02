package Game.Allgemein;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reader {
	
	//Fehlt noch
	private final String defaultText="";
	
	public Map<String, String> readFile(String filename) {
		Map<String, String> result = new HashMap<String, String>();
		File file = new File(filename);

        if (!file.canRead() || !file.isFile()) {
        	file = new File(this.defaultText);
        }
            

            BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filename));
            String zeile = null;
            while ((zeile = in.readLine()) != null) {
                String[] elem=zeile.split(":");
                if(elem.length ==2) {
                	result.put(elem[0], elem[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (Exception e) {
                }
        } 
		
		
		return result;
	}
	
	public ArrayList<String> readLanguages(String filename) {
		ArrayList<String> result= new ArrayList<String>();
		
		BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filename));
            String zeile = null;
            while ((zeile = in.readLine()) != null) {
                result.add(zeile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (Exception e) {
                }
        } 
		
		return result;
	}

}
