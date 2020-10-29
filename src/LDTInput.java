import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.Year;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class LDTInput extends JFrame {

	private JPanel contentPane;

	private JComboBox PractTeachCB,PractDivCB,PractSubCB,PractHMCB,PractBatchCB ;
	private JComboBox LecSubCB,LecTeachCB,LecDivCB,LecHMCB;
	private ProceedPart1 prev;
	private DeptData dd;
	private Vector<Subject> year1,year2,year3,year4;
	private String[] baTCH;
	private JTable LecTable;
	private JTable PracTable;
	public SqlTry sqlo;
	public Vector<DeptData> AllDept;
	 
	
	/**
	 * Create the frame.
	 */
	public LDTInput(ProceedPart1 m,DeptData ddt,SqlTry sO,Vector<DeptData> T_AllDept) {
		
		sqlo=sO;
		dd=ddt;
		prev=m;
		AllDept=T_AllDept;

		
		baTCH=new String[4];
		baTCH[0]="Batch1";
		baTCH[1]="Batch2";
		baTCH[2]="Batch3";
		baTCH[3]="Batch4";
		
		year1=new Vector<Subject>();
		year2=new Vector<Subject>();
		year3=new Vector<Subject>();
		year4=new Vector<Subject>();
		
		int t_ss=dd.curr_subjects.size();
		for(int z=0;z<t_ss;z++)
		{
			int gg=dd.curr_subjects.get(z).year;
			switch(gg)
			{
			case 1:
				year1.add(dd.curr_subjects.get(z));
				break;

			case 2:

				year2.add(dd.curr_subjects.get(z));
				break;

			case 3:
				year3.add(dd.curr_subjects.get(z));
				break;

			case 4:
				year4.add(dd.curr_subjects.get(z));
				break;
				
			
			}
		}
		

		setResizable(false);
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
		
		
		setBounds(prev.getX(), prev.getY(), 600, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel LDTMENU = new JPanel();
		contentPane.add(LDTMENU, "name_69517127523999");
		LDTMENU.setLayout(null);
		LDTMENU.setVisible(true);
		
		JPanel LDTPRACTICAL = new JPanel();
		contentPane.add(LDTPRACTICAL, "name_71600022028200");
		LDTPRACTICAL.setLayout(null);
		LDTPRACTICAL.setVisible(false);
		
		JPanel LDTLECTURE = new JPanel();
		contentPane.add(LDTLECTURE, "name_71991606966100");
		LDTLECTURE.setLayout(null);
		LDTLECTURE.setVisible(false);
		
		
		 DefaultTableModel modelPract = new DefaultTableModel();										//Division table
	     modelPract.setColumnIdentifiers(new Object[] {"Class","Batch","Subject","Count"});

		
		
		
		
		TranslucentButton btnNewButton_3 = new TranslucentButton("Lecture Details");
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				LDTLECTURE.setVisible(true);
				LDTMENU.setVisible(false);
		
			}
		});
		btnNewButton_3.setBounds(167, 137, 257, 70);
		LDTMENU.add(btnNewButton_3);
		
		TranslucentButton btnNewButton_4 = new TranslucentButton("Practical Details");
		btnNewButton_4.setForeground(new Color(0, 0, 0));
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			LDTPRACTICAL.setVisible(true);
			LDTMENU.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(167, 242, 257, 70);
		LDTMENU.add(btnNewButton_4);
		
		
		JLabel lblNewLabel = new JLabel("LDT MENU ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(201, 21, 166, 37);
		LDTMENU.add(lblNewLabel);
		
		TranslucentButton btnBack_1 = new TranslucentButton("BACK");
		btnBack_1.setForeground(new Color(0, 0, 0));
		btnBack_1.setBorderPainted(false);
		btnBack_1.setBackground(Color.WHITE);
		btnBack_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goback();
			}
		});
		btnBack_1.setBounds(10, 409, 94, 37);
		LDTMENU.add(btnBack_1);
		
		JButton btnNewButton_5 = new JButton("Teachers Availability");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AvailClicked();
				
			}
		});
		btnNewButton_5.setBounds(171, 336, 237, 59);
		//LDTMENU.add(btnNewButton_5);
		
		
		JLabel lblNewLabel_1 = new JLabel("ENTER PRACTICAL DETAILS");
		lblNewLabel_1.setBounds(219, 33, 163, 29);
		LDTPRACTICAL.add(lblNewLabel_1);
		
		
		int Tcn=dd.teachers.size();
		
		String[] myTS=new String[Tcn];
		
		for(int z=0;z<Tcn;z++)
		{
			myTS[z]=dd.teachers.get(z).name;
		}
		
		
		 PractTeachCB = new JComboBox(myTS);
		 PractTeachCB.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		System.out.println("Teacher event");
		 		dispPractTable();
		 		
		 	}
		 });
		PractTeachCB.setBounds(129, 73, 130, 22);
		LDTPRACTICAL.add(PractTeachCB);
		
		int Dcn=dd.divs.size();
		String[] myDS=new String[Dcn];
		
		for(int z=0;z<Dcn;z++)
		{
			myDS[z]=dd.divs.get(z).name;
		}
		
		
		 PractDivCB = new JComboBox(myDS);
		 PractDivCB.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	
		 		int di=PractDivCB.getSelectedIndex();
		 		int bs=dd.divs.get(di).batches;
		 		if(bs==3)
		 		{
		 			PractBatchCB.removeAllItems();
		 			String[] mybs= {"Batch1","Batch2","Batch3"};
		 			for(int z=0;z<3;z++)
		 			{
		 				PractBatchCB.addItem(mybs[z]);
		 			}
		 		}
		 		else if(bs==4)
		 		{
		 			PractBatchCB.removeAllItems();
		 			String[] mybs= {"Batch1","Batch2","Batch3","Batch4"};	
		 			for(int z=0;z<4;z++)
		 			{
		 				PractBatchCB.addItem(mybs[z]);
		 			}
		 			
		 		}
		 		else
		 		{}
		 		
		 		//subset
		 		
		 		int ty=dd.divs.get(di).year;
		 		
		 		switch(ty)
		 		{
			 		case 1:
			 			int tempy1=year1.size();
			 			PractSubCB.removeAllItems();
			 			for(int z=0;z<tempy1;z++)
			 			{
			 				PractSubCB.addItem(year1.get(z).name);
			 			}
			 			
			 			
			 			break;
	
			 		case 2:
			 			int tempy2=year2.size();
			 			PractSubCB.removeAllItems();
			 			for(int z=0;z<tempy2;z++)
			 			{
			 				PractSubCB.addItem(year2.get(z).name);
			 			}
			 			
			 			break;
			 		case 3:
			 			int tempy3=year3.size();
			 			PractSubCB.removeAllItems();
			 			for(int z=0;z<tempy3;z++)
			 			{
			 				PractSubCB.addItem(year3.get(z).name);
			 			}
			 			
			 			break;
			 		case 4:
			 			int tempy4=year4.size();
			 			PractSubCB.removeAllItems();
			 			for(int z=0;z<tempy4;z++)
			 			{
			 				PractSubCB.addItem(year4.get(z).name);
			 			}
			 			
			 			break;
		 		
		 		
		 		}
		 		
		 	}
		 });
		PractDivCB.setBounds(31, 147, 130, 22);
		LDTPRACTICAL.add(PractDivCB);
		
		 PractSubCB = new JComboBox();
		PractSubCB.setBounds(297, 147, 130, 22);
		LDTPRACTICAL.add(PractSubCB);
		
		
		String[] HWS= {"0","1","2","3","4","5","6","7","8","9"};
		
		 PractHMCB = new JComboBox(HWS);
		PractHMCB.setBounds(437, 147, 110, 22);
		LDTPRACTICAL.add(PractHMCB);
		
		TranslucentButton PractAdd = new TranslucentButton("ADD");
		PractAdd.setForeground(new Color(0, 0, 0));
		PractAdd.setBackground(Color.WHITE);
		PractAdd.setBorderPainted(false);
		PractAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PractAddClicked();
				goback();
				
			}
		});
		PractAdd.setBounds(119, 391, 130, 23);
		LDTPRACTICAL.add(PractAdd);
		
		TranslucentButton PractAddMore = new TranslucentButton("ADD MORE");
		PractAddMore.setForeground(new Color(0, 0, 0));
		PractAddMore.setBorderPainted(false);
		PractAddMore.setBackground(Color.WHITE);
		PractAddMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PractAddClicked();
			}
		});
		PractAddMore.setBounds(326, 391, 130, 23);
		LDTPRACTICAL.add(PractAddMore);
		
		TranslucentButton btnBack = new TranslucentButton("BACK");
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setBorderPainted(false);
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				LDTMENU.setVisible(true);
				LDTPRACTICAL.setVisible(false);
			}
			
		});
		btnBack.setBounds(10, 417, 89, 23);
		LDTPRACTICAL.add(btnBack);
		
		
		PractBatchCB = new JComboBox();
		PractBatchCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		PractBatchCB.setBounds(171, 147, 116, 22);
		LDTPRACTICAL.add(PractBatchCB);
		
		JLabel lblNewLabel_6 = new JLabel("Teacher Name");
		lblNewLabel_6.setBounds(28, 77, 91, 14);
		LDTPRACTICAL.add(lblNewLabel_6);
		
		JLabel lblDiv = new JLabel("Division");
		lblDiv.setBounds(68, 114, 69, 22);
		LDTPRACTICAL.add(lblDiv);
		
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setBounds(198, 118, 46, 14);
		LDTPRACTICAL.add(lblBatch);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(336, 118, 46, 14);
		LDTPRACTICAL.add(lblSubject);
		
		JLabel lblNoOfPractical = new JLabel("No of Practical");
		lblNoOfPractical.setBounds(454, 118, 80, 14);
		LDTPRACTICAL.add(lblNoOfPractical);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(43, 206, 491, 165);
		LDTPRACTICAL.add(scrollPane_2);
		

		DefaultTableModel Practmodel = new DefaultTableModel() {
	        public boolean isCellEditable(int rowIndex, int mColIndex) {
	            return false;
	        }
	    };										//Division table
	     Practmodel.setColumnIdentifiers(new Object[] {"Division","Batch","Subject","Number of Practical" });
		
		
		PracTable = new JTable(Practmodel);
		scrollPane_2.setViewportView(PracTable);
		
		
		
		 LecTeachCB = new JComboBox(myTS);
		 LecTeachCB.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		dispLecTable();
		 	}
		 });
		LecTeachCB.setBounds(134, 48, 127, 22);
		LDTLECTURE.add(LecTeachCB);
		
		JLabel label = new JLabel("ENTER LECTURE DETAIL ");
		label.setBounds(228, 0, 160, 40);
		LDTLECTURE.add(label);
		
		 LecDivCB = new JComboBox(myDS);
		 LecDivCB.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		int di=LecDivCB.getSelectedIndex();
		 		int ty=dd.divs.get(di).year;
		 		
		 		switch(ty)
		 		{
			 		case 1:
			 			int tempy1=year1.size();
			 			LecSubCB.removeAllItems();
			 			for(int z=0;z<tempy1;z++)
			 			{
			 				LecSubCB.addItem(year1.get(z).name);
			 			}
			 			
			 			
			 			break;
	
			 		case 2:
			 			int tempy2=year2.size();
			 			LecSubCB.removeAllItems();
			 			for(int z=0;z<tempy2;z++)
			 			{
			 				LecSubCB.addItem(year2.get(z).name);
			 			}
			 			
			 			break;
			 		case 3:
			 			int tempy3=year3.size();
			 			LecSubCB.removeAllItems();
			 			for(int z=0;z<tempy3;z++)
			 			{
			 				LecSubCB.addItem(year3.get(z).name);
			 			}
			 			
			 			break;
			 		case 4:
			 			int tempy4=year4.size();
			 			LecSubCB.removeAllItems();
			 			for(int z=0;z<tempy4;z++)
			 			{
			 				LecSubCB.addItem(year4.get(z).name);
			 			}
			 			
			 			break;
		 		
		 		
		 		}
	
		 		
		 	}
		 });
		LecDivCB.setBounds(53, 107, 127, 22);
		LDTLECTURE.add(LecDivCB);
		
		 LecSubCB = new JComboBox();
		LecSubCB.setBounds(227, 107, 127, 22);
		LDTLECTURE.add(LecSubCB);
		
		 LecHMCB = new JComboBox(HWS);
		LecHMCB.setBounds(395, 107, 127, 22);
		LDTLECTURE.add(LecHMCB);
		
		TranslucentButton btnNewButton = new TranslucentButton("ADD MORE");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LecAddClicked();
				
			}
		});
		btnNewButton.setBounds(357, 399, 160, 22);
		LDTLECTURE.add(btnNewButton);
	//	
		TranslucentButton btnNewButton_1 = new TranslucentButton("ADD ");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LecAddClicked();
				goback();
			}
		});
		btnNewButton_1.setBounds(173, 399, 127, 23);
		LDTLECTURE.add(btnNewButton_1);
		
		TranslucentButton btnNewButton_2 = new TranslucentButton("BACK");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LDTMENU.setVisible(true);
				LDTLECTURE.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(10, 417, 89, 23);
		LDTLECTURE.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Teacher");
		lblNewLabel_2.setBounds(56, 52, 68, 14);
		LDTLECTURE.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Class");
		lblNewLabel_3.setBounds(97, 82, 46, 14);
		LDTLECTURE.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Subject");
		lblNewLabel_4.setBounds(270, 82, 46, 14);
		LDTLECTURE.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Number of Lecture");
		lblNewLabel_5.setBounds(415, 82, 89, 14);
		LDTLECTURE.add(lblNewLabel_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(53, 167, 462, 211);
		LDTLECTURE.add(scrollPane_1);
		
		
		
		DefaultTableModel Lecmodel = new DefaultTableModel() {
	        public boolean isCellEditable(int rowIndex, int mColIndex) {
	            return false;
	        }
	    };										//Division table
	     Lecmodel.setColumnIdentifiers(new Object[] {"Division","Subject","Number of Lecture" });

		LecTable = new JTable(Lecmodel);
		dispLecTable();
		
		scrollPane_1.setViewportView(LecTable);
	
	
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
	
		LDTMENU.add(llabel);
		LDTLECTURE.add(llabel2);
		LDTPRACTICAL.add(llabel3);
		
	
		
	
	
	}
	
	void deleteLTable()
	{
		
		DefaultTableModel dm = (DefaultTableModel)LecTable.getModel();
			int rowCount = dm.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
		
	}

	
	void AvailClicked()
	{
		AvailableTable m=new AvailableTable(this,sqlo,dd);
		m.setVisible(true);
		this.setVisible(false);
		
	}
	
	void dispLecTable()
	{

		deleteLTable();
		DefaultTableModel edm = (DefaultTableModel)LecTable.getModel();
	int divsCount=dd.divs.size();
	int ti=LecTeachCB.getSelectedIndex();
	
	Teacher Ttemp=dd.teachers.get(ti);
	
	
	for(int z=0,i=0;z<divsCount;z++)
	{
		if(Ttemp.T_to_C[z]==true)
		{
		String[] tmps=new String[3];
		
		
		tmps[0]=dd.divs.get(z).name;
		tmps[1]=dd.curr_subjects.get(Ttemp.C_WSub[z]).name;
		tmps[2]=Integer.toString(Ttemp.L_HM[z]);
		
		
		edm.insertRow(i++, new Object[] { tmps[0],tmps[1],tmps[2]});
	
		}
	}
		
		
	}

	void deletePTable()
	{
		DefaultTableModel dm = (DefaultTableModel)PracTable.getModel();
			int rowCount = dm.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
		
	}

	
	void dispPractTable()
	{
		deletePTable();
		
		DefaultTableModel edm = (DefaultTableModel)PracTable.getModel();
		
		
		int ti=PractTeachCB.getSelectedIndex();
 		int tpc=dd.divs.size();
 		tpc*=4;
 		int txc=0;
 		Teacher tTemp=dd.teachers.get(ti);
 		for(int z=0;z<tpc;z++)
 		{
 			if(tTemp.T_to_P[z])
 			{
 				//table.ad
 				String tmPD0=dd.divs.get(z/4).name;
 				String tmPD1=baTCH[z%4];
 				
 				int si=tTemp.P_WSub[z];
 				
 				String tmPD2=dd.subjects.get(si).name;
 				String tmPD3=Integer.toString(tTemp.P_HM[z]);
 				
 				edm.insertRow(txc++, new Object[] { tmPD0,tmPD1,tmPD2,tmPD3,});

 			}
 		}
		
	}
	
	
	
	void LecAddClicked()
	{
		
		int _ti=LecTeachCB.getSelectedIndex();
		int _di=LecDivCB.getSelectedIndex();
		int _si=LecSubCB.getSelectedIndex();
		int _hw=LecHMCB.getSelectedIndex();
		
		int mydi=dd.divs.get(_di).year;
		switch(mydi)
		{
		case 1: _si=year1.get(_si).inDEX;
			break;
		case 2: _si=year2.get(_si).inDEX;
			break;
		case 3: _si=year3.get(_si).inDEX;
			break;
		case 4: _si=year4.get(_si).inDEX;
			break;
		}
		
		if(_hw==0)
		{
			dd.teachers.get(_ti).T_to_C[_di]=false;
			dd.teachers.get(_ti).L_HM[_di]=0;
			dd.teachers.get(_ti).R_L_HM[_di]=0;	
			dd.teachers.get(_ti).C_WSub[_di]=-1;
			dispLecTable();
						
			return;
		}
		
		dd.teachers.get(_ti).T_to_C[_di]=true;
		dd.teachers.get(_ti).L_HM[_di]=_hw;
		dd.teachers.get(_ti).R_L_HM[_di]=_hw;
		
		dd.teachers.get(_ti).C_WSub[_di]=_si;
		System.out.println("Lecture Added");	
		toast t = new toast("Lecture Added.", 250, 550); 
	    t.showtoast(); 
	   
		dispLecTable();
	}
	
	void PractAddClicked()
	{
		int _ti=PractTeachCB.getSelectedIndex();
		int _di=PractDivCB.getSelectedIndex();
		int _si=PractSubCB.getSelectedIndex();
		int _hw=PractHMCB.getSelectedIndex();
		int _bi=PractBatchCB.getSelectedIndex();
		
		
		
		int mydi=dd.divs.get(_di).year;
		switch(mydi)
		{
		case 1: _si=year1.get(_si).inDEX;
			break;
		case 2: _si=year2.get(_si).inDEX;
			break;
		case 3: _si=year3.get(_si).inDEX;
			break;
		case 4: _si=year4.get(_si).inDEX;
			break;
		}
		
		
		_di*=4;
		_di+=_bi;
		if(_hw==0)
		{
			dd.teachers.get(_ti).T_to_P[_di]=false;
			dd.teachers.get(_ti).P_HM[_di]=0;
			dd.teachers.get(_ti).R_P_HM[_di]=0;
			dd.teachers.get(_ti).P_WSub[_di]=0;

			dispPractTable();
			return;	
		}
		dd.teachers.get(_ti).T_to_P[_di]=true;
		dd.teachers.get(_ti).P_HM[_di]=_hw;
		dd.teachers.get(_ti).R_P_HM[_di]=_hw;
		dd.teachers.get(_ti).P_WSub[_di]=_si;
		System.out.println("Practical Added");	
		toast t = new toast("Practical Added.", 250, 550); 
	    t.showtoast(); 
	   
	    dispPractTable();
		
	}
	
	
	void goback()
	{

		prev.setVisible(true);
		this.setVisible(false);
		this.dispose();		
		
	}
}
