package queue;

import java.util.Scanner;

public class qf {
	int f,r,max;
	int[] q;
	
	qf(){
		f=0;
		r=-1;
		max=5;
		q=new int[max];
	}
	
	void enq(){
		if(r==(max-1)) {
			System.out.println("overflow");
		}else {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the new element ");
			int n=sc.nextInt();
			q[++r]=n;
		}
		
	}
	
	void dq() {
		if(f>r){
			System.out.println("underflow");
		}else {
			System.out.println("the element delted is"+q[f++]);
			
		}
	}
		
	
	void display(){
		for(int i=f;i<=r;i++) {
			System.out.println(q[i]);
		}
			
		}
		

}
