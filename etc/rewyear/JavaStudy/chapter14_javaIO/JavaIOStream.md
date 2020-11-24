# 자바 입출력

## 입출력 스트림
자료의 흐름이 물과 같다는 의미에서 유래된 용어로서, 다양한 입출력 장치에 동립적으로 일관성있는 입출력 방식을 제공(키보드, 파일 디스크, 메모리 등)

### 입출력 스트림 구분
* I/O 대상 기준: 입력 스트림, 출력 스트림
* 자료의 종류: 바이트 스트림, 문자 스트림
* 스트림의 기능: 기반 스트림, 보조 스트림

#### 입력 스트림과 출력 스트림
**입력 스트림: ** 대상으로부터 자료를 읽어 들이는 스트림
**출력 스트림: ** 대상으로 자료를 출력하는 스트림

**예시**
|종류|예시|
|---|---|
|입력 스트림|FileInputStream, FileReader,InputStreamReader, BufferedInputStream, BufferedReader 등|
|출력 스트림|FileOutputStream, FileWriter, OutputStreamWriter, BufferOutputStream, BufferedWriter 등|
-> Stream은 바이트 단위(동영상, 오디오 파일), Reader/Writer는 문자 단위(2바이트씩 처리해야함)

#### 기반 스트림과 보조 스트림
**기반 스트림: **대상에 직접 자료를 읽고 쓰는 기능을 가진 스트림
**보조 스트림: **직접 읽고 쓰는 기능은 없으나 추가적인 기능을 제공해주는 스트림으로서 기반 스트림이나 또 다른 보조 스트림을 생성자의 매개변수로 포함함
**보조스트림의 종류: **InputStreamReader, OutputStreamWriter, BufferedInputStream, BufferedOutputStream 등



## 표준입출력
표준 입출력으로 사용하는 System 클래스
```
public class System{
	public static PrintStream out; // 표준 출력 스트림
	public static InputStream in; // 표준 입력 스트림
	public static PrintStream err; // 표준 에러 스트림
}
```



## Scanner 클래스
java.util 패키지에 있는 입력 클래스로서 문자뿐만 아니라 정수, 실수 등 다양한 자료형을 읽어 들일수 있는 클래스로서 생성자가 다양하게 정의되어 있어 여러 소스로 부터 자료를 읽어 들일수 있음
|생성자|설명|
|---|---|
|Scanner(File source)|파일을 매개변수로 받아 파일의 데이터를 읽어들임|
|Scanner(InputStream source)|바이트스트림을 매개변수로 받아 파일의 데이터를 읽어들임|
|Scanner(String source)|String을 매개변수로 받아 파일의 데이터를 읽어들임|



## 바이트 단위 스트림
**InputStream과 OutputStream: **파일에 한 바이트씩 자료를 읽고 쓰는데 사용하는 스트림으로서 입력 스트림의 경우 파일이 없는 경우 예외가 발생하며, 출력 스트림의 경우 파일이 없는 경우 파일 생성하여 출력.
-> 대표적인 바이트 단위 스트림 클래스: **FileInputStream과 FileOutputStream**




## 문자 단위 스트림
**Reader과 Writer: **파일에 문자를 읽고 쓸때 가장 많이 사용하는 클래스로서, 문자의 인코딩 방식을 지정할 수 있음.
**-> 대표적인 문자 단위 스트림 클래스:  FileReader과 FileWriter**




## 보조 스트림
**FilterStreamReader와 FilterStreamWriter: **실제 읽고 쓰는 스트림이 아닌 보조적인 기능을 추가해주는 스트림으로서 데코레이터 패턴이라고도 함.   
생성자의 매개변수로 InputStream과 OutputStream을 받아 해당 스트림에 보조 기능을 추가해 줌.   
**-> 대표적인 보조 스트림 클래스: InputStreamReader와 OutputStreamWriter**   
(바이트 단위 스트림도 보조 스트림을 통해 바이트 단위를 문자 단위로 읽고 쓸수 있음)   

* **Bufferd 스트림:** 내부에 8192바이트 배열을 가지고 있으며, 읽거나 쓸 때 속도가 빠름
* **DataInputStream/DataOutputStream:** 자료가 저장된 상태 그대로 자료형을 유지하며 읽거나 쓰는 기능을 제공하는 스트림