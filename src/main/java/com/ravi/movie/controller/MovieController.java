package com.ravi.movie.controller;

import com.ravi.movie.dto.MovieResponse;
import com.ravi.movie.dto.SearchRequest;
import com.ravi.movie.model.Movie;
import com.ravi.movie.repository.MovieRepository;
import com.ravi.movie.utils.MovieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rest/")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;
    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int PAGE_SIZE = 5;

    //Get the paginated data
    //http://localhost:8080/api/rest/

    /**
     * Get all movies data, with pagination
     * @param pageNumber
     * @return
     */
    @GetMapping
    public List<MovieResponse> getAllMovies(@RequestParam("page") Optional<Integer> pageNumber){
        PageRequest page = PageRequest.of(pageNumber.orElse(DEFAULT_PAGE_NUMBER), PAGE_SIZE);

        return movieRepository.findAll(page).stream()
                .map(MovieUtils::convertToResponse)
                .collect(Collectors.toList());
    }

    //http://localhost:8080/api/rest/search?typeOfMovie=Comdey&nameOfDirector=Shoojit%20Sircar
    //http://localhost:8080/api/rest/search?typeOfMovie=Comdey
    //http://localhost:8080/api/rest/search?nameOfDirector=Shoojit%20Sircar


    /**
     * It will take multiple parameter from search
     * @param search
     * @return
     */
    @GetMapping(value = "/search")
    public List<MovieResponse> handleSearchRequest(SearchRequest search) {
        return movieRepository.findByTypeOrAndDirector(search).stream()
                .map(MovieUtils::convertToResponse)
                .collect(Collectors.toList());
    }

}
