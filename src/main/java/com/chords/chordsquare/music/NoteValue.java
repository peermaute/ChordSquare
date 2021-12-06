package com.chords.chordsquare.music;

public enum NoteValue {
    C,D,E,F,G,A,B;

    static public final NoteValue[] values = values();

    public NoteValue previous(){
        //Additional ( + values.length) added because modulo operator can return negative numbers in Java.
        return values[(ordinal() -1 + values.length) % values.length];
    }
    public NoteValue next(){
        return values[(ordinal() + 1) % values.length];
    }
}
