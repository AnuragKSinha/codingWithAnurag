package DSA.Arrays.BinarySearch;
/**
 * Space Complexity:O(1)
 * Time Complexity:(log n)
 * Given an infinite sorted array (or an array with unknown size), 
 * find if a given number ‘key’ is present in the array. Write a function to return the index of the ‘key’ 
 * if it is present in the array, otherwise return -1.
 * Since it is not possible to define an array with infinite (unknown) size, you will be provided with an 
 * interface ArrayReader to read elements of the array. ArrayReader.get(index) will return the number at index; 
 * if the array’s size is smaller than the index, it will return Integer.MAX_VALUE.
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