package com.chords.chordsquare;

import com.chords.chordsquare.music.Chord;
import com.chords.chordsquare.structure.ChordWordPairPlain;
import com.chords.chordsquare.structure.ChordWordPairPosition;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestChordWordPairPlain {
    @Test
    void testToStringListChordNull(){
        ChordWordPairPlain pair = new ChordWordPairPlain("Test");
        ArrayList<String> list = pair.toStringList();
        assertEquals(2, list.size());
        assertEquals("    ", list.get(0));
        assertEquals("Test", list.get(1));
    }
    @Test
    void testToStringListLongerChord(){
        ChordWordPairPlain pair = new ChordWordPairPlain("Test", "Gsus4");
        ArrayList<String> list = pair.toStringList();
        assertEquals("Gsus4", list.get(0));
        assertEquals("Test ", list.get(1));
    }
    @Test
    void testToStringListLongerWord(){
        ChordWordPairPlain pair = new ChordWordPairPlain("Test", "G");
        ArrayList<String> list = pair.toStringList();
        assertEquals("G   ", list.get(0));
        assertEquals("Test", list.get(1));
    }
    @Test
    void testToStringListSameLengthChordWord(){
        ChordWordPairPlain pair = new ChordWordPairPlain("Test", "Gmaj");
        ArrayList<String> list = pair.toStringList();
        assertEquals("Gmaj", list.get(0));
        assertEquals("Test", list.get(1));
    }
    @Test
    void testToStringListWordNull(){
        ChordWordPairPlain pair = new ChordWordPairPlain(new Chord("Gsus4"));
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
}
