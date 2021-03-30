package interfaceEx;

import java.io.IOException;

public class SchedulerTest {

	public static void main(String[] args) throws IOException {
		System.out.println("전화 상담원 할당 방식을 선택하세요.");
		System.out.println("R : 한명식 차례대로");
		System.out.println("L : 대기가 적은 상담원 우선");
		System.out.println("P : 우선순위가 높은 고객우선 숙련도 높은 상담원");
		
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
			System.out.println("지원되지 않는 정책입니다.");
			return;
		}
		
		scheduler.getNextCall();
		scheduler.sendCallToAgent();
	}

}
