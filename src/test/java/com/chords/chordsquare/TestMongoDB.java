package com.chords.chordsquare;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestMongoDB {
    @Autowired
    SongRepository songRepository;


    @Test
    void testCreateAndDeleteSong(){
        Song song = new Song();
        assertNull(song.getId());
        songRepository.save(song);
        assertTrue(songRepository.findById(song.getId()).isPresent());
        songRepository.delete(song);
        assertFalse(songRepository.findById(song.getId()).isPresent());
    }

}
