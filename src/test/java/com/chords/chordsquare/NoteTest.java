package com.chords.chordsquare;

import com.chords.chordsquare.music.Alteration;
import com.chords.chordsquare.music.Note;
import com.chords.chordsquare.music.NoteValue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NoteTest {
    //CONSTRUCTOR TESTS
    @Test
    void testConstructorUnalteredNote(){
        Note note = new Note("C");
        assertEquals("C", note.toString());
    }
    @Test
    void testConstructorGermanB(){
        Note note = new Note("H");
        assertEquals("B", note.toString());
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
    //TRANSPOSE TESTS
    @Test
    void testHigherKeyUnalteredNote(){
        Note note = new Note("D");
        note.higherKey();
        assertTrue(note.getNoteValue() == NoteValue.D);
        assertTrue(note.getAlteration() == Alteration.SHARP);
        assertTrue(note.isAltered());
    }
    @Test
    void testHigherKeyUnalteredNoteE(){
        Note note = new Note("E");
        note.higherKey();
        assertTrue(note.getNoteValue() == NoteValue.F);
        assertTrue(note.getAlteration() == Alteration.NONE);
        assertTrue(!note.isAltered());
    }
    @Test
    void testHigherKeyAlteredNoteSharp(){
        Note note = new Note("C#");
        note.higherKey();
        assertTrue(note.getNoteValue() == NoteValue.D);
        assertTrue(note.getAlteration() == Alteration.NONE);
        assertTrue(!note.isAltered());
    }
    @Test
    void testHigherKeyAlteredNoteFlat(){
        Note note = new Note("Bb");
        note.higherKey();
        assertTrue(note.getNoteValue() == NoteValue.B);
        assertTrue(note.getAlteration() == Alteration.NONE);
        assertFalse(note.isAltered());
    }

    @Test
    void testLowerKeyUnalteredNote(){
        Note note = new Note("D");
        note.lowerKey();
        assertTrue(note.getNoteValue() == NoteValue.D);
        assertTrue(note.getAlteration() == Alteration.FLAT);
        assertTrue(note.isAltered());
    }
    @Test
    void testLowerKeyUnalteredNoteF(){
        Note note = new Note("F");
        note.lowerKey();
        assertTrue(note.getNoteValue() == NoteValue.E);
        assertTrue(note.getAlteration() == Alteration.NONE);
        assertFalse(note.isAltered());
    }
    @Test
    void testLowerKeyAlteredNoteSharp(){
        Note note = new Note("C#");
        note.lowerKey();
        assertTrue(note.getNoteValue() == NoteValue.C);
        assertTrue(note.getAlteration() == Alteration.NONE);
        assertFalse(note.isAltered());
    }
    @Test
    void testLowerKeyAlteredNoteFlat(){
        Note note = new Note("Bb");
        note.lowerKey();
        assertTrue(note.getNoteValue() == NoteValue.A);
        assertTrue(note.getAlteration() == Alteration.NONE);
        assertFalse(note.isAltered());
    }
}
