package challenges.arraysAndStringsTest;

import challenges.arraysAndStrings.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArraysAndStringsTest {

    private UniqueCharacterDetector charDetector;
    private PermutationDetector permDetector;
    private URLConverter urlConverter;
    private OneAwayDetector oneAwayDetector;
    private Compressor compressor;

    @Before
    public void SetUp() {
        charDetector = new UniqueCharacterDetector();
        permDetector = new PermutationDetector();
        urlConverter = new URLConverter();
        oneAwayDetector = new OneAwayDetector();
        compressor = new Compressor();
    }

    @Test
    public void UniqueCharacters() {
        // Challenge: Given a string, see if you can detect whether it contains only unique chars
        Assert.assertTrue(charDetector.isUnique("ab"));
        Assert.assertFalse(charDetector.isUnique("aa"));
        Assert.assertTrue(charDetector.isUnique("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void PermutationOfTheOther() {
        // Challenge: Given two strings, check if one is a permutation of the other
        Assert.assertTrue(permDetector.isPermutation("abc", "cba"));
        Assert.assertFalse(permDetector.isPermutation("abc", "xyz"));
    }

    @Test
    public void URLIfy() {
        // Challenge: See if you can replace all the spaces in a a string with the
        // ASCII symbol for space '%20'. Assume you are given the length of the final
        // string. Hint: Use array of char[]
        Assert.assertEquals("My%20Home%20Page", urlConverter.urlify("My Home Page    ", 16));
    }

    @Test
    public void OneAway() {
        // Challenge: There are three types of edits that can be performed on strings: insert a character,
        // remove a character, or replace a character. Given two strings, write a function to check if they are
        // one or zero edits away.

        Assert.assertFalse(oneAwayDetector.oneAway("pale", "paleXXXX"));

        Assert.assertTrue(oneAwayDetector.oneAway("pale", "ple"));
        Assert.assertTrue(oneAwayDetector.oneAway("pales", "pale"));
        Assert.assertTrue(oneAwayDetector.oneAway("pale", "bale"));
        Assert.assertFalse(oneAwayDetector.oneAway("pale", "bake"));

        Assert.assertTrue(oneAwayDetector.oneAway("pale", "aale"));
        Assert.assertTrue(oneAwayDetector.oneAway("pale", "pble"));
        Assert.assertTrue(oneAwayDetector.oneAway("pale", "palk"));

        Assert.assertFalse(oneAwayDetector.oneAway("pale", "bakeerer"));
    }

    @Test
    public void Compressor() {
        // Challenge: Give a string with repeating characters (i.e. "aaabb") write
        // an algorithm that will compress the string down to the character, followed
        // by the number of times it appears in the string (i.e "a3b2").
        // If the compressed string is not smaller than original, return original.

        Assert.assertEquals("a3b2", compressor.compress("aaabb"));
        Assert.assertEquals("aabb", compressor.compress("aabb"));
        Assert.assertEquals("ab", compressor.compress("ab"));
        Assert.assertEquals("abc", compressor.compress("abc"));
        Assert.assertEquals("z3", compressor.compress("zzz"));
        Assert.assertEquals("aabbaabb", compressor.compress("aabbaabb")); // not shorter
    }

}
