package GUI.Dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class InventoryDialog extends Dialog {

	private int result;
	private Table table;
	private Text text;
	public InventoryDialog(Shell parent) {
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
		
		Label lblNewLabel = new Label(shellDialog, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblNewLabel.setText("New Label");
		
		table = new Table(shellDialog, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		table.setBounds(0, 0, 11, 12);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("New Column");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("New Column");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("New Column");
		
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText("Test");
		
		Label lblNewLabel_1 = new Label(shellDialog, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblNewLabel_1.setText("New Label");
		
		text = new Text(shellDialog, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		Button btnNewButton = new Button(shellDialog, SWT.NONE);
		btnNewButton.setText("New Button");
		
		Button btnNewButton_1 = new Button(shellDialog, SWT.NONE);
		btnNewButton_1.setText("New Button");
		
		Button btnNewButton_2 = new Button(shellDialog, SWT.NONE);
		btnNewButton_2.setText("New Button");
		
		
		
		
		
		return shellDialog;
	}
}
