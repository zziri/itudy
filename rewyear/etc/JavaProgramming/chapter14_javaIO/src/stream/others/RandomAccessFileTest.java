package stream.others;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile rf = new RandomAccessFile("random.txt","rw");
		rf.writeInt(100);
		System.out.println(rf.getFilePointer()); // ������ int��(4byte)�� �ϳ� write�߱⶧���� ��ġ 4�� ���
		
		rf.writeDouble(3.14);
		rf.writeUTF("�ȳ��ϼ���");
		System.out.println(rf.getFilePointer());
		
		// write�� �����͸� �б� ���ؼ��� seek()�޼��带 �̿��Ͽ� File Pointer�� ��ġ�� ������ �̵��ؾ���.
		rf.seek(4);
//		int i = rf.readInt();
		double d = rf.readDouble();
		System.out.println(d);
		
		rf.close();
	}

}
