package exam;

class HelloTest{
	public static void main(String[] args){
		System.out.println("�ȳ��ϼ���");
		System.out.print("�ݰ����ϴ�\n");
		System.out.println("�ߺ�Ź�����");
		System.out.println("���"+"������");
		System.out.println(36+10);
		System.out.println("36"+"10");
		System.out.println("36+10 = "+36+10);
		System.out.println("36+10 = "+(36+10));
		System.out.println("36/10 = "+(36/10));
		System.out.println("36/10 = "+(36.0/10.0));
		System.out.println("25/36 = "+ ((int)(25.0/36.0*10+0.5))/10.0); //�Ҽ����� ù°¥������ 
		System.out.print("25/36 = "+ String.format("%.1f",(25.0/36.0)) );
	
		System.out.println();
	}
}

