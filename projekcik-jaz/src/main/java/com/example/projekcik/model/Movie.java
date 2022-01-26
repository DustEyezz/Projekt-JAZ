package com.example.projekcik.model;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "movie_name")
	private String movieName;

	@Column(name = "movie_type")
	private String movieType;

	@Column(name = "movie_desc")
	private String movieDesc;

	@Column(name = "movie_date")
	private String movieDate;

	public Movie() {

	}

	public Movie(long id, String movieName, String movieType, String movieDesc, String movieDate) {
		this.id = id;
		this.movieName = movieName;
		this.movieType = movieType;
		this.movieDesc = movieDesc;
		this.movieDate = movieDate;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public long getId() {
		return id;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public String getMovieDesc() {
		return movieDesc;
	}

	public String getMovieName() {
		return movieName;
	}

	public String getMovieType() {
		return movieType;
	}
}
