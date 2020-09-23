package DSA.Arrays.BinarySearch;
/**
 * Space Complexity:O(1)
 * Time Complexity:(log n)
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
class RotatedSortedArraySearch {
    public int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+((right-left)/2);
            if(nums[mid]==target)
                return mid;
            if(nums[left]<=nums[mid]){ // left arr is sorted
                if(target>=nums[left] && target<nums[mid]) 
                    right=mid-1; // target lies bwt left and mid
                else
                    left=mid+1;
            }else{  // right arr is sorted
                if(target>nums[mid] && target<=nums[right]) //target lies bwt mid and right
                    left=mid+1;
                else
                    right=mid-1;
            }
        }
        return -1;
    }
}