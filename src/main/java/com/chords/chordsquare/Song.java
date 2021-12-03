package com.chords.chordsquare;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

@Data
public class Song {
    @Id
    long id;

    String name;

    ArrayList<ArrayList<ChordWordPair>> staveList;

    @Override
    public boolean equals(Object obj){
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Song song = (Song) obj;
        if(song.getId() == this.getId()){
            return true;
        }
        return false;
    }


}
