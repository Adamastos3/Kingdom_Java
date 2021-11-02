package GUI.Listener;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Shell;

public class SelectionAdapterLanguage extends SelectionAdapter {

	private Shell shell;
	private Combo comboText;
	private HashMap<String, String> language;
	private ResourceBundle message;

	public SelectionAdapterLanguage(Shell shell, Combo comboText, HashMap<String, String> language,
			ResourceBundle message) {
		this.shell=shell;
		this.comboText = comboText;
		this.language = language;
		this.message = message;
	}

	public void widgetSelected(SelectionEvent e) {

		System.out.println(comboText.getText());
		System.out.println(language.get("Englisch"));
		String[] languageString = language.get(comboText.getText()).split("/");
		System.out.println(languageString);
		String lang = languageString[0];
		System.out.println(lang);
		String code = languageString[1];
		System.out.println(code);
		
		Locale currendLocale = new Locale(lang, code);
		message = ResourceBundle.getBundle("MessageBundle", currendLocale);
		if(message != null) {
			System.out.println("message nicht null");
			System.out.println(message.getString("title"));
		}
		shell.dispose();
	}
}
