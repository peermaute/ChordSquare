package com.chords.chordsquare;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestMongoDB {
    @Autowired
    SongRepository songRepository;

    @Test
    void testCreateAndDeleteSong(){
        Song song = new Song();
        song.setId("123");
        String id = song.getId();
        assertFalse(songRepository.findById(id).isPresent());
        songRepository.save(song);
        assertTrue(songRepository.findById(id).isPresent());
        songRepository.delete(song);
        assertFalse(songRepository.findById(id).isPresent());
    }

}
