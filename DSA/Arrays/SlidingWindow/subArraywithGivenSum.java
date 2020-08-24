/**
 * Given an array of positive numbers and a positive number ‘S’, find the length of the
 * smallest contiguous subarray whose sum is greater than or equal to ‘S’. 
 * Return 0, if no such subarray exists.
 * Time Complexity:O(n)
 * Space Complexity:O(1)
 */
class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
      int windowSum = 0, 
      int min= Integer.MAX_VALUE;
      int windowStart = 0;
      for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
        windowSum += arr[windowEnd]; 
        while (windowSum >= S) {
          min = Math.min(min, windowEnd - windowStart + 1);
          windowSum -= arr[windowStart]; 
          windowStart++; 
        }
      }
  
      return min == Integer.MAX_VALUE ? 0 : min;
    }
  
    public static void main(String[] args) {
      int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
      System.out.println("Smallest subarray length: " + result);
      result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
      System.out.println("Smallest subarray length: " + result);
      result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
      System.out.println("Smallest subarray length: " + result);
    }
  }