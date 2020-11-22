package treeSetClass;

import java.util.TreeSet;
import java.util.Iterator;

public class MemberTreeSet {
	private TreeSet<Member> treeSet;
	
	public MemberTreeSet() {
		treeSet = new TreeSet<Member>();
	}
	
	public void addMember(Member mem)
	{
		treeSet.add(mem);
	}
	
	public boolean removeMember(int memberId)
	{
		Iterator<Member> it = treeSet.iterator();
		while(it.hasNext())
		{
			Member tmp = it.next();
			if(tmp.getMemberId() == memberId) {
				return treeSet.remove(tmp);
			}
		}
		
		System.out.printf("해당ID[%d]를 가진 회원이 없습니다.",memberId);
		return false;
	}
	
	public void showAllMember() {
		for(Member member : treeSet)
		{
			System.out.println(member);
		}
		
	}
	
	
	
}
