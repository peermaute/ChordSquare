package com.chords.chordsquare;

import com.chords.chordsquare.music.Chord;
import com.chords.chordsquare.structure.ChordWordPairPosition;
import com.chords.chordsquare.structure.Position;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestChordWordPairPosition {
    @Test
    void testToStringListChordNull(){
        ChordWordPairPosition pair = new ChordWordPairPosition("Test");
        ArrayList<String> list = pair.toStringList();
        assertEquals(2, list.size());
        assertEquals("    ", list.get(0));
        assertEquals("Test", list.get(1));
    }
    @Test
    void testToStringListLongerChord(){
        ChordWordPairPosition pair = new ChordWordPairPosition("Test", "Gsus4");
        ArrayList<String> list = pair.toStringList();
        assertEquals("Gsus4", list.get(0));
        assertEquals("Test ", list.get(1));
    }
    @Test
    void testToStringListLongerWord(){
        ChordWordPairPosition pair = new ChordWordPairPosition("Test", "G");
        ArrayList<String> list = pair.toStringList();
        assertEquals("G   ", list.get(0));
        assertEquals("Test", list.get(1));
    }
    @Test
    void testToStringListSameLengthChordWord(){
        ChordWordPairPosition pair = new ChordWordPairPosition("Test", "Gmaj");
        ArrayList<String> list = pair.toStringList();
        assertEquals("Gmaj", list.get(0));
        assertEquals("Test", list.get(1));
    }
    @Test
    void testToStringListWordNull(){
        ChordWordPairPosition pair = new ChordWordPairPosition();
        pair.setChord(new Chord("Gsus4"));
        ArrayList<String> list = pair.toStringList();
        assertEquals("Gsus4", list.get(0));
        assertEquals("     ", list.get(1));
    }
    @Test
    void testToStringListChordAndWordNull(){
        ChordWordPairPosition pair = new ChordWordPairPosition();
        ArrayList<String> list = pair.toStringList();
        assertEquals("", list.get(0));
        assertEquals("", list.get(1));
    }
    @Test
    void testToStringListBefore(){
        ChordWordPairPosition pair = new ChordWordPairPosition("Test", "Gmaj7");
        pair.setPosition(Position.BEFORE);
        ArrayList<String> list = pair.toStringList();
        assertEquals("Gmaj7    ", list.get(0));
        assertEquals("     Test", list.get(1));
    }
    @Test
    void testToStringListBeforeShortChord(){
        ChordWordPairPosition pair = new ChordWordPairPosition("Test", "G");
        pair.setPosition(Position.BEFORE);
        ArrayList<String> list = pair.toStringList();
        assertEquals("G    ", list.get(0));
        assertEquals(" Test", list.get(1));
    }
    @Test
    void testToStringListAfter(){
        ChordWordPairPosition pair = new ChordWordPairPosition("Test", "Gmaj7");
        pair.setPosition(Position.AFTER);
        ArrayList<String> list = pair.toStringList();
        assertEquals("    Gmaj7", list.get(0));
        assertEquals("Test     ", list.get(1));
    }
    @Test
    void testToStringListAfterShortChord(){
        ChordWordPairPosition pair = new ChordWordPairPosition("Test", "G");
        pair.setPosition(Position.AFTER);
        ArrayList<String> list = pair.toStringList();
        assertEquals("    G", list.get(0));
        assertEquals("Test ", list.get(1));
    }
    @Test
    void testToStringListAfterChordNull(){
        ChordWordPairPosition pair = new ChordWordPairPosition("Test");
        pair.setPosition(Position.AFTER);
        ArrayList<String> list = pair.toStringList();
        assertEquals("    ", list.get(0));
        assertEquals("Test", list.get(1));
    }
    @Test
    void testToStringListBeforeChordNull(){
        ChordWordPairPosition pair = new ChordWordPairPosition("Test");
        pair.setPosition(Position.BEFORE);
        ArrayList<String> list = pair.toStringList();
        assertEquals("    ", list.get(0));
        assertEquals("Test", list.get(1));
    }
    @Test
    void testToStringListIndexShortChord(){
        ChordWordPairPosition pair = new ChordWordPairPosition("Test", "G");
        pair.setIndex(1);
        ArrayList<String> list = pair.toStringList();
        assertEquals(" G  ", list.get(0));
        assertEquals("Test", list.get(1));
    }
    @Test
    void testToStringListLongIndex(){
        ChordWordPairPosition pair = new ChordWordPairPosition("Test", "G");
        pair.setIndex(6);
        ArrayList<String> list = pair.toStringList();
        assertEquals("      G", list.get(0));
        assertEquals("Test   ", list.get(1));
    }
    @Test
    void testToStringListIndexBefore(){
        ChordWordPairPosition pair = new ChordWordPairPosition("Test", "G");
        pair.setIndex(6);
        pair.setPosition(Position.BEFORE);
        ArrayList<String> list = pair.toStringList();
        assertEquals("G    ", list.get(0));
        assertEquals(" Test", list.get(1));
    }
    @Test
    void testToStringListIndexAfter(){
        ChordWordPairPosition pair = new ChordWordPairPosition("Test", "G");
        pair.setIndex(6);
        pair.setPosition(Position.AFTER);
        ArrayList<String> list = pair.toStringList();
        assertEquals("    G", list.get(0));
        assertEquals("Test ", list.get(1));
    }
    @Test
    void testToStringListIndexChordNull(){
        ChordWordPairPosition pair = new ChordWordPairPosition("Test");
        pair.setIndex(6);
        ArrayList<String> list = pair.toStringList();
        assertEquals("    ", list.get(0));
        assertEquals("Test", list.get(1));
    }
}
