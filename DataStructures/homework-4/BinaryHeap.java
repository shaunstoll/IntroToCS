import java.util.Arrays;
import java.util.HashMap;

public class BinaryHeap<T extends Comparable<? super T>> {

    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize; // Number of elements in heap
    private T[ ] array; // The heap array

    private HashMap<T, Integer> itemToArrayIndex; // TODO: you will use this hashmap mapping keys to positions in the heap. 

    /**
     * Construct the binary heap.
     */
    public BinaryHeap( ) {
        this( DEFAULT_CAPACITY );
    }

    /**
     * Construct the binary heap.
     * @param capacity the capacity of the binary heap.
     */
    @SuppressWarnings("unchecked")
    public BinaryHeap( int capacity ) {

        currentSize = 0;
        array = (T []) new Comparable[ capacity + 1 ];
        itemToArrayIndex = new HashMap<>(); // empty heap, empty hashmap
    }

    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( ) {
        return currentSize == 0;
    }

    /**
     * Test if the priority queue is logically full.
     * @return true if full, false otherwise.
     */
    public boolean isFull( ) {
        return currentSize == array.length - 1;
    }

    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty( ) {
        currentSize = 0;
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     * @exception IndexOutOfBoundsException if container is full.
     */
    public void insert(T x) throws IndexOutOfBoundsException {

        // TODO:This method needs to be modified         
        
        if( isFull( ) )
            throw new IndexOutOfBoundsException( );
            
        if (itemToArrayIndex.containsKey(x)) {
            int oldIndex = itemToArrayIndex.get(x);
            int index = currentSize;
            array[oldIndex] = array[ currentSize-- ];
            itemToArrayIndex.put(array[oldIndex], oldIndex);
            itemToArrayIndex.remove(array[index]);
            array[index] = null;
            percolateDown(oldIndex);
        }
        
        int hole = ++currentSize;
 
        //Percolate up
        while (hole>1 && x.compareTo(array [hole /2]) <0 ) {
            array[hole] = array[hole/2];
            itemToArrayIndex.put(array[hole], hole); // update hashMap
            if (x.compareTo(array [hole /2]) <0)
                hole /= 2; 
        }
            
        array[ hole ] = x;
        itemToArrayIndex.put(x, hole); // update hashMap
    }

    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item, or null, if empty.
     */
    public T findMin( ) {
        if( isEmpty( ) )
            return null;
        return array[ 1 ];
    }

    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or null, if empty.
     */
    public T deleteMin( ) {
        if( isEmpty( ) )
            return null;

        T minItem = findMin( );
        int index = currentSize;
        array[ 1 ] = array[ currentSize-- ];
        array[index] = null;
        percolateDown( 1 );
        return minItem;
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap( ) {
        for( int i = currentSize / 2; i > 0; i-- )
            percolateDown( i );
    }

    /**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown( int hole ) {
        // TODO:This method needs to be modified        

        int child;
        T tmp = array[ hole ];

        for( ; hole * 2 <= currentSize; hole = child ) {
/* 4*/      child = hole * 2;
/* 5*/      if( child != currentSize &&
/* 6*/          array[ child + 1 ].compareTo( array[ child ] ) < 0 )
/* 7*/          child++;
/* 8*/      if( array[ child ].compareTo( tmp ) < 0 ){
/* 9*/          array[ hole ] = array[ child ];
                itemToArrayIndex.put(array[hole], hole); // update hashMap
            } else
/*10*/          break;
        }
/*11*/  array[ hole ] = tmp;
        itemToArrayIndex.put(array[hole], hole); // update hashmap
    }

    /**
     * Get a string representation of the heap array.
     * @return string representation of the array backing the this heap.
     */
    public String printArray() {
        return Arrays.asList(array).toString();
    }
    
    /**
     * Get a string representation of the heap. 
     * @return a tree representing the tree encoded in this heap. 
     */
    public String printAsTree() {
        StringBuilder sb = new StringBuilder();
        printAsTree(sb,1);
        return sb.toString(); 
    }
   
    /**
     * Recursive internal method to assemble a tree
     * string representing the heap.
     */ 
    private void printAsTree(StringBuilder sb,int i) {
        if (2*i <= currentSize) {  // has left child
            sb.append("("); 
            sb.append(array[i]);
            sb.append(" ");
            printAsTree(sb,2*i); 
            if ((2*i + 1) <= currentSize){  // has right child
                sb.append(" ");
                printAsTree(sb, 2*i+1);
            }
            sb.append(")");
        } else {
            sb.append(array[i]);
        }
    }

    public static void main( String [ ] args ) {
        BinaryHeap<Process> h = new BinaryHeap<>(10);
        h.insert(new Process("p1",20));
        System.out.println(h.printArray());
        h.insert(new Process("p2",40));
        System.out.println(h.printArray());
        h.insert(new Process("p3",30));
        System.out.println(h.printArray());
        h.insert(new Process("p4",10));
        System.out.println(h.printArray());
        
        
        // Now change the priority of p2
        h.insert(new Process("p2",5));
        System.out.println(h.printArray());
        
        h.insert(new Process("p2",100));
        System.out.println(h.printArray());

    }
}
