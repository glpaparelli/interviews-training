package datastructures.trie;

public class Trie {
    private TrieNode root; 

    public Trie(){
        root = new TrieNode();
    }

    /**
     * @param word word to insert in the trie
     */
    public void insert(String word){
        TrieNode current = this.root; 
        for(Character c : word.toCharArray())
            //if the char exists than we move there, otherwise we insert it and then move there
            current = current.getChildern().computeIfAbsent(c, dontcare -> new TrieNode());

        current.setWordEnded(true);
    }

    public boolean contains(String word){
        TrieNode current = this.root;

        for(Character c : word.toCharArray()){
            TrieNode node = current.getChildern().get(c);
            if(node == null)
                return false; 

            current = node; 
        }
        return current.isWordEnded();
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    /**
     * @param word is the word to remove from the trie
     * @return true if the word is eliminated, false if the word is not present in the trie
     */
    public boolean delete(String word){
        return delete(root, word, 0);
    }

    //TODO: overriding posso anche cambiare le condizioni di visibilita!
    private boolean delete(TrieNode current, String word, int start) {
        // base case, run trough the trie as many times as the length of the word
        if(start == word.length()){
            //if the word has been found but it is only a prefix of another word
            //than the real word is not in the trie and we return false; 
            if(!current.isWordEnded())
                return false; 

            //say that we inserted in the trie two words: abba and ab
            //if I want to eliminate ab, when I find it a simply state that
            //the word do not finish at ab
            current.setWordEnded(false);
            return current.getChildern().isEmpty();
        }

        //take the (current) first char of the word
        char c = word.charAt(start);
        TrieNode node = current.getChildern().get(c);

        //if the current first char has no sons than the word is not found
        if(node == null)
            return false;

        //we should remove
        boolean shouldRemove = delete(node, word, start+1) && !node.isWordEnded();    

        if(shouldRemove){
            current.getChildern().remove(c);
            return current.getChildern().isEmpty();
        }

        return false;
    }



}
