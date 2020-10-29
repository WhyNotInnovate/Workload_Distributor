
import java.io.Serializable;
import java.util.*; 

class lectOrPract implements Serializable
{
	boolean l_p ;
	int day,timeing;
	int cls,batches;
	int t1,t2,t3,t4;
	int r1,r2,r3,r4;
	int s1,s2,s3,s4;
	int score;
	float Lscore;
	String FarDeptName;
	
	public lectOrPract(boolean lp,int t,int cl,float sc)
	{
		l_p=lp;
		t1=t;
		cls=cl;
		Lscore=sc;
	}
	
	public lectOrPract(boolean lp,int dy,int tim) {
	l_p=lp;
	day=dy;
	timeing=tim;
	}
	public lectOrPract(boolean lp,int dy,int tim,int t11,int t22,int t33,int cl) {
		l_p=lp;
		day=dy;
		cls=cl;
		timeing=tim;
		t1=t11;
		t2=t22;
		t3=t33;
	}
}

class teacher_st implements Serializable
{
	boolean l_p;
	int day,timeing;
	int r1;
	int cls;
	int sub;
	String FarDeptName;
	
	public teacher_st(boolean lp,int dy,int tt,int r,int cl,int s)
	{
		l_p=lp;
		day=dy;
		timeing=tt;
		r1=r;
		cls=cl;
		sub=s;
		
	}
}

class room_st implements Serializable
{
	boolean l_p;
	int day,timeing;
	int t1;
	int cls;
	int sub;
	String FarDeptName;
	
	
	public room_st(boolean lp,int dy,int tt,int r,int cl,int s)
	{
		l_p=lp;
		day=dy;
		timeing=tt;
		t1=r;
		cls=cl;
		sub=s;
	}
	
	
}

class Subject implements Serializable
{
	String name,Sname;
	int year;
	int sem,inDEX;
}

public class ReadDepartment  {
	
    String depart;	
    Vector<Room> rooms;
    Vector<Room> Lrooms;
    Vector<Division> div;
    Vector<Teacher> teachers;
    Vector<Subject> subjects;
    int m,n;
    
    
    
    void ReadF() {}    //$$                                                      
    void WriteF() {}	//$$                                                   
    void turn() {}     //$$  console read
    void changes() {}  // edit teachers div etc
    void disp() {}     // display fields.
    void calculatemistake() {}
    void generate() {} //
    void makePracticals() {} //$$ major Practical
    void makeLectures() {}   //   major Lector

    int total_parct() { return 0;}   //$$ count total no of practicals
    int select_Teacher_FP() {return 0;} //$$  select teachers for practical
    lectOrPract find_Pract(int techNo)  //  find best practical assignment 
    {lectOrPract t = null;return t;} 
    void make_Reflections(lectOrPract t) {} // reflect the selected pract 
    void eleminate_calc(Vector<lectOrPract> i) {} // calculate score
    
    
}

class Division implements Serializable
{
	String name;
	int shift,batches;
	int available[][],year; // 0 for available
	lectOrPract T_T[][];  //6*10
	int practTime;
	String GFM;
	int rm;				// prefered class room
}

class Room implements Serializable
{
	String Rname;
	boolean aflag;     // assigned or not
	int available[][]; //0 for free
	room_st T_T[][];
	boolean allowed[];   

	String FarDeptName;

}

class Teacher implements Serializable
{
	String name,shortName;
	boolean aflag;
	int ideal[][],shift;
	teacher_st T_T[][]; 
	int available[][];  // 0 for free
	
	boolean[] T_to_C;  // 1 for true   //size of div                   /// LDT
	int[] L_HM;								 //size of div				//  LDT
	int[] R_L_HM;  // remaining error //size of div		
	int RLC;
	int[] C_WSub;					 //size of div						// LDT

	int daily_LC[][];  // div.size * days(m)
	
	boolean[] T_to_P;	// 1 for true    //size of div*3               // 
	int[] P_HM;								//size of div*3            //
	int[] R_P_HM;					//size of div*3
	int RPC;
	int[] P_WSub;					//size of div*3                    //

	String FarDeptName;

}

