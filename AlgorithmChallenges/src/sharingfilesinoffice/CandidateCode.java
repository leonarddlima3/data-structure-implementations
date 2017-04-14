package sharingfilesinoffice;

import java.util.*;
public class CandidateCode {
	
	public static int minimumpossiblecost(String input1){
		//write code here
		String process1[]=input1.split("#");
		for(int i=0;i<process1.length;i++){
			System.out.println(process1[i]);
		}
		String process2[][]=new String[process1.length][];
		for(int i=0;i<process1.length;i++){
			process2[i]=process1[i].split("@");
		}
		System.out.println(process2.length);
		int process3[][]=new int[process2.length][process2[0].length];
		for(int i=0;i<process3.length;i++){
			for(int j=0;j<process3[0].length;j++){
				process3[i][j]=Integer.parseInt(process2[i][j]);
			}
		}
		for(int i=0;i<process3.length;i++){
			System.out.println("");
			for(int j=0;j<process3[0].length;j++){
				System.out.print(process3[i][j]+"		");
			}
		}
		for(int i=0;i<process3.length;i++){
			for(int j=0;j<process3[0].length;j++){
				process2[i][j]="/";
			}
		}
		String process4[][]=new String[process3.length][process3[0].length];
		for(int i=0;i<process3.length;i++){
			for(int j=0;j<process3[0].length;j++){
				if(process3[i][j]<0){
					if(process2[i][j].equals("/")){
						process2[i][j]="";
					}
					if(i+1<process3.length){
						if(process3[i+1][j]<0){
							process4[i][j]="#"+(i+1)+"!"+j;
						}
						process2[i][j]+=process3[i+1][j]+"@";
					}
					if(i-1>=0){
						if(process3[i-1][j]<0){
							process4[i][j]="#"+(i-1)+"!"+j;
						}
						process2[i][j]+=process3[i-1][j]+"@";
					}
					if(j+1<process3.length){
						if(process3[i][j+1]<0){
							process4[i][j]="#"+(i)+"!"+(j+1);
						}
						process2[i][j]+=process3[i][j+1]+"@";
					}
					if(j-1>=0){
						if(process3[i][j+1]<0){
							process4[i][j]="#"+(i)+"!"+(j+1);
						}
						process2[i][j]+=process3[i][j-1]+"@";
					}
					if(j-1>=0&&i-1>=0){
						if(process3[i-1][j-1]<0){
							process4[i][j]="#"+(i-1)+"!"+(j-1);
						}
						process2[i][j]+=process3[i-1][j-1]+"@";
					}
					if(j+1>=0&&i+1>=0){
						process2[i][j]+=process3[i+1][j+1]+"@";
					}
					if(j-1>=0&&i+1>=0){
						process2[i][j]+=process3[i+1][j-1]+"@";
					}
					if(j+1>=0&&i-1>=0){
						process2[i][j]+=process3[i-1][j+1]+"@";
					}
				}
			}
		}
		return 0;
	}

}
