package class_interfaceEx;

public class BookShelf extends Shelf implements Queue{

	@Override
	public void enQueue(String title) {
		shelf.add(title);		
	}

	@Override
	public String deQueue() {
		if(shelf.isEmpty()) {
			System.out.println("Shelf is Empty");
			return null;
		}
		
		return shelf.remove(0);			
	}

	@Override
	public int getSize() {
		return getCount();
	}

}
