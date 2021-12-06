package com.chords.chordsquare;

import com.chords.chordsquare.structure.ChordWordPair;
import lombok.Setter;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;


@Setter
@Getter
public class Song {
    @Id
    String id;

    String name;

    ArrayList<ArrayList<ChordWordPair>> staveList;
    public Song(){
        staveList = new ArrayList<>();
    }
    public Song(String id, String name, ArrayList<ArrayList<ChordWordPair>> staveList){
        this.id = id;
        this.name = name;
        this. staveList = staveList;
    }
    public void higherKey(){
        for(ArrayList<ChordWordPair> pairList: staveList){
            for(ChordWordPair pair: pairList){
                if(pair.getChord() != null){
                    pair.getChord().higherKey();
                }
            }
        }
    }
    public void lowerKey(){
        for(ArrayList<ChordWordPair> pairList: staveList){
            for(ChordWordPair pair: pairList){
                if(pair.getChord() != null) {
                    pair.getChord().lowerKey();
                }
            }
        }
    }

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
    @Override
    public String toString(){
        //TODO: Not quite working - look at TextConverterTest for an example
        String returnVal = "";
        for(ArrayList<ChordWordPair> curStave: staveList){
            String firstLine = "";
            String secondLine = "";
            for(ChordWordPair pair: curStave){
                if(pair.getChord() == null || pair.getChord().toString().isEmpty()){
                    for(int i = 0; i < pair.getWord().length(); i++){
                        firstLine += " ";
                    }
                    secondLine += " " + pair.getWord();
                }
                else if(pair.getChord().toString().length() < pair.getWord().length()){
                    firstLine += " " + pair.getChord().toString();
                    for(int i = pair.getChord().toString().length(); i < pair.getWord().length(); i++){
                        firstLine += " ";
                    }
                    secondLine += " " + pair.getWord();
                }
                else if(pair.getChord().toString().length() > pair.getWord().length()){
                    firstLine += " " + pair.getChord().toString();
                    secondLine += " " + pair.getWord();
                    for(int i = pair.getWord().length(); i < pair.getChord().toString().length(); i++){
                        secondLine += " ";
                    }
                }
                else if(pair.getChord().toString().length() == pair.getWord().length()){
                    firstLine += " " + pair.getChord().toString();
                    secondLine += " " + pair.getWord();
                }
            }
            returnVal += "\n" + firstLine;
            returnVal += "\n" + secondLine;
        }
        return returnVal;
    }

}
