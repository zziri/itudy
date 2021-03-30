package stream.outputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputTest {
	public static void main(String[] args) {
		// FileOutputStream을 사용 시, true와 같이 사용하면 기존 파일에 append 
		try(FileOutputStream fos = new FileOutputStream("output.txt",true))
		{
			fos.write(65);
			fos.write(66);
			fos.write(67);
		}catch (IOException e) {
			System.out.println(e);
		}
		
		// 바이트 단위로 write
		byte[] bs = new byte[26];
		byte data = 65;
		
		for(int i=0; i<bs.length; i++)
		{
			bs[i]=data++;
		}
		
		try(FileOutputStream fos2 = new FileOutputStream("output2.txt");
				FileInputStream fis = new FileInputStream("output2.txt"))
		{	
			fos2.write(bs);
			
			int i;
			byte[] bis = new byte[26];
			while((i=fis.read(bis)) != -1) {
				for(int j=0; j<i; j++) {
					System.out.print((char)bs[j]);
				}
			}
		}catch (IOException e) {
			System.out.println(e);
		}
	}
}
