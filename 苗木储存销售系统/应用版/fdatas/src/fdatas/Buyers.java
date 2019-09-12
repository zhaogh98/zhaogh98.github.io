package fdatas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class Buyers {

	protected Shell shell;
	private Text text;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Buyers window = new Buyers();
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
		shell.setText("买家信息");
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(800,450,150,60 );
		button.setText("\u8FD4\u56DE\u83DC\u5355");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(800, 268, 98, 30);
		button_1.setText("\u67E5\u627E\u4E70\u5BB6");
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.setBounds(800, 341, 98, 30);
		button_2.setText("\u767B\u8BB0\u4E70\u5BB6");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(722, 148, 30, 20);
		label.setText("\u59D3\u540D");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(771, 145, 150, 26);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(71, 82, 576, 413);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(79);
		tableColumn.setText("\u7F16\u53F7");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(84);
		tableColumn_1.setText("\u59D3\u540D");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(243);
		tableColumn_2.setText("\u516C\u53F8");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(165);
		tableColumn_3.setText("\u7535\u8BDD");
		
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
					messageBox.setMessage("查询姓名不能为空!");
			        messageBox.open();
			        shell.dispose();
			        while (!shell.isDisposed()){
			        	if (!display.readAndDispatch()){
			        		display.sleep();
			        	}
			        }
				}else {//开始查找
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
					}catch(Exception e){
						e.printStackTrace();
					}
					
					try{
						Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytree?useSSL=false&serverTimezone=UTC","root","001215");
						//连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
						String fname=text.getText();//姓名
						String sql = "select * from buyer "+
						"where buyername = ?";
						java.sql.PreparedStatement ptmt = connect.prepareStatement(sql);
						ptmt.setString(1, fname);
						
						ResultSet rs = ptmt.executeQuery();//创建数据对象
						List<Buyer> resultBuyer = new ArrayList<Buyer>();
						if(resultBuyer!=null) {
							while(rs.next()){
								Buyer buyer = new Buyer();
								buyer.setbuyerID(rs.getString("buyerID"));
								buyer.setbuyername(rs.getString("buyername"));
								buyer.setcompany(rs.getString("company"));
								buyer.setphone(rs.getString("phone"));
								resultBuyer.add(buyer);
							}
						}
						if(resultBuyer!=null) {
							table.removeAll();
							for(int i = 0 ; i < resultBuyer.size() ; i++) {
								TableItem item;
								item = new TableItem(table,SWT.NONE);
								item.setText(new String[] {
										resultBuyer.get(i).getbuyerID(),
										resultBuyer.get(i).getbuyername(),
										resultBuyer.get(i).getcompany(),
										resultBuyer.get(i).getphone(),
								});
							}
						}
						MessageBox messageBox = new MessageBox(shell);
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
				Addbuyer register=new Addbuyer();
				shell.close();
				register.open();
			}
		});

	}

}
