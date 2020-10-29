import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Color;

public class LabPDF extends JFrame {

	private JPanel contentPane;
	private DeptData dd;
	private CreateT_T prev;
	private String aca,date;
	private int idx;
	public SqlTry sqlo;

	public LabPDF(CreateT_T m,DeptData ddt,int IDX,String ay,String da,SqlTry sO) {
		sqlo=sO;
		prev=m;
		dd=ddt;
		aca=ay;
		date=da;
		idx=IDX;
		
		
		int posX=28;
		int posY=160;
		int pX=60;
		int pY=50;
		
		Room Rtemp=  dd.Lrooms.get(idx);
		
		String[] HtimeS1={"Day\\Time","8:00-9:00","9:00-10:00","10:00-10:15","10:15-11:15","11:15-12:15","12:15-1:00","1:00-2:00","2:00-3:00","3:00-4:00","4:00-5:00","5:00-6:00","6:00-7:00" };		
		String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

		
		
		
		System.out.println("LABPDF");
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowClosingDemo.windowClosing");
                	
                	disposethis();
               
            }
        });
		
		setBounds(100, 100, 900, 725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_2 = new JLabel(dd.pdfname);
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		label_2.setBounds(256, 100, 400, 23);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Academic Year:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(28, 112, 116, 23);
		contentPane.add(label_3);
		
		JLabel lblLabName = new JLabel("Lab Name:");
		lblLabName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLabName.setBounds(28, 135, 101, 19);
		contentPane.add(lblLabName);
		
		JLabel label_5 = new JLabel("With Effect From:-");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(572, 135, 136, 19);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Term:-");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(656, 114, 49, 19);
		contentPane.add(label_6);
		
		
		 DefaultTableModel Tmodel = new DefaultTableModel();										//Division table
			
		 Tmodel.setColumnIdentifiers(new Object[]    {"Day / Time","8:00-9:00","9:00-10:00","10:00-11:00","11:00-12:00","12:00-1:00","1:00-2:00","2:00-3:00","3:00-4:00","4:00-5:00","5:00-6:00","6:00-7:00" });
		
		JLabel label_7 = new JLabel("PREPARED BY");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(55, 660, 117, 20);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("STAFF");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_8.setBounds(229, 660, 51, 20);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("TIME TABLE  CHAIRMAN");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_9.setBounds(358, 660, 202, 20);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("HOD");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_10.setBounds(656, 663, 46, 14);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("PRINCIPAL");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_11.setBounds(762, 660, 92, 20);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel(aca);
		label_12.setFont(new Font("Dialog", Font.BOLD, 15));
		label_12.setBounds(165, 110, 176, 27);
		contentPane.add(label_12);
		
		String Lname=dd.Lrooms.get(idx).Rname;

		JLabel label_13 = new JLabel(Lname);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_13.setBounds(139, 130, 202, 27);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel(dd.EffectFrom);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_14.setBounds(726, 133, 171, 22);
		contentPane.add(label_14);
		
		int shift=dd.sem;
		String s=null;
		if(shift==1)
		{
			s= "ODD";
		}
		else
		{
			s="EVEN";
		}
		
		JLabel label_15 = new JLabel(s);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_15.setBounds(726, 112, 127, 23);
		contentPane.add(label_15);	
		
		
		
		ImageIcon imageIcon = new ImageIcon("aissmsMain.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(500, 85,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		
		JLabel CentreImg = new JLabel("");
		CentreImg.setIcon(imageIcon);
		CentreImg.setBounds(201, 11, 500, 85);
		contentPane.add(CentreImg);
		
		TranslucentButton PrintButton = new TranslucentButton("Print");
		PrintButton.setForeground(new Color(0, 0, 0));
		PrintButton.setBorderPainted(false);
		PrintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrintButton.setVisible(false);
				
				savePDF();
				
				PrintButton.setVisible(true);
				
			}
		});
		PrintButton.setBounds(801, 11, 71, 23);
		contentPane.add(PrintButton);

		
		
		

		//timing
		for(int z=0;z<HtimeS1.length;z++)
		{
			JTextField mytext=new JTextField();
			mytext.setHorizontalAlignment(SwingConstants.CENTER);
			mytext.setText(HtimeS1[z]);
			mytext.setBackground(new Color(255,255,255));
			mytext.setEditable(false);
			  mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
				//				txtGfj.setColumns(10);
			mytext.setBounds(z*pX +posX, posY, pX, pY);
			contentPane.add(mytext);
		}

		// dispay days
				for(int z=0;z<dd.m;z++)
				{
					JTextField mytext=new JTextField();
					mytext.setHorizontalAlignment(SwingConstants.CENTER);
					mytext.setText(days[z]);
					mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
					mytext.setBackground(new Color(255,255,255));
					mytext.setEditable(false);
					mytext.setBounds(posX, posY+ (z+1)*pY, pX, pY);
					contentPane.add(mytext);
				}
				
				String myts="";		
				int _pX,_pY;
				int tn1,cls1,sn1;
				room_st[][] timetable=Rtemp.T_T;
						
				
				for(int k=0;k<dd.m;k++)
				  {
					//_pX=posX+pX;
					_pY= (k+1)*pY + posY;
					  for(int l=0,z=0 ;z<12;z++)
					  {
						  
						  if(z==2)
							{
							
							}
						  else if(l==4)
						  {
							  
							  l++;
						  }
						  else if(timetable[k][l]==null)
						  {
							  	myts="\n     Free";
								l++;
								
								JTextArea mytext = new JTextArea();
			        			 mytext.setFont(new Font("Tahoma", Font.PLAIN, 12));
								mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
								mytext.setText(myts);
								 
								mytext.setBounds((z+1)*pX +posX, _pY, pX, pY);
								contentPane.add(mytext);
						  }else
						  {
	     						tn1=timetable[k][l].t1;
			        			cls1=timetable[k][l].cls;
			        			sn1=timetable[k][l].sub;
			        			myts=" "+dd.teachers.get(tn1).shortName+"\n "+dd.divs.get(cls1/4).name+"@"+Integer.toString(cls1%4 +1)+"\n  "+dd.curr_subjects.get(sn1).Sname;
			        			
			        			JTextArea mytext = new JTextArea();
			        			mytext.setFont(new Font("Tahoma", Font.PLAIN, 12));
			        			mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
			  					mytext.setText(myts);
							
			  					mytext.setBounds((z+1)*pX +posX, _pY, 2*pX, pY);
								
			  				//	if(dd.divs.get(cls1).shift== && (l==6 || l==7))
			  				//{
			  				//		mytext.setBounds((z+1)*pX +posX -(pX/2), _pY, pX, pY);
			  				//}
			  					
								contentPane.add(mytext);
								l++;
								l++;
								z++;
						  }
					  }
				  }
		
		
		

				  String tbreak="\n\n\n\n\n\n\n\n     Tea \n     Break ";
					 JTextArea mytext = new JTextArea();
					  mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
						  mytext.setText(tbreak);
					mytext.setBounds(3*pX +posX,1*pY + posY , pX, pY*dd.m);
					contentPane.add(mytext);

					tbreak="\n\n\n\n\n\n\n\n     Lunch \n     Break ";	 
					  mytext = new JTextArea();
					  mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
						  mytext.setText(tbreak);
					mytext.setBounds(6*pX +posX,1*pY + posY , pX, pY*dd.m);
					contentPane.add(mytext);
		

					JLabel lblNewLabel = new JLabel("Staff  :");
					lblNewLabel.setBounds(46, 460, 49, 14);
					contentPane.add(lblNewLabel);

					int listpos=0;
					int xpp=0;
					
					int tsl=dd.teachers.size();

					for(int i=0;i<tsl;i++)
					{
					 		String ss="";
							ss+=dd.teachers.get(i).shortName + " : "+dd.teachers.get(i).name;
							System.out.println(ss);
							JLabel lbel=new JLabel(ss);
							 lbel.setFont(new Font("Tahoma", Font.PLAIN, 11));
							lbel.setBounds( 92+ listpos*190, 460+(xpp++*15),160, 20);
							contentPane.add(lbel);
					
							if(xpp>=6)
							{
								listpos++;
								xpp=0;
							}
					 
					}


		
		
		
		
		
		
		
	}
	
	void disposethis()
	{
		this.dispose();
	}

	
	void savePDF()
	{
		try {
			PrinterJob job= PrinterJob.getPrinterJob();
			job.setJobName("Print Data");
			
			job.setPrintable(new Printable() {
				
				@Override
				public int print(Graphics arg0, PageFormat arg1, int arg2) throws PrinterException {
					if(arg2>0)
					{
						return Printable.NO_SUCH_PAGE;
					}
					Graphics2D g2=(Graphics2D)arg0;
					g2.translate(arg1.getImageableX(), arg1.getImageableY());
					g2.scale(0.75, 0.75);
					
					contentPane.paint(g2);
					return Printable.PAGE_EXISTS;
				}
			});

			Boolean ok=job.printDialog();
			if(ok)
			{
				job.print();
				
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
