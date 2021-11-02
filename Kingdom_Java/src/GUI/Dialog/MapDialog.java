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

public class MapDialog extends Dialog {

	private int result;
	public MapDialog(Shell parent) {
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
		shellDialog.setLayout(new GridLayout(1, false));
		
		Label lblNewLabel = new Label(shellDialog, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		lblNewLabel.setText("New Label");
		
		Group group = new Group(shellDialog, SWT.NONE);
		group.setBounds(0, 0, 66, 66);
		group.setLayout(new GridLayout(4, false));
		
		Label lblNewLabel_1 = new Label(group, SWT.NONE);
		lblNewLabel_1.setBounds(0, 0, 63, 19);
		lblNewLabel_1.setText("New Label");
		
		Label lblNewLabel_2 = new Label(group, SWT.NONE);
		lblNewLabel_2.setText("New Label");
		
		Label lblNewLabel_3 = new Label(group, SWT.NONE);
		lblNewLabel_3.setText("New Label");
		new Label(group, SWT.NONE);
		
		Label lblNewLabel_4 = new Label(group, SWT.NONE);
		lblNewLabel_4.setText("New Label");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Button btnNewButton = new Button(shellDialog, SWT.NONE);
		btnNewButton.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, true, 1, 1));
		btnNewButton.setText("New Button");
	
		
		
		return shellDialog;
	}
}
