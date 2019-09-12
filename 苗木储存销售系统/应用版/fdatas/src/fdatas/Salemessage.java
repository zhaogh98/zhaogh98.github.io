package fdatas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class Salemessage {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Salemessage window = new Salemessage();
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
		shell.setText("销售记录查询");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(549, 118, 20, 20);
		label.setText("\u4ECE");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"});
		combo.setBounds(575, 115, 92, 28);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(673, 118, 20, 20);
		label_1.setText("\u5E74");
		
		Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setItems(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"});
		combo_1.setBounds(702, 115, 92, 28);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(800, 118, 20, 20);
		label_2.setText("\u6708");
		
		Combo combo_2 = new Combo(shell, SWT.NONE);
		combo_2.setItems(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
		combo_2.setBounds(826, 115, 92, 28);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(924, 118, 20, 20);
		label_3.setText("\u65E5");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(549, 187, 20, 20);
		label_4.setText("\u5230");
		
		Combo combo_3 = new Combo(shell, SWT.NONE);
		combo_3.setItems(new String[] {"2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"});
		combo_3.setBounds(575, 184, 92, 28);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("\u5E74");
		label_5.setBounds(673, 187, 20, 20);
		
		Combo combo_4 = new Combo(shell, SWT.NONE);
		combo_4.setItems(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"});
		combo_4.setBounds(702, 184, 92, 28);
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setText("\u6708");
		label_6.setBounds(800, 187, 20, 20);
		
		Combo combo_5 = new Combo(shell, SWT.NONE);
		combo_5.setItems(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
		combo_5.setBounds(826, 184, 92, 28);
		
		Label label_7 = new Label(shell, SWT.NONE);
		label_7.setText("\u65E5");
		label_7.setBounds(924, 187, 20, 20);
		
		Button button = new Button(shell, SWT.NONE);
		button.setText("\u8FD4\u56DE");
		button.setBounds(702, 383, 98, 30);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(702, 298, 98, 30);
		button_1.setText("\u67E5\u8BE2");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(22, 52, 521, 437);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn_0 = new TableColumn(table, SWT.NONE);
		tableColumn_0.setWidth(54);
		tableColumn_0.setText("\u7F16\u53F7");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(99);
		tableColumn_1.setText("\u65E5\u671F");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(71);
		tableColumn_2.setText("\u4E70\u5BB6");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(89);
		tableColumn_3.setText("\u516C\u53F8");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(60);
		tableColumn_4.setText("\u6811\u79CD");
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(61);
		tableColumn_5.setText("\u578B\u53F7");
		
		TableColumn tableColumn_6 = new TableColumn(table, SWT.NONE);
		tableColumn_6.setWidth(61);
		tableColumn_6.setText("\u6570\u91CF");
		
		TableColumn tableColumn_7 = new TableColumn(table, SWT.NONE);
		tableColumn_7.setWidth(74);
		tableColumn_7.setText("\u571F\u7403\u72B6\u51B5");
		
		TableColumn tableColumn_8 = new TableColumn(table, SWT.NONE);
		tableColumn_8.setWidth(80);
		tableColumn_8.setText("\u6765\u6E90");
		
		TableColumn tableColumn_9 = new TableColumn(table, SWT.NONE);
		tableColumn_9.setWidth(66);
		tableColumn_9.setText("\u82D7\u5703");
		
		TableColumn tableColumn_10 = new TableColumn(table, SWT.NONE);
		tableColumn_10.setWidth(80);
		tableColumn_10.setText("\u9500\u552E\u989D");
		
		TableColumn tableColumn_11 = new TableColumn(table, SWT.NONE);
		tableColumn_11.setWidth(249);
		tableColumn_11.setText("\u5907\u6CE8");
		
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				Sale register=new Sale();
				shell.close();
				register.open();
			}
		});
		
		button_1.addSelectionListener(new SelectionAdapter(){//查询
			public void widgetSelected(SelectionEvent event){
				if(combo.getText() == ""&&combo_1.getText() == ""&&combo_2.getText() == ""&&combo_3.getText() == ""&&combo_4.getText() == ""&&combo_5.getText() == ""){
					final Display display = Display.getDefault();
			        final Shell shell = new Shell();
			        shell.setSize(327, 253);
					MessageBox messageBox = new MessageBox(shell);
					messageBox.setMessage("起始截止日期不能为空！");
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
						String year1=combo.getText();
						String month1=Integer.parseInt(combo_1.getText())+"";
						String day1=combo_2.getText();
						String year2=combo_3.getText();
						String month2=Integer.parseInt(combo_4.getText())+"";
						String day2=combo_5.getText();
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date u_date1=new java.util.Date();
						java.util.Date u_date2=new java.util.Date();
						u_date1 = df.parse(year1+"-"+month1+"-"+day1);
						u_date2 = df.parse(year2+"-"+month2+"-"+day2);
						java.sql.Date s_date1=new java.sql.Date(u_date1.getTime());
						java.sql.Date s_date2=new java.sql.Date(u_date2.getTime());
						
						String sql ="" +
								"select * from sale " +
								"where date between ? and ?";
						java.sql.PreparedStatement ptmt = connect.prepareStatement(sql);
						ptmt.setDate(1, s_date1);
						ptmt.setDate(2, s_date2);
						
						ResultSet rs = ptmt.executeQuery();//创建数据对象
						List<Trade> resultTrade = new ArrayList<Trade>();
						while(rs.next()){
							Trade trade = new Trade();
							trade.setsalenum(Integer.parseInt(rs.getString("salenum")));
							trade.setbuyername(rs.getString("buyername"));
							trade.setcompany(rs.getString("company"));
							trade.setdate(rs.getDate("date"));
							trade.settree(rs.getString("tree"));
							trade.setsize(rs.getInt("size"));
							trade.setwantnum(rs.getInt("wantnum"));
							trade.settree_soil(rs.getString("tree_soil"));
							trade.setsource(rs.getString("source"));
							trade.setfield(rs.getString("field"));
							trade.setout_price(rs.getInt("out_price"));
							trade.setnote(rs.getString("note"));
							resultTrade.add(trade);
						}
						if(resultTrade!=null) {
							table.removeAll();
							for(int i = 0 ; i < resultTrade.size() ; i++) {
								TableItem item;
								item = new TableItem(table,SWT.NONE);
								item.setText(new String[] {
										resultTrade.get(i).getsalenum()+"",
										resultTrade.get(i).getdate()+"",
										resultTrade.get(i).getbuyername(),
										resultTrade.get(i).getcompany(),
										resultTrade.get(i).gettree(),
										resultTrade.get(i).getsize()+"",
										resultTrade.get(i).getwantnum()+"",
										resultTrade.get(i).gettree_soil(),
										resultTrade.get(i).getsource(),
										resultTrade.get(i).getfield(),
										resultTrade.get(i).getout_price()+"",
										resultTrade.get(i).getnote(),
								});
							}
						}
						MessageBox messageBox = new MessageBox(shell);
						messageBox.setMessage("查询成功！");
				        messageBox.open();
				        while (!shell.isDisposed()){
				        	if (!display.readAndDispatch()){
				        		display.sleep();
				        	}
				        }
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		});

	}
}
