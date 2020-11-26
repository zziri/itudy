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
		
		// main thread ���忡�� jt1�� jt2���� join�� �ɾ��� ������ jt1,jt2�� dead�� �ɶ�����
		// main thread�� non-runnable ���°� �ȴ�.
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
