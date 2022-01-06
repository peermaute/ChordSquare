package com.chords.chordsquare.structure;

import java.util.ArrayList;

//TODO: staveList in Song as list of Stave. Implementations of Stave: StaveChordWordPair, StavePlain
public interface Stave {
    ArrayList<String> toStringList();
    void higherKey();
    void lowerKey();
}
