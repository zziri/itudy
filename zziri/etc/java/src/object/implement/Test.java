package object.implement;

public class Test {
    public static void main(String[] args) {
        Person person = new Person(180, 78, "Tomas", 37);
        Order order = new Order();
        order.setId("202011020003");
        order.setPhoneNumber("01023450001");
        order.setAddress("서울시 강남구 역삼동 111-333");
        order.setDate("20201102");
        order.setTime("130258");
        order.setPrice(35000);
        order.setMenu(3);

        System.out.println(person);
        System.out.println(order);
    }
}
