package com.authuser.auth_project.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class MoviesController {
    
    @GetMapping("/movies")
    public List<Map<String, Object>> getMovies() {
        List<Map<String, Object>> movies = new ArrayList<>();

        Map<String, Object> m1 = new HashMap<>();
        m1.put("id", 1);
        m1.put("title", "Inception");
        m1.put("year", 2010);

        Map<String, Object> m2 = new HashMap<>();
        m2.put("id", 2);
        m2.put("title", "The Dark Knight");
        m2.put("year", 2008);

        Map<String, Object> m3 = new HashMap<>();
        m3.put("id", 3);
        m3.put("title", "Interstellar");
        m3.put("year", 2014);

        movies.add(m1);
        movies.add(m2);
        movies.add(m3);

        return movies;
    }
}
