package com.example.projekcik.controller;

import com.example.projekcik.model.Movie;
import com.example.projekcik.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;


@Controller
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	@GetMapping()
	public String getAllMovies(Model model){
		model.addAttribute("movies", movieRepository.findAll());
		return "index";
	}

	@GetMapping("/add")
	public String showAddForm(Model model){
		model.addAttribute("movie", new Movie());
		return "addForm";
	}

	@PostMapping("/add")
	public String submitForm(@ModelAttribute Movie newMovie, Model model) {
		movieRepository.save(newMovie);

		model.addAttribute("movie", new Movie());

		return "addForm";
	}

/*
	@GetMapping("/movies/id/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("movie does not exist with id :" + id));
		return ResponseEntity.ok(movie);
	}

	@GetMapping("/movies/movieDesc/{movieDesc}")
	public ResponseEntity<List<Movie>> getMovieByMovieDesc(@PathVariable String movieDesc) {
		List<Movie> movie = movieRepository.findByMovieDescContaining(movieDesc);
		return ResponseEntity.ok(movie);
	}

	@GetMapping("/movies/movieName/{movieName}")
	public ResponseEntity<List<Movie>> getMovieByMovieName(@PathVariable String movieName) {
		List<Movie> movie = movieRepository.findByMovieNameContaining(movieName);
		return ResponseEntity.ok(movie);
	}

	@GetMapping("/movies/movieType/{movieType}")
	public ResponseEntity<List<Movie>> getMovieByMovieType(@PathVariable String movieType) {
		List<Movie> movie = movieRepository.findByMovieTypeContaining(movieType);
		return ResponseEntity.ok(movie);
	}

	@GetMapping("/movies/movieDate/{movieDate}")
	public ResponseEntity<List<Movie>> getMovieByMovieDate(@PathVariable String movieDate) {
		List<Movie> movie = movieRepository.findByMovieDate(movieDate);
		return ResponseEntity.ok(movie);
	}
	
	@PutMapping("/movies/update/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails){
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("movie does not exist with id :" + id));
		
		movie.setMovieName(movieDetails.getMovieName());
		movie.setMovieDesc(movieDetails.getMovieDesc());
		movie.setMovieType(movieDetails.getMovieType());
		movie.setMovieDate(movieDetails.getMovieDate());
		
		Movie updatedMovie = movieRepository.save(movie);
		return ResponseEntity.ok(updatedMovie);
	}

	@DeleteMapping("/movies/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMovie(@PathVariable Long id){
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("movie not exist with id :" + id));
		
		movieRepository.delete(movie);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	*/
}
