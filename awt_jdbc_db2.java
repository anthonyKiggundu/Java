import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;

public class editPane extends JFrame implements WindowListener, ActionListener
{
    	JButton btnLogin;
     	JButton btnExit;
     	JLabel LblError;
     	JPasswordField JTxtPass;
     	JTextField JTxtUname;
     	JLabel LblUname;
     	JLabel LblPass;
     	
     private String t;
	private String q;
	private String x;
	private String user = "dis";
	private String word = "anton";
	protected final static String LOGIN =  "Login";
	
     
   public editPane()
   {
     getContentPane().setLayout(null);
     setupGUI();
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   void setupGUI()
   {
    btnLogin = new JButton();
	btnLogin.setLocation(200,107);
	btnLogin.setSize(107,29);
	btnLogin.setText("Login");
	getContentPane().add(btnLogin);
	btnLogin.addActionListener(this);

	btnExit = new JButton();
	btnExit.setLocation(320,107);
	btnExit.setSize(107,29);
	btnExit.setText("Exit");
	getContentPane().add(btnExit);
	btnExit.addActionListener(this);


	LblError = new JLabel();
	LblError.setLocation(200,151);
	LblError.setSize(236,29);
	LblError.setText("");
	getContentPane().add(LblError);

	JTxtPass = new JPasswordField();
	JTxtPass.setLocation(222,60);
	JTxtPass.setSize(179,29);
	JTxtPass.setText("");
	JTxtPass.setColumns(10);
	JTxtPass.setEchoChar('*');
	getContentPane().add(JTxtPass);

	JTxtUname = new JTextField();
	JTxtUname.setLocation(222,24);
	JTxtUname.setSize(178,29);
	JTxtUname.setText("");
	JTxtUname.setColumns(10);
	getContentPane().add(JTxtUname);

	LblUname = new JLabel();
	LblUname.setLocation(64,23);
	LblUname.setSize(137,29);
	LblUname.setText("  Username ");
	getContentPane().add(LblUname);

	LblPass = new JLabel();
	LblPass.setLocation(64,59);
	LblPass.setSize(137,29);
	LblPass.setText("  Password ");
	getContentPane().add(LblPass);

	setTitle("EMS Login");
	setSize(552,251);
	setVisible(true);
	setResizable(true);
	LblError.setText("Message");
	
   }

public void login()
	{
	  JFrame frame = new JFrame();
	  menuFrame mFrame = new menuFrame();
	  frame.setJMenuBar(mFrame.createMenu());
	  frame.setSize(500,700);
	  frame.setVisible(true);
	}
 

   public void actionPerformed(ActionEvent e) {
                                //Uname.setText("Button Clicked");
				if(e.getSource() == btnLogin)
					{
						t = JTxtUname.getText();
						q = JTxtPass.getText();
						
						
							if(t.length() == 0)
							{
								LblError.setText("Please Enter a Username");
								JTxtUname.requestFocus();
							}
							else if(q.length() == 0)
							{
								LblError.setText("Please enter a Passsword");
								JTxtPass.requestFocus();
							}
							else if((t.equals(user)) && (q.equals(word)))
							{
								LblError.setText("Login Successful");
								x = e.getActionCommand();
								  if(LOGIN.equals(x))
									{
									  login();
									   setVisible(false);
									}
							}							
							else
							{
								System.out.println("Username or Password in wrong");
								JTxtUname.requestFocus();
							}
	
					}
				else if(e.getSource() == btnExit)
					{
						//x="You are sure you want to exit?";
  						//int n = JOptionPane.showMessageDialog(null,x, JOptionPane.YES_NO_CANCEL_OPTION);
						dispose();
                				System.exit(0);
						

					}
        }

        public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
        }

		


        public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}

   
public static void main( String args[] )
   {
     new editPane();
   }
}  


class menuFrame extends JFrame implements WindowListener, ActionListener{
	public menuFrame()
	 {
		super("Estate Management System");
		addWindowListener(this);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
	 }
	public JMenuBar createMenu()
	 {
	  	JMenuBar menuBar;
		JMenu fileMenu,editMenu,viewMenu, fileSubmenu, subMenu, subMenu2, subMenu3;
		JMenuItem fileMenuItem, editMenuItem, viewMenuItem, subMenuItem1, subMenuItem2, subMenuItem3, subMenuItem4, subMenuItem5, subMenuItem6;
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(fileMenu);

		fileMenuItem = new JMenuItem("Add new Agent");
		fileMenuItem.addActionListener(this);
		fileMenu.add(fileMenuItem);
		
		subMenu = new JMenu("Add new Estate Object");
		subMenu.setMnemonic(KeyEvent.VK_S);
		subMenuItem1 = new JMenuItem("Add House");
		subMenuItem1.setAccelerator(KeyStroke.getKeyStroke(
                		KeyEvent.VK_2, ActionEvent.ALT_MASK));
		subMenuItem1.addActionListener(this);
		subMenu.add(subMenuItem1);
		
		subMenuItem2 = new JMenuItem("Add Apartment");
		subMenuItem2.setAccelerator(KeyStroke.getKeyStroke(
                		KeyEvent.VK_2, ActionEvent.ALT_MASK));
		subMenuItem2.addActionListener(this);
		subMenu.add(subMenuItem2);
		fileMenu.add(subMenu);
		
		
		fileMenu.addSeparator();
	
		fileMenuItem = new JMenuItem("Add new Customer");
		fileMenuItem.addActionListener(this);
		fileMenu.add(fileMenuItem);

		subMenu = new JMenu("Add new Contract");
		subMenu.setMnemonic(KeyEvent.VK_S);
		subMenuItem1 = new JMenuItem("Tenancy Contract");
		subMenuItem1.setAccelerator(KeyStroke.getKeyStroke(
                		KeyEvent.VK_2, ActionEvent.ALT_MASK));
		subMenuItem1.addActionListener(this);
		subMenu.add(subMenuItem1);
		
		subMenuItem2 = new JMenuItem("Purchase Contract");
		subMenuItem2.setAccelerator(KeyStroke.getKeyStroke(
                		KeyEvent.VK_2, ActionEvent.ALT_MASK));
		subMenuItem2.addActionListener(this);
		subMenu.add(subMenuItem2);
		fileMenu.add(subMenu);

		fileMenu.addSeparator();
		
		fileMenuItem = new JMenuItem("Exit EMS");
		fileMenuItem.addActionListener(this);
		fileMenu.add(fileMenuItem);

		//View menu code 
		viewMenu = new JMenu("View");
		viewMenu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(viewMenu);

		viewMenuItem = new JMenuItem("Estate Agents");
		viewMenuItem.addActionListener(this);
		viewMenu.add(viewMenuItem);

		viewMenuItem = new JMenuItem("Estates");
		viewMenuItem.addActionListener(this);
		viewMenu.add(viewMenuItem);
		
		viewMenu.addSeparator();
	
		viewMenuItem = new JMenuItem("View Customers");
		viewMenuItem.addActionListener(this);
		viewMenu.add(viewMenuItem);

		viewMenuItem = new JMenuItem("view Contracts");
		viewMenuItem.addActionListener(this);
		viewMenu.add(viewMenuItem);

		//Edit menu code 
		editMenu = new JMenu("Edit");
		editMenu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(editMenu);

		editMenuItem = new JMenuItem("Edit Estate Agents");
		editMenuItem.addActionListener(this);
		editMenu.add(editMenuItem);

		editMenuItem = new JMenuItem("Delete Agent");
		editMenuItem.addActionListener(this);
		editMenu.add(editMenuItem);
		
		editMenu.addSeparator();
		
		subMenu2 = new JMenu("Edit Estate");
		subMenu2.setMnemonic(KeyEvent.VK_S);
		subMenuItem5 = new JMenuItem("Edit House");
		subMenuItem5.setAccelerator(KeyStroke.getKeyStroke(
                		KeyEvent.VK_2, ActionEvent.ALT_MASK));
		subMenuItem5.addActionListener(this);
		subMenu2.add(subMenuItem5);
		
		subMenuItem6 = new JMenuItem("Edit Apartment");
		subMenuItem6.setAccelerator(KeyStroke.getKeyStroke(
                		KeyEvent.VK_2, ActionEvent.ALT_MASK));
		subMenuItem6.addActionListener(this);
		subMenu2.add(subMenuItem6);
		editMenu.add(subMenu2);
		
		subMenu3 = new JMenu("Delete Estate");
		subMenu3.setMnemonic(KeyEvent.VK_S);
		subMenuItem3 = new JMenuItem("Delete House");
		subMenuItem3.setAccelerator(KeyStroke.getKeyStroke(
                		KeyEvent.VK_2, ActionEvent.ALT_MASK));
		subMenuItem3.addActionListener(this);
		subMenu3.add(subMenuItem3);
		
		subMenuItem4 = new JMenuItem("Delete Apartment");
		subMenuItem4.setAccelerator(KeyStroke.getKeyStroke(
                		KeyEvent.VK_2, ActionEvent.ALT_MASK));
		subMenuItem4.addActionListener(this);
		subMenu3.add(subMenuItem4);
		editMenu.add(subMenu3);

		return menuBar;
	 }
	

 /*public registerAgents viewAgents()
	{
		String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://";
		String user="";
		String password="";
		Connection myCon = null;
		
		try {
			 Class.forName(jdbcClassName);
			// Hole Verbindung
			 myCon = DriverManager.getConnection(url, user, password);

			// Erzeuge Anfrage
			String selectSQL = "SELECT * FROM agents";
			PreparedStatement pstmt = myCon.prepareStatement(selectSQL);
			//pstmt.setInt(1, id);
			String myName, myAdd,myLog, myPass;

			// Führe Anfrage aus
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				registerAgents ts = new registerAgents();
				//ts.setId(id);
				myName = rs.getString("name");
				myAdd = rs.getString("address");
				myLog = rs.getString("login");
				myPass = rs.getString("password");
				
				/*ts.setName(rs.getString("JTxtUname"));
				ts.setAddress(rs.getString("JTxtaddress"));
				ts.setLogin(rs.getString("JTxtLogin"));
				ts.setPassword(rs.getString("JTxtPass"));
				System.out.println(myName);
				System.out.println(myAdd);
				System.out.println(myLog);
				System.out.println(myPass);
				
				rs.close();
				pstmt.close();
				//return ts;
				
			}
		} catch (ClassNotFoundException e) {
      	  e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
public void viewAgents(String loginName)
	  {
		  String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
			String url="jdbc:db2://";
			String user="";
			String password="";
			Connection myCon = null;
			
			try {
				 Class.forName(jdbcClassName);
				// Hole Verbindung
				 myCon = DriverManager.getConnection(url, user, password);

				// Erzeuge Anfrage
				String selectSQL = "SELECT * FROM agents WHERE login = ?";
				PreparedStatement pstmt = myCon.prepareStatement(selectSQL);
				pstmt.setString(1, loginName);
				pstmt.executeQuery();
				
				String myName, myAdd,myLog, myPass;

			
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					editAgent ts = new editAgent();
					//ts.setId(id);
					myName = rs.getString("name");
					myAdd = rs.getString("address");
					myLog = rs.getString("login");
					myPass = rs.getString("password");
					
					/*ts.setName(rs.getString("JTxtUname"));
					ts.setAddress(rs.getString("JTxtaddress"));
					ts.setLogin(rs.getString("JTxtLogin"));
					ts.setPassword(rs.getString("JTxtPass"));
					System.out.println(myName);
					System.out.println(myAdd);
					System.out.println(myLog);
					System.out.println(myPass);
					
					JTxtFullname.setText(myName);
				  	 JTxtAddress.setText(myAdd);  
				  	  JTxtNewLogin.setText(myLog);
				  	  JTxtPass.setText(myPass);
				  	 LblError.setText("Your records are above, edit and click update");
				  	 JTxtFullname.requestFocus();
					//rs.close();
					//pstmt.close();
					//return ts;
					
				}
			} catch (ClassNotFoundException e) {
	    	  e.printStackTrace();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			//return null;
	  }*/

    public void addAgents()
	{
	  JFrame frame = new JFrame();
	  registerAgents rAgents = new registerAgents();
	  rAgents.setTitle("Register Agents");
	  rAgents.setSize(487,350);
	  rAgents.setVisible(true);
	  rAgents.setResizable(false);
	}

   public void addApartment()
	{
	  JFrame frame = new JFrame();
	  newApartment nApart = new newApartment();
	  nApart.setTitle("Add new Apartment");
	  nApart.setSize(547,608);
	  nApart.setVisible(true);
	  nApart.setResizable(true);
	}

   public void addHouse()
	{
	  JFrame frame = new JFrame();
	  newHouse nHouse = new newHouse();
	  nHouse.setTitle("Add new House");
	  nHouse.setSize(547,529);
	  nHouse.setVisible(true);
	  nHouse.setResizable(true);
	}

    public void addCustomer()
	{
	  JFrame frame = new JFrame();
	  newCustomer nCustomer = new newCustomer();
	  nCustomer.setTitle("Add new Customer");
	  nCustomer.setSize(497,310);
	  nCustomer.setVisible(true);
	  nCustomer.setResizable(true);
	}
    public void addTenant()
    {
      JFrame frame = new JFrame();
  	  tenancyContract nTContract = new tenancyContract();
  	  nTContract.setTitle("New Tenancy Contract");
  	  nTContract.setSize(445,482);
  	  nTContract.setVisible(true);
  	  nTContract.setResizable(true);
    }
    public void nPContract()
    {
      JFrame frame = new JFrame();
  	  purchaseContract pContract = new purchaseContract();
  	  pContract.setTitle("New Purchase Contract");
  	  pContract.setSize(445,482);
  	  pContract.setVisible(true);
  	  pContract.setResizable(true);
    }
    
    public void myAgents()
    {
      JFrame frame = new JFrame();
  	  viewAgents agents = new viewAgents();
  	  agents.setTitle("Agents");
  	  agents.setSize(466,440);
  	  agents.setVisible(true);
  	  agents.setResizable(true);
    }
    
    public void removeAgent()
    {
      JFrame frame = new JFrame();
  	  DelAgent remAgent = new DelAgent();
  	  remAgent.setTitle("Delete Agent");
  	  remAgent.setSize(509,242);
  	  remAgent.setVisible(true);
  	  remAgent.setResizable(true);
    }
    
    public void removeHouse()
    {
      JFrame frame = new JFrame();
  	  deleteHouse remHouse = new deleteHouse();
  	  remHouse.setTitle("Delete Agent");
  	  remHouse.setSize(509,242);
  	  remHouse.setVisible(true);
  	  remHouse.setResizable(true);
    }
	
    public void updateAgents()
    {
      JFrame frame = new JFrame();
  	  editAgent upAgents = new editAgent();
  	  upAgents.setTitle("Update Agent Data");
  	  upAgents.setSize(466,440);
  	  upAgents.setVisible(true);
  	  upAgents.setResizable(true);
    }
	public void actionPerformed(ActionEvent e)
	 {
		JMenuItem source = (JMenuItem)(e.getSource());
		String y = source.getText();
		if (y == "Add new Agent")
		  {
			addAgents();
			setVisible(false);
		  }
		else if (y == "Add Apartment")
		  {
			addApartment();
			setVisible(false);
		  }
		else if (y == "Add House")
		  {
			addHouse();
			setVisible(false);
		  }
		else if (y == "Add new Customer")
		  {
			addCustomer();
			setVisible(false);
		  }
		else if (y == "Tenancy Contract")
		  {
			addTenant();
			setVisible(false);
		  }
		else if (y == "Purchase Contract")
		  {
			nPContract();
			setVisible(false);
		  }
		else if (y == "Exit EMS")
		  {
			dispose();
			System.exit(0);
		  }
		else if (y == "Estate Agents")
		  {
			myAgents();
			setVisible(false);
		  }
		/*else if (y == "Estates")
		  {
			estates();
			setVisible(false);
		  }
		else if (y == "View Customers")
		  {
			viewCustomers();
			setVisible(false);
		  }
		else if (y == "View Contracts")
		  {
			viewContracts();
			setVisible(false);
		  }
		else if (y == "Edit Estate Agents")
		  {
			editAgents();
			setVisible(false);
		  } */
		else if (y == "Delete Agent")
		  {
			removeAgent();
			setVisible(false);
		  }
		else if (y == "Edit Estate Agents")
		  {
			updateAgents();
			setVisible(false);
		  }
		/*else if (y == "Edit House")
		  {
			editEstate();
			setVisible(false);
		  }
		else if (y == "Edit Apartment")
		  {
			editApartment();
			setVisible(false);
		  } */
		else if (y == "Delete House")
		  {
			removeHouse();
			setVisible(false);
		  }
		/*else
		  {
			delApartment();
			setVisible(false);
		  }*/
	 }

 	public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
        } 

    	public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}
}

class registerAgents extends JFrame implements WindowListener, ActionListener
{
    JLabel fnam;
     JTextField JTxtname ;
     JLabel add;
     JTextField JTxtaddress;
     JLabel logi;
     JTextField JTxtLogin;
     JLabel password;
     JPasswordField JTxtPass;
     JButton btnSave;
     JButton btnReset;
     JButton btnCancel;
     String i,j,k,n;
    
 	/*public void setAddress(String JTxtaddress) {
		this.JTxtaddress = JTxtaddress;
	}
	
	public void setName(String JTxtUname) {
		thisJTxtUname = JTxtUname;
	}
	
	public void setLogin(String JTxtLogin) {
		this.JTxtLogin = JTxtLogin;
	}
	
	public void setPassword(String JTxtPass) {
		this.JTxtPass = JTxtPass;
	}*/
	
   public registerAgents()
   {
     getContentPane().setLayout(null);
     setupGUI();
     addWindowListener(this);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   void setupGUI()
   {
     	fnam = new JLabel();
	fnam.setLocation(27,29);
	fnam.setSize(101,29);
	fnam.setText("  Full name ");
	getContentPane().add(fnam);

	JTxtname  = new JTextField();
	JTxtname .setLocation(163,29);
	JTxtname .setSize(183,29);
	JTxtname .setText("");
	JTxtname .setColumns(10);
	getContentPane().add(JTxtname );

	add = new JLabel();
	add.setLocation(28,74);
	add.setSize(100,29);
	add.setText("  Address ");
	getContentPane().add(add);

	JTxtaddress = new JTextField();
	JTxtaddress.setLocation(163,76);
	JTxtaddress.setSize(183,29);
	JTxtaddress.setText("");
	JTxtaddress.setColumns(10);
	getContentPane().add(JTxtaddress);

	logi = new JLabel();
	logi.setLocation(27,122);
	logi.setSize(100,29);
	logi.setText("  Login ");
	getContentPane().add(logi);

	JTxtLogin = new JTextField();
	JTxtLogin.setLocation(163,122);
	JTxtLogin.setSize(183,29);
	JTxtLogin.setText("");
	JTxtLogin.setColumns(10);
	getContentPane().add(JTxtLogin);

	password = new JLabel();
	password.setLocation(27,167);
	password.setSize(100,29);
	password.setText(" Password ");
	getContentPane().add(password);

	JTxtPass = new JPasswordField();
	JTxtPass.setLocation(163,168);
	JTxtPass.setSize(183,29);
	JTxtPass.setText("nopass");
	JTxtPass.setColumns(10);
	JTxtPass.setEchoChar('*');
	getContentPane().add(JTxtPass);

	btnSave = new JButton();
	btnSave.setLocation(83,225);
	btnSave.setSize(100,30);
	btnSave.setText("Save Data");
	getContentPane().add(btnSave);
	btnSave.addActionListener(this);

	btnReset = new JButton();
	btnReset.setLocation(194,226);
	btnReset.setSize(100,30);
	btnReset.setText("Reset Field");
	getContentPane().add(btnReset);
	btnReset.addActionListener(this);

	btnCancel = new JButton();
	btnCancel.setLocation(306,226);
	btnCancel.setSize(100,30);
	btnCancel.setText("Cancel");
	getContentPane().add(btnCancel);
	btnCancel.addActionListener(this);

		
	
   }
   public void actionPerformed(ActionEvent e)
	 {
	   if(e.getSource() == btnSave)
		{
			 i = JTxtname.getText();
			 j = JTxtaddress.getText();
			 k = JTxtLogin.getText();
			 n = JTxtPass.getText();
			
				if((i.length() == 0) || (j.length() == 0) || (k.length() == 0) || (n.length() == 0))
				{
					System.out.println("Please Fill in all the Fields");
					JTxtname.requestFocus();
				}
				else {
					saveAgents(i,j,k,n);
				     }							
				
		}
	else if(e.getSource() == btnCancel)
		{
			setVisible(false);
		}
	else
	   {
		 JTxtname.setText("");
		 JTxtaddress.setText("");
		 JTxtLogin.setText("");
		 JTxtPass.setText("");
		}
		
	}

public void saveAgents(String p, String d, String c, String u)
	{
	 	String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
        	String url="jdbc:db2://";
        	String user="";
        	String password="";
 
        	Connection myCon = null;
        	
        	try {
            		//Load class into memory
            		Class.forName(jdbcClassName);
            		//Establish connection
            		myCon = DriverManager.getConnection(url, user, password);
 			String insertSQL = "INSERT INTO agents(name, address, login, password) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = myCon.prepareStatement(insertSQL);

				pstmt.setString(1, p);
				pstmt.setString(2, d);
				pstmt.setString(3, c);
				pstmt.setString(4, u);
				int num = pstmt.executeUpdate(); 

				// Hole die Id des engefC<gten Datensatzes
				/*ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					setId(rs.getInt(1));
				}*/

				//rs.close();
				pstmt.close();
				//LblError.setText("Data successfully saved");
        	} catch (ClassNotFoundException e) {
            	  e.printStackTrace();
        	} catch (SQLException e) {
            	  e.printStackTrace();
        	} 
		
	}

     public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
        } 

	public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}
}  


class newApartment extends JFrame implements ActionListener, WindowListener
{
    JLabel lblApartI;
     JLabel LblCit;
     JLabel Lblostcode;
     JLabel LblStree;
     JLabel LblStrnu;
     JLabel LblSqAre;
     JLabel LblFloor;
     JLabel LbPrice;
     JLabel LblRoom;
     JLabel LblBalcon;
     JLabel LblKitchen;
     JTextField JTxtApartID;
     JTextField JTxtCity;
     JTextField JTxtPostcode;
     JTextField JTxtStreet;
     JTextField JTxtStrNum;
     JTextField JTxtSqArea;
     JTextField JTxtFloor;
     JTextField JTxtPrice;
     JTextField JTxtRoom;
     JTextField JTxtBalcony;
     JTextField JTxtKitchen;
     JButton btnSave;
     JButton btnReset;
     JLabel LblError;
     
   public newApartment()
   {
     getContentPane().setLayout(null);
     setupGUI();
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   void setupGUI()
   {
     	lblApartI = new JLabel();
	lblApartI.setLocation(17,25);
	lblApartI.setSize(100,30);
	lblApartI.setText("Apartment ID");
	getContentPane().add(lblApartI);

	LblCit = new JLabel();
	LblCit.setLocation(15,65);
	LblCit.setSize(100,30);
	LblCit.setText("City");
	getContentPane().add(LblCit);

	Lblostcode = new JLabel();
	Lblostcode.setLocation(16,104);
	Lblostcode.setSize(100,30);
	Lblostcode.setText("Post Code");
	getContentPane().add(Lblostcode);

	LblStree = new JLabel();
	LblStree.setLocation(16,142);
	LblStree.setSize(100,30);
	LblStree.setText("Street");
	getContentPane().add(LblStree);

	LblStrnu = new JLabel();
	LblStrnu.setLocation(17,181);
	LblStrnu.setSize(100,30);
	LblStrnu.setText("Street Number");
	getContentPane().add(LblStrnu);

	LblSqAre = new JLabel();
	LblSqAre.setLocation(17,219);
	LblSqAre.setSize(100,30);
	LblSqAre.setText("Sqaure Area");
	getContentPane().add(LblSqAre);

	LblFloor = new JLabel();
	LblFloor.setLocation(17,258);
	LblFloor.setSize(100,30);
	LblFloor.setText("Floor");
	getContentPane().add(LblFloor);

	LbPrice = new JLabel();
	LbPrice.setLocation(18,297);
	LbPrice.setSize(100,30);
	LbPrice.setText("Price");
	getContentPane().add(LbPrice);

	LblRoom = new JLabel();
	LblRoom.setLocation(19,335);
	LblRoom.setSize(100,30);
	LblRoom.setText("Rooms");
	getContentPane().add(LblRoom);

	LblBalcon = new JLabel();
	LblBalcon.setLocation(19,373);
	LblBalcon.setSize(100,30);
	LblBalcon.setText("Balcony ");
	getContentPane().add(LblBalcon);

	LblKitchen = new JLabel();
	LblKitchen.setLocation(19,410);
	LblKitchen.setSize(100,29);
	LblKitchen.setText("Kitchen");
	getContentPane().add(LblKitchen);

	JTxtApartID = new JTextField();
	JTxtApartID.setLocation(153,25);
	JTxtApartID.setSize(191,29);
	JTxtApartID.setText("");
	JTxtApartID.setColumns(10);
	getContentPane().add(JTxtApartID);

	JTxtCity = new JTextField();
	JTxtCity.setLocation(155,65);
	JTxtCity.setSize(191,29);
	JTxtCity.setText("");
	JTxtCity.setColumns(10);
	getContentPane().add(JTxtCity);

	/*JTxtCit = new JTextField();
	JTxtCit.setLocation(155,65);
	JTxtCit.setSize(191,29);
	JTxtCit.setText("");
	JTxtCit.setColumns(10);
	getContentPane().add(JTxtCit);

	JTxtCit = new JTextField();
	JTxtCit.setLocation(155,65);
	JTxtCit.setSize(191,29);
	JTxtCit.setText("");
	JTxtCit.setColumns(10);
	getContentPane().add(JTxtCit);*/

	JTxtPostcode = new JTextField();
	JTxtPostcode.setLocation(155,105);
	JTxtPostcode.setSize(191,29);
	JTxtPostcode.setText("");
	JTxtPostcode.setColumns(10);
	getContentPane().add(JTxtPostcode);

	/*JTxtPostcod = new JTextField();
	JTxtPostcod.setLocation(155,105);
	JTxtPostcod.setSize(191,29);
	JTxtPostcod.setText("");
	JTxtPostcod.setColumns(10);
	getContentPane().add(JTxtPostcod);*/

	JTxtStreet = new JTextField();
	JTxtStreet.setLocation(154,143);
	JTxtStreet.setSize(191,29);
	JTxtStreet.setText("");
	JTxtStreet.setColumns(10);
	getContentPane().add(JTxtStreet);

	JTxtStrNum = new JTextField();
	JTxtStrNum.setLocation(153,183);
	JTxtStrNum.setSize(191,29);
	JTxtStrNum.setText("");
	JTxtStrNum.setColumns(10);
	getContentPane().add(JTxtStrNum);

	JTxtSqArea = new JTextField();
	JTxtSqArea.setLocation(153,219);
	JTxtSqArea.setSize(191,29);
	JTxtSqArea.setText("");
	JTxtSqArea.setColumns(10);
	getContentPane().add(JTxtSqArea);

	JTxtFloor = new JTextField();
	JTxtFloor.setLocation(153,260);
	JTxtFloor.setSize(191,29);
	JTxtFloor.setText("");
	JTxtFloor.setColumns(10);
	getContentPane().add(JTxtFloor);

	JTxtPrice = new JTextField();
	JTxtPrice.setLocation(153,297);
	JTxtPrice.setSize(191,29);
	JTxtPrice.setText("");
	JTxtPrice.setColumns(10);
	getContentPane().add(JTxtPrice);

	JTxtRoom = new JTextField();
	JTxtRoom.setLocation(154,336);
	JTxtRoom.setSize(191,29);
	JTxtRoom.setText("");
	JTxtRoom.setColumns(10);
	getContentPane().add(JTxtRoom);

	JTxtBalcony = new JTextField();
	JTxtBalcony.setLocation(154,375);
	JTxtBalcony.setSize(193,29);
	JTxtBalcony.setText("");
	JTxtBalcony.setColumns(10);
	getContentPane().add(JTxtBalcony);

	JTxtKitchen = new JTextField();
	JTxtKitchen.setLocation(154,410);
	JTxtKitchen.setSize(193,29);
	JTxtKitchen.setText("");
	JTxtKitchen.setColumns(10);
	getContentPane().add(JTxtKitchen);
	
	btnSave = new JButton();
	btnSave.setLocation(135,473);
	btnSave.setSize(106,30);
	btnSave.setText("Save Data");
	btnSave.addActionListener(this);
	getContentPane().add(btnSave);

	btnReset = new JButton();
	btnReset.setLocation(254,473);
	btnReset.setSize(111,30);
	btnReset.setText("Reset Fields");
	btnReset.addActionListener(this);
	getContentPane().add(btnReset);

	LblError = new JLabel();
	LblError.setLocation(135,490);
	LblError.setSize(200,60);
	LblError.setText("Your errors shown here");
	getContentPane().add(LblError);

	
	
   }

    public void actionPerformed(ActionEvent e)
	 {
	   if(e.getSource() == btnSave)
		{
			String i = JTxtApartID.getText();
			String j = JTxtPostcode.getText();
			String k = JTxtStreet.getText();
			String n = JTxtStrNum.getText();
			String a = JTxtFloor.getText();
			String b = JTxtRoom.getText();
			String c = JTxtPrice.getText();
			String d = JTxtSqArea.getText();
			String f = JTxtCity.getText();	
			String q = JTxtBalcony.getText();
			String g = JTxtKitchen.getText();	
			
				if((i.length() == 0) || (j.length() == 0) || (k.length() == 0) || (n.length() == 0) || (a.length() == 0) || (b.length() == 0) || (c.length() == 0) || (d.length() == 0) || (f.length() == 0) || (q.length() == 0) || (g.length() == 0))
				{
					LblError.setText("Please Fill in all the Fields");
					JTxtApartID.requestFocus();
				}
				else {
					saveApartment(i,f,j,k,n,d,a,c,b,q,g);
				}							
				
		}
	else if(e.getSource() == btnReset)
		{
		 JTxtApartID.setText("");
		 JTxtPostcode.setText("");
		 JTxtStreet.setText("");
		 JTxtStrNum.setText("");
		 JTxtFloor.setText("");
		 JTxtRoom.setText("");
		 JTxtPrice.setText("");
		 JTxtSqArea.setText("");
 		 JTxtCity.setText("");	
 		JTxtBalcony.setText("");
		 JTxtKitchen.setText("");	

		}
	/*else
	   {
		 
		} */
		
	}
    
    public void saveApartment(String p, String d, String c, String u, String h, String r, String m, String w, String v, String y, String z)
	{
	 	String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
     	String url="jdbc:db2://";
     	String user="";
     	String password="";

     	Connection myCon = null;
     	
     	try {
         		//Load class into memory
         		Class.forName(jdbcClassName);
         		//Establish connection
         		myCon = DriverManager.getConnection(url, user, password);
         		System.out.println("Connection successfull");
         		System.out.println(p);
         		System.out.println(d);
         		System.out.println(c);
         		System.out.println(u);
         		System.out.println(h);
         		System.out.println(r);
         		System.out.println(m);
         		System.out.println(w);
         		System.out.println(v);
			String insertSQL = "INSERT INTO apartments(apart_id, city, postal_code, street, street_num,sq_area, floor, price, rooms, balcony, kitchen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = myCon.prepareStatement(insertSQL);

				pstmt.setString(1, p);
				pstmt.setString(2, d);
				pstmt.setString(3, c);
				pstmt.setString(4, u);
				pstmt.setString(5, h);
				pstmt.setString(6, r);
				pstmt.setString(7, m);
				pstmt.setString(8, w);
				pstmt.setString(9, v);
				pstmt.setString(10, y);
				pstmt.setString(11, z);
				int num = pstmt.executeUpdate(); 
				
				// Hole die Id des engefC<gten Datensatzes
				/*ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					setId(rs.getInt(1));
				}*/
				
				//rs.close();
				pstmt.close();
				//LblError.setText("Data successfully saved");
     	} catch (ClassNotFoundException e) {
         	  e.printStackTrace();
     	} catch (SQLException e) {
         	  e.printStackTrace();
     	} 
     	LblError.setText("Click Reset to make another entry");	
	}

     public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
        } 

	public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}
} 




class newHouse extends JFrame implements ActionListener, WindowListener
{
    JLabel lblHousID;
     JLabel LblCit;
     JLabel Lblostcode;
     JLabel LblStree;
     JLabel LblStrnu;
     JLabel LblSqAre;
     JLabel LblFloors;
     JLabel LbPrice;
     JLabel LblGarde;
     JTextField JTxtHouseID;
     JTextField JTxtCity;
     JTextField JTxtPostcode;
     JTextField JTxtStreet;
     JTextField JTxtStrNum;
     JTextField JTxtSqArea;
     JTextField JTxtFloor;
     JTextField JTxtPrice;
     JTextField JTxtGarden;
     JButton btnSave;
     JButton btnReset;
     JLabel LblError;
     
   public newHouse()
   {
     getContentPane().setLayout(null);
     setupGUI();
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   void setupGUI()
   {
     	lblHousID = new JLabel();
	lblHousID.setLocation(17,25);
	lblHousID.setSize(100,30);
	lblHousID.setText("House ID ");
	getContentPane().add(lblHousID);

	LblCit = new JLabel();
	LblCit.setLocation(15,65);
	LblCit.setSize(100,30);
	LblCit.setText("City");
	getContentPane().add(LblCit);

	Lblostcode = new JLabel();
	Lblostcode.setLocation(16,104);
	Lblostcode.setSize(100,30);
	Lblostcode.setText("Post Code");
	getContentPane().add(Lblostcode);

	LblStree = new JLabel();
	LblStree.setLocation(16,142);
	LblStree.setSize(100,30);
	LblStree.setText("Street");
	getContentPane().add(LblStree);

	LblStrnu = new JLabel();
	LblStrnu.setLocation(17,181);
	LblStrnu.setSize(100,30);
	LblStrnu.setText("Street Number");
	getContentPane().add(LblStrnu);

	LblSqAre = new JLabel();
	LblSqAre.setLocation(17,219);
	LblSqAre.setSize(100,30);
	LblSqAre.setText("Sqaure Area");
	getContentPane().add(LblSqAre);

	LblFloors = new JLabel();
	LblFloors.setLocation(17,258);
	LblFloors.setSize(100,30);
	LblFloors.setText("Floors");
	getContentPane().add(LblFloors);

	LbPrice = new JLabel();
	LbPrice.setLocation(18,297);
	LbPrice.setSize(100,30);
	LbPrice.setText("Price");
	getContentPane().add(LbPrice);

	LblGarde = new JLabel();
	LblGarde.setLocation(18,339);
	LblGarde.setSize(100,29);
	LblGarde.setText("Garden");
	getContentPane().add(LblGarde);

	JTxtHouseID = new JTextField();
	JTxtHouseID.setLocation(153,25);
	JTxtHouseID.setSize(191,29);
	JTxtHouseID.setText("");
	JTxtHouseID.setColumns(10);
	getContentPane().add(JTxtHouseID);

	

	JTxtCity = new JTextField();
	JTxtCity.setLocation(155,65);
	JTxtCity.setSize(191,29);
	JTxtCity.setText("");
	JTxtCity.setColumns(10);
	getContentPane().add(JTxtCity);

	
	JTxtPostcode = new JTextField();
	JTxtPostcode.setLocation(154,105);
	JTxtPostcode.setSize(191,29);
	JTxtPostcode.setText("");
	JTxtPostcode.setColumns(10);
	getContentPane().add(JTxtPostcode);

	JTxtStreet = new JTextField();
	JTxtStreet.setLocation(154,143);
	JTxtStreet.setSize(191,29);
	JTxtStreet.setText("");
	JTxtStreet.setColumns(10);
	getContentPane().add(JTxtStreet);

	JTxtStrNum = new JTextField();
	JTxtStrNum.setLocation(153,183);
	JTxtStrNum.setSize(191,29);
	JTxtStrNum.setText("");
	JTxtStrNum.setColumns(10);
	getContentPane().add(JTxtStrNum);

	JTxtSqArea = new JTextField();
	JTxtSqArea.setLocation(153,219);
	JTxtSqArea.setSize(191,29);
	JTxtSqArea.setText("");
	JTxtSqArea.setColumns(10);
	getContentPane().add(JTxtSqArea);

	JTxtFloor = new JTextField();
	JTxtFloor.setLocation(153,260);
	JTxtFloor.setSize(191,29);
	JTxtFloor.setText("");
	JTxtFloor.setColumns(10);
	getContentPane().add(JTxtFloor);

	JTxtPrice = new JTextField();
	JTxtPrice.setLocation(153,297);
	JTxtPrice.setSize(191,29);
	JTxtPrice.setText("");
	JTxtPrice.setColumns(10);
	getContentPane().add(JTxtPrice);

	JTxtGarden = new JTextField();
	JTxtGarden.setLocation(152,340);
	JTxtGarden.setSize(193,29);
	JTxtGarden.setText("");
	JTxtGarden.setColumns(10);
	getContentPane().add(JTxtGarden);


	btnSave = new JButton();
	btnSave.setLocation(118,423);
	btnSave.setSize(106,30);
	btnSave.setText("Save Data");
	btnSave.addActionListener(this);
	getContentPane().add(btnSave);

	btnReset = new JButton();
	btnReset.setLocation(247,423);
	btnReset.setSize(111,30);
	btnReset.setText("Reset Fields");
	btnReset.addActionListener(this);
	getContentPane().add(btnReset);

	LblError = new JLabel();
	LblError.setLocation(118,440);
	LblError.setSize(200,60);
	LblError.setText("");
	getContentPane().add(LblError);

	
	
	
   }
 public void actionPerformed(ActionEvent e)
	 {
	   if(e.getSource() == btnSave)
		{
			String i = JTxtHouseID.getText();
			String j = JTxtPostcode.getText();
			String k = JTxtStreet.getText();
			String n = JTxtStrNum.getText();
			String a = JTxtFloor.getText();
			String b = JTxtGarden.getText();
			String c = JTxtPrice.getText();
			String d = JTxtSqArea.getText();
			String f = JTxtCity.getText();	
			
				if((i.length() == 0) || (j.length() == 0) || (k.length() == 0) || (n.length() == 0) || (a.length() == 0) || (c.length() == 0) || (d.length() == 0) || (f.length() == 0) ||(b.length() == 0))
				{
					LblError.setText("Please Fill in all the Fields");
					JTxtHouseID.requestFocus();
				}
				else {
						saveHouse(i,f,j,k,n,d,a,c,b);
					}							
				
		}
	else if(e.getSource() == btnReset)
		{
		 JTxtHouseID.setText("");
		 JTxtPostcode.setText("");
		 JTxtStreet.setText("");
		 JTxtStrNum.setText("");
		 JTxtFloor.setText("");
		 //JTxtRoom.setText("");
		 JTxtPrice.setText("");
		 JTxtSqArea.setText("");
 		 JTxtCity.setText("");
 		 JTxtGarden.setText("");

		}
	/*else
	   {
		 
		} */
		
	}
 
 public void saveHouse(String p, String d, String c, String u, String h, String r, String m, String w, String v)
	{
	 	String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
     	String url="jdbc:db2://";
     	String user="";
     	String password="";

     	Connection myCon = null;
     	
     	try {
         		//Load class into memory
         		Class.forName(jdbcClassName);
         		//Establish connection
         		myCon = DriverManager.getConnection(url, user, password);
         		System.out.println("Connection successfull");
         		System.out.println(p);
         		System.out.println(d);
         		System.out.println(c);
         		System.out.println(u);
         		System.out.println(h);
         		System.out.println(r);
         		System.out.println(m);
         		System.out.println(w);
         		System.out.println(v);
			String insertSQL = "INSERT INTO houses(house_id, city, postal_code, street, street_num,sq_area, floors, price, garden) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = myCon.prepareStatement(insertSQL);

				pstmt.setString(1, p);
				pstmt.setString(2, d);
				pstmt.setString(3, c);
				pstmt.setString(4, u);
				pstmt.setString(5, h);
				pstmt.setString(6, r);
				pstmt.setString(7, m);
				pstmt.setString(8, w);
				pstmt.setString(9, v);
				int num = pstmt.executeUpdate(); 
				
				// Hole die Id des engefC<gten Datensatzes
				/*ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					setId(rs.getInt(1));
				}*/
				
				//rs.close();
				pstmt.close();
				//LblError.setText("Data successfully saved");
     	} catch (ClassNotFoundException e) {
         	  e.printStackTrace();
     	} catch (SQLException e) {
         	  e.printStackTrace();
     	} 
     	LblError.setText("Click Reset to make another entry");
	}

   public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
        } 

	public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}
    
}  


class newCustomer extends JFrame implements ActionListener, WindowListener
{
    JButton btnSave;
     JButton btnReset;
     JTextField JTxtFname;
     JLabel LbFname;
     JLabel LblLname;
     JTextField JTxtLname;
     JTextField JTxtAddress;
     JLabel LblAddress;
     JLabel LblError;
     
   public newCustomer()
   {
     getContentPane().setLayout(null);
     setupGUI();
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   void setupGUI()
   {
     	btnSave = new JButton();
	btnSave.setLocation(120,159);
	btnSave.setSize(106,29);
	btnSave.setText("Save Data");
	getContentPane().add(btnSave);
	btnSave.addActionListener(this);

	btnReset = new JButton();
	btnReset.setLocation(241,160);
	btnReset.setSize(113,29);
	btnReset.setText("Reset");
	getContentPane().add(btnReset);
	btnReset.addActionListener(this);

	JTxtFname = new JTextField();
	JTxtFname.setLocation(211,27);
	JTxtFname.setSize(173,27);
	JTxtFname.setText("");
	JTxtFname.setColumns(10);
	getContentPane().add(JTxtFname);

	LbFname = new JLabel();
	LbFname.setLocation(59,27);
	LbFname.setSize(129,25);
	LbFname.setText("   First name");
	getContentPane().add(LbFname);

	LblLname = new JLabel();
	LblLname.setLocation(59,63);
	LblLname.setSize(130,25);
	LblLname.setText("    Last name");
	getContentPane().add(LblLname);

	JTxtLname = new JTextField();
	JTxtLname.setLocation(211,63);
	JTxtLname.setSize(171,27);
	JTxtLname.setText("");
	JTxtLname.setColumns(10);
	getContentPane().add(JTxtLname);

	JTxtAddress = new JTextField();
	JTxtAddress.setLocation(211,99);
	JTxtAddress.setSize(172,27);
	JTxtAddress.setText("");
	JTxtAddress.setColumns(10);
	getContentPane().add(JTxtAddress);

	LblAddress = new JLabel();
	LblAddress.setLocation(59,99);
	LblAddress.setSize(130,25);
	LblAddress.setText("    Address ");
	getContentPane().add(LblAddress);

	LblError = new JLabel();
	LblError .setLocation(90,207);
	LblError .setSize(300,36);
	LblError .setText("No_Label");
	getContentPane().add(LblError );

	setTitle("New Customer");
	setSize(497,310);
	setVisible(true);
	setResizable(true);
	
	
   }
   
   public void actionPerformed(ActionEvent e)
	 {
	   if(e.getSource() == btnSave)
		{
			String i = JTxtFname.getText();
			String j = JTxtLname.getText();
			String k = JTxtAddress.getText();
			
			
				if((i.length() == 0) || (j.length() == 0) || (k.length() == 0))
				{
					LblError.setText("Please Fill in all the Fields");
					JTxtFname.requestFocus();
				}
				else {
					/*System.out.println("Login Successful");
					x = e.getActionCommand();
					  if(LOGIN.equals(x))
						{
						  login();
						   setVisible(false);
						}*/
				}							
				
		}
	else if(e.getSource() == btnReset)
		{
		 JTxtFname.setText("");
		 JTxtLname.setText("");
		 JTxtAddress.setText("");
		 

		}
	/*else
	   {
		 
		} */
		
	}

   
   public void windowClosing(WindowEvent e) {
       dispose();
       System.exit(0);
   } 

public void windowOpened(WindowEvent e) {}
public void windowActivated(WindowEvent e) {}
public void windowIconified(WindowEvent e) {}
public void windowDeiconified(WindowEvent e) {}
public void windowDeactivated(WindowEvent e) {}
public void windowClosed(WindowEvent e) {}
    
}  
 

class tenancyContract extends JFrame implements WindowListener, ActionListener
{
    JLabel LblContractID;
     JLabel LblStarDate;
     JLabel LblPlace;
     JLabel LblOthers;
     JLabel LblEndDate;
     JTextField JTxtContractID;
     JTextField JTxtStartDate;
     JTextField JTxtEndDate;
     JTextField JTxtPlace;
     JTextField JTxtOthers;
     JButton btnSave;
     JButton btnReset;
     JLabel LblError;
     String i,j,k,n,q;
     
   public tenancyContract()
   {
     getContentPane().setLayout(null);
     setupGUI();
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   void setupGUI()
   {
     	LblContractID = new JLabel();
	LblContractID.setLocation(21,45);
	LblContractID.setSize(127,27);
	LblContractID.setText("     Contract ID ");
	getContentPane().add(LblContractID);

	LblStarDate = new JLabel();
	LblStarDate.setLocation(20,83);
	LblStarDate.setSize(129,27);
	LblStarDate.setText("     Start Date ");
	getContentPane().add(LblStarDate);

	LblPlace = new JLabel();
	LblPlace.setLocation(19,157);
	LblPlace.setSize(129,27);
	LblPlace.setText("      Place");
	getContentPane().add(LblPlace);

	LblOthers = new JLabel();
	LblOthers.setLocation(17,194);
	LblOthers.setSize(131,29);
	LblOthers.setText("     Other Costs");
	getContentPane().add(LblOthers);

	LblEndDate = new JLabel();
	LblEndDate.setLocation(19,119);
	LblEndDate.setSize(130,27);
	LblEndDate.setText("      End Date");
	getContentPane().add(LblEndDate);

	JTxtContractID = new JTextField();
	JTxtContractID.setLocation(181,44);
	JTxtContractID.setSize(163,27);
	JTxtContractID.setText("");
	JTxtContractID.setColumns(10);
	getContentPane().add(JTxtContractID);

	JTxtStartDate = new JTextField();
	JTxtStartDate.setLocation(181,83);
	JTxtStartDate.setSize(163,27);
	JTxtStartDate.setText("");
	JTxtStartDate.setColumns(10);
	getContentPane().add(JTxtStartDate);

	JTxtEndDate = new JTextField();
	JTxtEndDate.setLocation(181,121);
	JTxtEndDate.setSize(162,27);
	JTxtEndDate.setText("");
	JTxtEndDate.setColumns(10);
	getContentPane().add(JTxtEndDate);

	JTxtPlace = new JTextField();
	JTxtPlace.setLocation(181,158);
	JTxtPlace.setSize(162,27);
	JTxtPlace.setText("");
	JTxtPlace.setColumns(10);
	getContentPane().add(JTxtPlace);

	JTxtOthers = new JTextField();
	JTxtOthers.setLocation(182,196);
	JTxtOthers.setSize(161,27);
	JTxtOthers.setText("");
	JTxtOthers.setColumns(10);
	getContentPane().add(JTxtOthers);

	btnSave = new JButton();
	btnSave.setLocation(74,257);
	btnSave.setSize(103,34);
	btnSave.setText("Save Data");
	getContentPane().add(btnSave);
	btnSave.addActionListener(this);

	btnReset = new JButton();
	btnReset.setLocation(202,257);
	btnReset.setSize(112,34);
	btnReset.setText("Reset");
	getContentPane().add(btnReset);
	btnReset.addActionListener(this);
	
	LblError = new JLabel();
	LblError.setLocation(74,280);
	LblError.setSize(151,60);
	LblError.setText("");
	getContentPane().add(LblError);

	
	
   }
   
public void actionPerformed(ActionEvent e)
	 {
	   if(e.getSource() == btnSave)
		{
			i = JTxtContractID.getText();
			j = JTxtStartDate.getText();
			k = JTxtEndDate.getText();
			n = JTxtPlace.getText();
			q = JTxtOthers.getText();
			
			
				if((i.length() == 0) || (j.length() == 0) || (k.length() == 0) || (n.length() == 0) || (q.length() == 0))
				{
					LblError.setText("Please Fill in all the Fields");
					JTxtContractID.requestFocus();
				}
				else {
						saveContract(i,j,k,n,q);
						LblError.setText("Click the Reset Button to add another record");
					}							
				
		}
	else if(e.getSource() == btnReset)
		{
			JTxtContractID.setText("");
			JTxtStartDate.setText("");
			JTxtEndDate.setText("");
			JTxtPlace.setText("");
			JTxtOthers.setText("");
			JTxtContractID.requestFocus();
		}
	else
	   {
		 
		} 
		
	}

   public void saveContract(String g, String v, String y, String f, String j)
   {
	   String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
   		String url="jdbc:db2://";
   		String user="";
   		String password="";

   		Connection myCon = null;
   	
   	try {
       		//Load class into memory
       		Class.forName(jdbcClassName);
       		//Establish connection
       		myCon = DriverManager.getConnection(url, user, password);
       		//Fill in the right table fields
		String insertSQL = "INSERT INTO tContract(lastname, address, login, password) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = myCon.prepareStatement(insertSQL);

			pstmt.setString(1, g);
			pstmt.setString(2, v);
			pstmt.setString(3, y);
			pstmt.setString(4, f);
			pstmt.setString(4, j);
			int num = pstmt.executeUpdate(); 

			// Hole die Id des engefC<gten Datensatzes
			/*ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				setId(rs.getInt(1));
			}*/

			//rs.close();
			pstmt.close();
			//LblError.setText("Data successfully saved");
   	} catch (ClassNotFoundException e) {
       	  e.printStackTrace();
   	} catch (SQLException e) {
       	  e.printStackTrace();
   	} 
   }
   public void windowClosing(WindowEvent e) {
       dispose();
       System.exit(0);
   } 

public void windowOpened(WindowEvent e) {}
public void windowActivated(WindowEvent e) {}
public void windowIconified(WindowEvent e) {}
public void windowDeiconified(WindowEvent e) {}
public void windowDeactivated(WindowEvent e) {}
public void windowClosed(WindowEvent e) {setVisible(false);}
    
}  

class purchaseContract extends JFrame implements ActionListener
{
    JLabel LblContractID;
     JLabel LblDate;
     JLabel LblPlace;
     JLabel LblInstallments;
     JLabel LblInterestRate;
     JTextField JTxtContractID;
     JTextField JTxtDate;
     JTextField JTxtInstallments;
     JTextField JTxtPlace;
     JTextField JTxtInterestRate;
     JButton btnSave;
     JButton btnReset;
     JButton btnClose;
     JLabel LblError;
     String i,j,k,n,q;
     
   public purchaseContract()
   {
     getContentPane().setLayout(null);
     setupGUI();
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   void setupGUI()
   {
     	LblContractID = new JLabel();
	LblContractID.setLocation(21,45);
	LblContractID.setSize(127,27);
	LblContractID.setText("     Contract ID ");
	getContentPane().add(LblContractID);

	LblDate = new JLabel();
	LblDate.setLocation(20,83);
	LblDate.setSize(129,27);
	LblDate.setText("     Date ");
	getContentPane().add(LblDate);

	LblPlace = new JLabel();
	LblPlace.setLocation(19,157);
	LblPlace.setSize(129,27);
	LblPlace.setText("      Place");
	getContentPane().add(LblPlace);

	LblInstallments = new JLabel();
	LblInstallments.setLocation(17,194);
	LblInstallments.setSize(131,29);
	LblInstallments.setText("     Other Costs");
	getContentPane().add(LblInstallments);

	LblInterestRate = new JLabel();
	LblInterestRate.setLocation(19,119);
	LblInterestRate.setSize(130,27);
	LblInterestRate.setText("      End Date");
	getContentPane().add(LblInterestRate);

	JTxtContractID = new JTextField();
	JTxtContractID.setLocation(181,44);
	JTxtContractID.setSize(163,27);
	JTxtContractID.setText("");
	JTxtContractID.setColumns(10);
	getContentPane().add(JTxtContractID);

	JTxtDate = new JTextField();
	JTxtDate.setLocation(181,83);
	JTxtDate.setSize(163,27);
	JTxtDate.setText("");
	JTxtDate.setColumns(10);
	getContentPane().add(JTxtDate);

	JTxtInstallments = new JTextField();
	JTxtInstallments.setLocation(181,121);
	JTxtInstallments.setSize(162,27);
	JTxtInstallments.setText("");
	JTxtInstallments.setColumns(10);
	getContentPane().add(JTxtInstallments);

	JTxtPlace = new JTextField();
	JTxtPlace.setLocation(181,158);
	JTxtPlace.setSize(162,27);
	JTxtPlace.setText("");
	JTxtPlace.setColumns(10);
	getContentPane().add(JTxtPlace);

	JTxtInterestRate = new JTextField();
	JTxtInterestRate.setLocation(182,196);
	JTxtInterestRate.setSize(161,27);
	JTxtInterestRate.setText("");
	JTxtInterestRate.setColumns(10);
	getContentPane().add(JTxtInterestRate);

	btnSave = new JButton();
	btnSave.setLocation(60,257);
	btnSave.setSize(90,34);
	btnSave.setText("Save Data");
	getContentPane().add(btnSave);
	btnSave.addActionListener(this);

	btnReset = new JButton();
	btnReset.setLocation(170,257);
	btnReset.setSize(90,34);
	btnReset.setText("Reset");
	getContentPane().add(btnReset);
	btnReset.addActionListener(this);
	
	btnClose = new JButton();
	btnClose.setLocation(280,257);
	btnClose.setSize(100,34);
	btnClose.setText("Close Form");
	getContentPane().add(btnClose);
	btnClose.addActionListener(this);
	
	LblError = new JLabel();
	LblError.setLocation(74,280);
	LblError.setSize(151,60);
	LblError.setText("");
	getContentPane().add(LblError);

	
	
   }
   
public void actionPerformed(ActionEvent e)
	 {
	   if(e.getSource() == btnSave)
		{
			i = JTxtContractID.getText();
			j = JTxtDate.getText();
			k = JTxtInstallments.getText();
			n = JTxtPlace.getText();
			q = JTxtInterestRate.getText();
			
			
				if((i.length() == 0) || (j.length() == 0) || (k.length() == 0) || (n.length() == 0) || (q.length() == 0))
				{
					LblError.setText("Please Fill in all the Fields");
					JTxtContractID.requestFocus();
				}
				else {
						saveContract(i,j,k,n,q);
						LblError.setText("Click the Reset Button to add another record");
					}							
				
		}
	else if(e.getSource() == btnReset)
		{
			JTxtContractID.setText("");
			JTxtDate.setText("");
			JTxtInstallments.setText("");
			JTxtPlace.setText("");
			JTxtInterestRate.setText("");
			JTxtContractID.requestFocus();
		}
	else if(e.getSource()== btnClose)
	   {
		 setVisible(false);
		} 
		
	}

   public void saveContract(String g, String v, String y, String f, String j)
   {
	   String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
  		String url="jdbc:db2://";
  		String user="";
  		String password="";

  		Connection myCon = null;
  	
  	try {
      		//Load class into memory
      		Class.forName(jdbcClassName);
      		//Establish connection
      		myCon = DriverManager.getConnection(url, user, password);
      		//Fill in the right table fields
		String insertSQL = "INSERT INTO pContract(lastname, address, login, password) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = myCon.prepareStatement(insertSQL);

			pstmt.setString(1, g);
			pstmt.setString(2, v);
			pstmt.setString(3, y);
			pstmt.setString(4, f);
			pstmt.setString(4, j);
			int num = pstmt.executeUpdate(); 

			// Hole die Id des engefC<gten Datensatzes
			/*ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				setId(rs.getInt(1));
			}*/

			//rs.close();
			pstmt.close();
			//LblError.setText("Data successfully saved");
  	} catch (ClassNotFoundException e) {
      	  e.printStackTrace();
  	} catch (SQLException e) {
      	  e.printStackTrace();
  	} 
 }
   
    
}

class DelAgent extends JFrame implements ActionListener
{
    JButton btnDelete;
     JLabel LblAgent;
     JButton btnCancel;
     JTextField JTxtAgentID;
     JLabel LblError;
     String delLogin;
     
   public DelAgent()
   {
     getContentPane().setLayout(null);
     setupGUI();
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   void setupGUI()
   {
     	btnDelete = new JButton();
     	btnDelete.setLocation(150,88);
     	btnDelete.setSize(79,29);
     	btnDelete.setText("  Delete ");
	    getContentPane().add(btnDelete);
	    btnDelete.addActionListener(this);

	LblAgent = new JLabel();
	LblAgent.setLocation(14,35);
	LblAgent.setSize(108,29);
	LblAgent.setText("    Enter Agent ID ");
	getContentPane().add(LblAgent);

	btnCancel = new JButton();
	btnCancel.setLocation(238,88);
	btnCancel.setSize(86,29);
	btnCancel.setText("Cancel");
	getContentPane().add(btnCancel);
	btnCancel.addActionListener(this);

	JTxtAgentID = new JTextField();
	JTxtAgentID.setLocation(149,34);
	JTxtAgentID.setSize(176,30);
	JTxtAgentID.setText("");
	JTxtAgentID.setColumns(10);
	getContentPane().add(JTxtAgentID);

	LblError = new JLabel();
	LblError.setLocation(150,145);
	LblError.setSize(177,26);
	LblError.setText("");
	getContentPane().add(LblError);

	
	
	
   }
   
   public void actionPerformed(ActionEvent e)
   {
	   delLogin = JTxtAgentID.getText();
	    if(e.getSource() == btnCancel)
	    {
	    	setVisible(false);
	    }
	    else
	    {
	    	deleteAgent(delLogin);
	    }	
   }
   
  public void deleteAgent(String loginName)
  {
	  String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
  	String url="";
  	String user="";
  	String password="";
  	
  	Connection myCon = null;
  	
  	try {
      		//Load class into memory
      		Class.forName(jdbcClassName);
      		//Establish connection
      		myCon = DriverManager.getConnection(url, user, password);
      		String deleteSQL = "DELETE FROM agents WHERE login = ?";
      		PreparedStatement pstmt = myCon.prepareStatement(deleteSQL);
      		pstmt = myCon.prepareStatement(deleteSQL); 
      		pstmt.setString(1, loginName);
      		pstmt.executeUpdate();
      		LblError.setText("Agent successfully deleted..");
      		JTxtAgentID.setText("");
		
			pstmt.close();
			//LblError.setText("Data successfully saved");
  	} catch (ClassNotFoundException e) {
      	  e.printStackTrace();
  	} catch (SQLException e) {
      	  e.printStackTrace();
  	} 
 }
      
}  

class deleteHouse extends JFrame implements ActionListener
{
    JButton btnDelete;
     JLabel LblEstate;
     JButton btnCancel;
     JTextField JTxtHouseID;
     JLabel LblError;
     String delLogin;
     
   public deleteHouse()
   {
     getContentPane().setLayout(null);
     setupGUI();
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   void setupGUI()
   {
     	btnDelete = new JButton();
     	btnDelete.setLocation(150,88);
     	btnDelete.setSize(79,29);
     	btnDelete.setText("  Delete ");
	    getContentPane().add(btnDelete);
	    btnDelete.addActionListener(this);

	LblEstate = new JLabel();
	LblEstate.setLocation(14,35);
	LblEstate.setSize(108,29);
	LblEstate.setText("    Enter House ID ");
	getContentPane().add(LblEstate);

	btnCancel = new JButton();
	btnCancel.setLocation(238,88);
	btnCancel.setSize(86,29);
	btnCancel.setText("Cancel");
	getContentPane().add(btnCancel);
	btnCancel.addActionListener(this);

	JTxtHouseID = new JTextField();
	JTxtHouseID.setLocation(149,34);
	JTxtHouseID.setSize(176,30);
	JTxtHouseID.setText("");
	JTxtHouseID.setColumns(10);
	getContentPane().add(JTxtHouseID);

	LblError = new JLabel();
	LblError.setLocation(150,145);
	LblError.setSize(177,26);
	LblError.setText("");
	getContentPane().add(LblError);

		
   }
   
   public void actionPerformed(ActionEvent e)
   {
	   delLogin = JTxtHouseID.getText();
	    if(e.getSource() == btnCancel)
	    {
	    	setVisible(false);
	    }
	    else
	    {
	    	delHouse(delLogin);
	    }	
   }
   
  public void delHouse(String loginName)
  {
	  String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
  	String url="jdbc:db2://";
  	String user="";
  	String password="";
  	
  	Connection myCon = null;
  	
  	try {
      		//Load class into memory
      		Class.forName(jdbcClassName);
      		//Establish connection
      		myCon = DriverManager.getConnection(url, user, password);
      		String deleteSQL = "DELETE FROM houses WHERE loginName = ?";
      		PreparedStatement pstmt = myCon.prepareStatement(deleteSQL);
      		pstmt = myCon.prepareStatement(deleteSQL); 
      		pstmt.setString(1, loginName);
      		pstmt.executeUpdate();
      		LblError.setText("House successfully deleted..");
      		JTxtHouseID.setText("");
		
			pstmt.close();
			//LblError.setText("Data successfully saved");
  	} catch (ClassNotFoundException e) {
      	  e.printStackTrace();
  	} catch (SQLException e) {
      	  e.printStackTrace();
  	} 
 }
      
}  


class updateAgents extends JFrame implements ActionListener
{
	JButton btnUpdate;
  JLabel LblLogin;
  JButton btnCancel;
  JTextField JTxtLogin;
  JLabel LblError;
  JTextField JTxtFullname;
  JLabel Lblame;
  JTextField JTxtAddress;
  JLabel LblAddress;
  JTextField JTxtNewLogin;
  JLabel LblPass;
  JLabel LblCurrent;
  JPasswordField JTxtPass;
  JButton btnFind;
  
  
  String loginName;
  	  
	    
public updateAgents()
{
  getContentPane().setLayout(null);
  setupGUI();
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
void setupGUI()
{
  	btnUpdate = new JButton();
  	btnUpdate.setLocation(152,274);
  	btnUpdate.setSize(85,28);
  	btnUpdate.setText("Update Data");
	getContentPane().add(btnUpdate);
	btnUpdate.addActionListener(this);

	LblLogin = new JLabel();
	LblLogin.setLocation(17,25);
	LblLogin.setSize(180,25);
	LblLogin.setText("    Enter the Agent's Login Code ");
	getContentPane().add(LblLogin);

	btnCancel = new JButton();
	btnCancel.setLocation(245,273);
	btnCancel.setSize(83,29);
	btnCancel.setText("Cancel");
	getContentPane().add(btnCancel);
	btnCancel.addActionListener(this);

	JTxtLogin = new JTextField();
	JTxtLogin.setLocation(207,25);
	JTxtLogin.setSize(117,25);
	JTxtLogin.setText("");
	JTxtLogin.setColumns(10);
	getContentPane().add(JTxtLogin);

	LblError = new JLabel();
	LblError.setLocation(120,318);
	LblError.setSize(250,26);
	LblError.setText("");
	getContentPane().add(LblError);

	JTxtFullname = new JTextField();
	JTxtFullname.setLocation(149,119);
	JTxtFullname.setSize(176,28);
	JTxtFullname.setText("");
	JTxtFullname.setColumns(10);
	getContentPane().add(JTxtFullname);

	Lblame = new JLabel();
	Lblame.setLocation(18,120);
	Lblame.setSize(114,27);
	Lblame.setText("  Full name ");
	getContentPane().add(Lblame);

	JTxtAddress = new JTextField();
	JTxtAddress.setLocation(151,155);
	JTxtAddress.setSize(175,26);
	JTxtAddress.setText("");
	JTxtAddress.setColumns(10);
	getContentPane().add(JTxtAddress);

	LblAddress = new JLabel();
	LblAddress.setLocation(19,155);
	LblAddress.setSize(113,25);
	LblAddress.setText("  Address ");
	getContentPane().add(LblAddress);

	LblLogin = new JLabel();
	LblLogin.setLocation(19,189);
	LblLogin.setSize(113,25);
	LblLogin.setText("  Login ");
	getContentPane().add(LblLogin);

	JTxtNewLogin = new JTextField();
	JTxtNewLogin.setLocation(150,190);
	JTxtNewLogin.setSize(175,25);
	JTxtNewLogin.setText("");
	JTxtNewLogin.setColumns(10);
	getContentPane().add(JTxtNewLogin);

	LblPass = new JLabel();
	LblPass.setLocation(20,223);
	LblPass.setSize(113,25);
	LblPass.setText("  Password ");
	getContentPane().add(LblPass);

	LblCurrent = new JLabel();
	LblCurrent.setLocation(17,66);
	LblCurrent.setSize(191,30);
	LblCurrent.setText("");
	getContentPane().add(LblCurrent);

	JTxtPass = new JPasswordField();
	JTxtPass.setLocation(150,223);
	JTxtPass.setSize(175,25);
	JTxtPass.setText("");
	JTxtPass.setColumns(10);
	JTxtPass.setEchoChar('*');
	getContentPane().add(JTxtPass);
	
	btnFind = new JButton();
	btnFind.setLocation(214,66);
	btnFind.setSize(110,30);
	btnFind.setText("Find Record");
	getContentPane().add(btnFind);
	btnFind.addActionListener(this);


	
	
}

	
  
public void actionPerformed(ActionEvent e)
{
	  	String j = JTxtFullname.getText();
		 String k = JTxtAddress.getText();  
		 String x = JTxtNewLogin.getText();
		 String i = JTxtPass.getText();
	  	 loginName = JTxtLogin.getText();
	  	 
	    if(e.getSource() == btnCancel)
	    {
	    	setVisible(false);
	    }
	    else if(e.getSource() == btnFind)
	    {
	    	findAgent(loginName);
	    }	
	    else if(e.getSource() == btnUpdate)
	    {
	    	//updateAgent(j,k,x,i);
	    }
	    else
	    {
	    	LblError.setText("ID cannot be found");
	    	JTxtLogin.requestFocus();
	    }
} 


public void findAgent(String loginName)
{
	  String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://";
		String user="";
		String password="";
		Connection myCon = null;
		
		try {
			 Class.forName(jdbcClassName);
			// Hole Verbindung
			 myCon = DriverManager.getConnection(url, user, password);

			// Erzeuge Anfrage
			String selectSQL = "SELECT * FROM agents WHERE login = ?";
			PreparedStatement pstmt = myCon.prepareStatement(selectSQL);
			pstmt.setString(1, loginName);
			pstmt.executeQuery();
			
			String myName, myAdd,myLog, myPass;

		
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				updateAgents ts = new updateAgents();
				//ts.setId(id);
				myName = rs.getString("name");
				myAdd = rs.getString("address");
				myLog = rs.getString("login");
				myPass = rs.getString("password");
				
				/*ts.setName(rs.getString("JTxtUname"));
				ts.setAddress(rs.getString("JTxtaddress"));
				ts.setLogin(rs.getString("JTxtLogin"));
				ts.setPassword(rs.getString("JTxtPass"));
				System.out.println(myName);
				System.out.println(myAdd);
				System.out.println(myLog);
				System.out.println(myPass);*/
				
				JTxtFullname.setText(myName);
			  	 JTxtAddress.setText(myAdd);  
			  	  JTxtNewLogin.setText(myLog);
			  	  JTxtPass.setText(myPass);
			  	 LblError.setText(" Click update to Edit Data");
			  	 JTxtFullname.requestFocus();
				//rs.close();
				//pstmt.close();
				//return ts;
				
			}
		} catch (ClassNotFoundException e) {
  	  e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		//return null;
	}

}  


class editAgent extends JFrame implements ActionListener
{
	JButton btnUpdate;
    JLabel LblLogin;
    JButton btnCancel;
    JTextField JTxtLogin;
    JLabel LblError;
    JTextField JTxtFullname;
    JLabel Lblame;
    JTextField JTxtAddress;
    JLabel LblAddress;
    JTextField JTxtNewLogin;
    JLabel LblPass;
    JLabel LblCurrent;
    JPasswordField JTxtPass;
    JButton btnFind;
    
    
    String loginName;
    	  
 	    
  public editAgent()
  {
    getContentPane().setLayout(null);
    setupGUI();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  void setupGUI()
  {
    	btnUpdate = new JButton();
    	btnUpdate.setLocation(152,274);
    	btnUpdate.setSize(85,28);
    	btnUpdate.setText("Update Data");
	getContentPane().add(btnUpdate);
	btnUpdate.addActionListener(this);

	LblLogin = new JLabel();
	LblLogin.setLocation(17,25);
	LblLogin.setSize(180,25);
	LblLogin.setText("    Enter the Agent's Login Code ");
	getContentPane().add(LblLogin);

	btnCancel = new JButton();
	btnCancel.setLocation(245,273);
	btnCancel.setSize(83,29);
	btnCancel.setText("Cancel");
	getContentPane().add(btnCancel);
	btnCancel.addActionListener(this);

	JTxtLogin = new JTextField();
	JTxtLogin.setLocation(207,25);
	JTxtLogin.setSize(117,25);
	JTxtLogin.setText("");
	JTxtLogin.setColumns(10);
	getContentPane().add(JTxtLogin);

	LblError = new JLabel();
	LblError.setLocation(120,318);
	LblError.setSize(250,26);
	LblError.setText("");
	getContentPane().add(LblError);

	JTxtFullname = new JTextField();
	JTxtFullname.setLocation(149,119);
	JTxtFullname.setSize(176,28);
	JTxtFullname.setText("");
	JTxtFullname.setColumns(10);
	getContentPane().add(JTxtFullname);

	Lblame = new JLabel();
	Lblame.setLocation(18,120);
	Lblame.setSize(114,27);
	Lblame.setText("  Full name ");
	getContentPane().add(Lblame);

	JTxtAddress = new JTextField();
	JTxtAddress.setLocation(151,155);
	JTxtAddress.setSize(175,26);
	JTxtAddress.setText("");
	JTxtAddress.setColumns(10);
	getContentPane().add(JTxtAddress);

	LblAddress = new JLabel();
	LblAddress.setLocation(19,155);
	LblAddress.setSize(113,25);
	LblAddress.setText("  Address ");
	getContentPane().add(LblAddress);

	LblLogin = new JLabel();
	LblLogin.setLocation(19,189);
	LblLogin.setSize(113,25);
	LblLogin.setText("  Login ");
	getContentPane().add(LblLogin);

	JTxtNewLogin = new JTextField();
	JTxtNewLogin.setLocation(150,190);
	JTxtNewLogin.setSize(175,25);
	JTxtNewLogin.setText("");
	JTxtNewLogin.setColumns(10);
	getContentPane().add(JTxtNewLogin);

	LblPass = new JLabel();
	LblPass.setLocation(20,223);
	LblPass.setSize(113,25);
	LblPass.setText("  Password ");
	getContentPane().add(LblPass);

	LblCurrent = new JLabel();
	LblCurrent.setLocation(17,66);
	LblCurrent.setSize(191,30);
	LblCurrent.setText("");
	getContentPane().add(LblCurrent);

	JTxtPass = new JPasswordField();
	JTxtPass.setLocation(150,223);
	JTxtPass.setSize(175,25);
	JTxtPass.setText("");
	JTxtPass.setColumns(10);
	JTxtPass.setEchoChar('*');
	getContentPane().add(JTxtPass);
	
	btnFind = new JButton();
	btnFind.setLocation(214,66);
	btnFind.setSize(110,30);
	btnFind.setText("Find Record");
	getContentPane().add(btnFind);
	btnFind.addActionListener(this);

	
	
  }
  
	
   
    
  public void actionPerformed(ActionEvent e)
  {
	  String j = JTxtFullname.getText();
		 String k = JTxtAddress.getText();  
		 String x = JTxtNewLogin.getText();
		 String i = JTxtPass.getText();
	  	 loginName = JTxtLogin.getText();
	  	 
	    if(e.getSource() == btnCancel)
	    {
	    	setVisible(false);
	    }
	    else if(e.getSource() == btnFind)
	    {
	    	findAgent(loginName);
	    }	
	    else if(e.getSource() == btnUpdate)
	    {
	    	updateAgent(j,k,x,i);
	    }
	    else
	    {
	    	LblError.setText("ID cannot be found");
	    	JTxtLogin.requestFocus();
	    }
  } 
  
  public void updateAgent(String y, String p, String q, String r)
  {
	  String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
	  	String url="jdbc:db2://";
	  	String user="";
	  	String password="";
	  	
	  	Connection myCon = null;
	  	Statement stmt;
	  	ResultSet rs;
	  	
	  	try {
	      		//Load class into memory
	      		Class.forName(jdbcClassName);
	      		//Establish connection
	      		myCon = DriverManager.getConnection(url, user, password);
	      		//String selectSQL = "SELECT * FROM agents WHERE loginName = ?";
	      		System.out.println(y);
	      		System.out.println(p);
	      		System.out.println(q);
	      		System.out.println(r);
	      		String updateSQL = "UPDATE agents SET name = ?, address = ?, login = ?, password = ? WHERE login = ?";
	      		PreparedStatement pstmt = myCon.prepareStatement(updateSQL);
	      		pstmt = myCon.prepareStatement(updateSQL); 
	      		
	      		//pstmt.executeUpdate();
	      		
				// Setze Anfrage Parameter
				pstmt.setString(1, y);
				pstmt.setString(2, p);
				pstmt.setString(3, q);
				pstmt.setString(4, r);
				pstmt.setString(5, loginName);
				int num = pstmt.executeUpdate();

				pstmt.close();
	      		LblError.setText("Update Successful..");
	      		
		} catch (ClassNotFoundException e) {
	      	  e.printStackTrace();
	  	} catch (SQLException e) {
	      	  e.printStackTrace();
	  	} 
	  	
	  	  	
  }
  
  public void findAgent(String loginName)
  {
	  String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://";
		String user="";
		String password="";
		Connection myCon = null;
		
		try {
			 Class.forName(jdbcClassName);
			// Hole Verbindung
			 myCon = DriverManager.getConnection(url, user, password);

			// Erzeuge Anfrage
			String selectSQL = "SELECT * FROM agents WHERE login = ?";
			PreparedStatement pstmt = myCon.prepareStatement(selectSQL);
			pstmt.setString(1, loginName);
			pstmt.executeQuery();
			
			String myName, myAdd,myLog, myPass;

		
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				editAgent ts = new editAgent();
				//ts.setId(id);
				myName = rs.getString("name");
				myAdd = rs.getString("address");
				myLog = rs.getString("login");
				myPass = rs.getString("password");
				
				/*ts.setName(rs.getString("JTxtUname"));
				ts.setAddress(rs.getString("JTxtaddress"));
				ts.setLogin(rs.getString("JTxtLogin"));
				ts.setPassword(rs.getString("JTxtPass"));
				System.out.println(myName);
				System.out.println(myAdd);
				System.out.println(myLog);
				System.out.println(myPass);*/
				
				JTxtFullname.setText(myName);
			  	 JTxtAddress.setText(myAdd);  
			  	  JTxtNewLogin.setText(myLog);
			  	  JTxtPass.setText(myPass);
			  	 LblError.setText("Your records are above, edit and click update");
			  	 JTxtFullname.requestFocus();
				//rs.close();
				//pstmt.close();
				//return ts;
				
			}
		} catch (ClassNotFoundException e) {
    	  e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		//return null;
  }
  
        
}  
