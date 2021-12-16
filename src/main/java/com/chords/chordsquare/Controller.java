package com.chords.chordsquare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    TextConverter textConverter;

    @Autowired
    SongRepository songRepository;

    @PostMapping(path = "/songs/new")
    public ResponseEntity<String> newSong(@RequestBody String text){
        Song song = textConverter.textToSong(text);
        songRepository.save(song);
        if(songRepository.findById(song.getId()).isPresent()){
            System.out.println("POST Request successful: Song created");
            return new ResponseEntity<>("Creation successful", HttpStatus.CREATED);
        }
        System.out.println("POST Request FAILED");
        return new ResponseEntity<>("Creation failed, check logs", HttpStatus.BAD_REQUEST);
    }
}
