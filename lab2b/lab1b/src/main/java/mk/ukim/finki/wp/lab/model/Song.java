<<<<<<< HEAD
package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Data
@Entity
public class Song {
    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;
    @ManyToMany
    private List<Artist> performers;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Album album;
    public Song(String trackId, String title, String genre, int releaseYear) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        album = null;
    }

    public Song() {

    }
}
=======
package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Getter
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackId;
    String title;
    String genre;
    Integer releaseYear;
    @ManyToMany
    private List<Artist> performers;
    @ManyToOne
    private Album album;

    public Song(String title, String genre, Integer releaseYear, Album album) {
        this.trackId = (long) (Math.random()*1000);

        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        performers = new ArrayList<>();
        this.album = album;
        //add albums maybe
    }

    public void addArtist(Artist performer){
        performers.add(performer);
    }
}
>>>>>>> 7c6648558d2896e91b6d75476646ca49db013d34
