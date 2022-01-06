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

    String text;

    ArrayList<ArrayList<ChordWordPair>> staveList;

    public Song(){
        staveList = new ArrayList<>();
    }
    public Song(String id, String name, ArrayList<ArrayList<ChordWordPair>> staveList){
        this.id = id;
        this.name = name;
        this.staveList = staveList;
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
        if(song.getId().equals(this.getId())){
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        String retString = "";
        for(int i = 0; i < staveList.size(); i++){
            String[] staveArray = staveToStringArray(staveList.get(i));
            if(i != 0){
                retString += "\n";
            }
            retString += staveArray[0];
            retString += "\n";
            retString += staveArray[1];
        }
        return retString;
    }

    private String[] staveToStringArray(ArrayList<ChordWordPair> stave){
        String[] retArray = new String[2];
        retArray[0] = "";
        retArray[1] = "";
        for(int i = 0; i < stave.size(); i++){
            ArrayList<String> pairString = stave.get(i).toStringList();
            if(i != 0){
                retArray[0] = retArray[0] + " ";
                retArray[1] = retArray[1] + " ";
            }
            retArray[0] = retArray[0] + pairString.get(0);
            retArray[1] = retArray[1] + pairString.get(1);
        }
        return retArray;
    }

    /*private String oldToString(){
        String returnVal = "";
        for(ArrayList<ChordWordPair> curStave: staveList){
            String firstLine = "";
            String secondLine = "";
            for(ChordWordPair pair: curStave){
                if(pair.getChord() == null || pair.getChord().toString().isEmpty()){
                    if(!firstLine.isEmpty()){
                        firstLine += " ";
                    }
                    for(int i = 0; i < pair.getWord().length(); i++){
                        firstLine += " ";
                    }
                    if(!secondLine.isEmpty()){
                        secondLine += " ";
                    }
                    secondLine += pair.getWord();
                }
                else if(pair.getChord().toString().length() < pair.getWord().length()){
                    if(!firstLine.isEmpty()){
                        firstLine += " ";
                    }
                    firstLine += pair.getChord().toString();
                    for(int i = pair.getChord().toString().length(); i < pair.getWord().length(); i++){
                        firstLine += " ";
                    }
                    if(!secondLine.isEmpty()){
                        secondLine += " ";
                    }
                    secondLine += pair.getWord();
                }
                else if(pair.getChord().toString().length() > pair.getWord().length()){
                    if(!firstLine.isEmpty()){
                        firstLine += " ";
                    }
                    firstLine += pair.getChord().toString();
                    if(!secondLine.isEmpty()){
                        secondLine += " ";
                    }
                    secondLine += pair.getWord();
                    for(int i = pair.getWord().length(); i < pair.getChord().toString().length(); i++){
                        secondLine += " ";
                    }
                }
                else if(pair.getChord().toString().length() == pair.getWord().length()){
                    if(!firstLine.isEmpty()){
                        firstLine += " ";
                    }
                    if(!secondLine.isEmpty()){
                        secondLine += " ";
                    }
                    firstLine += pair.getChord().toString();
                    secondLine += pair.getWord();
                }
            }
            returnVal += "\n" + firstLine;
            returnVal += "\n" + secondLine;
        }
        return returnVal;
    }*/
}
