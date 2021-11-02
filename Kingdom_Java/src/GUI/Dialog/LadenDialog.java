package GUI.Dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class LadenDialog extends Dialog {

	private int result;
	public LadenDialog(Shell parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}
	
	public int open() {
		Shell shellDialog=createDisplayGui();
		Display d = shellDialog.getDisplay();
		
		
		shellDialog.pack();
		shellDialog.open();
		
		while(!shellDialog.isDisposed()) {
			if(!d.readAndDispatch()) {
				d.sleep();
			}
		}
		
		return  result;
	}
	
	private Shell createDisplayGui() {

		Shell shellDialog= new Shell(getParent());
		shellDialog.setLayout(new GridLayout(3, false));
		
		Button btnNewButton_3 = new Button(shellDialog, SWT.NONE);
		btnNewButton_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		btnNewButton_3.setText("New Button");
		
		Label lblNewLabel = new Label(shellDialog, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 3, 1));
		lblNewLabel.setText("New Label");
		
		Button btnRadioButton = new Button(shellDialog, SWT.RADIO);
		btnRadioButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		btnRadioButton.setText("Radio Button");
		
		Button btnNewButton = new Button(shellDialog, SWT.NONE);
		btnNewButton.setText("New Button");
		
		Button btnNewButton_1 = new Button(shellDialog, SWT.NONE);
		btnNewButton_1.setText("New Button");
		
		Button btnNewButton_2 = new Button(shellDialog, SWT.NONE);
		btnNewButton_2.setText("New Button");
		
		
		
		return shellDialog;
	}
}
