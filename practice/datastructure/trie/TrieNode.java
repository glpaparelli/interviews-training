package datastructure.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    
    private final Map<Character, TrieNode> childern = new HashMap<>();
    private boolean wordEnded; 
    
    public Map<Character, TrieNode> getChildern(){
        return this.childern;
    }

    public boolean isWordEnded(){
        return this.wordEnded;
    }

    public void setWordEnded(boolean wordEnded){
        this.wordEnded = wordEnded;
    }
}
