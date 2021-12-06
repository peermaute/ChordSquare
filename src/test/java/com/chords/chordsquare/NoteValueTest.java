package com.chords.chordsquare;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class NoteValueTest {
    @Test
    void testPrevious(){
        NoteValue noteValue = NoteValue.E;
        noteValue = noteValue.previous();
        assertFalse(noteValue.toString().equals("E"));
        assertEquals("D", noteValue.toString());
    }
    @Test
    void testPreviousModulo(){
        NoteValue noteValue = NoteValue.C;
        noteValue = noteValue.previous();
        assertFalse(noteValue.toString().equals("C"));
        assertEquals("B", noteValue.toString());
    }
    @Test
    void testPreviousMultiple(){
        NoteValue noteValue = NoteValue.F;
        noteValue = noteValue.previous();
        noteValue = noteValue.previous();
        noteValue = noteValue.previous();
        assertFalse(noteValue.toString().equals("F"));
        assertEquals("C", noteValue.toString());
    }
    @Test
    void testNext(){
        NoteValue noteValue = NoteValue.C;
        noteValue = noteValue.next();
        assertFalse(noteValue.toString().equals("C"));
        assertEquals("D", noteValue.toString());
    }
    @Test
    void testNextModulo(){
        NoteValue noteValue = NoteValue.B;
        noteValue = noteValue.next();
        assertFalse(noteValue.toString().equals("B"));
        assertEquals("C", noteValue.toString());
    }
    @Test
    void testNextMultiple(){
        NoteValue noteValue = NoteValue.C;
        noteValue = noteValue.next();
        noteValue = noteValue.next();
        noteValue = noteValue.next();
        assertFalse(noteValue.toString().equals("C"));
        assertEquals("F", noteValue.toString());
    }

}
