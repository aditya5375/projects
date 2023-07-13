import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
class Billing implements ActionListener
{
	JLabel cname=new JLabel("CUSTOMER NAME");
	JTextField cnamet;
	JButton store=new JButton("UPDATE DATABASE");
	Choice dept = new Choice();
	Choice deptlist = new Choice();
	JLabel name;
	JButton fin_bil=new JButton("FINAL BILL");
	JLabel bdate=new JLabel("BILL DATE");
	JTextField bdatet;
	//DefaultListModel model = new DefaultListModel();
	DefaultListModel model1 = new DefaultListModel();
	/*DefaultListModel model2 = new DefaultListModel();
	DefaultListModel model3 = new DefaultListModel();
	DefaultListModel model4 = new DefaultListModel();
	*/List list5= new List();
	List list1 = new List();
	JList list2 = new JList(model1);
	List list3 = new List();
	List list4 = new List();
	JButton show = new JButton("LIST OF PRODUCT");
	JFrame frame;
	JButton insert = new JButton("ADD PRODUCT INTO LIST");
	JTextField quan = new JTextField();
	JButton cancel = new JButton(new ImageIcon("Images\\cancel1.jpg"));
	JButton prev = new JButton("PREVIOUS PAGE");
	int i=1;
	float final_amt=0;
	int q=0;
	float ammmt=0;
	float val2;
	Calendar dt = Calendar.getInstance();
	JLabel final_bill=new JLabel("FINAL AMMOUNT");
	JTextField amt=new JTextField();
	JLabel ammtpaid=new JLabel("AMMOUNT PAID");
	JTextField ammtpaidt=new JTextField();
	Billing(String value)
	{	
		
		frame = new JFrame("BILLING FORM");
		frame.add(cname);
		cname.setBounds(100,70,180,30);
		cnamet=new JTextField(value);	
		frame.add(cnamet);
		cnamet.setBounds(300,70,150,30);
		frame.add(bdate);
		String stdt = dt.get(Calendar.DATE) + "/" + (dt.get(Calendar.MONTH)+1) + "/" + dt.get(Calendar.YEAR); 
		bdate.setBounds(500,70,100,30);
		bdatet=new JTextField(stdt);
		frame.add(bdatet);
		bdatet.setBounds(600,70,100,30);
		JLabel head = new JLabel("DAILY BILLING FORM");
		JLabel deptpname = new JLabel("PRODUCT LIST");
		JLabel quant = new JLabel("QUANTITY");
		name = new JLabel("SELECT DEPARTMENT NAME");
		frame.add(name);
		name.setBounds(10,110,180,30);
		frame.add(dept);
		dept.setBounds(200,110,180,30);
		frame.add(head);
		head.setFont(new Font("DAILY BILLING FORM",Font.BOLD,35));
		head.setBounds(200,0,750,50);
		frame.add(quant);
		quant.setBounds(400,150,200,30);
		frame.add(quan);
		quan.setBounds(550,150,180,30);
		frame.add(show);
		show.setBounds(10,150,180,30);
		frame.add(list5);
		list1.setBounds(10,200,50,300);
		frame.add(list1);
		frame.add(list2);
		list2.setBounds(60,200,300,300);
		frame.add(ammtpaid);
		ammtpaid.setBounds(590,250,100,30);
		frame.add(ammtpaidt);
		ammtpaidt.setBounds(690,250,100,30);
		frame.add(cancel);
		cancel.setBounds(600,450,50,60);
		frame.add(prev);
		prev.setBounds(600,350,150,30);
		frame.add(fin_bil);
		fin_bil.setBounds(600,400,150,30);
		fin_bil.addActionListener(this);
		Object str= "PRODUCT NAME";
		model1.addElement(str);
		Object s_tr="----------------------------------------------------------------";
		model1.addElement(s_tr);
		String str1 = "SR.NO.";
		list1.add(str1);
		String s_tr1="------";
		list1.add(s_tr1);
	
		frame.add(list3);
		list3.setBounds(360,200,80,300);
		frame.add(list4);
		list4.setBounds(440,200,70,300);
		String str2= "PRICE OF 1";
		list3.add(str2);
		String s_tr2="---------------";
		list3.add(s_tr2);
		String str3 = "QUANTITY";
		list4.add(str3);
		String s_tr3="---------------";
		list4.add(s_tr3);
		frame.add(list5);
		list5.setBounds(510,200,70,300);
		String str4= "AMMOUNT";
		list5.add(str4);
		String s_tr4="---------------";
		list5.add(s_tr4);
		frame.add(final_bill);
		final_bill.setBounds(400,500,100,30);
		frame.add(amt);
		amt.setBounds(510,500,75,30);
		frame.add(store);
		store.setBounds(600,300,150,30);
		frame.add(deptpname);
		deptpname.setBounds(400,120,170,25);
		frame.add(insert);
		insert.setBounds(200,150,180,30);
		try{
			
		int y_pos=0;
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stock",
            "postgres","password");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select distinct(Department) from Billing ");
		while (rs.next())
		{
			String val=rs.getString(1);
			System.out.println (val);
	//	JLabel img = new JLabel(val);
		System.out.println ("hi");
		dept.addItem(val);
	//	frame.add(img);
	//	img.setBounds(300,y_pos,150,30);
	//	y_pos+=40;
	
	}	insert.addActionListener(this);
		show.addActionListener(this);
		cancel.addActionListener(this);
		prev.addActionListener(this);
		store.addActionListener(this);
		frame.setLayout(null);
		frame.setSize(790,570);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	public void actionPerformed(ActionEvent b)
	{
		if(b.getSource() == cancel)
		{
			frame.dispose();
		}
		else if(b.getSource() == prev)
		{ 
		frame.dispose();
			new FirstPage();
		}
		else if(b.getSource() == fin_bil)
		{ 
		frame.dispose();
			Final_Bill bill = new Final_Bill(cnamet.getText(),Float.parseFloat(amt.getText()));
		}
	else if(b.getSource() == show)
		{
			System.out.println ("SHOW BUTTON CLICK");
    		String dname = dept.getSelectedItem();
			System.out.println (dname);
			try{
				Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stock",
            "postgres","password");
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery("select * from Billing where Department='"+dname+"'  ");
					if(deptlist.getItemCount() > 0)
				   deptlist.removeAll(); 
			
				while (rs.next())
				{
					String val=rs.getString(2);
					System.out.println (val);
					System.out.println ("hi");
					deptlist.addItem(val);
				
				}	
				frame.add(deptlist);
				deptlist.setBounds(550,120,180,30);
				
				}
				catch(Exception l)
				{
					System.out.println (l);
				}
		}
		if(b.getSource() == insert)
		{
			String quantity=quan.getText().trim();
			
			System.out.println (quantity);
			if(quantity.equals("")  )
			{
				JOptionPane.showMessageDialog( frame, "ENTER QUANTITY OF PRODUCT", "FAILED", JOptionPane.DEFAULT_OPTION);
			}
			else if(Integer.parseInt(quantity)<=0)
			{
				JOptionPane.showMessageDialog( frame, "ENTER PROPER QUANTITY OF PRODUCT", "FAILED", JOptionPane.DEFAULT_OPTION);
			}
			else
			{
			
			Object pname= deptlist.getSelectedItem();
			System.out.println ("Product list");
			System.out.println (pname);
			model1.addElement(pname);
			
			
			try{
				Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stock",
            "postgres","password");
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery("select * from Billing where Product_Name='"+pname+"'  ");
				
				while (rs.next())
				{
					q=Integer.parseInt(rs.getString(5));
					
					ammmt=Float.parseFloat(rs.getString(7));
					System.out.println ("quant:"+q);
					if(q<=2)
					{
						JOptionPane.showMessageDialog(frame,"Reorder Product!!!!\n Less Quantity is Availabel.");
					}
					//model1.addElement(i);
					String val=rs.getString(2);
					float val1=rs.getFloat(6);
					float val3=Float.parseFloat(quan.getText());
					val2=val1*val3;
					
					System.out.println (val);
					System.out.println (val1);
					System.out.println (val2);
					list1.add(Integer.toString(i));
					i=i+1;
					//model1.addElement(pname);
					list3.add(Float.toString(val1));
					list4.add(quan.getText());
					list5.add(Float.toString(val2));
					final_amt=final_amt+val2;
					amt.setText(Float.toString(final_amt));					
				
				}	
				int q1=q-Integer.parseInt(quan.getText());
				float ammt=ammmt-val2;
				Statement st1=con.createStatement();
				st1.executeUpdate("update Billing set Quantity='"+q1+"',Price='"+ammt+"' where Product_Name= '"+pname+"' ");
			
				}
				catch(Exception l)
				{
					System.out.println (l);
				}
	
		}
		}
		else if(b.getSource() == store)
		{
				System.out.println ("save");
			Connection con = null;
			String driver = "org.postgresql.Driver";
		 	String url = "jdbc:postgresql://localhost:5432/stock";
		 	try
				{
				try{
				String value1=cnamet.getText();
				float value2=Float.parseFloat(amt.getText());
				String datet=bdatet.getText();
				float amtg=Float.parseFloat(ammtpaidt.getText());
				float amtr=amtg-value2;
				Class.forName(driver);
				con = DriverManager.getConnection(url,"postgres","password");
				PreparedStatement st=con.prepareStatement("insert into bill(B_DATE,C_NAME,AMT,AMTG,AMTR) values(?,?,?,?,?)");
				st.setString(1,datet);
				st.setString(2,value1);
				st.setFloat(3,value2);
				st.setFloat(5,amtg);
				st.setFloat(6,amtr);
				st.executeUpdate();
				JOptionPane.showMessageDialog(frame,"RECORD ADDED SUCCESSFULLY");
				con.close();
					}
				catch(Exception ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Error in storing","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Error");
				}
		}
	}
	public void mainbill(String a)
	{
		
		Billing d = new Billing(a);
	}
}