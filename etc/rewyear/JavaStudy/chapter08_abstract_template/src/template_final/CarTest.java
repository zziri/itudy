package template_final;

public class CarTest {

	public static void main(String[] args) {
		Car aiCar = new AICar();
		Car manualCar = new ManualCar();
		
		// run() �޼���� �߻�Ŭ������ Car���� final�� �̿��Ͽ� ���ø� �޼���� ����
		// ������ ��ũ���� ���۽ó������� ������ ������, ���� Ŭ�������� �Ϻθ� �ٲ�����ϴ� ��� 
		// �߻� Ŭ�������� ���ø� �޼��带 �������ְ�, ���� Ŭ������ �ش� Ŭ������ �°� ������ 
		aiCar.run();
		System.out.println("=================");
		manualCar.run();

	}

}
