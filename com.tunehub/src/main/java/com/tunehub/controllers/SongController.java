package com.tunehub.controllers;

import com.tunehub.entities.Songs;
import com.tunehub.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    private SongService songService;


    //ADDING A SONG BUT INTIALLY CHECKING THE WHETHER THE SONG WITH SAME IS EXISTS OR NOT IF EXISTS RETURN Song already existed ELSE Song aDDED SUCCESSFULLY THEN RETURN TO THE ADMINPAGE

    /**1. Handle the request to add a song when the "/addsong" endpoint is accessed.
     * 2.    // Check if the song with the given name and artist does not already exist.
     * 3.        // If the song does not exist, add it to the database.
     * 4.    // Return the view name "adminhomepage".
     *
     */


    @PostMapping("/addsong")
    public String addSong(@ModelAttribute Songs songs) {
        // Check if the song with the given name and artist doesn't exist
        if (!songService.songExists(songs.getName(), songs.getArtist())) {
            // If not, add the song
            songService.addSong(songs);
            System.out.println("Song added successfully");
        } else {
            System.out.println("Song already exists");
        }
        // Return the view name for redirection

        return "adminhomepage";
    }


    //TO DISPLAY ALL THE SONGS IN THE DATABASE IN THE VIEWALLSONGS.HTML
    // Map this method to handle GET requests for "/viewallsongs"

    @GetMapping("/viewallsongs")
    public String viewallsongs(Model model)
    {
        // Retrieve a list of all songs from the service
        List<Songs> songsList= songService.viewallsongs();
        // Add the songs list to the model, making it accessible in the view

        model.addAttribute("songs",songsList);


        // Return the view name "viewallsongs"
        return "displaysongs";
    }

    @GetMapping("/playsongs")
    public String playsongs(Model model)
    {
        boolean premiumuser=false;
        if (premiumuser) {
            List<Songs> songsList = songService.playsongs();
            model.addAttribute("songs",songsList);
            return "displaysongs";
        }
        else {
        return "makepayment";
    }
    }
}
