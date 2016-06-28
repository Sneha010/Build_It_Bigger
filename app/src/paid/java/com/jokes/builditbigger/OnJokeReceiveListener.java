package com.jokes.builditbigger;

import com.myapplication.backend.myJokesApi.model.JokeBean;

/**
 * Created by Sneha Khadatare : 587823
 * on 6/27/2016.
 */
public interface OnJokeReceiveListener {

    void onJokeReceive(JokeBean joke);

}
