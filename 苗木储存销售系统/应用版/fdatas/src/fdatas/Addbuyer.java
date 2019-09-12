package fdatas;

import java.sql.Connection;
import java.sql.DriverManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class Addbuyer {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Addbuyer window = new Addbuyer();
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
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		shell.setSize(1000, 600);
		shell.setText("��ҵǼ�");
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(766, 467, 98, 30);
		button.setText("\u8FD4\u56DE");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(766, 403, 98, 30);
		button_1.setText("\u5F55\u5165");
		
		Group group = new Group(shell, SWT.NONE);
		group.setText("\u82D7\u6728\u4FE1\u606F\u8868");
		group.setBounds(55, 10, 599, 511);
		
		Label label = new Label(group, SWT.NONE);
		label.setBounds(114, 90, 30, 20);
		label.setText("\u7F16\u53F7");
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setBounds(114, 161, 30, 20);
		label_1.setText("\u59D3\u540D");
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setBounds(114, 243, 30, 20);
		label_2.setText("\u516C\u53F8");
		
		Label label_3 = new Label(group, SWT.NONE);
		label_3.setBounds(114, 326, 60, 20);
		label_3.setText("\u7535\u8BDD\u53F7\u7801");
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(150, 90, 103, 26);
		
		text_1 = new Text(group, SWT.BORDER);
		text_1.setBounds(150, 161, 103, 26);
		
		text_2 = new Text(group, SWT.BORDER);
		text_2.setBounds(150, 243, 213, 26);
		
		text_3 = new Text(group, SWT.BORDER);
		text_3.setBounds(180, 326, 183, 26);
		
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				Buyers register=new Buyers();
				shell.close();
				register.open();
			}
		});
		
		button_1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				
				if(text.getText()==""||text_1.getText()==""||text_3.getText()==""){
					final Display display = Display.getDefault();
			        final Shell shell = new Shell();
			        shell.setSize(327, 253);
					MessageBox messageBox = new MessageBox(shell);
					messageBox.setMessage("��š������ͺ��벻��Ϊ�գ�");
			        messageBox.open();
			        shell.dispose();
			        while (!shell.isDisposed()){
			        	if (!display.readAndDispatch()){
			        		display.sleep();
			        	}
			        }
				}else {//��ʼ¼��
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
					}catch(Exception e){
						e.printStackTrace();
					}
					
					try{
						Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytree?useSSL=false&serverTimezone=UTC","root","001215");
						//����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������

						String buyerID=text.getText();
						String buyername=text_1.getText();
						String company=text_2.getText();
						String phone=text_3.getText();
						
						String sql ="" +
								"insert into buyer " +
								"(buyerID,buyername,company,phone) " +
								"values(?,?,?,?)";
						java.sql.PreparedStatement ptmt = connect.prepareStatement(sql);
						ptmt.setString(1, buyerID);
						ptmt.setString(2, buyername);
						ptmt.setString(3, company);
						ptmt.setString(4, phone);
						ptmt.execute();
						
						MessageBox messageBox = new MessageBox(shell,SWT.OK);
						messageBox.setMessage("¼��ɹ���");
				        messageBox.open();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		});

	}
}
