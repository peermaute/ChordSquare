package com.chords.chordsquare;

import com.chords.chordsquare.music.Chord;
import com.chords.chordsquare.structure.ChordWordPair;
import com.chords.chordsquare.structure.Position;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Converts texts in the given format to a Song.
 * Format:
 * Every word either has a chord associated with it or not. Either way it is symbolised by a ChordWordPair with chord==null if it has no chord.
 * If you want to associate a chord, you have to use the following format [chord symbol, index, position (-1 for before, 0 for over and 1 for after)]
 *
 * Example:
 *
 *      C         G
 * Happy Birthday to you
 *
 * Translates to:
 * Happy[C,0,1] Birthday to[G,0,0] you
 *
 * If you want a chord to be above the word at index 0 you can also jsut write the chord symbol
 */
@Service
public class TextConverter {
    //TODO: You have to put a space or new line after each word (no comma for example) -> maybe fix?
    public Song textToSong(String text){
        Song song = new Song();
        String[] lines = text.split("\\r?\\n");
        for(String line: lines){
            String[] wordChordPairs = line.split(" ");
            ArrayList<ChordWordPair> chordWordLine = new ArrayList<>();
            int counter = 1;
            for(String pair: wordChordPairs){
                ChordWordPair chordWordPair;
                if(!pair.contains("[")){
                    chordWordPair = new ChordWordPair(pair);
                }
                else{
                    int index = pair.indexOf("[");
                    String chordString = pair.substring(index);
                    //Cut Braces
                    chordString = chordString.substring(1, chordString.length()-1);
                    String[] chordParams = chordString.split(",");
                    if(!(chordParams.length == 1 || chordParams.length == 3)){
                        throw new IllegalArgumentException("Given text contains bad formatted chords at line " + counter);
                    }
                    Chord chord = new Chord(chordParams[0]);
                    String word = pair.substring(0, index);
                    chordWordPair = new ChordWordPair(word);
                    chordWordPair.setChord(chord);
                    if(chordParams.length == 3){
                        chordWordPair.setIndex(Integer.parseInt(chordParams[1]));
                        switch(Integer.parseInt(chordParams[2])){
                            case -1:
                                chordWordPair.setPosition(Position.BEFORE);
                                break;
                            case 0:
                                chordWordPair.setPosition(Position.OVER);
                                break;
                            case 1:
                                chordWordPair.setPosition(Position.AFTER);
                                break;
                        }
                    }

                }
                chordWordLine.add(chordWordPair);
            }
            song.getStaveList().add(chordWordLine);
            counter++;
        }
        return song;
    }
}
