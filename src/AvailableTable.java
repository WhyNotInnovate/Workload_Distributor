import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AvailableTable extends JFrame {

	private JPanel contentPane;
	private LDTInput prev;
	private JTable table1;
	
	SqlTry sO;
	JComboBox List_all,Entity_Combox;
	DeptData dd;
	MyModel myM;
	public AvailableTable(LDTInput m,SqlTry sal,DeptData pdd) {
		prev=m;
		dd=pdd;
		sO=sal;
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowClosingDemo.windowClosing");
                	
                int v=JOptionPane.showConfirmDialog(contentPane.getParent(), "Are you sure you want to Exit?", "WARNING",
                        JOptionPane.YES_NO_OPTION);
                if ( v== JOptionPane.YES_OPTION) 
                {
                	sO.closeCon();
                	System.exit(0);
                }
                else //if(v == JOptionPane.NO_OPTION)
                {
                	
                }
                
            }
        });
		
		
		setBounds(prev.getX(), prev.getY(), 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String[] enSTR= {"Teacher","Room","Laboratory","Division"};
		Entity_Combox = new JComboBox(enSTR);
		Entity_Combox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				List_all.setSelectedIndex(-1);
				List_all.removeAllItems();
				int En_idx=Entity_Combox.getSelectedIndex();
				if(En_idx==0) 
				{
					System.out.println("E = "+0);
					int Tcoun=dd.teachers.size();
					for(int z=0;z<Tcoun;z++)
					{
						List_all.addItem(dd.teachers.get(z).name);
					}
					
				}
				else if(En_idx==1) 
				{
					System.out.println("E = "+1);
					int Rcoun=dd.rooms.size();
					for(int z=0;z<Rcoun;z++)
					{
						List_all.addItem(dd.rooms.get(z).Rname);
					}
					
				}
				else if(En_idx==2) 
				{
					System.out.println("E = "+2);
					int Lcoun=dd.Lrooms.size();
					for(int z=0;z<Lcoun;z++)
					{
						List_all.addItem(dd.Lrooms.get(z).Rname);
					}
					
				}
				else if(En_idx==3)
				{
					System.out.println("E = "+3);
					int Dcoun=dd.divs.size();
					for(int z=0;z<Dcoun;z++)
					{
						List_all.addItem(dd.divs.get(z).name);
					}
					
				}
				else {
					System.out.println("Available has Fallen!!!");
				}
			
				
			}
		});
		Entity_Combox.setBounds(81, 67, 174, 33);
		contentPane.add(Entity_Combox);
		
			List_all = new JComboBox();
			List_all.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					makeTable();
				}
			});
			List_all.setBounds(327, 67, 166, 33);
			contentPane.add(List_all);
		
		
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmClicked();
			}
		});
		btnNewButton.setBounds(354, 391, 132, 33);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goback();
			}
		});
		btnBack.setBounds(10, 427, 89, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 141, 488, 200);
		contentPane.add(scrollPane);
		table1 = new JTable();
		scrollPane.setViewportView(table1);
				
		
		ImageIcon imageIcon = new ImageIcon("rr.jpg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(700, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		JLabel llabel = new JLabel("");
		llabel.setIcon(imageIcon);
		llabel.setBounds(10 ,0, 584, 500);
		contentPane.add(llabel);
		
	}
	
	void goback()
	{
		prev.setVisible(true);
		this.setVisible(false);
		this.dispose();				
	}
	
	void makeTable()
	{
		int entityNo=Entity_Combox.getSelectedIndex();
		int listNo=List_all.getSelectedIndex();
		
		
		System.out.println(" no "+entityNo+"  "+listNo);
		if(listNo==-1) {return;}
		String[] tme= {"8-9","9-10","10-11","11-12","12-1","1-2","2-3","3-4","4-5","5-6","6-7"};
		if(entityNo==0) 
		{
			
			myM = new MyModel (dd.m,dd.n,dd.teachers.get(listNo).available,tme);
			table1.setModel(myM);
		}
		else if(entityNo==1) 
		{
			myM = new MyModel (dd.m,dd.n,dd.rooms.get(listNo).available,tme);
			table1.setModel(myM);
			
//			table1=new JTable(myM);
		}
		else if(entityNo==2) 
		{
			myM = new MyModel (dd.m,dd.n,dd.Lrooms.get(listNo).available,tme);
			table1.setModel(myM);
		}
		else if(entityNo==3) 
		{
			myM = new MyModel (dd.m,dd.n,dd.divs.get(listNo).available,tme);
			table1.setModel(myM);
		}
		else {
			System.out.println("Whats this going???????");
		}
		
		table1.setRowHeight(35);
		
	}
	
	void confirmClicked()
	{
		int entityNo=Entity_Combox.getSelectedIndex();
		int listNo=List_all.getSelectedIndex();
		int i,j;
		int [][]ATemp=null;
		
		if(entityNo==0) 
		{
			ATemp=dd.teachers.get(listNo).available;
		}
		else if(entityNo==1) 
		{
			ATemp=dd.rooms.get(listNo).available;
		}
		else if(entityNo==2) 
		{
			ATemp=dd.Lrooms.get(listNo).available;
		}
		else if(entityNo==3) 
		{
			ATemp=dd.divs.get(listNo).available;
		}
		else {
			System.out.println("Whats this going???????");
			return;
		}
		
		for(i=0;i<dd.m;i++)
			for(j=0;j<dd.n;j++)
			{
			ATemp[i][j]=(int) myM.getValueAt(i, j);	
			}
		System.out.println("Suceess");
		
	}
	
}