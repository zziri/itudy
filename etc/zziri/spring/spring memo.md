
# spring

spring framework를 공부하거나 실습하면서 메모합니다

## Service Test Mocking

@ExtendWith(MockitoExtension.class) 어노테이션을 Test 클래스에 달아줍니다

```java
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
    ...
}
```

dao(repository)에 해당하는 클래스의 Mock 객체를 생성합니다

```java
class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;
    ...
}
```

service 클래스 객체에 mock으로 생성된 dao 객체를 주입합니다

```java
class PersonServiceTest {
    @InjectMocks
    private PersonService personService;
    ...
}
```

return type이 있는 경우 when, thenReturn 메소드를 이용해서 동작을 Mocking 합니다

```java
// return value가 있는 경우
when(personRepository.findById(1L))
                .thenReturn(Optional.of(new Person("martin")));
// return value가 없는 경우(null인 경우)
when(personRepository.findById(1L))
                .thenReturn(Optional.empty());
```

return type이 없는 경우(void) verify 메소드를 이용해서 해당 메소드의 내용이 실행되었는지 확인하는 과정을 추가합니다

```java
// personService.put(personDto); 코드를 실행하고 verify를 통해 Person 클래스의 객체를 매개변수로 save메소드가 1회 호출되었는지 검사합니다
@Test
void put() {
    PersonDto personDto = PersonDto.of("martin", "programming", "pangyo", LocalDate.now(), "dev", "010-1111-111");
    personService.put(personDto);
    verify(personRepository, times(1)).save(any(Person.class));
}
```

