<<<<<<< HEAD
package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }


    @GetMapping("/add-to-song")
    public String chooseArtistForSong(@RequestParam Long songId, Model model){
        List<Artist> artists = artistService.listArtists();
        model.addAttribute("artists",artists);
        model.addAttribute("songId",songId);
        return "artistsList";
    }

    @PostMapping("/add-to-song")
    public String chooseArtistForSong(@RequestParam Long songId, @RequestParam Long artistId) {

        songService.findAndAddArtistToSong(artistId, songId);
        return "redirect:/songs/details/" + songId;
    }

}
=======
package mk.ukim.finki.wp.lab.web.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ArtistController {
}
>>>>>>> 7c6648558d2896e91b6d75476646ca49db013d34
