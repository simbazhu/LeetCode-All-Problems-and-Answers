/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private final Deque<NestedInteger> stack = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        ListIterator<NestedInteger> iter = nestedList.listIterator(nestedList.size());
        while (iter.hasPrevious()) {
            stack.push(iter.previous());
        }
        advanceToNextInteger();
    }

    private void advanceToNextInteger() {
        while (!stack.isEmpty()) {
            NestedInteger top = stack.peek();
            if (top.isInteger()) {
                return;
            } else {
                stack.pop();
                List<NestedInteger> nestedList = top.getList();
                ListIterator<NestedInteger> iter = nestedList.listIterator(nestedList.size());
                while (iter.hasPrevious()) {
                    stack.push(iter.previous());
                }
            }
        }
    }
    @Override
    public Integer next() {
        Integer ret = stack.pop().getInteger();
        advanceToNextInteger();
        return ret;
    }
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
