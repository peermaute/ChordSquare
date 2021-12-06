package com.chords.chordsquare;

import com.chords.chordsquare.music.Chord;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ChordTest {
    //CONSTRUCTOR
    @Test
    void testChordNoAlterationNoAddition(){
        Chord chord = new Chord("C");
        assertEquals("", chord.getAddition());
        assertEquals("C", chord.getNote().toString());
        assertEquals("C", chord.toString());
    }
    @Test
    void testChordAlterationSharpNoAddition(){
        Chord chord = new Chord("C#");
        assertEquals("", chord.getAddition());
        assertEquals("C#", chord.getNote().toString());
        assertEquals("C#", chord.toString());
    }
    @Test
    void testChordAlterationSharpSpecialNoAddition(){
        Chord chord = new Chord("E#");
        assertEquals("", chord.getAddition());
        assertEquals("F", chord.getNote().toString());
        assertEquals("F", chord.toString());
    }
    @Test
    void testChordAlterationFlatNoAddition(){
        Chord chord = new Chord("Eb");
        assertEquals("", chord.getAddition());
        assertEquals("Eb", chord.getNote().toString());
        assertEquals("Eb", chord.toString());
    }
    @Test
    void testChordAlterationFlatSpecialNoAddition(){
        Chord chord = new Chord("Cb");
        assertEquals("", chord.getAddition());
        assertEquals("B", chord.getNote().toString());
        assertEquals("B", chord.toString());
    }
    @Test
    void testChordNoAlterationWithAddition(){
        Chord chord = new Chord("Cmaj7");
        assertEquals("maj7", chord.getAddition());
        assertEquals("C", chord.getNote().toString());
        assertEquals("Cmaj7", chord.toString());
    }
    @Test
    void testChordAlterationSharpWithAddition(){
        Chord chord = new Chord("C#9");
        assertEquals("9", chord.getAddition());
        assertEquals("C#", chord.getNote().toString());
        assertEquals("C#9", chord.toString());
    }
    @Test
    void testChordAlterationFlatWithAddition(){
        Chord chord = new Chord("Eb7");
        assertEquals("7", chord.getAddition());
        assertEquals("Eb", chord.getNote().toString());
        assertEquals("Eb7", chord.toString());
    }
    @Test
    void testChordAlterationSharpSpecialWithAddition(){
        Chord chord = new Chord("E#7");
        assertEquals("7", chord.getAddition());
        assertEquals("F", chord.getNote().toString());
        assertEquals("F7", chord.toString());
    }
    @Test
    void testChordAlterationFlatSpecialWithAddition(){
        Chord chord = new Chord("Cb9");
        assertEquals("9", chord.getAddition());
        assertEquals("B", chord.getNote().toString());
        assertEquals("B9", chord.toString());
    }
    //TRANSPOSE NO ADDITION
    @Test
    void testHigherKeyNoAlterationNoAddition(){
        Chord chord = new Chord("C");
        chord.higherKey();
        assertEquals("", chord.getAddition());
        assertEquals("C#", chord.getNote().toString());
        assertEquals("C#", chord.toString());
    }
    @Test
    void testHigherKeyWithAlterationSharpNoAddition(){
        Chord chord = new Chord("C#");
        chord.higherKey();
        assertEquals("", chord.getAddition());
        assertEquals("D", chord.getNote().toString());
        assertEquals("D", chord.toString());
    }
    @Test
    void testHigherKeyWithAlterationFlatNoAddition(){
        Chord chord = new Chord("Bb");
        chord.higherKey();
        assertEquals("", chord.getAddition());
        assertEquals("B", chord.getNote().toString());
        assertEquals("B", chord.toString());
    }
    @Test
    void testHigherKeyWithAlterationSharpSpecialNoAddition(){
        Chord chord = new Chord("E#");
        chord.higherKey();
        assertEquals("", chord.getAddition());
        assertEquals("F#", chord.getNote().toString());
        assertEquals("F#", chord.toString());
    }
    @Test
    void testHigherKeyWithAlterationFlatSpecialNoAddition(){
        Chord chord = new Chord("Cb");
        chord.higherKey();
        assertEquals("", chord.getAddition());
        assertEquals("C", chord.getNote().toString());
        assertEquals("C", chord.toString());
    }

    @Test
    void testLowerKeyNoAlterationNoAddition(){
        Chord chord = new Chord("D");
        chord.lowerKey();
        assertEquals("", chord.getAddition());
        assertEquals("Db", chord.getNote().toString());
        assertEquals("Db", chord.toString());
    }
    @Test
    void testLowerKeyWithAlterationSharpNoAddition(){
        Chord chord = new Chord("C#");
        chord.lowerKey();
        assertEquals("", chord.getAddition());
        assertEquals("C", chord.getNote().toString());
        assertEquals("C", chord.toString());
    }
    @Test
    void testLowerKeyWithAlterationFlatNoAddition(){
        Chord chord = new Chord("Bb");
        chord.lowerKey();
        assertEquals("", chord.getAddition());
        assertEquals("A", chord.getNote().toString());
        assertEquals("A", chord.toString());
    }
    @Test
    void testLowerKeyWithAlterationSharpSpecialNoAddition(){
        Chord chord = new Chord("E#");
        chord.lowerKey();
        assertEquals("", chord.getAddition());
        assertEquals("E", chord.getNote().toString());
        assertEquals("E", chord.toString());
    }
    @Test
    void testLowerKeyWithAlterationFlatSpecialNoAddition(){
        Chord chord = new Chord("Cb");
        chord.lowerKey();
        assertEquals("", chord.getAddition());
        assertEquals("Bb", chord.getNote().toString());
        assertEquals("Bb", chord.toString());
    }
    //TRANSPOSE WITH ADDITION
    @Test
    void testHigherKeyNoAlterationWithAddition(){
        Chord chord = new Chord("C9");
        chord.higherKey();
        assertEquals("9", chord.getAddition());
        assertEquals("C#", chord.getNote().toString());
        assertEquals("C#9", chord.toString());
    }
    @Test
    void testHigherKeyWithAlterationSharpWithAddition(){
        Chord chord = new Chord("C#maj7");
        chord.higherKey();
        assertEquals("maj7", chord.getAddition());
        assertEquals("D", chord.getNote().toString());
        assertEquals("Dmaj7", chord.toString());
    }
    @Test
    void testHigherKeyWithAlterationFlatWithAddition(){
        Chord chord = new Chord("Bbsus4");
        chord.higherKey();
        assertEquals("sus4", chord.getAddition());
        assertEquals("B", chord.getNote().toString());
        assertEquals("Bsus4", chord.toString());
    }
    @Test
    void testHigherKeyWithAlterationSharpSpecialWithAddition(){
        Chord chord = new Chord("E#7");
        chord.higherKey();
        assertEquals("7", chord.getAddition());
        assertEquals("F#", chord.getNote().toString());
        assertEquals("F#7", chord.toString());
    }
    @Test
    void testHigherKeyWithAlterationFlatSpecialWithAddition(){
        Chord chord = new Chord("Cb9");
        chord.higherKey();
        assertEquals("9", chord.getAddition());
        assertEquals("C", chord.getNote().toString());
        assertEquals("C9", chord.toString());
    }

    @Test
    void testLowerKeyNoAlterationWithAddition(){
        Chord chord = new Chord("Dsus2");
        chord.lowerKey();
        assertEquals("sus2", chord.getAddition());
        assertEquals("Db", chord.getNote().toString());
        assertEquals("Dbsus2", chord.toString());
    }
    @Test
    void testLowerKeyWithAlterationSharpWithAddition(){
        Chord chord = new Chord("C#7");
        chord.lowerKey();
        assertEquals("7", chord.getAddition());
        assertEquals("C", chord.getNote().toString());
        assertEquals("C7", chord.toString());
    }
    @Test
    void testLowerKeyWithAlterationFlatWithAddition(){
        Chord chord = new Chord("Bbadd9");
        chord.lowerKey();
        assertEquals("add9", chord.getAddition());
        assertEquals("A", chord.getNote().toString());
        assertEquals("Aadd9", chord.toString());
    }
    @Test
    void testLowerKeyWithAlterationSharpSpecialWithAddition(){
        Chord chord = new Chord("E#7");
        chord.lowerKey();
        assertEquals("7", chord.getAddition());
        assertEquals("E", chord.getNote().toString());
        assertEquals("E7", chord.toString());
    }
    @Test
    void testLowerKeyWithAlterationFlatSpecialWithAddition(){
        Chord chord = new Chord("Cb9");
        chord.lowerKey();
        assertEquals("9", chord.getAddition());
        assertEquals("Bb", chord.getNote().toString());
        assertEquals("Bb9", chord.toString());
    }
}
