package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest_Gugudan {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("원하는 단을 입력: ");
		int dan = Integer.parseInt(bf.readLine());
		int i;
		
		for(i=1; i<10; i++) {
			System.out.println(dan+"*"+i+"="+dan*i);
		}
		
	}
}
