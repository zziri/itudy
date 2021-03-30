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





## Java Collection FrameWork
알고리즘 풀이에 자주 사용되는 자바의 Collection 프레임워크에 대해서 알아보자
자주 사용되는 자료구조나 알고리즘은 이미 Java에 구현이 되어 있으므로 해당 라이브러리를 호출해서 사용하면 된다.

**1. ArrayList**   

* 길이가 변하는 가변배열로서 C++의 vector와 유사하다.

* 주요 메서드
	```java
	* add(E element) // ArrayList 맨 뒤에 새로운 element 추가
	* clear() // ArrayList를 완전히 비워버리는 메서드
	* contains(Object o) // o가 ArrayList의 요소로 있는지 판단.
	* get(int index) // index번째 요소를 반환
	* remove(int index) // index번째 요소를 삭제
	* set(int index, E element) // index번째 요소를 element로 변경
	* toArray() // ArrayList를 Array형태로 변환해서 반환
	```
	
* 사용예시
	
	ex1) 단순 배열로 사용
	
	```java
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
  	int n = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
	  	for (int i=0; i<n; i++) {
			int temp = sc.nextInt();
			a.add(temp);
		}
		
		Collections.sort(a);
		for(int x : a) {
			System.out.println(x);  
		}  
	}
	
	```
	
	
	
	ex2) 인접리스트 구현
	
	```java
	class GraphByList {
		private ArrayList<Integer>[] adjList; // ArrayList배열
		private int degree; 
		
		public GraphByList(int initSize)
		{	
	        // 인접리스트 생성
	        adjList = new ArrayList[initSize+1];
	        degree = initSize;
	
	        // 각 정점에 대한 인접리스트 초기화 
	        for(int i=1; i<=degree; i++) 
	        {
	            adjList[i] = new ArrayList<Integer>();
	        }
      }
	
	    // add() 메서드를 통해 간선 추가
	    public void insertEdge(int start, int end)
	    {
	        adjList[start].add(end);
	        adjList[end].add(start);
	    }
	
	    ...
	```

**2. Stack**   
	LIFO형태의 자료구조로서 마지막에 입력된 요소가 제일먼저 반환되는 구조   

* 주요 메서드	

        E push(E element) // 스택에 새로운 element 추가
        E pop() // 스택 가장 위에 있는 자료를 반환하면서 삭제
        E peek() // 스택 가장 위에 있는 자료를 반환
        bool empty() // 스택이 비어있는지 유무를 반환
        int size() // 스택에 저장되어 있는 요소의 수
    

**3. Queue**   
	Java에서 Queue는 인터페이스로 구현되어 있으며, 이를 구현한 클래스는 **ArrayDeque, LinkedList, PriorityQueue**이 있다.   

* 주요 메서드   
    ```
    E offer(E element) // 큐에 element 삽입   
    E poll() // dequeue 연산을 수행하며 해당 요소를 반환   
    E peek() // 가장 앞에 있는 요소를 반환   
    bool isEmpty() // 스택이 비어있는지 유무를 반환   
    int size() // 스택에 저장되어 있는 요소의 수   
    ```

* 사용예시   
	ex) BFS에 사용되는 queue()
	
	```
	public static void BFS(int node) // 시작노드 
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		int num;
		
		checked[node] = true; // 시작 노드 방문
		queue.add(node); // 시작 노드 enqueue
		
		while(!queue.isEmpty())
		{
			num = queue.poll();
			System.out.printf("%d ", num); // 출력
			
			for(int i=0; i<graph.getNode(num).size(); i++)
			{
				int next = graph.getNode(num).get(i);
				if(checked[next] == false) // 방문하지 않았다면
				{
					checked[next] = true; // 해당 노드 방문 체크
					queue.add(next); // 큐에 enqueue
				}
					
			}
		}
	}
	```
	
* PriorityQueue

    우선순위를 가진 항목들을 저장하는 큐로서 우선순위가 높은 데이터가 먼저 출력되는 형태

    해당 객체의 요소들은 정렬되야 하므로 **Comparator**인터페이스를 구현해 줘야 함
    
  ex) PrirorityQueue를 이용한 최대 힙 문제
  
    ```
    public class Main {
  		// Comparator 상속받아 compare()메소드 정의
    		static class Compare implements Comparator<Integer> 
    		{
    			public int compare(Integer one, Integer two) 
    			{
      				return two.compareTo(one); 
    			}
      		}
	  
      		public static void main(String args[]) 
    		{
    			Scanner sc = new Scanner(System.in);
    			Compare cmp = new Compare();
    			
    			// compare
    			PriorityQueue<Integer> q = new PriorityQueue<Integer>(1, cmp);
    			int n = sc.nextInt();
    			
				// n개 요소 입력
				while (n-- > 0) {
                    int x = sc.nextInt();
                    if(x == 0) 
                    {
                        if(q.isEmpty())
                            System.out.println(0); 
                        else
                            System.out.println(q.poll());
                    } 
                    else 
                        q.offer(x); 
    		}
    }
    ```
  
  

4. **Set 인터페이스**   

   중복을 허용하지 않는 자료구조

   **주요 메서드**
	```
    void clear() // Set 초기화
    boolean add(E e) // element 삽입
    boolean contains(Object o) // 해당 요소를 가지고 있는지 판단
    boolean isEmpty() // Set이 비어있는지 확인
    boolean remove(Object o) // 해당 요소를 삭제
    int size() // Set에 저장되어 있는 요소의 수
   ```

   **HashSet**   

   * HashTable을 이용해서 구현되어있음
   * 중복을 허용하지 않으며 순서가 보장되지 않는 자료구조

   **TreeSet**

   * binary search tree로 구현되어 있으며, 요소를 오름차순이나 내림차순으로 정렬
   * 정렬을 위해서 비교메서드인 "Comparable or Comparator"를 구현해 주어야 함

   ㅡ> 일반적인 경우 HashSet을 사용하며 정렬이 필요한 경우 TreeSet을 사용한다.    

   

   

   

5. **Map 인터페이스**

   key,value 쌍을 이루는 pair형태의 요소를 가지는 자료구조로서 key의 중복을 허용하지 않음

   **주요 메서드**

   ```
   void clear() // Map을 초기화
   boolean containsKey(Object key) // 해당 Key를 가지는 요소가 있는지 확인
   boolean containsValue(Object value) // 해당 Value를 가지고 있는 요소가 있는지 확인
   V get(Object key) Key에 해당하는 Value 반환
   boolean isEmpty() // Map이 비어있는지 확인
   V put(K key, V value) // (Key, Value) 쌍을 Map에 삽입
   boolean remove(Object o) // 해당 key를 가지고 있는 요소 삭제
   Set<Map.Entry<K,V>> entrySet()  Key, Value 쌍을 이용한 Set을 생성
   Set< K> key keySet() // 요소를 Key로 갖는 Set을 생성
   int size() // 해당 객체의 요소의 수 반환 	
   ```

   

   **HashMap**   

   * HashTable을 이용해서 구현되어있음
   * 중복을 허용하지 않으며 순서가 보장되지 않는 자료구조

   **TreeMap**

   * binary search tree로 구현되어 있으며, 요소를 오름차순이나 내림차순으로 정렬
   * 정렬을 위해서 비교메서드인 "Comparable or Comparator"를 구현해 주어야 함



## 정렬
배열의 정렬에는 **Array.sort()** 메서드를 사용하고 Collection에 대한 정렬은 **Collections.sort()**를 이용한다.

* ArrayList 정렬 예제

```
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		for (int i=0; i<n; i++) {
			int temp = sc.nextInt();
			a.add(temp);
		}

		Collections.sort(a); // Sort ASC
		for (int x : a) {
			System.out.println(x); 
		}
	}
```



* array 정렬 예제
```
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) {
			int temp = sc.nextInt();
			arr.add(temp);
		}

		Arrays.sort(arr); // Sort ASC
		for (int x : arr) {
			System.out.println(x); 
		}
	}
```



**기본자료형이 아닌 자료에 대한 정렬**   

 * 기본 자료형이 아닌 클래스에 대한 정렬이 필요할 경우 사용자가 직접 비교대상에 대한 비교 메서드를 정의해주어야 한다. 

 * 정렬을 위해서 Comparable or Comparator 인터페이스 구현해줘야함.   
     * **Comparable인터페이스 구현시:**  compareTo() 메서드 재정의 해줘야 함

        -> compareTo()양수 반환: 오름차순, 음수 반환: 내림차순 

       * **comparable 예시**

       ```java
       public class Member implements Comparable<Member>{
       	private int memberId;
       	private string memberName;
       	
       	@Override
       	public int compareTo(Member o) {
       		return this.memberId - o.memberId;
       	}
       
       ...
       
       Member[] arr = new Member[20];
       
       // Member클래스 내부에 Member클래스에 대한 compareTo() 메서드가 재정의 되어 있기 때문에 배열만 인자로 넘겨주면 됨
       Arrays.sort(arr);
       ```

       

     * **Comparator인터페이스 구현시:**  compare() 메서드 재정의 해줘야 함 

       -> compareTo()와 유사하나 매개변수가 2개 들어옴. 양수 반환: 오름차순, 음수 반환: 내림차순 

       * **comparator 예시**

       ```java
       // Lambda를 활용하여 comparator 구현하여 sort()메서드의 두번째 인자로 compare 메서드를 정의해서 넘겨줌
       Arrays.sort(arr, new Comparator<Member>() {
       	public int compare(Member p1, Member p2) {
       		return p2.id - p1.id; 
       	}
       });
       ```

       

