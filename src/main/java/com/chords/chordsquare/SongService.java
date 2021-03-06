package com.chords.chordsquare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class SongService {

    @Autowired
    TextConverter textConverter;

    @Autowired
    SongRepository songRepository;

    //TODO: Decide between textToSongPosition() and textToSongPlain()
    public boolean newSong(Map<String, String> map){
        if(map == null){
            throw new IllegalArgumentException("Argument must not be null");
        }
        if (map.get("text") == null && map.get("name") == null) {
            System.out.println(System.currentTimeMillis() + "   " +  "POST Request FAILED: Either text or name has to be set");
            return false;
        }
        Song song = new Song();
        if(map.get("text") != null){
            song = textConverter.textToSongPosition(map.get("text"));
        }
        if(map.get("name") != null){
            song.setName(map.get("name"));
        }
        songRepository.save(song);
        if(songRepository.findById(song.getId()).isPresent()){
            System.out.println(System.currentTimeMillis() + "   " +  "POST Request successful: Song created");
            return true;
        }
        System.out.println(System.currentTimeMillis() + "   " +  "POST Request FAILED");
        return false;
    }
    public boolean deleteSong(String songId){
        if(songId == null){
            throw new IllegalArgumentException("songId must not be null");
        }
        if(!songRepository.findById(songId).isPresent()){
            System.out.println(System.currentTimeMillis() + "   " +  "DELETE Request FAILED: No song with the given songId in the repository");
            return false;
        }
        songRepository.delete(songRepository.findById(songId).get());
        if(songRepository.findById(songId).isPresent()){
            System.out.println(System.currentTimeMillis() + "   " +  "DELETE Request FAILED");
            return false;
        }
        return true;
    }
    public boolean updateSong(Song song){
        if(song == null){
            throw new IllegalArgumentException("Song must not be null");
        }
        if(song.getId() == null){
            throw new IllegalArgumentException("Song ID must not be null");
        }
        if(!songRepository.findById(song.getId()).isPresent()){
            System.out.println(System.currentTimeMillis() + "   " +  "PUT Request FAILED: No song with the given songId in the repository");
            return false;
        }
        Song updSong = songRepository.findById(song.getId()).get();
        if(song.getStaveList() != null && !song.getStaveList().isEmpty()){
            updSong.setStaveList(song.getStaveList());
        }
        if(song.getName() != null && !song.getName().equals(updSong.getName())){
            updSong.setName(song.getName());
        }
        try{
            songRepository.save(updSong);
        }
        catch (Exception e){
            System.out.println(System.currentTimeMillis() + "   " +  "PUT Request FAILED");
            e.printStackTrace();
            return false;
        }
        System.out.println(System.currentTimeMillis() + "   " +  "PUT Request SUCCESSFUL: Song " + updSong.getId() + " updated");
        return true;
    }
    public ArrayList<Song> getAllSongs(){
        try{
            ArrayList<Song> songList = new ArrayList<>();
            songList.addAll(songRepository.findAll());
            System.out.println(System.currentTimeMillis() + "   " +  "GET Request successful");
            for(Song song: songList){
                song.setText(song.toString());
            }
            return songList;
        }
        catch (Exception e){
            System.out.println(System.currentTimeMillis() + "   " +  "GET Request FAILED");
            throw e;
        }
    }
    public Song getSong(String songId){
        if(songId == null){
            throw new IllegalArgumentException("songId must not be null");
        }
        if(!songRepository.findById(songId).isPresent()){
            System.out.println(System.currentTimeMillis() + "   " +  "GET Request FAILED: No song with the given songId in the repository");
            throw new IllegalArgumentException("No song with the given songId in the repository");
        }
        Song song = songRepository.findById(songId).get();
        System.out.println(System.currentTimeMillis() + "   " +  "GET Request successful");
        song.setText(song.toString());
        return song;
    }
    public ArrayList<Song> getSongsByName(String name){
        if(name == null){
            throw new IllegalArgumentException("Name must not be null");
        }
        try{
            ArrayList<Song> songList = new ArrayList<>();
            songList.addAll(songRepository.findByName(name));
            System.out.println(System.currentTimeMillis() + "   " +  "GET Request successful");
            for(Song song: songList){
                song.setText(song.toString());
            }
            return songList;
        }
        catch (Exception e){
            System.out.println(System.currentTimeMillis() + "   " +  "GET Request FAILED");
            throw e;
        }
    }
}
