package interfaceEx;

public class PrioritAllocation implements Scheduler {

	@Override
	public void getNextCall() {
		System.out.println("������� ���� ���� call�� ���� �����ɴϴ�.");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("���� ���õ��� ���� �������� ���� ����մϴ�.");
	}

}
