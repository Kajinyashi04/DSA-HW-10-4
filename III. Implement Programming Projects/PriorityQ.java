public class PriorityQ {
    private int maxSize;
    private long[] queueArray;
    private int nItems;

    public PriorityQ(int size) {
        maxSize = size;
        queueArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long value) {
        if (nItems == 0) {
            queueArray[nItems++] = value;
        } else {
            int j;
            for (j = nItems - 1; j >= 0; j--) {
                if (value > queueArray[j]) {
                    queueArray[j + 1] = queueArray[j];
                } else {
                    break;
                }
            }
            queueArray[j + 1] = value;
            nItems++;
        }
    }

    public long remove() {
        return queueArray[--nItems];
    }

    public long peekMin() {
        return queueArray[nItems - 1];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public void display() {
        System.out.print("Priority Queue (from highest to lowest priority): ");
        for (int i = nItems - 1; i >= 0; i--) {
            System.out.print(queueArray[i] + " ");
        }
        System.out.println();
    }
}
