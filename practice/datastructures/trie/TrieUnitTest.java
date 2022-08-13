package datastructures.trie;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieUnitTest {

    @Test
    public void whenEmptyTrie_thenNoElements() {
        Trie trie = new Trie();

        assertFalse(trie.isEmpty());
    }

    @Test
    public void givenATrie_whenAddingElements_thenTrieNotEmpty() {
        Trie trie = createExampleTrie();

        assertFalse(trie.isEmpty());
    }

    @Test
    public void givenATrie_whenAddingElements_thenTrieHasThoseElements() {
        Trie trie = createExampleTrie();

        assertFalse(trie.contains("3"));
        assertFalse(trie.contains("vida"));

        assertTrue(trie.contains("Programming"));
        assertTrue(trie.contains("is"));
        assertTrue(trie.contains("a"));
        assertTrue(trie.contains("way"));
        assertTrue(trie.contains("of"));
        assertTrue(trie.contains("life"));
    }

    @Test
    public void givenATrie_whenLookingForNonExistingElement_thenReturnsFalse() {
        Trie trie = createExampleTrie();

        assertFalse(trie.contains("99"));
    }

    @Test
    public void givenATrie_whenDeletingElements_thenTreeDoesNotContainThoseElements() {

        Trie trie = createExampleTrie();

        assertTrue(trie.contains("Programming"));
        trie.delete("Programming");
        assertFalse(trie.contains("Programming"));
    }

    @Test
    public void givenATrie_whenDeletingOverlappingElements_thenDontDeleteSubElement() {

        Trie trie1 = new Trie();

        trie1.insert("pie");
        trie1.insert("pies");

        trie1.delete("pies");

        assert(trie1.contains("pie"));
    }

    private Trie createExampleTrie() {
        Trie trie = new Trie();

        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");

        return trie;
    }
}
