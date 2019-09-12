package fdatas;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.wb.swt.SWTResourceManager;

public class Menu {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Menu window = new Menu();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents(display);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(Display display) {
		shell = new Shell();
		shell.setSize(800, 600);
		shell.setText("苗木销售管理系统菜单");
		Image image=new Image(display,"./img/menu_background.jpg");
		shell.setBackgroundImage(image);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(66, 182, 160, 80);
		button_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		button_1.setText("\u82D7\u6728\u4FE1\u606F(\u5165\u5E93\u767B\u8BB0)");
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.setBounds(241, 286, 160, 80);
		button_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		button_2.setText("\u4E70\u5BB6\u4FE1\u606F(\u767B\u8BB0)");
		
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.setBounds(241, 182, 160, 80);
		button_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		button_3.setText("\u9500\u552E(\u67E5\u8BE2\u8BB0\u5F55)");
		
		Button button_4 = new Button(shell, SWT.NONE);
		button_4.setBounds(66, 286, 160, 80);
		button_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		button_4.setText("\u6536\u76CA(\u67E5\u8BE2\u8BB0\u5F55)");
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(241, 401, 100, 30);
		button.setText("\u9000\u51FA\u7CFB\u7EDF");
		
		Label label = new Label(shell, SWT.NONE|SWT.CENTER);
		label.setBounds(228, 34, 400, 33);
		label.setText("\u6B22\u8FCE\u6765\u5230\u82D7\u6728\u9500\u552E\u7CFB\u7EDF");
		label.setFont(new Font(display,"宋体",20,SWT.NORMAL));
		
		button_1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				Store register=new Store();
				shell.close();
				register.open();
			}
		});
		
		button_2.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				Buyers register=new Buyers();
				shell.close();
				register.open();
			}
		});
		
		button_3.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				Sale register=new Sale();
				shell.close();
				register.open();
			}
		});
		
		button_4.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				Earn register=new Earn();
				shell.close();
				register.open();
			}
		});
		
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				Login register=new Login();
				shell.close();
				register.open();
			}
		});
	}
}
