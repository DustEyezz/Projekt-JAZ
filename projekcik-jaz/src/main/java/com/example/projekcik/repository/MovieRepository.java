package com.example.projekcik.repository;

import com.example.projekcik.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
    List<Movie> findByMovieDate(String movieDate);
    List<Movie> findByMovieDescContaining(String movieDesc);
    List<Movie> findByMovieTypeContaining(String movieType);
    List<Movie> findByMovieNameContaining(String movieName);
}
