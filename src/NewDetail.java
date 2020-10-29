import java.awt.BorderLayout;
import java.util.Calendar;
import java.util.Vector;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NewDetail extends JFrame {

	private JPanel contentPane;
	private JFrame  prev;
	private JTextField txtItDepartment;
	private JComboBox comboBox,DDCB;
	private String[] yrs; 
	JToggleButton tglbtnNewToggleButton;
	JDatePickerImpl datePicker;
	public SqlTry sqlo;
	private JTextField DateTF;
	public Vector<DeptData> AllDept;
	 
	
	
	public NewDetail(JFrame F, SqlTry sql,Vector<DeptData> T_AllDept) {
		prev=F;
		sqlo=sql;
		AllDept=T_AllDept;
 
		
		dateCal();
		

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
		
		setBounds(prev.getX(), prev.getY(), 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name of Project");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(21, 103, 154, 38);
		contentPane.add(lblNewLabel);
		
		
		
		txtItDepartment = new JTextField();
		txtItDepartment.setBackground(Color.WHITE);
		txtItDepartment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtItDepartment.setText("IT Project 1");
		txtItDepartment.setBounds(214, 99, 303, 42);
		contentPane.add(txtItDepartment);
		txtItDepartment.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Academic Year");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(21, 163, 154, 38);
		//contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Effect from Date ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(21, 166, 154, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Details of Project");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_3.setBounds(128, 22, 366, 42);
		contentPane.add(lblNewLabel_3);
		
		TranslucentButton btnNewButton = new TranslucentButton("Proceed");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				proceedClicked();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(353, 360, 200, 49);
		contentPane.add(btnNewButton);
		
		comboBox = new JComboBox(yrs);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(214, 160, 301, 49);
		//contentPane.add(comboBox);
		
	
	
	
		tglbtnNewToggleButton = new JToggleButton("Sem-I");
		tglbtnNewToggleButton.setBackground(Color.WHITE);
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(tglbtnNewToggleButton.isSelected())
				{
					tglbtnNewToggleButton.setText("Sem-II");
				}
				else
				{
					tglbtnNewToggleButton.setText("Sem-I");
				}
			}
		});
		tglbtnNewToggleButton.setBounds(214, 230, 303, 42);
		contentPane.add(tglbtnNewToggleButton);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBackground(new Color(240, 240, 240));
		lblSemester.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSemester.setBounds(21, 230, 85, 22);
		contentPane.add(lblSemester);
		
		TranslucentButton btnNewButton_1 = new TranslucentButton("BACK");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goBack();
			}
		});
		btnNewButton_1.setBounds(10, 412, 85, 38);
		contentPane.add(btnNewButton_1);
		
		DateTF = new JTextField();
		DateTF.setBackground(Color.WHITE);
		DateTF.setBounds(214, 166, 303, 42);
		contentPane.add(DateTF);
		DateTF.setColumns(10);
		
		String[] ddn= {"IT","COMP","ENTC","INSTRU","ELECTRIC","FE"};
		String[] ddsn= {"Department of Information Technology",
		 		"Department of Computer Science",
		 		"Department of Electronics And Telecommunication",
		 		"Department of Instrumentation",
		 		"Department of Electrical Engineering",
		 		"Department of First Year Engineering"	        			 
		 
 };
		DDCB = new JComboBox(ddsn);
		DDCB.setBackground(Color.WHITE);
		DDCB.setFont(new Font("Tahoma", Font.BOLD, 13));
		DDCB.setBounds(214, 290, 303, 42);
		contentPane.add(DDCB);
		
		JLabel lblDepartmentName = new JLabel("Department Name");
		lblDepartmentName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepartmentName.setBounds(21, 286, 165, 49);
		contentPane.add(lblDepartmentName);
		
		
		
		
		

		ImageIcon imageIcon = new ImageIcon("rr.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(700, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		JLabel llabel = new JLabel("");
		llabel.setIcon(imageIcon);
		llabel.setBounds(0 ,0, 600, 500);
		contentPane.add(llabel);
		
	}
	
	
	void dateCal()
	{
		yrs=new String[2];
		int year = Calendar.getInstance().get(Calendar.YEAR);
		yrs[0]=String.valueOf(year-1)+"-"+String.valueOf(year%2000);
		yrs[1]=String.valueOf(year)+"-"+String.valueOf((year+1)%2000);
		
		
	}
	
	void proceedClicked()
	{
		String sf="";
		String date="";
		if(sf.equals(txtItDepartment.getText()) || date.equals(DateTF.getText()))
		{
			return;
		}
		
		sf=txtItDepartment.getText();
		date=DateTF.getText();
		int tsem=(tglbtnNewToggleButton.isSelected())?2:1;
		//Strin Date;
//		String yr=(String) comboBox.getSelectedItem();
		String ddn=(String) DDCB.getSelectedItem();
		
		int i,j=AllDept.size();
		
		for(i=0;i<j;i++)
		{
			if(sf.equals(AllDept.get(i).departN))
			{
				System.out.println("SAME NAME");
				String tmsg="Project Name Already Exits.";
				toast t = new toast(tmsg,this.getX()+(int)(0.5*this.getWidth())-(tmsg.length()*4),this.getY()+(int)(0.85*this.getHeight())); 
			    t.showtoast(); 
			    
				return;
					
			}
		}
		
		
		
		
		
		DeptData dd=new DeptData(sf, tsem,null,date,ddn);
		AllDept.add(dd);
		Menu m=new Menu(this,dd,sqlo,AllDept);
		m.setVisible(true);
		this.setVisible(false);
		
	}
	void goBack()
	{
		prev.setVisible(true);
		this.setVisible(false);
		this.dispose();		
	}
}
