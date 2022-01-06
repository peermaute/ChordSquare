package com.chords.chordsquare;

import com.chords.chordsquare.structure.ChordWordPairPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication
public class ChordSquareApplication implements CommandLineRunner {

    @Autowired
    SongRepository songRepository;


    public static void main(String[] args) {
        SpringApplication.run(ChordSquareApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
    private void initiate(){
    /*

        Song song = new Song();
        song.setName("Happy Birthday");
        ArrayList<ChordWordPairPosition> stave = new ArrayList<>();

        ChordWordPairPosition pair = new ChordWordPairPosition("Happy", "D");
        ChordWordPairPosition pair2 = new ChordWordPairPosition("Birthday");
        ChordWordPairPosition pair3 = new ChordWordPairPosition("to");
        ChordWordPairPosition pair4 = new ChordWordPairPosition("You", "A");
        stave.add(pair);
        stave.add(pair2);
        stave.add(pair3);
        stave.add(pair4);
        song.getStaveList().add(stave);

        ArrayList<ChordWordPairPosition> stave2 = new ArrayList<>();
        ChordWordPairPosition pair5 = new ChordWordPairPosition("Happy");
        ChordWordPairPosition pair6 = new ChordWordPairPosition("Birthday");
        ChordWordPairPosition pair7 = new ChordWordPairPosition("to");
        ChordWordPairPosition pair8 = new ChordWordPairPosition("You", "D");
        stave2.add(pair5);
        stave2.add(pair6);
        stave2.add(pair7);
        stave2.add(pair8);
        song.getStaveList().add(stave2);

        ArrayList<ChordWordPairPosition> stave3 = new ArrayList<>();
        ChordWordPairPosition pair9 = new ChordWordPairPosition("Happy");
        ChordWordPairPosition pair10 = new ChordWordPairPosition("Birthday");
        ChordWordPairPosition pair11 = new ChordWordPairPosition("dear");
        ChordWordPairPosition pair12 = new ChordWordPairPosition("Elsie", "G");
        stave3.add(pair9);
        stave3.add(pair10);
        stave3.add(pair11);
        stave3.add(pair12);
        song.getStaveList().add(stave3);

        ArrayList<ChordWordPairPosition> stave4 = new ArrayList<>();
        ChordWordPairPosition pair13 = new ChordWordPairPosition("Happy", "D");
        ChordWordPairPosition pair14 = new ChordWordPairPosition("Birthday");
        ChordWordPairPosition pair15 = new ChordWordPairPosition("to", "A");
        ChordWordPairPosition pair16 = new ChordWordPairPosition("You", "D");
        stave4.add(pair13);
        stave4.add(pair14);
        stave4.add(pair15);
        stave4.add(pair16);
        song.getStaveList().add(stave4);

        //Should be D major
        //System.out.println(song);

        //Should be D# major
        song.higherKey();
        // System.out.println(song);

        //Should be B major
        song.lowerKey();
        song.lowerKey();
        song.lowerKey();
        song.lowerKey();
        // System.out.println(song);

        //songRepository.save(song);
        Optional<Song> optSong = songRepository.findById("61ae7463044c2c7ee4545e21");
        optSong.get().higherKey();
        optSong.get().higherKey();
        optSong.get().higherKey();
        System.out.println(optSong);

     */
    }
}
