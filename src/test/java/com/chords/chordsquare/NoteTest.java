package com.chords.chordsquare;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class NoteTest {
    @Test
    void testConstructorUnalteredNote(){
        Note note = new Note("C");
        assertEquals("C", note.toString());
    }
    @Test
    void testConstructorAlteredNoteSharp(){
        Note note = new Note("C#");
        assertEquals("C#", note.toString());
        assertTrue(note.getNoteValue() == NoteValue.C);
        assertTrue(note.getAlteration() == Alteration.SHARP);
    }
    @Test
    void testConstructorAlteredNoteFlat(){
        Note note = new Note("Bb");
        assertEquals("Bb", note.toString());
        assertTrue(note.getNoteValue() == NoteValue.B);
        assertTrue(note.getAlteration() == Alteration.FLAT);
    }
    @Test
    void testConstructorAlteredNoteSpecialCaseCb(){
        Note note = new Note("Cb");
        assertEquals("B", note.toString());
    }
    @Test
    void testConstructorAlteredNoteSpecialCaseFb(){
        Note note = new Note("Fb");
        assertEquals("E", note.toString());
    }
    @Test
    void testConstructorAlteredNoteSpecialCaseBSharp(){
        Note note = new Note("B#");
        assertEquals("C", note.toString());
    }
    @Test
    void testConstructorAlteredNoteSpecialCaseESharp(){
        Note note = new Note("E#");
        assertEquals("F", note.toString());
    }
}
