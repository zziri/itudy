package hash;


public class HashingTest {
	public static void main(String[] args) {
		ChainingHashTable htChaining = new ChainingHashTable();
	
		htChaining.hashAdd("kim", "programmer");
		htChaining.hashAdd("lee", "engineer");
		htChaining.hashAdd("son", "footballplayer");
		htChaining.hashAdd("yoo", "singer");
		htChaining.hashAdd("park", "chef");
		htChaining.displayHashTable();
		
		ProbingHashTable htProbing = new ProbingHashTable();
		
		htProbing.hashAdd("kim", "programmer");
		htProbing.hashAdd("lee", "engineer");
		htProbing.hashAdd("son", "footballplayer");
		htProbing.hashAdd("yoo", "singer");
		htProbing.hashAdd("park", "chef");
					
		htProbing.displayHashTable();
	}
}
