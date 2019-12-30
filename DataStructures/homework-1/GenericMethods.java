public class GenericMethods {
    
  public static <T extends Comparable<T>> int findMin(T[] arr) {
    
    int idx = 0;
    T smallestElement = arr[0];
    
    for (int i = 1; i < arr.length; i++) {
      
      if (arr[i].compareTo(smallestElement) < 0)  {
        smallestElement = arr[i];
        idx = i;
      }
    }
    return idx;
  }
  
  public static <T extends Comparable<T>> int findMinRecursive(T[] arr) {
    int i = 1;
    T[] array = arr;
    T smallestElement = arr[0];
    int idx = 0;
    
    return findMinRecursiveHelper(i, array, smallestElement, idx);
  }
  
  private static <T extends Comparable<T>> int findMinRecursiveHelper(int i, T[] arr, T smallestElement, int idx) {
    
    if (i == arr.length) {
      return idx; //Base Case
    }
    
    else if (arr[i].compareTo(smallestElement) < 0) {
      smallestElement = arr[i];
      idx = i;
      
      return findMinRecursiveHelper(i + 1, arr, smallestElement, idx);
    }
    
    else {
      return findMinRecursiveHelper(i + 1, arr, smallestElement, idx);
    }
  }
  
  public static <T extends Comparable<T>> int binarySearch(T[] arr, T x) {
    T[] array = arr;
    T item = x;
    int left = 0;
    int right = arr.length - 1;
    
    return binarySearchHelper(array, item, left, right);
  }
  
  private static <T extends Comparable<T>> int binarySearchHelper(T[] arr, T x, int left, int right) {
    if (left > right) {
      return -1;
    }
    
    int mid = (left + right)/2;
      
    if (x.compareTo(arr[mid]) == 0) { //Base Case
      return mid;
    }
    if (x.compareTo(arr[mid]) < 0) {
      return binarySearchHelper(arr, x, left, right = mid - 1);
    }
    else {
      return binarySearchHelper(arr, x, left = mid + 1, right);
    }
  }
  public static void main(String[] args) {
    Integer[] arr = new Integer[]{1, 2, 4, 5, 8, 12};
    Integer x = 13;
    System.out.println(binarySearch(arr, x));
  }
}