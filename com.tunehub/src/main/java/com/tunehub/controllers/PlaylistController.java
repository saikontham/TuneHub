package com.tunehub.controllers;

import com.tunehub.entities.Playlist;
import com.tunehub.entities.Songs;
import com.tunehub.services.PlaylistSerivce;
import com.tunehub.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class PlaylistController {
    @Autowired
    private SongService songService;

    @Autowired
    private PlaylistSerivce playlistSerivce;

    @GetMapping("/createplaylist")
    public String createPlaylist(Model model)
    {
        List<Songs> songsList = songService.viewallsongs();
        model.addAttribute("songs",songsList);
        return "createplaylist";
    }
    @PostMapping("/addplaylist")
    public String addPlaylist(@ModelAttribute Playlist playlist)
    {
        playlistSerivce.addPlaylist(playlist);
        List<Songs> songslist = playlist.getSongs();

        for (Songs s:songslist)
        {
            s.getPlaylist().add(playlist);
            songService.updateSong(s);
        }
        return "adminhomepage";
    }

    @GetMapping("/viewplaylist")
    public String viewPlaylist(Model model)
    {
        List<Playlist> playlists=playlistSerivce.fetchPlaylist();
        model.addAttribute("playlist",playlists);
        return "displayPlaylist";
    }

}
