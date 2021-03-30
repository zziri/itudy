package stream.writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) throws IOException {
		// FileOutputStream도 마찬가지로 바이트를 문자 단위로 변경하여 write를 할 수 있음.
//		FileOutputStream fos = new FileOutputStream("writer.txt");
//		OutputStreamWriter osw = new OutputStreamWriter(fos);
		
		FileWriter fw = new FileWriter("writer.txt");
		
		fw.write('A');
		
		char[] buf = {'X', 'Y', 'Z', 'L', 'M', 'N'};
		fw.write(buf,3,3); // (buffer, start, cnt)
		
		fw.write("Java스터디 입니다.");
		
		fw.close();

	}

}
