package stream.inputStream;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemTest2 {

	public static void main(String[] args) {
		System.out.println("�Է� �� �����Ͻ÷��� '��'�� �Է��ϼ���: ");
		
		try {
			int i;
			// ���� ��Ʈ���� InputStreamReader�� ����Ͽ� ����Ʈ ������ �о���̴� System.in.read()�� ���ڷ� �а� ����
			// ���� ��Ʈ���� �׻� ȥ�� ������� ���ϰ� ������ ȣ���ϸ鼭 ��� ��Ʈ���� ����ؾ���.
			InputStreamReader isr = new InputStreamReader(System.in);
			while((i = isr.read()) != '��') {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
