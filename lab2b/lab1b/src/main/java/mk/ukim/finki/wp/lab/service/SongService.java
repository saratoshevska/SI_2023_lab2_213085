<<<<<<< HEAD
package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService{
    List<Song> listSongs();
    List<Song> listSongsByAlbum(Long albumId);
    void findAndAddArtistToSong(Long artistId, Long songId);
    Optional<Song> findByTrackId(String trackId);
    Optional<Song> findById(long id);
    void deleteById(long id);
    void save(Long id,String title, String trackId,String genre,int releaseYear, Long albumId);
    void removeArtistFromSong(Long songId, Long performerId);
}
=======
package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findByTrackId(Long trackId);

    public Optional<Song> save(String title, String genre, Integer releaseYear, Album album);

    void deleteById(Long id);
}
>>>>>>> 7c6648558d2896e91b6d75476646ca49db013d34
