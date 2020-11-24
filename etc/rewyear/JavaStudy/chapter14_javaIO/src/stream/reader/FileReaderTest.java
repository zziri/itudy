package stream.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		// 문자를 읽어들어야 하는데 어쩔수 없이 바이트 스트림으로 읽어야 하는경우(ex.소켓 프로그래밍)
		// 보조 스트림을 이용하여 바이트스트림을 문자단위로 읽어들임.
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
