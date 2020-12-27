package stream;

import java.util.ArrayList;
import java.util.List;

public class CustomerStreamTest {

	public static void main(String[] args) {
		Customer customerLee = new Customer("ÀÌ¼ø½Å",40,100);
		Customer customerKim = new Customer("±èÀ¯½Å",20,100);
		Customer customerHong = new Customer("È«±æµ¿",13,50);
		
		List<Customer> cusList = new ArrayList<Customer>();
		
		cusList.add(customerLee);
		cusList.add(customerKim);
		cusList.add(customerHong);
		
		System.out.println(cusList);
		
		cusList.stream().map(c->c.getName()).forEach(s->System.out.println(s));
		int total = cusList.stream().mapToInt(c->c.getCost()).sum();
		System.out.println(total);
		
		cusList.stream().filter(c->c.getAge()>=20).map(c->c.getName()).sorted().forEach(s->System.out.println(s));

	}

}
