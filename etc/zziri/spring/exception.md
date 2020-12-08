
# exception

서버에서 발생하는 예외상황을 정의하는 exception을 만듭니다

## 간단한 Exception Class

RenameIsNotPermittedException 이름 변경을 허용하지 않는데 변경했을 경우 발생시킬 exception을 다음과 같이 정의합니다
```java
@Slf4j
public class RenameIsNotPermittedException extends RuntimeException{
    private static final String MESSAGE = "이름 변경을 허용하지 않습니다";

    public RenameIsNotPermittedException() {
        super(MESSAGE);
        log.error(MESSAGE);
    }
}
```

Service에 적용시킵니다

```java
public class PersonService {
    @Transactional
    public void modify(Long id, PersonDto personDto) {
        // id에 해당하는 person 객체가 없을 경우 PersonNotFoundException 예외를 throw 합니다
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);

        if (!person.getName().equals(personDto.getName())) {
            // 이름이 일치하지 않으면 그에 맞는 exception을 throw 합니다
            throw new RenameIsNotPermittedException();
        }
    }
}
```

Test에 적용시킵니다
exception이 발생하는 상황을 catch하기 위해서는 assertThrows를 활용합니다
```java
class PersonServiceTest {
    @Test
    void modifyIfNameIsDifferent() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.of(new Person("tony")));
        // personService.modify(1L, mockPersonDto())을 수행하고 RenameIsNotPermittedException 예외가 발생해야 테스트가 정상통과됩니다
        assertThrows(RenameIsNotPermittedException.class, () -> personService.modify(1L, mockPersonDto()));
    }
}
```

## Exception Handling

Exception Class와 Response DTO를 이용해 예외를 처리합니다

예외가 발생하면 클라이언트에 response할 객체의 클래스를 정의합니다

```java
@Data
// 생성자의 access level을 private으로 합니다
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {
    private int code;
    private String message;

    public static ErrorResponse of(HttpStatus httpStatus, String message) {
        return new ErrorResponse(httpStatus.value(), message);
    }
}
```

특정예외를 @ExceptionHandler를 이용해 처리합니다

```java
public class PersonController {
    // RenameIsNotPermittedException 에 대한 ExceptionHandler입니다
    @ExceptionHandler(value = RenameIsNotPermittedException.class)
    public ResponseEntity<ErrorResponse> handleRenameNoPermittedException(RenameIsNotPermittedException ex) {
        // RenameIsNotPermittedException 예외가 발생하면 http status code 400(bad request)와 그 메세지를 ResponseEntity에 담아 반환합니다
        return new ResponseEntity<>(ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
```

정의된 예외를 제외한 나머지(RuntimeException)를 처리합니다

```java
public class PersonController {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        log.error("서버오류 : {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 오류가 발생하였습니다"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

