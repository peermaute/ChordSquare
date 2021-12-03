package com.chords.chordsquare;

import lombok.Data;

@Data
public class ChordWordPair {
    private String word;
    private Chord chord;
    //Over which index of the word appears the chord
    private int index;
    //Is the chord over the word or before or after it
    private Position position;

    public ChordWordPair(String word){
        this.word = word;
        this.position = Position.OVER;
    }
    public ChordWordPair(String word, Chord newChord){
        this.word = word;
        //weird IDE error, if I try to use this.chord "no access" to interface -> no shadowing
        chord = newChord;
        this.position = Position.OVER;
    }

}
