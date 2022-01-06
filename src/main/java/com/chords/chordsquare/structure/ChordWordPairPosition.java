package com.chords.chordsquare.structure;

import com.chords.chordsquare.music.Chord;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ChordWordPairPosition implements ChordWordPair{
    private String word;
    private Chord chord;
    //Over which index of the word appears the chord
    private int index;
    //Is the chord over the word or before or after it
    private Position position;

    public ChordWordPairPosition(){
        this.position = Position.OVER;
    }

    public ChordWordPairPosition(String word){
        this.word = word;
        this.position = Position.OVER;
    }
    public ChordWordPairPosition(String word, String chordString){
        this.word = word;
        this.chord = new Chord(chordString);
        this.position = Position.OVER;
    }
    public ChordWordPairPosition(String word, String chordString, Position position){
        this.word = word;
        this.chord = new Chord(chordString);
        this.position = position;
    }
    public ChordWordPairPosition(String word, String chordString, int index){
        this.word = word;
        this.chord = new Chord(chordString);
        this.index = index;
    }
    public ChordWordPairPosition(String word, String chordString, Position position, int index){
        this.word = word;
        this.chord = new Chord(chordString);
        this.position = position;
        this.index = index;
    }
    public ChordWordPairPosition(String word, Chord chord, Position position, int index){
        this.word = word;
        this.chord = chord;
        this.position = position;
        this.index = index;
    }
    public ArrayList<String> toStringList(){
        ArrayList<String> list = new ArrayList<>();
        String line1 = "";
        String line2 = "";
        if(chord != null){
            line1 = chord.toString();
        }
        if(word != null){
            line2 = word;
        }
        if(word != null && chord != null){
            int length1 = line1.length();
            int length2 = line2.length();
            if(position != Position.OVER){
                if(position == Position.BEFORE){
                    for(int i = 0; i < chord.toString().length(); i++){
                        line2 = " " + line2;
                    }
                    for(int i = 0; i < length2 - length1; i++){
                        line1 += " ";
                    }
                }
                if(position ==  Position.AFTER){
                    for(int i = 0; i < word.length(); i++){
                        line1 = " " + line1;
                    }
                    for(int i = 0; i < length1 - length2; i++){
                        line2 += " ";
                    }
                }
            }
            else{
                if(index != 0){
                    for(int i = 0; i < index; i++){
                        line1 = " " + line1;
                    }
                }
            }
            length1 = line1.length();
            length2 = line2.length();
            if(length1 > length2){
                for(int i = 0; i < length1 - length2; i++){
                    line2 += " ";
                }
            }
            if(length2 > length1){
                for(int i = 0; i < length2 - length1; i++){
                    line1 += " ";
                }
            }
        }
        else if(chord == null && word != null){
            for(int i = 0; i < word.length(); i++){
                line1 += " ";
            }
        }
        else if(chord != null && word == null){
            for(int i = 0; i < chord.toString().length(); i++){
                line2 += " ";
            }
        }
        list.add(line1);
        list.add(line2);
        return list;
    }
    public void setIndex(int index){
        if(index < 0){
            throw new IllegalArgumentException("Index must not be negative");
        }
        this.index = index;
    }
}
