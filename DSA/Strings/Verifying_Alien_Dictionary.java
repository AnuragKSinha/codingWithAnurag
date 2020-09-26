package DSA.String;
/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 * Time Complexity: O(C) ,where C is the total content of words
 * Space Complexity: O(1)
 */
class Verifying_Alien_Dictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] loc=new int[26];
	for(int i=0;i<order.length();i++){
		loc[order.charAt(i)-'a']=i;
	}
	for(int i=0;i<words.length-1;i++){
			if(!checkwords(words[i],words[i+1],loc))
				return false;
	}
	return true;	
    }
 public boolean checkwords(String str1,String str2,int[] loc){
	int s1=0;
	int s2=0;
	while(s1<str1.length() && s2<str2.length()){
        char c1=str1.charAt(s1);
        char c2=str2.charAt(s2);
		if(c1!=c2)
			return loc[c1-'a']<loc[c2-'a'];
		s1++;
		s2++;
	}
	if(str1.length()>str2.length())
		return false;
	return true;
}
}
