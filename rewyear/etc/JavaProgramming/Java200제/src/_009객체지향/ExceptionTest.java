package _009객체지향;

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

// 자바에서는 예외처리를 하기위해 try{ }블럭에 예외가 발생할 수 있는 소스를,
// catch(Exception){ }블럭에는 예외가 발생할 경우 어떻게 처리할 것인지를 작성
public class ExceptionTest {

	public static void main(String[] args) {
		Date today = new Date();	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(today);
		
		// ex1. SimpleDateFormat를 이용해서 String을 Date형태로 변환할 때
		// "연도4자리-월2자리-일2자리" format이어야 하는데, 해당 format이 아닌 경우에 대한 예외처리
		try {
			Date d = sdf.parse(str);
		} catch (ParseException e) {
			System.out.println(e);
		}
		
		// ex2. 예외 발생여부와 상관없이 실행해야 하는 코드의 경우 finally{}블럭에 작성한다.
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
		
		// ex3. 대개 자바의 IO는 AutoCloseable을 상속받은 Closeable 인터페이스의 close()를 
		// 구현했기 때문에 finally 키워드를 사용하지 않고도 자동적으로 블럭을 벗어나면 close()가 호출되며
		// 다음과 같이 try(){} 구문으로 작성할 수 있다.
		
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
