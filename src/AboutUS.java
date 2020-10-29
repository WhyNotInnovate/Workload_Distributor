import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class AboutUS extends JFrame {

	private JPanel contentPane;
	private JFrame prev;
	public SqlTry sqlo;
	
	public AboutUS(JFrame frmHello,SqlTry sO) {
		sqlo=sO;
		prev=frmHello;
		
		
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
		
		JLabel lblNewLabel = new JLabel("             ABOUT US");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(138, 11, 403, 72);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Description:-");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(32, 85, 132, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblThanksTo = new JLabel("Developing Team:-");
		lblThanksTo.setBackground(Color.WHITE);
		lblThanksTo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThanksTo.setBounds(32, 264, 182, 45);
		contentPane.add(lblThanksTo);
		
		TranslucentButton btnBack = new TranslucentButton("BACK");
		btnBack.setBorderPainted(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goback();
	
			}
		});

		btnBack.setForeground(new Color(0, 0 ,0));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.setBounds(10, 391, 89, 29);
		contentPane.add(btnBack);
		
	
		//Image Display
		
		ImageIcon imageIcon = new ImageIcon("rr.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(700, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setIcon(imageIcon);
		lblNewLabel1.setBounds(0 ,0, 600, 500);
		contentPane.add(lblNewLabel1);
		
	}
	
	void goback()
	{
		prev.setVisible(true);
		this.setVisible(false);
		this.dispose();
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
}
