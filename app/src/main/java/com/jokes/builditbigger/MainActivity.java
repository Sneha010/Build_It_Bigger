package com.jokes.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {


    @Bind(R.id.main_container)
    LinearLayout mMainContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container , MainActivityFragment.newInstance())
                .commit();


    }

    public void tellJoke(View view){
        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
    }

}
