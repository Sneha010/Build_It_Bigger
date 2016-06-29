package com.jokes.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;
import android.text.TextUtils;

import com.myapplication.backend.myJokesApi.model.JokeBean;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sneha Khadatare : 587823
 * on 6/28/2016.
 */
public class CheckForNonEmptyString extends AndroidTestCase {

    // create  a signal to let us know when our task is done.
    private CountDownLatch mSignal = null;
    private Context mContext ;

    protected void setUp() throws Exception {
        super.setUp();

        mSignal = new CountDownLatch(1);
        mContext = new MockContext();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        mSignal.countDown();
    }

    public void testJokeAsyncTask() throws Throwable{

        try {
            JokesEndpointAsyncTask myJokeAsyntask =
                    new JokesEndpointAsyncTask(mContext ,new TestJokesReceiveListener());
            myJokeAsyntask.execute();

            boolean isSuccess = mSignal.await(5 , TimeUnit.SECONDS);

            if(!isSuccess){
                fail("Could not connect to server!");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }

    class TestJokesReceiveListener implements OnJokeReceiveListener{

        @Override
        public void onJokeReceive(JokeBean joke) {

            assertFalse(TextUtils.isEmpty(joke.getJoke()));
            mSignal.countDown();
        }
    }
}
