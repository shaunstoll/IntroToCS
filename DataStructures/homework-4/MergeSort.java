import java.util.Arrays;

public class MergeSort {

  /**
   * Method that merges two sorted halves of a subarray (from Weiss,
   * Data Structures and Algorithm Analysis in Java)
   * 
   * @param a
   *          an array of Comparable items.
   * @param tmpArray
   *          an array to place the merged result.
   * @param leftPos
   *          the left-most index of the subarray.
   * @param rightPos
   *          the index of the start of the second half.
   * @param rightEnd
   *          the right-most index of the subarray.
   */
  private static void merge(Integer[] a, Integer[] tmp, int leftPos, int rightPos, int rightEnd) {

        int aCtr = leftPos;
        int bCtr = rightPos; 
        int cCtr = leftPos; 

        while (aCtr < rightPos && bCtr <= rightEnd) {
            
            if (a[aCtr] <= a[bCtr]) 
                tmp[cCtr++] = a[aCtr++];
            else 
                tmp[cCtr++] = a[bCtr++];
        }
        
        if (aCtr >= rightPos )  // copy remaining elements in right partion 
            while (bCtr <= rightEnd) 
                tmp[cCtr++] = a[bCtr++];

        if (bCtr > rightEnd ) // copy remaining elements in left partion
            while (aCtr < rightPos) 
                tmp[cCtr++] = a[aCtr++]; 
            
        for (int i=leftPos; i<=rightEnd; i++) {
            a[i] = tmp[i];
        }

  }

 
  /* 
   * @param a
   *          an array of Comparable items.
   * @param tmpArray
   *          an array to place the merged result.
   * @param left
   *          the left-most index of the subarray.
   * @param right
   *          the right-most index of the subarray.
   */
  private static void mergeSort(Integer[] inputArray) {
      
      if (inputArray == null)
          throw new IllegalArgumentException("Invalid input");
      
      if (inputArray.length == 1)
          return;
       
      for (int i = 0; i < inputArray.length - 1; i=i+2) {
          try {
              if (inputArray[i+1] - inputArray[i] < 0) {
                  Integer tmp = inputArray[i];
                  inputArray[i] = inputArray[i+1];
                  inputArray[i+1] = tmp;
              }
          }
          catch (NullPointerException e) {
              System.out.println(e);
              System.out.println("There is a null element.");
              System.exit(0);
          }
      }
      //System.out.println(Arrays.toString(inputArray) + " test");
      
      if (inputArray.length == 2)
          return;
      
      
      Integer[] tmp = new Integer[inputArray.length];
      
      for (int size = 2; size < inputArray.length; size *= 2) {
          
          int leftPos = 0;
          int rightPos = size;
          int rightEnd = Math.min(size*2 - 1, inputArray.length - 1);
          
          while (rightEnd < inputArray.length) {
              merge(inputArray, tmp, leftPos, rightPos, rightEnd);
              leftPos = rightEnd + 1;
              rightPos = leftPos + size;
              rightEnd = rightPos + size - 1;
              if (rightPos < inputArray.length && rightEnd >= inputArray.length)
                  rightEnd = inputArray.length - 1;
          }
          //System.out.println(Arrays.toString(inputArray) + " test");
      }
      
      return;
  }

  public static void main(String[] args) {
    Integer[] a = {1,9,2,4,7,8,4,5,0};
    System.out.println(Arrays.toString(a)); 
    MergeSort.mergeSort(a);
    System.out.println(Arrays.toString(a));
    
    Integer[] b = {3,6,-10,12,5,2,1};
    System.out.println(Arrays.toString(b)); 
    MergeSort.mergeSort(b);
    System.out.println(Arrays.toString(b)); 
      
    Integer[] c = {2,1, -9, 12, 18, 6, 4, 22, 8, 7, 3, 100};
    System.out.println(Arrays.toString(c)); 
    MergeSort.mergeSort(c);
    System.out.println(Arrays.toString(c)); 
    
    
  }
}
