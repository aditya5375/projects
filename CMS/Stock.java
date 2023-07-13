import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.regex.*;
class Stock implements ActionListener
{
  JFrame f=new JFrame("STOCK FORM");
  JLabel head=new JLabel("STOCK UPDATION FORM");
  JLabel id= new JLabel("PRODUCT ID");
  JTextField idt = new JTextField();
  JLabel name=new JLabel("PRODUCT NAME");
  JTextField namet=new JTextField(10);
  JLabel dept=new JLabel("SECTIONS");
  JComboBox deptt=new JComboBox();
  JLabel comp=new JLabel("COMPANY");
  JTextField compt=new JTextField(10);
  JLabel quant=new JLabel("QUANTITY");
  JTextField quantt=new JTextField();
  JLabel price=new JLabel("PRICE OF 1 PRODUCT");
  JTextField pricet=new JTextField(2);
  JLabel total=new JLabel("TOTAL AMMOUNT");
  JTextField totalt=new JTextField(2);
  JButton addd=new JButton("ADD RECORD");
  JButton mod=new JButton("MODIFY");
  JButton del=new JButton("DELETE BY NAME");
  JButton ser=new JButton("SEARCH BY NAME");
  JButton ref=new JButton("REFRESH");
  JButton back=new JButton("PREVIOUS PAGE");
  JButton cancel=new JButton("CANCEL");
  JButton clear=new JButton("CLEAR");
   Stock()
	{
		f.add(head);
		head.setBounds(200,0,700,50);
		head.setFont(new Font("STOCK UPDATION FORM",Font.BOLD,35));
		f.add(id);
		id.setBounds(410,60,150,30);
		f.add(idt);
		idt.setBounds(540,60,150,30);
		f.add(name); 
		name.setBounds(410,110,150,30);
		f.add(namet);
		namet.setBounds(540,110,150,30);
		f.add(dept);
		dept.setBounds(410,160,150,30);
		f.add(deptt);
		deptt.addItem("LADIES");
		deptt.addItem("GENTS");
		deptt.addItem("CHILDERNS");
		
		deptt.setBounds(540,160,150,30);
		f.add(comp);
		comp.setBounds(410,210,150,30);
		f.add(compt);
		compt.setBounds(540,210,150,30);
		f.add(quant);
		quant.setBounds(410,260,150,30);
		f.add(quantt);
		quantt.setBounds(540,260,150,30);
		f.add(price);
		price.setBounds(410,310,150,30);
		f.add(pricet);
		pricet.setBounds(540,310,150,30);
		f.add(total);
		total.setBounds(410,360,150,30);
		f.add(totalt);
		totalt.setBounds(540,360,150,30);
		totalt.setEditable(false);
		f.add(addd);
		addd.setBounds(30,400,150,30);
		f.add(mod);
		mod.setBounds(200,400,150,30);
		mod.setToolTipText("DO CHANGES THEN UPDATE AS PER NAME");
		f.add(del);
		del.setBounds(380,400,150,30);
		f.add(ser);
		ser.setBounds(550,400,150,30);	
		f.add(ref);
		ref.setBounds(200,450,150,30);
		f.add(clear);
		clear.setBounds(380,450,150,30);
		f.add(back);
		back.setBounds(200,500,150,30);
		f.add(cancel);
		cancel.setBounds(380,500,150,30);
		addd.addActionListener(this);
		mod.addActionListener(this);
		del.addActionListener(this);
		ser.addActionListener(this);
		back.addActionListener(this);
		cancel.addActionListener(this);
		clear.addActionListener(this);
		ref.addActionListener(this);
		id.setEnabled(false);
		idt.setEnabled(false);
		Vector col1 = new Vector();
        Vector col2 = new Vector();
		        try
        {
        	
           	String driver = "org.postgresql.Driver";
		 	String url = "jdbc:postgresql://localhost:5432/stock";
			Class.forName( driver );
            Connection connection = DriverManager.getConnection( url,"postgres","password");
            String sql = "Select * from Billing";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount()-1;
            for (int i = 1; i <= columns; i++)
            {
                col1.addElement( md.getColumnName(i) );
            }
            while (rs.next())
            {
                Vector row = new Vector(columns);
 
                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }
 
                col2.addElement( row );
            }
 
            rs.close();
            stmt.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }
        JTable table = new JTable(col2, col1);
        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
        JScrollPane scrollPane = new JScrollPane( table,v,h );
		f.add(scrollPane);
		scrollPane.setBounds(0,60,400,300);
		f.setSize(790,570);
		f.setLayout(null);	
		f.setVisible(true);	
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == addd)
		{
			
		System.out.println ("add");
		String value1=namet.getText();
		Object value2=deptt.getSelectedItem();
		String value4=quantt.getText();
		String value3=compt.getText();
		float value5=Float.parseFloat(pricet.getText());
		float value6=value5*Float.parseFloat(value4);
		Connection con = null;
		String driver = "org.postgresql.Driver";
		 	String url = "jdbc:postgresql://localhost:5432/stock";
		System.out.println(value1+value2+value3+value4+value5+value6);
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
		if(Integer.parseInt(value4)<0)
		{
			JOptionPane.showMessageDialog(null,"Enter proper quantity");
			flag=1;
		}
		if(value5<0.0)
		{
			JOptionPane.showMessageDialog(null,"Enter proper price");
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
		PreparedStatement st=con.prepareStatement("insert into Billing(Product_Name,Department,Company,Quantity,Price_of_One,Price) values(?,?,?,?,?,?)");
		st.setString(1,value1);
		st.setObject(2,value2);
		st.setString(3,value3);
		st.setInt(4,Integer.parseInt(value4));
		st.setFloat(5,value5);
		st.setFloat(6,value6);
		st.executeUpdate();
		JOptionPane.showMessageDialog(f,"Data is successfully entered into database.");
		con.close();
		}}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(f,"Error in submitting data!!!!");
		} 
		}
		else if(ae.getSource() == mod)
		{
			
			System.out.println ("mod");
			Connection con = null;
		 	String driver = "org.postgresql.Driver";
		 	String url = "jdbc:postgresql://localhost:5432/stock";
		 	try
				{
					String value1=namet.getText().trim();
					if(value1.equals(""))
					JOptionPane.showMessageDialog(f,"ENTER VALID DATA");
					else
					{
					int x=JOptionPane.showConfirmDialog(f,"Confirm edit? All data will be replaced");
				if(x==0)
				{
				try{
				Object value2=deptt.getSelectedItem();
				String value3=compt.getText();
				String value4=quantt.getText();
				Float value5=Float.parseFloat(pricet.getText());
				Float value6=value5 * Float.parseFloat(value4);
				Class.forName(driver);
				con = DriverManager.getConnection(url);;
				Statement st=con.createStatement();

				st.executeUpdate("update Billing set Department='"+value2+"', Company='"+value3+"',Quantity='"+value4+"',Price_of_One='"+value5+"',Price='"+value6+"' where Product_Name='"+value1+"'");
				JOptionPane.showMessageDialog(f,"Updated successfully");
				con.close();
					}
				catch(Exception ex)
				{
					System.out.println (ex);
					JOptionPane.showMessageDialog(f,"Error in updating edit fields");
				}
					}
				}
			}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(f,"Error");
				}
		}
		else if(ae.getSource() == del)
		{
			System.out.println ("del");
			String value1=namet.getText().trim();
			if(value1.equals(""))
				JOptionPane.showMessageDialog(f,"Cannot found record.");
				else
				{
			Connection con = null;
		 	String driver = "org.postgresql.Driver";
		 	String url = "jdbc:postgresql://localhost:5432/stock";
		 	try{
				Class.forName(driver);
				con = DriverManager.getConnection(url,"postgres","password");
				PreparedStatement st=con.prepareStatement("DELETE FROM Billing WHERE Product_Name = ?");
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
		}
		else if(ae.getSource() == ser)
		{
			id.setEnabled(true);
			idt.setEnabled(true);
			System.out.println ("ser");
			String value=namet.getText();
			Connection con = null;
		 	String driver = "org.postgresql.Driver";
		 	String url = "jdbc:postgresql://localhost:5432/stock";
		 	try{
				Class.forName(driver);
				con = DriverManager.getConnection(url,"postgres","password");
				PreparedStatement st=con.prepareStatement("select * from Billing where Product_Name=?");
				st.setString(1,value);
				ResultSet res=st.executeQuery();
				res.next();
				idt.setText(Integer.toString(res.getInt(1)));
				namet.setText(res.getString(2));
				deptt.setSelectedItem(res.getObject(3));
				compt.setText(res.getString(4));
				quantt.setText(Integer.toString(res.getInt(5)));
				pricet.setText(Float.toString(res.getFloat(6)));
				totalt.setText(Float.toString(res.getFloat(7)));
				con.close();
				}
			catch(Exception exp1)
			{
				exp1.printStackTrace();
				JOptionPane.showMessageDialog(f,"Can not show data");
			}
			id.setEnabled(false);
			idt.setEnabled(false);
		}
		
		else if(ae.getSource() == back)
		{
		System.out.println ("back");
		f.dispose();
		new FirstPage();
		
		}
		
		else if(ae.getSource() == cancel)
		{
		System.out.println ("cancel");
		f.dispose();
		
		}
		else if(ae.getSource() == ref)
		{
			System.out.println ("REFRESH");
					Vector col1 = new Vector();
        Vector col2 = new Vector();
		try
        {
        	
            String driver = "org.postgresql.Driver";
		 	String url = "jdbc:postgresql://localhost:5432/stock";
			Class.forName( driver );
            Connection connection = DriverManager.getConnection( url,"postgres","password");
            String sql = "Select * from Billing";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount()-1;
            for (int i = 1; i <= columns; i++)
            {
                col1.addElement( md.getColumnName(i) );
            }
            while (rs.next())
            {
                Vector row = new Vector(columns);
 
                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }
 
                col2.addElement( row );
            }
 
            rs.close();
            stmt.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }
        JTable table = new JTable(col2, col1);
        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
        JScrollPane scrollPane = new JScrollPane( table,v,h );
		f.add(scrollPane);
		scrollPane.setBounds(0,60,400,300);

		}
		else if(ae.getSource() == clear)
		{
		System.out.println ("clear");
		idt.setText("");
		namet.setText("");
		
		compt.setText("");
		quantt.setText("");
		pricet.setText("");
		totalt.setText("");
			
		}
	}
  public static void main(String args[])
{
  Stock c=new Stock();
}
}
	