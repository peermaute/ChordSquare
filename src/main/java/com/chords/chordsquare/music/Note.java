package com.chords.chordsquare.music;

public class Note {
    private boolean altered;
    private NoteValue noteValue;
    private Alteration alteration;

    public Note(){

    }

    public Note(String noteAsString){
        if(noteAsString == null){
            throw new IllegalArgumentException("Argument must not be null");
        }
        if(noteAsString.length() < 1 || noteAsString.length() > 2){
            throw new IllegalArgumentException("Length of String has to be either 1 or 2");
        }
        if(noteAsString.length() == 1){
            alteration = Alteration.NONE;
            noteValue = charToNoteValue(noteAsString.charAt(0));
        }
        if(noteAsString.length() == 2){
            altered = true;
            alteration = charToAlteration(noteAsString.charAt(1));
            noteValue = charToNoteValue(noteAsString.charAt(0));
            correctAlterationSpecialCase();
        }
    }
    //higherKey(): when not altered, just alter unless it's e or b
    //lowerKey(): when not altered, just alter unless it's c or f
    //higherKey(): when altered, just deAlter
    //lowerKey(): when altered, just deAlter
    public void higherKey(){
        if(altered){
            if(alteration == Alteration.SHARP){
                noteValue = noteValue.next();
            }
           altered = false;
           alteration = Alteration.NONE;
        }
        else{
            if(noteValue == NoteValue.E || noteValue == NoteValue.B){
                noteValue = noteValue.next();
            }
            else{
                altered = true;
                alteration = Alteration.SHARP;
            }
        }
    }
    public void lowerKey(){
        if(altered){
            if(alteration == Alteration.FLAT){
                noteValue = noteValue.previous();
            }
            altered = false;
            alteration = Alteration.NONE;
        }
        else{
            if(noteValue == NoteValue.C || noteValue == NoteValue.F){
                noteValue = noteValue.previous();
            }
            else{
                altered = true;
                alteration = Alteration.FLAT;
            }
        }
    }
    /**
     * Corrects a possible Note Cb, Fb, E# or B# to B, E, F or C
     */
    private void correctAlterationSpecialCase(){
        if(alteration == Alteration.FLAT){
            if(noteValue == NoteValue.C){
                altered = false;
                alteration = Alteration.NONE;
                noteValue = NoteValue.B;
            }
            if(noteValue == NoteValue.F){
                altered = false;
                alteration = Alteration.NONE;
                noteValue = NoteValue.E;
            }
        }
        if(alteration == Alteration.SHARP){
            if(noteValue == NoteValue.E){
                altered = false;
                alteration = Alteration.NONE;
                noteValue = NoteValue.F;
            }
            if(noteValue == NoteValue.B){
                altered = false;
                alteration = Alteration.NONE;
                noteValue = NoteValue.C;
            }
        }
    }
    private NoteValue charToNoteValue(char noteAsChar){
        switch (noteAsChar){
            case 'C':
                return NoteValue.C;
            case 'D':
                return NoteValue.D;
            case 'E':
                return NoteValue.E;
            case 'F':
                return NoteValue.F;
            case 'G':
                return NoteValue.G;
            case 'A':
                return NoteValue.A;
            case 'B':
                //For german notation
            case 'H':
                return NoteValue.B;
            default:
                throw new IllegalArgumentException("Argument is not a Note");
        }
    }
    private Alteration charToAlteration(char alterationAsChar){
        switch (alterationAsChar){
            case 'b':
                return Alteration.FLAT;
            case '#':
                return Alteration.SHARP;
            default:
                throw new IllegalArgumentException("Argument is not an Alteration");
        }
    }
    @Override
    public String toString(){
        if(altered){
            if(alteration == Alteration.FLAT){
                return noteValue.toString() + 'b';
            }
            return noteValue.toString() + '#';
        }
        return noteValue.toString();
    }

    public boolean isAltered() {
        return altered;
    }

    public NoteValue getNoteValue() {
        return noteValue;
    }

    public Alteration getAlteration() {
        return alteration;
    }
}
