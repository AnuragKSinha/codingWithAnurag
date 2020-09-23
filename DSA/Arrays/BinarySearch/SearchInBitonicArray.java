package DSA.Arrays.BinarySearch;
/**
 * Space Complexity:O(1)
 * Time Complexity:(log n)
 * Given a Bitonic array, find if a given ‘key’ is present in it. An array is considered bitonic 
 * if it is monotonically increasing and then monotonically decreasing. Monotonically increasing or
 * decreasing means that for any index i in the array arr[i] != arr[i+1].
 * Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.
 */
class SearchBitonicArray {

    public static int search(int[] arr, int key) {
      int start=0,end=arr.length-1;
      while(start<=end){
        int mid=start+((end-start)/2);
        if(arr[mid]==key)
            return mid;
        if(arr[mid]>arr[mid+1])//desc
        {
           if(key>arr[mid])
              end=mid-1;
           else
              start=mid+1;
        }else{ //asc
            if(key>arr[mid])
                start=mid+1;
            else
                end=mid-1;
  
        }
      }
      return -1;
    }
  
    public static void main(String[] args) {
      System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
      System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
      System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
      System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
  }