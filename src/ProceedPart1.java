import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class ProceedPart1 extends JFrame {

	private JPanel contentPane;
    private Menu prev;
    private DeptData dd;
	private Boolean bb;
	public Vector<DeptData> AllDept;
	
    JComboBox PSpCBox,AllowedCB,PSpTCBoc,TnameCBox,LecCRCB;
    JList Sublist;
    private JTable PracTimeTable;
    SqlTry sO;
    
    
	public ProceedPart1(Menu m,DeptData ddt,Boolean bbt,SqlTry sqlTemp,Vector<DeptData> T_AllDept) {
		prev=m;
		dd=ddt;
		bb=bbt;
		sO=sqlTemp;
		AllDept=T_AllDept;

		
		if(!bb)
		{
			myInitlizer();
		}
		setBounds(prev.getX(), prev.getY(), 600, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowClosingDemo.windowClosing");
                	
                int v=JOptionPane.showConfirmDialog(getContentPane().getParent(), "Save Data ?", "WARNING",
                        JOptionPane.YES_NO_OPTION);
                if ( v== JOptionPane.YES_OPTION) 
                {
                	try {
						sO.wObj(AllDept);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                	sO.closeCon();
                	System.exit(0);

                }
                else if(v == JOptionPane.NO_OPTION)
                {
                	sO.closeCon();
                	System.exit(0);

                }
                else
                {}
            }
        });
		JPanel ProceedMenuP = new JPanel();
		contentPane.add(ProceedMenuP, "name_11752848919100");
		ProceedMenuP.setLayout(null);
		ProceedMenuP.setVisible(true);
		
		JPanel CPTimeP = new JPanel();
		contentPane.add(CPTimeP, "name_11762473442900");
		CPTimeP.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(53, 150, 488, 207);
		CPTimeP.add(scrollPane_1);
		
		DefaultTableModel Cmodel = new DefaultTableModel() {
	        public boolean isCellEditable(int rowIndex, int mColIndex) {
	            return false;
	        }
	    };										//Division table
	     Cmodel.setColumnIdentifiers(new Object[] {"NAME","YEAR","BATCHES","Shift","GFM","Practical-Time" });

		
		PracTimeTable = new JTable(Cmodel);
		PracTimeTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane_1.setViewportView(PracTimeTable);
		ClassTableDisp();
		
		System.out.println("DD.divs");
		int AtempDiv=dd.divs.size();
		String[] sBox=new String[AtempDiv];
		for(int z=0;z<AtempDiv;z++)
		{  
			sBox[z]=dd.divs.get(z).name;
		}
		
		PSpCBox = new JComboBox(sBox);
		PSpCBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		PSpCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				int inDex=PSpCBox.getSelectedIndex();
				if(dd.divs.get(inDex).shift==1)
				{
					
					String[] mYsn= {"8-10","10-12","1-3","2-4"};
					//PSpTCBoc.removeAll();
					PSpTCBoc.removeAllItems();
					for(int z=0;z<mYsn.length;z++)
					{
						PSpTCBoc.addItem(mYsn[z]);
					}
				}
				else	
				{
					String[] mYsn= {"11 - 1","1:30 -3:30","4-6","5-7"};
					//PSpTCBoc.removeAll();
					PSpTCBoc.removeAllItems();
					
					for(int z=0;z<mYsn.length;z++)
					{
						PSpTCBoc.addItem(mYsn[z]);
					}
				}
			}
		});
		
		PSpCBox.setBounds(114, 63, 141, 22);
		CPTimeP.add(PSpCBox);
		
		JLabel lblNewLabel = new JLabel("Class Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(26, 63, 78, 22);
		CPTimeP.add(lblNewLabel);
		
		
		PSpTCBoc = new JComboBox<String>();
		PSpTCBoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		PSpTCBoc.setBounds(390, 104, 141, 22);
		CPTimeP.add(PSpTCBoc);
		
		JLabel lblTiming = new JLabel("Timing");
		lblTiming.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTiming.setBounds(313, 97, 62, 37);
		CPTimeP.add(lblTiming);
		
		TranslucentButton btnNewButton_5 = new TranslucentButton("SET Timing");
		btnNewButton_5.setForeground(new Color(0, 0, 0));
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setClicked();
				
			}
		});
		btnNewButton_5.setBounds(204, 368, 186, 47);
		CPTimeP.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER CLASS DETAILS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(194, 11, 287, 37);
		CPTimeP.add(lblNewLabel_1);
		
		JPanel RoomSpP = new JPanel();
		contentPane.add(RoomSpP, "name_11777855189700");
		RoomSpP.setLayout(null);
		
        System.out.println("dd.lrooms");
		int lrC=dd.Lrooms.size();
		String[] sln=new String[lrC];
		for(int z=0;z<lrC;z++)
		{
			sln[z]=dd.Lrooms.get(z).Rname;
		}
		
		AllowedCB = new JComboBox(sln);
		AllowedCB.setFont(new Font("Tahoma", Font.BOLD, 13));
		AllowedCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("jijno");
			listDisp();	
				
			}
		});
		AllowedCB.setBounds(197, 37, 180, 35);
		RoomSpP.add(AllowedCB);
		
		TranslucentButton btnNewButton_6 = new TranslucentButton("Confirm");
		btnNewButton_6.setForeground(new Color(0, 0, 0));
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setBorderPainted(false);
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				confirmClicked();
				
				
			}
		});
		btnNewButton_6.setBounds(239, 348, 114, 40);
		RoomSpP.add(btnNewButton_6);
		
		TranslucentButton btnBack_1 = new TranslucentButton("Back");
		btnBack_1.setForeground(new Color(0, 0, 0));
		btnBack_1.setBorderPainted(false);
		btnBack_1.setBackground(Color.WHITE);
		btnBack_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProceedMenuP.setVisible(true);
				RoomSpP.setVisible(false);
			}
		});
		btnBack_1.setBounds(10, 411, 73, 29);
		RoomSpP.add(btnBack_1);
		

		
		 System.out.println("curr.sub");
			int csC=dd.curr_subjects.size();
			String[] myarr=new String[csC];
			for(int z=0;z<csC;z++)
			{
				myarr[z]=dd.curr_subjects.get(z).name;
			}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 93, 429, 245);
		RoomSpP.add(scrollPane);
		Sublist = new JList(myarr);
		scrollPane.setViewportView(Sublist);
		Sublist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listDisp();
	
				
		

		TranslucentButton btnBack = new TranslucentButton("BACK");
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setBorderPainted(false);
		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProceedMenuP.setVisible(true);
				CPTimeP.setVisible(false);
			}
		});
		btnBack.setBounds(10, 417, 79, 29);
		CPTimeP.add(btnBack);
		
		int tno=dd.teachers.size();
		String[] tnsn=new String[tno];
		for(int z=0;z<tno;z++)
		{
			tnsn[z]=dd.teachers.get(z).name;
		}
	    TnameCBox = new JComboBox(tnsn);
	    TnameCBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		TnameCBox.setBounds(114, 108, 141, 22);
		CPTimeP.add(TnameCBox);
		
		JLabel lblGfm = new JLabel("GFM");
		lblGfm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGfm.setBounds(41, 112, 46, 14);
		CPTimeP.add(lblGfm);
		
		JLabel lblClassRoom = new JLabel("Lecture Class Room");
		lblClassRoom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClassRoom.setBounds(285, 63, 120, 22);
		CPTimeP.add(lblClassRoom);
		
		
		int rnn=dd.rooms.size();
		String[] rsn=new String[rnn+1];
		rsn[0]="Any Class Room";
		for(int z=1;z<=rnn;z++)
		{
			rsn[z]=dd.rooms.get(z-1).Rname;
			
		}
		LecCRCB = new JComboBox(rsn);
		LecCRCB.setBounds(415, 64, 116, 22);
		CPTimeP.add(LecCRCB);
		
		
		
		
		TranslucentButton btnNewButton = new TranslucentButton("Load Distribution Detail");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LDTclicked();
			}
		});
		btnNewButton.setBounds(133, 104, 294, 51);
		ProceedMenuP.add(btnNewButton);
		
		TranslucentButton btnNewButton_1 = new TranslucentButton("Class Practical Time");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  CPTimeP.setVisible(true);
				ProceedMenuP.setVisible(false);
			}
		});
		
		
		
		btnNewButton_1.setBounds(133, 177, 294, 45);
		ProceedMenuP.add(btnNewButton_1);
		
		TranslucentButton btnNewButton_2 = new TranslucentButton("Lab Details");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RoomSpP.setVisible(true);
				ProceedMenuP.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(133, 244, 294, 42);
		ProceedMenuP.add(btnNewButton_2);
		
		TranslucentButton btnNewButton_3 = new TranslucentButton("Create Time Table");
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VandP();
			}
		});
		btnNewButton_3.setBounds(133, 317, 294, 45);
		ProceedMenuP.add(btnNewButton_3);
		
		TranslucentButton btnNewButton_4 = new TranslucentButton("BACK");
		btnNewButton_4.setForeground(new Color(0, 0, 0));
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			goback();
			}
		});
		btnNewButton_4.setBounds(10, 405, 95, 35);
		ProceedMenuP.add(btnNewButton_4);
		
		JLabel lblSelectAnyAttribute = new JLabel("SELECT ANY ATTRIBUTE");
		lblSelectAnyAttribute.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 29));
		lblSelectAnyAttribute.setBounds(96, 11, 405, 62);
		ProceedMenuP.add(lblSelectAnyAttribute);
		
		TranslucentButton btnNewButton_7 = new TranslucentButton("Save LDT Details");
		btnNewButton_7.setForeground(new Color(0, 0, 0));
		btnNewButton_7.setBorderPainted(false);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveClicked();
			}
		});
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_7.setBounds(199, 396, 176, 51);
		//ProceedMenuP.add(btnNewButton_7);                      //  didnt add save ldt
		
		
		
		ImageIcon imageIcon = new ImageIcon("rr.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(700, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		JLabel llabel = new JLabel("");
		llabel.setIcon(imageIcon);
		llabel.setBounds(0 ,0, 600, 500);
		JLabel llabel2 = new JLabel("");
		llabel2.setIcon(imageIcon);
		llabel2.setBounds(0 ,0, 600, 500);
		JLabel llabel3 = new JLabel("");
		llabel3.setIcon(imageIcon);
		llabel3.setBounds(0 ,0, 600, 500);
		
		ProceedMenuP.add(llabel);
		CPTimeP.add(llabel2);
		RoomSpP.add(llabel3);
		
	}
	void goback()
	{

		prev.setVisible(true);
		this.setVisible(false);
		this.dispose();		
		
	}

	void LDTclicked()
	{
		LDTInput m=new LDTInput(this, dd,sO,AllDept);
		m.setVisible(true);
		this.setVisible(false);
	}
	
	
	synchronized void myInitlizer()
	{
		try {
		
		initSubjects();
		initLRoom();
		initRoom();
		initDivision();
		initTeacher();

		System.out.println("teachDone");
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
	
	void initSubjects()
	{

		System.out.println("sub init");
		int SubCn=dd.subjects.size();
		System.out.println("sub");
		System.out.println();
	    dd.curr_subjects=new Vector<Subject>();
		for(int q=0;q<SubCn;q++)
		{
			if(dd.sem==dd.subjects.get(q).sem)
			dd.curr_subjects.add(dd.subjects.get(q));
		}
		
	}
	
 void initRoom()
	{

		System.out.println("rooms");
		int Rlen=dd.rooms.size();
		int TM=dd.m;
		int TW=dd.n;
		
		for(int z=0;z<Rlen;z++)
		{
			Room tr=dd.rooms.get(z);
			if(!tr.aflag)
			{	
				tr.available=new int[TM][TW];
				tr.T_T=new room_st[TM][TW];
				for(int k=0;k<TM;k++)
				{
					for(int j=0;j<TW;j++)
					{
						tr.available[k][j]=0;
						tr.T_T[k][j]=null;
					}
				}
				tr.aflag=true;
			}
		}
		
	}
	
	void initLRoom()
	{
		

		System.out.println("Lroom");
		int Rlen=dd.Lrooms.size();
		int TM=dd.m;
		int TW=dd.n;
		int ff=dd.curr_subjects.size();
		for(int z=0;z<Rlen;z++)
		{
			Room tr=dd.Lrooms.get(z);
			if(!tr.aflag)
			{
				tr.available=new int[TM][TW];
				tr.T_T=new room_st[TM][TW];
				for(int k=0;k<TM;k++)
				{
					for(int j=0;j<TW;j++)
					{
					tr.available[k][j]=0;
					tr.T_T[k][j]=null;
					}
				}
				tr.aflag=true;
			}
			tr.allowed=new boolean[ff];
			for(int e=0;e<ff;e++)
			{
				tr.allowed[e]=true;
			}
			
		}
	}
	
	void initDivision()
	{
		System.out.println("div");
		int Dlen=dd.divs.size();
		int TM=dd.m;
		int TW=dd.n;
		
		for(int z=0;z<Dlen;z++)
		{
			Division tr=dd.divs.get(z);
			tr.available=new int[TM][TW];
			tr.T_T=new lectOrPract[TM][TW];
			
			tr.rm=-1;
			
			for(int k=0;k<TM;k++)
			{
				for(int j=0;j<TW;j++)
				{
					tr.available[k][j]=0;
					tr.T_T[k][j]=null;
				}
			}
			
			if(tr.shift==1)
			{
				for(int k=0;k<TM;k++)
				{
					for(int j=8;j<TW;j++)
					{
						tr.available[k][j]=1;
					}
					tr.available[k][4]=1;
				}
				
				
			}
			else
			{

				for(int k=0;k<TM;k++)
				{
					for(int j=0;j<3;j++)
					{
						tr.available[k][j]=1;
					}
					tr.available[k][5]=1;
				}
				
			}
			
		}
		
 	}
	
	void initTeacher()
	{

		System.out.println("teach");
		int Tlen=dd.teachers.size();
		int TM=dd.m;
		int TW=dd.n;
		int dtmp=dd.divs.size();
		
		for(int z=0;z<Tlen;z++)
		{
			Teacher tr=dd.teachers.get(z);
			
			if(!tr.aflag)
			{
			tr.available=new int[TM][TW];
			tr.ideal=new int[TM][TW];
			tr.T_T=new teacher_st[TM][TW];
			for(int k=0;k<TM;k++)
				for(int j=0;j<TW;j++)
				{
					tr.available[k][j]=0;
					tr.ideal[k][j]=2;
					tr.T_T[k][j]=null;
				}
			tr.aflag=true;
			}
			tr.daily_LC=new int[dtmp][TM];
			
			for(int k=0;k<dtmp;k++)
				for(int j=0;j<TM;j++)
				{
				
					tr.daily_LC[k][j]=0;				
				}
			
			
			
			tr.L_HM= new int[dtmp];
	    	tr.C_WSub=new int[dtmp];
	    	tr.T_to_C=new boolean[dtmp];
	    	tr.R_L_HM=new int[dtmp];
	    	tr.RLC=0;
	    	
	    	tr.T_to_P=new boolean[dtmp*4];
	    	tr.P_HM= new int[dtmp*4];
	    	tr.P_WSub=new int[dtmp*4];
	    	tr.R_P_HM= new int[dtmp*4]; //over here if 4 batch
	    	tr.RPC=0;
	    	
	    	for(int j=0;j<dtmp;j++)
	    	{
	    		tr.T_to_C[j]=false;
				tr.L_HM[j]=0;
				tr.R_L_HM[j]=0;
				
				tr.C_WSub[j]=-1;
				
			
	    	}
	    	for(int j=0;j<dtmp*4;j++)
	    	{
		    	tr.T_to_P[j]=false;
		    	tr.P_HM[j]=0;
		    	tr.R_P_HM[j]=0;
		    	tr.P_WSub[j]=-1;
	    	}
			
	    	
	    	if(tr.shift==1)
	    	{
	    		for(int k=0;k<TM;k++)
	    		{
	    			
	    			for(int j=8;j<TW;j++)
	    			{
					tr.available[k][j]=1;
					tr.ideal[k][j]=4;
					}
	    		    tr.available[k][4]=1;
	    		    tr.ideal[k][4]=4;
	    		}
	    		
	    	}
	    	else
	    	{

	    		for(int k=0;k<TM;k++)
	    		{
	    			
	    			for(int j=0;j<3;j++)
	    			{
					tr.available[k][j]=1;
					tr.ideal[k][j]=4;
					}
	    		    tr.available[k][5]=1;
	    		    tr.ideal[k][5]=4;
	    		}
	    		
	    	}
			
		}
		
	}
	
	
	
  void 	setClicked()
	{

	  	deleteClassRecAll();
		int di=PSpCBox.getSelectedIndex();
		int ti=PSpTCBoc.getSelectedIndex();
		int teachI=TnameCBox.getSelectedIndex();
		int ris=LecCRCB.getSelectedIndex();
		
		dd.divs.get(di).GFM=dd.teachers.get(teachI).name;
		dd.divs.get(di).rm=ris-1;
		
		if(dd.divs.get(di).shift==1)
		{
			switch(ti)
			{
				case 0:dd.divs.get(di).practTime=0;
					    break;

				case 1:dd.divs.get(di).practTime=2;
					    break;
				case 2:dd.divs.get(di).practTime=5;
						break;
				case 3:dd.divs.get(di).practTime=6;
						break;
			}
		}
		else
		{

			switch(ti)
			{
				case 0:dd.divs.get(di).practTime=3;
					    break;

				case 1:dd.divs.get(di).practTime=6;
					    break;
				case 2:dd.divs.get(di).practTime=8;
				    	break;
				case 3:dd.divs.get(di).practTime=9;
				    	break;
			}
			
		}
		
		ClassTableDisp();
	}
  

  
	void deleteClassRecAll()
	{
		
		DefaultTableModel dm = (DefaultTableModel)PracTimeTable.getModel();
		int rowCount = dm.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
		
	}

  void ClassTableDisp()
	{
		
		DefaultTableModel edm = (DefaultTableModel)PracTimeTable.getModel();
	int divsCount=dd.divs.size();
  Vector<Division> tdivs=dd.divs;
	for(int z=0;z<divsCount;z++)
	{
		String[] tmps=new String[6];
		tmps[0]=tdivs.get(z).name;
		tmps[1]=Integer.toString(tdivs.get(z).year);
		tmps[2]=Integer.toString(tdivs.get(z).batches);
		tmps[3]=Integer.toString(tdivs.get(z).shift);
		tmps[4]=tdivs.get(z).GFM;
		if(tdivs.get(z).practTime==-1)
			tmps[5]="---";
		else
		{
		switch(tdivs.get(z).practTime)
		{
		case 0:	tmps[5]="08:00-10:00"  ;       break;	
		case 2:	tmps[5]="10:00-12:00"  ;       break;	
		case 3:	tmps[5]="11:00-01:00"  ;       break;	
		case 5:	tmps[5]="01:00-03:00"  ;       break;	
		case 6:	tmps[5]="02:00-04:00"  ;       break;	
		case 8:	tmps[5]="04:00-06:00"  ;       break;	
		case 9:	tmps[5]="05:00-07:00"  ;       break;	
		}
		}
		if(tdivs.get(z).shift==2 && tdivs.get(z).practTime==6)
		tmps[5]="01:30-03:30";
		
		edm.insertRow(z, new Object[] { tmps[0],tmps[1],tmps[2],tmps[3],tmps[4],tmps[5]});
	}
	
	}
  
  
  void listDisp()
  {
	  
	    System.out.println("curr.sub");
		 
	    int lri=AllowedCB.getSelectedIndex();
   		int CSz=dd.curr_subjects.size();
	     
   		int count=0;
  		for(int z=0;z<CSz;z++)
  		{
  			if(dd.Lrooms.get(lri).allowed[z]==true)
  			{
  				count++;
  			}
  		}
  		int [] sel=new int[count]; 
  		for(int z=0,k=0;z<CSz;z++)
  		{
  			if(dd.Lrooms.get(lri).allowed[z]==true)
  			{
  				sel[k++]=z;
  			}
  		} 
  		
  		Sublist.setSelectedIndices(sel);
  		
  }
  
 void  confirmClicked()
 {
	    int lri=AllowedCB.getSelectedIndex();
  		 int CSz=dd.curr_subjects.size();
		
  		for(int z=0;z<CSz;z++)
		{
			if(Sublist.isSelectedIndex(z)==true)
			{
				dd.Lrooms.get(lri).allowed[z]=true;
				
			}else
			{
				dd.Lrooms.get(lri).allowed[z]=false;	
			}
		}
	 
	 
 }
 
 void saveClicked()
	{
		
		try
		{
		sO.wObj(AllDept);
		
		}catch(Exception e)
		{ e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Not saved ", "Message",JOptionPane.WARNING_MESSAGE);
		return ;
		}
		JOptionPane.showMessageDialog(null, "Saved Successfully!!", "Message",
		        JOptionPane.WARNING_MESSAGE);
		
	}
  
 void initall() {
	 initRoom();
	 initLRoom();
	 initDivision();
	// initTeacher();
	 
 }
 
 	void VandP()
 	{
	 
 		//initall();
 		int ft=dd.createTT_Main();
 		//dd.teachers.get(5).available[3][2]=1;
 		
 		if(ft==1)
 		{
 		CreateT_T vp=new CreateT_T(this, dd,sO,AllDept);
 		vp.setVisible(true);
 		this.setVisible(false);
 		}
 		else
 		{
 			toast t = new toast("Unable To Create Table", 250, 550); 
		    t.showtoast(); 
 			 t = new toast("Unappropriate LDT Data", 250, 550); 
		    t.showtoast(); 
		   
 		}
 	}
 	
}
