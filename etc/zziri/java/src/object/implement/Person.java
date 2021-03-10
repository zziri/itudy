package object.implement;

public class Person {
    private int height;
    private int weight;
    private String name;
    private int age;

    public Person(int height, int weight, String name, int age) {
        this.height = height;
        this.weight = weight;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("키=%d\n몸무게=%d\n이름=%s\n나이=%d", height, weight, name, age);
    }
}
