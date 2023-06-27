package com.sternritter.lookify.controllers;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sternritter.lookify.models.Song;
import com.sternritter.lookify.services.SongService;

import jakarta.validation.Valid;

@Controller
public class SongController {
	@Autowired
	SongService songService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String showDashboard(Model model) {
		model.addAttribute("songs", songService.allSongs());
		return "dashboard.jsp";
	}
	
	@GetMapping("/songs/new")
	public String showForm(@ModelAttribute Song song) {
		return "newSong.jsp";
	}
	
	@PostMapping("/process")
	public String addSong(
			@Valid @ModelAttribute Song song, 
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "newSong.jsp";
		}
		songService.createSong(song);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/songs/{id}")
	public String showSong(
			@PathVariable long id, 
			Model model
			) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "show.jsp";
	}
	
	@GetMapping("/songs/top-ten")
	public String topSongs(Model model) {
		List<Song> topSongs = songService.allSongs();
		topSongs.sort(Comparator.comparingInt(Song::getRating).reversed());
		model.addAttribute("songs", topSongs);
		return "topSongs.jsp";
	}
	
	@PostMapping("/search")
	public String search(
			@RequestParam String artist, 
			Model model
			) {
		model.addAttribute("artist", artist);
		return "redirect:/search?artist=" + artist;
	}
	
	@GetMapping("/search")
	public String showSongsByArtist(
			@RequestParam String artist, 
			Model model
			) {
		model.addAttribute("artist", artist);
		model.addAttribute("songs", songService.findByArtist(artist));
		return "search.jsp";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSong(@PathVariable long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
}
