public class GenericBinarySearch {
  
    public static int binarySearch(int[] arr, int i) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        
        while (left <= right) {
            mid = (right + left)/2;
            if (i < arr[mid]) {
                right = mid - 1;
            }
            else if (i > arr[mid]) {
                left = mid + 1;
            }
            else {return mid;}
        }
        return -1;
    }
    
    public static int binarySearch(ComparablePerson[] arr, ComparablePerson i) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        
        while (left <= right) {
            mid = (right + left)/2;
            if (i.compareTo(arr[mid]) < 0) {
                right = mid - 1;
            }
            else if (i.compareTo(arr[mid]) > 0) {
                left = mid + 1;
            }
            else {return mid;}
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256};
        System.out.println(binarySearch(arr, 128));
        System.out.println(binarySearch(arr, 1));
        System.out.println(binarySearch(arr, 256));
        System.out.println(binarySearch(arr, 12));
        
        ComparablePerson[] comp = new ComparablePerson[3];
        comp[0] = new ComparablePerson("Brown", "James");
        comp[1] = new ComparablePerson("Harris", "Todd");
        comp[2] = new ComparablePerson("Williams", "Matt");
        
        ComparablePerson other1 = new ComparablePerson("Williams", "Matt");
        ComparablePerson other2 = new ComparablePerson("Brown", "Sally");
        
        System.out.println(binarySearch(comp, other1));
        System.out.println(binarySearch(comp, other2));
        
    }
}