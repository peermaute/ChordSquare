package com.chords.chordsquare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
//TODO: Block requests with wrong format (f.e. get request to put mapping)
@CrossOrigin("*")
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
        if(songService.newSong(map)){
            return new ResponseEntity<>("Creation successful", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Creation failed, check logs", HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping(path = "/songs/delete")
    public ResponseEntity<String> deleteSong(@RequestBody String songId){
        if(songService.deleteSong(songId)){
            return new ResponseEntity<>("Deletion successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Deletion failed, check logs", HttpStatus.BAD_REQUEST);
    }
    @PutMapping(path = "/songs/update")
    public ResponseEntity<String> updateSong(@RequestBody Song song){
        if(songService.updateSong(song)){
            return new ResponseEntity<>("Update successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Update failed, check logs", HttpStatus.BAD_REQUEST);
    }
    @GetMapping(path = "/songs", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getSongs(){
        ArrayList<Song> songList = songService.getAllSongs();
        if(songList != null){
            return new ResponseEntity<>(songList, HttpStatus.OK);
        }
        return new ResponseEntity<>("GET Request failed, check logs", HttpStatus.BAD_REQUEST);
    }
    @GetMapping(path = "songs/{songId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getSong(@PathVariable String songId){
        try{
            return new ResponseEntity<>(songService.getSong(songId), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("GET Request failed, check logs", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(path = "songs/name", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getSongsByName(@RequestBody String name){
        try{
            return new ResponseEntity<>(songService.getSongsByName(name), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("GET Request failed, check logs", HttpStatus.BAD_REQUEST);
        }
    }
}
