package DSA.Arrays.BinarySearch;
/**
 * Space Complexity:O(1)
 * Time Complexity:(log n)
 * Given an array of numbers sorted in ascending order, 
 * find the range of a given number ‘key’. The range of the ‘key’ 
 * will be the first and last position of the ‘key’ in the array.
 * Write a function to return the range of the ‘key’. 
 * If the ‘key’ is not present return [-1, -1].
 */
class FindRange {

    public static int[] findRange(int[] arr, int key) {
      int[] result = new int[] { -1, -1 };
      result[0]=findMaxRange(arr,key,false);
      if(result[0]!=-1)
        result[1]=findMaxRange(arr,key,true);
      return result;
    }
    public static int findMaxRange(int[] arr,int key,boolean maxInt){
      int start=0,end=arr.length-1;
      int index=-1;
      while(start<=end){
        int mid=start+((end-start)/2);
        if(arr[mid]==key){
          index=mid;
          if(maxInt)
            start=mid+1;
          else
            end=mid-1;
        }
        else if(arr[mid]>key)
            end=mid-1;
        else 
            start=mid+1;
      }
      return index;
    }
  
    public static void main(String[] args) {
      int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
      System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
      result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
      System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
      result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
      System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
  }