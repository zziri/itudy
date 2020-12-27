package lambda;

@FunctionalInterface
interface PrintString{
	void printStr(String str);
}

public class LambdaTest {

	public static void main(String[] args) {
		// 1. 함수를 자료형으로 선언 
		PrintString lambdaPrintStr = str->System.out.println(str);
		lambdaPrintStr.printStr("Test");
		
		printMyStr(lambdaPrintStr);
		
		PrintString newLambdaPrintStr = updatePrintStr();
		newLambdaPrintStr.printStr("Test3");		

	}
	
	// 2. 함수를 매개변수를 람다식으로 전해줘서 함수 내부에서 사용
	public static void printMyStr(PrintString lambdaStr)
	{
		lambdaStr.printStr("Test2");
	}
	
	// 3. 함수의 리턴값으로 사용.
	public static PrintString updatePrintStr()
	{
		return str->System.out.println(str + "!!!");
	}
}
