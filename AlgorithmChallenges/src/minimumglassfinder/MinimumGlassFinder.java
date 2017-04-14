/*
 * Finding the minimum number of glasses required to serve 
 * the guests arriving and going from a party at a certain 
 * interval of time
 * */

package minimumglassfinder;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;


public class MinimumGlassFinder{

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int count=0;
		int n=Integer.parseInt(br.readLine());
		System.out.println(n);
		String arr_dep[][]=new String[n][n];
	    for(int i=0;i<n;i++){
			String s[]=br.readLine().split("#");
			arr_dep[i][0]=s[0];
			arr_dep[i][1]=s[1];
		}
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date minArr=sdf.parse(arr_dep[0][0]),maxDep=sdf.parse(arr_dep[0][1]);
		for(int i=0;i<n;i++){
		 Date arr=sdf.parse(arr_dep[i][0]);
		 Date dep=sdf.parse(arr_dep[i][1]);
		 if(i!=0){
		     if(minArr.after(arr)){
		         minArr=arr;
		     }
		     if(maxDep.before(dep)){
		         maxDep=dep;
		     }
		 }
		System.out.println(minArr+"    "+maxDep);
		}
		long diffMins=(maxDep.getTime()-minArr.getTime())/(60*1000)%60;
		System.out.println("diffMins  "+diffMins);
		Calendar cal1=Calendar.getInstance();
		Calendar cal2=Calendar.getInstance();
		cal1.setTime(minArr);
		cal2.setTime(maxDep);
		int flag=0;
		int glasses=0;
		
		for(int i=0;i<=diffMins+1;i++){
		    System.out.println("inside 1");
		    int j=0;
		    while(j<n){
		        System.out.println("inside while");
		        System.out.println("arrTime: "+sdf.parse(sdf.format(cal1.getTime()))+"       "+sdf.parse(arr_dep[j][0]));
		        System.out.println("depTime: "+sdf.parse(sdf.format(cal2.getTime()))+"       "+sdf.parse(arr_dep[j][1]));
		        if(sdf.parse(sdf.format(cal1.getTime())).equals(sdf.parse(arr_dep[j][0]))){
		            count++;
		            System.out.println("count: "+count);
		        }else if(sdf.parse(sdf.format(cal2.getTime())).equals(sdf.parse(arr_dep[j][1]))){
		            flag=1;
		        }
		        
		    
		        System.out.println("inside 2");
		        if(count>glasses){
		            glasses=count;
		        }
		        System.out.println("glasses : "+glasses);
		        j++;
		    }
		    if(flag==1){
		        count--;
		        flag=0;
		    }
		    cal1.add(Calendar.MINUTE, 1);
		    System.out.println("count  "+count);
		    
		    
		}
		System.out.println("glasses  "+glasses);
	}

}
