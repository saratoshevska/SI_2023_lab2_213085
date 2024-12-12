package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {
    public List<Artist> findAll(){
        return DataHolder.artists;
    }
    public Optional<Artist> findById(Long id){
        return DataHolder.artists.stream().filter(a -> a.getId().equals(id)).findFirst();
    }
    public List<Artist> searchArtists(String searchTerm) {
        return artists.stream()
                .filter(artist -> artist.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                        artist.getSurname().toLowerCase().contains(searchTerm.toLowerCase()) ||
                        artist.getBio().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Artist> searchArtists(String searchTerm) {
        return artistRepository.searchArtists(searchTerm);
    }

}


