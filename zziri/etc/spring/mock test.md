# mock test

mockito를 이용한 mock test

## setting

Mockito에서 제공하는 mock 객체를 사용하기 위해 Test 클래스에 어노테이션을 달아야합니다
```java
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
```

mock 객체를 생성합니다
```java
@Mock
private PersonRepository personRepository;
```

`@Mock` 어노테이션이 붙은 목객체를 주입합니다
```java
@InjectMocks
private PersonService personService;
```

테스트하고자 하는 클래스가 다른 클래스 객체를 멤버로 포함하고 있을 경우 `@InjectMocks` 어노테이션으로 주입하여 사용할 수 있습니다

## 리턴 값이 있는 경우

리턴 값이 있는 메소드의 경우 when, thenReturn 메소드를 이용해서 mocking이 가능합니다

```java
// personRepository.findById(1L)를 실행하면 new Person("martin")를 리턴합니다
when(personRepository.findById(1L))
        .thenReturn(Optional.of(new Person("martin")));
```

## 리턴값이 없는 메소드의 경우

리턴 값이 없는 메소드의 경우 verify와 save 메소드를 이용해 mocking이 가능합니다

```java
@Test
void delete() {
    when(personRepository.findById(1L))
            .thenReturn(Optional.of(new Person("martin")));
    personService.delete(1L);
    // 위 코드를 실행하면 personRepository.save 함수가 1회 실행되었는지 확인
    // IsPersonWillBeDeleted.matches 메소드의 리턴이 true인지(person.deleted가 true로 잘 세팅 되었는지) 확인
    verify(personRepository, times(1)).save(argThat(new IsPersonWillBeDeleted()));
}
```

이때 personRepository의 save 메소드가 단순히 실행된 것만 확인하는 것이 아니라 그 핵심 로직도 확인하기 위해서 `argThat`을 이용해 확인합니다
그리고 그 인자는 `ArgumentMatcher` 인터페이스를 구현한 클래스 객체로 합니다

```java
private static class IsPersonWillBeDeleted implements ArgumentMatcher<Person> {
    @Override
    public boolean matches(Person person) {
        return person.isDeleted();
    }
}
```
