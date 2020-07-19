package DSA.Recursion;
/**
 * This Solution is a Recursive Solution Without using Dynamic Programming 
 * LeetCode ref- https://leetcode.com/problems/edit-distance/
 * this first Step of Coding which will eventually lead up to Bottom Up Approach of 
 * Dynamic Programming;
 * As we can see in editDist method that there are 2 parameters that are changing
 * which means we need to use a 2D matrix for solving it in Bottom Up Approach 
 * which is more efficient
 * Note: By this Solution you wont be able to pass all the test cases as it is a naive Solution and takes 
 * exponential Time Complexity
 */
class EditDistance {
    public int minDistance(String word1,String word2) {
        if(word1==null && word2==null)
            return 0;
        if(word1==null)
            return word2.length();
        else if(word2==null)
            return word1.length();
        return editDist(0,0,word1,word2);
    }
    public int editDist(int i,int j,String word1,String word2){
        if(i>=word1.length() && j>=word2.length())
            return 0;
        if(i>=word1.length())
            return word2.length()-j;
        else if(j>=word2.length())
            return word1.length()-i;
        if(word1.charAt(i)==word2.charAt(j))
            return editDist(i+1,j+1,word1,word2);
        int insert=editDist(i,j+1,word1,word2);
        int delete=editDist(i+1,j,word1,word2);
        int replace=editDist(i+1,j+1,word1,word2);
        return Math.min(replace,Math.min(insert,delete))+1;
    }
}