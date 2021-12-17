package com.chords.chordsquare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {
    @Autowired
    TextConverter textConverter;

    @Autowired
    SongRepository songRepository;

    @Autowired
    SongService songService;

    @PostMapping(path = "/songs/new")
    public ResponseEntity<String> newSong(@RequestBody Map<String,String> map){
        return songService.newSong(map);
    }
}
