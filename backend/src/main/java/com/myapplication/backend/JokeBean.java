package com.myapplication.backend;

/** The object model for the data we are sending through endpoints */
public class JokeBean {

    private String mJoke;
    private int mJokeId;

    public JokeBean(String joke, int jokeId) {
        mJoke = joke;
        mJokeId = jokeId;
    }

    public String getJoke() {
        return mJoke;
    }

    public void setJoke(String joke) {
        mJoke = joke;
    }

    public int getJokeId() {
        return mJokeId;
    }

    public void setJokeId(int jokeId) {
        mJokeId = jokeId;
    }
}