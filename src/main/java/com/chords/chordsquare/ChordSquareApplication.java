package com.chords.chordsquare;

import com.chords.chordsquare.structure.ChordWordPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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


        Song song = new Song();
        song.setName("Happy Birthday");
        ArrayList<ChordWordPair> stave = new ArrayList<>();

        ChordWordPair pair = new ChordWordPair("Happy", "D");
        ChordWordPair pair2 = new ChordWordPair("Birthday");
        ChordWordPair pair3 = new ChordWordPair("to");
        ChordWordPair pair4 = new ChordWordPair("You", "A");
        stave.add(pair);
        stave.add(pair2);
        stave.add(pair3);
        stave.add(pair4);
        song.getStaveList().add(stave);

        ArrayList<ChordWordPair> stave2 = new ArrayList<>();
        ChordWordPair pair5 = new ChordWordPair("Happy");
        ChordWordPair pair6 = new ChordWordPair("Birthday");
        ChordWordPair pair7 = new ChordWordPair("to");
        ChordWordPair pair8 = new ChordWordPair("You", "D");
        stave2.add(pair5);
        stave2.add(pair6);
        stave2.add(pair7);
        stave2.add(pair8);
        song.getStaveList().add(stave2);

        ArrayList<ChordWordPair> stave3 = new ArrayList<>();
        ChordWordPair pair9 = new ChordWordPair("Happy");
        ChordWordPair pair10 = new ChordWordPair("Birthday");
        ChordWordPair pair11 = new ChordWordPair("dear");
        ChordWordPair pair12 = new ChordWordPair("Elsie", "G");
        stave3.add(pair9);
        stave3.add(pair10);
        stave3.add(pair11);
        stave3.add(pair12);
        song.getStaveList().add(stave3);

        ArrayList<ChordWordPair> stave4 = new ArrayList<>();
        ChordWordPair pair13 = new ChordWordPair("Happy", "D");
        ChordWordPair pair14 = new ChordWordPair("Birthday");
        ChordWordPair pair15 = new ChordWordPair("to", "A");
        ChordWordPair pair16 = new ChordWordPair("You", "D");
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
    }
}
