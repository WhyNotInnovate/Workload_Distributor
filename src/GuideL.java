import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class GuideL extends JFrame {

	private JPanel contentPane;
	private JFrame prev;
	public SqlTry sqlo;
	
	public GuideL(JFrame F,SqlTry sO) {
		sqlo=sO;
		prev=F;
	
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowClosingDemo.windowClosing");
                	
                int v=JOptionPane.showConfirmDialog(contentPane.getParent(), "Are you sure you want to Exit?", "WARNING",
                        JOptionPane.YES_NO_OPTION);
                if ( v== JOptionPane.YES_OPTION) 
                {
                	sqlo.closeCon();
                	System.exit(0);
                }
                else //if(v == JOptionPane.NO_OPTION)
                {
                	
                }
                
            }
        });	
		
		setBounds(prev.getX(), prev.getY(), 600, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblGuidelinesForTimetable = new JLabel("Guidelines for Timetable creation");
		lblGuidelinesForTimetable.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblGuidelinesForTimetable.setBounds(72, 11, 512, 31);
		contentPane.add(lblGuidelinesForTimetable);
		
		TranslucentButton btnBack = new TranslucentButton("BACK");
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBorderPainted(false);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			hello();
			}
		});
		btnBack.setBounds(10, 414, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Name of Project:-  AISSMS IOIT TIME TABLE CREATOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 78, 564, 41);
		contentPane.add(lblNewLabel);
		
	
	
		String s1="okk we go ";
	
		
		
		
		
		ImageIcon imageIcon = new ImageIcon("rr.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(700, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		JLabel llabel = new JLabel("");
		llabel.setIcon(imageIcon);
		llabel.setBounds(0 ,0, 600, 500);
		contentPane.add(llabel);
		
		
		
		
		
		
		
	}
	void hello()
	{
		System.out.println("hello");
	prev.setVisible(true);
	this.setVisible(false);
	this.dispose();
	}
	
	
	
}
