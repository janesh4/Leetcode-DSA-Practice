package PC;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PCSemaphoresTest {

    @Test
    public void testProducerConsumerConcurrency() throws InterruptedException {

        PCSemaphores pc = new PCSemaphores(5);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Integer> consumedItems = new CopyOnWriteArrayList<>();

        Runnable producer = () -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    pc.produce(i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable consumer = () -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    consumedItems.add(pc.consume());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        executor.submit(producer);
        executor.submit(producer);
        executor.submit(consumer);
        executor.submit(consumer);

        executor.shutdown();
        boolean finished = executor.awaitTermination(10, TimeUnit.SECONDS);

        // Assertions
        Assert.assertTrue(finished, "Executor did not finish in time");
        Assert.assertEquals(consumedItems.size(), 20, "All items should be consumed");
        Assert.assertEquals(pc.size(), 0, "Buffer should be empty at end");
    }
}
