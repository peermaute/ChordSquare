package com.chords.chordsquare.structure;

import com.chords.chordsquare.music.Chord;

import java.util.ArrayList;

public interface ChordWordPair {
    ArrayList<String> toStringList();
    Chord getChord();
}
