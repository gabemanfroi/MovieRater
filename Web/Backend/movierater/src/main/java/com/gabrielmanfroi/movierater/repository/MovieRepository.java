package com.gabrielmanfroi.movierater.repository;

import com.gabrielmanfroi.movierater.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {


}
