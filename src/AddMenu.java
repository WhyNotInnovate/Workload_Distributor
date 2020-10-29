import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import jdk.nashorn.internal.ir.BreakNode;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class AddMenu extends JFrame {

	private JPanel contentPane;
	private Menu prev;
	private JTextField DivnameTF;
	 private JComboBox yearBox;
	 private JComboBox SubYearBox, BatchCB;
	 private DeptData dd;
	 public SqlTry sqlo;
	
	 
	private int  tempyear=1;
	JToggleButton togbutton,ClassTogBut,TeachTogBut;
	
	String year[]= {"FIRST","SECOND","THIRD","FOURTH"};
	private JTextField SubAddTF;
	private JTextField RoomAddTF;
	private JTextField LRoomTF;
	private JTextField TeachAddTF;
	private JTextField TeachSnTF;
	private JTable ClassTable;
	private JTable Stable;
	private JTable RoomTable;
	private JTable LabTable;
	private JTable TeacherTable;
	private JTextField SNTF;
	public Vector<DeptData> AllDept;
	
	public AddMenu(Menu m,DeptData ddt,SqlTry sO,Vector<DeptData> T_AllDept) {
		prev=m;
		dd=ddt;
		sqlo=sO;
		AllDept=T_AllDept;
		
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
		setResizable(false);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel AskADD = new JPanel();
		contentPane.add(AskADD, "name_1655320763785");
		AskADD.setLayout(null);
		AskADD.setVisible(true);
	
		
		JPanel CAddPanel = new JPanel();
		contentPane.add(CAddPanel, "name_1662126854331");
		CAddPanel.setLayout(null);
		
		JLabel lblAddClassRooms = new JLabel("Enter New Class Details");
		lblAddClassRooms.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddClassRooms.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddClassRooms.setBounds(158, 11, 237, 25);
		CAddPanel.add(lblAddClassRooms);
		
		TranslucentButton btnNewButton_5 = new TranslucentButton("BACK");
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setForeground(new Color(0, 0, 0));

		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AskADD.setVisible(true);
				CAddPanel.setVisible(false);
			}
		});
		btnNewButton_5.setBounds(10, 417, 89, 23);
		CAddPanel.add(btnNewButton_5);
		contentPane.add(CAddPanel);
		
		DivnameTF = new JTextField();
		DivnameTF.setFont(new Font("Tahoma", Font.BOLD, 11));
		DivnameTF.setBounds(126, 53, 164, 20);
		CAddPanel.add(DivnameTF);
		DivnameTF.setColumns(10);
		
		JLabel lblClassName = new JLabel("CLASS NAME");
		lblClassName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClassName.setBounds(27, 56, 89, 14);
		CAddPanel.add(lblClassName);
		
		String year[]= {"FIRST","SECOND","THIRD","FOURTH"};
		 yearBox = new JComboBox(year);
		 yearBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		yearBox.setBounds(285, 96, 86, 25);
		CAddPanel.add(yearBox);
		
		TranslucentButton btnNewButton_7 = new TranslucentButton("ADD ");
		btnNewButton_7.setBorderPainted(false);
		btnNewButton_7.setForeground(new Color(0, 0, 0));

		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_7.addActionListener(new ActionListener() {			 //		class add + button     
			public void actionPerformed(ActionEvent e) {
				
				String cmp="";
				if(!cmp.equals(DivnameTF.getText()))
				{
					
				insertDivision();
				toast t = new toast("Class Added.", 250, 550); 
			    t.showtoast(); 
			    AskADD.setVisible(true);
			    CAddPanel.setVisible(false);
				}
				else
				{	toast t = new toast("Please Enter Name", 250, 550); 
				    t.showtoast(); 
					
				}
			}
		});
		btnNewButton_7.setBounds(269, 407, 89, 23);
		CAddPanel.add(btnNewButton_7);
		contentPane.add(CAddPanel);
		
		TranslucentButton btnNewButton_8 = new TranslucentButton("ADD MORE");
		btnNewButton_8.setBorderPainted(false);
		btnNewButton_8.setForeground(new Color(0, 0, 0));

		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmp="";
				if(!cmp.equals(DivnameTF.getText()))
				{insertDivision();
				toast t = new toast("Class Added.", 250, 550); 
			    t.showtoast(); 
			    }
				else
				{	toast t = new toast("Please Enter Name", 250, 550); 
				    t.showtoast(); 
					
				}
			}
		});
		btnNewButton_8.setBounds(400, 406, 124, 25);
		CAddPanel.add(btnNewButton_8);
		contentPane.add(CAddPanel);
		
		JLabel lblYear_1 = new JLabel("YEAR");
		lblYear_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYear_1.setBounds(235, 101, 46, 14);
		CAddPanel.add(lblYear_1);
		
		
		JLabel lblShift = new JLabel("SHIFT");
		lblShift.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblShift.setBounds(55, 101, 46, 14);
		CAddPanel.add(lblShift);
		
		ClassTogBut = new JToggleButton("SHIFT-I");
		ClassTogBut.setFont(new Font("Tahoma", Font.BOLD, 11));
		ClassTogBut.setBounds(117, 97, 89, 23);
		ClassTogBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if (ClassTogBut.isSelected())  
					 ClassTogBut.setText("SHIFT-II");  
			        else  
			        	ClassTogBut.setText("SHIFT-I"); 
			}
		});
		
		CAddPanel.add(ClassTogBut);
		
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBatch.setBounds(400, 101, 46, 14);
		CAddPanel.add(lblBatch);
		
		String[] myarr= {"2","3","4","5"};
		 BatchCB = new JComboBox(myarr);
		 BatchCB.setFont(new Font("Tahoma", Font.BOLD, 11));
		BatchCB.setBounds(456, 97, 89, 22);
		CAddPanel.add(BatchCB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(26, 142, 533, 254);
		CAddPanel.add(scrollPane);
		
		
		DefaultTableModel Cmodel = new DefaultTableModel() {
	        public boolean isCellEditable(int rowIndex, int mColIndex) {
	            return false;
	        }
	    };										//Division table
	     Cmodel.setColumnIdentifiers(new Object[] {"NAME","YEAR","BATCHES","Shift","GFM","Practical-Time" });

		
		
		
		ClassTable = new JTable(Cmodel);
		scrollPane.setViewportView(ClassTable);
		ClassTableDisp();
		
		TranslucentButton btnDelete = new TranslucentButton("DELETE");
		btnDelete.setBorderPainted(false);
		btnDelete.setForeground(new Color(0, 0, 0));

		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cri=ClassTable.getSelectedRow();
				if(cri==-1)
				{
					return;
				}
				dd.divs.remove(cri);
				deleteClassRecAll();
				ClassTableDisp();
			}
		});
		btnDelete.setBounds(139, 407, 89, 23);
		CAddPanel.add(btnDelete);
		CAddPanel.setVisible(false);
		contentPane.add(CAddPanel);
		
		
		
		
		JPanel SAddP = new JPanel();
		contentPane.add(SAddP, "name_3080694398322");
		SAddP.setLayout(null);
		
		JLabel lblAddSubjects = new JLabel("ADD SUBJECTS");
		lblAddSubjects.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddSubjects.setBounds(211, 11, 163, 33);
		SAddP.add(lblAddSubjects);
		
		TranslucentButton btnNewButton_6 = new TranslucentButton("BACK");
		btnNewButton_6.setBorderPainted(false);
		btnNewButton_6.setForeground(new Color(0, 0, 0));

		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AskADD.setVisible(true);
				SAddP.setVisible(false);
				
			}
		});
		btnNewButton_6.setBounds(10, 417, 89, 23);
		SAddP.add(btnNewButton_6);
		contentPane.add(SAddP);
		
		JLabel lblSubjectName = new JLabel("Subject Name");
		lblSubjectName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubjectName.setBounds(28, 55, 108, 23);
		SAddP.add(lblSubjectName);
		
		SubAddTF = new JTextField();
		SubAddTF.setBounds(146, 55, 163, 23);
		SAddP.add(SubAddTF);
		SubAddTF.setColumns(10);
		

		
		SubYearBox = new JComboBox(year);
		SubYearBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		SubYearBox.setBounds(404, 89, 153, 22);
		SAddP.add(SubYearBox);
		
		togbutton = new JToggleButton("SEM-I");				
		togbutton.setFont(new Font("Tahoma", Font.BOLD, 14));
		togbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if (togbutton.isSelected())  
			            togbutton.setText("SEM-II");  
			        else  
			            togbutton.setText("SEM-I"); 
			}
		});
		togbutton.setBounds(146, 89, 163, 23);
		SAddP.add(togbutton);
		
		TranslucentButton SubADDObj = new TranslucentButton("ADD");
		SubADDObj.setBorderPainted(false);
		SubADDObj.setForeground(new Color(0, 0, 0));

		SubADDObj.setFont(new Font("Tahoma", Font.BOLD, 14));
		SubADDObj.addActionListener(new ActionListener() {     // ADD sub + 
			public void actionPerformed(ActionEvent e) {
				
				String cmp="";
				if((!cmp.equals(SubAddTF.getText())) && (!cmp.equals(SNTF.getText())) )
				{
					insertSubject();
				toast t = new toast("Subject Added.", 250, 550); 
			    t.showtoast(); 

			    AskADD.setVisible(true);
			    SAddP.setVisible(false);				}
				else
				{	toast t = new toast("Please Enter Name", 250, 550); 
				    t.showtoast(); 
					
				}
			}
		});
		SubADDObj.setBounds(276, 401, 129, 23);
		SAddP.add(SubADDObj);
		contentPane.add(SAddP);
		
		TranslucentButton SubAddMore = new TranslucentButton("ADD MORE");						///ADD SUb + more
		SubAddMore.setBorderPainted(false);
	    SubAddMore.setForeground(new Color(0, 0, 0));

		SubAddMore.setFont(new Font("Tahoma", Font.BOLD, 14));
		SubAddMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				String cmp="";
				if((!cmp.equals(SubAddTF.getText())) && (!cmp.equals(SNTF.getText())) )
				{
					insertSubject();
				toast t = new toast("Subject Added.", 250, 550); 
			    t.showtoast(); 
			 
				}
				else
				{	toast t = new toast("Please Enter Name", 250, 550); 
				    t.showtoast(); 
					
				}
			
			}
			
		});
		SubAddMore.setBounds(425, 401, 120, 23);
		SAddP.add(SubAddMore);
		contentPane.add(SAddP);
		
		JLabel lblNewLabel_1 = new JLabel("Select Semister");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(28, 89, 108, 27);
		SAddP.add(lblNewLabel_1);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYear.setBounds(349, 93, 46, 14);
		SAddP.add(lblYear);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(30, 145, 527, 220);
		SAddP.add(scrollPane_1);
		
		DefaultTableModel Smodel = new DefaultTableModel(){
	        public boolean isCellEditable(int rowIndex, int mColIndex) {
	            return false;
	        }
	    };										//Subject table
        Smodel.setColumnIdentifiers(new Object[] {"Name","Short Name","Year","Sem"});
		
		
		Stable = new JTable(Smodel);
		Stable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(Stable);
		SubTableDisp();
		
		TranslucentButton btnDelete_1 = new TranslucentButton("DELETE");
		btnDelete_1.setBorderPainted(false);
		btnDelete_1.setForeground(new Color(0, 0, 0));

		btnDelete_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sri=Stable.getSelectedRow();
				if(sri==-1)
				{
					return;
				}
				int ssize=dd.subjects.size();
				for(int z=sri;z<ssize;z++)
				{
					dd.subjects.get(z).inDEX--;
				}
				dd.subjects.remove(sri);
				deleteSubAll();
				SubTableDisp();
			
			}
		});
		btnDelete_1.setBounds(167, 401, 89, 23);
		SAddP.add(btnDelete_1);
		contentPane.add(SAddP);
		
		JLabel lblNewLabel_3 = new JLabel("Short Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(329, 58, 83, 17);
		SAddP.add(lblNewLabel_3);
		
		SNTF = new JTextField();
		SNTF.setBounds(425, 57, 135, 23);
		SAddP.add(SNTF);
		SNTF.setColumns(10);
		
		JPanel RAddP = new JPanel();
		contentPane.add(RAddP, "name_3113019241149");
		RAddP.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD CLASS ROOMS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(200, 11, 221, 48);
		RAddP.add(lblNewLabel);
		
		
		TranslucentButton btnBackr = new TranslucentButton("BACK");
		btnBackr.setBorderPainted(false);
		btnBackr.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBackr.setForeground(new Color(0, 0, 0));

		btnBackr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AskADD.setVisible(true);
				RAddP.setVisible(false);
				
			}
		});
		btnBackr.setBounds(10, 417, 89, 23);
		RAddP.add(btnBackr);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(39, 81, 60, 27);
		RAddP.add(lblNewLabel_2);
		
		RoomAddTF = new JTextField();
		RoomAddTF.setBounds(117, 70, 176, 38);
		RAddP.add(RoomAddTF);
		RoomAddTF.setColumns(10);
		
		TranslucentButton RoomAddObj = new TranslucentButton("ADD");					//Add room +
		RoomAddObj.setBorderPainted(false);
		RoomAddObj.setForeground(new Color(0, 0, 0));

		RoomAddObj.setFont(new Font("Tahoma", Font.BOLD, 14));
		RoomAddObj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmp="";
				if(!cmp.equals(RoomAddTF.getText()))
				{
					insertCRoom();
				toast t = new toast("Class Room Added.", 250, 550); 
			    t.showtoast(); 

			    AskADD.setVisible(true);
			    RAddP.setVisible(false);
				}
				else
				{	toast t = new toast("Please Enter Name", 250, 550); 
				    t.showtoast(); 
					
				}
				
			}
		});
		RoomAddObj.setBounds(254, 392, 89, 23);
		RAddP.add(RoomAddObj);
		
		TranslucentButton RoomAddMore = new TranslucentButton("ADD MORE");				//Add more Room +
		RoomAddMore.setBorderPainted(false);
		RoomAddMore.setForeground(new Color(0, 0, 0));

		RoomAddMore.setFont(new Font("Tahoma", Font.BOLD, 14));
		RoomAddMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cmp="";
				if(!cmp.equals(RoomAddTF.getText()))
				{
					insertCRoom();
				toast t = new toast("Class Room Added.", 250, 550); 
			    t.showtoast(); 
			   
				}
				else
				{	toast t = new toast("Please Enter Name", 250, 550); 
				    t.showtoast(); 
					
				}
			}
		});
		
		
		RoomAddMore.setBounds(375, 392, 120, 23);
		RAddP.add(RoomAddMore);
		
		TranslucentButton btnNewButton_9 = new TranslucentButton("DELETE");
		btnNewButton_9.setBorderPainted(false);
		btnNewButton_9.setForeground(new Color(0, 0, 0));

		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rri=RoomTable.getSelectedRow();
				if(rri==-1)
				{
					return;
				}
				dd.rooms.remove(rri);
				deleteRoomAll();
				RoomTableDisp();
			}
		});
		btnNewButton_9.setBounds(129, 392, 89, 23);
		RAddP.add(btnNewButton_9);
		
		
		
		DefaultTableModel Rmodel = new DefaultTableModel(){
	        public boolean isCellEditable(int rowIndex, int mColIndex) {
	            return false;
	        }
	    };
	    Rmodel.setColumnIdentifiers(new Object[] {"name" });
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(22, 132, 532, 230);
		RAddP.add(scrollPane_2);
		
		RoomTable = new JTable(Rmodel);
		scrollPane_2.setViewportView(RoomTable);
		RoomTableDisp();
		
		RAddP.setVisible(false);
		
		
		JPanel LAddP = new JPanel();
		contentPane.add(LAddP, "name_3128698358102");
		LAddP.setLayout(null);
		
		JLabel lblAddLabs = new JLabel("ADD LABS");
		lblAddLabs.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblAddLabs.setBounds(252, 11, 199, 35);
		LAddP.add(lblAddLabs);
		
		TranslucentButton btnBack_1 = new TranslucentButton("BACK");
		btnBack_1.setBorderPainted(false);
		btnBack_1.setForeground(new Color(0, 0, 0));

		btnBack_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AskADD.setVisible(true);
				LAddP.setVisible(false);
				
			}
		});
		btnBack_1.setBounds(10, 402, 89, 23);
		LAddP.add(btnBack_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(52, 77, 47, 20);
		LAddP.add(lblName);
		
		LRoomTF = new JTextField();
		LRoomTF.setBounds(141, 66, 170, 35);
		LAddP.add(LRoomTF);
		LRoomTF.setColumns(10);
		
		TranslucentButton LRoomAddObj = new TranslucentButton("ADD");
		LRoomAddObj.setBorderPainted(false);
		LRoomAddObj.setForeground(new Color(0, 0, 0));

		LRoomAddObj.setFont(new Font("Tahoma", Font.BOLD, 14));
		LRoomAddObj.addActionListener(new ActionListener() {          //Add LRoom +
			public void actionPerformed(ActionEvent e) {
				String cmp="";
				if(!cmp.equals(LRoomTF.getText()))
				{
					insertLRoom();
				toast t = new toast("Lab Room Added.", 250, 550); 
			    t.showtoast(); 

			    AskADD.setVisible(true);
			    LAddP.setVisible(false);
				}
				else
				{	toast t = new toast("Please Enter Name", 250, 550); 
				    t.showtoast(); 
					
				}
			
			}
		});
		LRoomAddObj.setBounds(286, 390, 89, 23);
		LAddP.add(LRoomAddObj);
		
		TranslucentButton LRoomAddMore = new TranslucentButton("ADD MORE");
		LRoomAddMore.setBorderPainted(false);
		LRoomAddMore.setForeground(new Color(0, 0, 0));

		LRoomAddMore.setFont(new Font("Tahoma", Font.BOLD, 14));
		LRoomAddMore.addActionListener(new ActionListener() {      //Add Lab Room more 
			public void actionPerformed(ActionEvent e) {
				String cmp="";
				if(!cmp.equals(LRoomTF.getText()))
				{
					insertLRoom();
				
				toast t = new toast("Lab Room Added.", 250, 550); 
			    t.showtoast(); 
			    }
				else
				{	toast t = new toast("Please Enter Name", 250, 550); 
				    t.showtoast(); 
					
				}
			}
		});
		LRoomAddMore.setBounds(400, 390, 130, 23);
		LAddP.add(LRoomAddMore);
		
		TranslucentButton btnDelete_2 = new TranslucentButton("DELETE");
		btnDelete_2.setBorderPainted(false);
		btnDelete_2.setForeground(new Color(0, 0, 0));

		btnDelete_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int lri=LabTable.getSelectedRow();
				if(lri==-1)
				{
					return;
				}
				
				dd.Lrooms.remove(lri);
				deleteLabRoomAll();
				LabTableDisp();
			}
		});
		btnDelete_2.setBounds(166, 390, 89, 23);
		LAddP.add(btnDelete_2);
		

		DefaultTableModel Labmodel = new DefaultTableModel(){
	        public boolean isCellEditable(int rowIndex, int mColIndex) {
	            return false;
	        }
	        };										//LRooms Table
	     Labmodel.setColumnIdentifiers(new Object[] {"Lname" });
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(36, 128, 506, 225);
		LAddP.add(scrollPane_3);
		
		LabTable = new JTable(Labmodel);
		scrollPane_3.setViewportView(LabTable);
		LabTableDisp();
		
		
		LAddP.setVisible(false);
		
		JPanel TAddP = new JPanel();
		contentPane.add(TAddP, "name_3152909408783");
		TAddP.setLayout(null);
		
		JLabel lblAddTeachers = new JLabel("ADD TEACHERS");
		lblAddTeachers.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddTeachers.setBounds(229, 11, 225, 23);
		TAddP.add(lblAddTeachers);
		
		TranslucentButton btnBackt = new TranslucentButton("Back");
		btnBackt.setBorderPainted(false);
		btnBackt.setForeground(new Color(0, 0, 0));

		btnBackt.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBackt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AskADD.setVisible(true);
				TAddP.setVisible(false);
				
			}
		});
		btnBackt.setBounds(10, 417, 89, 23);
		TAddP.add(btnBackt);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName_1.setBounds(82, 57, 43, 19);
		TAddP.add(lblName_1);
		
		TeachAddTF = new JTextField();
		TeachAddTF.setBounds(149, 53, 138, 30);
		TAddP.add(TeachAddTF);
		TeachAddTF.setColumns(10);
		
		JLabel lblShortName = new JLabel("Short Name");
		lblShortName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblShortName.setBounds(39, 114, 100, 30);
		TAddP.add(lblShortName);
		
		TeachSnTF = new JTextField();
		TeachSnTF.setBounds(149, 108, 138, 36);
		TAddP.add(TeachSnTF);
		TeachSnTF.setColumns(10);
		
		TranslucentButton TeachAddObj = new TranslucentButton("ADD"); 						// teacher Add +
		TeachAddObj.setBorderPainted(false);
		TeachAddObj.setForeground(new Color(0, 0, 0));

		TeachAddObj.setFont(new Font("Tahoma", Font.BOLD, 14));
		TeachAddObj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cmp="";
				if(!(cmp.equals(TeachAddObj.getText()) || cmp.equals(TeachSnTF.getText())) )
				{
					insertTeach();
				toast t = new toast("Teacher Added.", 250, 550); 
			    t.showtoast(); 

			    AskADD.setVisible(true);
			    TAddP.setVisible(false);
				}
				else
				{	toast t = new toast("Please Enter Name", 250, 550); 
				    t.showtoast(); 
					
				}
				
				
			}
		});
		TeachAddObj.setBounds(299, 392, 89, 23);
		TAddP.add(TeachAddObj);
		
		TranslucentButton TeachAddMore = new TranslucentButton("ADD MORE");
		TeachAddMore.setBorderPainted(false);
		TeachAddMore.setForeground(new Color(0, 0, 0));

		TeachAddMore.setFont(new Font("Tahoma", Font.BOLD, 14));
		TeachAddMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmp="";
				if(!(cmp.equals(TeachAddObj.getText()) || cmp.equals(TeachSnTF.getText())) )
				{
					insertTeach();
				toast t = new toast("Teacher Added.", 250, 550); 
			    t.showtoast(); 
			    }
				else
				{	toast t = new toast("Please Enter Name", 250, 550); 
				    t.showtoast(); 
					
				}
				
				
				
			}
		});
		TeachAddMore.setBounds(417, 392, 133, 23);
		TAddP.add(TeachAddMore);
		
		 TeachTogBut = new JToggleButton("SHIIFT-I");
		 TeachTogBut.setFont(new Font("Tahoma", Font.BOLD, 15));
		TeachTogBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if (TeachTogBut.isSelected())  
					 TeachTogBut.setText("SHIFT-II");  
			        else  
			        	TeachTogBut.setText("SHIFT-I"); 
			}
		});
		
		TeachTogBut.setBounds(410, 108, 121, 35);
		TAddP.add(TeachTogBut);
		
		JLabel lblShift_1 = new JLabel("SHIFT");
		lblShift_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblShift_1.setBounds(328, 117, 57, 24);
		TAddP.add(lblShift_1);
		
		TranslucentButton btnDelete_3 = new TranslucentButton("DELETE");
		btnDelete_3.setBorderPainted(false);
		btnDelete_3.setForeground(new Color(0, 0, 0));

		btnDelete_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int tri=TeacherTable.getSelectedRow();
				if(tri==-1)
				{
					return;
				}
				dd.teachers.remove(tri);
				deleteTeacherAll();
				TeacherTableDisp();
			}
		});
		btnDelete_3.setBounds(177, 392, 89, 23);
		TAddP.add(btnDelete_3);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_4.setBounds(26, 178, 531, 188);
		TAddP.add(scrollPane_4);
		
		DefaultTableModel Tmodel = new DefaultTableModel(){
	        public boolean isCellEditable(int rowIndex, int mColIndex) {
	            return false;
	        }
	    };										//Teachers List Table
	     Tmodel.setColumnIdentifiers(new Object[] {"name","Short Name","Shift" });
	 
		
		TeacherTable = new JTable(Tmodel);
		scrollPane_4.setViewportView(TeacherTable);
		TeacherTableDisp();
		
		TAddP.setVisible(false);
			
		TranslucentButton btnNewButton = new TranslucentButton("Class");	// Add class
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CAddPanel.setVisible(true);
				AskADD.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton.setBounds(198, 86, 189, 48);
		AskADD.add(btnNewButton);
		
		TranslucentButton btnNewButton_1 = new TranslucentButton("Subjects");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(Color.WHITE);

		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SAddP.setVisible(true);
				AskADD.setVisible(false);		
			}
		});
		btnNewButton_1.setBounds(198, 145, 189, 48);
		AskADD.add(btnNewButton_1);
		
		TranslucentButton btnNewButton_2 = new TranslucentButton("Class Room");
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(Color.WHITE);

		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RAddP.setVisible(true);
				AskADD.setVisible(false);		
			
			}
		});
		btnNewButton_2.setBounds(201, 222, 189, 48);
		AskADD.add(btnNewButton_2);
		
		TranslucentButton btnNewButton_3 = new TranslucentButton("Laboratory");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setForeground(new Color(0, 0, 0));

		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LAddP.setVisible(true);
				AskADD.setVisible(false);		
			
			}
		});
		btnNewButton_3.setBounds(201, 292, 189, 48);
		AskADD.add(btnNewButton_3);
		
		TranslucentButton btnNewButton_4 = new TranslucentButton("Teachers");
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setForeground(new Color(0, 0, 0));

		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TAddP.setVisible(true);
				AskADD.setVisible(false);		
			
			}
		});
		btnNewButton_4.setBounds(201, 363, 189, 48);
		AskADD.add(btnNewButton_4);
		
		TranslucentButton btnBack = new TranslucentButton("BACK");		
		btnBack.setBorderPainted(false);							
		btnBack.setForeground(new Color(0, 0, 0));				//go to back
		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goback();
			}
		});
		btnBack.setBounds(10, 417, 89, 23);
		AskADD.add(btnBack);
		
	
		TranslucentButton iptRbtn = new TranslucentButton("IMPORT");	  // ROOM	
		iptRbtn.setBorderPainted(false);							
		iptRbtn.setForeground(new Color(0, 0, 0));				//go to back
		iptRbtn.setBackground(Color.WHITE);
		iptRbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		iptRbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				importDeptChoice(1);
			}
		});
		iptRbtn.setBounds(375, 70, 144, 35);
		RAddP.add(iptRbtn);
	
		TranslucentButton iptLbtn = new TranslucentButton("IMPORT");		// LAB
		iptLbtn.setBorderPainted(false);							
		iptLbtn.setForeground(new Color(0, 0, 0));				//go to back
		iptLbtn.setBackground(Color.WHITE);
		iptLbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		iptLbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				importDeptChoice(2);
			}
		});
		iptLbtn.setBounds(375, 69, 144, 28);
		LAddP.add(iptLbtn);
	
		TranslucentButton iptTbtn = new TranslucentButton("IMPORT");		// Teacher
		iptTbtn.setBorderPainted(false);							
		iptTbtn.setForeground(new Color(0, 0, 0));				//go to back
		iptTbtn.setBackground(Color.WHITE);
		iptTbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		iptTbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				importDeptChoice(3);
			}
		});
		iptTbtn.setBounds(375, 69, 144, 28);
		TAddP.add(iptTbtn);
		
		
		
		/*
		ImageIcon imageIcon = new ImageIcon("rr.jpg"); // load the image to a imageIcon
		Image image1 = imageIcon.getImage(); // transform it 
		Image newimg = image1.getScaledInstance(700, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		JLabel lblNewLabe2 = new JLabel("");
		lblNewLabe2.setIcon(imageIcon);
		lblNewLabe2.setBounds(0, 0, 584, 461);
		contentPane.add(lblNewLabe2);
	
		*/
		
		
		JLabel lblSelectAnyAttribute = new JLabel("      SELECT ANY ATTRIBUTE");
		lblSelectAnyAttribute.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSelectAnyAttribute.setBounds(61, 11, 452, 53);
		AskADD.add(lblSelectAnyAttribute);
		
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
		JLabel llabel4 = new JLabel("");
		llabel4.setIcon(imageIcon);
		llabel4.setBounds(0 ,0, 600, 500);
		JLabel llabel5 = new JLabel("");
		llabel5.setIcon(imageIcon);
		llabel5.setBounds(0 ,0, 600, 500);
		JLabel llabel6 = new JLabel("");
		llabel6.setIcon(imageIcon);
		llabel6.setBounds(0 ,0, 600, 500);
		
		AskADD.add(llabel);
		CAddPanel.add(llabel2);
		SAddP.add(llabel3);
		RAddP.add(llabel4);
		LAddP.add(llabel5);
		TAddP.add(llabel6);
		
	}
	

	
	
	
	
	
	void goback()
	{
		prev.setVisible(true);
		this.setVisible(false);
		this.dispose();		
		
	}
	
	void importDeptChoice(int ch)
	{
		int i,j=AllDept.size(),k=0;
		if(j==0||j==1)
		{
			JOptionPane.showMessageDialog(this, "No Other Projects Present!");
		}
		
		String[] impStr=new String[j];
		impStr[k++]="Select Any One";
		for(i=0;i<j;i++)
		{
			if(dd.departN.equals(AllDept.get(i).departN))
			{
				continue;
			}
			impStr[k++]=AllDept.get(i).departN;
		}
		
		Object selection = JOptionPane.showInputDialog(this, "Select Any One DepartMent",
		        " Import From", JOptionPane.QUESTION_MESSAGE, null, impStr, impStr[0]);

		if(impStr[0].equals(selection) || selection==null)
		{
			return;
		}

		for(i=0;i<j;i++)
		{
			if(selection.equals(AllDept.get(i).departN))
			{
				switch(ch)
				{
				case 1:selectimportRoom(i);
						break;
				case 2:selectimportLAB(i);
						break;
				case 3:selectimportTeacher(i);
						break;
				}
			}
		}
		
	}
	
	void selectimportRoom(int idx)
	{
		DeptData DTemp=AllDept.get(idx);
		int i,j=DTemp.rooms.size(),k=0;
		if(j==0)
		{
			JOptionPane.showMessageDialog(this, "No Rooms Present!");
		    return;
		}
		String[] impStr=new String[j+1];
		impStr[k++]="Select Any One Room";
		for(i=0;i<j;i++)
		{
			if(dd.departN.equals(DTemp.rooms.get(i).FarDeptName))
			{impStr[k++]=DTemp.rooms.get(i).Rname;}
		}
		if(k==1)
		{
			JOptionPane.showMessageDialog(this, "No Rooms Present!");
			return;
		}
		
		Object selection = JOptionPane.showInputDialog(this, "Select Any One Room",
		        " Import From"+DTemp.departN, JOptionPane.QUESTION_MESSAGE, null, impStr, impStr[0]);

		if(impStr[0].equals(selection) || selection==null)
		{
			return ;
		}
		
		for(i=0;i<j;i++)
		{
			if(selection.equals(DTemp.rooms.get(i).Rname))
			{
				
				int fkg=checkcopy(DTemp.rooms.get(i).Rname,1);
				if(fkg==0)
				{
					Room sTemp=DTemp.rooms.get(i);
					Room rTemp=new Room();
					rTemp.aflag=sTemp.aflag;
					rTemp.Rname=sTemp.Rname;
					rTemp.FarDeptName=sTemp.FarDeptName;
					rTemp.T_T=sTemp.T_T;
					rTemp.available=sTemp.available;
					
				dd.rooms.add(rTemp);
				deleteRoomAll();
				RoomTableDisp();
				}
				else
				{
					JOptionPane.showMessageDialog(this, " Room Name Already Present!");					
				}
				break;
			}
		}		
	}
	
	void selectimportLAB(int idx)
	{
		DeptData DTemp=AllDept.get(idx);
		int i,j=DTemp.Lrooms.size(),k=0;
		if(j==0)
		{
			JOptionPane.showMessageDialog(this, "No LabRooms Present!");
			return;
		}
		String[] impStr=new String[j+1];
		impStr[k++]="Select Laboratory";
		for(i=0;i<j;i++)
		{
			if(dd.departN.equals(DTemp.Lrooms.get(i).FarDeptName))
			{impStr[k++]=DTemp.Lrooms.get(i).Rname;}
		}
		if(k==1)
		{
			JOptionPane.showMessageDialog(this, "No LabRooms Present!");
				return;
		}
		
		
		Object selection = JOptionPane.showInputDialog(this, "Select Any One Laboratory",
		        " Import From"+DTemp.departN, JOptionPane.QUESTION_MESSAGE, null, impStr, impStr[0]);
		
		if(impStr[0].equals(selection) || selection==null)
		{
			return;
		}

		for(i=0;i<j;i++)
		{
			if(selection.equals(DTemp.Lrooms.get(i).Rname))
			{

				int fkg=checkcopy(DTemp.Lrooms.get(i).Rname,2);
				if(fkg==0)
				{
					Room sTemp=DTemp.Lrooms.get(i);
					Room rTemp=new Room();
					rTemp.aflag=sTemp.aflag;
					rTemp.Rname=sTemp.Rname;
					rTemp.FarDeptName=sTemp.FarDeptName;
					rTemp.T_T=sTemp.T_T;
					rTemp.available=sTemp.available;
					
				dd.Lrooms.add(rTemp);
				deleteLabRoomAll();
				LabTableDisp();
				}
				else
				{
					JOptionPane.showMessageDialog(this, " Laboratory Name Already Present!");										
				}
				break;
				
			}
		}
	}
	
	void selectimportTeacher(int idx)
	{
		DeptData DTemp=AllDept.get(idx);
		int i,j=DTemp.teachers.size(),k=0;
		if(j==0)
		{
			JOptionPane.showMessageDialog(this, "No Teachers Present!");
			return;
		}
		String[] impStr=new String[j+1];
		impStr[k++]="Select Teacher";
		for(i=0;i<j;i++)
		{
			if(dd.departN.equals(DTemp.teachers.get(i).FarDeptName))
			{impStr[k++]=DTemp.teachers.get(i).name;}
		}
		if(k==1)
		{
			JOptionPane.showMessageDialog(this, "No Teachers Present!");
			return;
		}
		
		Object selection = JOptionPane.showInputDialog(this, "Select Any One Teacher",
		        " Import From "+DTemp.departN, JOptionPane.QUESTION_MESSAGE, null, impStr, impStr[0]);
		
		if(impStr[0].equals(selection) || selection==null)
		{
			return;
		}
		
		for(i=0;i<j;i++)
		{
			if(selection.equals(DTemp.teachers.get(i).name))
			{

				int fkg=checkcopy(DTemp.teachers.get(i).name,3);
				if(fkg==0)
				{
					Teacher sTEmp=DTemp.teachers.get(i);
					Teacher rTEmp=new Teacher();
					rTEmp.name=sTEmp.name;
					rTEmp.FarDeptName=sTEmp.FarDeptName;
					rTEmp.aflag=sTEmp.aflag;
					rTEmp.shortName=sTEmp.shortName;
					rTEmp.shift=sTEmp.shift;
					rTEmp.ideal=sTEmp.ideal;
					rTEmp.available=sTEmp.available;
					rTEmp.T_T=sTEmp.T_T;
					
				dd.teachers.add(rTEmp);
				deleteTeacherAll();
				TeacherTableDisp();
				}
				else
				{
					JOptionPane.showMessageDialog(this, " Teacher Name Already Present!");					
				}
				break;
				
			}
		}
		
	}
	
	int checkcopy(String nme,int ch)
	{
		int i,j;
		
		switch(ch)
		{
		case 1:j=dd.rooms.size();
				for(i=0;i<j;i++)
				{
					if(nme.equals(dd.rooms.get(i).Rname))
					{
						return 1;
					}
				}
				break;
			
		case 2:j=dd.Lrooms.size();
				for(i=0;i<j;i++)
				{
					if(nme.equals(dd.Lrooms.get(i).Rname))
					{
						return 1;
					}
				}
				break;
	
		case 3:j=dd.teachers.size();
				for(i=0;i<j;i++)
				{
					if(nme.equals(dd.teachers.get(i).name))
					{
						return 1;
					}
				}
				break;

		}
		return 0;
	}
	
	
	void insertDivision()
	{
		dd.curr_subjects=null;
		DefaultTableModel edm = (DefaultTableModel)ClassTable.getModel();
		
		Division DTemp=new Division();
		DTemp.name=DivnameTF.getText();
		DTemp.year=yearBox.getSelectedIndex()+1;
		DTemp.shift=(ClassTogBut.isSelected())? 2:1;
		DTemp.practTime=-1;
		DTemp.batches=BatchCB.getSelectedIndex()+2;
		dd.divs.add(DTemp);
		DivnameTF.setText("");
		
		
		String[] tmps=new String[6];
		tmps[0]=DTemp.name;
		tmps[1]=Integer.toString(DTemp.year);
		tmps[2]=Integer.toString(DTemp.batches);
		tmps[3]=Integer.toString(DTemp.shift);
		tmps[4]=DTemp.GFM;
		if(DTemp.practTime==-1)
			tmps[5]="---";
		else
		tmps[5]=Integer.toString(DTemp.practTime);
		
		int z=ClassTable.getRowCount();
		edm.insertRow(z, new Object[] { tmps[0],tmps[1],tmps[2],tmps[3],tmps[4],tmps[5]});

		
	}

	void insertSubject()
	{

		dd.curr_subjects=null;
		Subject STemp=new Subject();
		STemp.name=SubAddTF.getText();
		STemp.year=SubYearBox.getSelectedIndex()+1;
		STemp.sem=(togbutton.isSelected())? 2:1;
		STemp.inDEX=dd.subjects.size();
		STemp.Sname=SNTF.getText();
		dd.subjects.add(STemp);
		SubAddTF.setText("");
		SNTF.setText("");
		
		
		DefaultTableModel edm = (DefaultTableModel)Stable.getModel();
		
			String[] tmps=new String[4];
			tmps[0]=STemp.name;
			tmps[1]=STemp.Sname;
			tmps[2]=Integer.toString(STemp.year);
			tmps[3]=Integer.toString(STemp.sem);
			
			int z=Stable.getRowCount();
			edm.insertRow(z, new Object[] { tmps[0],tmps[1],tmps[2],tmps[3]});
		
		
	}
	
	void insertCRoom()
	{
		dd.curr_subjects=null;                                                   // erase previous LDT data 
		Room RTemp=new Room();
		RTemp.FarDeptName=dd.departN;
		RTemp.Rname=RoomAddTF.getText();
		RTemp.aflag=false;
		dd.rooms.add(RTemp);
		RoomAddTF.setText("");
		
		DefaultTableModel edm = (DefaultTableModel)RoomTable.getModel();
		
		
			String[] tmps=new String[1];
			tmps[0]=RTemp.Rname;
			
			int z=RoomTable.getRowCount();
			edm.insertRow(z, new Object[] { tmps[0]});
		
		
		
	}

	void insertLRoom()
	{

		dd.curr_subjects=null;
		Room LTemp=new Room();
		LTemp.FarDeptName=dd.departN;
		LTemp.Rname=LRoomTF.getText();
		LTemp.aflag=false;
		
		dd.Lrooms.add(LTemp);
		LRoomTF.setText("");
		
		DefaultTableModel edm = (DefaultTableModel)LabTable.getModel();
		
			String[] tmps=new String[1];
			tmps[0]=LTemp.Rname;
			
			int z=LabTable.getRowCount();
			edm.insertRow(z, new Object[] { tmps[0]});
		
	}
	
	void insertTeach()
	{

		dd.curr_subjects=null;
		Teacher TTemp=new Teacher();
		TTemp.FarDeptName=dd.departN;
		TTemp.name=TeachAddTF.getText();
		TTemp.shortName=TeachSnTF.getText();
		TTemp.shift=(TeachTogBut.isSelected())? 2:1;
		TTemp.aflag=false;
		dd.teachers.add(TTemp);
		TeachAddTF.setText("");
		TeachSnTF.setText("");
		
		DefaultTableModel edm = (DefaultTableModel)TeacherTable.getModel();
		
		
			String[] tmps=new String[3];
			tmps[0]=TTemp.name;
			tmps[1]=TTemp.shortName;
			tmps[2]=Integer.toString(TTemp.shift);
			
			
			int z=TeacherTable.getRowCount();
			edm.insertRow(z, new Object[] { tmps[0],tmps[1],tmps[2]});
		
	}
	
	
	void deleteClassRecAll()
	{
		
		DefaultTableModel dm = (DefaultTableModel)ClassTable.getModel();
		int rowCount = dm.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
		
	}
	
	
	void ClassTableDisp()
	{
		
		DefaultTableModel edm = (DefaultTableModel)ClassTable.getModel();
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
		tmps[5]=Integer.toString(tdivs.get(z).practTime);
		
		edm.insertRow(z, new Object[] { tmps[0],tmps[1],tmps[2],tmps[3],tmps[4],tmps[5]});
	}
	
	}
	
	void deleteSubAll()
	{
		DefaultTableModel dm = (DefaultTableModel)Stable.getModel();
		int rowCount = dm.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
		
	}
	
	void SubTableDisp()
	{
		
		DefaultTableModel edm = (DefaultTableModel)Stable.getModel();
		int SubCount=dd.subjects.size();
	    Vector<Subject> tSubs=dd.subjects;
		for(int z=0;z<SubCount;z++)
		{
			String[] tmps=new String[4];
			tmps[0]=tSubs.get(z).name;
			tmps[1]=tSubs.get(z).Sname;
			tmps[2]=Integer.toString(tSubs.get(z).year);
			tmps[3]=Integer.toString(tSubs.get(z).sem);
			edm.insertRow(z, new Object[] { tmps[0],tmps[1],tmps[2],tmps[3]});
		}
		
	}
	
	void deleteRoomAll()
	{
		DefaultTableModel dm = (DefaultTableModel)RoomTable.getModel();
		int rowCount = dm.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
		
	}
	
	void RoomTableDisp()
	{
		DefaultTableModel edm = (DefaultTableModel)RoomTable.getModel();
		
		int RoomCount=dd.rooms.size();
	    Vector<Room> tRooms=dd.rooms;
		for(int z=0;z<RoomCount;z++)
		{
			String[] tmps=new String[1];
			tmps[0]=tRooms.get(z).Rname;
			
			edm.insertRow(z, new Object[] { tmps[0]});
		}
	}
	
	
	void deleteLabRoomAll()
	{
		DefaultTableModel dm = (DefaultTableModel)LabTable.getModel();
		int rowCount = dm.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
		
	}
	
	
	void LabTableDisp()
	{
		DefaultTableModel edm = (DefaultTableModel)LabTable.getModel();
		
		int LRoomCount=dd.Lrooms.size();
	    Vector<Room> tLRooms=dd.Lrooms;
		for(int z=0;z<LRoomCount;z++)
		{
			String[] tmps=new String[1];
			tmps[0]=tLRooms.get(z).Rname;
			
			edm.insertRow(z, new Object[] { tmps[0]});
		}
		
	}
	
	void deleteTeacherAll()
	{
		DefaultTableModel dm = (DefaultTableModel)TeacherTable.getModel();
		int rowCount = dm.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
		
	}
	
	
	void TeacherTableDisp()
	{
		DefaultTableModel edm = (DefaultTableModel)TeacherTable.getModel();
		
		int teachCount=dd.teachers.size();
	    Vector<Teacher> tTeach=dd.teachers;
		for(int z=0;z<teachCount;z++)
		{
			String[] tmps=new String[3];
			tmps[0]=tTeach.get(z).name;
			tmps[1]=tTeach.get(z).shortName;
			tmps[2]=Integer.toString(tTeach.get(z).shift);
			
			edm.insertRow(z, new Object[] { tmps[0],tmps[1],tmps[2]});
		}
	}
}
