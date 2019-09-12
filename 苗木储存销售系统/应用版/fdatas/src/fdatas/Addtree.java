package fdatas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.wb.swt.SWTResourceManager;

public class Addtree {

	protected Shell shell;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text_11;
	private Text text_12;
	private Text text_13;
	private Text text_14;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Addtree window = new Addtree();
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
		shell.setText("苗木录入");
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(766, 467, 98, 30);
		button.setText("\u8FD4\u56DE");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(766, 403, 98, 30);
		button_1.setText("\u5F55\u5165");
		
		Group group = new Group(shell, SWT.NONE);
		group.setText("\u82D7\u6728\u4FE1\u606F\u8868");
		group.setBounds(55, 10, 599, 511);
		
		Label label_0 = new Label(group, SWT.NONE);
		label_0.setBounds(33, 42, 30, 20);
		label_0.setText("\u7F16\u53F7");
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setBounds(339, 42, 30, 20);
		label_1.setText("\u65E5\u671F");
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setBounds(33, 99, 60, 20);
		label_2.setText("\u6811\u79CD\u540D\u79F0");
		
		Label label_3 = new Label(group, SWT.NONE);
		label_3.setBounds(33, 162, 30, 20);
		label_3.setText("\u53E3\u5F84");
		
		Label label_4 = new Label(group, SWT.NONE);
		label_4.setBounds(207, 162, 30, 20);
		label_4.setText("\u6570\u91CF");
		
		Label label_5 = new Label(group, SWT.NONE);
		label_5.setBounds(360, 162, 60, 20);
		label_5.setText("\u571F\u7403\u72B6\u51B5");
		
		Label label_6 = new Label(group, SWT.NONE);
		label_6.setBounds(33, 221, 30, 20);
		label_6.setText("\u6765\u6E90");
		
		Label label_7 = new Label(group, SWT.NONE);
		label_7.setBounds(33, 288, 30, 20);
		label_7.setText("\u82D7\u5703");
		
		Label label_8 = new Label(group, SWT.NONE);
		label_8.setBounds(33, 350, 45, 20);
		label_8.setText("\u88C5\u8F66\u4EF7");
		
		Label label_9 = new Label(group, SWT.NONE);
		label_9.setBounds(207, 350, 30, 20);
		label_9.setText("\u8FD0\u8D39");
		
		Label label_10 = new Label(group, SWT.NONE);
		label_10.setBounds(360, 350, 75, 20);
		label_10.setText("\u5378\u8F66\u79CD\u690D\u4EF7");
		
		Label label_11 = new Label(group, SWT.NONE);
		label_11.setBounds(33, 403, 30, 20);
		label_11.setText("\u8FDB\u4EF7");
		
		Label label_12 = new Label(group, SWT.NONE);
		label_12.setBounds(207, 403, 30, 20);
		label_12.setText("\u552E\u4EF7");
		
		Label label_13 = new Label(group, SWT.NONE);
		label_13.setBounds(33, 456, 30, 20);
		label_13.setText("\u56FE\u7247");
		
		Label label_14 = new Label(group, SWT.NONE);
		label_14.setBounds(207, 456, 30, 20);
		label_14.setText("\u5907\u6CE8");
		
		text_1 = new Text(group, SWT.BORDER);
		text_1.setBounds(69, 42, 193, 26);
		
		text_2 = new Text(group, SWT.BORDER);
		text_2.setBounds(99, 99, 138, 26);
		
		text_3 = new Text(group, SWT.BORDER);
		text_3.setBounds(69, 162, 88, 26);
		
		text_4 = new Text(group, SWT.BORDER);
		text_4.setBounds(243, 162, 73, 26);
		
		text_5 = new Text(group, SWT.BORDER);
		text_5.setBounds(426, 162, 73, 26);
		
		text_6 = new Text(group, SWT.BORDER);
		text_6.setBounds(69, 221, 138, 26);
		
		text_7 = new Text(group, SWT.BORDER);
		text_7.setBounds(69, 288, 138, 26);
		
		text_8 = new Text(group, SWT.BORDER);
		text_8.setBounds(84, 350, 88, 26);
		
		text_9 = new Text(group, SWT.BORDER);
		text_9.setBounds(243, 350, 88, 26);
		
		text_10 = new Text(group, SWT.BORDER);
		text_10.setBounds(441, 350, 88, 26);
		
		text_11 = new Text(group, SWT.BORDER);
		text_11.setBounds(69, 403, 88, 26);
		
		text_12 = new Text(group, SWT.BORDER);
		text_12.setBounds(243, 403, 88, 26);
		
		text_13 = new Text(group, SWT.BORDER);
		text_13.setBounds(69, 456, 103, 26);
		
		text_14 = new Text(group, SWT.BORDER);
		text_14.setBounds(243, 456, 325, 26);
		
		DateTime dateTime = new DateTime(group, SWT.BORDER);
		dateTime.setBounds(375, 40, 143, 28);
		
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				Store register=new Store();
				shell.close();
				register.open();
			}
		});
		
		button_1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				
				if(text_1.getText()==""||text_2.getText()==""||text_4.getText()==""){
					final Display display = Display.getDefault();
			        final Shell shell = new Shell();
			        shell.setSize(327, 253);
					MessageBox messageBox = new MessageBox(shell);
					messageBox.setMessage("编号、树种和数量不能为空！");
			        messageBox.open();
			        shell.dispose();
			        while (!shell.isDisposed()){
			        	if (!display.readAndDispatch()){
			        		display.sleep();
			        	}
			        }
				}else {//开始录入
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
					}catch(Exception e){
						e.printStackTrace();
					}
					
					try{
						Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytree?useSSL=false&serverTimezone=UTC","root","001215");
						//连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
						
						int iday=dateTime.getDay();
						int imonth=dateTime.getMonth()+1;
						int iyear=dateTime.getYear();
						String day,month,year;
						if(iday<10) {
							day = "0"+iday;
						}else{
							day = ""+iday;
						}
						if(imonth<10) {
							month = "0"+imonth;
						}else{
							month = ""+imonth;
						}
						year = ""+iyear;
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date u_date=new java.util.Date();
						u_date = df.parse(year+"-"+month+"-"+day);
						java.sql.Date s_date=new java.sql.Date(u_date.getTime());

						String treeID=text_1.getText();//苗木编号
						String tree=text_2.getText();//苗木名称
						int size=Integer.parseInt(text_3.getText());
						int num=Integer.parseInt(text_4.getText());
						String tree_soil=text_5.getText();
						String source=text_6.getText();
						String field=text_7.getText();
						int on_truck=Integer.parseInt(text_8.getText());
						int transport=Integer.parseInt(text_9.getText());
						int off_truck=Integer.parseInt(text_10.getText());
						int cost_price=Integer.parseInt(text_11.getText());
						int sale_price=Integer.parseInt(text_12.getText());
						String img=text_13.getText();
						String note=text_14.getText();
						
						String sql ="" +
								"insert into store " +
								"(treeID,date,tree,size,num,tree_soil,source,field," +
								"on_truck,transport,off_truck,cost_price,sale_price,img,note) " +
								"values(" +
								"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						java.sql.PreparedStatement ptmt = connect.prepareStatement(sql);
						ptmt.setString(1, treeID);
						ptmt.setDate(2, s_date);
						ptmt.setString(3, tree);
						ptmt.setInt(4, size);
						ptmt.setInt(5, num);
						ptmt.setString(6, tree_soil);
						ptmt.setString(7, source);
						ptmt.setString(8, field);
						ptmt.setInt(9, on_truck);
						ptmt.setInt(10, transport);
						ptmt.setInt(11, off_truck);
						ptmt.setInt(12, cost_price);
						ptmt.setInt(13, sale_price);
						ptmt.setString(14, img);
						ptmt.setString(15, note);
						ptmt.execute();
						
						String sql1 ="" +
								"insert into earning " +
								"(date,pay,`get`) " +
								"values(" +
								"?,?,0)";
						java.sql.PreparedStatement ptmt1 = connect.prepareStatement(sql1);
						ptmt1.setDate(1, s_date);
						ptmt1.setInt(2, cost_price*num+on_truck+transport+off_truck);
						ptmt1.execute();
						
						MessageBox messageBox = new MessageBox(shell,SWT.OK);
						messageBox.setMessage("录入成功！");
				        messageBox.open();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		});

	}
}
