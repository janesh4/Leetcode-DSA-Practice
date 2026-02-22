package tries;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tries.PrefixTree;

/**
 * Unit tests for PrefixTree (Trie).
 *
 * Coverage:
 * - Insert and exact search
 * - Prefix search
 * - Multiple word handling
 * - Non-existing values
 * - Empty Trie behavior
 */
public class PrefixTreeTest {

    private PrefixTree trie;

    /** Runs before every test case */
    @BeforeMethod
    public void setUp() {
        trie = new PrefixTree();
    }

    /** Verifies insert() and search() for exact word */
    @Test
    public void shouldFindInsertedWord() {
        trie.insert("apple");

        Assert.assertTrue(trie.search("apple"),
                "Inserted word must be found in Trie");
    }

    /** Verifies search() returns false for partial word */
    @Test
    public void shouldNotFindPartialWordAsExactMatch() {
        trie.insert("apple");

        Assert.assertFalse(trie.search("app"),
                "Partial prefix should not be treated as full word");
    }

    /** Verifies startsWith() works for valid prefix */
    @Test
    public void shouldReturnTrueForValidPrefix() {
        trie.insert("apple");

        Assert.assertTrue(trie.startsWith("app"),
                "Prefix should exist in Trie");
    }

    /** Verifies search() for non-existing word */
    @Test
    public void shouldReturnFalseForNonExistingWord() {
        trie.insert("apple");

        Assert.assertFalse(trie.search("banana"),
                "Non-inserted word must not be found");
    }

    /** Verifies Trie handles multiple insertions correctly */
    @Test
    public void shouldHandleMultipleWords() {
        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        Assert.assertTrue(trie.search("apple"));
        Assert.assertTrue(trie.search("app"));
        Assert.assertTrue(trie.search("bat"));
        Assert.assertFalse(trie.search("bad"));
    }

    /** Verifies behavior on empty Trie */
    @Test
    public void shouldReturnFalseWhenTrieIsEmpty() {
        Assert.assertFalse(trie.search("anything"));
        Assert.assertFalse(trie.startsWith("a"));
    }
}
