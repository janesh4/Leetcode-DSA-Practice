package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LRUCacheTest {

    @Test
    public void testExample() {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(cache.get(1), 1); // cache: [1,2]

        cache.put(3, 3); // evicts key 2
        Assert.assertEquals(cache.get(2), -1);

        cache.put(4, 4); // evicts key 1
        Assert.assertEquals(cache.get(1), -1);
        Assert.assertEquals(cache.get(3), 3);
        Assert.assertEquals(cache.get(4), 4);
    }

    @Test
    public void testUpdateExistingKey() {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(1, 10);

        Assert.assertEquals(cache.get(1), 10);
    }
}

