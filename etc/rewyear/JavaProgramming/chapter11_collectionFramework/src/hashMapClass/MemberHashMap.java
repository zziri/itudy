package hashMapClass;

import java.util.HashMap;
import java.util.Iterator;

public class MemberHashMap {
	private HashMap<Integer, Member> hashMap;
	
	public MemberHashMap()
	{
		hashMap = new HashMap<Integer, Member>();
	}
	
	public void addMember(Member member)
	{
		hashMap.put(member.getMemberId(), member);
	}
	
	public boolean removeMember(int memberId)
	{
		if(hashMap.containsKey(memberId)) {
			hashMap.remove(memberId);
			return false;
		}
		System.out.println("ȸ�� ��ȣ�� �����ϴ�.");
		return false;
	}
	
	public void showAllMember() {
		// HashMap�� keySet() �޼���� ��� key��ü�� Set���·� ��ȯ
		Iterator ir = hashMap.keySet().iterator();
		
		while(ir.hasNext())
		{
			int key = (int)ir.next();
			Member member = hashMap.get(key);
			System.out.println(member);
		}
	}
	
	
}
