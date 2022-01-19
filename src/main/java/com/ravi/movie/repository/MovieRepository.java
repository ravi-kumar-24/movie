package com.ravi.movie.repository;

import com.ravi.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String>, MovieService {
    @Query
    List<Movie> findByTypeOfMovie(String typeOfMovie);
    @Query
    List<Movie> findByNameOfDirector(String typeOfDirector);
    @Query
    List<Movie> findByTypeOfMovieAndNameOfDirector(String typeOfMovie, String typeOfDirector);
}
