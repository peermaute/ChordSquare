package com.chords.chordsquare.structure;

import com.chords.chordsquare.music.Chord;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ChordWordPairPlain implements ChordWordPair{
    private Chord chord;
    private String word;
    public ChordWordPairPlain(){
    }
    public ChordWordPairPlain(String word){
        this.word = word;
    }
    public ChordWordPairPlain(Chord chord){
        this.chord = chord;
    }
    public ChordWordPairPlain(String word, Chord chord){
        this.word = word;
        this.chord = chord;
    }
    public ChordWordPairPlain(String word, String chordString){
        this.word = word;
        this.chord = new Chord(chordString);
    }
    @Override
    public ArrayList<String> toStringList() {
        ArrayList<String> list = new ArrayList<>();
        String[] lines = setLines();
        list.add(lines[0]);
        list.add(lines[1]);
        return list;
    }

    private String[] setLines() {
        String[] lines = new String[2];
        if(chord != null){
            lines[0] = chord.toString();
        }
        else{
            lines[0] = "";
        }
        if(word != null){
            lines[1] = word;
        }
        else{
            lines[1] = "";
        }
        lines = correctLengths(lines);
        return lines;
    }

    private String[] correctLengths(String[] lines) {
        int line0Length = lines[0].length();
        int line1Length = lines[1].length();

        if(line0Length < line1Length){
            for(int i = line0Length; i < line1Length; i++){
                lines[0] += " ";
            }
        }
        if(line1Length < line0Length){
            for(int i = line1Length; i < line0Length; i++){
                lines[1] += " ";
            }
        }
        return lines;
    }
}
