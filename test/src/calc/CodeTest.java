package calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CodeTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[][] a = new String[][] {{"keroro","dood"},{"loa","noa"}};
		String b = "dodo";
		System.out.println(a.length);
		System.out.println(a[0].length);
		System.out.println(a[0][0].length());
		
		System.out.println(a);
		System.out.println(a[0]);
		System.out.println(a[0][0].toString());
		System.out.println(b.toString());
		

	}

}

/*
 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
 * 
 * System.out.print(" 입력 > "); int su = sc.nextInt();
 * 
 * int[] s = new int [8];
 * 
 * for(int i = 0; i<s.length; i++) { s[i] = su%2; su= su/2; } for(int i =
 * s.length-1; i>=0; i--) {
 * 
 * System.out.print(s[i]); } }
 */


//
//while (true) {
//	int count = 0;
//	int[] binary = new int[32];
//	
//	
//	System.out.print("10진수 입력: ");
//	int su = Integer.parseInt(br.readLine());
//	if (su > 0) {
//		for (int i = 0; i < binary.length; i++) {
//			binary[i] = su % 2;
//			su = su / 2;
//			count++;
//			if (su == 0 && (i + 1) % 4 == 0) {
//				break;
//			}
//		}
//	} else if (su == 0)	break; else; // su ==0이면 종료; 그외 음수일경우 반복 
//
//	for (int i = count; i > 0; i--) {
//		
//		System.out.print(binary[i-1]);
//		count--;
//		if (count % 4 == 0)
//			System.out.print(" ");
//	}
//	System.out.println();
//}
//System.out.println("프로그램 종료");