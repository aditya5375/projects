
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
class monthly implements ActionListener
{
	JFrame frame;
	JButton prev=new JButton("PREVIOUS PAGE");
	JButton cancel=new JButton("CANCEL PAGE");
	JLabel head=new JLabel("CURRENT MONTH RECORDS");
	JPanel panel=new JPanel();
	monthly()
	{
	  frame=new JFrame("CURRENT MONTH RECORDS");
   	  frame.setSize(1200,700);
   	  frame.setLayout(null);
   	  frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
   	  Color c = new Color(255,218,185);
      Container con = frame.getContentPane();
      con.setBackground( c ); 
      
      frame.add(head);
      head.setFont(new Font("CURRENT MONTH RECORDS",Font.BOLD,55));
      head.setBounds(300,0,1100,60);
   	  frame.add(panel);
   	  panel.setLayout(null);
   	  panel.setBackground(new Color(255,218,185));
   	  panel.setBounds(100,70,1000,540);
          prev.setBounds(600,100,150,30);
          cancel.setBounds(600,140,150,30);
          
      frame.add(prev);
   	  frame.add(cancel);
   	  prev.setBounds(400,620,150,30);
   	  cancel.setBounds(600,620,150,30);
   	  prev.addActionListener(this);
   	  cancel.addActionListener(this);
   	  int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
   Vector columnNames = new Vector();
        Vector data = new Vector();
 	    try
        {
        	
           String driver = "org.postgresql.Driver";
		 	String url = "jdbc:postgresql://localhost:5432/stock";
			Class.forName( driver );
            Connection con1 = DriverManager.getConnection( url,"postgres","password");
	          	String sql = "Select * from bill where B_DATE between Date()-30 and Date() Order by B_DATE,B_NO ";
            //String sql = "Select Date() from Stock ";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns =md.getColumnCount();
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
        JScrollPane tabdata = new JScrollPane( table,v,h );
        panel.add(tabdata);
        tabdata.setBounds(10,80,900,370);

   	  frame.setVisible(true);
   }
	


public void actionPerformed(ActionEvent e)
{
	if(e.getSource() == prev)
	{
		frame.dispose();
		
		MainMenu m=new MainMenu();
			m.setTitle("Main Menu");
		m.setSize(800,700);
		m.setVisible(true);
	}
	else if(e.getSource() == cancel)
	{
		frame.dispose();
	}
}
	
public static void main(String args[])
   {
   monthly wd=new monthly();
   }	
	
}