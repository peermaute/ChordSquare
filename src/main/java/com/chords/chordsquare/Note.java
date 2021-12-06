package com.chords.chordsquare;

public class Note {
    private boolean altered;
    private NoteValue noteValue;
    //higherKey(): when not altered, just alter unless it's e or b
    //lowerKey(): when not altered, just alter unless it's c or f
    //higherKey(): when altered, just deAlter
    //lowerKey(): when altered, just deAlter
}
