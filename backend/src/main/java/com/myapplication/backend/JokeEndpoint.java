/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.myapplication.backend;

import com.example.TellMeJoke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
  name = "myJokesApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.com",
    ownerName = "backend.myapplication.com",
    packagePath=""
  )
)
public class JokeEndpoint {

    /** A simple endpoint method that takes a fetch joke from java library */
    @ApiMethod(name = "fetchJoke")
    public JokeBean fetchJoke() {
        JokeBean response = new JokeBean();
        response.setJoke(new TellMeJoke().getJoke());
        return response;
    }

}
