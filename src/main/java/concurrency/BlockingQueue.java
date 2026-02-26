package concurrency;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A thread-safe bounded blocking queue implementation.
 *
 * Supports:
 *  - put(Integer)  -> blocks if queue is full
 *  - take()        -> blocks if queue is empty
 *
 * This implementation uses:
 *  - intrinsic lock (synchronized)
 *  - wait()
 *  - notifyAll()
 *
 * Classic Producer-Consumer problem solution.
 */
public class BlockingQueue {

    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Inserts element into queue.
     * Blocks if queue is full.
     */
    public synchronized void put(Integer element) throws InterruptedException {

        // Use while, NOT if
        // Because of spurious wakeups.
        while (queue.size() == capacity) {
            wait();  // releases lock and waits
        }

        queue.add(element);

        // Wake up waiting threads
        notifyAll();
    }

    /**
     * Removes and returns element from queue.
     * Blocks if queue is empty.
     */
    public synchronized Integer take() throws InterruptedException {

        // Again, while not if (spurious wakeups safe)
        while (queue.isEmpty()) {
            wait();  // releases lock and waits
        }

        Integer item = queue.poll();

        // Wake up waiting threads
        notifyAll();

        return item;
    }

    public synchronized int size() {
        return queue.size();
    }
}