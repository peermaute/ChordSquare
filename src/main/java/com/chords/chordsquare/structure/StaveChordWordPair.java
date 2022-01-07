package com.chords.chordsquare.structure;

import java.util.ArrayList;
//TODO: Tests!!!
public class StaveChordWordPair implements Stave{
    ArrayList<ChordWordPair> pairList;
    public StaveChordWordPair(){
        pairList = new ArrayList<>();
    }
    @Override
    public ArrayList<String> toStringList() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("");
        stringList.add("");
        for(int i = 0; i < pairList.size(); i++){
            ArrayList<String> pairString = pairList.get(i).toStringList();
            if(i != 0){
                stringList.set(0, stringList.get(0) + " ");
                stringList.set(1, stringList.get(1) + " ");
            }
            stringList.set(0, stringList.get(0) + pairString.get(0));
            stringList.set(1, stringList.get(1) + pairString.get(1));
        }
        return stringList;
    }

    @Override
    public void higherKey() {
        for(ChordWordPair curPair: pairList){
            if(curPair.getChord() != null){
                curPair.getChord().higherKey();
            }
        }
    }

    @Override
    public void lowerKey() {
        for(ChordWordPair curPair: pairList){
            if(curPair.getChord() != null){
                curPair.getChord().lowerKey();
            }
        }
    }
}
