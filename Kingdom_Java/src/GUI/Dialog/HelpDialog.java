package GUI.Dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;

public class HelpDialog extends Dialog {
	private int result;
	public HelpDialog(Shell parent) {
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
		shellDialog.setLayout(new GridLayout(1, true));
		
		Group group = new Group(shellDialog, SWT.NONE);
		group.setLayout(new GridLayout(4, false));
		
		Button btnNewButton = new Button(group, SWT.NONE);
		btnNewButton.setText("New Button");
		
		Button btnNewButton_1 = new Button(group, SWT.NONE);
		btnNewButton_1.setText("New Button");
		
		Button btnNewButton_2 = new Button(group, SWT.NONE);
		btnNewButton_2.setText("New Button");
		new Label(group, SWT.NONE);
		
		Group group_1 = new Group(shellDialog, SWT.NONE);
		group_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
		group_1.setBounds(0, 0, 66, 66);
		group_1.setLayout(new GridLayout(3, false));
		
		Label lblNewLabel = new Label(group_1, SWT.WRAP);
		lblNewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 3, 1));
		lblNewLabel.setText("New Label");
		
		Button btnNewButton_3 = new Button(shellDialog, SWT.NONE);
		btnNewButton_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true, 1, 1));
		btnNewButton_3.setBounds(0, 0, 91, 34);
		btnNewButton_3.setText("New Button");
		
		
		return shellDialog;
	}
}
