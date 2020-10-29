import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Vector;

public class DeptData implements Serializable{
	
	 String departN;	
	         int m,n,sem;
	         String year,EffectFrom,pdfname,pdfsname;
	         Vector<Room> rooms ;
	    	 Vector<Room> Lrooms;
	    	 Vector<Division> divs;
	    	 Vector<Teacher> teachers;
	    	 Vector<Subject> subjects;
	    	 Vector<Subject> curr_subjects;
	    	
	         public DeptData(String sn,int Sem,String yr,String date,String ddn)
	         {
	        	 m=5;
	        	 n=11;
	        	 departN=sn;
	        	 sem=Sem;
	        	 year=yr;
	        	 EffectFrom=date;
	        	 pdfname=ddn;
	        	 PDFDN();
	        	 initValues();
	        	 
	         }
	         void PDFDN()
	         {
	        	 
	        	 String[] ddsn= {"Department of Information Technology",
	        			 		"Department of Computer Science",
	        			 		"Department of Electronics And Telecommunication",
	        			 		"Department of Instrumentation",
	        			 		"Department of Electrical Engineering",
	        			 		"Department of First Year Engineering"	        			 
	        			 
	        	 };
	        	 String[] ddn= {"IT","COMP","ENTC","INSTRU","ELECTRIC","FE"};
	     		
	        	 if(pdfname.equals(ddsn[0]))
	        	 {
	        		 pdfsname=ddn[0];
	        	 }
	        	 else if(pdfname.equals(ddsn[1]))
	        	 {

	        		 pdfsname=ddn[1];
	        	 }
	        	 else if(pdfname.equals(ddsn[2]))
	        	 {

	        		 pdfsname=ddn[2];
	        	 }else if(pdfname.equals(ddsn[3]))
	        	 {

	        		 pdfsname=ddn[3];
	        	 }else if(pdfname.equals(ddsn[4]))
	        	 {

	        		 pdfsname=ddn[4];
	        	 }else if(pdfname.equals(ddsn[5]))
	        	 {

	        		 pdfsname=ddn[5];
	        	 }
	        	 else;
	
	         }
	         void initValues()
	         { 
	        	 rooms=new Vector<Room>();
	        	 Lrooms=new Vector<Room>();		 
	             divs =new  Vector<Division>();
	             teachers=new Vector<Teacher>();
	             subjects=new Vector<Subject>();
	         
	         }

	         
	   
	         //			        		 \ ! /
	         // --------Practical Part -> \!/ 
	         
	         int total_pract_count() // Done
	         {
	        	 System.out.println("total prac count");
	         	int i,j,k;
	         	int count=0,tcount;
	         	int bat;
	         	int dS=divs.size();
	         	int tS=teachers.size();
	         	for(i=0;i<dS;i++)
	         	{
	         		bat=divs.get(i).batches;
	         		tcount=0;
	         		for(j=0;j<bat;j++)
	         		{	
	         			for(k=0;k<tS;k++)
	         			{
	         				if(teachers.get(k).T_to_P[(i*4)+j])
	         				tcount+=teachers.get(k).P_HM[(i*4)+j];
	         			}
	         			
	         		}
	         		if(tcount%bat==0)
	         		{
	         			count+=(tcount/bat);
	         		}else
	         		{	
	         			System.out.println("Wrong Practical Assignment div"+i);
	         			return 0;
	         		}
	         		
	         	}
	         	
	         	System.out.println("hhhhh");
	         	for(k=0;k<tS;k++)
	         	{
	         		tcount=0;
	         		
	         		for(i=0;i<dS;i++)
		         	{
		         		bat=divs.get(i).batches;
		         		for(j=0;j<bat;j++)
		         		{
		         			if(teachers.get(k).T_to_P[(i*4)+j])
		         			{
		         				tcount+=teachers.get(k).P_HM[(i*4)+j];
		         				teachers.get(k).R_P_HM[(i*4)+j]=teachers.get(k).P_HM[(i*4)+j];
		         			}
		         		}
		         	}
	         		teachers.get(k).RPC=tcount;
	         		System.out.println(teachers.get(k).name+" :"+teachers.get(k).RPC);
	         	
	         	}
	         	
	         	System.out.println("Total Practical size: "+count);
	         	return count;
	         }

	         int select_Teacher_PF()  // done
	     	{
	         	
	     		int i,j,k;
	     		k=teachers.size();
	     		j=0;
	     		for(i=1;i<k;i++)
	     		{
	     			if(teachers.get(i).RPC>teachers.get(j).RPC )
	     			{
	     				j=i;
	     			}
	     		}
	     		System.out.println("Selected Teacher : "+teachers.get(j).name +"  no: "+ teachers.get(j).RPC);
	     		return j;
	     	}
	         
	         int find_div(int ti)  //done
	         {
	        	 System.out.println("find_div(ti) ");
	        	 int i,kz;
	        	 kz=divs.size();
	        	 int j=0,jsum=0;
	        	 for(i=0;i<kz;i++)
	        	 {
	        		 int sum=0,cg=divs.get(i).batches;
	        		 for(int g=0;g<cg;g++)
	        		 {
	        		   if(teachers.get(ti).T_to_P[(i*4) + g]==true)
	        		   {
	        			 sum+=teachers.get(ti).P_HM[(i*4) + g];
	        		   }
	        		 }
	        		 if(i==0)
	        		 {
	        			 jsum=sum;
	        			 continue;
	        		 }
	        		 if(sum>jsum)
	        		 {
	        			 j=i;
	        			 jsum=sum;
	        		 }
	        	 }
	        	 System.out.println("Selected Division "+divs.get(j).name+" "+j+"  sum=:"+jsum);
	        	 return j;
	        }
	     	 
	         boolean PTisAvailable(int tn,int dn) //done
	         {
	        	 int i;
	        	 Teacher TTemp=teachers.get(tn);
	        	 Division DTemp=divs.get(dn);
	        	 int Ptime=divs.get(dn).practTime;
	        	 
	        	 for(i=0;i<m;i++)
	        	 {
	        		 if(DTemp.available[i][Ptime]==0 && DTemp.available[i][Ptime+1]==0)
	        		 {
	        			 if(TTemp.available[i][Ptime]==0 && TTemp.available[i][Ptime+1]==0)
	        			 {
	        				 return true; 
	        		 
	        			 }
	        		 }
	        	 }
	        	 return false;
	        	 
	         }
	         
	         Vector<lectOrPract> getPListByTime(int tn,int dn)  //done
	         {
	        	int i;
	        	 Vector<lectOrPract> vtemp=null;
		        	 
	        	 Teacher TTemp=teachers.get(tn);
	        	 Division DTemp=divs.get(dn);
	        	 int Ptime=divs.get(dn).practTime;
	        	 
	        	 System.out.println("");
	        	 for(i=0;i<m;i++)
	        	 {
	        		 System.out.println(" ");
	        		 System.out.println(i+" "+Ptime+" "+DTemp.available[i][Ptime]+" "+DTemp.available[i][Ptime+1]);
	        		 System.out.println(i+" "+Ptime+" "+TTemp.available[i][Ptime]+" "+TTemp.available[i][Ptime+1]);
	        		 
	        		 
	        		 if(DTemp.available[i][Ptime]==0 && DTemp.available[i][Ptime+1]==0)
	        		 {
	        			 if(TTemp.available[i][Ptime]==0 && TTemp.available[i][Ptime+1]==0)
	        			 {
	        				lectOrPract tm=new lectOrPract(true, i, Ptime);
	        				if(vtemp==null)
	        				{
	        					vtemp=new Vector<lectOrPract>();
	        				}
	        				vtemp.add(tm);
	        			 }
	        		 }
	        	 }
	        	 
	        	 System.out.println("By Time  "+ vtemp.size());
	        	 return vtemp;
	         }
	         
	         Vector<lectOrPract> getPListAnyTime(int tn,int dn)   //done
	         {
	        	 int i,j,k;
	        	 Vector<lectOrPract> vtemp=null;
		        	 
	        	 Teacher TTemp=teachers.get(tn);
	        	 Division DTemp=divs.get(dn);
	        	 int Ptime=divs.get(dn).practTime;
	        	 
	        	 int[] shft1= {0,2,5,6};
	        	 int[] shft2= {3,6,8,9};
	        	 
	        	 if(DTemp.shift==1)
	        	 {
	        		 for(i=0;i<m;i++)
	        			 for(j=0;j<4;j++)
	        			 {
	        				 k=shft1[j];
	        				 if(DTemp.available[i][k]==0 && DTemp.available[i][k+1]==0)
	        				 {
	        					 if(TTemp.available[i][k]==0 && TTemp.available[i][k+1]==0)
	        					 {
	        						 lectOrPract tm=new lectOrPract(true, i, k);
	        						 if(vtemp==null)
	        						 {
	        							 vtemp=new Vector<lectOrPract>();
	        						 }
	        						 vtemp.add(tm);
	        					 }
	        				 }
	        			 }
	        	  }
	        	 else
	        	 {

	        		 for(i=0;i<m;i++)
	        			 for(j=0;j<4;j++)
	        			 {
	        				 k=shft2[j];
	        				 if(DTemp.available[i][k]==0 && DTemp.available[i][k+1]==0)
	        				 {
	        					 if(TTemp.available[i][k]==0 && TTemp.available[i][k+1]==0)
	        					 {
	        						 lectOrPract tm=new lectOrPract(true, i, k);
	        						 if(vtemp==null)
	        						 {
	        							 vtemp=new Vector<lectOrPract>();
	        						 }
	        						 vtemp.add(tm);
	        					 }
	        				 }
	        			 }
	        	 }
	        	 return vtemp;
	         }
	
	         int findweight(int d,int time, int t)  // done 
	         {
	         	int a,b,sum;
	         	a=teachers.get(t).ideal[d][time];
	         	b=teachers.get(t).ideal[d][time+1];
	         	
	         	if(a==4 || b==4)
	         		{return 0;}
	         	
	         	sum=a+b;
	         	
	         	if(a==1 || b==1)
	         	{--sum;}
	         	
	         	if(teachers.get(t).available[d][time]!=0 && teachers.get(t).available[d][time+1]!=0)
	         	{
	         		return 0;
	         	}
	         		
	         	return sum;
	         }

	         lectOrPract verify3(lectOrPract p)
	         {
	        	 int i,a1,a2,a3;
	         	a1=findweight(p.day,p.timeing,p.t1);
	         	a2=findweight(p.day,p.timeing,p.t2);
	         	a3=findweight(p.day,p.timeing,p.t3);
	         	
	         	p.batches=3;
	         	if(a1==0 || a2==0 || a3==0)
	         	{
	         		p.score=0;
	         		return p;
	         	}
	         	else
	         	{
	         		p.score=a1+a2+a3;
	         	}
	         	if(divs.get(p.cls).available[p.day][p.timeing]!=0) // check div available
	         	{
	         		p.score=0;
	         		return p; 
	         	}
	         	
	         	p.s1=teachers.get(p.t1).P_WSub[p.cls*4];
	         	p.s2=teachers.get(p.t2).P_WSub[p.cls*4  +1];
	         	p.s3=teachers.get(p.t3).P_WSub[p.cls*4  +2];
	         		         			
	         	int j=Lrooms.size();
	         	
	         	for(i=0;i<j;i++)                       // check rooms available
	         	{
	         		     
	         		if(Lrooms.get(i).available[p.day][p.timeing]==0 && Lrooms.get(i).available[p.day][p.timeing+1]==0 && Lrooms.get(i).allowed[p.s1]==true)
	         		{
	         			p.r1=i;
	         			break;
	         		}
	         		
	         	}
	         	
	         	
	         	if(i==j)
	         	{
	         		p.score=0;
	         		return p;
	         	}
	         	else if(p.r1<j-1 &&Lrooms.get(p.r1+1).available[p.day][p.timeing]==0 &&Lrooms.get(p.r1+1).available[p.day][p.timeing+1]==0 && Lrooms.get(p.r1+1).allowed[p.s2]==true)
	         	{
	    		 	p.r2=p.r1+1;
		         		
	         	}
	         	else
	         	{
	         		for(i=0;i<j;i++)                       // check rooms available
	         		{
	         		     
	         			if(Lrooms.get(i).available[p.day][p.timeing]==0 &&Lrooms.get(i).available[p.day][p.timeing+1]==0 && Lrooms.get(i).allowed[p.s2]==true  && p.r1!=i)
	         			{
	         				p.r2=i;
	         				break;
	         			}
	         		}
	         		if(i==j)
		         	{
		         		p.score=0;
		         		return p;
		         	}
	         	}

	         	if((p.r2!=p.r1+1)&& p.r1<j-1  && Lrooms.get(p.r1+1).available[p.day][p.timeing]==0 && Lrooms.get(p.r1+1).available[p.day][p.timeing+1]==0 && Lrooms.get(p.r1+1).allowed[p.s3]==true)
	         	{
	         		p.r3=p.r1+1;
	         	} 
	         	else if(p.r2<j-1  && Lrooms.get(p.r2+1).available[p.day][p.timeing]==0 && Lrooms.get(p.r2+1).available[p.day][p.timeing+1]==0 && Lrooms.get(p.r2+1).allowed[p.s3]==true)
	         	{
	    		 	p.r3=p.r2+1;
		         		
	         	}
	         	else 
	         	{	         	
	         		for(i=0;i<j;i++)                       // check rooms available
	         		{
	         		     
	         			if(Lrooms.get(i).available[p.day][p.timeing]==0 &&Lrooms.get(i).available[p.day][p.timeing+1]==0 && Lrooms.get(i).allowed[p.s3]==true  && p.r1!=i && p.r2!=i)
	         			{
	         				p.r3=i;
	         				break;
	         			}
	         		}
	         		if(i==j)
		         	{
		         		p.score=0;
		         		return p;
		         	}
	         	}
	         	
	         	
	         	return p;
	         }
	         
	         lectOrPract verify4(lectOrPract p)
	         {
	        	 int i,a1,a2,a3,a4;
	         	a1=findweight(p.day,p.timeing,p.t1);
	         	a2=findweight(p.day,p.timeing,p.t2);
	         	a3=findweight(p.day,p.timeing,p.t3);
	         	a4=findweight(p.day,p.timeing,p.t4);
	         	
	         	p.batches=4;
	         	if(a1==0 || a2==0 || a3==0 || a4==0)
	         	{
	         		p.score=0;
	         		return p;
	         	}
	         	else
	         	{
	         		p.score=a1+a2+a3+a4;
	         	}
	         	if(divs.get(p.cls).available[p.day][p.timeing]!=0) // check div available
	         	{
	         		p.score=0;
	         		return p; 
	         	}
	         	
	         	p.s1=teachers.get(p.t1).P_WSub[p.cls*4];
	         	p.s2=teachers.get(p.t2).P_WSub[p.cls*4  +1];
	         	p.s3=teachers.get(p.t3).P_WSub[p.cls*4  +2];
	         	p.s4=teachers.get(p.t4).P_WSub[(p.cls*4)  +3];	         			
	         	
	         	int j=Lrooms.size();
	         	
	         	for(i=0;i<j;i++)                       // check rooms available
	         	{
	         		     
	         		if(Lrooms.get(i).available[p.day][p.timeing]==0 && Lrooms.get(i).available[p.day][p.timeing+1]==0 && Lrooms.get(i).allowed[p.s1]==true)
	         		{
	         			p.r1=i;
	         			break;
	         		}
	         		
	         	}
	         	
	         	
	         	if(i==j)
	         	{
	         		p.score=0;
	         		return p;
	         	}
	         	else if(p.r1<j-1 && Lrooms.get(p.r1+1).available[p.day][p.timeing]==0 && Lrooms.get(p.r1+1).available[p.day][p.timeing+1]==0 && Lrooms.get(p.r1+1).allowed[p.s2]==true)
	         	{
	    		 	p.r2=p.r1+1;
		         		
	         	}
	         	else
	         	{
	         		for(i=0;i<j;i++)                       // check rooms available
	         		{
	         		     
	         			if(Lrooms.get(i).available[p.day][p.timeing]==0 &&Lrooms.get(i).available[p.day][p.timeing+1]==0 && Lrooms.get(i).allowed[p.s2]==true  && p.r1!=i)
	         			{
	         				p.r2=i;
	         				break;
	         			}
	         		}
	         		if(i==j)
		         	{
		         		p.score=0;
		         		return p;
		         	}
	         	
	         	}

	         	if((p.r2!=p.r1+1) && p.r1<j-1  && Lrooms.get(p.r1+1).available[p.day][p.timeing]==0&&Lrooms.get(p.r1+1).available[p.day][p.timeing+1]==0 && Lrooms.get(p.r1+1).allowed[p.s3]==true)
	         	{
	         		p.r3=p.r1+1;
	         	} 
	         	else if(p.r2<j-1  && Lrooms.get(p.r2+1).available[p.day][p.timeing]==0 &&Lrooms.get(p.r2+1).available[p.day][p.timeing+1]==0 && Lrooms.get(p.r2+1).allowed[p.s3]==true)
	         	{
	    		 	p.r3=p.r2+1;
		         		
	         	}
	         	else 
	         	{	         	
	         		for(i=0;i<j;i++)                       // check rooms available
	         		{
	         		     
	         			if(Lrooms.get(i).available[p.day][p.timeing]==0 &&Lrooms.get(i).available[p.day][p.timeing+1]==0 && Lrooms.get(i).allowed[p.s3]==true  && p.r1!=i && p.r2!=i)
	         			{
	         				p.r3=i;
	         				break;
	         			}
	         		}
	         		if(i==j)
		         	{
		         		p.score=0;
		         		return p;
		         	}
	         	}
	         	

	         	if((p.r2!=p.r1+1)&& p.r1<j-1  && Lrooms.get(p.r1+1).available[p.day][p.timeing]==0 &&Lrooms.get(p.r1+1).available[p.day][p.timeing+1]==0 && Lrooms.get(p.r1+1).allowed[p.s4]==true)
	         	{
	         		p.r4=p.r1+1;
	         	} 
	         	else if((p.r3!=p.r2+1) &&  p.r2<j-1  && Lrooms.get(p.r2+1).available[p.day][p.timeing]==0 &&Lrooms.get(p.r2+1).available[p.day][p.timeing+1]==0 && Lrooms.get(p.r2+1).allowed[p.s4]==true)
	         	{
	    		 	p.r3=p.r2+1;
		         		
	         	}
	         	else if(p.r3<j-1  && Lrooms.get(p.r3+1).available[p.day][p.timeing]==0 &&Lrooms.get(p.r3+1).available[p.day][p.timeing+1]==0 && Lrooms.get(p.r3+1).allowed[p.s4]==true)
	         	{
	         		p.r4=p.r3+1;
	         	}
	         	else
	         	{
	         		for(i=0;i<j;i++)                       // check rooms available
	         		{
	         		     
	         			if(Lrooms.get(i).available[p.day][p.timeing]==0 &&Lrooms.get(i).available[p.day][p.timeing+1]==0 && Lrooms.get(i).allowed[p.s4]==true  && p.r1!=i && p.r2!=i && p.r3!=i)
	         			{
	         				p.r3=i;
	         				break;
	         			}
	         		}
	         		if(i==j)
		         	{
		         		p.score=0;
		         		return p;
		         	}
	         		
	         	}
	         	
	         	
	         	if(divs.get(p.cls).available[p.day][p.timeing]!=0) // check div available
	         	{
	         		p.score=0;
	         	}
	         	return p;
	        	 
	        	 
	         }
	         
	         lectOrPract findPract_3B(Vector<lectOrPract> vtemp,int tn,int dn) 
	         {
	        	 int i,j,k,h; 
	        	 Teacher Ttemp=teachers.get(tn);
		         Division DTemp=divs.get(dn);
		         boolean[] btemp=Ttemp.T_to_P;
		     	
		         int ts = teachers.size();
		     	 int tps=dn*4;
		         int vs=vtemp.size();
		         Vector<lectOrPract> ctemp=new Vector<lectOrPract>();
			     	
		     	 
		         for(j=tps;j<tps+3;j++)
		    		{
		    			if(!btemp[j])
		    			{
		    				continue;
		    			}
		    			System.out.println("j ="+j);
		    			switch(j%4)
		    			{
		    			case 0: 
		    					for(k=0;k<ts;k++)
		    			         {
		    						if(k==tn || teachers.get(k).T_to_P[j+1]==false || teachers.get(k).R_P_HM[j+1]<1)
		    						{
		    							continue;
		    						}
		    						for(h=0;h<ts;h++)
		    						{
		    							if(h==tn || h==k || teachers.get(h).T_to_P[j+2]==false || teachers.get(h).R_P_HM[j+2]<1)
		    							{
		    								continue;
		    							}
		    							for(i=0;i<vs;i++)
		    							{	
		    							 lectOrPract lp=new lectOrPract(true,vtemp.get(i).day,vtemp.get(i).timeing,tn,k,h,j/4);
		    							 lp=verify3(lp);
		    							 if(lp.score!=0)
		    							 {ctemp.add(lp);}
		    							}
		    						}
		    			         }
		    					break;
		    			case 1:      
		    				for(k=0;k<ts;k++)
				          {
							if(k==tn || teachers.get(k).T_to_P[j-1]==false ||teachers.get(k).R_P_HM[j-1]<1)
							{
								continue;
							}
							for(h=0;h<ts;h++)
							{
								if(h==tn || h==k || teachers.get(h).T_to_P[j+1]==false || teachers.get(h).R_P_HM[j+1]<1 )
								{
									continue;
								}
								for(i=0;i<vs;i++)
								{
								 lectOrPract lp=new lectOrPract(true,vtemp.get(i).day,vtemp.get(i).timeing,k,tn,h,j/4);
								 lp=verify3(lp);
								 if(lp.score!=0)
								 {ctemp.add(lp);}
								}
							}
				         }
						break;
		    			case 2: for(k=0;k<ts;k++)
				          {
							if(k==tn || teachers.get(k).T_to_P[j-2]==false || teachers.get(k).R_P_HM[j-2]<1)
							{
								continue;
							}
							for(h=0;h<ts;h++)
							{
								if(h==tn || h==k || teachers.get(h).T_to_P[j-1]==false || teachers.get(h).R_P_HM[j-1]<1)
								{
									continue;
								}
								for(i=0;i<vs;i++)
								{
								 lectOrPract lp=new lectOrPract(true,vtemp.get(i).day,vtemp.get(i).timeing,k,h,tn,j/4);
								 lp=verify3(lp);
								 if(lp.score!=0)
								 {ctemp.add(lp);}
								}
							}
				           }
						break;
		    				
		    			}// switch end
		    		}// tps end
		    	
		         		         
		         

		         if(ctemp.size()==0)
		     	{
		     		System.out.println("combination not formed");
		     		throw new EmptyStackException();
		     	}
		     	System.out.println("ctemp size "+ ctemp.size());
		     	j=0;
		     	k=ctemp.size();
		     	h=ctemp.get(j).score;
		     	for(i=1;i<k;i++)
		     	{
		     		if(ctemp.get(i).score>h)
		     		{
		     			j=i;
		     			h=ctemp.get(j).score;
		     		}
		     	}
		     	System.out.println("selected j of pract : "+j);
		     	return ctemp.get(j);
	        	
	         }
	     
	         lectOrPract findPract_4B(Vector<lectOrPract> vtemp,int tn,int dn)
	         {

	        	 int i,j,k,h,b; 
	        	 Teacher Ttemp=teachers.get(tn);
		         Division DTemp=divs.get(dn);
		         boolean[] btemp=Ttemp.T_to_P;
		     	
		         int ts = teachers.size();
		     	 int tps=dn*4;
		         int vs=vtemp.size();
		         Vector<lectOrPract> ctemp=new Vector<lectOrPract>();
		     	 
		         for(j=tps;j<tps+4;j++)
		    		{
		    			if(!btemp[j])
		    			{
		    				continue;
		    			}
		    			System.out.println("j ="+j);
		    			switch(j%4)
		    			{
		    			case 0: 
		    					for(k=0;k<ts;k++)
		    			         {
		    						if(k==tn || teachers.get(k).T_to_P[j+1]==false || teachers.get(k).R_P_HM[j+1]<1)
		    						{
		    							continue;
		    						}
		    						for(h=0;h<ts;h++)
		    						{
		    							if(h==tn || h==k || teachers.get(h).T_to_P[j+2]==false || teachers.get(h).R_P_HM[j+2]<1)
		    							{
		    								continue;
		    							}
		    							
		    							for(b=0;b<ts;b++)
		    							{
			    							if(b==h||b==tn || b==k || teachers.get(b).T_to_P[j+3]==false || teachers.get(b).R_P_HM[j+3]<1)
			    							{
			    								continue;
			    							}
		    							
		    								for(i=0;i<vs;i++)
		    								{	
		    									lectOrPract lp=new lectOrPract(true,vtemp.get(i).day,vtemp.get(i).timeing,tn,k,h,j/4);
		    									lp.t4=b;
		    									lp=verify4(lp);
		    									if(lp.score!=0)
		    									{ctemp.add(lp);}
		    								}
		    							}
		    						}
		    			         }
		    					break;
		    			case 1:      
		    				for(k=0;k<ts;k++)
				          {
							if(k==tn || teachers.get(k).T_to_P[j-1]==false ||teachers.get(k).R_P_HM[j-1]<1)
							{
								continue;
							}
							
							for(h=0;h<ts;h++)
							{
								if(h==tn || h==k || teachers.get(h).T_to_P[j+1]==false || teachers.get(h).R_P_HM[j+1]<1 )
								{
									continue;
								}

    							for(b=0;b<ts;b++)
    							{
	    							if(b==h||b==tn || b==k || teachers.get(b).T_to_P[j+2]==false || teachers.get(b).R_P_HM[j+2]<1)
	    							{
	    								continue;
	    							}
    							
									for(i=0;i<vs;i++)
									{
										lectOrPract lp=new lectOrPract(true,vtemp.get(i).day,vtemp.get(i).timeing,k,tn,h,j/4);
										lp.t4=b;
										lp=verify4(lp);
										if(lp.score!=0)
										{ctemp.add(lp);}
									}
    							}
							}
				         }
						break;
		    			case 2: 
		    				for(k=0;k<ts;k++)
				          {
							if(k==tn || teachers.get(k).T_to_P[j-2]==false || teachers.get(k).R_P_HM[j-2]<1)
							{
								continue;
							}
							for(h=0;h<ts;h++)
							{
								if(h==tn || h==k || teachers.get(h).T_to_P[j-1]==false || teachers.get(h).R_P_HM[j-1]<1)
								{
									continue;
								}

    							for(b=0;b<ts;b++)
    							{
	    							if(b==h||b==tn || b==k || teachers.get(b).T_to_P[j+1]==false || teachers.get(b).R_P_HM[j+1]<1)
	    							{
	    								continue;
	    							}
    							
	    							for(i=0;i<vs;i++)
	    							{
	    								lectOrPract lp=new lectOrPract(true,vtemp.get(i).day,vtemp.get(i).timeing,k,h,tn,j/4);
	    								lp.t4=b;
	    								lp=verify4(lp);
	    								if(lp.score!=0)
	    								{ctemp.add(lp);}
	    							}
    							}
							}
				           }
						break;
		    			case 3: 
		    				for(k=0;k<ts;k++)
				          {
							if(k==tn || teachers.get(k).T_to_P[j-3]==false || teachers.get(k).R_P_HM[j-3]<1)
							{
								continue;
							}
							for(h=0;h<ts;h++)
							{
								if(h==tn || h==k || teachers.get(h).T_to_P[j-2]==false || teachers.get(h).R_P_HM[j-2]<1)
								{
									continue;
								}

    							for(b=0;b<ts;b++)
    							{
	    							if(b==h||b==tn || b==k || teachers.get(b).T_to_P[j-1]==false || teachers.get(b).R_P_HM[j-1]<1)
	    							{
	    								continue;
	    							}
    							
	    							for(i=0;i<vs;i++)
	    							{
	    								lectOrPract lp=new lectOrPract(true,vtemp.get(i).day,vtemp.get(i).timeing,k,h,b,j/4);
	    								lp.t4=tn;
	    								lp=verify4(lp);
	    								if(lp.score!=0)
	    								{ctemp.add(lp);}
	    							}
    							}
							}
				           }
						break;
		    			
		    			}// switch end
		    			
		    			if(ctemp.size()>20)
		    			{
		    				break;
		    			}
		    			
		    		}// tps end

		         
		         if(ctemp.size()==0)
		     	{
		     		System.out.println("combination not formed");
		     		throw new EmptyStackException();
		     	}
		     	System.out.println("ctemp size "+ ctemp.size());
		     	j=0;
		     	k=ctemp.size();
		     	h=ctemp.get(j).score;
		     	for(i=1;i<k;i++)
		     	{
		     		if(ctemp.get(i).score>h)
		     		{
		     			j=i;
		     			h=ctemp.get(j).score;
		     		}
		     	}
		     	System.out.println("Selected ctemp Pract :"+j);
		     	return ctemp.get(j);
	        	
		     }
	         
	         lectOrPract find_Pract(int ti,int di)
	         {
	        	 
	        	 System.out.println("findPract(ti, di)");
	        	lectOrPract ret=null;
	        	Teacher Ttemp=teachers.get(ti);
	        	Division DTemp=divs.get(di);
	        	Vector<lectOrPract> vtemp=null;
	        	
	        	boolean isAVl=true;
	        	if(DTemp.practTime!=-1)
	        	{
	        		System.out.println("practime  is avail"  );
	        		isAVl=PTisAvailable(ti,di);
	        		if(isAVl)
	        		{
	        			vtemp=getPListByTime(ti,di);
	        		}
	        	}
	        	if(DTemp.practTime==-1 || isAVl==false || vtemp==null)
	        	{
	        		System.out.println("practime not avail"  );

	        		vtemp=getPListAnyTime(ti,di);
        	    }
	        	
	        	if(DTemp.batches==3)
	        	{
	        	ret=findPract_3B(vtemp,ti,di);	
	        	}
	        	else if(DTemp.batches==4)
	        	{
		        	ret=findPract_4B(vtemp,ti,di);
	        	}
	        	else;

	        	return ret;
	         }
	         
	     	 int makePracticals() // done
	     	 {
	     		int i,j,z,c = 0;
	     		System.out.println("Make practical (major) ");
	     		lectOrPract temp;
	     		try {
	     			c= total_pract_count();
		     			
	     		}
	     		catch(Exception e)
	     		{
	     			e.printStackTrace();
	     		}
	     		if(c==0)
	     		{System.out.println("wrong practical assignment");return 0;}
	     		int tn,dn;
	     		for(;c>0;c--)
	     		{
	     			try {
	     			System.out.println("Enter loop "+c);
	     			tn=select_Teacher_PF();
	     			dn=find_div(tn);
	     			temp=find_Pract(tn,dn);
	     			MakeP_Reflections(temp);
	     			System.out.println("Remaining practicals :");
	/////////////////display 
		         	int ds=divs.size();
		         	
		         	for( z=0;z<ds;z++)
	            	{
	            		System.out.println(divs.get(z).name);
	            		for(i=0;i<m;i++)
	            		{
	            			for(j=0;j<n;j++)
	            		{	
	            		 System.out.print(divs.get(z).available[i][j]);
	            		 System.out.print("  ");
	            		}
	            		System.out.println("");	
	            		}
	            	}
	            	
	            	int rs=rooms.size();
	            	for( z=0;z<rs;z++)
	            	{
	            		System.out.println(rooms.get(z).Rname);
	                	
	            		for(i=0;i<m;i++)
	            		{
	            		for(j=0;j<n;j++)
	            		{	
	            		 System.out.print(rooms.get(z).available[i][j]);
	            		 System.out.print("  ");
	             		
	            		}
	            		System.out.println("");
	            		}
	            	}
	            	
	            	int lrs=Lrooms.size();
	            	for( z=0;z<lrs;z++)
	            	{System.out.println(Lrooms.get(z).Rname);
	            	
	            		for(i=0;i<m;i++)
	            		{
	            		for(j=0;j<n;j++)
	            		{	
	            			System.out.print(Lrooms.get(z).available[i][j]);
	            		 System.out.print("  ");
	                	}
	            		System.out.println("");
	            		}
	            	}
	            	
		         	
	            	int ts=teachers.size();
	            	for( z=0;z<ts;z++)
	            	{
	            		System.out.println(teachers.get(z).name);
	                	
	            		for(i=0;i<m;i++)
	            		{
	            		for(j=0;j<n;j++)
	            		{	
	            		 System.out.print(teachers.get(z).available[i][j] + "  ");
	            		}
	            		System.out.println("");
	            		}
	            	}
		         	
		         	
		         	/////////////////////// display END
		        
	     			
	     			}catch(Exception e){
	     				//c++;
	     				System.out.println("error make pract" );
	     				e.printStackTrace();
	     				return 0;
	     			}
	     			
	     		}
	     		return 1;
	     		
	     	  }
	         
	         void MakeP_Reflections(lectOrPract tr1)
	         {
	        	 
	        	 
	        	 System.out.println("Reflections");
	        	    int 	tday=tr1.day;
	        	    int 	ttime=tr1.timeing;
	        	   
	        	    room_st rs;
	        	    teacher_st ts;
	        	    
	        	    
	        	   
	        	    System.out.println("Class "+divs.get(tr1.cls).name +" "+tr1.cls);
	        	    
	        	    divs.get(tr1.cls).available[tday][ttime]=1;
	            	divs.get(tr1.cls).available[tday][ttime+1]=1;
	            	tr1.FarDeptName=departN;
	        	    divs.get(tr1.cls).T_T[tday][ttime]=tr1;
	            	

	        	    System.out.println("Room1 "+Lrooms.get(tr1.r1).Rname+" "+tr1.r1);
	        	    System.out.println("Room2 "+Lrooms.get(tr1.r2).Rname+" "+tr1.r2);
	        	    System.out.println("Room3 "+Lrooms.get(tr1.r3).Rname+" "+tr1.r3);
		        	   
	            	Lrooms.get(tr1.r1).available[tday][ttime]=1;
	            	Lrooms.get(tr1.r1).available[tday][ttime+1]=1;
	            	rs=new room_st(true, tday, ttime, tr1.t1, tr1.cls*4,tr1.s1);
	            	rs.FarDeptName=departN;
	            	Lrooms.get(tr1.r1).T_T[tday][ttime]=rs;
	            	
	            	Lrooms.get(tr1.r2).available[tday][ttime]=1;
	            	Lrooms.get(tr1.r2).available[tday][ttime+1]=1;
	            	rs=new room_st(true, tday, ttime, tr1.t2, tr1.cls*4 +1,tr1.s2);
	            	rs.FarDeptName=departN;
	            	Lrooms.get(tr1.r2).T_T[tday][ttime]=rs;
	            	
	            	
	            	Lrooms.get(tr1.r3).available[tday][ttime]=1;
	            	Lrooms.get(tr1.r3).available[tday][ttime+1]=1;
	            	rs=new room_st(true, tday, ttime, tr1.t3, tr1.cls*4 +2,tr1.s3);
	            	rs.FarDeptName=departN;
	            	Lrooms.get(tr1.r3).T_T[tday][ttime]=rs;
	            	
	            	if(tr1.batches==4)
	            	{
	            		System.out.println("Room4 "+Lrooms.get(tr1.r4).Rname+" "+tr1.r4);
			        	
	            		Lrooms.get(tr1.r4).available[tday][ttime]=1;
		            	Lrooms.get(tr1.r4).available[tday][ttime+1]=1;
		            	rs=new room_st(true, tday, ttime, tr1.t4, tr1.cls*4 +3,tr1.s4);
		            	rs.FarDeptName=departN;
		            	Lrooms.get(tr1.r4).T_T[tday][ttime]=rs;
		            }


            		System.out.println("teach1 "+teachers.get(tr1.t1).name+" "+tr1.t1);
            		System.out.println("teach2 "+teachers.get(tr1.t2).name+" "+tr1.t2);
            		System.out.println("teach3 "+teachers.get(tr1.t3).name+" "+tr1.t3);

		        	
	            	teachers.get(tr1.t1).available[tday][ttime]=1;
	            	teachers.get(tr1.t1).available[tday][ttime+1]=1;
	            	ts= new teacher_st(true, tday, ttime, tr1.r1, tr1.cls*4,tr1.s1);
	            	ts.FarDeptName=departN;
	            	teachers.get(tr1.t1).T_T[tday][ttime]=ts;
	            	
	            	teachers.get(tr1.t1).R_P_HM[tr1.cls*4]--;
	            	teachers.get(tr1.t1).RPC--;
	            	
	            	teachers.get(tr1.t2).available[tday][ttime]=1;
	            	teachers.get(tr1.t2).available[tday][ttime+1]=1;
	            	ts= new teacher_st(true, tday, ttime, tr1.r2, tr1.cls*4 +1,tr1.s2);
	            	ts.FarDeptName=departN;
	            	teachers.get(tr1.t2).T_T[tday][ttime]=ts;

	            	teachers.get(tr1.t2).R_P_HM[tr1.cls*4 +1]--;
	            	teachers.get(tr1.t2).RPC--;
	            	
	            	teachers.get(tr1.t3).available[tday][ttime]=1;
	            	teachers.get(tr1.t3).available[tday][ttime+1]=1;
	            	ts= new teacher_st(true, tday, ttime, tr1.r3, tr1.cls*4 +2,tr1.s3);
	            	ts.FarDeptName=departN;
	            	teachers.get(tr1.t3).T_T[tday][ttime]=ts;

	            	teachers.get(tr1.t3).R_P_HM[tr1.cls*4+2]--;
	            	teachers.get(tr1.t3).RPC--;

	            	if(tr1.batches==4)
	            	{	System.out.println("teach4 "+teachers.get(tr1.t4).name+" "+tr1.t4);
	            		
	            		teachers.get(tr1.t4).available[tday][ttime]=1;
		            	teachers.get(tr1.t4).available[tday][ttime+1]=1;
		            	ts= new teacher_st(true, tday, ttime, tr1.r4, tr1.cls*4 +3,tr1.s4);
		            	ts.FarDeptName=departN;
		            	teachers.get(tr1.t4).T_T[tday][ttime]=ts;

		            	teachers.get(tr1.t4).R_P_HM[tr1.cls*4+3]--;
		            	teachers.get(tr1.t4).RPC--;
	            		
	            	}
	            	
	            	
	            	
	         }
	         
	         
	         void dispA(int av[][])
	         {
	        	 int i,j,k;
	        	
	        	 for(i=0;i<m;i++)
	        	 {
	        		 for(j=0;j<n;j++)
	        		 {
	        			 System.out.println(av[i][j] +"  ");
	        		 }
	        		 System.out.println("");
	        	 }
	        	 
	         }
	         
	         //								 *
	         // -------------   Pract Done  /!\
	         //							   / ! \
	         
	         //								   \ ! /
	         // ------------    Lecture Part->  \!/
	         //									 *
	         int totalLect()  // done 
	     	{
	        	 System.out.println("Total Lec Count");
	     		int i,j,k,z,count=0,gcount;
	         	j=0;
	         	k=teachers.size();
	         	int ds=divs.size();
	         	for(i=0;i<k;i++)
	         	{
	         		Teacher TTemp=teachers.get(i);
	         		gcount=0;
	         		for(j=0;j<ds;j++)
	         		{
	         			if(TTemp.T_to_C[j]==true)
	         			{
	         				gcount+=TTemp.L_HM[j];
	         				TTemp.R_L_HM[j]=TTemp.L_HM[j];
	         			}
	         		}
	         		TTemp.RLC=gcount;
	         		System.out.println(TTemp.name+" "+TTemp.RLC);
	         		count+=gcount;
	         		
	         	}
	         	System.out.println("Total lec Count"+count);
	         	
	         	
	         	/*////////////////display 
	         	
	         	for( z=0;z<ds;z++)
            	{
            		System.out.println(divs.get(z).name);
            		for(i=0;i<m;i++)
            		{
            			for(j=0;j<n;j++)
            		{	
            		 System.out.print(divs.get(z).available[i][j]);
            		 System.out.print("  ");
            		}
            		System.out.println("");	
            		}
            	}
            	
            	int rs=rooms.size();
            	for( z=0;z<rs;z++)
            	{
            		System.out.println(rooms.get(z).Rname);
                	
            		for(i=0;i<m;i++)
            		{
            		for(j=0;j<n;j++)
            		{	
            		 System.out.print(rooms.get(z).available[i][j]);
            		 System.out.print("  ");
             		
            		}
            		System.out.println("");
            		}
            	}
            	
            	int lrs=Lrooms.size();
            	for( z=0;z<lrs;z++)
            	{System.out.println(Lrooms.get(z).Rname);
            	
            		for(i=0;i<m;i++)
            		{
            		for(j=0;j<n;j++)
            		{	
            			System.out.print(Lrooms.get(z).available[i][j]);
            		 System.out.print("  ");
                	}
            		System.out.println("");
            		}
            	}
            	
	         	
            	int ts=teachers.size();
            	for( z=0;z<ts;z++)
            	{
            		System.out.println(teachers.get(z).name);
                	
            		for(i=0;i<m;i++)
            		{
            		for(j=0;j<n;j++)
            		{	
            		 System.out.print(teachers.get(z).available[i][j] + "  ");
            		}
            		System.out.println("");
            		}
            	}
	         	
	         	
	         	*/////////////////////// display END
	         	
	         	
	         	return count;
	     	}
	     	
	     	lectOrPract select_Teacher_L()  // done
	    	{
	    		Vector<lectOrPract> tp= new Vector<lectOrPract>();
	    		
	    		int i,j,p,q,ct,cd;
	    		ct=teachers.size();
	    		cd=divs.size();
	    		
	    		for(i=0;i<ct;i++)
	    		{
	    			
	    			for(j=0;j<cd;j++)
	    			{

	    				int lcount=0;
	    				if(teachers.get(i).T_to_C[j]==false)
	    				{
	    					continue;
	    				}
	    				for(p=0;p<m;p++)
	    				{
	    					for(q=0;q<n;q++)
	    					{
	    						if(teachers.get(i).available[p][q]==0 && divs.get(j).available[p][q]==0)
	    						{
	    							lcount++;
	    						}
	    					}
	    				}
	    				
	    				if(lcount!=0)
	    				{
	    					int r=teachers.get(i).R_L_HM[j];
	    					if(r==0)
	    					{
	    						break;
	    					}
	    					float zx=((float)r)/lcount;
	    					lectOrPract e=new lectOrPract(false, i, j,zx);
	    					tp.add(e);
	    				}
	    					
	    			}
	    			
	    		}
	    		
	    		j=0;
	    		p=tp.size();
	    		for(i=1;i<p;i++)
	    		{
	    			if(tp.get(i).Lscore>tp.get(j).Lscore)
	    			{
	    				j=i;
	    			}
	    			
	    		}
	    		
	    		System.out.println("tp size :"+tp.size());
	    		if(p==0)
	    		{
	    			System.out.println("Select teacher failed  ");
	    		}
	    		
	    		return tp.get(j);
	    	}
	    		
	    	lectOrPract assignLRoom(lectOrPract tv) //done
	    	{
	    		int i,j,rm;
	    		j=rooms.size();
	    		rm=divs.get(tv.cls).rm;
	    		
	    		tv.s1=teachers.get(tv.t1).C_WSub[tv.cls];
	    		
	    		if(rm!=-1)
	    		{
	    			if(rooms.get(rm).available[tv.day][tv.timeing]==0)
	    			{
	    				tv.r1=rm;
	    				tv.score=1;
	    				return tv;
	    			}
		    			
	    		}
	    		
	    		for(i=0;i<j;i++)
	    		{
	    			if(rooms.get(i).available[tv.day][tv.timeing]==0)
	    			{
	    				tv.r1=i;
	    				tv.score=1;
	    				return tv;
	    			}
	    		}
	    		return tv;
	    	}
	    	

	    	lectOrPract find_lect(lectOrPract tg) throws Exception // done
	    	{
	    		int i,j,k;
	    		int pte=divs.get(tg.cls).practTime;
	    		System.out.println("Practime "+ pte);
	    		for(i=1;i<4;i++)// daily suBcount
	    		{
	    			
	    			for(j=0;j<n;j++)  //daily time wise
	    			{
	    				if(pte==j || pte+1==j)
	    				{
	    					System.out.println("continue"+j);
	    					continue;
	    				}
	    				for(k=0;k<m;k++)
	    				{
	    					
	    					if(teachers.get(tg.t1).available[k][j]==0 && divs.get(tg.cls).available[k][j]==0 && teachers.get(tg.t1).daily_LC[tg.cls][k]==i-1)
	    					{
	    					 tg.day=k;
	    					 tg.timeing=j;
	    					 tg.score=0;
	    					 tg=assignLRoom(tg);
	    						
	    					 if(tg.score==1)
	    						 {System.out.println("Time : "+tg.day+"  "+tg.timeing);
	    						   return tg;}
	    					}
	    				}
	    			}
	    			
	    		}
	    		
	    		System.out.println("Failed assigning lecture");
	    		throw new EmptyStackException();
	    		
	    	}
	    	
	    	void make_ReflectionL(lectOrPract temp)
	    	{
	    		int tday=temp.day;
	    		int ttime=temp.timeing;
	    	
	    		room_st rs;
	    	    teacher_st ts;
	    	    
	    	    System.out.println("Class "+divs.get(temp.cls).name +" "+temp.cls);
        	    System.out.println("Room1 "+rooms.get(temp.r1).Rname+" "+temp.r1);
        	    System.out.println("teach1 "+teachers.get(temp.t1).name+" "+temp.t1);
        	    System.out.println("Time : "+temp.day+"  "+temp.timeing);
	    	    System.out.println("------");
        	    
	    		divs.get(temp.cls).available[tday][ttime]=1;
	    		temp.FarDeptName=departN;
	    		divs.get(temp.cls).T_T[tday][ttime]=temp;
	    		
	    		rooms.get(temp.r1).available[tday][ttime]=1;
	    		rs=new room_st(false, tday, ttime, temp.t1, temp.cls,temp.s1);
	    		rs.FarDeptName=departN;
	    		rooms.get(temp.r1).T_T[tday][ttime]=rs;
	    		
	    		teachers.get(temp.t1).available[tday][ttime]=1;
	    		ts= new teacher_st(false, tday, ttime, temp.r1, temp.cls,temp.s1);
	    		ts.FarDeptName=departN;
	    		teachers.get(temp.t1).T_T[tday][ttime]=ts;
	    		
	    		teachers.get(temp.t1).daily_LC[temp.cls][tday]++;
	    		
	    		teachers.get(temp.t1).R_L_HM[temp.cls]--;
	    		teachers.get(temp.t1).RLC--;
	    		
	    	}
	        
	    	
            int	 makeLectures()
            {
            	int i,j,z;
            	System.out.println("Make Lecture (Major)");
        		lectOrPract temp;
        		int c=totalLect();
        		
        		try {
        		
        		for(;c>0;c--)
        		{
        			System.out.println("Lectures rem : "+c);
            		
        			temp=select_Teacher_L();
        			temp=find_lect(temp);
        			make_ReflectionL(temp);
        			/////////////////display 
    	         	int ds=divs.size();
    	         	
    	         	for( z=0;z<ds;z++)
                	{
                		System.out.println(divs.get(z).name);
                		for(i=0;i<m;i++)
                		{
                			for(j=0;j<n;j++)
                		{	
                		 System.out.print(divs.get(z).available[i][j]);
                		 System.out.print("  ");
                		}
                		System.out.println("");	
                		}
                	}
                	
                	int rs=rooms.size();
                	for( z=0;z<rs;z++)
                	{
                		System.out.println(rooms.get(z).Rname);
                    	
                		for(i=0;i<m;i++)
                		{
                		for(j=0;j<n;j++)
                		{	
                		 System.out.print(rooms.get(z).available[i][j]);
                		 System.out.print("  ");
                 		
                		}
                		System.out.println("");
                		}
                	}
                	
                	int lrs=Lrooms.size();
                	for( z=0;z<lrs;z++)
                	{System.out.println(Lrooms.get(z).Rname);
                	
                		for(i=0;i<m;i++)
                		{
                		for(j=0;j<n;j++)
                		{	
                			System.out.print(Lrooms.get(z).available[i][j]);
                		 System.out.print("  ");
                    	}
                		System.out.println("");
                		}
                	}
                	
    	         	
                	int ts=teachers.size();
                	for( z=0;z<ts;z++)
                	{
                		System.out.println(teachers.get(z).name);
                    	
                		for(i=0;i<m;i++)
                		{
                		for(j=0;j<n;j++)
                		{	
                		 System.out.print(teachers.get(z).available[i][j] + "  ");
                		}
                		System.out.println("");
                		}
                	}
    	         	
    	         	
    	         	/////////////////////// display END
    	        
        		}
        		}catch(Exception e)
        		{
        			System.out.println(e);
        			return 0;
        		}
            	return 1;
            }
	         
            
            void Clrinit()
            {
            	int i,j,k,z;
            	int ds=divs.size();
            	
            	for( z=0;z<ds;z++)
            	{
            		System.out.println(divs.get(z).name);
            		for(i=0;i<m;i++)
            		{
            			for(j=0;j<n;j++)
            		{	
            		 System.out.print(divs.get(z).available[i][j]);
            		 System.out.print("  ");
            		}
            		System.out.println("");	
            		}
            	}
            	
            	int rs=rooms.size();
            	for( z=0;z<rs;z++)
            	{
            		System.out.println(rooms.get(z).Rname);
                	
            		for(i=0;i<m;i++)
            		{
            		for(j=0;j<n;j++)
            		{	
            		 System.out.print(rooms.get(z).available[i][j]);
            		 System.out.print("  ");
             		
            		}
            		System.out.println("");
            		}
            	}
            	
            	int lrs=Lrooms.size();
            	for( z=0;z<lrs;z++)
            	{System.out.println(Lrooms.get(z).Rname);
            	
            		for(i=0;i<m;i++)
            		{
            		for(j=0;j<n;j++)
            		{	
            			System.out.print(Lrooms.get(z).available[i][j]);
            	
               		 System.out.print("  ");
                	}
            		System.out.println("");
            		}
            	}
            	
            	
            	int ts=teachers.size();

        		for(z=0;z<ts;z++)
        		{
        			Teacher tr=teachers.get(z);
        			
        			for(k=0;k<ds;k++)
        				for(j=0;j<m;j++)
        				{
        				
        					tr.daily_LC[k][j]=0;				
        				}
        			
        		}
            	
            	for( z=0;z<ts;z++)
            	{
            		System.out.println(teachers.get(z).name);
                	
            		for(i=0;i<m;i++)
            		{
            		for(j=0;j<n;j++)
            		{	
            		 System.out.print(teachers.get(z).available[i][j] + "  ");
            		}
            		System.out.println("");
            		}
            	}
            	
            	
            }
            
            
            
	         int createTT_Main()
	         {
	        	 int proc=1;
	        	Clrinit();
	        
	        	 try {
	        	 proc=makePracticals();
	        	 
	        	 }catch(Exception e)
	        	 {
	        		 
	        		e.printStackTrace();
	        		 return 0;
	        	 }
	        	 if(proc==0)
	        	 {
	        		 return proc;
	        	 }
	        	 
	        		 
	        	 try {
	        	 proc=makeLectures();
	        	 
	        	 }catch(Exception e)
	        	 {
	        		 e.printStackTrace();
	        		 return 0;
	        	 }
	        	 
	        	 return proc;
	         }
	    
}