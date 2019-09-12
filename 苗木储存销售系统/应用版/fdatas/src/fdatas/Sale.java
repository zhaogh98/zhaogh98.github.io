package fdatas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class Sale {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Table table_1;
	private Table table_2;
	private int treeflag = 0;
	private int buyerflag = 0;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Sale window = new Sale();
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
		shell.setText("销售记录");
		//shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(800,450,150,60 );
		button.setText("\u8FD4\u56DE\u83DC\u5355");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(800, 268, 98, 30);
		button_1.setText("\u51FA\u552E");
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.setBounds(800, 341, 98, 30);
		button_2.setText("\u9500\u552E\u8BB0\u5F55\u67E5\u8BE2");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(684, 62, 60, 20);
		label.setText("\u82D7\u6728\u7F16\u53F7");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(684, 106, 60, 20);
		label_1.setText("\u91C7\u8D2D\u6570\u91CF");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(684, 150, 60, 20);
		label_2.setText("\u4E70\u5BB6\u7F16\u53F7");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(684, 203, 60, 20);
		label_3.setText("\u552E\u51FA\u65E5\u671F");
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(750, 203, 122, 28);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(750, 62, 73, 26);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(750, 106, 73, 26);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(750, 150, 73, 26);
		
		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(43, 47, 606, 279);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tableColumn_0 = new TableColumn(table_1, SWT.NONE);
		tableColumn_0.setWidth(54);
		tableColumn_0.setText("\u7F16\u53F7");
		
		TableColumn tableColumn_1 = new TableColumn(table_1, SWT.NONE);
		tableColumn_1.setWidth(76);
		tableColumn_1.setText("\u65E5\u671F");
		
		TableColumn tableColumn_2 = new TableColumn(table_1, SWT.NONE);
		tableColumn_2.setWidth(71);
		tableColumn_2.setText("\u6811\u79CD");
		
		TableColumn tableColumn_3 = new TableColumn(table_1, SWT.NONE);
		tableColumn_3.setWidth(60);
		tableColumn_3.setText("\u578B\u53F7");
		
		TableColumn tableColumn_4 = new TableColumn(table_1, SWT.NONE);
		tableColumn_4.setWidth(60);
		tableColumn_4.setText("\u6570\u91CF");
		
		TableColumn tableColumn_5 = new TableColumn(table_1, SWT.NONE);
		tableColumn_5.setWidth(79);
		tableColumn_5.setText("\u571F\u7403\u72B6\u51B5");
		
		TableColumn tableColumn_6 = new TableColumn(table_1, SWT.NONE);
		tableColumn_6.setWidth(74);
		tableColumn_6.setText("\u6765\u6E90");
		
		TableColumn tableColumn_7 = new TableColumn(table_1, SWT.NONE);
		tableColumn_7.setWidth(74);
		tableColumn_7.setText("\u82D7\u5703");
		
		TableColumn tableColumn_8 = new TableColumn(table_1, SWT.NONE);
		tableColumn_8.setWidth(80);
		tableColumn_8.setText("\u88C5\u8F66\u4EF7");
		
		TableColumn tableColumn_9 = new TableColumn(table_1, SWT.NONE);
		tableColumn_9.setWidth(80);
		tableColumn_9.setText("\u8FD0\u8D39");
		
		TableColumn tableColumn_10 = new TableColumn(table_1, SWT.NONE);
		tableColumn_10.setWidth(80);
		tableColumn_10.setText("\u5378\u8F66\u4EF7");
		
		TableColumn tableColumn_11 = new TableColumn(table_1, SWT.NONE);
		tableColumn_11.setWidth(80);
		tableColumn_11.setText("\u8FDB\u4EF7");
		
		TableColumn tableColumn_12 = new TableColumn(table_1, SWT.NONE);
		tableColumn_12.setWidth(80);
		tableColumn_12.setText("\u552E\u4EF7");
		
		TableColumn tableColumn_13 = new TableColumn(table_1, SWT.NONE);
		tableColumn_13.setWidth(120);
		tableColumn_13.setText("\u56FE\u7247");
		
		TableColumn tableColumn_14 = new TableColumn(table_1, SWT.NONE);
		tableColumn_14.setWidth(249);
		tableColumn_14.setText("\u5907\u6CE8");
		
		table_2 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_2.setBounds(43, 341, 606, 154);
		table_2.setHeaderVisible(true);
		table_2.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table_2, SWT.NONE);
		tableColumn.setWidth(79);
		tableColumn.setText("\u7F16\u53F7");
		
		TableColumn tableColumn_15 = new TableColumn(table_2, SWT.NONE);
		tableColumn_15.setWidth(84);
		tableColumn_15.setText("\u59D3\u540D");
		
		TableColumn tableColumn_16 = new TableColumn(table_2, SWT.NONE);
		tableColumn_16.setWidth(243);
		tableColumn_16.setText("\u516C\u53F8");
		
		TableColumn tableColumn_17 = new TableColumn(table_2, SWT.NONE);
		tableColumn_17.setWidth(165);
		tableColumn_17.setText("\u7535\u8BDD");
		
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.setBounds(829, 62, 98, 30);
		button_3.setText("\u67E5\u8BE2");
		
		Button button_4 = new Button(shell, SWT.NONE);
		button_4.setBounds(829, 150, 98, 30);
		button_4.setText("\u67E5\u8BE2");
		
		button_1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				if(treeflag==0||buyerflag==0){
					final Display display = Display.getDefault();
			        final Shell shell = new Shell();
			        shell.setSize(327, 253);
					MessageBox messageBox = new MessageBox(shell);
					messageBox.setMessage("请先查询！");
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

						String treeID=text.getText();
						int wantnum=Integer.parseInt(text_1.getText());
						String buyerID=text_2.getText();
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
						
						if(wantnum<1) {
							MessageBox messageBox = new MessageBox(shell);
							messageBox.setMessage("请输入售出数量！");
					        messageBox.open();
						}else {
							String sql1 ="" +
									"select tree,size,num,tree_soil,source,field,on_truck,transport,off_truck,cost_price,sale_price from store " +
									"where treeID = ?";
							java.sql.PreparedStatement ptmt1 = connect.prepareStatement(sql1);
							ptmt1.setString(1, treeID);
							ResultSet rs1 = ptmt1.executeQuery();//创建数据对象
							List<Tree> resultTree = new ArrayList<Tree>();
							while(rs1.next()){
								Tree tree = new Tree();
								tree.setdate(s_date);
								tree.settree(rs1.getString("tree"));
								tree.setsize(rs1.getInt("size"));
								tree.setnum(rs1.getInt("num"));
								tree.settree_soil(rs1.getString("tree_soil"));
								tree.setsource(rs1.getString("source"));
								tree.setfield(rs1.getString("field"));
								tree.seton_truck(rs1.getInt("on_truck"));
								tree.settransport(rs1.getInt("transport"));
								tree.setoff_truck(rs1.getInt("off_truck"));
								tree.setcost_price(rs1.getInt("cost_price"));
								tree.setsale_price(rs1.getInt("sale_price"));
								resultTree.add(tree);
							}	
							String sql2 ="" +
									"select buyername,company from buyer " +
									"where buyerID =?";
							java.sql.PreparedStatement ptmt2 = connect.prepareStatement(sql2);
							ptmt2.setString(1, buyerID);
							ResultSet rs2 = ptmt2.executeQuery();//创建数据对象
							List<Buyer> resultBuyer = new ArrayList<Buyer>();
							while(rs2.next()){
								Buyer buyer = new Buyer();
								buyer.setbuyername(rs2.getString("buyername"));
								buyer.setcompany(rs2.getString("company"));
								resultBuyer.add(buyer);
							}
							if(wantnum>resultTree.get(0).getnum()) {
								MessageBox messageBox = new MessageBox(shell);
								messageBox.setMessage("库存数量不足！");
						        messageBox.open();
							}else {
								String sql3 ="" +
										"insert into sale " +
										"(date,buyername,company,tree,size,wantnum," +
										"tree_soil,source,field,out_price) " +
										"values(" +
										"?,?,?,?,?,?,?,?,?,?)";
								java.sql.PreparedStatement ptmt3 = connect.prepareStatement(sql3);
								ptmt3.setDate(1, s_date);
								ptmt3.setString(2, resultBuyer.get(0).getbuyername());
								ptmt3.setString(3, resultBuyer.get(0).getcompany());
								ptmt3.setString(4, resultTree.get(0).gettree());
								ptmt3.setInt(5, resultTree.get(0).getsize());
								ptmt3.setInt(6, wantnum);
								ptmt3.setString(7, resultTree.get(0).gettree_soil());
								ptmt3.setString(8, resultTree.get(0).getsource());
								ptmt3.setString(9, resultTree.get(0).getfield());
								ptmt3.setInt(10, resultTree.get(0).getsale_price()*wantnum);
								ptmt3.execute();
								
								String sql4 ="" +
										"insert into earning " +
										"(date,pay,`get`) " +
										"values(?,?,?)";
								java.sql.PreparedStatement ptmt4 = connect.prepareStatement(sql4);
								ptmt4.setDate(1, s_date);
								ptmt4.setInt(2, 0);
								ptmt4.setInt(3, resultTree.get(0).getsale_price()*wantnum);
								ptmt4.execute();
								
								if(wantnum==resultTree.get(0).getnum()) {
									String sql5 ="delete from store" +
											"where treeID =?";
									java.sql.PreparedStatement ptmt5 = connect.prepareStatement(sql5);
									ptmt5.setString(1, resultTree.get(1).gettreeID());
									ptmt5.execute();
								}else {
									String sql6 ="" +
											"update store " +
											"set num =? " +
											"where treeID =?";
									java.sql.PreparedStatement ptmt6 = connect.prepareStatement(sql6);
									ptmt6.setInt(1, resultTree.get(0).getnum()-wantnum);
									ptmt6.setString(2, treeID);
									ptmt6.execute();
								}
								MessageBox messageBox = new MessageBox(shell);
								messageBox.setMessage("录入成功！");
						        messageBox.open();
						        buyerflag = 1;
							}
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		});
		
		button_2.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				Salemessage register=new Salemessage();
				shell.close();
				register.open();
			}
		});
		
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				Menu register=new Menu();
				shell.close();
				register.open();
			}
		});
		
		button_3.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				if(text.getText()==""){
					final Display display = Display.getDefault();
			        final Shell shell = new Shell();
			        shell.setSize(327, 253);
					MessageBox messageBox = new MessageBox(shell);
					messageBox.setMessage("苗木编号不能为空！");
			        messageBox.open();
			        shell.dispose();
			        while (!shell.isDisposed()){
			        	if (!display.readAndDispatch()){
			        		display.sleep();
			        	}
			        }
			        //display.dispose();
				}else {//开始录入
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
					}catch(Exception e){
						e.printStackTrace();
					}
					
					try{
						Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytree?useSSL=false&serverTimezone=UTC","root","001215");
						//连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

						int treeID=Integer.parseInt(text.getText());
						
						String sql7 ="" +
								"select * from store " +
								"where treeID = ?";
						java.sql.PreparedStatement ptmt7 = connect.prepareStatement(sql7);
						ptmt7.setInt(1, treeID);
						
						ResultSet rs1 = ptmt7.executeQuery();//创建数据对象
						List<Tree> resultTree = new ArrayList<Tree>();
						while(rs1.next()){
							Tree tree = new Tree();
							tree.settreeID(rs1.getString("treeID"));
							tree.setdate(rs1.getDate("date"));
							tree.settree(rs1.getString("tree"));
							tree.setsize(rs1.getInt("size"));
							tree.setnum(rs1.getInt("num"));
							tree.settree_soil(rs1.getString("tree_soil"));
							tree.setsource(rs1.getString("source"));
							tree.setfield(rs1.getString("field"));
							tree.seton_truck(rs1.getInt("on_truck"));
							tree.settransport(rs1.getInt("transport"));
							tree.setoff_truck(rs1.getInt("off_truck"));
							tree.setcost_price(rs1.getInt("cost_price"));
							tree.setsale_price(rs1.getInt("sale_price"));
							tree.setimg(rs1.getString("img"));
							tree.setnote(rs1.getString("note"));
							resultTree.add(tree);
						}
						if(resultTree!=null) {
							table_1.removeAll();
							for(int i = 0 ; i < resultTree.size() ; i++) {
								TableItem item;
								item = new TableItem(table_1,SWT.NONE);
								item.setText(new String[] {
										resultTree.get(i).gettreeID(),
										resultTree.get(i).getdate()+"",
										resultTree.get(i).gettree(),
										resultTree.get(i).getsize()+"",
										resultTree.get(i).getnum()+"",
										resultTree.get(i).gettree_soil(),
										resultTree.get(i).getsource(),
										resultTree.get(i).getfield(),
										resultTree.get(i).geton_truck()+"",
										resultTree.get(i).gettransport()+"",
										resultTree.get(i).getoff_truck()+"",
										resultTree.get(i).getcost_price()+"",
										resultTree.get(i).getsale_price()+"",
										resultTree.get(i).getimg(),
										resultTree.get(i).getnote(),
								});
							}
						}
						treeflag = 1;
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
			}
		});
		
		button_4.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				if(text_2.getText()==""){
					final Display display = Display.getDefault();
			        final Shell shell = new Shell();
			        shell.setSize(327, 253);
					MessageBox messageBox = new MessageBox(shell);
					messageBox.setMessage("买家编号不能为空！");
			        messageBox.open();
			        shell.dispose();
			        while (!shell.isDisposed()){
			        	if (!display.readAndDispatch()){
			        		display.sleep();
			        	}
			        }
			        //display.dispose();
				}else {//开始录入
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
					}catch(Exception e){
						e.printStackTrace();
					}
					
					try{
						Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytree?useSSL=false&serverTimezone=UTC","root","001215");
						//连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

						String buyerID=text_2.getText();
						
						String sql7 ="" +
								"select * from buyer " +
								"where buyerID = ?";
						java.sql.PreparedStatement ptmt7 = connect.prepareStatement(sql7);
						ptmt7.setString(1, buyerID);
						
						ResultSet rs2 = ptmt7.executeQuery();//创建数据对象
						List<Buyer> resultBuyer = new ArrayList<Buyer>();
						while(rs2.next()){
							Buyer buyer = new Buyer();
							buyer.setbuyerID(rs2.getString("buyerID"));
							buyer.setbuyername(rs2.getString("buyername"));
							buyer.setcompany(rs2.getString("company"));
							buyer.setphone(rs2.getString("phone"));
							resultBuyer.add(buyer);
						}
						table_2.removeAll();
						if(resultBuyer!=null) {
							for(int i = 0 ; i < resultBuyer.size() ; i++) {
								TableItem item;
								item = new TableItem(table_2,SWT.NONE);
								item.setText(new String[] {
										resultBuyer.get(i).getbuyerID(),
										resultBuyer.get(i).getbuyername(),
										resultBuyer.get(i).getcompany(),
										resultBuyer.get(i).getphone(),
								});
							}
						}
						buyerflag = 1;
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		});

	}
}
