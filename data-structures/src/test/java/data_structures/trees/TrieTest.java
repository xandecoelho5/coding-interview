package data_structures.trees;

import data_structures.trees.Trie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrieTest {

    private Trie trie;

    @Before
    public void SetUp() {
        trie = new Trie();
    }

    @Test
    public void SearchPrefix() {
        trie.insert("tries");
        trie.insert("trie");
        trie.insert("tried");
        trie.insert("try");

        Assert.assertTrue(trie.contains("try"));
        Assert.assertTrue(trie.startsWith("tr"));

        trie.insert("Canada");
        Assert.assertTrue(trie.startsWith("C"));
        Assert.assertTrue(trie.startsWith("Ca"));
        Assert.assertTrue(trie.startsWith("Can"));
        Assert.assertTrue(trie.startsWith("Cana"));
        Assert.assertTrue(trie.startsWith("Canad"));
        Assert.assertTrue(trie.startsWith("Canada"));
        Assert.assertTrue(trie.contains("Canada"));
    }

}
