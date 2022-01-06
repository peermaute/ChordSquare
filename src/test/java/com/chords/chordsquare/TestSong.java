package com.chords.chordsquare;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestSong {
    @Autowired
    TextConverter textConverter;
    @Test
    void testToString(){
        String text = "Happy[C,0,1] Birthday to[G,0,0] you\nHappy Birthday to[C] you";
        Song song = textConverter.textToSongPosition(text);
        String songToString = song.toString();
        assertEquals("     C          G     \nHappy  Birthday to you\n               C     \nHappy Birthday to you", songToString);
    }
}
