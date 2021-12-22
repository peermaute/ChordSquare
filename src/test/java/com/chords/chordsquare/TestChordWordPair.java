package com.chords.chordsquare;

import com.chords.chordsquare.music.Chord;
import com.chords.chordsquare.structure.ChordWordPair;
import com.chords.chordsquare.structure.Position;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestChordWordPair {
    @Test
    void testToStringListChordNull(){
        ChordWordPair pair = new ChordWordPair("Test");
        ArrayList<String> list = pair.toStringList();
        assertEquals(2, list.size());
        assertEquals("    ", list.get(0));
        assertEquals("Test", list.get(1));
    }
    @Test
    void testToStringListLongerChord(){
        ChordWordPair pair = new ChordWordPair("Test", "Gsus4");
        ArrayList<String> list = pair.toStringList();
        assertEquals("Gsus4", list.get(0));
        assertEquals("Test ", list.get(1));
    }
    @Test
    void testToStringListLongerWord(){
        ChordWordPair pair = new ChordWordPair("Test", "G");
        ArrayList<String> list = pair.toStringList();
        assertEquals("G   ", list.get(0));
        assertEquals("Test", list.get(1));
    }
    @Test
    void testToStringListSameLengthChordWord(){
        ChordWordPair pair = new ChordWordPair("Test", "Gmaj");
        ArrayList<String> list = pair.toStringList();
        assertEquals("Gmaj", list.get(0));
        assertEquals("Test", list.get(1));
    }
    @Test
    void testToStringListWordNull(){
        ChordWordPair pair = new ChordWordPair();
        pair.setChord(new Chord("Gsus4"));
        ArrayList<String> list = pair.toStringList();
        assertEquals("Gsus4", list.get(0));
        assertEquals("     ", list.get(1));
    }
    @Test
    void testToStringListChordAndWordNull(){
        ChordWordPair pair = new ChordWordPair();
        ArrayList<String> list = pair.toStringList();
        assertEquals("", list.get(0));
        assertEquals("", list.get(1));
    }
    @Test
    void testToStringListBefore(){
        ChordWordPair pair = new ChordWordPair("Test", "Gmaj7");
        pair.setPosition(Position.BEFORE);
        ArrayList<String> list = pair.toStringList();
        assertEquals("Gmaj7    ", list.get(0));
        assertEquals("     Test", list.get(1));
    }
    @Test
    void testToStringListBeforeShortChord(){
        ChordWordPair pair = new ChordWordPair("Test", "G");
        pair.setPosition(Position.BEFORE);
        ArrayList<String> list = pair.toStringList();
        assertEquals("G    ", list.get(0));
        assertEquals(" Test", list.get(1));
    }
    @Test
    void testToStringListAfter(){
        ChordWordPair pair = new ChordWordPair("Test", "Gmaj7");
        pair.setPosition(Position.AFTER);
        ArrayList<String> list = pair.toStringList();
        assertEquals("    Gmaj7", list.get(0));
        assertEquals("Test     ", list.get(1));
    }
    @Test
    void testToStringListAfterShortChord(){
        ChordWordPair pair = new ChordWordPair("Test", "G");
        pair.setPosition(Position.AFTER);
        ArrayList<String> list = pair.toStringList();
        assertEquals("    G", list.get(0));
        assertEquals("Test ", list.get(1));
    }
    @Test
    void testToStringListAfterChordNull(){
        ChordWordPair pair = new ChordWordPair("Test");
        pair.setPosition(Position.AFTER);
        ArrayList<String> list = pair.toStringList();
        assertEquals("    ", list.get(0));
        assertEquals("Test", list.get(1));
    }
    @Test
    void testToStringListBeforeChordNull(){
        ChordWordPair pair = new ChordWordPair("Test");
        pair.setPosition(Position.BEFORE);
        ArrayList<String> list = pair.toStringList();
        assertEquals("    ", list.get(0));
        assertEquals("Test", list.get(1));
    }
    @Test
    void testToStringListIndexShortChord(){
        ChordWordPair pair = new ChordWordPair("Test", "G");
        pair.setIndex(1);
        ArrayList<String> list = pair.toStringList();
        assertEquals(" G  ", list.get(0));
        assertEquals("Test", list.get(1));
    }
    @Test
    void testToStringListLongIndex(){
        ChordWordPair pair = new ChordWordPair("Test", "G");
        pair.setIndex(6);
        ArrayList<String> list = pair.toStringList();
        assertEquals("      G", list.get(0));
        assertEquals("Test   ", list.get(1));
    }
    @Test
    void testToStringListIndexBefore(){
        ChordWordPair pair = new ChordWordPair("Test", "G");
        pair.setIndex(6);
        pair.setPosition(Position.BEFORE);
        ArrayList<String> list = pair.toStringList();
        assertEquals("G    ", list.get(0));
        assertEquals(" Test", list.get(1));
    }
    @Test
    void testToStringListIndexAfter(){
        ChordWordPair pair = new ChordWordPair("Test", "G");
        pair.setIndex(6);
        pair.setPosition(Position.AFTER);
        ArrayList<String> list = pair.toStringList();
        assertEquals("    G", list.get(0));
        assertEquals("Test ", list.get(1));
    }
    @Test
    void testToStringListIndexChordNull(){
        ChordWordPair pair = new ChordWordPair("Test");
        pair.setIndex(6);
        ArrayList<String> list = pair.toStringList();
        assertEquals("    ", list.get(0));
        assertEquals("Test", list.get(1));
    }
}
