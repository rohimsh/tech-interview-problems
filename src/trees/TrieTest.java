package trees;

public class TrieTest {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abc");
		trie.insert("xy");
		trie.insert("xyz");
		trie.insert("wxyz");
		trie.insert("xyzt");
		System.out.println(trie.search("x"));
		System.out.println(trie.search("xyz"));
		System.out.println(trie.search("wxyz"));
		System.out.println(trie.search("xyzt"));
		System.out.println(trie.startsWith("a"));
		System.out.println(trie.startsWith("xy"));
		System.out.println(trie.startsWith("zx"));
		System.out.println(trie.startsWith("wxt"));
		
	}
}
