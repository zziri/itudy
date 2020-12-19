package hash;

import java.util.LinkedList;

//LinkedList를 이용한 Separate Chaining
public class ChainingHashTable {
	public static final int HASH_SIZE=13; // 해시 테이블의 크기, 소수(prime number)
	
	class Element {
		String key;
		String value;
			
		public Element(String key, String value) 
		{
			this.key = key;
			this.value = value;
		}
		
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}	
	}
	
	public LinkedList<Element>[] hashTable;
	
	public ChainingHashTable()
	{
		hashTable = new LinkedList[HASH_SIZE];
	}

	// 해시 함수, key값을 입력받아 고유의 인덱스(해시주소)를 생성하는 함수
	public int hashFunc(String key)
	{
		int hashIndex = 0;
		
		// key 값의 각 자리에 대한 아스키코드를 더해서 해시 인덱스 생성
		for(char c : key.toCharArray())
			hashIndex += c;
		
		// 해시 크기만큼 mod연산
		hashIndex %= HASH_SIZE;
		
		return hashIndex;
	}
	
	public void hashAdd(String key, String value)
	{
		int hashIdx = hashFunc(key);
		
		// 빈 버켓이면, 새로운 LinkedList생성해서 할당 	
		LinkedList<Element> bucket = hashTable[hashIdx];
		if(bucket == null)
		{
			bucket = new LinkedList<Element>();
			hashTable[hashIdx] = bucket;
		}
		
		// 삽입할 노드 생성
		Element node = new Element(key,value);
		
		// 삽입할 노드가 이미 존재하는지 검사 후 존재하지 않으면, 리스트 맨 마지막에 삽입
		if(hashTable[hashIdx].contains(node) == false) 
		{
			hashTable[hashIdx].addLast(node); 
		}
		else // 이미 해당 값이 존재하면 value 값을 변경 or 중복 메시지 호출
		{
			node.setValue(value);
		}
	}
	
	public String hashSearch(String key)
	{
		int hashIdx = hashFunc(key);
		
		if(hashTable[hashIdx] == null)
			return null;
		
		// 해당 해시주소의 노드들을 전부 탐색
		for(Element node : hashTable[hashIdx])
		{
			if(key == node.getKey()) {
				System.out.println("key found");
				return node.getValue();
			}
		}
		
		System.out.println("key가 저장되어 있지 않습니다.");
		return null;
	}
	
	public void displayHashTable()
	{
		for(int i=0; i<HASH_SIZE; i++)
		{
			System.out.printf("[%d] ",i);
			if(hashTable[i] == null) {
				System.out.println("null");
				continue;
			}
			
			for(Element node : hashTable[i])
			{	
				System.out.printf("[%s, %s] -> ",node.getKey() 
						,node.getValue());
			}
			System.out.println("null");
		}
	}
}
