class MovingAverage {

    Queue<Integer> q;
    double sum = 0;
    int size;

    public MovingAverage(int s) {
        q = new LinkedList();
        size = s;
    }
    
    public double next(int val) {
        if(q.size() == size){
            sum = sum - q.poll();
        }
        q.offer(val);
        sum += val;
        return sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
