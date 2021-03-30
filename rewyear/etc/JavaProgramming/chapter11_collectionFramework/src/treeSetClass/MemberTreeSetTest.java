package treeSetClass;

public class MemberTreeSetTest {

	public static void main(String[] args) {
		MemberTreeSet memberManager = new MemberTreeSet();
		
		Member lee = new Member(100,"lee");
		Member kim = new Member(101,"kim");
		Member seo = new Member(102,"seo");
		Member park = new Member(103,"park");
		
		memberManager.addMember(lee);
		memberManager.addMember(kim);
		memberManager.addMember(seo);
		memberManager.addMember(park);
		
		memberManager.showAllMember();

	}

}
