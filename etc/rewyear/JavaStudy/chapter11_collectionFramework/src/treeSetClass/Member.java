package treeSetClass;

public class Member implements Comparable<Member>{
	private int memberId;
	private String memeberName;
	
	public Member() {}
	public Member(int memberId, String memeberName) {
		super();
		this.memberId = memberId;
		this.memeberName = memeberName;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemeberName() {
		return memeberName;
	}
	public void setMemeberName(String memeberName) {
		this.memeberName = memeberName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return memeberName + "회원님의 ID는 " + memberId + "입니다.";
	}
	
	// Set 인터페이스에서 중복 검사를 하기 위해 equals(),hashCode() 메서드 재정의
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return memberId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member)
		{
			Member tmp = (Member)obj;
			return this.memberId == tmp.memberId;
		}
		return false;
	}
	
	// TreeSet에서 이용하기 위해 Comparable<T> 인터페이스 상속받아 compareTo() method 재정의
	// 양수 반환: 오름차순 정렬, 음수 반환: 내림차순 
	@Override
	public int compareTo(Member o) {
		return this.memberId - o.memberId;
	}
	
	
}
