import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;
class HomePage implements ActionListener
{
   JFrame frame;
   JTabbedPane pane;
   intro ch;
   ticketcenter fn;
   food edu;
   mm lml;
   artdeco per;
   JLabel head=new JLabel("GARMENT SHOP");
   JLabel bk = new JLabel(new ImageIcon("AP.jpg"));
   JButton prev=new JButton("PREVIOUS PAGE");
   JButton cancel=new JButton("CANCEL");
   
   HomePage()
   {
   	  frame=new JFrame("GARMENT SHOP");
   	  frame.setSize(1280,775);
   	  frame.setLayout(null);
   	  //frame.setBackground(new Color(255,222,173));
   	  frame.setFont(new Font("Times New Roman",Font.PLAIN,20));
      Container con = frame.getContentPane();

      frame.add(head);
      head.setForeground(Color.black);
      head.setFont(new Font("GARMENT SHOP",Font.BOLD,55));
      head.setBounds(300,0,1100,60);
   	  pane=new JTabbedPane();
   	  ch=new  intro();
   	  pane.add("INTRODUCTION",ch);
   	  fn=new ticketcenter();
   	  pane.add("TICKET CENTER",fn);
   	  edu=new food();
   	  pane.add("FOOD COURT",edu);
   	  lml=new mm();
   	  pane.add("MOVIE MUNCHIES",lml);
   	  pane.setBounds(100,130,1000,490);
   	  per=new artdeco();
   	  pane.add("ART DECO METRO",per);
   	  frame.add(prev);
   	  frame.add(cancel);
   	  prev.setBounds(400,630,150,30);
   	  cancel.setBounds(600,630,150,30);
   	     	  
   	  prev.addActionListener(this);
   	  cancel.addActionListener(this);
   	  frame.add(pane);
   	  frame.setVisible(true);
  	  frame.add(bk);
   	  bk.setBounds(0,0,1300,775);
   	  frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 
   }
   public void actionPerformed(ActionEvent ae)
   {
   	if(ae.getSource() == cancel)
   	{
   		frame.dispose();
   	}
   	
   	else if(ae.getSource() == prev)
   	{
   		frame.dispose();
   	
   	}
   	
   	
   }

public static void main(String args[])
   {
   HomePage wd=new HomePage();
   }
}
class intro extends JPanel
{
  JLabel home;
  intro()
  {
   	setLayout(null);
  	home=new JLabel("INTRODUCTION");
  	home.setFont(new Font("INTRODUCTION",Font.BOLD,32));
    home.setBounds(400,10,400,30); 
    home.setForeground(Color.black);
    JLabel img=new JLabel(new ImageIcon("Images/intro.jpg"));
     JTextArea txt1=new JTextArea("\t\tINTRODUCTION" +

"\n\n\tBIG Cinemas at R City lets Mumbai's movie lovers experience movies like never before."+

"With 4 screens, 20 shows a day and a total seating capacity of 2100, it provides a variety of in cinema experiences to choose from."+

"Savour sumptuous delicacies at Cine Diner, the world's first ever cinema-cum-fine dining restaurant. Discover new angles to movie viewing at 180°, an exclusive screen with All Luxury Recliner Seating. Relax as you wait for friends at Pause, the private in-cinema lounge."+

"Or let your kids have a blast at Mischief, an exclusive in-cinema play area for kids."+

"bIndia's first megaplex offers you an array of in-cinema experiences that the country has never seen before."
);

     int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	 int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
    JScrollPane sp=new JScrollPane(txt1,v,h);
    sp.setBounds(350,70,600,370); 
    
    txt1.setLineWrap(true);
    txt1.setEditable(false);
    txt1.setBackground(new Color(176,196,222));
    txt1.setFont(new Font("Times New Roman",Font.PLAIN,19));
    add(img);
    img.setBounds(10,50,300,300);
    add(home);
    add(sp);
    setBackground(new Color(173,216,230)); 
  }
 
 
 }
class ticketcenter extends JPanel
{
  JLabel car;
  ticketcenter()
  {
  	setLayout(null);
  	car=new JLabel("TICKET CENTER");
  	car.setFont(new Font("TICKET CENTER",Font.BOLD,32));
    car.setBounds(400,10,400,30); 
    car.setForeground(Color.black);
    JLabel img=new JLabel(new ImageIcon("Images\\ticket.jpg"));
    JTextArea txt1=new JTextArea("\t\t\tTICKET CENTER" +

"\n\n\tCar loans are reasonably short-term lending vehicles designed to help people purchase automobiles. A car loan can come from a number of different lending sources. The sources available can depend on the need for bad credit car loans or used car loans. It is also possible to sometimes refinance car loans to obtain a better deal. This is not uncommon when people make new car loans and discover they can get better terms elsewhere. The cost of borrowing associated with car loans can be impacted by a number of factors. The length of the loan in months, the interest rates involved and the amount of down payment can all affect costs."
);

     int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	 int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
    JScrollPane sp=new JScrollPane(txt1,v,h);
   // sp.setBounds(280,70,700,370); 
    txt1.setLineWrap(true);
    txt1.setEditable(false);
    txt1.setBackground(new Color(176,196,222));
    txt1.setFont(new Font("Times New Roman",Font.PLAIN,19));
    
    add(img);
    img.setBounds(150,50,700,370);
    
    add(car);
    add(sp);
    setBackground(new Color(173,216,230)); 
  }
   
}
class food extends JPanel
{
  JLabel edu;
  food()
  {
  	setLayout(null);
  	edu=new JLabel("FOOD COURT");
  	edu.setFont(new Font("FOOD COURT",Font.BOLD,32));
    edu.setBounds(400,10,400,30); 
    edu.setForeground(Color.black);
    JLabel img=new JLabel(new ImageIcon("Images\\food.jpg"));
    JTextArea txt1=new JTextArea("\t\tFOOD COURT" +

"\n\n\tA food court is a plaza or common area within a facility[1] that is contiguous with the counters of multiple food vendors and provides a common area for self-serve dining.[2] Food courts may be found in shopping malls and airports, and in various regions (such as Asia and Africa) may be a standalone development."+
"Food courts consist of a number of vendors at food stalls or service "+
"counters. Meals are ordered at one of the vendors and then carried to a "+
"common dining area. Typical North American and European food courts have "+
"mostly fast food chains such as McDonald's and Sbarro, with perhaps a"+ 
"few smaller private vendors. Cuisines and choices are varied, with"+ 
"larger food courts offering more global choices. Asian and African food"+ 
"courts are mostly private vendors that offer local cuisine."+ 
"In Singapore, food courts and hawker centers are the people's main"+ 
"eating choice when dining out.[4] Many food courts have several shops"+ 
"which sell prepared meals for shoppers to take home and reheat, making"+ 
"the food court a daily stop for some shoppers"
);

     int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	 int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
    JScrollPane sp=new JScrollPane(txt1,v,h);
    sp.setBounds(350,70,600,370); 
    add(img);
    img.setBounds(10,50,300,300);
    txt1.setLineWrap(true);
    txt1.setEditable(false);
    txt1.setBackground(new Color(176,196,222));
    txt1.setFont(new Font("Times New Roman",Font.PLAIN,19));
    
    add(edu);
    add(sp);
    setBackground(new Color(173,216,230)); 
  }
 
 
 
}
class mm extends JPanel
{
  JLabel loan1;
  mm()
  {
  	setLayout(null);
  	loan1=new JLabel("MOVIE MUNCHIES");
  	loan1.setFont(new Font("MOVIE MUNCHIES",Font.BOLD,32));
    loan1.setBounds(300,10,500,30); 
    loan1.setForeground(Color.black);
    JLabel img=new JLabel(new ImageIcon("munchies.jpg"));
        JTextArea txt1=new JTextArea("\t\t\tMOVIE MUNCHIES" +

"\n\n\tThe sumptuous Popcorn Flavor Bar has three range of flavors - the tangy Hot & Sour range which includes flavors like Tomato Chilli, Cheese and Jalapeno, Chilly Chutney and Sichuan, the subtle International range which includes Yoghurt and Onion, Cheese and Pepper, Wasabi and Cajun Spice and the fabulously Indian range which includes the Chatpata Masala, Sweet and Tangy Lime, Butter Garlic and Cheese Spice."+

"The Popcorn Flavor Bar is a one of its kind concept where BIG Cinemas guests can request for flavors to be added to their regular popcorn in a specially designed Shaker Bag that is available at the concession counter. Popcorn lovers will be greeted with a wide range of flavors, an opportunity to indulge their taste buds like never before."+
"The Popcorn Flavor Bar is open at all BIG Cinemas multiplexes."+
"About the flavours :"+
"\n1. Cajun Spice : Blend of mixed herb like oregano, rosemary, thyme along with the spices like Red chilly, black pepper giving it a kick of heat while keeping the flavor."+
"\n2. Sweet & Tangy Lime : A juicy blend of fresh lime with sugar, aromatic spices like coriander, ginger, ajwain clove & mixed herbs giving a balanced sweet tangy flavor."+
"\n3. Wasabi Seasonings : A sharp, tingling aroma with a biting, fresh taste of blended garlic, ginger & pepper with yellow mustard powder making it truly asian flavor."+
"\n4. Cheese & Jalapeno : A creamy profile of cheddar cheese with the topnote of fresh Jalapeno to give that unique kick of heat."+
"\n5. Cheese & Pepper : A nice smooth creamy cheese blended along with pepper & herbs to give the hit with every bite."+
"\n6. Yogurt & Onion : A blend of creamy yogurt & green onion for that nice subtle sophisticated taste."+
"\n7. Chilly Chutney : A mix of red hot paprika along with pepper, cumin, fennel, garlic, juicy tomato & a touch of green coriander leaves to have an exotic Indian relish."+
"\n8. Butter Garlic : Sizzling creamy butter blended along with garlic, aromatic caraway seeds, oregano, paprika."+
"\n9. Chatpata Masala : An unique blend of hot paprika, pepper along with juicy tomato, creamy onion & mixed herbs to give a sizzling taste of tango spice."+
"\n10. Tomato chilli : Juicy tangy tomato blended with red hot paprika."+
"\n11. Schezwan : A blend of age old chinese favorite soy sauce with nice aromatic garlic & the red hot chillies."+
"\n12. Cheese Spicy : Cheddar cheese blended other spices like paprika, cumin, pepper to have that unique spicy cream feel."
);

     int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	 int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
    JScrollPane sp=new JScrollPane(txt1,v,h);
    sp.setBounds(350,70,600,370); 
    
    txt1.setLineWrap(true);
    txt1.setEditable(false);
    txt1.setBackground(new Color(176,196,222));
    txt1.setFont(new Font("Times New Roman",Font.PLAIN,19));
    add(img);
    img.setBounds(10,50,300,300);
    
    add(loan1);
    add(sp);
    setBackground(new Color(173,216,230)); 
  }
 
}


class artdeco extends JPanel
{
  JLabel loan1;
  artdeco()
  {
   	setLayout(null);
  	loan1=new JLabel("ART DECO METRO");
  	loan1.setFont(new Font("ART DECO METRO",Font.BOLD,32));
    loan1.setBounds(300,10,500,30); 
    loan1.setForeground(Color.black);
    JLabel img=new JLabel(new ImageIcon("Images\\art.jpg"));    
    JTextArea txt1=new JTextArea("\t\t\tART DECO METRO" +

"\n\n\tThe Art Deco Metro cinema opened in June 1938, primarily to exhibit the MGM movies and gradually became Bollywood's favorite red carpet destination. Over the past seven decades, Metro Cinema has become a landmark on the Mumbai's cityscape and part of city's movie traditions. BIG Cinemas acquired the theatre in 2005 and refurbished it with state of art facilities and opulent interiors which blend today's audience requirements with the theatre's heritage charm and results have been remarkable."+

"Metro BIG Cinemas now houses 6 contemporary screening rooms with a seating capacity for 1491 people including a luxurious Ebony Lounge with recliners, offering moviegoers the finest customer amenities and a dynamic screen presentation, along with a greater choice of films and viewing times. The auditoriums are furnished with wall-to-wall screens, stadium-style seating in plush, high-backed push back sofas and Dolby sound systems."

);

     int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	 int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
    JScrollPane sp=new JScrollPane(txt1,v,h);
    
    sp.setBounds(350,70,600,370); 
    
    txt1.setLineWrap(true);
    txt1.setEditable(false);
    txt1.setBackground(new Color(176,196,222));
    txt1.setFont(new Font("Times New Roman",Font.PLAIN,19));
    add(img);
    img.setBounds(10,50,300,300);
    
    add(loan1);
    add(sp);
    setBackground(new Color(173,216,230)); 
  }
 
 
 }
