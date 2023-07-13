import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.regex.*;
class Employee implements ActionListener
{
  JFrame f=new JFrame("EMPLOYEE FORM");
  JPanel main=new JPanel();
  JLabel head=new JLabel("EMPLOYEE UPDATION FORM");
  JLabel id= new JLabel("EMPLOYEE ID");
  JTextField idt = new JTextField();
  JLabel name=new JLabel("FULL NAME");
  JTextField namet=new JTextField(10);
    JLabel land=new JLabel("LAND LINE NUMBER");
  JTextField landt=new JTextField(10);
  JLabel cno=new JLabel("CONTACT NUMBER"); 
  JTextField cnot=new JTextField(2); 
  JButton addd=new JButton("ADD RECORD"); 
  JButton mod=new JButton("MODIFY");  
  JButton del=new JButton("DELETE BY NAME"); 
  JButton ser=new JButton("SEARCH BY NAME"); 
  JButton back=new JButton("PREVIOUS PAGE"); 
  JButton cancel=new JButton("CANCEL"); 
  JButton clear=new JButton("CLEAR"); 
	 JLabel img=new JLabel(new ImageIcon("Images\\cust.jpg"));
   Employee()
	{
		f.add(main);
		main.setBounds(0,0,900,740);
		main.setBackground(new Color(216,191,216));
		main.setLayout(null);
		main.add(head);
		head.setBounds(200,0,700,50);
		head.setFont(new Font("EMPLOYEE UPDATION FORM",Font.BOLD,35));
		main.add(id);
		id.setBounds(560,460,150,30);
		main.add(idt);
		idt.setBounds(690,460,150,30);
		idt.setEditable(false);
		main.add(name); 
		name.setBounds(560,510,150,30);
		main.add(namet);
		namet.setBounds(690,510,150,30);
		main.add(cno);
		cno.setBounds(560,560,150,30);
		main.add(cnot);
		cnot.setBounds(690,560,150,30);
		
		main.add(land);
		land.setBounds(560,610,150,30);
		main.add(landt);
		landt.setBounds(690,610,150,30);
		
		main.add(addd);
		addd.setBounds(60,460,150,30);
		main.add(mod);
		mod.setBounds(220,460,150,30);
		mod.setToolTipText("DO CHANGES THEN UPDATE AS PER NAME");
		main.add(del);
		del.setBounds(390,460,150,30);
		main.add(ser);
		ser.setBounds(60,510,150,30);	
		main.add(clear);
		clear.setBounds(220,510,150,30);
		main.add(back);
		back.setBounds(390,510,150,30);
		main.add(cancel);
		cancel.setBounds(220,560,150,30);
		addd.addActionListener(this);
		mod.addActionListener(this);
		del.addActionListener(this);
		ser.addActionListener(this);
		back.addActionListener(this);
		cancel.addActionListener(this);
		clear.addActionListener(this);
		main.add(img);
		img.setBounds(0,-100,900,700);
		f.setSize(900,720);
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
		String value2=cnot.getText();
		String value3=idt.getText();
		String landline=landt.getText();
		Connection con = null;
		
		System.out.println(value1+value2);
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
			m = p.matcher(value2);
			if(!m.matches())
			{
		    	JOptionPane.showMessageDialog(f,"Enter Proper mobile Number");
		    	dontInsert = true;
		    	flag=1;
		    }				
			p = Pattern.compile("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
			m = p.matcher(landline);
			if(!m.matches())
			{
		    	JOptionPane.showMessageDialog(f,"Enter Proper Contact Number");
		    	dontInsert = true;
		    	flag=1;
		    }				
		
		
		
		try{
			if(flag==1)
			{
					JOptionPane.showMessageDialog( f,"try once more", "ERROR...", JOptionPane.ERROR_MESSAGE);
			}
			else 
			{ 
				
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stock",
            "postgres","password");
		PreparedStatement st=con.prepareStatement("insert into EMPLOYEE(E_NAME,C_NO,LAND) values(?,?,?)");
		st.setString(1,value1);
		st.setInt(2,Integer.parseInt(value2));
		st.setInt(3,Integer.parseInt(landline));
		
		st.executeUpdate();
		JOptionPane.showMessageDialog(f,"EMPLOYEE IS SUCCESSFULLY ADDED INTO DATABASE");
		con.close();
		}}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(f,"BECAUSE OF ERROR CANT SUBMIT DATA");
		} 
		}
		else if(ae.getSource() == mod)
		{
			
			System.out.println ("mod");
			Connection con = null;
		 	String url = "org.postgresql.Driver";
		 	String driver = "jdbc:postgresql://localhost:5432/stock";
           
		 	try
				{
					String value1=namet.getText().trim();
					if(value1.equals(""))
					JOptionPane.showMessageDialog(f,"ENTER VALID DATA");
					else
					{
					int x=JOptionPane.showConfirmDialog(f,"UPDATE WILL CHANGES THE CONTACT NUMBER!!!");
				if(x==0)
				{
				try{
				String value2=cnot.getText();
				String landline=landt.getText();
				Class.forName(url);
				con = DriverManager.getConnection(driver,"postgres","password");
				Statement st=con.createStatement();
				st.executeUpdate("update EMPLOYEE set C_NO='"+value2+"',LAND='"+landline+"' where E_NAME='"+value1+"'");
				JOptionPane.showMessageDialog(f,"UPDATED SUCCESSFULLY","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
				con.close();
					}
				catch(Exception ex)
				{
					System.out.println (ex);
					JOptionPane.showMessageDialog(f,"ERROR IN UPDATING","ERROR",JOptionPane.ERROR_MESSAGE);
				}
					}
				}
			}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(f,"ERROR IN UPDATING","ERROR",JOptionPane.ERROR_MESSAGE);
				}
		}
		else if(ae.getSource() == del)
		{
			System.out.println ("del");
			String value1=namet.getText().trim();
			if(value1.equals(""))
				JOptionPane.showMessageDialog(f,"ENTER VALID TYPE!!!","ERROR",JOptionPane.ERROR_MESSAGE);
				else
				{
			Connection con = null;
		 	String url = "org.postgresql.Driver";
		 	String driver = "jdbc:postgresql://localhost:5432/stock";
		 	try{
				Class.forName(url);
				con = DriverManager.getConnection(driver,"postgres","password");
				PreparedStatement st=con.prepareStatement("DELETE FROM EMPLOYEE WHERE E_NAME = ?");
				st.setString(1,value1);
				st.executeUpdate();
				JOptionPane.showMessageDialog(f,"RECORD IS DELETED SUCCESSFULLY");
				con.close();
				idt.setText("");
		namet.setText("");
		cnot.setText("");
				}
			catch(Exception exp3)
				{
					
				JOptionPane.showMessageDialog(f,"BECAUSE OF ERROR CANT DELETE. TRY AGAIN!!!");
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
		 	String url = "org.postgresql.Driver";
		 	String driver = "jdbc:postgresql://localhost:5432/stock";
          
		 	try{
				Class.forName(url);
				con = DriverManager.getConnection(driver,"postgres","password");
				PreparedStatement st=con.prepareStatement("select * from EMPLOYEE where E_NAME=?");
				st.setString(1,value);
				ResultSet res=st.executeQuery();
				res.next();
				idt.setText(Integer.toString(res.getInt(1)));
				namet.setText(res.getString(2));
				cnot.setText(res.getString(3));
				landt.setText(res.getString(4));
				con.close();
				}
			catch(Exception exp1)
			{
				exp1.printStackTrace();
				JOptionPane.showMessageDialog(f,"DATA IS NOT AVAILABEL","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		
		
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
		else if(ae.getSource() == clear)
		{
		System.out.println ("clear");
		idt.setText("");
		namet.setText("");
		cnot.setText("");
		landt.setText("");
		}
	}
  public static void main(String args[])
{
  Employee c=new Employee();
}
}
	