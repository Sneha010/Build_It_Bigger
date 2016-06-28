package com.jokes.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.myapplication.backend.myJokesApi.MyJokesApi;
import com.myapplication.backend.myJokesApi.model.JokeBean;

import java.io.IOException;

/**
 * Created by Sneha Khadatare : 587823
 * on 6/22/2016.
 */
public class JokesEndpointAsyncTask extends AsyncTask<Void, Void, JokeBean> {
    private static MyJokesApi myApiService = null;
    private Context context;
    private OnJokeReceiveListener mOnJokeReceiveListener;

    public JokesEndpointAsyncTask(Context context , OnJokeReceiveListener jokeReceiveListener) {
        this.context = context;
        mOnJokeReceiveListener = jokeReceiveListener;
    }

    @Override
    protected JokeBean doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
           /* MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.152.19.23:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });*/
            // end options for devappserver

            MyJokesApi.Builder builder = new MyJokesApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://gcetry.appspot.com/_ah/api/");

            myApiService = builder.build();
        }


        try {
            return myApiService.fetchJoke().execute();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(final JokeBean result) {

        mOnJokeReceiveListener.onJokeReceive(result);

    }
}