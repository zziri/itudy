package hashSetClass;

import java.util.HashSet;
import java.util.Iterator;

public class MemberHashSet {
	private HashSet<Member> hashSet;
	
	public MemberHashSet() {
		hashSet = new HashSet<Member>();
	}
	
	public void addMember(Member mem)
	{
		hashSet.add(mem);
	}
	
	public boolean removeMember(int memberId)
	{
		Iterator<Member> it = hashSet.iterator();
		while(it.hasNext())
		{
			Member tmp = it.next();
			if(tmp.getMemberId() == memberId) {
				return hashSet.remove(tmp);
			}
		}
		
		System.out.printf("해당ID[%d]를 가진 회원이 없습니다.",memberId);
		return false;
	}
	
	public void showAllMember() {
		for(Member member : hashSet)
		{
			System.out.println(member);
		}
		
	}
	
}
