package com.chords.chordsquare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SongService {

    @Autowired
    TextConverter textConverter;

    @Autowired
    SongRepository songRepository;

    public ResponseEntity<String> newSong(Map<String, String> map){
        if (map.get("text") == null && map.get("name") == null) {
            System.out.println("POST Request FAILED: Either text or name has to be set");
            return new ResponseEntity<>("Creation failed, either text or name has to be set", HttpStatus.BAD_REQUEST);
        }
        Song song = new Song();
        if(map.get("text") != null){
            song = textConverter.textToSong(map.get("text"));
        }
        if(map.get("name") != null){
            song.setName(map.get("name"));
        }
        songRepository.save(song);
        if(songRepository.findById(song.getId()).isPresent()){
            System.out.println("POST Request successful: Song created");
            return new ResponseEntity<>("Creation successful", HttpStatus.CREATED);
        }
        System.out.println("POST Request FAILED");
        return new ResponseEntity<>("Creation failed, check logs", HttpStatus.BAD_REQUEST);
    }

}