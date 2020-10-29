
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.*;
import java.util.Vector;




public class SqlTry {
	
	static Connection   con=null;
	public int OpenDB()
	{
		  try {
			  	 Class.forName("org.sqlite.JDBC");
			  	con = DriverManager.getConnection("jdbc:sqlite:mytest1.db");
    		 	con.setAutoCommit(false);
		         
		      } catch ( Exception e ) {
		         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		         return 0;
		      }
		      System.out.println("int openDB() >>> "+"Opened database successfully");
		 return 1;
		      
	}
	
	public void Read_Pname(StartWindow swObj) throws Exception
	{
		
		int i=0;
		DeptData dtt=null;
		//Class.forName("org.sqlite.JDBC");
		//con = DriverManager.getConnection("jdbc:sqlite:mytest1.db");
	 	System.out.println("void Read_Pname() >>> Project list");
     
        String stg="select * FROM ProjectNames";
		
		PreparedStatement stmt=con.prepareStatement(stg);  
		con.setAutoCommit(false);
		ResultSet rs=stmt.executeQuery();  
		
		while (rs.next())
		    {
		      System.out.println(rs.getString("Pname"));
		    	i++;
		    }
		if(i==0)
		{
			System.out.println("No Projects ");
			return ;
	    }
		System.out.println("Total project = "+i);
		
		stmt=con.prepareStatement(stg);  
		rs=stmt.executeQuery();  
		while (rs.next())
	    {
			  byte[] st = (byte[]) rs.getObject(2);
		      ByteArrayInputStream baip = new ByteArrayInputStream(st);
		      ObjectInputStream ois = new ObjectInputStream(baip);
		      dtt=(DeptData) ois.readObject();
		 	  swObj.AllDept.add(dtt);
		    	
	    }
		
		
		rs.close();
		con.commit();
		stmt.close();
		
	}
	
	
	public int deleteNameTable() throws Exception
	{
		System.out.println("void deleteNameTable() >>>");
		String sd="DROP TABLE ProjectNames"; 
		Statement s= con.createStatement();
		con.setAutoCommit(false);
		s.executeUpdate(sd);
		System.out.print("dleted");
		s.close();
		con.commit();
		return 1;
	}
	
	public synchronized void createNameTable() throws Exception
	{
		  System.out.println("void createdNametable()  >>> ");
		  String sd="create table IF NOT EXISTS ProjectNames ( Pname CHAR(50) not null, Pobj BLOB not null );";
		  Statement s= con.createStatement();
		  con.setAutoCommit(false);
		  s.executeUpdate(sd);
		  System.out.print("created");
	      con.commit();
		  s.close();
		
	}
	
	public DeptData getObjt(String sn) throws Exception
	{
	
		DeptData dtt=null;
		
		//String stg="select * FROM ProjectNames";
		System.out.println("getobj");
     	con.setAutoCommit(false);
		PreparedStatement pst=con.prepareStatement("select * FROM ProjectNames");
		ResultSet rs = pst.executeQuery(); 
		while (rs.next())
		    {  // remaining
			      if(sn.equals(rs.getString("Pname")))
			      {
			    	  System.out.println("Matched");
			      byte[] st = (byte[]) rs.getObject(2);
			      ByteArrayInputStream baip = new ByteArrayInputStream(st);
			      ObjectInputStream ois = new ObjectInputStream(baip);
			      dtt=(DeptData) ois.readObject();
			      rs.close();
			      return dtt;
			      }
		   }
		    rs.close();
		    return dtt;
		    	
		
	}
	
		
	void wObj(Vector<DeptData> dptd) throws Exception
	{
		System.out.println("void WOBJ(ALLDept)  >>> ");
		
		deleteNameTable();
		createNameTable();
		//deleteR(dptd);
		
		PreparedStatement pstmt=null;
		con.setAutoCommit(false);
		
		int i,j=dptd.size();
		for(i=0;i<j;i++)
		{
		System.out.println("h="+i);
		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ObjectOutputStream oos = new ObjectOutputStream(baos);
	    oos.writeObject(dptd.get(i));
	    byte[] employeeAsBytes = baos.toByteArray();
	    pstmt = con.prepareStatement("INSERT INTO ProjectNames (Pname,Pobj) VALUES(?,?)");
	    ByteArrayInputStream bais = new ByteArrayInputStream(employeeAsBytes);
	    pstmt.setString(1,dptd.get(i).departN);
	    pstmt.setBinaryStream(2, bais, employeeAsBytes.length);
	    pstmt.executeUpdate();
	    pstmt.close();
		
		
		}
	    con.commit();
		System.out.println(" insert");
		
		
	}
	
	void closeCon()
	{
	if(con!=null)
	{
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	else
	{
		System.out.println("already closed()");
	}
	
	}
	
	
	void deleteR(DeptData dp)
	{
		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt=null;
		
			String sql="DELETE FROM ProjectNames WHERE Pname = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dp.departN);
			pstmt.executeUpdate();
			pstmt.close();
			con.commit();
			System.out.println("deleted");
				 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

