package GUI.Dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class GameDialog extends Dialog {

	private int result;
	public GameDialog(Shell parent) {
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
		shellDialog.setSize(489, 323);
		shellDialog.setBounds(getParent().getBounds());
		shellDialog.setLayout(new GridLayout(6, true));
		
		Button btnNewButton_3 = new Button(shellDialog, SWT.NONE);
		btnNewButton_3.setText("New Button");
		new Label(shellDialog, SWT.NONE);
		
		Button btnNewButton_5 = new Button(shellDialog, SWT.NONE);
		btnNewButton_5.setText("New Button");
		new Label(shellDialog, SWT.NONE);
		
		Button btnNewButton_7 = new Button(shellDialog, SWT.NONE);
		btnNewButton_7.setText("New Button");
		new Label(shellDialog, SWT.NONE);
		
		Label lblNewLabel_2 = new Label(shellDialog, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblNewLabel_2.setText("New Label");
		
		Label lblNewLabel_6 = new Label(shellDialog, SWT.NONE);
		lblNewLabel_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_6.setText("New Label");
		
		Label lblNewLabel_1 = new Label(shellDialog, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 2, 1));
		lblNewLabel_1.setText("New Label");
		
		Label lblNewLabel = new Label(shellDialog, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblNewLabel.setText("New Label");
		
		Label lblNewLabel_5 = new Label(shellDialog, SWT.NONE);
		lblNewLabel_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_5.setText("New Label");
		
		
		
		
		Label lblNewLabel_3 = new Label(shellDialog, SWT.WRAP);
		lblNewLabel_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 6, 1));
		lblNewLabel_3.setText("New Label");
		
		Button btnNewButton = new Button(shellDialog, SWT.NONE);
		btnNewButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 6, 1));
		btnNewButton.setText("New Button");
		
		Button btnNewButton_1 = new Button(shellDialog, SWT.NONE);
		btnNewButton_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 6, 1));
		btnNewButton_1.setText("New Button");
		
		Button btnNewButton_2 = new Button(shellDialog, SWT.NONE);
		btnNewButton_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 6, 1));
		btnNewButton_2.setText("New Button");
		
		Label lblNewLabel_4 = new Label(shellDialog, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 6, 1));
		lblNewLabel_4.setText("New Label");
		
		
		
		return shellDialog;
		
		
	}
}
