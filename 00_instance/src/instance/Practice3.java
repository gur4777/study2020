package instance;

public class Practice3 {
	public static void main(String[] args) {
		
		String name = "L";
		int basePay = 2500000;
		double tax = basePay*3.3/100;
		int salary = basePay-(int)tax;
		
		
		System.out.println("�̸��� L�� ����� �⺻���� 2500000�϶� 3.3%�� ���ݰ� ������ ����Ͻÿ�.");
		System.out.println("�����ʹ� �ݵ�� ������ ����");
		
		System.out.println("****"+name+"�� ����****");
		System.out.println("�⺻�� : "+basePay);
		System.out.println("���� : " +(int)tax);
		System.out.println("���� : "+salary);
	}
}