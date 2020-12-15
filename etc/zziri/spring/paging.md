
# paging

데이터베이스의 테이블에 저장된 모든 정보를 리스트 형태로 불러올 때, 모든 데이터를 가져오지 않고 페이징해서(잘라서) 가져오는 방법입니다

## add getAll method

테이블에 저장된 모든 정보를 리스트 형태로 불러오는 getAll method를 추가합니다

Controller에 getAll을 추가합니다

```java
public class PersonController {
    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }
}
```

Service에 getAll을 추가합니다

```java
public class PersonService {
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
```

## paging

getAll 메소드에서 페이징해서 가져오도록 리팩토링합니다

@PageableDefault 어노테이션을 달아 Pageable type을 파라미터로 받습니다

반환은 Page 타입으로 반환합니다

```java
public class PersonController {
    @GetMapping
    public Page<Person> getAll(@PageableDefault Pageable pageable) {
        return personService.getAll(pageable);
    }
}
```

## 사용해보기

`Postman`과 같은 http client로 `localhost:8080/api/person?page=0&size=2`으로 GET 요청을 해봅니다

아래와 같은 형태로 response를 합니다

```javascript
{
    "content": [
        {
            "id": 1,
            "name": "martin",
            "hobby": "programming",
            "address": "pangyo",
            "birthday": "2020-12-30",
            "job": "programmer",
            "phoneNumber": "010-1111-2222",
            "deleted": false,
            "birthdayToday": false,
            "age": 1
        },
        {
            "id": 2,
            "name": "jihoon",
            "hobby": "programming",
            "address": "gwanggyo",
            "birthday": "1994-11-13",
            "job": "programmer",
            "phoneNumber": "010-1133-4444",
            "deleted": false,
            "birthdayToday": false,
            "age": 27
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 2,
        "unpaged": false,
        "paged": true
    },
    "totalPages": 1,
    "totalElements": 2,
    "last": true,
    "size": 2,
    "number": 0,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "numberOfElements": 2,
    "first": true,
    "empty": false
}
```