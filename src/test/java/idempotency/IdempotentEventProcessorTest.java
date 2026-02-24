package idempotency;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class IdempotentEventProcessorTest {

    @Test
    public void testSingleProcessing() {
        IdempotentEventProcessor processor = new IdempotentEventProcessor();

        boolean first = processor.processEvent("event1");
        boolean second = processor.processEvent("event1");

        Assert.assertTrue(first, "First call should process");
        Assert.assertFalse(second, "Second call should be skipped");
    }

    @Test
    public void testDifferentEvents() {
        IdempotentEventProcessor processor = new IdempotentEventProcessor();

        boolean e1 = processor.processEvent("event1");
        boolean e2 = processor.processEvent("event2");

        Assert.assertTrue(e1);
        Assert.assertTrue(e2);
    }

    @Test
    public void testConcurrentProcessing() throws InterruptedException {
        IdempotentEventProcessor processor = new IdempotentEventProcessor();

        int threadCount = 20;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);
        AtomicInteger successCount = new AtomicInteger(0);

        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                if (processor.processEvent("event1")) {
                    successCount.incrementAndGet();
                }
                latch.countDown();
            });
        }

        latch.await();
        executor.shutdown();

        Assert.assertEquals(successCount.get(), 1,
                "Only one thread should process the event");
    }
}
