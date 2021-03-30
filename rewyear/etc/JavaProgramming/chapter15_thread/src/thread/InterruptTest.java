package thread;

public class InterruptTest extends Thread{
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(i);
		}
		
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("wake!!!!");
		}
	}
	public static void main(String[] args) {
		InterruptTest it = new InterruptTest();
		it.start();
		
		// sleep으로 blocking된 thread를 wake
		it.interrupt();
		System.out.println("end!!!");

	}

}
