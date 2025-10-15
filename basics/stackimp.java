package stack;
import java.util.*;
public class stackimp {
	int top,max;
	int[] stack;
	
	stackimp(){
		top=-1;
		max=5;
		stack=new int[max];
		
	}
	void push() {
		if(top==max-1) {
			System.out.println("stack over flow");
		}else {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the new element ");
			int n=sc.nextInt();
			stack[++top]=n;
			
		}
	}
	
	void pop() {
		if(top==-1) {
			System.out.println("stackvunder flow");
		}else {
			System.out.println("the deleted element is"+stack[top--]);
		}
	}
	
	void display() {
		for(int i=top;i>=0;i--) {
			System.out.println(stack[i]);
			
		}
	}
	
	

}
