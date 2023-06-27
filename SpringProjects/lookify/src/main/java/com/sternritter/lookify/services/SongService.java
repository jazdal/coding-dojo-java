package com.sternritter.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sternritter.lookify.models.Song;
import com.sternritter.lookify.repositories.SongRepository;

@Service
public class SongService {
	// Adds the SongRepository as a dependency:
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	// Returns all songs (READ):
	public List<Song> allSongs() {
		return songRepository.findAll();
	}
	
	// Creates a song (CREATE):
	public Song createSong(Song song) {
		return songRepository.save(song);
	}
	
	// Retrieves a song by ID (READ):
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	// Retrieves all songs by a certain artist (READ):
	public List<Song> findByArtist(String artist) {
		return songRepository.findByArtistContaining(artist);
	}
	
	// Updates a song (UPDATE):
	public Song updateSong(Song song) {
		return songRepository.save(song);
	}
	
	// Deletes a song (DELETE):
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
}
