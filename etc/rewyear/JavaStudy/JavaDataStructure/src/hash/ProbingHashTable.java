package hash;

public class ProbingHashTable {
	public static final int HASH_SIZE=13; // �ؽ� ���̺��� ũ��, �Ҽ�(prime number)
	
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
		
		// ���� ����� ���� �� ��� ��Ŷ�� Ž���ϴµ� �ٽ� ������ �ε����� ���ƿ��� ���
		// �ؽ����̺��� ����á�ٰ� ���� ����(���� overflow ���ܸ� �߻���Ű�ų�, resizing�� �ؾ���)
		int initIdx = hashIdx; 		
		
		// ���� �����: �浹�� �߻��ϰ� �Ǹ� ���� �� ��ŭ �ε����� �������� �������� ����ִ� ������ ã��
		// ���� �����: ���� ������� �����ϳ� �������� ������ŭ �������ѳ����� ���(i*i)
		while(hashTable[hashIdx] != null) {
			if(hashTable[hashIdx].getKey() == key) {
				System.out.println("key�� �ߺ��Ǿ����ϴ�.");
				return;
			}
			
			hashIdx = (hashIdx + 1) % HASH_SIZE;
			
			if(hashIdx == initIdx)
			{
				System.out.println("�ؽ� �����÷ο� �߻�");
				return;
			}
		}
		
		hashTable[hashIdx] = new Element(key,value); // ���ο� ��ġ�� ����		
	}
	
	public String hashSearch(String key)
	{
		int hashIdx = hashFunc(key);
		int initIdx = hashIdx; 
		
		while(hashTable[hashIdx] != null)
		{
			if(hashTable[hashIdx].getKey() == key) {
				System.out.println("Ž�� ����");
				return hashTable[hashIdx].getValue();
			}
				
			hashIdx = (hashIdx + 1) % HASH_SIZE;
			
			if(hashIdx == initIdx)
				break;
		}
		
		System.out.println("ã�� key ���� �����ϴ�");
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
