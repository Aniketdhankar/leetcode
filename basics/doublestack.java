package stack;
import java.util.*;

public class doublestack {
	int t1,t2,max;
	int[] stack;
	static Scanner sc=new Scanner(System.in);

	doublestack(){
		t1=-1;
		t2=max;
		max=5;
		stack=new int[max];
		
	}
	void push() {
		if(t2-t1==-1) {
			System.out.println("overflow");
		}else {
			System.out.println("eneter the ele");
			
			int n=sc.nextInt();
			System.out.println("eneter at top- 1 or bottom -2");
			//top(max wali side)
			int ch=sc.nextInt();
			if(ch==1) {
				t2--;
				stack[t2]=n;
			}else if(ch==2) {
				stack[++t1]=n;
			}
		}
		}
		
		
		void pop() {
			System.out.println("pop at top- 1 or bottom -2");
			int ch=sc.nextInt();
			if(ch==1) {
				if(t2!=max) {
					System.out.println("the deleted element is"+stack[t2++]);
				}else {
					System.out.println("underflow");
				}
		}
			else if(ch==2) {
				if(t1!=-1) {
					System.out.println("the deleted element is"+stack[t1--]);
				}else {
					System.out.println("underflow");
					
				}
					
				}
		}
		void display() {
			for(int i=max-1;i>=0;i--) {
				System.out.println(stack[i]);		
			}
		}
	}
		
