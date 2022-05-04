class Trie {
    private Trie[] children;
    private boolean isEnd;
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        Trie node = this;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie node = performSearch(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie node = performSearch(prefix);
        return node != null;

    }

    public Trie performSearch(String word){
        Trie node = this;
        for(char c : word.toCharArray()){
            if(node.children[c - 'a'] == null){
                return null;
            }
            node = node.children[c - 'a'];
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
