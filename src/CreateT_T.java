import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class CreateT_T extends JFrame {

	private JPanel contentPane;
	private ProceedPart1 prev;
	private DeptData dd;
	private String Academicyear,Date;
	public SqlTry sqlo;
	public Vector<DeptData> AllDept;
	 
	
	public CreateT_T(ProceedPart1 m,DeptData ddt,SqlTry sO,Vector<DeptData> T_AllDept) {
		prev=m;
		dd=ddt;
		sqlo=sO;
		AllDept=T_AllDept;

		
		String[] curr= {"2018-19","2019-20","2020-21","2021-22"};
		Academicyear=(String) JOptionPane.showInputDialog(null, "Select Any One",
		        "Academic Year", JOptionPane.QUESTION_MESSAGE, null, curr, curr[0]);
		
		
		
		
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
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TranslucentButton btnNewButton = new TranslucentButton("TEACHER");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(new Color(0, 0, 0));

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				teachClicked();
			}
		});
		btnNewButton.setBounds(184, 101, 215, 48);
		contentPane.add(btnNewButton);
		
		TranslucentButton btnNewButton_1 = new TranslucentButton("CLASS");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				classClicked();
				
			}
		});
		btnNewButton_1.setBounds(184, 173, 215, 44);
		contentPane.add(btnNewButton_1);
		
		TranslucentButton btnNewButton_2 = new TranslucentButton("CLASS ROOM");
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				classRClicked();
			}
		});
		btnNewButton_2.setBounds(184, 242, 215, 48);
		contentPane.add(btnNewButton_2);
		
		TranslucentButton btnNewButton_3 =new TranslucentButton("LABORATORY");
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LabClicked();
			}
		});
		btnNewButton_3.setBounds(184, 314, 215, 44);
		contentPane.add(btnNewButton_3);
		
		TranslucentButton btnNewButton_4 = new TranslucentButton("SAVE TO IMAGE");
		btnNewButton_4.setForeground(new Color(0, 0, 0));
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_4.setBounds(184, 327, 215, 44);
		//contentPane.add(btnNewButton_4);
		
		TranslucentButton btnBack = new TranslucentButton("BACK");
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setBorderPainted(false);
		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				goback();
			}
		});
		btnBack.setBounds(10, 423, 97, 27);
		contentPane.add(btnBack);
		
		JLabel lblSelectAnyAttribute = new JLabel("TIME TABLE CREATED");
		lblSelectAnyAttribute.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblSelectAnyAttribute.setBounds(144, 11, 311, 57);
		contentPane.add(lblSelectAnyAttribute);

		ImageIcon imageIcon = new ImageIcon("rr.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(700, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		JLabel llabel = new JLabel("");
		llabel.setIcon(imageIcon);
		llabel.setBounds(0 ,0, 600, 500);
		contentPane.add(llabel);
		
	
	
	}

	void teachClicked()
	{
		int tC=dd.teachers.size();
		int in=tC;
		String[] myStr=new String[tC];
		for(int z=0;z<tC;z++)
		{
			myStr[z]=dd.teachers.get(z).name;
		}
		
		Object selection = JOptionPane.showInputDialog(null, "Select Any One",
				        "Teachers Name", JOptionPane.QUESTION_MESSAGE, null, myStr, myStr[0]);
	
		for(int z=0;z<tC;z++)
		{
			if(myStr[z].equals(selection))
			{
				in=z;
				break;
			}
		}
		if(in==tC)
		{
		System.out.println("Selection error");	
		return;
		}
		
		TeachPDF tdf= new TeachPDF(this,dd,in,Academicyear,Date,sqlo);
		tdf.setVisible(true);
		
	}
	
	void classClicked()
	{
		int tC=dd.divs.size();
		int in=tC;
		String[] myStr=new String[tC];
		for(int z=0;z<tC;z++)
		{
			myStr[z]=dd.divs.get(z).name;
		}
		
		Object selection = JOptionPane.showInputDialog(null, "Select Any One",
				        "Teachers Name", JOptionPane.QUESTION_MESSAGE, null, myStr, myStr[0]);
	
		for(int z=0;z<tC;z++)
		{
			if(myStr[z].equals(selection))
			{
				in=z;
				break;
			}
		}
		if(in==tC)
		{
		System.out.println("Selection error");	
		return;
		}
		
		ClassPDF cdf=new ClassPDF(this,dd,in,Academicyear,Date,sqlo);
		cdf.setVisible(true);
		
		
	}
	
	void classRClicked()
	{
		int tC=dd.rooms.size();
		int in=tC;
		String[] myStr=new String[tC];
		for(int z=0;z<tC;z++)
		{
			myStr[z]=dd.rooms.get(z).Rname;
		}
		
		Object selection = JOptionPane.showInputDialog(null, "Select Any One",
				        "Room Name", JOptionPane.QUESTION_MESSAGE, null, myStr, myStr[0]);
	
		for(int z=0;z<tC;z++)
		{
			if(myStr[z].equals(selection))
			{
				in=z;
				break;
			}
		}
		if(in==tC)
		{
		System.out.println("Selection error");	
		return;
		}
		
		RoomPDF rdf=new RoomPDF(this,dd,in,Academicyear,Date,sqlo);
		rdf.setVisible(true);
		
	}
	
	void LabClicked()
	{
		int tC=dd.Lrooms.size();
		int in=tC;
		String[] myStr=new String[tC];
		for(int z=0;z<tC;z++)
		{
			myStr[z]=dd.Lrooms.get(z).Rname;
		}
		
		Object selection = JOptionPane.showInputDialog(null, "Select Any One",
				        "Lab Name", JOptionPane.QUESTION_MESSAGE, null, myStr, myStr[0]);
	
		for(int z=0;z<tC;z++)
		{
			if(myStr[z].equals(selection))
			{
				in=z;
				break;
			}
		}
		if(in==tC)
		{
		System.out.println("Selection error");	
		return;
		}
		
		LabPDF ldf= new LabPDF(this,dd,in,Academicyear,Date,sqlo);
		ldf.setVisible(true);
		
		
		
		
		
		
		
		ImageIcon imageIcon = new ImageIcon("rr.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(700, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		JLabel llabel = new JLabel("");
		llabel.setIcon(imageIcon);
		llabel.setBounds(0 ,0, 600, 500);
		contentPane.add(llabel);
		
	}
	

	void goback()
	{

		prev.setVisible(true);
		this.setVisible(false);
		this.dispose();		
		
	}


	
}
