package com.jokes.builditbigger;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.display.joke.DisplayJokeFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.myapplication.backend.myJokesApi.model.JokeBean;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment implements OnJokeReceiveListener{



    @Bind(R.id.adView)
    AdView mAdView;

    @Bind(R.id.btnJoke)
    TextView btnJoke;

    @Bind(R.id.progressBar)
    ProgressBar mProgressBar;

    @Bind(R.id.joke_container)
    LinearLayout llJokeContainer;

    public static MainActivityFragment newInstance() {
        MainActivityFragment fragment = new MainActivityFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, view);


        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("9282635A0855270B5969A49E250D2EFC")  // for nexus 9282635A0855270B5969A49E250D2EFC
                .build();                                           // for edge DFFD9AE6297B62CCBD027509843436C3
        mAdView.loadAd(adRequest);



        return view;
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btnJoke)
    public void tellJoke(View view){

        mProgressBar.setVisibility(View.VISIBLE);
        llJokeContainer.setVisibility(View.GONE);

        new JokesEndpointAsyncTask(getActivity() , this).execute();




    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onJokeReceive(JokeBean joke) {

        mProgressBar.setVisibility(View.GONE);
        llJokeContainer.setVisibility(View.VISIBLE);

        String message = null;

        if(joke !=null && joke.getJokeId() != 0){
            message = joke.getJoke();
        }else{
            message = getString(R.string.error_joke);
        }

        Fragment fragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.joke_container);

        if(fragment !=null && fragment instanceof DisplayJokeFragment){
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.joke_container , DisplayJokeFragment.newInstance(message))
                    .commit();
            btnJoke.setText("One more joke please!");
        }else{
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.joke_container , DisplayJokeFragment.newInstance(message))
                    .commit();

            btnJoke.setText("Tell another joke");
        }


    }

}
