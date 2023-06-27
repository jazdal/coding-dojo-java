/**
 * 
 */
package com.sternritter.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sternritter.lookify.models.Song;

public interface SongRepository extends CrudRepository<Song, Long> {
	// This method retrieves all the songs from the database
	public List<Song> findAll();
	
	// This method finds songs by artist name in the search string:
	public List<Song> findByArtistContaining(String artist);
}