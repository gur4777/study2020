package collection;

import java.util.Scanner;
import java.util.Stack;
import static java.lang.System.out;

public class StrackTest {

	public static void main(String[] args) {
		//String[] groupA = {"�콺��Ű��Ÿ", "������Ʈ","����","���ѹα�"};
		Stack<String> stack = new Stack<String>();
		
		//for(int i=0; i<groupA.length; i++)
			stack.push("����");
		stack.push("����");
		stack.push("����");
		
		out.println(stack.pop());
		out.println(stack.pop());
		out.println(stack.pop());
		
//		while(! stack.isEmpty())
//			out.println(stack.pop() );
		
		Stack<Boolean> a = new Stack<Boolean>();
		a.add(true);
		a.push(true);
		a.push(true);
		a.push(true);
		a.push(false);
		a.push(true);
		a.push(false);
		a.push(true);
		a.push(true);
		a.push(true);
		a.push(true);
		Scanner sc = new Scanner(System.in);
		while(true) {
			while(a.pop()) {
				System.out.println("true");
			}
			System.out.println("false");
		}
	}

}