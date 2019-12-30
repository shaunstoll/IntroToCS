import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class KBestCounter<T extends Comparable<? super T>> {

    PriorityQueue<T> heap;
    int k;

    public KBestCounter(int k) {
        this.k = k;
        heap = new PriorityQueue<>();
    }

    public void count(T x) {
        if (heap.size() < k)
            heap.add(x);
        
        else {
            if (x.compareTo(heap.peek()) > 0) {
               heap.poll();
               heap.add(x);
            }
        }      
    }

    public List<T> kbest() {
        
        List<T> list = new ArrayList<>();
        int heap_size = heap.size();
        
        for (int i = 0; i < heap_size; i++)
            list.add(heap.poll());
        
        for (T o : list)
            heap.add(o);
        
        return list;
    }
}