package PC;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class PCSemaphores {

    private final Queue<Integer> buffer = new LinkedList<>();
    private final Semaphore empty;
    private final Semaphore full;
    private final Semaphore mutex = new Semaphore(1);

    public PCSemaphores(int capacity) {
        this.empty = new Semaphore(capacity);
        this.full = new Semaphore(0);
    }

    public void produce(int item) throws InterruptedException {
        empty.acquire();
        mutex.acquire();
        try {
            buffer.offer(item);
        } finally {
            mutex.release();
        }
        full.release();
    }

    public int consume() throws InterruptedException {
        full.acquire();
        mutex.acquire();
        int item;
        try {
            item = buffer.poll();
        } finally {
            mutex.release();
        }
        empty.release();
        return item;
    }

    // helper for testing
    public int size() {
        return buffer.size();
    }
}
