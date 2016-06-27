package com.example;

import java.util.Random;

public class TellMeJoke {

    private String[] mJokeList;
    private Random mRandom;

    public TellMeJoke() {

        mRandom = new Random();
        mJokeList = new String[3];

        mJokeList[0] = " Q : What is the object-oriented way to become wealthy?\n\n A: Inheritance";
        mJokeList[1] = " Q : What is the programmer's favorite hangout place?\n\n A : Foo Bar";
        mJokeList[2] = " Q : 0 is false and 1 is true, right?\n\n A : 1";
    }

    public Joke getJoke(){
        int jokeId = mRandom.nextInt(mJokeList.length);
        Joke joke = new Joke(mJokeList[jokeId] , jokeId);
        return joke;
    }
}
