package hash;

import java.util.LinkedList;

//LinkedList�� �̿��� Separate Chaining
public class ChainingHashTable {
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
	
	public LinkedList<Element>[] hashTable;
	
	public ChainingHashTable()
	{
		hashTable = new LinkedList[HASH_SIZE];
	}

	// �ؽ� �Լ�, key���� �Է¹޾� ������ �ε���(�ؽ��ּ�)�� �����ϴ� �Լ�
	public int hashFunc(String key)
	{
		int hashIndex = 0;
		
		// key ���� �� �ڸ��� ���� �ƽ�Ű�ڵ带 ���ؼ� �ؽ� �ε��� ����
		for(char c : key.toCharArray())
			hashIndex += c;
		
		// �ؽ� ũ�⸸ŭ mod����
		hashIndex %= HASH_SIZE;
		
		return hashIndex;
	}
	
	public void hashAdd(String key, String value)
	{
		int hashIdx = hashFunc(key);
		
		// �� �����̸�, ���ο� LinkedList�����ؼ� �Ҵ� 	
		LinkedList<Element> bucket = hashTable[hashIdx];
		if(bucket == null)
		{
			bucket = new LinkedList<Element>();
			hashTable[hashIdx] = bucket;
		}
		
		// ������ ��� ����
		Element node = new Element(key,value);
		
		// ������ ��尡 �̹� �����ϴ��� �˻� �� �������� ������, ����Ʈ �� �������� ����
		if(hashTable[hashIdx].contains(node) == false) 
		{
			hashTable[hashIdx].addLast(node); 
		}
		else // �̹� �ش� ���� �����ϸ� value ���� ���� or �ߺ� �޽��� ȣ��
		{
			node.setValue(value);
		}
	}
	
	public String hashSearch(String key)
	{
		int hashIdx = hashFunc(key);
		
		if(hashTable[hashIdx] == null)
			return null;
		
		// �ش� �ؽ��ּ��� ������ ���� Ž��
		for(Element node : hashTable[hashIdx])
		{
			if(key == node.getKey()) {
				System.out.println("key found");
				return node.getValue();
			}
		}
		
		System.out.println("key�� ����Ǿ� ���� �ʽ��ϴ�.");
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
