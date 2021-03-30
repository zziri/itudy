package thread;

import java.util.ArrayList;

class Library{
	public ArrayList<String> books = new ArrayList<String>(); 
	
	public Library()
	{
		books.add("ÅÂ¹é»ê¸Æ1");
		books.add("ÅÂ¹é»ê¸Æ2");
		books.add("ÅÂ¹é»ê¸Æ3");
	}
	
	public synchronized String lendBook() throws InterruptedException {
		Thread t = Thread.currentThread();
		while(books.size() == 0) {
			System.out.println(t.getName() + "wait...");
			wait();
		}
			
		String title = books.remove(0);
		System.out.println(t.getName() + ":" + title + " lend");
		return title;
	}
	
	public synchronized void returnBook(String title) {
		Thread t = Thread.currentThread();
		books.add(title);
		notifyAll();
		System.out.println(t.getName() + ":" + title + " return");
	}
}

class Student extends Thread{
	
	
	public void run()
	{
		try {
			String title = LibraryMain.library.lendBook();	
			sleep(5000);
			LibraryMain.library.returnBook(title);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class LibraryMain {
	public static Library library = new Library();
	
	public static void main(String[] args) {
		Student std1 = new Student();
		Student std2 = new Student();
		Student std3 = new Student();
		Student std4 = new Student();
		Student std5 = new Student();
		Student std6 = new Student();
		
		std1.start();
		std2.start();
		std3.start();
		std4.start();
		std5.start();
		std6.start();

	}

}
