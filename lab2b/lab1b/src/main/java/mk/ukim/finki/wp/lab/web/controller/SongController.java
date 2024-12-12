<<<<<<< HEAD
package mk.ukim.finki.wp.lab.web.controller;


import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("songs")
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error,@RequestParam(required = false) Long albumId, Model model){
        if(albumId!=null && albumId!=-1) model.addAttribute("songs",songService.listSongsByAlbum(albumId));
        else model.addAttribute("songs",songService.listSongs());
        model.addAttribute("error",error);
        model.addAttribute("albums",albumService.findAll());
        return "listSongs";
    }

    @PostMapping("/add")
    public String saveOrUpdateSong(@RequestParam(required = false) Long id,
                                   @RequestParam String title,
                                   @RequestParam String trackId,
                                   @RequestParam String genre,
                                   @RequestParam int releaseYear,
                                   @RequestParam Long albumId){

        //id = null ako pesnata e nova   14to baranjeeee
        songService.save(id,title,trackId,genre,releaseYear,albumId);
        return "redirect:/songs";
    }
    @GetMapping("/add-form")
    public String getAddSongPage(Model model){
        model.addAttribute("albums",albumService.findAll());
        return "add-song";
    }

    @GetMapping("/edit/{songId}")
    public String editSong(@PathVariable Long songId,Model model){
        Optional<Song> songToEdit = songService.findById(songId);

        if(songToEdit.isEmpty()) return "redirect:/songs?error=choose a valid song to edit";

        model.addAttribute("song",songToEdit.get());
        model.addAttribute("albums",albumService.findAll());
        return "add-song";
    }



    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id){
        songService.deleteById(id);
        return "redirect:/songs";
    }
    @PostMapping("/performers/delete/{songId}/{performerId}")
    public String deletePerformerFromSong(@PathVariable Long songId, @PathVariable Long performerId) {
        // Remove the performer from the song
        songService.removeArtistFromSong(songId, performerId);

        // Redirect back to the song edit page
        return "redirect:/songs/edit/" + songId;
    }




    @GetMapping("/details/{id}")
    public String songDetails(@PathVariable Long id,Model model){
        Song songToEdit = songService.findById(id).orElseThrow();
        model.addAttribute("song",songToEdit);
        return "songDetails";
    }
}
=======
package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.exceptions.InvalidAlbumIdException;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SongController {

    private final SongService songService;
    private final AlbumService albumService;
    private final ArtistService artistService;

    public SongController(SongService songService, AlbumService albumService, ArtistService artistService) {
        this.songService = songService;
        this.albumService = albumService;
        this.artistService = artistService;
    }

    @GetMapping("/songs")
    public String getSongsPage(@RequestParam(required = false) String error, Model model){

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }


        model.addAttribute("songs", this.songService.listSongs());
        return "listSongs";
    }

    @GetMapping("/songs/add-form")
    public String getAddSongPage(Model model){
        List<Artist> artists = this.artistService.listArtists();
        List<Album> albums = this.albumService.findAll();
        model.addAttribute("artists", artists);
        model.addAttribute("albums", albums);
        return "add-song";
    }

    @PostMapping("/songs/add")
    public String saveSong(@RequestParam(required = false) String title,
                           @RequestParam(required = false) Long trackId,
                           @RequestParam(required = false) String genre,
                           @RequestParam(required = false) Integer releaseYear,
                           @RequestParam(required = false) Long albumId){

        Album album = albumService.findById(albumId).orElseThrow(() -> new InvalidAlbumIdException(albumId));

        if(trackId == null){
            this.songService.save(title, genre, releaseYear, album);
            return "redirect:/songs";
        }

        Song song = this.songService.findByTrackId(trackId);
        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(albumService.findById(albumId).orElseThrow(() -> new InvalidAlbumIdException(albumId)));
        return "redirect:/songs";
    }

    @GetMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable Long id){
        this.songService.deleteById(id);
        return "redirect:/songs";
    }

    @GetMapping("/songs/edit-form/{id}")
    public String getEditSongForm(@PathVariable Long id, Model model){
        Song song = this.songService.findByTrackId(id);
        List<Artist> artists = this.artistService.listArtists();
        List<Album> albums = this.albumService.findAll();
        model.addAttribute("song", song);
        model.addAttribute("artists", artists);
        model.addAttribute("albums", albums);
        return "add-song";
    }

    @GetMapping("/songs/edit/{songId}")
    public String editSong(@PathVariable Long songId,
                           @RequestParam(required = false) String title,
                           @RequestParam(required = false) String genre,
                           @RequestParam(required = false) Integer releaseYear,
                           @RequestParam(required = false) Long albumId){
        Song song = this.songService.findByTrackId(songId);
        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(albumService.findById(albumId).orElseThrow(() -> new InvalidAlbumIdException(albumId)));
        return "redirect:/songs";
    }
}
>>>>>>> 7c6648558d2896e91b6d75476646ca49db013d34
