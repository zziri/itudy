package lambda;

@FunctionalInterface
interface PrintString{
	void printStr(String str);
}

public class LambdaTest {

	public static void main(String[] args) {
		// 1. �Լ��� �ڷ������� ���� 
		PrintString lambdaPrintStr = str->System.out.println(str);
		lambdaPrintStr.printStr("Test");
		
		printMyStr(lambdaPrintStr);
		
		PrintString newLambdaPrintStr = updatePrintStr();
		newLambdaPrintStr.printStr("Test3");		

	}
	
	// 2. �Լ��� �Ű������� ���ٽ����� �����༭ �Լ� ���ο��� ���
	public static void printMyStr(PrintString lambdaStr)
	{
		lambdaStr.printStr("Test2");
	}
	
	// 3. �Լ��� ���ϰ����� ���.
	public static PrintString updatePrintStr()
	{
		return str->System.out.println(str + "!!!");
	}
}
