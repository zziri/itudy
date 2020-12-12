
# stream

Java의 stream을 공부하고 정리합니다

## 데이터 모델

List 자료구조에 넣을 손님 데이터를 모델링합니다

```java
class Customer {
    private String name;
    private int age;
    private int price;
}
```

## 리스트 생성

리스트를 생성합니다

```java
List<TravelCustomer> customers = new ArrayList<>();
customers.add(lee);
customers.add(kim);
customers.add(hong);
```

## 골라서 출력하기

stream을 생성하고 map을 이용해 손님의 이름만 따로 가져오고 이름만 있는 리스트를 순회하면서 이름을 출력합니다

```java
customers.stream().map(c -> c.getName()).forEach(s -> System.out.println(s));
```

## 특정 데이터만 더하기

stream을 생성하고 mapToInt를 사용해 손님의 비용만 가져오고 그 비용을 전부 더합니다

```java
System.out.println(customers.stream().mapToInt(c -> c.getPrice()).sum());
```

## 조건에 따른 데이터만 골라 정렬하기

stream을 생성하고 20세 이상의 손님들만 고르며, 거기서 이름만 가져오고 정렬 후 출력합니다

```java
customers.stream().filter(c->c.getAge() >= 20).map(c->c.getName()).sorted().forEach(s-> System.out.println(s));
```

## reduce 활용하기

BinaryOperator<T> 인터페이스를 구현한 클래스를 생성합니다

```java
class Compare implements BinaryOperator<Integer> {
    @Override
    public Integer apply(Integer integer, Integer integer2) {
        if(integer > integer2) {
            return integer2;
        } else {
            return integer;
        }
    }
}
```

stream을 생성하고 손님의 나이만 가져온 후 reduce를 통해 나이가 가장 어린 손님을 뽑아 출력합니다

```java
// reduce의 파라미터 부분은 Compare 클래스를 따로 정의하지 않고 람다식으로도 사용이 가능합니다
System.out.println(customers.stream().map(c->new Integer(c.getAge())).reduce(new Compare()).get());
```

