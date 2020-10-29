import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;


import javax.swing.JLabel;


public class StartWindow {

	private JFrame frmHello;
	//private String DeptName;
	public SqlTry sqlo;
	public Vector<DeptData> AllDept; 
	
	//BufferedImage image = ImageIO.read(new File("G:\\b2\\102APPLE\\IMG_4487.png"));
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.setProperty("sun.io.serialization.extendedDebugInfo", "true");

		EventQueue.invokeLater(new Runnable() {
			public void run() {
			
				try {
					StartWindow win = new StartWindow();
					win.frmHello.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}finally
				{
					System.out.println("finally here");
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHello = new JFrame();
		frmHello.getContentPane().setBackground(Color.WHITE);
		frmHello.getContentPane().setLayout(null);
		frmHello.setResizable(false);
		//frmHello.getl
		sqlo=new SqlTry();
		AllDept=new Vector<DeptData>();
		
		try {
			sqlo.OpenDB();
			sqlo.createNameTable();
			sqlo.Read_Pname(this);
//			linkEntities();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmHello.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowClosingDemo.windowClosing");
                
                int v=JOptionPane.showConfirmDialog(frmHello, "Save Data ?", "WARNING",
                        JOptionPane.YES_NO_OPTION);
                if ( v== JOptionPane.YES_OPTION) 
                {
                	try {
						sqlo.wObj(AllDept);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                	sqlo.closeCon();
                	System.exit(0);

                }
                else if(v == JOptionPane.NO_OPTION)
                {
                	sqlo.closeCon();
                	System.exit(0);

                }
                else
                {}
                
            }
        });
		
		TranslucentButton btnNewProject = new TranslucentButton("New Project");           // button 1
		btnNewProject.setBorderPainted(false);
		btnNewProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				NewDetail m=new NewDetail(frmHello,sqlo,AllDept); 
				frmHello.setVisible(false);		
				m.setVisible(true);
				
			}
		});
		btnNewProject.setForeground(new Color(0, 0, 0));
		btnNewProject.setBackground(new Color(238, 232, 170));
		btnNewProject.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewProject.setBounds(201, 121, 184, 59);
		frmHello.getContentPane().add(btnNewProject);
		
		TranslucentButton btnNewButton = new TranslucentButton("Import Project");			// button 2
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(339, 74, 100, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				importRead();
				
			}
		});
		btnNewButton.setForeground(new Color(0, 0 ,0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton.setBounds(201, 210, 184, 59);
		frmHello.getContentPane().add(btnNewButton);
		
		TranslucentButton btnGuideLines = new TranslucentButton("Guide Lines");				// button 3
		btnGuideLines.setBorderPainted(false);
		btnGuideLines.addActionListener(new ActionListener() {   
			
			public void actionPerformed(ActionEvent arg0) {
		
				GuideL gl=new GuideL(frmHello,sqlo);
			    gl.setVisible(true);
			    frmHello.setVisible(false);
			    
			}
		});
		btnGuideLines.setForeground(new Color(0, 0 ,0));
		btnGuideLines.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnGuideLines.setBounds(201, 289, 184, 59);
		frmHello.getContentPane().add(btnGuideLines);
		

		frmHello.setBounds(400, 100, 600, 500);
		frmHello.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    
		TranslucentButton btnNewButton_1 = new TranslucentButton("About Project");
		btnNewButton_1.setBorderPainted(false);
		/*btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		AboutUS abu=new AboutUS(frmHello,sqlo);
			    abu.setVisible(true);
			    frmHello.setVisible(false);
	    		
	    	}
	    });*/
	    btnNewButton_1.setForeground(new Color(0, 0 ,0));
	    btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	    btnNewButton_1.setBounds(425, 415, 149, 35);
	    frmHello.getContentPane().add(btnNewButton_1);
	
		
		frmHello.getContentPane().add(btnNewProject);
		frmHello.getContentPane().add(btnNewButton_1);
		frmHello.getContentPane().add(btnGuideLines);
		frmHello.getContentPane().add(btnNewButton);
		

		JLabel lblNewLabel_1 = new JLabel("<html><center>"+"WorkLoad Distribution and Time Table Creator"+"</center></html>");
		lblNewLabel_1.setToolTipText("Work Load Distribution and \r\n\tTimeTable Creator");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1.setBounds(87, 22, 399, 84);
		frmHello.getContentPane().add(lblNewLabel_1);
	
		
		
		
		
		
		ImageIcon imageIcon = new ImageIcon("rr.jpg"); // load the image to a imageIcon
		Image image1 = imageIcon.getImage(); // transform it 
		Image newimg = image1.getScaledInstance(700, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setBounds(0, 0, 600, 500);
		frmHello.getContentPane().add(lblNewLabel);
		
		
	}
	
	
	void importRead()
	{
		
		//String P_name= ask user
		int i,j=AllDept.size();
		
		if(j==0) {JOptionPane.showMessageDialog(this.frmHello,"NO Projects Created..!"); return ;}
		String[] sA=new String[j+1];
		
		sA[0]="Select Any One";
		for(i=1;i<j+1;i++)
		{
			sA[i]=AllDept.get(i-1).departN;
		}
		
		Object selection = JOptionPane.showInputDialog(this.frmHello, "Select Any One",
				        "Saved Projects", JOptionPane.QUESTION_MESSAGE, null, sA, sA[0]);
		
		if(sA[0].equals(selection) || selection==null)
		{
			System.out.println("Something wrong");
			return ;
			
		}
	
		DeptData dtd=null;
		try {
			dtd=selectDept((String)selection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ;
		}
		if(dtd==null)
		  {
			System.out.println("Error Select Dept");
			return;
		  }
		Menu m=new Menu(frmHello,dtd,sqlo,AllDept);
		m.setVisible(true);
		frmHello.setVisible(false);		

	}
	
	void linkEntities()
	{
		DeptData TTemp=null;
		int i,j=AllDept.size();
		int p,q;
		
		for(i=0;i<j;i++)
		{
		
			TTemp =AllDept.get(i);
			q=TTemp.rooms.size();
			
			for(p=0;p<q;p++)
			{
				
				if( !TTemp.departN.equals(TTemp.rooms.get(p).FarDeptName))
				{
					Room rTemp=TTemp.rooms.get(p);
					int P_idx=getProjIDX(rTemp.FarDeptName);
					if(P_idx==-1) {return;}
					int R_idx=getRoomIDX(P_idx,rTemp.Rname);
					if(R_idx==-1) {return;}
					Room cRTemp=AllDept.get(P_idx).rooms.get(R_idx);
					rTemp.available=cRTemp.available;
					rTemp.T_T=cRTemp.T_T;
					rTemp.aflag=cRTemp.aflag;
					
				}
			}
			
			q=TTemp.Lrooms.size();
			
			for(p=0;p<q;p++)
			{
				if(!TTemp.departN.equals(TTemp.Lrooms.get(p).FarDeptName))
				{
					
					Room rTemp=TTemp.Lrooms.get(p);
					int P_idx=getProjIDX(rTemp.FarDeptName);
					if(P_idx==-1) {return;}
					int L_idx=getLabIDX(P_idx,rTemp.Rname);
					if(L_idx==-1) {return;}
					Room cRTemp=AllDept.get(P_idx).Lrooms.get(L_idx);
					rTemp.available=cRTemp.available;
					rTemp.T_T=cRTemp.T_T;
					rTemp.aflag=cRTemp.aflag;
					
				}
			}
			
			q=TTemp.teachers.size();
			
			for(p=0;p<q;p++)
			{
			
				if(!TTemp.departN.equals(TTemp.teachers.get(p).FarDeptName))
				{
					Teacher rTemp=TTemp.teachers.get(p);
					int P_idx=getProjIDX(rTemp.FarDeptName);
					if(P_idx==-1) {return;}
					int T_idx=getTeacherIDX(P_idx, rTemp.name);
					if(T_idx==-1) {return;}
					Teacher crTemp=AllDept.get(P_idx).teachers.get(T_idx);
					rTemp.aflag=crTemp.aflag;
					rTemp.available=crTemp.available;
					rTemp.T_T=crTemp.T_T;
					rTemp.ideal=crTemp.ideal;
					
					
				}
			}
			
		}
			
	}
	
	int getProjIDX(String Pnam)
	{
		int i,j=AllDept.size();
		
				for(i=0;i<j;i++)
				{
					if(Pnam.equals(AllDept.get(i).departN))
					{
						return i;
					}
				}
		
		return -1;
	}
	
	int getRoomIDX(int P_idx,String rname)
	{
		DeptData TTemp=AllDept.get(P_idx);
		int i,j=TTemp.rooms.size();
		
		for(i=0;i<j;i++)
		{
			if(rname.equals(TTemp.rooms.get(i).Rname))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	int getLabIDX(int P_idx,String lname)
	{
		DeptData TTemp=AllDept.get(P_idx);
		int i,j=TTemp.Lrooms.size();
		
		for(i=0;i<j;i++)
		{
			if(lname.equals(TTemp.Lrooms.get(i).Rname))
			{
				return i;
			}
		}
		
		
		return -1;
	}
	
	int getTeacherIDX(int P_idx,String Tname)
	{
		DeptData TTemp=AllDept.get(P_idx);
		int i,j=TTemp.teachers.size();
		
		for(i=0;i<j;i++)
		{
			if(Tname.equals(TTemp.teachers.get(i).name))
			{
				return i;
			}
			
		}
		
		return -1;
	}
	
	@Override  
    public void finalize()   
    {   
		sqlo.closeCon();
        System.out.println("finalize method called");   
    }   
	
	DeptData selectDept(String sng)
	{
		int i,j=AllDept.size();
		DeptData Dtemp=null;
	  for(i=0;i<j;i++)
	  {
		  if(sng.equals(AllDept.get(i).departN))
		  {
			  Dtemp=AllDept.get(i);
		  }
	  }

	  
		  return Dtemp;
		
	}
	
	
}


/*class ImageLabel extends JLabel {

	  public ImageLabel(String img) {
	    this(new ImageIcon(img));
	  }

	  public ImageLabel(ImageIcon icon) {
	    setIcon(icon);
	    // setMargin(new Insets(0,0,0,0));
	    setIconTextGap(0);
	    // setBorderPainted(false);
	    setBorder(null);
	    setText(null);
	    setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
	  }

	}
*/