package com.ravi.movie.repository;

import com.ravi.movie.dto.SearchRequest;
import com.ravi.movie.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findByTypeOrAndDirector(SearchRequest searchRequest);
}
