package com.chords.chordsquare.structure;

import com.chords.chordsquare.music.Chord;
import lombok.Data;

@Data
public class ChordWordPair {
    private String word;
    private Chord chord;
    //Over which index of the word appears the chord
    private int index;
    //Is the chord over the word or before or after it
    private Position position;

    public ChordWordPair(){
        this.position = Position.OVER;
    }

    public ChordWordPair(String word){
        this.word = word;
        this.position = Position.OVER;
    }
    public ChordWordPair(String word, String chordString){
        this.word = word;
        this.chord = new Chord(chordString);
        this.position = Position.OVER;
    }
    public ChordWordPair(String word, String chordString, Position position){
        this.word = word;
        this.chord = new Chord(chordString);
        this.position = position;
    }
    public ChordWordPair(String word, String chordString, int index){
        this.word = word;
        this.chord = new Chord(chordString);
        this.index = index;
    }
    public ChordWordPair(String word, String chordString, Position position, int index){
        this.word = word;
        this.chord = new Chord(chordString);
        this.position = position;
        this.index = index;
    }
    public ChordWordPair(String word, Chord chord, Position position, int index){
        this.word = word;
        this.chord = chord;
        this.position = position;
        this.index = index;
    }

}
