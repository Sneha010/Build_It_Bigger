package com.example;

/**
 * Created by Sneha Khadatare : 587823
 * on 6/27/2016.
 */
public class Joke {

    private String jokeString;
    private int jokeId;

    public Joke(String jokeString, int jokeId) {
        this.jokeString = jokeString;
        this.jokeId = jokeId;
    }

    public String getJokeString() {
        return jokeString;
    }

    public void setJokeString(String jokeString) {
        this.jokeString = jokeString;
    }

    public int getJokeId() {
        return jokeId;
    }

    public void setJokeId(int jokeId) {
        this.jokeId = jokeId;
    }
}
