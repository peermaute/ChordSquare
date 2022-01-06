package com.chords.chordsquare;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TextConverterTest {
    @Test
    void testTextToSong(){
        TextConverter textConverter = new TextConverter();
        String text = "Happy[C,0,1] Birthday to[G,0,0] you\nHappy Birthday to[C] you\nHappy Birthday dear Elsie[F]\nHappy Birthday[C] to[G] you[C]";
        Song song = textConverter.textToSongPosition(text);
        System.out.println("*****************");
        System.out.println(song);
        System.out.println("*****************");
    }
}
