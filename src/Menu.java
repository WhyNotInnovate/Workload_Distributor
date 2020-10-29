import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JTextField;

public class Menu extends JFrame {
	private JFrame prev;
	 DeptData dd;
	 SqlTry sO;
	 private JTextField EffectFrom;
	 public Vector<DeptData> AllDept;
	 
	public Menu(JFrame F,DeptData dn,SqlTry sqlTemp,Vector<DeptData> T_AllDept) {
		prev=F;
		dd=dn;
		sO=sqlTemp;
		AllDept=T_AllDept;

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
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		setBounds(prev.getX(), prev.getY(), 600, 500);
		
		TranslucentButton btnNewButton = new TranslucentButton("Add Department Data");								//add button
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gotoADDMenu();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton.setBounds(118, 78, 349, 58);
		getContentPane().add(btnNewButton);
		
		TranslucentButton btnVerfyDetail = new TranslucentButton("Proceed With New Data");				//verify and proceed button
		btnVerfyDetail.setForeground(new Color(0, 0, 0));
		btnVerfyDetail.setBorderPainted(false);
		btnVerfyDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				dd.EffectFrom=EffectFrom.getText();
				proceedClicked();
			}
		});
		btnVerfyDetail.setBackground(Color.WHITE);
		btnVerfyDetail.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnVerfyDetail.setBounds(118, 216, 349, 58);
		getContentPane().add(btnVerfyDetail);
		
		TranslucentButton btnNewButton_2 = new TranslucentButton("Save Department Details");					//save details button
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				saveClicked();
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_2.setBounds(118, 359, 349, 62);
		getContentPane().add(btnNewButton_2);
		
		TranslucentButton btnBack = new TranslucentButton("Back");
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setBorderPainted(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				//back button
				goBack();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBack.setBounds(10, 419, 95, 31);
		getContentPane().add(btnBack);
		
		JLabel depth = new JLabel("");
		depth.setFont(new Font("Tahoma", Font.BOLD, 25));
		depth.setHorizontalAlignment(SwingConstants.CENTER);
		depth.setBounds(143,11,299,56);
		getContentPane().add(depth);
		depth.setText(dd.departN);
		
		TranslucentButton btnNewButton_3 = new TranslucentButton("Rename");
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				
				String dname=JOptionPane.showInputDialog("hiii",dd.departN);
				
				if(dname==null ||dname.equals(""))
				{
					return;
				}
				dd.departN=dname;
				depth.setText(dname);
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_3.setBounds(118, 147, 349, 58);
		getContentPane().add(btnNewButton_3);
		
		TranslucentButton btnNewButton_1 = new TranslucentButton("Proceed With Previous Data");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dd.EffectFrom=EffectFrom.getText();
				proceed2Clicked();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_1.setBounds(118, 285, 349, 63);
		getContentPane().add(btnNewButton_1);
	
		

		String mysem="";
		if(dd.sem==1)
		{
			mysem="Sem-I";
		}
		else
		{
			mysem="Sem-II";	
		}
		JToggleButton tglbtnNewToggleButton = new JToggleButton(mysem);
		tglbtnNewToggleButton.setBackground(Color.WHITE);
		tglbtnNewToggleButton.setBounds(35, 30, 100, 30);
		
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(tglbtnNewToggleButton.isSelected())
				{
					tglbtnNewToggleButton.setText("Sem-II");
					dd.sem=2;
				}
				else
				{
					tglbtnNewToggleButton.setText("Sem-I");
					dd.sem=1;
				}
			}
		});
		
		
		getContentPane().add(tglbtnNewToggleButton);
		
		
		
		
		EffectFrom = new JTextField(dd.EffectFrom);
		EffectFrom.setHorizontalAlignment(SwingConstants.CENTER);
		EffectFrom.setBounds(450, 30, 100, 30);
		getContentPane().add(EffectFrom);
		EffectFrom.setColumns(10);
	
		
		

		ImageIcon imageIcon = new ImageIcon("rr.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(700, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		JLabel llabel = new JLabel("");
		llabel.setIcon(imageIcon);
		llabel.setBounds(0 ,0, 600, 500);
		getContentPane().add(llabel);
		
	}
	
	void goBack()
	{
		prev.setVisible(true);
		this.setVisible(false);
		this.dispose();		
	}

	void gotoADDMenu()
	{
		AddMenu am=new AddMenu(this,dd,sO,AllDept);
		am.setVisible(true);
		this.setVisible(false);
	}
	
	
	
	
	
	void saveClicked()
	{
		
		try
		{
		sO.wObj(AllDept);
		
		}catch(Exception e)
		{ e.printStackTrace();
		JOptionPane.showMessageDialog(this, "Not saved ", "Message",JOptionPane.WARNING_MESSAGE);
		return ;
		}
		JOptionPane.showMessageDialog(this, "Saved Successfully!!", "Message",
		        JOptionPane.WARNING_MESSAGE);
	
	
	}
	
	void proceedClicked()
	{
		ProceedPart1 pp1=new ProceedPart1(this,dd,false,sO,AllDept);
		pp1.setVisible(true);
		this.setVisible(false);
	}
	
	
	
	
	void proceed2Clicked()
	{
		
		if(dd.curr_subjects==null)
		{
			JOptionPane.showMessageDialog(this, "No Previous Data Present!!", "Message",
			        JOptionPane.WARNING_MESSAGE);
			
			return;
		}
		ProceedPart1 pp1=new ProceedPart1(this, dd,true,sO,AllDept);
		pp1.setVisible(true);
		this.setVisible(false);
	}
}

