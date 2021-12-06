package com.chords.chordsquare;

import lombok.Data;

@Data
public class Chord {

    private String addition;
    private Note note;
    
    public Chord(String chordString){
        if(chordString == null || chordString.isEmpty()){
            throw new IllegalArgumentException("Argument must not be null or empty");
        }
        initialize(chordString);
    }

    public void higherKey(){
        note.higherKey();
    }
    public void lowerKey(){
        note.lowerKey();
    }
    private void initialize(String chordString){
        if(chordString == null || chordString.isEmpty()){
            throw new IllegalArgumentException("Argument must not be null or empty");
        }
        if(chordString.length() == 1){
            note = new Note(chordString);
        }
        else {
            boolean isAltered = chordString.charAt(1) == 'b' || chordString.charAt(1) == '#';
            if(chordString.length() == 2 && isAltered){
                note = new Note(chordString);
            }
            if(chordString.length() == 2 && !isAltered){
                note = new Note(chordString.substring(0,1));
                addition = chordString.substring(1);
            }
            if(chordString.length() > 2 && isAltered){
                note = new Note(chordString.substring(0,2));
                addition = chordString.substring(2);
            }
            if(chordString.length() > 2 && !isAltered){
                note = new Note(chordString.substring(0,1));
                addition = chordString.substring(1);
            }
        }
        if(addition == null){
            addition = "";
        }
    }
    @Override
    public String toString(){
        return note.toString() + addition;
    }
}
