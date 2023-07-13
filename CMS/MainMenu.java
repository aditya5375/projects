import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class MainMenu extends JFrame implements ActionListener 
{
	JMenuBar mbar;
	JMenu daily,weekly,monthly,m4,previous;
	JMenuItem daily_1,daily_2,weekly_1,weekly_2,weekly_3,monthly_1,previous_1;
	JTextArea t=new JTextArea();
	JLabel img=new JLabel(new ImageIcon("Images\\bill1.jpg"));
	
	public MainMenu()
	{
		
		mbar = new JMenuBar();
		setJMenuBar(mbar);
		daily=new JMenu("DAILY RECORD");
		mbar.add(daily);
		daily_1 = new JMenuItem("DAILY RECORD SHEET");
		daily.add(daily_1);
		weekly=new JMenu("WEEKLY RECORD");
		mbar.add(weekly);
		weekly_1 = new JMenuItem("WEEKLY RECORD SHEET");
		weekly.add(weekly_1);
		monthly=new JMenu("MONTHLY RECORD");
		mbar.add(monthly);
		monthly_1 = new JMenuItem("MONTHLY RECORD SHEET");
		monthly.add(monthly_1);
		previous=new JMenu("PREVIOUS PAGE");
		mbar.add(previous);
		previous_1 = new JMenuItem("PREVIOUS PAGE");
		previous.add(previous_1);
		daily_1.addActionListener(this);
		monthly_1.addActionListener(this);
		weekly_1.addActionListener(this);
		previous_1.addActionListener(this);
		addWindowListener(new M());
		add(t);
		t.setBounds(0,20,800,700);
		t.setEditable(false);
		t.add(img);
		img.setBounds(0,-50,800,700);
		t.setBackground(new Color(188,143,143));
	}
	


	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==daily_1)
		{
		dispose();
		new daily();

		}
		if(ae.getSource()==weekly_1)
		{
			dispose();
			new weekly();
		}
		
		
		if(ae.getSource()==monthly_1)
		{ 
			dispose();
			new monthly();            
		}
if(ae.getSource()==previous_1)
		{ 
			dispose();
			new FirstPage();            
		}

	}

	 public static void main(String args[])
	{
		MainMenu m = new MainMenu();
		m.setTitle("Main Menu");
		m.setSize(800,700);
		m.setVisible(true);


	}

	class M extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			setVisible(false);
			dispose();
			
		}
	}

}
