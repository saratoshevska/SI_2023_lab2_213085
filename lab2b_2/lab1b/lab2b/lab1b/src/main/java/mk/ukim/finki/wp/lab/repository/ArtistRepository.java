<<<<<<< HEAD
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
}
=======
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
}
>>>>>>> 7c6648558d2896e91b6d75476646ca49db013d34
