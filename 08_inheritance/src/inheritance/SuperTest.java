package inheritance;

public class SuperTest {
	protected double weight, height;
	
	public SuperTest() {
		System.out.println("suferTest의 기본 생성자 입니다.");
	}
	public SuperTest(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}
	
	public void disp(){
		System.out.println("몸무게= "+weight);
		System.out.println("키= "+height);
	}
}
