import java.util.Iterator;

/**
 *  A Range iterable that can be used to iterate over a sequence of integers
 *  (similar to Python's range function).
 */
public class Range implements Iterable<Integer> {
  
  private int start;
  private int stop;
  private int step;
  
  private class RangeIterator implements Iterator<Integer> {
    
    private int current;
    
    public RangeIterator() {
      current = start;
    }
    
    public boolean hasNext() {
      if (step < 0) {
        return current > stop;
      }
      else {
        return current < stop;
      }
    }
    
    public Integer next() {
      Integer oldCurrent = current;
      current += step;
      return oldCurrent;
    }
    
    public void remove() {
      throw new UnsupportedOperationException("The remove method is not required for this PS.");
    }
  }
  
  public Range(int start, int stop, int step) {
    if ((start >= stop && step > 0) || (start <= stop && step < 0) || step == 0) {
      throw new IllegalArgumentException("You are not using the program correctly.");
    }
    this.start = start;
    this.stop = stop;
    this.step = step;
    
  }

  public Iterator<Integer> iterator() {
    return new RangeIterator();
  }
  
}

