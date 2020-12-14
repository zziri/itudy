
# parameter validator

파라미터의 유효성을 검사합니다

## Annotation

@Valid 어노테이션을 달아 해당 객체를 recursive하게 검증할 수 있도록 합니다

```java
public void postPerson(@RequestBody @Valid PersonDto personDto) {
        personService.put(personDto);
    }
```

@NotBlank 어노테이션을 달아 해당 객체가 null이거나 비어있으면("" 혹은 " ") Exception을 발생시키도록 합니다

이때, 조건이 만족되면 MethodArgumentNotValidException이 발생하게 됩니다

```java
public class PersonDto {
    @NotBlank(message = "이름은 필수값입니다")
    private String name;
}
```

MethodArgumentNotValidException에 대한 Exception Handler를 정의합니다

```java
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        // DTO에 설정한 message("이름은 필수값입니다")를 읽어오게 하도록 ex.getBindingResult().getFieldError().getDefaultMessage()를 인자로 넘겨줍니다
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getBindingResult().getFieldError().getDefaultMessage());
    }
}
```

DTO에 설정한 message를 읽어와 response할 수 있도록 매개변수가 다른 ErrorResponse.of 메소드를 정의합니다

```java
public class ErrorResponse {
    public static ErrorResponse of(HttpStatus httpStatus, FieldError fieldError) {
        if(fieldError == null) {
            return new ErrorResponse(httpStatus.value(), "invaled params");
        } else {
            return new ErrorResponse(httpStatus.value(), fieldError.getDefaultMessage());
        }
    }
}
```

