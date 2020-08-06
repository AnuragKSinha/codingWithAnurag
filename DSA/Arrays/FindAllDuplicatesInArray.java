package DSA.Arrays;
/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Space Complexity:O(1); we are excluding out array and it is not required if we ditrectly 
 * print results.
 * Time Complexity:(n)
 */
class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        if(nums.length==0)
            return new ArrayList<Integer>();
        List<Integer> output=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int index=nums[i];
            if(index<0)
                index*=-1;
            if(nums[index-1]<0)
                output.add(index);
            else if(nums[index-1]>0)
                nums[index-1]*=-1;
        }
        return output;
    }
}