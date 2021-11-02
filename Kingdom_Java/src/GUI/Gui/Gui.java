package GUI.Gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

public abstract class Gui {

	private Shell shell;
	private Display display;
	
	public Gui() {
		createDisplay();
		createShell();
	}
	
	public void createDisplay() {
		display = new Display();
		
	}

	public void createShell() {
		shell = new Shell(display);
		shell.setLayout(new GridLayout(1, true));
		int[] a = getMonitorSizes();
		shell.setBounds(a[0], a[1], a[2], a[3]);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
		lblNewLabel.setText("New Label");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		btnNewButton.setText("New Button");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		btnNewButton_1.setText("New Button");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		btnNewButton_2.setText("New Button");
		
		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		btnNewButton_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		btnNewButton_3.setText("New Button");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblNewLabel_1.setText("New Label");
		
	}
	
	private int[] getMonitorSizes() {
		int[] result = new int[4];
		
		Monitor m = display.getPrimaryMonitor();
		System.out.println(m.getBounds().x);
		System.out.println(m.getBounds().y);
		System.out.println(m.getBounds().width);
		System.out.println(m.getBounds().height);
		result[0]= m.getBounds().x+100;
		result[1]= m.getBounds().y+100;
		result[2]= m.getBounds().width/2+200;
		result[3]= m.getBounds().height/2+200;
		
		return result;
	}
	
	public void open() {
		
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
