package fdatas;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class Store {

	protected Shell shell;
	private Text text;
	private Table table_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Store window = new Store();
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
		shell.setSize(1000, 600);
		shell.setText("苗木入库");
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(800,450,150,60 );
		button.setText("\u8FD4\u56DE\u83DC\u5355");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(800, 268, 98, 30);
		button_1.setText("\u67E5\u627E\u82D7\u6728");
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.setBounds(800, 341, 98, 30);
		button_2.setText("\u767B\u8BB0\u82D7\u6728");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(734, 114, 60, 20);
		label.setText("\u82D7\u6728\u540D\u79F0");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(800, 114, 150, 26);
		
		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(54, 47, 643, 463);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tableColumn_0 = new TableColumn(table_1, SWT.NONE);
		tableColumn_0.setWidth(54);
		tableColumn_0.setText("\u7F16\u53F7");
		
		TableColumn tableColumn_1 = new TableColumn(table_1, SWT.NONE);
		tableColumn_1.setWidth(114);
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
		
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				Menu register=new Menu();
				shell.close();
				register.open();
			}
		});
		
		button_1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				if(text.getText()==""){
					final Display display = Display.getDefault();
			        final Shell shell = new Shell();
			        shell.setSize(327, 253);
					MessageBox messageBox = new MessageBox(shell);
					messageBox.setMessage("查询树种不能为空!");
			        messageBox.open();
			        shell.dispose();
			        while (!shell.isDisposed()){
			        	if (!display.readAndDispatch()){
			        		display.sleep();
			        	}
			        }
				}else {//开始查找
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");//用了MySQL新版本所以发生了更改
					}catch(Exception e){
						e.printStackTrace();
					}
					try{
						Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytree?useSSL=false&serverTimezone=UTC","root","001215");
						//连接URL为   jdbc:mysql//服务器地址/数据库名  ，MySQL8.0要添加useSSL和UTC，后面的2个参数分别是登陆用户名和密码
						String fname=text.getText();//苗木名称
						String sql = "select * from store "+
						"where tree = ?";
						java.sql.PreparedStatement ptmt = connect.prepareStatement(sql);
						ptmt.setString(1, fname);
						
						ResultSet rs = ptmt.executeQuery();//创建数据对象
						
						List<Tree> resultTree = new ArrayList<Tree>();
						while(rs.next()){
							Tree tree = new Tree();
							tree.settreeID(rs.getString("treeID"));
							tree.setdate(rs.getDate("date"));
							tree.settree(rs.getString("tree"));
							tree.setsize(rs.getInt("size"));
							tree.setnum(rs.getInt("num"));
							tree.settree_soil(rs.getString("tree_soil"));
							tree.setsource(rs.getString("source"));
							tree.setfield(rs.getString("field"));
							tree.seton_truck(rs.getInt("on_truck"));
							tree.settransport(rs.getInt("transport"));
							tree.setoff_truck(rs.getInt("off_truck"));
							tree.setcost_price(rs.getInt("cost_price"));
							tree.setsale_price(rs.getInt("sale_price"));
							tree.setimg(rs.getString("img"));
							tree.setnote(rs.getString("note"));
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
						MessageBox messageBox = new MessageBox(shell,SWT.OK);
						messageBox.setMessage("查询成功!");
					    messageBox.open();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		});
		
		button_2.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				Addtree register=new Addtree();
				shell.close();
				register.open();
			}
		});

	}
}
