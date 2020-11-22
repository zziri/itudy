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
		
		// Member클래스에서 equals에 대한 재정의를 memberId로 했기 때문에 중복된 id를 가진 park2는 삽입되지 않음.
		memberManager.addMember(park2); 
		memberManager.showAllMember();

	}

}
