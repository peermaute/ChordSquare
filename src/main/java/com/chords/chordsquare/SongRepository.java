package com.chords.chordsquare;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface SongRepository extends MongoRepository<Song, String> {
    ArrayList<Song> findByName(String name);
    Optional<Song> findById(String id);
}
