package com.example;

import java.util.Random;

public class TellMeJoke {

    private static String[] mJokeList;
    private static Random mRandom;

    static {

        mRandom = new Random();
        mJokeList = new String[3];

        mJokeList[0] = " Q : What is the object-oriented way to become wealthy?\n\n A : Inheritance";
        mJokeList[1] = " Q : What is the programmer's favorite hangout place?\n\n A : Foo Bar";
        mJokeList[2] = " Q : 0 is false and 1 is true, right?\n\n A : 1";
    }

    public static Joke getJoke(){
        int jokeId = mRandom.nextInt(mJokeList.length);
        Joke joke = new Joke(mJokeList[jokeId] , jokeId);
        return joke;
    }
}
