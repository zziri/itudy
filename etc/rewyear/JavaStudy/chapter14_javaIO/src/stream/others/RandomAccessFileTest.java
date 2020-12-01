package stream.others;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile rf = new RandomAccessFile("random.txt","rw");
		rf.writeInt(100);
		System.out.println(rf.getFilePointer()); // 위에서 int형(4byte)를 하나 write했기때문에 위치 4가 출력
		
		rf.writeDouble(3.14);
		rf.writeUTF("안녕하세요");
		System.out.println(rf.getFilePointer());
		
		// write한 데이터를 읽기 위해서는 seek()메서드를 이용하여 File Pointer의 위치를 적절히 이동해야함.
		rf.seek(4);
//		int i = rf.readInt();
		double d = rf.readDouble();
		System.out.println(d);
		
		rf.close();
	}

}
