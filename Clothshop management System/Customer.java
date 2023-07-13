import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.regex.*;
class Customer implements ActionListener
{
  JFrame f=new JFrame("CUSTOMER DATABASE FORM");
  JLabel img=new JLabel(new ImageIcon("Images\\cust2.jpg"));
  JLabel n=new JLabel("CUSTOMER NAME");
  JTextField nt=new JTextField(10);
  JLabel add=new JLabel("ADDRESS");
  JTextField addt=new JTextField(10);
  JLabel cnum=new JLabel("CONTACT NUMBER");
  JTextField cnumt=new JTextField();
  JButton addd=new JButton("ADD");
  JButton mod=new JButton("SAVE");
  JButton del=new JButton("DELETE");
  JButton ser=new JButton("SEARCH BY NAME");
  JButton ref=new JButton("REFRESH");
  JButton clear=new JButton("CLEAR");
  JButton back=new JButton("PREVIOUS PAGE");
  JButton bill=new JButton("BILL PAGE");
   Customer()
	{
		
		f.add(n);
		n.setBounds(10,380,200,30);
		f.add(nt);
		nt.setBounds(180,380,150,30);
		f.add(add);
		add.setBounds(10,430,200,30);
		f.add(addt);
		addt.setBounds(180,430,150,30);
		f.add(cnum);
		cnum.setBounds(10,480,200,30);
		f.add(cnumt);
		cnumt.setBounds(180,480,150,30);
		f.add(addd);
		addd.setBounds(350,380,200,25);
		f.add(ser);
		ser.setBounds(570,380,200,25);
		f.add(ref);
		ref.setBounds(350,450,200,25);
		f.add(mod);
		mod.setBounds(350,415,200,25);
		mod.setToolTipText("DO CHANGES IN DATA THEN SAVE IT");
		f.add(del);
		del.setBounds(570,415,200,25);	
		del.setToolTipText("ENTER NAME TO DELETE RECORD");
		f.add(clear);
		clear.setBounds(570,450,200,25);
		f.add(back);
		back.setBounds(350,485,200,25);
		f.add(bill);
		bill.setBounds(570,485,200,25);
		addd.addActionListener(this);
		mod.addActionListener(this);
		ser.addActionListener(this);
		del.addActionListener(this);
		ref.addActionListener(this);
		clear.addActionListener(this);
		back.addActionListener(this);
		bill.addActionListener(this);
		f.add(img);
		img.setBounds(-200,-160,790,700);
		Vector columnNames = new Vector();
        Vector data = new Vector();
		        try
        {
        	
            String driver = "org.postgresql.Driver";
		 	String url = "jdbc:postgresql://localhost:5432/stock";
			Class.forName( driver );
            Connection connection = DriverManager.getConnection( url,"postgres","password");
            String sql = "Select * from Cust"; 
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount()-2;
            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( md.getColumnName(i) );
            }
            while (rs.next())
            {
                Vector row = new Vector(columns);
 
                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }
 
                data.addElement( row );
            }
 
            rs.close();
            stmt.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }
        JTable table = new JTable(data, columnNames);
        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
        JScrollPane scrollPane = new JScrollPane( table,v,h );
		f.add(scrollPane);
		scrollPane.setBounds(380,30,400,330);
		
		f.setSize(790,570);
	f.setLayout(null);	
	f.setVisible(true);	
	f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == addd)
		{
			System.out.println ("hhii");
			String value1=nt.getText();
			String value2=addt.getText();
			String value3=cnumt.getText();
			Connection con = null;
			
			 String driver = "org.postgresql.Driver";
		 	String url = "jdbc:postgresql://localhost:5432/stock";
			System.out.println(value1+value2+value3);
				int flag=0;
			Pattern p;Matcher m;
 			boolean dontInsert = false;
					p = Pattern.compile("[A-Za-z]+[ ]*[A-Za-z]+");
			m = p.matcher(value1);
			if(!m.matches())
			{
		    	JOptionPane.showMessageDialog(f,"Enter proper name");
		    	dontInsert = true;
		    	flag=1;
		    }				
			p = Pattern.compile("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
			m = p.matcher(value3);
			if(!m.matches())
			{
		    	JOptionPane.showMessageDialog(f,"Enter Proper Contact Number");
		    	dontInsert = true;
		    	flag=1;
		    }				
		
			try{
				if(flag==1)
			{
					JOptionPane.showMessageDialog( f, "try once more", "ERROR...", JOptionPane.ERROR_MESSAGE);
			}
			else 
			{
				Class.forName(driver);
				con = DriverManager.getConnection(url,"postgres","password");
				PreparedStatement st=con.prepareStatement("insert into CUST(CUSTOMER_NAME,ADDRESS,CONTACT_NUMBER) values(?,?,?)");
				st.setString(1,value1);
				st.setString(2,value2);
				st.setString(3,value3);
				st.executeUpdate();
				JOptionPane.showMessageDialog(f,"DATA IS INSERTED INTO TABLE!!!!!!");
				con.close();
				}
			}
				catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(f,"Error in submitting data!");
				}
		}
		else if(e.getSource() == ser)
		{
			System.out.println ("serch");
			String value=nt.getText();
			Connection con = null;
			//sun.jdbc.odbc.JdbcOdbcDriver
		 	String driver = "org.postgresql.Driver";
		 	String url = "jdbc:postgresql://localhost:5432/stock";
		 	try{
				Class.forName(driver);
				con = DriverManager.getConnection(url,"postgres","password");
				PreparedStatement st=con.prepareStatement("select * from CUST where CUSTOMER_NAME=?");
				st.setString(1,value);
				ResultSet res=st.executeQuery();
				res.next();
				nt.setText(res.getString(1));
				addt.setText(res.getString(2));
				cnumt.setText(res.getString(3));
				con.close();
				}
			catch(Exception exp1)
			{
				exp1.printStackTrace();
				JOptionPane.showMessageDialog(f,"Can not show data");
			}
		}
		else if(e.getSource() == ref)
		{
			Vector columnNames = new Vector();
        Vector data = new Vector();
		        try
        {
        	
            String driver = "org.postgresql.Driver";
		 	String url = "jdbc:postgresql://localhost:5432/stock";
			Class.forName( driver );
            Connection connection = DriverManager.getConnection( url,"postgres","password");
            String sql = "Select * from Cust";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( md.getColumnName(i) );
            }
            while (rs.next())
            {
                Vector row = new Vector(columns);
 
                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }
 
                data.addElement( row );
            }
 
            rs.close();
            stmt.close();
        }
        catch(Exception er)
        {
            System.out.println( er );
        }
        JTable table = new JTable(data, columnNames);
        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
        JScrollPane scrollPane = new JScrollPane( table,v,h );
		f.add(scrollPane);
		scrollPane.setBounds(380,30,400,330);
		}
	else if(e.getSource() == mod)
		{
			System.out.println ("save");
			Connection con = null;
			//sun.jdbc.odbc.JdbcOdbcDriver
		 	String driver = "org.postgresql.Driver";
		 	String url = "jdbc:postgresql://localhost:5432/stock";
		 	try
				{
					int x=JOptionPane.showConfirmDialog(f,"Confirm edit? All data will be replaced");
				if(x==0){
				try{
				String value1=nt.getText();
				String value2=addt.getText();
				String value3=cnumt.getText();
				Class.forName(driver);
				con = DriverManager.getConnection(url,"postgres","password");
				Statement st=con.createStatement();
				st.executeUpdate("update CUST set ADDRESS='"+value2+"', CONTACT_NUMBER='"+value3+"' where CUSTOMER_NAME='"+value1+"'");
				JOptionPane.showMessageDialog(f,"Updated successfully");
				con.close();
					}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(f,"Error in updating edit fields");
				}
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(f,"Error");
				}
		}
		else if(e.getSource() == back)
		{
			new FirstPage();
		}
		else if(e.getSource() == bill)
		{
			f.dispose();
			new Billing(nt.getText().trim());
		}
		else if(e.getSource() == del)
		{
			System.out.println ("delete");
			String value1=nt.getText();
			Connection con = null;
		 	String driver = "org.postgresql.Driver";
		 	String url = "jdbc:postgresql://localhost:5432/stock";
		 	try{
				Class.forName(driver);
				con = DriverManager.getConnection(url,"postgres","password");
				PreparedStatement st=con.prepareStatement("DELETE FROM CUST WHERE CUSTOMER_NAME = ?");
				st.setString(1,value1);
				st.executeUpdate();
				JOptionPane.showMessageDialog(f,"Record is deleted successfully.");
				con.close();
				}
			catch(Exception exp3)
				{
					
				JOptionPane.showMessageDialog(f,"Error in deleting record.");
				exp3.printStackTrace();
				}
		}
		else if(e.getSource() == clear)
		{
			System.out.println ("clear");
			nt.setText("");
			addt.setText("");
			cnumt.setText("");
	}
}
  public static void main(String args[])
{
  Customer c=new Customer();
}
}