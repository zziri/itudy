package stream.inputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputTest {

	public static void main(String[] args) {
		
		
		try(FileInputStream fis = new FileInputStream("input.txt")) {		
			int i;
			while((i = fis.read()) != -1) {
				System.out.print((char)i);
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}	
		
		try(FileInputStream fis2 = new FileInputStream("input2.txt")) {		
			int i;
			byte[] bs = new byte[10]; 
			while((i = fis2.read(bs)) != -1) { // ����Ʈ �迭 ������ �о� ���� ���, ���� ����Ʈ �� ��ŭ ��ȯ
				for(int j=0; j<i; j++) {
					System.out.print((char)bs[j]);
				}
				System.out.println("");
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}	

	}

}
