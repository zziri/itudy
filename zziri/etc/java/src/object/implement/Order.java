package object.implement;

public class Order {
    private String id;
    private String date;
    private String time;
    private int price;
    private int menu;
    private String phoneNumber;
    private String address;

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  "주문 번호=" + id +
                "\n주문 날짜=" + date +
                "\n주문 시간=" + time +
                "\n주문 가격=" + price +
                "\n메뉴 번호=" + menu +
                "\n주문 핸드폰 번호=" + phoneNumber +
                "\n주문 주소=" + address;
    }
}
