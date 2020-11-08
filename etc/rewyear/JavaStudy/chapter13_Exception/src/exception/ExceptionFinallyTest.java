//package exception;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//public class ExceptionFinallyTest {
//
//	public static void main(String[] args) {
//		
//		FileInputStream fis = null;
//		
//		// 1. finally의 경우 항상 리소스 해제 등 반드시 실행되어야 하는 시퀀스가 들어있다.
//		try {
//			fis = new FileInputStream("a.txt");
//		} 
//		catch(FileNotFoundException e) {
//			System.out.println(e);
//		}
//		finally { // try가 성공하던, 실패하던 finally문으로 넘어와 코드가 실행됨.
//			try {
//				fis.close();
//				System.out.println("finally called");
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//		}
//		
//		// 2. try-with-resource문
//		// 자바7 이상부터 해당 리소스가 AutoCloseable을 구현한 경우 위와 같이 close()를 명시적으로 호출하지 않아도
//		// 정상적인 경우나 예외가 발생한 경우 모두 자동으로 close()가 호출 됨.
//		try(FileInputStream fis2 = new FileInputStream("a.txt")){
//			
//		}catch(FileNotFoundException e) {
//			System.out.println(e);
//		}catch(IOException e) {
//			System.out.println(e);
//		}
//		
//		
//		
//		
//
//	}
//
//}
