
import javax.swing.*;
import java.awt.event.*;
class FirstPage implements ActionListener
{
	JButton Bill;
	JButton Stock,cust,go,total;
	JFrame frame;
	JButton reports=new JButton("BILLING REPORTS PAGE");
	FirstPage()
	{
		frame = new JFrame("ADMIN WORK PAGE");
		JLabel img = new JLabel(new ImageIcon("Images\\supermarket.jpg"));
		go = new JButton(new ImageIcon("Images\\back.jpg"));
		Bill = new JButton("EMPLOYEE PAGE");
		Stock = new JButton("STOCK UPDATION");
		cust = new JButton("CUSTOMER DETILS");
		total = new JButton("TOTAL SELL");
		JLabel previous = new JLabel("PREVIOUS PAGE");
		frame.add(img);
		frame.add(go);
		frame.add(Bill);
		frame.add(Stock);
		frame.add(cust);
		frame.add(previous);
		frame.add(reports);

		img.setBounds(-220,-130,1000,780);
		go.setBounds(600,330,60,50);
		Bill.setBounds(550,130,200,30);
		Stock.setBounds(550,180,200,30);
		cust.setBounds(550,230,200,30); 
		reports.setBounds(550,280,200,30);
		previous.setBounds(600,380,200,30);
		Bill.addActionListener(this);
		Stock.addActionListener(this);
		cust.addActionListener(this);
		go.addActionListener(this);
		
		reports.addActionListener(this);
		frame.setLayout(null);
		frame.setSize(790,570);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == Bill)
		{
			System.out.println ("Bill BUTTON");
		frame.dispose();
		new Employee();
		}
		else if(e.getSource() == Stock)
		{
			System.out.println ("Stock BUTTON");
			frame.dispose();
			new Stock();
			
		}
		else if(e.getSource() == cust)
		{
			System.out.println ("cust BUTTON");
			frame.dispose();
			new Customer();
		}
		else if(e.getSource() == go)
		{
			System.out.println ("JUMP TO PREVIOUS PAGE");
			frame.dispose();
			new LoginPage();
		}
		else if(e.getSource() == reports)
		{
			System.out.println ("TOTAL CELL");
				MainMenu m=new MainMenu();
				m.setTitle("Main Menu");
		m.setSize(800,700);
			m.setVisible(true);
		}
		
	}	
	public static void main(String args[])
	{
		FirstPage fp = new FirstPage();
	}
}