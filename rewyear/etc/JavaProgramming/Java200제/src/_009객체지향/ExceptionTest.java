package _009��ü����;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// �ڹٿ����� ����ó���� �ϱ����� try{ }���� ���ܰ� �߻��� �� �ִ� �ҽ���,
// catch(Exception){ }������ ���ܰ� �߻��� ��� ��� ó���� �������� �ۼ�
public class ExceptionTest {

	public static void main(String[] args) {
		Date today = new Date();	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(today);
		
		// ex1. SimpleDateFormat�� �̿��ؼ� String�� Date���·� ��ȯ�� ��
		// "����4�ڸ�-��2�ڸ�-��2�ڸ�" format�̾�� �ϴµ�, �ش� format�� �ƴ� ��쿡 ���� ����ó��
		try {
			Date d = sdf.parse(str);
		} catch (ParseException e) {
			System.out.println(e);
		}
		
		// ex2. ���� �߻����ο� ������� �����ؾ� �ϴ� �ڵ��� ��� finally{}���� �ۼ��Ѵ�.
		InputStream inputStream = null;
		URL url = null;
		String newUrls = null;
		boolean isConnection = false;
		
		try {
			url = new URL(newUrls);
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection(); 
			inputStream = new BufferedInputStream(urlConnection.getInputStream());
			
			isConnection = true;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// ex3. �밳 �ڹ��� IO�� AutoCloseable�� ��ӹ��� Closeable �������̽��� close()�� 
		// �����߱� ������ finally Ű���带 ������� �ʰ� �ڵ������� ���� ����� close()�� ȣ��Ǹ�
		// ������ ���� try(){} �������� �ۼ��� �� �ִ�.
		
		try(FileInputStream fis = new FileInputStream("a.txt");
				BufferedInputStream bis = new BufferedInputStream(fis);)
		{
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
