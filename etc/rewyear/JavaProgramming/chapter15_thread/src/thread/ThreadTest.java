package thread;

class MyThread extends Thread{

	@Override
	public void run() {
		for(int i=0; i<200; i++)
		{
			System.out.print(i + "\t");
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class YourThread implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<200; i++)
		{
			System.out.printf("[%d]\t",i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}


	
}

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start!!!");
		
		MyThread th1 = new MyThread();
		
		YourThread yth = new YourThread();
		Thread th2 = new Thread(yth);
		
		th1.start();
		th2.start();
		
		// 해당 프로그램의 스레드 확인
		Thread t = Thread.currentThread();
		System.out.println(t);
		
		System.out.println("End!!!");
		

	}

}
