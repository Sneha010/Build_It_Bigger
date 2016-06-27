package com.display.joke;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Sneha Khadatare : 587823
 * on 6/27/2016.
 */
public class DisplayJokeFragment extends Fragment {

    public static final String JOKE = "JOKE";


    public static DisplayJokeFragment newInstance(String jokeString) {
        DisplayJokeFragment fragment = new DisplayJokeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(JOKE , jokeString);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_joke, container, false);

        ((TextView) view.findViewById(R.id.tvJoke)).setText(getArguments().getString(JOKE));

        return view;
    }
}
