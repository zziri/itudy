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
//		// 1. finally�� ��� �׻� ���ҽ� ���� �� �ݵ�� ����Ǿ�� �ϴ� �������� ����ִ�.
//		try {
//			fis = new FileInputStream("a.txt");
//		} 
//		catch(FileNotFoundException e) {
//			System.out.println(e);
//		}
//		finally { // try�� �����ϴ�, �����ϴ� finally������ �Ѿ�� �ڵ尡 �����.
//			try {
//				fis.close();
//				System.out.println("finally called");
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//		}
//		
//		// 2. try-with-resource��
//		// �ڹ�7 �̻���� �ش� ���ҽ��� AutoCloseable�� ������ ��� ���� ���� close()�� ��������� ȣ������ �ʾƵ�
//		// �������� ��쳪 ���ܰ� �߻��� ��� ��� �ڵ����� close()�� ȣ�� ��.
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
