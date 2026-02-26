package concurrency;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueTest {

    @Test
    public void testBasicPutTake() throws InterruptedException {
        BlockingQueue queue = new BlockingQueue(2);

        queue.put(10);
        queue.put(20);

        Assert.assertEquals(queue.take(), Integer.valueOf(10));
        Assert.assertEquals(queue.take(), Integer.valueOf(20));
    }

    @Test
    public void testBlockingWhenEmpty() throws InterruptedException, ExecutionException, TimeoutException {
        BlockingQueue queue = new BlockingQueue(1);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(queue::take);

        Thread.sleep(500); // ensure take() is waiting

        queue.put(99);

        Integer result = future.get(2, TimeUnit.SECONDS);

        Assert.assertEquals(result, Integer.valueOf(99));
        executor.shutdown();
    }

    @Test
    public void testBlockingWhenFull() throws InterruptedException, ExecutionException, TimeoutException {
        BlockingQueue queue = new BlockingQueue(1);

        queue.put(1);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(() -> {
            try {
                queue.put(2); // should block until space available
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread.sleep(500); // ensure put() is waiting

        Assert.assertEquals(queue.take(), Integer.valueOf(1));

        future.get(2, TimeUnit.SECONDS); // should complete now

        Assert.assertEquals(queue.take(), Integer.valueOf(2));

        executor.shutdown();
    }

    @Test
    public void testMultipleProducersConsumers() throws InterruptedException {

        BlockingQueue queue = new BlockingQueue(5);
        int producerThreads = 3;
        int consumerThreads = 3;
        int itemsPerProducer = 100;

        ExecutorService executor = Executors.newFixedThreadPool(6);
        AtomicInteger consumedCount = new AtomicInteger(0);

        // Producers
        for (int i = 0; i < producerThreads; i++) {
            executor.submit(() -> {
                for (int j = 0; j < itemsPerProducer; j++) {
                    try {
                        queue.put(j);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

        // Consumers
        for (int i = 0; i < consumerThreads; i++) {
            executor.submit(() -> {
                for (int j = 0; j < itemsPerProducer; j++) {
                    try {
                        queue.take();
                        consumedCount.incrementAndGet();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        Assert.assertEquals(consumedCount.get(), producerThreads * itemsPerProducer);
    }
}