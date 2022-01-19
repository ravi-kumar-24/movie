package com.ravi.movie.utils;

import com.ravi.movie.dto.MovieResponse;
import com.ravi.movie.model.Movie;

public class MovieUtils {
    /**this will convert to Movie to MovieResponse
     *
     * @param movie
     * @return
     */
    public static MovieResponse convertToResponse(Movie movie) {
        return MovieResponse.builder()
                .id(movie.getId())
                .name(movie.getNameOfMovie())
                .type(movie.getTypeOfMovie())
                .director(movie.getNameOfDirector())
                .build();
    }
}
