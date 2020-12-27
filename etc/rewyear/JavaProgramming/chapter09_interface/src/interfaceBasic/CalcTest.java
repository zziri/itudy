package interfaceBasic;

public class CalcTest {

	public static void main(String[] args) {
		CompleteCalc calc = new CompleteCalc();
		
		int n1 = 10;
		int n2 = 2;
		
		calc.description();
		
		int[] ary = {1,2,3,4,5}; 
		int sum = Calc.total(ary);
		
		System.out.println(sum);

	}

}
