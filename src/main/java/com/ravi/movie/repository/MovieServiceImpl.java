package com.ravi.movie.repository;

import com.ravi.movie.dto.SearchRequest;
import com.ravi.movie.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository repository;

    @Override
    public List<Movie> findByTypeOrAndDirector(SearchRequest searchRequest) {
        if(searchRequest.getTypeOfMovie() !=null && searchRequest.getNameOfDirector()!=null){
          return   findByTypeAndDirector(searchRequest.getTypeOfMovie(),searchRequest.getNameOfDirector());
        }else if(searchRequest.getTypeOfMovie() !=null){
            return  findByTypeOfMovie(searchRequest.getTypeOfMovie());
        }else if(searchRequest.getNameOfDirector()!=null){
            return  findByDirector(searchRequest.getNameOfDirector());
        }
        return null;
    }

    private List<Movie> findByTypeAndDirector(String type, String director) {
       return repository.findByTypeOfMovieAndNameOfDirector(type, director);
    }

    private List<Movie> findByDirector(String director) {
        return repository.findByNameOfDirector(director);
    }

    private List<Movie> findByTypeOfMovie(String type) {
        return repository.findByTypeOfMovie(type);
    }


}
