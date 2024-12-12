package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> listArtists();
    void addArtist(String firstName, String lastName);
    Optional<Artist> findById(Long id);
    List<Artist> searchArtists(String searchTerm);
}