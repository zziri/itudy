package stream.inputStream;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemTest2 {

	public static void main(String[] args) {
		System.out.println("입력 후 종료하시려면 '끝'을 입력하세요: ");
		
		try {
			int i;
			// 보조 스트림인 InputStreamReader를 사용하여 바이트 단위로 읽어들이는 System.in.read()를 문자로 읽게 보조
			// 보조 스트림은 항상 혼자 사용하지 못하고 생성자 호출하면서 기반 스트림을 사용해야함.
			InputStreamReader isr = new InputStreamReader(System.in);
			while((i = isr.read()) != '끝') {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
