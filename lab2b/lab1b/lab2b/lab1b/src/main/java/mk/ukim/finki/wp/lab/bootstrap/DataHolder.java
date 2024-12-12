<<<<<<< HEAD
package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Artist> artists = new ArrayList<>();
    public static List<Song> songs = new ArrayList<>();

    public static List<Album> albums = new ArrayList<>();

    @PostConstruct
    public void init(){
        artists.add(new Artist(1L, "artist1", "last1","dhgvongnv"));
        artists.add(new Artist(2L, "artist2", "last2","vnanll"));
        artists.add(new Artist(3L, "artist3", "last3","fcnfkff"));
        artists.add(new Artist(4L, "artist4", "last4","podddh"));
        artists.add(new Artist(5L, "artist5", "last5","lokdkddn"));


        albums.add(new Album("album 1", "rock", "2014"));
        albums.add(new Album("album 2", "pop", "2004"));
        albums.add(new Album("album 3", "jazz", "2010"));
        albums.add(new Album("album 4", "metal", "1980"));
        albums.add(new Album("album 5", "rock", "2002"));


        songs.add(new Song( "song1", "pop", 2018, albums.get(1)));
        songs.add(new Song( "song2", "rock", 2015, albums.get(3)));
        songs.add(new Song( "song3", "metal", 1980, albums.get(2)));
        songs.add(new Song("song4", "jazz", 2010, albums.get(0)));
        songs.add(new Song("song5", "electric", 2014, albums.get(4)));



    }
}
=======
package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Artist> artists = new ArrayList<>();
    public static List<Song> songs = new ArrayList<>();

    public static List<Album> albums = new ArrayList<>();

    @PostConstruct
    public void init(){
        artists.add(new Artist(1L, "artist1", "last1","dhgvongnv"));
        artists.add(new Artist(2L, "artist2", "last2","vnanll"));
        artists.add(new Artist(3L, "artist3", "last3","fcnfkff"));
        artists.add(new Artist(4L, "artist4", "last4","podddh"));
        artists.add(new Artist(5L, "artist5", "last5","lokdkddn"));


        albums.add(new Album("album 1", "rock", "2014"));
        albums.add(new Album("album 2", "pop", "2004"));
        albums.add(new Album("album 3", "jazz", "2010"));
        albums.add(new Album("album 4", "metal", "1980"));
        albums.add(new Album("album 5", "rock", "2002"));


        songs.add(new Song( "song1", "pop", 2018, albums.get(1)));
        songs.add(new Song( "song2", "rock", 2015, albums.get(3)));
        songs.add(new Song( "song3", "metal", 1980, albums.get(2)));
        songs.add(new Song("song4", "jazz", 2010, albums.get(0)));
        songs.add(new Song("song5", "electric", 2014, albums.get(4)));



    }
}
>>>>>>> 7c6648558d2896e91b6d75476646ca49db013d34
