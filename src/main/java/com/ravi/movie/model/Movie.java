package com.ravi.movie.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TBL_MOVIE")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @EqualsAndHashCode.Include
    private String nameOfDirector;

    @EqualsAndHashCode.Include
    private String nameOfMovie;

    private String typeOfMovie;

}
