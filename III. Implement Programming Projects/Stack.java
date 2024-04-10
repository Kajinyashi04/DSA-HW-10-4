public class Stack {
    private Deque deque;

    public Stack(int size) {
        deque = new Deque(size);
    }

    public void push(long value) {
        deque.insertRight(value);
    }

    public long pop() {
        return deque.removeRight();
    }

    public long peek() {
        return deque.removeRight();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.isFull();
    }
}
