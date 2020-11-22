package hashSetClass;

public class MemberHashSetTest {

	public static void main(String[] args) {
		MemberHashSet memberManager = new MemberHashSet();
		
		Member lee = new Member(100,"lee");
		Member kim = new Member(101,"kim");
		Member seo = new Member(102,"seo");
		Member park = new Member(103,"park");
		Member park2 = new Member(103,"park2");
		
		
		memberManager.addMember(lee);
		memberManager.addMember(kim);
		memberManager.addMember(seo);
		memberManager.addMember(park);
		memberManager.removeMember(102);
		
		// MemberŬ�������� equals�� ���� �����Ǹ� memberId�� �߱� ������ �ߺ��� id�� ���� park2�� ���Ե��� ����.
		memberManager.addMember(park2); 
		memberManager.showAllMember();

	}

}
