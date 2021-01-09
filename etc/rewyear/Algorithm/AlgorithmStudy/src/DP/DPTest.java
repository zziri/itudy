package DP;

public class DPTest {
	// 단순 재귀함수로 구현한 피보나치
	// 
	public static int fib(int n)
	{
		if(n == 2 || n==1) return 1;
		else return fib(n-1) + fib(n-2);
	}
	
	// 하향식 피보나치 dp
	// 한 번 계산한 결과를 메모이제이션하기 위한 dp테이블 초기화
	public static int[] dp1 = new int[1000];
	
	public static int fib1(int n)
	{
		if(n == 2 || n==1) return 1;
		
		// 계산한 적이 있는 경우 저장한 값 반환
		if(dp1[n] != 0)
			return dp1[n];
		
		// 한번도 계산하지 않은 문제라면, 피보나치 계산하여 반환
		dp1[n] = fib(n-1) + fib(n-2);
		return dp1[n]; 
	}
	
	// 상향식 피보나치 dp
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
