<<<<<<< HEAD
package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService{
    List<Artist> listArtists();
    Optional<Artist> ArtistFindById(Long id);
}
=======
package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> listArtists();
    Optional<Artist> findById(Long id);
}
>>>>>>> 7c6648558d2896e91b6d75476646ca49db013d34
