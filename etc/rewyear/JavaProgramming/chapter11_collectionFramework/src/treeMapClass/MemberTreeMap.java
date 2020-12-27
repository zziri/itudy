package treeMapClass;

import java.util.Iterator;
import java.util.TreeMap;

public class MemberTreeMap {
	private TreeMap<Integer, Member> treeMap;
	
	public MemberTreeMap() {
		treeMap = new TreeMap<Integer, Member>();
	}
	
	public void addMember(Member member) {
		treeMap.put(member.getMemberId(), member);
	}
	
	public boolean removeMember(int memberId) 
	{
		if(treeMap.containsKey(memberId))
		{
			treeMap.remove(memberId);
			return true;
		}
		System.out.println("ȸ����ȣ�� �����ϴ�.");
		return false;
	}
	
	public void showAllMember() {
		for(int key : treeMap.keySet())
		{
			System.out.println(treeMap.get(key));
		}
	}
	


}
