package fdatas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class Login {

	protected Shell shell;
	private Text text_1;
	private Text text_2;
	public static String Id;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Login window = new Login();
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
		shell.setSize(600, 400);
		shell.setText("苗木销售管理系统");
		
		Image image=new Image(display,"./img/login_background.jpg");
		shell.setBackgroundImage(image);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(94, 52, 406, 33);
		label.setText("\u6B22\u8FCE\u4F7F\u7528\u82D7\u6728\u9500\u552E\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font(display,"宋体",20,SWT.NORMAL));
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(174, 119, 45, 20);
		label_1.setText("\u7528\u6237\u540D");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(174, 171, 30, 20);
		label_2.setText("\u5BC6\u7801");
		
		text_1 = new Text(shell, SWT.PASSWORD);
		text_1.setBounds(256, 116, 151, 26);
		
		text_2 = new Text(shell, SWT.PASSWORD);
		text_2.setBounds(256, 168, 151, 26);
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(236, 233, 98, 30);
		button.setText("\u767B\u5F55");
		
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				
				Id = text_1.getText();
				if(text_1.getText()==""||text_2.getText()==""){
					final Display display = Display.getDefault();
			        final Shell shell = new Shell();
			        shell.setSize(327, 253);
					MessageBox messageBox = new MessageBox(shell);
					messageBox.setMessage("账号和密码不能为空！!");
			        messageBox.open();
			        shell.dispose();
			        while (!shell.isDisposed()){
			        	if (!display.readAndDispatch()){
			        		display.sleep();
			        	}
			        }
			        //display.dispose();
				}else {
					
					String user=text_1.getText();//账号
					String pass=text_2.getText();//密码
					if(!user.equals("my")||!pass.equals("123456")){//说明账号密码错误
						final Display display = Display.getDefault();
				        final Shell shell = new Shell();
				        shell.setSize(327, 253);
						MessageBox messageBox = new MessageBox(shell);
						messageBox.setMessage("账号或者密码错误!!");
				        messageBox.open();
				        shell.dispose();
				        while (!shell.isDisposed()){
				        	if (!display.readAndDispatch()){
				        		display.sleep();
				        	}
				        }
					}else {
						Menu register=new Menu();
						shell.close();
						register.open();
					}
					
				/*try{
						Class.forName("com.mysql.jdbc.Driver");
					}catch(Exception e){
						e.printStackTrace();
					}*/
				}
				/*Menu register=new Menu();
				shell.close();
				register.open();*/
			}
		});	
	}
		
}
