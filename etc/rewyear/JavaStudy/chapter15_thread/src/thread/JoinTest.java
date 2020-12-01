package thread;

public class JoinTest extends Thread {
	
	int start;
	int end;
	int total=0;
	
	public JoinTest(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
	
	public void run() {
		for(int i=start; i<=end; i++)
		{
			total += i;
		}
	}

	public static void main(String[] args) {
		JoinTest jt1 = new JoinTest(1,50);
		JoinTest jt2 = new JoinTest(51,100);
		
		jt1.start();
		jt2.start();
		
		// main thread 입장에서 jt1과 jt2에게 join을 걸었기 때문에 jt1,jt2가 dead가 될때까지
		// main thread는 non-runnable 상태가 된다.
		try {
			jt1.join();
			jt2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int total = jt1.total + jt2.total;
		System.out.println(jt1.total);
		System.out.println(jt2.total);
		System.out.println(total);

	}

}
