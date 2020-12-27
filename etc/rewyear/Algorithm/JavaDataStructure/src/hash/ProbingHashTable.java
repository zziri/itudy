package hash;

public class ProbingHashTable {
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
	
	public Element[] hashTable;
	
	public ProbingHashTable()
	{
		hashTable = new Element[HASH_SIZE];
	}

	public int hashFunc(String key)
	{
		int hashIndex = 0;
		
		for(char c : key.toCharArray())
			hashIndex += c;

		hashIndex %= HASH_SIZE;
		
		return hashIndex;
	}
	
	public void hashAdd(String key, String value)
	{
		int hashIdx = hashFunc(key);
		
		// 선형 조사법 진행 중 모든 버킷을 탐색하는데 다시 원래의 인덱스로 돌아오는 경우
		// 해시테이블이 가득찼다고 볼수 있음(따라서 overflow 예외를 발생시키거나, resizing을 해야함)
		int initIdx = hashIdx; 		
		
		// 선형 조사법: 충돌이 발생하게 되면 일정 값 만큼 인덱스를 증가시켜 증가시켜 비어있는 버켓을 찾음
		// 이차 조사법: 선형 조사법과 유사하나 증가량을 제곱만큼 증가시켜나가는 방법(i*i)
		while(hashTable[hashIdx] != null) {
			if(hashTable[hashIdx].getKey() == key) {
				System.out.println("key가 중복되었습니다.");
				return;
			}
			
			hashIdx = (hashIdx + 1) % HASH_SIZE;
			
			if(hashIdx == initIdx)
			{
				System.out.println("해시 오버플로우 발생");
				return;
			}
		}
		
		hashTable[hashIdx] = new Element(key,value); // 새로운 위치에 삽입		
	}
	
	public String hashSearch(String key)
	{
		int hashIdx = hashFunc(key);
		int initIdx = hashIdx; 
		
		while(hashTable[hashIdx] != null)
		{
			if(hashTable[hashIdx].getKey() == key) {
				System.out.println("탐색 성공");
				return hashTable[hashIdx].getValue();
			}
				
			hashIdx = (hashIdx + 1) % HASH_SIZE;
			
			if(hashIdx == initIdx)
				break;
		}
		
		System.out.println("찾는 key 값이 없습니다");
		return null;
	}
	
	public void displayHashTable()
	{
		for(int i=0; i<HASH_SIZE; i++)
		{
			System.out.printf("[%d] ",i);
			if(hashTable[i] == null)
				System.out.println("null");
			else
				System.out.printf("[%s, %s]\n",hashTable[i].getKey() 
						,hashTable[i].getValue());
		}
	}
}
