package instance;

public class Variable2 {
	// ���������� ����� ���ÿ� 0���� �ʱ�ȭ�ȴ�
	int a; // field �������� , �ν��Ͻ� ����
	static int b; //        Ŭ���� ����
	String str;
	
	public static void main(String[] args) {
		int a=5; // local variable(��������) �ʱ�ȭ�� ���� ������ �����Ⱚ�� ����.
		int b=0;
		Variable2 va = new Variable2();
		
		System.out.println("����a = "+a);
		System.out.println("�ʵ�a = "+va.a);
		System.out.println("�ʵ�b = "+Variable2.b);
		System.out.println("�ʵ�str = "+ new Variable2().str);
		
	}
}