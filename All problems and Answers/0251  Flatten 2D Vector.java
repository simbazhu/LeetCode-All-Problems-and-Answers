import java.util.NoSuchElementException;

class Vector2D {
    
    private int[][] vector;
    private int inner = 0;
    private int outer = 0;
    
    public Vector2D(int[][] v) {
        // We need to store a *reference* to the input vector. 
        vector = v;
    }

    // If the current outer and inner point to an integer, this method does nothing.
    // Otherwise, inner and outer are advanced until they point to an integer.
    // If there are no more integers, then outer will be equal to vector.length
    // when this method terminates.
    private void advanceToNext() {
        // While outer is still within the vector, but inner is over the 
        // end of the inner list pointed to by outer, we want to move
        // forward to the start of the next inner vector.
        while (outer < vector.length && inner == vector[outer].length) {
            inner = 0;
            outer++;
        }
    }
    
    public int next() {
        // As per Java specs, throw an exception if there's no next.
        // This will also ensure the pointers point to an integer otherwise.
        if (!hasNext()) throw new NoSuchElementException();
        // Return current element and move inner so that is after the current
        // element.
        return vector[outer][inner++];
    }
    
    public boolean hasNext() {
        // Ensure the position pointers are moved such they point to an integer,
        // or put outer = vector.length.
        advanceToNext();
        // If outer = vector.length then there are no integers left, otherwise
        // we've stopped at an integer and so there's an integer left.
        return outer < vector.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
