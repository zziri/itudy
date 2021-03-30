package treeMapClass;

public class MemberTreeMapTest {

	public static void main(String[] args) {
		MemberTreeMap memberManager = new MemberTreeMap();
		
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
