package stream.serializtion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable{
	String name;
	String job;
	
	public Person(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}

	@Override
	public String toString() {
		return name + "," + job;
	}
	
	
}

public class SerializationTest {

	public static void main(String[] args) {
		Person personLee = new Person("이순신","엔지니어");
		Person personKim = new Person("김유신","선생님");
		
		try(FileOutputStream fos = new FileOutputStream("serialization.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos))
		{
			oos.writeObject(personLee);
			oos.writeObject(personKim);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		try(FileInputStream fis = new FileInputStream("serialization.dat");
				ObjectInputStream ois = new ObjectInputStream(fis))
		{
			Person p1 = (Person)ois.readObject();
			Person p2 = (Person)ois.readObject();
			
			System.out.println(p1);
			System.out.println(p2);
		}
		catch(IOException e)
		{
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
