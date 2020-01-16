package thread;

public class Synchronized extends Thread{
	private static int count;
	
	public static void main(String[] args) {
		Synchronized aa = new Synchronized();
		Synchronized bb = new Synchronized();
		Synchronized cc = new Synchronized();
		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");
		aa.start();
		bb.start();
		cc.start();
	}
	
	//public synchronized void run() {//����ȭ�� �ȵȴ�.
	public void run() {
//		synchronized(this) {����ȭ�� �ȵ�
		synchronized(Synchronized.class) {//����ȭ ��
			for(int i =1; i<=5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName()+" : "+count);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}