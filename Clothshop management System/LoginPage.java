import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class LoginPage implements ActionListener
{
  JFrame f=new JFrame("Billing and Stock Login Page");
  JLabel img=new JLabel(new ImageIcon("Images\\billing.PNG"));
  JLabel name = new JLabel("BILLING AND STOCK FOR GARMENT SHOP");
  JLabel user = new JLabel("USER NAME");
  JLabel pass = new JLabel("PASSWORD");
  JTextField usertext = new JTextField();
  JPasswordField passtext = new JPasswordField();
  JButton login = new JButton("Login");
  JButton clear = new JButton("Clear");
  JButton tour = new JButton("SUPER MARKET TOUR");
  JButton spec = new JButton("SPECILITIES");
 
  JLabel market = new JLabel(new ImageIcon("Images\\super.JPG"));
    LoginPage()
	{
		
		f.add(name);
		name.setBounds(10,0,1240,50);
		name.setFont(new Font("BILLING AND STOCK FOR GARMENT SHOP",Font.BOLD|Font.ITALIC,40));
		f.add(img);
		img.setBounds(200,-50,400,400);
		f.add(market);
		market.setBounds(500,210,300,200);
		f.add(user);
		user.setBounds(10,400,200,30);
		f.add(usertext);
		usertext.setBounds(180,400,200,30);
		f.add(pass);
		pass.setBounds(10,450,200,30);
		f.add(passtext);
		passtext.setBounds(180,450,200,30);
		f.add(login);
		login.setBounds(20,500,150,30);
		f.add(clear);
		clear.setBounds(190,500,150,30);
		login.addActionListener(this);
		clear.addActionListener(this);
		f.setSize(900,570);
		f.setLayout(null);	
		f.setVisible(true);	
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == clear)
		{
			usertext.setText("");
			passtext.setText("");
		
		}
		else if(e.getSource() == login)
		{
			
			String user,pass;
			user = usertext.getText();
			pass = passtext.getText();
			System.out.println (user);
			System.out.println (pass);
			if(user.equals("BillStock")&&pass.equals("BillStock"))
			{
			System.out.println ("YES");
			JOptionPane.showMessageDialog( f, "Authorised User U Can Access Project", "LOGIN", JOptionPane.DEFAULT_OPTION);
			f.dispose();
			new FirstPage();
			}
			else
			{
			JOptionPane.showMessageDialog( f, "Please Enter Proper User Name And Password", "ERROR...", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
  public static void main(String args[])
{
  LoginPage c=new LoginPage();
}
}
	 