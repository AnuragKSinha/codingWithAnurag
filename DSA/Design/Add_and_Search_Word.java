package DSA.Design;
/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 *
 */
class WordDictionary {
    class TrieNode{
        private TrieNode[] links;
        private final int R=26;
        private boolean isEnd;
        TrieNode(){
            links=new TrieNode[R];
        }
        public  boolean containsKey(char ch){
            if(ch=='.')
                return false;
            return links[ch-'a']!=null;
        }
        public TrieNode getKey(char ch){
            return links[ch-'a'];
        }
        public void put(char ch,TrieNode node){
            links[ch-'a']=node;
        }
        public boolean isEnd(){
            return isEnd;
        }
        public void setEnd(){
            isEnd=true;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node=root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch))
                node.put(ch,new TrieNode());
            node=node.getKey(ch);
        }
        node.setEnd();
    }
    public boolean searchInWord(String word,int index,TrieNode node){
        TrieNode temp=node;
        for(int i=index;i<word.length();i++){
            if(!temp.containsKey(word.charAt(i))){
                if(word.charAt(i)=='.'){
                    for(int l=0;l<26;l++){
                        if(temp.links[l]!=null && searchInWord(word,i+1,temp.links[l]))
                            return true;  
                    }
                }
                    return false;
            }else {
                temp=temp.getKey(word.charAt(i));
            }
        }
        return temp.isEnd;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchInWord(word,0,root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */