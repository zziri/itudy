package DP;

public class DPTest {
	// �ܼ� ����Լ��� ������ �Ǻ���ġ
	// 
	public static int fib(int n)
	{
		if(n == 2 || n==1) return 1;
		else return fib(n-1) + fib(n-2);
	}
	
	// ����� �Ǻ���ġ dp
	// �� �� ����� ����� �޸������̼��ϱ� ���� dp���̺� �ʱ�ȭ
	public static int[] dp1 = new int[1000];
	
	public static int fib1(int n)
	{
		if(n == 2 || n==1) return 1;
		
		// ����� ���� �ִ� ��� ������ �� ��ȯ
		if(dp1[n] != 0)
			return dp1[n];
		
		// �ѹ��� ������� ���� �������, �Ǻ���ġ ����Ͽ� ��ȯ
		dp1[n] = fib(n-1) + fib(n-2);
		return dp1[n]; 
	}
	
	// ����� �Ǻ���ġ dp
	public static int[] dp2 = new int[1000];
	public static int fib2(int n)
	{
		dp2[1] = 1;
		dp2[2] = 1;
		
		for(int i=3; i<=n; i++)
		{
			dp2[i] = dp2[i-2] + dp2[i-1];
		}
		
		return dp2[n];
	}
	
	public static void main(String[] args) {
		
		long start,end;
		
		start = System.currentTimeMillis();
		System.out.println(fib(40));
		end = System.currentTimeMillis();
		System.out.printf("duration: %d\n",end - start);
		
		start = System.currentTimeMillis();
		System.out.println(fib1(40));
		end = System.currentTimeMillis();
		System.out.printf("duration: %d\n",end - start);
		
		start = System.currentTimeMillis();
		System.out.println(fib2(40));
		end = System.currentTimeMillis();
		System.out.printf("duration: %d\n",end - start);

	}

}
