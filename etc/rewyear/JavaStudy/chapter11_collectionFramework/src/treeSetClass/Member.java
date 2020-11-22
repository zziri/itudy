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
		return memeberName + "ȸ������ ID�� " + memberId + "�Դϴ�.";
	}
	
	// Set �������̽����� �ߺ� �˻縦 �ϱ� ���� equals(),hashCode() �޼��� ������
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
	
	// TreeSet���� �̿��ϱ� ���� Comparable<T> �������̽� ��ӹ޾� compareTo() method ������
	// ��� ��ȯ: �������� ����, ���� ��ȯ: �������� 
	@Override
	public int compareTo(Member o) {
		return this.memberId - o.memberId;
	}
	
	
}
