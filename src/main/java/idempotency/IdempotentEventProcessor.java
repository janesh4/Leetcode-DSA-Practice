package idempotency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Prevent Duplicate Processing using Idempotency Key
 */
public class IdempotentEventProcessor {

    private final ConcurrentMap<String, Boolean> processedEvents = new ConcurrentHashMap<>();

    /**
     * Process event only once
     */
    public boolean processEvent(String eventId) {

        // Atomic conditional write
        Boolean existing = processedEvents.putIfAbsent(eventId, Boolean.TRUE);

        if (existing != null) {
            System.out.println("Duplicate event skipped: " + eventId);
            return false;
        }

        // Only one thread reaches here
        executeBusinessLogic(eventId);
        return true;

    }

    private void executeBusinessLogic(String eventId) {
        System.out.println("Processing event: " + eventId);
        // Actual business logic
    }

}
