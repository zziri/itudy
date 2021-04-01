package temp;

interface MyInterFace {
    static void func() {
        System.out.println("MyInterface");
    }
}

public class Test {
    public static void main(String[] args) {
        MyInterFace.func();
    }
}