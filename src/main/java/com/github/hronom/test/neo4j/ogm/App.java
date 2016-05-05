package com.github.hronom.test.neo4j.ogm;

import com.github.hronom.test.neo4j.ogm.domain.Actor;
import com.github.hronom.test.neo4j.ogm.domain.Movie;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

public class App {
    public static void main(String[] args) {
        //Set up the Session
        SessionFactory sessionFactory = new SessionFactory("com.github.hronom.test.neo4j.ogm.domain");
        Session session = sessionFactory.openSession();

        Movie movie = new Movie("The Matrix", 1999);

        Actor keanu = new Actor("Keanu Reeves");
        keanu.actsIn(movie);

        Actor carrie = new Actor("Carrie-Ann Moss");
        carrie.actsIn(movie);

        // Persist the movie. This persists the actors as well.
        session.save(movie);

        // Load a movie
        Movie matrix = session.load(Movie.class, movie.getId());
        for (Actor actor : matrix.getActors()) {
            System.out.println("Actor: " + actor.getName());
        }
    }
}
