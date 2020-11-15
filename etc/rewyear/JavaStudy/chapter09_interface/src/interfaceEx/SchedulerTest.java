package interfaceEx;

import java.io.IOException;

public class SchedulerTest {

	public static void main(String[] args) throws IOException {
		System.out.println("��ȭ ���� �Ҵ� ����� �����ϼ���.");
		System.out.println("R : �Ѹ�� ���ʴ��");
		System.out.println("L : ��Ⱑ ���� ���� �켱");
		System.out.println("P : �켱������ ���� ���켱 ���õ� ���� ����");
		
		int mode = System.in.read();
		Scheduler scheduler = null;
		
		if(mode == 'R' || mode == 'r') {
			scheduler = new RoundRobin();
		}
		else if(mode == 'L' || mode == 'l') {
			scheduler = new LeastJob();
		}
		else if(mode == 'P' || mode == 'p') {
			scheduler = new PrioritAllocation();
		}
		else {
			System.out.println("�������� �ʴ� ��å�Դϴ�.");
			return;
		}
		
		scheduler.getNextCall();
		scheduler.sendCallToAgent();
	}

}
