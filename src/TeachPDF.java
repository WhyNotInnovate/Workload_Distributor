import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;

public class TeachPDF extends JFrame {

	private JPanel contentPane;
	private DeptData dd;
	private CreateT_T prev;
	private String aca,date;
	int idx;
	public SqlTry sqlo;
	
	public TeachPDF(CreateT_T m,DeptData ddt,int IDX,String ay,String da,SqlTry sO) {
		sqlo=sO;
		prev=m;
		dd=ddt;
		idx=IDX;
		aca=ay;
		date=da;
		
		int posX=28;
		int posY=160;
		int pX=80;
		int pY=60;

		Teacher tTemp=dd.teachers.get(IDX);
		
		String[] HtimeS1={"Day\\Time","8:00-9:00","9:00-10:00","10:00-10:15","10:15-11:15","11:15-12:15","12:15-1:00","1:00-2:00","2:00-3:00","3:00-4:00" };		
		String[] HtimeS2= {"Day\\Time","11:00-12:00","12:00-1:00","1:00-1:30","1:30-2:30","2:30-3:30","3:30-4:00","4:00-5:00","5:00-6:00","6:00-7:00"};
		String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

		
		
		System.out.println("TeacherPDF");
		System.out.println("in Teachpdf");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowClosingDemo.windowClosing");
                	
                	disposethis();
               
            }
        });
		
		setBounds(100, 100, 900,725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDepartmentOfInformation = new JLabel(dd.pdfname);
		lblDepartmentOfInformation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblDepartmentOfInformation.setBounds(256, 100, 400, 23);
		contentPane.add(lblDepartmentOfInformation);
		
		
		
		
		JLabel lblAcademicYear = new JLabel("Academic Year:");
		lblAcademicYear.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAcademicYear.setBounds(10, 112, 116, 23);
		contentPane.add(lblAcademicYear);
		
		JLabel lblName = new JLabel("Teacher Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(10, 134, 136, 19);
		contentPane.add(lblName);
		
		
		String Tname=dd.teachers.get(idx).name;
		
		JLabel lblNewLabel = new JLabel(Tname);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(150, 130, 202, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(aca);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setBounds(165, 110, 176, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Term:-");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(656, 114, 49, 19);
		contentPane.add(lblNewLabel_2);
		
		
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
		JLabel lblNewLabel_3 = new JLabel(s);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(726, 112, 127, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblWithEffectFrom = new JLabel("With Effect From:-");
		lblWithEffectFrom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWithEffectFrom.setBounds(572, 135, 136, 19);
		contentPane.add(lblWithEffectFrom);
		
		JLabel lblD = new JLabel(dd.EffectFrom);
		lblD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblD.setBounds(726, 133, 171, 22);
		contentPane.add(lblD);
		
		JLabel lblPreparedBy = new JLabel("PREPARED BY");
		lblPreparedBy.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPreparedBy.setBounds(55, 660, 117, 20);
		contentPane.add(lblPreparedBy);
		
		JLabel lblStaff = new JLabel("STAFF");
		lblStaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStaff.setBounds(229, 660, 51, 20);
		contentPane.add(lblStaff);
		
		JLabel lblTimeTableChairman = new JLabel("TIME TABLE  CHAIRMAN");
		lblTimeTableChairman.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTimeTableChairman.setBounds(358, 660, 202, 20);
		contentPane.add(lblTimeTableChairman);
		
		JLabel lblHod = new JLabel("HOD");
		lblHod.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHod.setBounds(656, 663, 46, 14);
		contentPane.add(lblHod);
		
		JLabel lblPrincipal = new JLabel("PRINCIPAL");
		lblPrincipal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrincipal.setBounds(762, 660, 92, 20);
		contentPane.add(lblPrincipal);
		
		
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
		
		JLabel Slabel = new JLabel("Subjects  :");
		Slabel.setBounds(28, 525, 63, 14);
		contentPane.add(Slabel);
		
		
		
		int e=(tTemp.shift==1)? 0: 3;
		if(e==0)
		{
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
		}
		else
		{
			for(int z=0;z<HtimeS1.length;z++)
			{
				JTextField mytext=new JTextField();
				mytext.setHorizontalAlignment(SwingConstants.CENTER);
				mytext.setText(HtimeS2[z]);
				mytext.setBackground(new Color(255,255,255));
				mytext.setEditable(false);
				  mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
					//txtGfj.setColumns(10);
				mytext.setBounds(z*pX +posX, posY, 80, 60);
				contentPane.add(mytext);
			
			}
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
//			txtGfj.setColumns(10);
			mytext.setBounds(posX, posY+ (z+1)*pY, 80, 60);
			contentPane.add(mytext);
		
		}
	
        String myts="";		
		int _pX=posX+pX,_pY;
		int dn1,rn1,sn1;
		teacher_st[][] timetable=tTemp.T_T;
		
		if(e==0)
		{
		  for(int k=0;k<dd.m;k++)
		  {
			//_pX=posX+pX;
			_pY= (k+1)*pY + posY;
			for(int l=0,z=0;z<9;z++)
			{
				if(z==2)
				{
					myts="\n     Break";
					
					 JTextArea mytext = new JTextArea();
					  mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
					  mytext.setText(myts);
					 
					mytext.setBounds((z+1)*pX +posX, _pY, pX, pY);
					//contentPane.add(mytext);
				
				}
				else if(l==4)
				{
					
					myts="\n     Break";
					l++;
					
					 JTextArea mytext = new JTextArea();
					  mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
						 mytext.setText(myts);
					 //					txtGfj.setColumns(10);
					
					mytext.setBounds((z+1)*pX +posX, _pY, pX, pY);
					//contentPane.add(mytext);
				
				}
				else if(timetable[k][l]==null)
				{
					myts="\n     Free";
					l++;
					
					 JTextArea mytext = new JTextArea();
					  mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
						mytext.setText(myts);
					 
//					txtGfj.setColumns(10);
					
					mytext.setBounds((z+1)*pX +posX, _pY, pX, pY);
					contentPane.add(mytext);

					
        			
				}else if(timetable[k][l].l_p==true)
				{
					dn1=timetable[k][l].cls;
        			rn1=timetable[k][l].r1;
        			sn1=timetable[k][l].sub;
        			myts="            "+dd.divs.get(dn1/4).name+"@"+(dn1%4+1) 
        				+"\n            "+dd.Lrooms.get(rn1).Rname
        				+"\n            "+dd.curr_subjects.get(sn1).Sname;
        			l++;
        			l++;
					
        			 JTextArea mytext = new JTextArea();
        			  mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
  					mytext.setText(myts);
        			 
//					txtGfj.setColumns(10);
					
					mytext.setBounds((z+1)*pX +posX, _pY, 2*pX, pY);
					contentPane.add(mytext);
					z++;
        			
        			
				}else
				{
					dn1=timetable[k][l].cls;
        			rn1=timetable[k][l].r1;
        			sn1=timetable[k][l].sub;
        			myts="     "+dd.divs.get(dn1).name
        				+"\n     "+dd.rooms.get(rn1).Rname
        				+"\n     "+dd.curr_subjects.get(sn1).Sname;
        			l++;
        			//dd.subjects.get(sn1).name+
					
        			 JTextArea mytext = new JTextArea();
        			  mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
  					  mytext.setText(myts);
        			 
//					txtGfj.setColumns(10);
					
					mytext.setBounds((z+1)*pX +posX, _pY, pX, pY);
					contentPane.add(mytext);

				}
			}
		  }

		  //break
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

		  
		  
		}//shift 1
		else
		{
			for(int k=0;k<dd.m;k++)
			{
				//_pX=posX+pX;
				_pY= k*pY + posY;
				for(int l=e,z=0;z<9;z++)
				{
					if(z==5)
					{
						myts="Break";
						
						 JTextArea mytext = new JTextArea();
						  mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
						  mytext.setText(myts);
						 //						txtGfj.setColumns(10);
						
						mytext.setBounds((z+1)*pX +posX, _pY, pX, pY);
						//contentPane.add(mytext);
					
						  mytext.setBorder(new LineBorder(new Color(0, 0, 0)));

					}
					else if(e==5)
					{
						myts="Break";
						l++;
						 JTextArea mytext = new JTextArea();
						  mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
						  mytext.setText(myts);
						 //						txtGfj.setColumns(10);
						
						mytext.setBounds((z+1)*pX +posX, _pY, pX, pY);
						//contentPane.add(mytext);
					
					}
					else if(timetable[k][l]==null)
					{
						myts="\n     Free";
						l++;
						 JTextArea mytext = new JTextArea();
						  mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
						  mytext.setText(myts);
						 
//						txtGfj.setColumns(10);
						
						
						mytext.setBounds((z+1)*pX +posX, _pY, pX, pY);
						contentPane.add(mytext);

						
						continue;
	        			
					}else if(timetable[k][l].l_p==true)
					{
						dn1=timetable[k][l].cls;
	        			rn1=timetable[k][l].r1;
	        			sn1=timetable[k][l].sub;
	        			myts="            "+dd.divs.get(dn1/4).name+"@"+(dn1%4+1) 
	            				+"\n            "+dd.Lrooms.get(rn1).Rname
	            				+"\n            "+dd.curr_subjects.get(sn1).Sname;
	        			l++;
	        			l++;
						
	        			 JTextArea mytext = new JTextArea();
						  mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
	        			  mytext.setText(myts);
	        			 
//						txtGfj.setColumns(10);
						

	        			mytext.setBounds((z+1)*pX +posX, _pY, 2*pX, pY);
						contentPane.add(mytext);
						z++;
	        			
					}else
					{
						dn1=timetable[k][l].cls;
	        			rn1=timetable[k][l].r1;
	        			sn1=timetable[k][l].sub;
	        			myts="     "+dd.divs.get(dn1).name
	            				+"\n     "+dd.rooms.get(rn1).Rname
	            				+"\n     "+dd.curr_subjects.get(sn1).Sname;
	        			l++;
	        			
	        			 JTextArea mytext = new JTextArea();
						  mytext.setBorder(new LineBorder(new Color(0, 0, 0)));
	        			  mytext.setText(myts);
	        			 
						//txtGfj.setColumns(10);
						
						
						mytext.setBounds((z+1)*pX +posX, _pY, pX, pY);
						contentPane.add(mytext);
						
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

			
		}//shift 2
		
		
		int listpos=0;
		int xpp=0;
		int sl=tTemp.T_to_C.length;
		int coun=0;
		for(int i=0;i<sl;i++)
		{
			if(tTemp.T_to_C[i])
			{
				String ss="";
				ss+=dd.divs.get(i).name + " : ";
				ss+=dd.curr_subjects.get(tTemp.C_WSub[i]).name+"  ";
				ss+=" ("+  Integer.toString(tTemp.L_HM[i])+" Hrs)";
				coun+=tTemp.L_HM[i];
				System.out.println(ss);
				JLabel lbel=new JLabel(ss);
				 lbel.setFont(new Font("Tahoma", Font.PLAIN, 11));					
				lbel.setBounds( 92+ listpos*190, 525+(xpp++*20),180, 20);
				contentPane.add(lbel);
				if(xpp>=5)
				{
					listpos++;
					xpp=0;
				}
			}
		}
		
		for(int i=0;i<sl*4;i++)
		{
			if(tTemp.T_to_P[i])
			{
				String ss="";
				ss+=dd.divs.get(i/4).name +"@"+ Integer.toString(i%4 + 1)+ " : ";
				ss+=dd.curr_subjects.get(tTemp.P_WSub[i]).name+"  ";
				ss+=" ("+  Integer.toString(tTemp.P_HM[i]*2)+" Hrs)";
				coun+=tTemp.P_HM[i]*2;
				System.out.println(ss);
				JLabel lbel=new JLabel(ss);
				 lbel.setFont(new Font("Tahoma", Font.PLAIN, 11));
					
				lbel.setBounds( 92+ listpos*190, 525+(xpp++*20),180, 20);
				contentPane.add(lbel);
				if(xpp>=5)
				{
					listpos++;
					xpp=0;
				}
			}
		}
		
		String wkload="Work Load  : "+Integer.toString(coun)+" hrs";
		JLabel lblWorkLoad = new JLabel(wkload);
		lblWorkLoad.setBounds(695, 525, 136, 14);
		contentPane.add(lblWorkLoad);
		
		
		
	}
	
	void screenshot()
	{
		BufferedImage screenshotImage = new BufferedImage(
                this.getBounds().width, this.getBounds().height,
                BufferedImage.TYPE_INT_RGB);
        this.paint(screenshotImage.getGraphics());
        try {
            ImageIO.write(screenshotImage, "png", new File(dd.teachers.get(idx).name+".png" ));
        } catch (Exception ex) {
            System.err.println("ImageIsuues");
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
