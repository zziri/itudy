# Algorithm with Java
알고리즘 풀이 및 코딩테스트 언어로 **Java**를 선택하였습니다. 이에 대해서  속도가 빠른 C++이나 배우기 쉽고 라이브러리 사용이 편한 Python이라는 언어가 있지만 추후 개발언어로 Java를 사용할 것이기 때문에 알고리즘 Study 이전에 알고리즘 풀이를 위한  Java의 특성 및 라이브러리 등을 정리한 글입니다.



## Java 입출력
### 출력   
1. System.out.println(...) // Java의 가장 일반적인 출력으로, 출력 후 줄바꿈
2. System.out.print(...) // System.out.println()과 유사하나, 줄바꿈 없음
3. System.out.printf(...) // C언어의 printf와 유사하게 사용자가 포맷을 지정해서 출력

### 입력   
**1. Scanner**   

* next자료형() 메소드를 통해 입력을 받을수 있음
* hasNext자료형() 메소드를 통해 입력받을 수 있는 자료형이 있는지 확인할 수 있다.
* Scanner 사용 기본 예제
```java
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
		
	int num1,num2;
	num1 = scanner.nextInt();
	num2 = scanner.nextInt();
		
    System.out.println(num1 + num2);
    scanner.close();
}
```

* hasNext자료형()메소드를 이용한 정수가 아닐때 까지 입력받는 예제
```java
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
    int total=0;
    
    while(scanner.hasNextInt()) {
        total += scanner.nextInt();
    }
    
    System.out.println(total);
    scanner.close();
}
```
* Scanner 입력시 개행문자 처리

```java
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	int num;
	String str;
	num = scanner.nextInt();
		
	// 콘솔 입력시 엔터도 스트림에 입력되기 때문에 개행문자도 처리해야 함.
	scanner.nextLine(); 
		
	str = scanner.nextLine();
	    
	System.out.println(num + str);
	    scanner.close();
	}
```



**2. BufferedReader**   

* 문자열 입력에 장점이 있으며 read()와 readLine() 메소드를 통해서 문자열을 읽어들인다.

* Scanner에 비해서 속도가 빠르므로 입력이 많은 경우에는 BufferedReader를 사용하는게 좋다.

* **StringTokenizer**

   * 공백, 띄어쓰기, 컴마 등으로 구분된 문자열을 토큰화 시킬때 유용한 객체
   * BufferedReader의 split을 사용하여도 무방

* BufferedReader 및 StringTokenizer 사용예제
   ```java
   import java.io.BufferedReader;
   import java.io.IOException;
   import java.io.InputStreamReader;
   
   public class JavaIOTest {
   	public static void main(String[] args) throws IOException {
   		BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
   		String line = bufReader.readLine();
   
   		// split을 사용한 토큰화
   		String[] strList = line.split(" ");
   		for(String str : strList)
   			System.out.println(str);		
           
   		// StringTokenizer를 활용한 토큰화
   		StringTokenizer strTokenizer = new StringTokenizer(line, " ");
   		while(strTokenizer.hasMoreTokens())
   		{
   			System.out.println(strTokenizer.nextToken());
   		}		
   	}
   }
   ```



**3. StringBuilder** 
* for문으로 여러번 출력하는 것보다 StringBuilder를 이용하여 문자열을 만들고 출력하는 것이 속도 면에서 이점이 있다.
	```java
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner scanner = new Scanner(System.in);
		String[] strList = scanner.nextLine().split(" "); // 테스트할 문자열 생성
		StringBuilder strBuilder = new StringBuilder();
		long startTime,endTime;
		
		// 출력할때 마다 System.out.println 호출해서 출력
		startTime = System.currentTimeMillis();
		for(String str : strList)
			System.out.println(str);
		endTime = System.currentTimeMillis();
		System.out.printf("%d sec\n",(endTime - startTime)); // 같은 문자열에 대해서 16ms
		
		// 출력할 내용들을 StringBuilder를 이용해 하나의 문자열로 만들어 출력		
		startTime = System.currentTimeMillis();
		for(String str : strList)
			strBuilder.append(str + '\n');
		endTime = System.currentTimeMillis();
		System.out.println(strBuilder);
		System.out.printf("%dsec\n",endTime - startTime); // 같은 문자열에 대해서 3ms
		
	}
	```
  
   

