package stream.decorator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		long startmsec = 0, endmsec = 0;
		
		try(FileInputStream fis = new FileInputStream("a.zip");
				FileOutputStream fos = new FileOutputStream("a_copy.zip");
				BufferedInputStream bis = new BufferedInputStream(fis);
				BufferedOutputStream bos = new BufferedOutputStream(fos);){
			
			int cnt;
			startmsec = System.currentTimeMillis();
			
			while((cnt = bis.read()) != -1){
				bos.write(cnt);
			}
			
			endmsec = System.currentTimeMillis();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("duration: %d\n",endmsec-startmsec);
		
		// ���� ��Ʈ���� �Ǵٸ� ������Ʈ���� decorate�Ҽ� ����.
		Socket sock = new Socket();
		// ��ݽ�Ʈ�� InputStream�� InputStreamReader�� ���ΰ� �̸� �� BufferedReader�� ���μ� ���
		BufferedReader isr = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		

	}

}
