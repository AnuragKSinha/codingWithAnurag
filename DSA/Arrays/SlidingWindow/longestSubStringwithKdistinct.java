package DSA.Array.SlidingWindow;
/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
 * Time Complexity:O(n)
 * Space Complexity:O(n)
 */
class lengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character,Integer> map=new HashMap<>();
        int start=0;
        int res=0;
        for(int end=0;end<s.length();end++){
            if(map.containsKey(s.charAt(end)))
                map.put(s.charAt(end),map.get(s.charAt(end))+1);
            else 
                map.put(s.charAt(end),1);
            while(map.size()>k){
                char leftchar=s.charAt(start);
                map.put(leftchar,map.get(leftchar)-1);
                if(map.get(leftchar)==0)
                    map.remove(leftchar);
                start++;
            }
            res=Math.max(res,end-start+1);
        }
        return res;
    }
}