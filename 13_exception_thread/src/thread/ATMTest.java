package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATMTest implements Runnable {
	private long depositeMoney=100000;//잔액
	private long balance;
	
	public static void main(String[] args) {
		ATMTest atm = new ATMTest();
		Thread mom = new Thread(atm);
		Thread son = new Thread(atm);
		
		
		mom.setName("엄마");
		son.setName("아들");
		mom.start();
		son.start();
	}

	@Override
	//public synchronized void run() {//동기화 = 한개의 쓰래드만 통과 가능하다.
	
	public void run() {
		
		synchronized (ATMTest.class) {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(Thread.currentThread().getName()+"님 안녕하세요");
			
			
			try {
				System.out.println("찾고자 하는 금액 입력 : ");
				balance = Long.parseLong(br.readLine());
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
				
			withDraw();	
		}
	}
	
	public void withDraw() {
		if(balance<=depositeMoney) {
			if(balance%10000==0) {
				depositeMoney = depositeMoney-balance; 		
				System.out.println("잔액은"+depositeMoney);
			} else {
				System.out.println("만원단위로 입력하세요");
			} 
				
		} else
			System.out.println("잔액 부족");

	}
}
