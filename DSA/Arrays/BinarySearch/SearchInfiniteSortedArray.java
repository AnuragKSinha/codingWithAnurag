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
class SearchInfiniteSortedArray {
class ArrayReader {
  int[] arr;

  ArrayReader(int[] arr) {
    this.arr = arr;
  }

  public int get(int index) {
    if (index >= arr.length)
      return Integer.MAX_VALUE;
    return arr[index];
  }
}

  public static int search(ArrayReader reader, int key) {
    int start=0,end=1;
    while(reader.get(end)<key){
      int newStart=end+1;
      end+=(end-start+1)*2;
      start=newStart;
    }
    return binarySearch(reader,key,start,end);
  }
  public static int binarySearch(ArrayReader reader,int key,int start,int end){
    while(start<=end){
      int middle=start+((end-start)/2);
      if(reader.get(middle)==key)
          return middle;
      else if(reader.get(middle)>key)
          end=middle-1;
      else 
          start=middle+1;
    }
    return -1;
  }

  public static void main(String[] args) {
    ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
    System.out.println(SearchInfiniteSortedArray.search(reader, 16));
    System.out.println(SearchInfiniteSortedArray.search(reader, 11));
    reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
    System.out.println(SearchInfiniteSortedArray.search(reader, 15));
    System.out.println(SearchInfiniteSortedArray.search(reader, 200));
  }
}