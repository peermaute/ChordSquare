package com.chords.chordsquare;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestSongService {

    @Autowired
    SongRepository songRepository;

    @Autowired
    SongService songService;

    @Test
    void testNewSong(){
        Map<String, String> map = new HashMap<>();
        String name = "TestSong";
        map.put("name", name);
        ArrayList<Song> list = songRepository.findByName(name);
        songService.newSong(map);
        ArrayList<Song> list2 = songRepository.findByName(name);
        assertEquals(list.size() + 1, list2.size());
        Song song = list2.get(list.size());
        assertEquals(song.getName(), name);
        songRepository.delete(song);
        ArrayList<Song> list3 = songRepository.findByName(name);
        assertEquals(list.size(), list3.size());
    }
    @Test
    void testDeleteSong(){
        Song song = new Song();
        songRepository.save(song);
        assertTrue(songRepository.findById(song.getId()).isPresent());
        songService.deleteSong(song.getId());
        assertFalse(songRepository.findById(song.getId()).isPresent());
    }
    @Test
    void testUpdate(){
        Song song = new Song();
        songRepository.save(song);
        assertTrue(songRepository.findById(song.getId()).isPresent());
        assertNull(songRepository.findById(song.getId()).get().getName());
        song.setName("TestSong");
        assertNull(songRepository.findById(song.getId()).get().getName());
        songService.updateSong(song);
        assertEquals("TestSong", songRepository.findById(song.getId()).get().getName());
        songRepository.delete(song);
        assertFalse(songRepository.findById(song.getId()).isPresent());
    }
    @Test
    void testGetSong(){
        Song song = new Song();
        songRepository.save(song);
        assertTrue(songRepository.findById(song.getId()).isPresent());
        assertEquals(song, songService.getSong(song.getId()));
        songRepository.delete(song);
        assertFalse(songRepository.findById(song.getId()).isPresent());
    }
    @Test
    void testGetSongsByName(){
        Song song = new Song();
        String name = "TestSong";
        song.setName(name);
        ArrayList<Song> list = songService.getSongsByName(name);
        songRepository.save(song);
        assertTrue(songRepository.findById(song.getId()).isPresent());
        ArrayList<Song> list2 = songService.getSongsByName(name);
        assertEquals(list.size() + 1, list2.size());
        songRepository.delete(song);
        ArrayList<Song> list3 = songService.getSongsByName(name);
        assertEquals(list.size(), list3.size());
    }
}
