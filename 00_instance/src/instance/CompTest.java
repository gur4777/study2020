package instance;

public class CompTest {
	
	public static void main(String[] args) {
		
		int score = 90;
		
		String result = score >=80 && score <=100 ? "�հ�" : "���հ�";
		System.out.println(score >=80 && score <=100 ? "�հ�" : "���հ�");
		System.out.println("���:"+result);
		
		result = score%2==0 && score !=0 ? "¦��": "Ȧ��";
		System.out.println("Ȧ¦ ���: "+result);
		
		int b = 80;
		result = score < b ? String.format("%d", b):String.format("%d", score);
		System.out.println("ū ��: "+result);
		
	}
}
