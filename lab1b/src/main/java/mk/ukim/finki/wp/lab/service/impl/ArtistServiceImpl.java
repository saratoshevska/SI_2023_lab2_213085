package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.repository.jpa.ArtistRepositoryJPA;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepositoryJPA repository;

    public ArtistServiceImpl(ArtistRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    public List<Artist> listArtists() {
        return repository.findAll();
    }

    @Override
    public Optional<Artist> ArtistFindById(Long id) {
        return repository.findById(id);
    }
}
