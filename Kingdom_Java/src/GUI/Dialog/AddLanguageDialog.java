package GUI.Dialog;

import java.util.HashMap;
import java.util.ResourceBundle;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import GUI.Listener.SelectionAdapterLanguage;

public class AddLanguageDialog extends Dialog {
	
	private ResourceBundle message;
	private HashMap<String,String> language;
	private static final int defaultStyle = SWT.APPLICATION_MODAL;
	private Combo comboBox;

	public AddLanguageDialog(Shell parent, int style, HashMap<String,String> language ) {
		super(parent, style);
		this.language=language;
	}
	
	public AddLanguageDialog(Shell parent, HashMap<String,String> language ) {
		super(parent, defaultStyle);
		this.language=language;
	}
	
	public ResourceBundle open() {
		Shell shellDialog= new Shell(getParent());
		shellDialog.setMaximumSize(250, 30);
		shellDialog.setMinimumSize(250, 30);
		Display d = getParent().getDisplay();
		createDisplayGui(shellDialog);
		shellDialog.pack();
		shellDialog.open();
		while(!shellDialog.isDisposed()) {
			if(!d.readAndDispatch()) {
				d.sleep();
			}
		}
		
		return  message;
	}
	
	private void createDisplayGui(Shell shell) {
		
		shell.setLayout(new GridLayout(1, true));
		createLabel(shell);
		createComboBox(shell);
		createButton(shell);
		
		
}
	
	private void createLabel(Shell shell) {
		//GridData data = new GridData(SWT.FILL, SWT.FILL,true, true, 1,1);
		Label label = new Label(shell, SWT.LEFT);
		label.setFont(new Font(shell.getDisplay(), "Arial", 18, SWT.BOLD));
		//label.setLayoutData(data);
		label.setText("Choose a Language");

	}
	
	private void createComboBox(Shell shell) {
		//GridData gData = new GridData(SWT.FILL, SWT.FILL, true,true,1,1);
		comboBox= new Combo(shell, SWT.DROP_DOWN);
		comboBox.setFont(new Font(shell.getDisplay(), "Arial", 12, SWT.BOLD));
		//comboBox.setLayoutData(gData);
		
		String[] tmp = new String[language.keySet().size()];
		int tmpNumber=0;
		for(String i: language.keySet()) {
			tmp[tmpNumber]=i;
		tmpNumber++;
		}
		comboBox.setItems(tmp);

	}
	
	private void createButton(Shell shell) {
		//GridData gData = new GridData(SWT.FILL, SWT.FILL, true,true,1,1);
		Button button = new Button(shell, SWT.PUSH);
		//button.setLayoutData(gData);
		button.setText("OK");
		button.addSelectionListener(new SelectionAdapterLanguage(shell, comboBox, language, message));
	}
	
}

