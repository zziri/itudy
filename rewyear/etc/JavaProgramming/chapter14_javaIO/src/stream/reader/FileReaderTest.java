package stream.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		// ���ڸ� �о���� �ϴµ� ��¿�� ���� ����Ʈ ��Ʈ������ �о�� �ϴ°��(ex.���� ���α׷���)
		// ���� ��Ʈ���� �̿��Ͽ� ����Ʈ��Ʈ���� ���ڴ����� �о����.
//		FileInputStream fis = new FileInputStream("reader.txt");
//		InputStreamReader isr = new InputStreamReader(fis);
//		int i;
//		while((i = isr.read()) != -1) {
//			System.out.print((char)i);
//		}
//		isr.close();
		
		FileReader fr = new FileReader("reader.txt");
		int i;
		while((i = fr.read()) != -1) {
			System.out.print((char)i);
		}
		
		

	}

}
