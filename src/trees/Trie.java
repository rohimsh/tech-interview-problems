package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class Trie {
    private Map<Character, Trie> trieMap;
    private boolean isEndOfWord;
    
    public Trie() {
        this.trieMap = new HashMap<Character, Trie>();
        this.isEndOfWord = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word != null && word.length() != 0){
            int level = 0, len = word.length();
            Trie crawl = this;
            
            for(; level < len; level++){
                char ch = word.charAt(level);
                
                if(!crawl.trieMap.containsKey(ch)){
                	Trie newNode = new Trie();
                	crawl.trieMap.put(ch, newNode);
                    crawl = newNode;
                } else{
                    crawl = crawl.trieMap.get(ch);
                }
            }
            
            crawl.isEndOfWord = true;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word != null && word.length() != 0){
            int level = 0, len = word.length();
            Map<Character, Trie> trieMap = this.trieMap;
            boolean isEndOfWord = this.isEndOfWord;
            
            for(; level < len; level++){
                char ch = word.charAt(level);
                
                if(!trieMap.containsKey(ch)){
                    return false;
                } else{
                	isEndOfWord = trieMap.get(ch).isEndOfWord;
                	trieMap = trieMap.get(ch).trieMap;
                }
            }
            
            return isEndOfWord;
            
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix != null && prefix.length() != 0){
            int level = 0, len = prefix.length();
            Map<Character, Trie> trieMap = this.trieMap;
            boolean isEndOfWord = this.isEndOfWord;
            
            for(; level < len; level++){
                char ch = prefix.charAt(level);
                if(!trieMap.containsKey(ch)){
                    break;
                } else{
                	isEndOfWord = trieMap.get(ch).isEndOfWord;
                	trieMap = trieMap.get(ch).trieMap;
                }
            }
            
            return level == len;
            
        }
        return true;
    }
}

