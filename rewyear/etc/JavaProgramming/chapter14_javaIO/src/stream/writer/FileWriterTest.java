package stream.writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) throws IOException {
		// FileOutputStream�� ���������� ����Ʈ�� ���� ������ �����Ͽ� write�� �� �� ����.
//		FileOutputStream fos = new FileOutputStream("writer.txt");
//		OutputStreamWriter osw = new OutputStreamWriter(fos);
		
		FileWriter fw = new FileWriter("writer.txt");
		
		fw.write('A');
		
		char[] buf = {'X', 'Y', 'Z', 'L', 'M', 'N'};
		fw.write(buf,3,3); // (buffer, start, cnt)
		
		fw.write("Java���͵� �Դϴ�.");
		
		fw.close();

	}

}
