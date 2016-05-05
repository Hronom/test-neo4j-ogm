package com.github.hronom.test.neo4j.ogm.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Movie {

    @GraphId
    private Long id;
    private String title;
    private int released;

    @Relationship(type = "ACTS_IN", direction = "INCOMING")
    private Set<Actor> actors = new HashSet<>();

    public Movie(String title, int year) {
        this.title = title;
        this.released = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleased() {
        return released;
    }

    public void setReleased(int released) {
        this.released = released;
    }
}
