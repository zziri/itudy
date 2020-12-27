package hashMapClass;

import hashSetClass.Member;

public class Member {
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
	public int hashCode() {
		// TODO Auto-generated method stub
		return memberId;
	}
	
	// 중복 검사를 하기 위해 equals() 메서드 재정의
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member)
		{
			Member tmp = (Member)obj;
			return this.memberId == tmp.memberId;
		}
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return memeberName + "회원님의 ID는 " + memberId + "입니다.";
	}
}
