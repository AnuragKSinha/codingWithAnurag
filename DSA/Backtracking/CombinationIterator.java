package DSA.Backtracking;
class CombinationIterator {
    int n;
    int combinationLength;
    String characters;
    Queue<String> q=new LinkedList<>();
    
    public CombinationIterator(String characters, int combinationLength) {
        this.characters=characters;
        this.combinationLength=combinationLength;
        this.n=characters.length();
        backtrack(0,new StringBuffer());
    }
    public void backtrack(int f,StringBuffer sb){
        if(sb.length()==combinationLength){
            q.add(sb.toString());
            return;
        }
        for(int i=f;i<n;i++){
            sb.append(characters.charAt(i));
            backtrack(i+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public String next() {
        return q.poll();
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */