package trees;

import java.util.HashMap;

/**
 * Problem:
 * Implement a Trie (Prefix Tree) supporting insert, search, and prefix search.
 *
 * LeetCode:
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * Overview:
 * - Each TrieNode stores:
 *      → children map for next characters
 *      → endOfWord flag for exact match
 *
 * Overall Time Complexity:
 * - All operations are O(L), where L = length of input string.
 *
 * Overall Space Complexity:
 * - O(T), where T = total number of TrieNodes created
 *   (≈ total characters inserted across all words in worst case).
 */
 class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}

public class PrefixTree {
    private TrieNode root;

    /** Initializes an empty Trie. */
    public PrefixTree() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the Trie.
     *
     * Mindmap:
     *  root → iterate each character →
     *  create node if absent →
     *  move to child →
     *  mark endOfWord = true
     *
     * Time Complexity:
     *  O(L), where L = length of the word.
     *
     * Auxiliary Space:
     *  O(1) per call (node creation counted in Trie storage).
     */
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.endOfWord = true;
    }

    /**
     * Searches for an exact word in the Trie.
     *
     * Mindmap:
     *  root → traverse characters →
     *  missing node → return false →
     *  traversal ends → check endOfWord
     *
     * Time Complexity:
     *  O(L), where L = length of the word.
     *
     * Auxiliary Space:
     *  O(1)
     */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.endOfWord;
    }

    /**
     * Checks whether any word starts with the given prefix.
     *
     * Mindmap:
     *  root → traverse prefix →
     *  missing node → return false →
     *  traversal success → return true
     *
     * Time Complexity:
     *  O(L), where L = length of the prefix.
     *
     * Auxiliary Space:
     *  O(1)
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}
